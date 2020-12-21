import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("Enter Zoo operation day count: ");
        String daysOfOperation = myObj.nextLine();  // Read user input
        int convertedInt = Integer.parseInt(daysOfOperation);

        // Running the actual program
        ZooTycoon myzoo = new ZooTycoon(convertedInt);
    }
}
