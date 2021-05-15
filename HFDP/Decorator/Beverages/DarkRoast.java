package Decorator.Beverages;

import Decorator.Beverage;

public class DarkRoast extends Beverage {

    public String getDescription() {
        return "DarkRoast";
    }

    public Double getPrice() {
        return 1.20; 
    }
}
