package com.bigbank.Subscriptions.Entertainment;
import com.bigbank.Subscriptions.*;

/* Decorates Subscription as a Bill */
public class Netflix extends Subscription {
    Subscription sub; 
    
    public Netflix(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " ENTR NFLX";
    }

    
}