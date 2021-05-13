package Behavioral.Ducks;

import Behavioral.FlyBehavior.*;
import Behavioral.QuackBehavior.*;

public class Rubber extends Duck {
    public Rubber() {
        this.type = "Rubber"; 
        this.flybehavior = new CantFly(); 
        this.quackbehavior = new Squeak(); 
    }
}
