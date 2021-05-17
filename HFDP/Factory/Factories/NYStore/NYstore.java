package Factory.Factories.NYStore;
import Factory.Pizza;
import Factory.Factories.PizzaStore; 


public class NYstore extends PizzaStore {
 
    public Pizza createPizza(String type) {
        if (type == "cheese") { 
            return new NYcheese();
        } 
        else if (type == "NYpepperoni") {
            return new NYpepperoni();
        }
        return new NYpepperoni(); 
    }
}
