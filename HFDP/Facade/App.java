package Facade;

public class App {
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Facade Pattern");

        ShapeFacade shapes = new ShapeFacade(); 
        shapes.drawCircle();
        shapes.drawRectangle();
        shapes.drawSquare();

        System.out.println();
    }
}
