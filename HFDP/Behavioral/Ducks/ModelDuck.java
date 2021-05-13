package Behavioral.Ducks;

import Behavioral.FlyBehavior.*;
import Behavioral.QuackBehavior.*;

// This class demonstrates how you could set behaviors dynamically 
// it will initially not be able to fly and will quack
// will change during runtime for it to squeak and fly 
public class ModelDuck extends Duck {
    public ModelDuck() {
        this.type = "ModelDuck"; 
        this.flybehavior = new CantFly(); 
        this.quackbehavior = new Quack(); 
    }

    @Override
    public void setFlyBehavior(FlyBehavior b) {
        this.flybehavior = b; 
    }

    @Override
    public void setQuackBehavior(QuackBehavior q) {
        this.quackbehavior = q; 
    }
}
