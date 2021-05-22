package Adapter;

public class TurkeyAdapter implements Duck {
    private Turkey turkey; 

    public TurkeyAdapter(Turkey t) {
        this.turkey = t; 
    }
    public void quack() {
        this.turkey.gobble();
    }
    public void fly() {
        this.turkey.fly();
    }
}
