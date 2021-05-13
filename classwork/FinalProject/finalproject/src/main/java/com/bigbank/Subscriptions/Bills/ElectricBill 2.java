package com.bigbank.Subscriptions.Bills;
import com.bigbank.Subscriptions.*;

/* Decorates Subscription as a Bill */
public class ElectricBill extends Subscription {
    Subscription sub; 
    
    public ElectricBill(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " BILL ELEC"; 
    }
}