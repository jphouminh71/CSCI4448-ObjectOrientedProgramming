package Factory;
import Factory.Factories.COstore.*;
import Factory.Factories.NYStore.*;

public class App {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Pizza Factory!");

        // create a certain type of pizza store
        var COstore = new COstore(); 
        var NYstore = new NYstore(); 

        COstore.orderPizza("cheese");
        System.out.println();
        NYstore.orderPizza("cheese"); 

        System.out.println();
    }
}
