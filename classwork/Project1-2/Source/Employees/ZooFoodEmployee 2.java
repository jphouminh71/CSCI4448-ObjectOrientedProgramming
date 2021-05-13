package Employees;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.*;
import java.util.*;

public class ZooFoodEmployee extends ZooEmployee implements PropertyChangeListener {

    private PropertyChangeSupport pcs;
    public PrintWriter outFile;

    public ZooFoodEmployee(String givenName) { 
        this.setName(givenName);
        pcs = new PropertyChangeSupport(this);   
    }

    // REQUIRED OBSERVABLE METHODS
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

    // Observing the ZooClock
    public void propertyChange(PropertyChangeEvent evt) {
        String event = evt.getNewValue().toString();
        int time = Integer.parseInt(event);
        if (time == 1200) {  
            this.makeFood();
            this.serveFood();
            this.cleanup();
        }
        else if (time == 1700) {
            this.makeFood();
            this.serveFood();
            this.cleanup();
        }
        else if (time == 800) {
            outFile.println(this.arriveAtZoo());
        }
        else if (time == 2100) {
            outFile.println(this.leaveZoo());
        }
    }

    public void makeFood() {
        outFile.println(String.format("%s the %s is making food for the zoo.", this.getName(), this.getRole()));
    }

    public void serveFood() {
        outFile.println(String.format("%s the %s is serving food at the zoo.", this.getName(), this.getRole()));
    }

    public void cleanup() {
        outFile.println(String.format("%s the %s is cleaning up the kitchen.", this.getName(), this.getRole()));
    }
}