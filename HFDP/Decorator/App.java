package Decorator;

import Decorator.Beverages.*;
import Decorator.Condiments.*;

public class App {
   public static void main(String[] args) {
        System.out.println();
        
        Beverage darkWMilk = new DarkRoast(); 
        darkWMilk = new Milk(darkWMilk); 
        System.out.println(darkWMilk.getDescription());
        System.out.println(darkWMilk.getPrice());

        System.out.println();
   }
}
