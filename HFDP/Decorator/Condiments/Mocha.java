package Decorator.Condiments;
import Decorator.Beverage;

public class Mocha extends CondimentDecorator {

    Beverage beverage; 

    public Mocha(Beverage b) {
        this.beverage = b; 
    }
    
    public String getDescription() {
        return this.beverage.getDescription() +  "Mocha";
    }

    public Double getPrice() {
        return this.beverage.getPrice() + 0.20; 
    }
}
