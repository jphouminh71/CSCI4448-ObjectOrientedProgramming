package com.bigbank.Subscriptions.Bills;
import com.bigbank.Subscriptions.*;

/* Decorates Subscription as a Bill */
public class HomeInsuranceBill extends Subscription {
    Subscription sub; 
    
    public HomeInsuranceBill(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " BILL HINS"; 
    }
}