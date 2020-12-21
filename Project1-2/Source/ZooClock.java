import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.*;

public class ZooClock {
    private PropertyChangeSupport pcs; 
    private int time;
    private int timeinterval = 100;

    public ZooClock () {
        this.time = 700; 
        pcs = new PropertyChangeSupport(this);   
    }

    // REQUIRED OBSERVABLE METHODS
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

    int getTime() {
        return this.time;
    }

    // Will signal all observers at each increment, its up to the observers to determine how to handle
    // the current time.
    public boolean incrementTime() {
        if (this.time == 2100) {
            this.time = 700;
            return false;
        }
        pcs.firePropertyChange("time", this.time, this.time + timeinterval); 
        this.time = this.time + timeinterval;
        return true;
    }
}