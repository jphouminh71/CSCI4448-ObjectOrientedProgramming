package Decorator.Condiments;
import Decorator.Beverage;

public class Milk extends CondimentDecorator{
    
    Beverage beverage; 

    public Milk(Beverage b) {
        this.beverage = b;
    }

    public String getDescription() {
        return this.beverage.getDescription() + " Milk";
    }

    public Double getPrice() {
        return this.beverage.getPrice() + 0.20; 
    }
}
