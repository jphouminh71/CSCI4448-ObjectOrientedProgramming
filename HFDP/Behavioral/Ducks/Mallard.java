package Behavioral.Ducks;

// importing the behaviors, we can use any of them for the mallard now 
import Behavioral.FlyBehavior.*;
import Behavioral.QuackBehavior.*;


public class Mallard extends Duck{
    
    public Mallard() {
        this.type = "Mallard"; 
        this.flybehavior = new CanFly();
        this.quackbehavior = new Quack(); 
    }
}
