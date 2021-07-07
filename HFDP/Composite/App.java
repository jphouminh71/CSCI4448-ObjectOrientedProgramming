package Composite;

import java.util.ArrayList;

public class App {
    public static void main(String args[]) {
        System.out.println("Composite Pattern!"); 

        Employee leo = new Employee("leo", "head payments", 200000);
        Employee jon = new Employee("jon", "integrated payments", 72000);
        Employee rick = new Employee("rick", "integrated payments", 72000);
        Employee zach = new Employee("zach", "assistant", 20);

        Employee morty = new Employee("morty", "sales", 10000);
        Employee candice = new Employee("candice", "head sales", 30000);

        Employee boss = new Employee("boss", "CEO", 1);
        
        // building the hierarchy
        candice.addEmployee(morty);
        jon.addEmployee(zach);

        leo.addEmployee(jon);
        leo.addEmployee(rick);

        boss.addEmployee(leo);
        boss.addEmployee(candice);

        boss.printInfo();
        boss.printSuboordinates();

        // only going one level down the tree, would do this recursively normally 
        for( Employee e : boss.getSuboordinates()){ 
            ArrayList<Employee> subs = e.getSuboordinates();
            for (Employee s : subs) {
                s.printInfo();
            }
            System.out.println("--");
            
        }

        System.out.println();
    }
}
