package Employees;
import ZooAnimals.Animals;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.io.*;
import java.util.*;

public class ZooKeeper extends ZooEmployee implements PropertyChangeListener {

    private PropertyChangeSupport pcs; 
    public PrintWriter outFile;
    private String currentActivity = ""; 

    private Animals[] animal_list;   // gets set after animals are initialized 
    
    public ZooKeeper(String givenName) { 
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

    // Observing the clock
    public void propertyChange(PropertyChangeEvent evt) {
        Object time = evt.getNewValue();
        int currTime = (int) time;
        if (currTime == 800) {
            outFile.println(this.arriveAtZoo());
        }
        if (currTime == 900) {
            for (Animals x : animal_list) { outFile.println(this.wakeAnimal(x));}
            for (Animals x : animal_list) { outFile.println(this.roleCallAnimal(x));}
        }
        if (currTime == 1200) {
            for (Animals x : animal_list) { outFile.println(this.feedAnimal(x)); }
            for (Animals x : animal_list) { outFile.println(this.excerciseAnimal(x));}
        }
        if (currTime == 1900) {
            for (Animals x : animal_list) { outFile.println(this.makeAnimalSleep(x));}
        }
        if (currTime == 2100) {
            outFile.println(this.leaveZoo());
        }
    }

    // ZOOKEEPER METHODS
    public void fetchAnimals(Animals[] a) {
        this.animal_list = a;
    }

    public void setActivity(String actv) { 
        pcs.firePropertyChange("currentActivity", this.currentActivity, actv);
        this.currentActivity = actv; 
    }

    public String excerciseAnimal(Animals animal) {
        setActivity("excercise the animals");
        String s1 = animal.roam();
        String s2 = String.format("%s the %s excercises %s the %s | ", this.getName(), this.getRole(), animal.getName(), animal.getType());
        return s2 + " " + s1; 
    }

    public String makeAnimalSleep(Animals animal) {
        setActivity("make the animals sleep");
        String s1 = animal.sleep();
        String s2 = String.format("%s the %s to puts %s the %s to sleep | ", this.getName(), this.getRole(), animal.getName(), animal.getType());
        return s2 + " " + s1; 
    }

    public String wakeAnimal(Animals animal) {
        setActivity("wake up the animals");
        String s1 = animal.wakeUp();
        String s2 = String.format("%s the %s wakes up the animal %s the %s | ", this.getName(), this.getRole(), animal.getName(), animal.getType());
        return s2 + " " + s1; 
    }

    public String roleCallAnimal(Animals animal) {
        setActivity("role call the animals");
        String s1 = String.format("%s the %s roll calls for %s the %s", this.getName(), this.getRole(), animal.getName(), animal.getType());
        String s2 = String.format(" | %s is here!", animal.getName());
        return s1 + " " + s2; 
    }

    public String feedAnimal(Animals animal) {
        setActivity("feed the animals");
        String s1 = animal.eat();
        String s2 = String.format("%s the %s feeds %s the %s |", this.getName(), this.getRole(), animal.getName(), animal.getType());
        return s2 + " " + s1; 
    }

}