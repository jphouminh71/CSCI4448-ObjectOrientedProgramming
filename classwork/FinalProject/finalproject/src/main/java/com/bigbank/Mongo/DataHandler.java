package com.bigbank.Mongo;
import com.bigbank.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.function.Consumer;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;




/*  PATTERNS USED 
    - Singleton for an object that serves purely to interact with MongoDB, shouldn't 
    ever need to have more than one running instance 
*/
public class DataHandler {

    /* Init MongoDB client */
    MongoClient mongoClient;
    MongoCollection<Document> collection;

    /* Singleton Constructor */
    private static DataHandler dh = new DataHandler();
    private DataHandler() {((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("org.mongodb.driver").setLevel(Level.ERROR); } // silence warnings 
    public static DataHandler getInstance() { return dh; }

    /* Connects to the database */
    public void connectToDB(){
        MongoClientURI uri = new MongoClientURI(K.Mongo.MongoClientURL);
        mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase(K.Mongo.dbName);
        collection = database.getCollection(K.Mongo.collName);
    }

    /* End Client Session */
    public void endSession() {
        mongoClient.close();
    }

    /* Employee calls to init account */
    public void addDocument(String name, String password, String type) {
        try {
            /* init default values */
            Double initialAmount = 0.0;
            ArrayList<String> transactions = new ArrayList<String>();
            ArrayList<Double> transactionAmount = new ArrayList<Double>();
            ArrayList<String> transactionDate = new ArrayList<String>();
            ArrayList<String> subscriptions = new ArrayList<String>();
            ArrayList<Double> rates = new ArrayList<Double>();
            ArrayList<Integer> recurringRates = new ArrayList<Integer>();
            

            // init default array values here

            /* query out id for the next user to be added */
            Document query = new Document(K.Mongo.id, new ObjectId(K.Mongo.UserCount));
            Document result = collection.find(query).iterator().next();
            int nextID = result.getInteger(K.Mongo.UUID,0);

            /* Send document */
            Document document = new Document("_id", nextID)
            .append(K.Mongo.name, name)
            .append(K.Mongo.pwd, password)
            .append(K.Mongo.bal, initialAmount)
            .append(K.Mongo.UserType, type)
            .append(K.Mongo.trans, transactions)
            .append(K.Mongo.transAmount, transactionAmount)
            .append(K.Mongo.transdate, transactionDate)
            .append(K.Mongo.subs, subscriptions)
            .append(K.Mongo.subsCosts, rates)
            .append(K.Mongo.recRate, recurringRates);
            ;
            collection.insertOne(document);
            collection.updateOne(Filters.eq(K.Mongo.id, new ObjectId(K.Mongo.UserCount)), new Document("$set", new Document(K.Mongo.UUID, nextID+1)));

        } catch (MongoWriteException e) {
            System.out.println("INSERTION ERROR: " + e);
        }
    }

    /* Deletes user from system via customerID */
    public void deleteDocument(int customerID) {
        try {
            // delete the person
            collection.deleteOne(Filters.eq(K.Mongo.id, customerID));

            // update the unique identifier
            Document query = new Document(K.Mongo.id, new ObjectId(K.Mongo.UserCount));
            Document result = collection.find(query).iterator().next();
            int currentId = result.getInteger(K.Mongo.UUID,0);

            collection.updateOne(Filters.eq(K.Mongo.id, new ObjectId(K.Mongo.UserCount)), new Document("$set", new Document(K.Mongo.UUID, currentId-1)));
        } catch (MongoWriteException e) {
            System.out.println("DELETION ERROR: " + e);
        }
    }

    /* Updates document for a user */
    public < E > void updateDocument(int customerID, String key, E value) {
        System.out.println(">>>>>: " + key);
        try {
            switch(value.getClass().getSimpleName()){

                /* Update UUID */
                case "Integer":{
                    if (key == K.Mongo.UUID){
                        int v = (int)value;
                        collection.updateOne(Filters.eq(key, customerID), new Document("$set", new Document(key, v)));
                    }
                    break;
                }   

                /* updates their username, transaction array, transaction date */
                case "String":{
                    String v = (String)value;

                    /* Updates user password */
                    if (key == K.Mongo.name || key == K.Mongo.pwd){
                        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
                        if (found != null) {
                            Bson updatedValue = new Document(key, v);
                            Bson updateOperation = new Document("$set", updatedValue);
                            collection.updateOne(found, updateOperation);
                        }
                    }

                    /* Updates transaction array */
                    else if (key == K.Mongo.trans){
                        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
                        if (found != null){
                            collection.findOneAndUpdate(Filters.eq(K.Mongo.id, customerID), Updates.push(K.Mongo.trans, value.toString()));
                        }
                    }

                    /* Updates transaction date array */
                    else if (key == K.Mongo.transdate) {
                        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
                        if (found != null){
                            collection.findOneAndUpdate(Filters.eq(K.Mongo.id, customerID), Updates.push(K.Mongo.transdate, value.toString()));
                        }
                    }

                    /* Updates their subscription array */
                    else if (key == K.Mongo.subs) {
                        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
                        if (found != null){
                            collection.findOneAndUpdate(Filters.eq(K.Mongo.id, customerID), Updates.push(K.Mongo.subs, value.toString()));
                        }
                    }
                    break;
                }

                /* Update balance or transaction amounts*/
                case "Double":{
                    /* Updates their current balance */
                    if (key == K.Mongo.bal){
                        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
                        if (found != null) {
                            Bson updatedValue = new Document(key, (double)value);
                            Bson updateOperation = new Document("$set", updatedValue);
                            collection.updateOne(found, updateOperation);
                        }
                    } 

                    /* Updates their transaction amount array */
                    else if (key == K.Mongo.transAmount) {
                        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
                        if (found != null) {
                            collection.findOneAndUpdate(Filters.eq(K.Mongo.id, customerID), Updates.push(K.Mongo.transAmount, (Double)value));
                        }
                    }

                    else if (key == K.Mongo.recRate) {
                        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
                        if (found != null) {
                            collection.findOneAndUpdate(Filters.eq(K.Mongo.id, customerID), Updates.push(K.Mongo.recRate, (Double)value));
                        }
                    }
                    
                    /* Updates their subscription rates array */
                    else if (key == K.Mongo.subsCosts) {
                        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
                        if (found != null) {
                            collection.findOneAndUpdate(Filters.eq(K.Mongo.id, customerID), Updates.push(K.Mongo.subsCosts, (Double)value));
                        }
                    }
                    break;
                }
                default:
                  System.out.println("Could not identify the type of value to be updated");
              }
        } catch (MongoWriteException e ) {
            System.out.println("UPDATE ERROR: " + e);
        }
    }


    /* Retrieves the users document of information returns JSON string */
    public String fetch(int customerID) {
        Document found = (Document) collection.find(new Document(K.Mongo.id, customerID)).first();
        if (found == null) {
            System.out.println("USER " + customerID + " NOT FOUND.");
            return null;
        }
        return found.toJson();
    }
} 