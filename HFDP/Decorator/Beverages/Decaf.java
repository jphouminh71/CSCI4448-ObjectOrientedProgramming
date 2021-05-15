package Decorator.Beverages;

import Decorator.Beverage;

public class Decaf extends Beverage{
    public String getDescription() {
        return "Decaf";
    }

    public Double getPrice() {
        return 0.99; 
    }
}
