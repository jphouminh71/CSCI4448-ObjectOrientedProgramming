package Strategy.Ducks;

import Strategy.FlyBehavior.*;
import Strategy.QuackBehavior.*;

public class Rubber extends Duck {
    public Rubber() {
        this.type = "Rubber"; 
        this.flybehavior = new CantFly(); 
        this.quackbehavior = new Squeak(); 
    }
}
