package com.bigbank.Users;

import com.bigbank.Mongo.DataHandler;


public abstract class User {

    private String information;     /* JSON representation of the current users information  */
    private DataHandler db;

    User(String info, DataHandler db) {
        this.information = info;
        this.db = db;
    }

    public String getInformation(){
        return this.information;
    }

    public DataHandler getdb() {
        return this.db;
    }

     // return to the user log in page.
     public void signOut(){
        System.out.println("Signing off!");
    }
}
