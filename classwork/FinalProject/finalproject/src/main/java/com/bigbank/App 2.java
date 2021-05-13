package com.bigbank;
import java.util.ArrayList;

import com.bigbank.Subscriptions.*;
import com.bigbank.Subscriptions.Bills.*;
import com.bigbank.Users.Customer;
import com.bigbank.Users.Employee;
import com.bigbank.Mongo.*;

import org.json.*;
import java.util.Scanner;

/*
    This class is where we handle small simulation of how the backend works in our program
*/
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        DataHandler db = DataHandler.getInstance();
        db.connectToDB();

        /* Enter the user inputs from here, just customerid for now */
        /* SWITCH BETWEEN CUSTOMER AND EMPLOYEE HERE */
        int customerID = 0;     // 1 = customer account , 0 = employee account
        String info = signin(customerID, db);
        if (info != null) {
            try {
                JSONObject obj = new JSONObject(info);
                String type = obj.getString(K.Mongo.UserType);
                System.out.println(type);
                if (customerID == 1) {                 /* handle customer account */
                    handleCustomer(info, db);
                }else {
                    handleEmployee(info,db);           /* handle employee account */
                }
            } 
            catch (JSONException e) {
                System.out.println("INVALID LOGIN: " + e);
            }
        }
    }


    /* verifies the login */
    public static String signin(int customerID, DataHandler db) {
        String userInfo = db.fetch(customerID);
        if (userInfo == null) {     /* customer doesn't exist */
            System.out.println("Customer with id " + customerID + " doesn't exist!");
            return null;
        }
        return userInfo;    // returns the json representation of their information
    }


    /* Function that will handle all the interaction that a customer will be able to perform */
    public static void handleCustomer(String info, DataHandler db) {
        Scanner scanner = new Scanner(System.in);
        Customer c = new Customer(info, db);

        /* Make notfication center listen to the customer */
        NotificationCenter nc = new NotificationCenter(); 
        c.addPropertyChangeListener(nc);


        /* Temporary switch menu that simulates the interaction that we wanted for the interactive web page */

        String choice; 
        boolean activeMenu = true;
        while(activeMenu) {
            System.out.println("Customer Menu");
            System.out.println("0: Display Information");
            System.out.println("1: Add Transaction");
            System.out.println("2: Add Subscription");
            System.out.println("3: Delete Account");
            System.out.println("4: Sign Out");
            choice = scanner.nextLine();
            int val = Integer.parseInt(choice);

            switch(val) {
                case 0:     // display information
                    c.displayInformation();
                    break;
                case 1:     // add transactions  , it will just be static transaction 
                    c.addTransaction("DEFAULT TRANSACTION", 1.00);
                    break;
                case 2:     // add subscriptions , default hulu subscription with 30 day recurrment
                    c.addSubscription("HULU", "Entertainment" , 99.99, 30);
                    break;
                case 3:     // delete account 
                    c.deleteAccount();
                    break;
                case 4:     // sign out 
                    c.checkForRecurringPayments();
                    c.signOut();
                    activeMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
              }
        }

        System.out.println("Signing off!");
        scanner.close();
        db.endSession();
    }

    /* Function that will handle all the interaction that a employee will be able to perform */
    public static void handleEmployee(String info, DataHandler db) {
        Scanner scanner = new Scanner(System.in);
        Employee e = new Employee(info, db);
        /* Temporary switch menu that simulates the interaction that we wanted for the interactive web page */

        String choice; 
        boolean activeMenu = true;
        while(activeMenu) {
            System.out.println("Employee Menu");
            System.out.println("1: Search Customers");
            System.out.println("2: Add Customers");
            System.out.println("3: Remove Customers");
            System.out.println("4: Sign Out");
            choice = scanner.nextLine();
            int val = Integer.parseInt(choice);

            switch(val) {
                case 1:     // search customer 
                    e.SearchCustomers(0);       // just hard coding to search for the customer with id = 0 
                    break;
                case 2:     // add customer
                    e.AddCustomers("Zachary Chommala", "testpassword");
                    break;
                case 3:     // remove customer
                    e.RemoveCustomers(1);      // for the sake of demonstration, we just remove the person we just added to the
                    break;
                case 4:     // sign out 
                    e.signOut();
                    activeMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
              }
        }
        scanner.close();
        db.endSession();
    }
}


        //db.addDocument("Zachary Chommala", "testpass", "customer" );
        //db.deleteDocument(2);   // zach should be deleted from the system.
        
        //db.updateDocument(1, K.Mongo.transdate, "12/01/01"); // replace 2 with 1
        //db.updateDocument(1, K.Mongo.name, "Bao Nguyen");
        //db.updateDocument(2, K.Mongo.pwd, "password");
        //
        //db.updateDocument(0, K.Mongo.bal, 333333.10);
        //db.updateDocument(0, K.Mongo.transAmount, 100.2); // adding to transaction array 
        //db.updateDocument(0, K.Mongo.trans, "XBONE"); // adding to transaction array 
        //db.updateDocument(0, K.Mongo.transdate, "11/11/1111"); // adding to transaction array 