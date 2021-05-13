package com.bigbank.Users;
import java.util.ArrayList;
import java.util.HashMap;

import com.bigbank.K;
import com.bigbank.Mongo.DataHandler;
import com.bigbank.Subscriptions.BasicSubscription;
import com.bigbank.Subscriptions.Bills.AccountFeeBill;
import com.bigbank.Subscriptions.Bills.ElectricBill;
import com.bigbank.Subscriptions.Bills.HomeInsuranceBill;
import com.bigbank.Subscriptions.Bills.MortageBill;
import com.bigbank.Subscriptions.Bills.Waterbill;
import com.bigbank.Subscriptions.Entertainment.HBO;
import com.bigbank.Subscriptions.Entertainment.Hulu;
import com.bigbank.Subscriptions.Entertainment.Netflix;
import com.bigbank.Subscriptions.Entertainment.Spotify;
import com.bigbank.Subscriptions.Food.DoorDash;
import com.bigbank.Subscriptions.Food.Groceries;
import com.bigbank.Subscriptions.Food.Postmates;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import org.json.*;

/* PATTERNS USED
    * Observer
        - made the notification observe an instance of a customer in the event such as an account 
        overdraft

    * Decorator
        - upon entering new subscriptions, our pre-defined subcriptions will decorate the name 
        of the subscription witha specific label (see subcriptions directory)
*/
public class Customer extends User{

    private PropertyChangeSupport pcs;
    Double Balance; 
    HashMap <String, Integer> Transactions;  // load when you want to look at all the transactions? 


    /* Constructor */
    public Customer(String info, DataHandler db) {
        super(info, db);

        /* Make the Notification Center observe the customer */
        pcs = new PropertyChangeSupport(this);
    }

    /* Function will check all the customers current subscriptions and adjust balance accordingly */
    /* This function should get called upon sign out */
    public void checkForRecurringPayments() {
        String info = this.getInformation();
        DataHandler db = this.getdb();
        try {
            JSONObject obj = new JSONObject(info);
            int id = obj.getInt(K.Mongo.id);
            JSONArray subs = obj.getJSONArray(K.Mongo.subs);
            JSONArray subcosts = obj.getJSONArray(K.Mongo.subsCosts);

            /* Add a transaction if the date matches today */
            /* Update their current balance */
            /* not implemented yet */

        } catch (JSONException e) {
            System.out.println("INVALID LOGIN: " + e);
        }
    }
    
    /* Add a recurring subscription for that user */
    /* these inputs would normally be recieved through a button */
    public void addSubscription(String sub, String type,  double amount, int duration){
        System.out.println("IN ADD SUBSCRIPTION");
        DataHandler db = getdb();
        BasicSubscription new_subscription = new BasicSubscription(sub, amount, duration);

        /* Case match against the type and decorate if applicable */
        System.out.println(sub);
        System.out.println(type);
        switch (type) {
            case "Entertainment":
                switch (sub) {
                    case "HULU":
                        Hulu huluSub = new Hulu(new_subscription);

                        // 0 is in place for the customerid but didn't have time to 
                        // properly store the current customers id so we hardcoded it in to make all updates 
                        // to "jonathan phouminh" in the db
                        System.out.println(">>" + huluSub.getName());
                        db.updateDocument(1, K.Mongo.subs, huluSub.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, huluSub.getprice());
                        db.updateDocument(1, K.Mongo.recRate, huluSub.getRecurringRate());                  
                        
                        return;
                    case "HBO":
                        HBO hboSub = new HBO(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, hboSub.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, hboSub.getprice());
                        db.updateDocument(1, K.Mongo.recRate, hboSub.getRecurringRate());      
                        return;
                    
                    case "NETFLIX":
                        Netflix netflixSub = new Netflix(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, netflixSub.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, netflixSub.getprice());
                        db.updateDocument(1, K.Mongo.recRate, netflixSub.getRecurringRate());    
                        
                        return;
                    
                    case "SPOTIFY":
                        Spotify spot_sub = new Spotify(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, spot_sub.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, spot_sub.getprice());
                        db.updateDocument(1, K.Mongo.recRate, spot_sub.getRecurringRate());    

                        return;
                    default:
                        break;
                }
                break;
            
            case "Bill":
                switch (sub){
                    case "ACCOUNT":
                        AccountFeeBill ACC = new AccountFeeBill(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, ACC.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, ACC.getprice());
                        db.updateDocument(1, K.Mongo.recRate, ACC.getRecurringRate());    
                        return;

                    case "ELECTRIC":
                        ElectricBill EC = new ElectricBill(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, EC.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, EC.getprice());
                        db.updateDocument(1, K.Mongo.recRate, EC.getRecurringRate());    
                        return;

                    case "HOMEINSUR":
                        HomeInsuranceBill HIB = new HomeInsuranceBill(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, HIB.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, HIB.getprice());
                        db.updateDocument(1, K.Mongo.recRate, HIB.getRecurringRate());  
                        return;

                    case "MORTAGE":
                        MortageBill MB = new MortageBill(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, MB.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, MB.getprice());
                        db.updateDocument(1, K.Mongo.recRate, MB.getRecurringRate());  
                        return;

                    case "WATER":
                        Waterbill WB = new Waterbill(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, WB.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, WB.getprice());
                        db.updateDocument(1, K.Mongo.recRate, WB.getRecurringRate());  
                        return;

                    default:
                        break;
                }
                break;
            
            case "Food":
                switch (sub) {
                    case "DOORDASH":
                        DoorDash dd = new DoorDash(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, dd.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, dd.getprice());
                        db.updateDocument(1, K.Mongo.recRate, dd.getRecurringRate());  
                        return;
                    
                    case "GROCERIES":
                        Groceries groceries = new Groceries(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, groceries.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, groceries.getprice());
                        db.updateDocument(1, K.Mongo.recRate, groceries.getRecurringRate());  
                        return;

                    case "POSTMATES":
                        Postmates pst = new Postmates(new_subscription);

                        db.updateDocument(1, K.Mongo.subs, pst.getName());       
                        db.updateDocument(1, K.Mongo.subsCosts, pst.getprice());
                        db.updateDocument(1, K.Mongo.recRate, pst.getRecurringRate());  
                        return;
                    default:
                        break;
                }
                break;
            
            default:
                break;
        }
        db.updateDocument(1, K.Mongo.subs, new_subscription.getName());       
        db.updateDocument(1, K.Mongo.subsCosts, new_subscription.getprice());
        db.updateDocument(1, K.Mongo.recRate, new_subscription.getRecurringRate());  
    }

    /* Add a new transaction for that customer */
    public void addTransaction(String transName, double Amount){
        String info = this.getInformation();
        DataHandler db = this.getdb();
        try {
            JSONObject obj = new JSONObject(info);
            int id = obj.getInt(K.Mongo.id);
            double bal = obj.getDouble(K.Mongo.bal);
            if (Amount > bal) {
                // fire pcs if overdraft was detected 
                pcs.firePropertyChange("overdraft", bal, bal-Amount); 
            }
            /* Adds entry to the table , default date is just 11/11/1111 */
            db.updateDocument(id, K.Mongo.trans, transName);
            db.updateDocument(id, K.Mongo.transAmount, Amount);
            db.updateDocument(id, K.Mongo.transdate, "11/11/1111");

            /* update the balance */
            db.updateDocument(id, K.Mongo.bal, bal-Amount);
        } catch (JSONException e) {
            System.out.println("INVALID LOGIN: " + e);
        }
    }

    /* User and all of their information will be removed from the system */
    public void deleteAccount(){
        /* grab account number for that customer */
        String info = this.getInformation();
        DataHandler db = this.getdb();

        try {
            JSONObject obj = new JSONObject(info);
            int id = obj.getInt(K.Mongo.id);
            int customerID = id;
        db.deleteDocument(customerID);
        } catch (JSONException e) {
            System.out.println("INVALID LOGIN: " + e);
        }
    }

    /* display all the current transactions for that customer */
    public void displayInformation(){
        /* grabbing the account transaction information  */ 
        String info = this.getInformation();
        DataHandler db = this.getdb();

        try {
            JSONObject obj = new JSONObject(info);
            JSONArray transactions = obj.getJSONArray(K.Mongo.trans);
            JSONArray amounts = obj.getJSONArray(K.Mongo.transAmount);
            JSONArray dates = obj.getJSONArray(K.Mongo.transdate);
            JSONArray subs = obj.getJSONArray(K.Mongo.subs);
            JSONArray subcosts = obj.getJSONArray(K.Mongo.subsCosts);
            JSONArray subrates = obj.getJSONArray(K.Mongo.recRate);

            /* printing out a list of their transactions */
            System.out.println("TRANSACTIONS");
            System.out.println("-------");
            System.out.println(transactions);
            System.out.println(amounts);
            System.out.println(dates);
            System.out.println("Balance: " + obj.getDouble(K.Mongo.bal));
            System.out.println("SUBSCRIPTION INFORMATION");
            System.out.println("-------");
            System.out.println(subs);
            System.out.println(subcosts);
            System.out.println(subrates);
            
        
        } catch (JSONException e) {
            System.out.println("INVALID LOGIN: " + e);
        }
    }

    /* Observable Methods */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

}
