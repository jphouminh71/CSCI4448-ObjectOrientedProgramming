package com.bigbank.Users;

import com.bigbank.Mongo.DataHandler;
import com.bigbank.K;
import org.json.*;

public class Employee extends User{

    public Employee(String info, DataHandler db) {
        super(info, db);
    }

    /* 
        Query out all of the customers transaction inforation just printing it out to the command line 
    */
    public void SearchCustomers(int customerID){
        DataHandler db = this.getdb();
        String cust = db.fetch(customerID);
        try {
            JSONObject obj = new JSONObject(cust);
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
            System.out.print("JSON ERROR: " + e);
        }
    }

    /* 
        Go into the db and add the default parameters apart from their name and password
    */
    public void AddCustomers(String customerName, String password) {
        DataHandler db = this.getdb();
        db.addDocument(customerName, password, "customer");           // adding a customer to the db
    }

    /* 
        Query into the db and drop that customer by customerid
    */
    public void RemoveCustomers(int customerID){
        DataHandler db = this.getdb();
        db.deleteDocument(customerID);
    }
}
