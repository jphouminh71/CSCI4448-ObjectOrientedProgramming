package Facade.shapes; 

import Facade.Shape; 

public class Circle implements Shape {
    public Circle() {}

    public void draw() {
        System.out.println("Drawing: Circle"); 
    }
}