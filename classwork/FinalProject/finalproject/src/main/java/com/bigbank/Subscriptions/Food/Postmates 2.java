package com.bigbank.Subscriptions.Food;
import com.bigbank.Subscriptions.*;

public class Postmates extends Subscription {
    Subscription sub; 
    
    public Postmates (Subscription s) {
        this.sub = s; 
    }

    public String getName() {
        return this.sub.getName() + " FOOD PSMT";
    }
    
}