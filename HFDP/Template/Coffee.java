package Template;

public class Coffee extends CaffieneBeverage {

    void brew() {
        System.out.println("Grinding coffee..");
        System.out.println("Steeping grinds..");
    }

    void addCondiments() {
        System.out.println("adding cream..");
        System.out.println("adding sugar");
    }
}
