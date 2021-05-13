package com.bigbank.Subscriptions;

/* These are uncategorized Subscriptions that we don't currently know about */
public class BasicSubscription extends Subscription {

    public BasicSubscription(String name, Double price, int recurringrate) {
        setName(name);
        setPrice(price);
        setRecurringRate(recurringrate);  
        setDateSubscribed();
    }

    public String getName() {
        return this.name;
    }

}