package Adapter;


/* 
    This program instantiates a turkey and duck object. We want to keep the client to only use the duck interface 
    so what we do is adapt the turkeyes interface to mimic the duck interface and therefore we use the turkeys interface
    through the duck interface.
*/
public class App {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Adapter Pattern!");

        Turkey secretDuck = new Turkey();
        Duck mallard = new Mallard(); 
        Duck ad = new TurkeyAdapter(secretDuck); 
        
        Duck[] arr = new Duck[] {mallard,ad}; 
        for (int i = 0; i < arr.length; i++) {
            arr[i].quack(); 
            arr[i].fly(); 
        }
        

        System.out.println();
    }
}
