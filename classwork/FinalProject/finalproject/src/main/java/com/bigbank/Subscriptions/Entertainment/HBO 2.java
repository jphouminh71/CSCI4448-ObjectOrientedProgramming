package com.bigbank.Subscriptions.Entertainment;
import com.bigbank.Subscriptions.*;


/* Decorates Subscription as a Bill */
public class HBO extends Subscription {
    Subscription sub; 
    
    public HBO(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " ENTR HBO";
    }

    
}