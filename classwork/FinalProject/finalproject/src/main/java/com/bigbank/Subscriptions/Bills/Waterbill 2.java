package com.bigbank.Subscriptions.Bills;
import com.bigbank.Subscriptions.*;

/* Decorates Subscription as a Bill */
public class Waterbill extends Subscription {
    Subscription sub; 
    
    public Waterbill(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " BILL WATR"; 
    }
}