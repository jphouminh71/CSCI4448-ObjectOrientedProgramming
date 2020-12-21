package com.bigbank.Subscriptions.Bills;
import com.bigbank.Subscriptions.*;


/* Decorates Subscription as a Bill */
public class MortageBill extends Subscription {
    Subscription sub; 
    
    public MortageBill(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " BILL MORT"; 
    }
}