package Decorator.Condiments;

import Decorator.Beverage;

public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription(); 
    public abstract Double getPrice();
}
