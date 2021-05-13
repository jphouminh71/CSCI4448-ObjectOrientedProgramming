package com.bigbank;

public class K {    

    /* Constants used for MongoDB */
    public static class Mongo {
        public static String id = "_id";       // unique id
        public static String name = "name";   
        public static String pwd = "password";
        public static String bal = "balance";
        public static String trans = "transactions";   // array of transactions, they are in string format
        public static String transdate = "transactionDate";    // array of dates, they are in string format 
        public static String transAmount = "transactionAmount";
        public static String subs = "subscriptions";
        public static String subsCosts = "rates";
        public static String recRate = "recurringRates";
        public static String dbName = "bb-members";
        public static String collName = "bb-collection";
        public static String MongoClientURL = "mongodb+srv://jonathan:phouminh@members.gkemk.mongodb.net/Members?retryWrites=true&w=majority"; 
        public static String UserCount = "5fb42af7ff316a50c4f2243d";
        public static String UUID = "UUID";
        public static String UserType = "usertype";
    }
}
