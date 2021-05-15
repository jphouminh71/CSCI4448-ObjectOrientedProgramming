package Decorator.Beverages;

import Decorator.Beverage;

public class Expresso extends Beverage {
    public String getDescription() {
        return "Expresso";
    }

    public Double getPrice() {
        return 1.80; 
    }
}
