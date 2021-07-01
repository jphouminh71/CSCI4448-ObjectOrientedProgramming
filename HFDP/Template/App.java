package Template;

public class App {
    
    public static void main(String args[]) {
        System.out.println();
        System.out.println("Template pattern!"); 

        CaffieneBeverage tea = new Tea(); 
        CaffieneBeverage coffee = new Coffee(); 

        tea.prepareDrink();
        System.out.println(); 
        coffee.prepareDrink();
        System.out.println(); 
        System.out.println();
    }
}
