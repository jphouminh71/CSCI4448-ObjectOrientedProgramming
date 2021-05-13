package com.bigbank.Subscriptions.Entertainment;
import com.bigbank.Subscriptions.*;


/* Decorates Subscription as a Bill */
public class Hulu extends Subscription {
    Subscription sub; 
    
    public Hulu(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " ENTR HULU";
    }
}