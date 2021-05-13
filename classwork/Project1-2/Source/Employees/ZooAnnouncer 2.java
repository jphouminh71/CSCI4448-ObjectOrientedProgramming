package Employees;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.*;


public class ZooAnnouncer extends ZooEmployee implements PropertyChangeListener {
    /* Delegate for the PrintWriter */
    public PrintWriter outFile;

    public ZooAnnouncer(String givenName) { this.setName(givenName); }

    // Listening to the Zookeeper and Clock
    public void propertyChange(PropertyChangeEvent evt) {
        String source = evt.getPropertyName();
        if (source == "currentActivity") {     // events coming from the ZooKeeper
            String event = evt.getNewValue().toString(); 
            outFile.println(String.format("%s the %s says, The Zookeeper is about to %s!", this.getName(), this.getRole(), event));
        }
        if (source == "time") {                // events coming from the ZooClock
            int event = (int) evt.getNewValue();
            if(event == 2100) {
                outFile.println(this.leaveZoo());
            }
            else if (event == 800){
                outFile.println(this.arriveAtZoo());
            }
        }
    }
}
