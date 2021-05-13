package com.bigbank.Subscriptions.Bills;
import com.bigbank.Subscriptions.*;


/* Decorates Subscription as a Bill */
public class AccountFeeBill extends Subscription {
    Subscription sub; 
    
    public AccountFeeBill(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " BILL ACC"; // "Bill: Account"
    }
}