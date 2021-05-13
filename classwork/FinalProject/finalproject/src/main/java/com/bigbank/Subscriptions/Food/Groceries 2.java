package com.bigbank.Subscriptions.Food;
import com.bigbank.Subscriptions.*;


/* Decorates Subscription as a Bill */
public class Groceries extends Subscription {
    Subscription sub; 
    
    public Groceries(Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " FOOD GRCY";
    }
    
}