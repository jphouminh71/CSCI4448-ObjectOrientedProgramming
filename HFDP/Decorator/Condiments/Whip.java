package Decorator.Condiments;

import Decorator.Beverage;

public class Whip extends Beverage {

    Beverage beverage; 

    public Whip(Beverage b) {
        this.beverage = b;
    }
    
    public String getDescription() {
        return beverage.getDescription() + "Whip";
    }

    public Double getPrice() {
        return beverage.getPrice() + 0.20; 
    }
}
