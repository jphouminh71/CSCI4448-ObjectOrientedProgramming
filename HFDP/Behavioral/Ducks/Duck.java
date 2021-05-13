package Behavioral.Ducks;

import Behavioral.FlyBehavior.*;
import Behavioral.QuackBehavior.*;

// Abstract Base Class For All Ducks
public abstract class Duck {
    
    // Attributes 
    public String type; 

    // references to the different behaviors
    public FlyBehavior flybehavior; 
    public QuackBehavior quackbehavior; 

    // Constructor 
    public Duck () { }

    // Methods
    public String getType(){ 
        return this.type; 
    }

    public void performFly() {
        flybehavior.fly();
    }

    public void performQuack() {
        quackbehavior.quack(); 
    }

    public void setFlyBehavior(FlyBehavior f) {
        System.out.println("Setting Fly Behavior");
        return; 
    } 
    public void setQuackBehavior(QuackBehavior q) {
        System.out.println("Setting Quack Behavior");
        return; 
    }


}
