package Behavioral;

class Duck {

    // Attributes
    private String type; 

    // Constructor 
    Duck(String type) {
        this.type = type; 
    }

    void printType() {
        System.out.println("TYPE: " + this.type); 
    }
}
