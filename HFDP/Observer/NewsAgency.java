package Observer;

import java.util.ArrayList;
import java.util.List;


/**
 *  Needs to provide the following
 *  List to keep track of all observables
 *  Methods that notifys all Observers in the set
 *  Methods to add / remove observers from the set
 */ 

public class NewsAgency {
    // attributes 
    public String headline; 
    private List<Subscriber> subs = new ArrayList<>(); 
    // constructor
    public NewsAgency() {
        this.headline = "NO NEWS"; 
    }

    public void addObserver(Subscriber client) {
        // set the reference for the client
        client.subject = this; 
        // add client to the set
        subs.add(client);
    }
    
    public void removeObserver(Subscriber client) {
        client.subject = null; 
        subs.remove(client); 
    }

    // sets new headline and notifies all observers 
    public void setNews(String news) {
        this.headline = news; 
        System.out.println("New News: " + this.headline); 

        for (Subscriber subscriber : subs) {
            subscriber.update(this.headline);  // passing as a string, but you would pass objects to unpack later 
        }
    }
    
    public void printObservers() {
        System.out.println("Printing Observer Set");
        var size = this.subs.size(); 
        for (int i = 0; i < size; i++) {
            var element = this.subs.get(i); 
            System.out.println(element.Client); 
        }
    }

    public String getHeadline() {
        return this.headline; 
    }

}
