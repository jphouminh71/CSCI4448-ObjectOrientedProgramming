package Decorator.Beverages;

import Decorator.Beverage;

public class HouseBlend extends Beverage {
    public String getDescription() {
        return "HouseBlend";
    }

    public Double getPrice() {
        return 1.05; 
    }
}
