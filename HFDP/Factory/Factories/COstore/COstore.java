package Factory.Factories.COstore;
import Factory.Factories.*;
import Factory.Pizza;


public class COstore extends PizzaStore {
    public Pizza createPizza(String type) {
        if (type == "Mountaineer") {
            return new Mountaineer();
        } 
        else if (type == "ColoradoStyle"){
            return new ColoradoStyle(); 
        }
        return new Mountaineer(); 
    }
}
