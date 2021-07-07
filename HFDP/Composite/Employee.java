package Composite;

import java.util.ArrayList;
import java.util.List; 

public class Employee {
    // attributes
    private String name; 
    private String department; 
    private int salary; 
    private ArrayList<Employee> suboordinates; 

    // constructor 
    public Employee(String name, String department, int salary) {
        this.name = name; 
        this.department = department; 
        this.salary = salary; 
        this.suboordinates = new ArrayList<Employee>();
    }

    // all methods that all employees support, this is what allows us to make a hierachry behavior 
    public void addEmployee(Employee e) {
        String newName = e.name;
        String currentE = this.name; 
        System.out.println(newName + " is now a suboordinate of " + currentE);
        this.suboordinates.add(e); 
    }

    public void removeEmployee(Employee e) {

        // make sure they are a suboordinate 
        if (this.suboordinates.contains(e)) {
            Boolean removed = this.suboordinates.remove(e); 
            if (removed) {
                System.out.println(e.name + " is no longer a suboordinate of " + this.name); 
            }
        }
        else {
            System.out.println(e.name + " is not an suboordinate of " + this.name); 
        }
    }

    public void printSuboordinates() {
        for (int i = 0; i < this.suboordinates.size(); i++) {
            System.out.println(this.suboordinates.get(i).name); 
        }
    }

    public ArrayList<Employee>  getSuboordinates() {
        return this.suboordinates; 
    }

    // overrides any built in 'toString()' method 
    public void printInfo() {
        System.out.println("Name:" + name + " dept:" + this.department + " salary:" + this.salary); 
    }


}
