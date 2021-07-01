package Template;

public abstract class CaffieneBeverage {
    
    // client execute method 
    final public void prepareDrink() {
        this.boilWater();
        this.brew();
        this.addCondiments();
        this.pourBeverage();
    }
    
    // template methods for varying algorithm 
    abstract void brew(); 
    abstract void addCondiments(); 

    // generic methods shared by all subclasses
    private final void boilWater() {
        System.out.println("Boiling hot water");
    }

    private final void pourBeverage() {
        System.out.println("Pouring drink into cup");
    }
}
