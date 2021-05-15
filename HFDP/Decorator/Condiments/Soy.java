package Decorator.Condiments;

import javax.swing.border.BevelBorder;

import Decorator.Beverage;

public class Soy extends CondimentDecorator {

    Beverage beverage; 

    public Soy(Beverage b) {
        this.beverage = b; 
    }

    public String getDescription() {
        return this.beverage.getDescription() + "Soy";
    }

    public Double getPrice() {
        return this.beverage.getPrice() + 0.20; 
    }
}
