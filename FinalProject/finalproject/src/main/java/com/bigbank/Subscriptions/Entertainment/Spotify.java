package com.bigbank.Subscriptions.Entertainment;
import com.bigbank.Subscriptions.*;


/* Decorates Subscription as a Bill */
public class Spotify extends Subscription {
    Subscription sub; 
    
    public Spotify(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " ENTR SPFY";
    }

    
}