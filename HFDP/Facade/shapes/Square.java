package Facade.shapes;

import Facade.Shape; 

public class Square implements Shape {    
    public Square() {}

    public void draw() {
        System.out.println("Drawing: SQUARE");
    }
}
