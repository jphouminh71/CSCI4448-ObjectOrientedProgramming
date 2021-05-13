package Employees;
import ZooAnimals.Animals;


public abstract class ZooEmployee { 

    private String name;  

    // getter methods
    public String getName() { return this.name; }
    public String getRole() { return this.getClass().getSimpleName(); }

    public void setName(String givenName) { this.name = givenName; }

    public String leaveZoo() {
        String s1 = String.format("%s the %s is leaving the zoo for the day.", this.getName(), this.getRole());
        return s1;
    }

    public String arriveAtZoo() {
        String s1 = String.format("%s the %s is arriving at the zoo.", this.getName(), this.getRole());
        return s1;
    }
}