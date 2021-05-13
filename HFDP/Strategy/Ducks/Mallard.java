package Strategy.Ducks;

import Strategy.FlyBehavior.*;
import Strategy.QuackBehavior.*;


public class Mallard extends Duck{
    
    public Mallard() {
        this.type = "Mallard"; 
        this.flybehavior = new CanFly();
        this.quackbehavior = new Quack(); 
    }
}
