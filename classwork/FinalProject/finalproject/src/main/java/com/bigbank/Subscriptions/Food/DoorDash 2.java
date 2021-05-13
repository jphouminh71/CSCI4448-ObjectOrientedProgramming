package com.bigbank.Subscriptions.Food;
import com.bigbank.Subscriptions.*;


/* Decorates Subscription as a Bill */
public class DoorDash extends Subscription {
    Subscription sub; 
    
    public DoorDash (Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " FOOD DRDH";
    }

    
}