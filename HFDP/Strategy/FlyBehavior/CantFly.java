package Strategy.FlyBehavior;

public class CantFly implements FlyBehavior {
    public void fly() {
        System.out.println("Im not a duck that can fly!"); 
    }
}
