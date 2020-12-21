package com.bigbank.Subscriptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

/* Abstract factory that defines Basic Subscriptions */
public abstract class Subscription {

    /* basic subscription attributes */
    public String name; 
    private double price; 
    private String dateSubscribed; 
    private double MonthlyRecurringRate;  

    /* Getter / Setter */
    public abstract String getName();

    public double getprice() {
        return this.price;
    }

    public String getDateSubscribed() {
        return this.dateSubscribed;
    }

    public double getRecurringRate() {
        return this.MonthlyRecurringRate;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setPrice(double p) {
        this.price = p; 
    }

    public void setRecurringRate(int r) {
        this.MonthlyRecurringRate = r;
    }


    /* This doesn't get used anywhere at this stage in the project */
    public void setDateSubscribed() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = date.format(formatter);

        this.dateSubscribed = formattedDate;
    }
}
