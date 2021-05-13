package Behavioral;
import Behavioral.Ducks.*; 

import Behavioral.FlyBehavior.*;
import Behavioral.QuackBehavior.*;

public class App {
    public App() {}  // empty constructor 

    public static void main(String[] args) {
        System.out.println();

        Duck newDuck = new Mallard();  // you would change this by creating a duckFactory  
        System.out.println("This duck is a " + newDuck.getType());
        newDuck.performFly(); 
        newDuck.performQuack(); 
        System.out.println();

        Duck rubberDuck = new Rubber();  // you would change this by creating a duckFactory  
        System.out.println("This duck is a " + rubberDuck.getType());
        rubberDuck.performFly(); 
        rubberDuck.performQuack(); 
        System.out.println();

        Duck modelDuck = new ModelDuck();  // you would change this by creating a duckFactory  
        System.out.println("This duck is a " + modelDuck.getType());
        modelDuck.performFly(); 
        modelDuck.performQuack(); 
        modelDuck.setFlyBehavior(new CanFly()); 
        modelDuck.setQuackBehavior(new Squeak()); 
        System.out.println("~~ Changing Behavior ~~");
        modelDuck.performFly(); 
        modelDuck.performQuack(); 


        System.out.println();
    }
}
