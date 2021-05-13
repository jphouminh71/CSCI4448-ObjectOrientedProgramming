package com.bigbank;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class NotificationCenter implements PropertyChangeListener{
    public NotificationCenter(){
        
    }

    // Observing a customer 
    public void propertyChange(PropertyChangeEvent evt) {
        String event = evt.getNewValue().toString();
        /* System will log out all of the events to the terminal */
        switch (event) {
            case "overdraft":
                System.out.println("You overdrafted!!! ");
                break;
            default:
                System.out.println("NOTIFICATION RECIEVED: " + event);
                break;
        }
        
    }
}