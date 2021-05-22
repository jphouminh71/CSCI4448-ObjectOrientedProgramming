package Adapter;

public class Mallard implements Duck {
    public Mallard() {}

    public void quack() {
        System.out.println("quack quack!");
    }
    public void fly() {
        System.out.println("Mallard is flying!");
    }
}
