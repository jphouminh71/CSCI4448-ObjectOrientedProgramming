package Command;

import Command.Recievers.*;
import Command.Commands.*; 

public class App {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Command Pattern! ");


        Light bulb = new Light();
        LightOnCommand lo = new LightOnCommand(bulb);
        SimpleRemoteControl remote = new SimpleRemoteControl(); 

        remote.setCommand(lo);
        remote.ButtonPressed();
        remote.ButtonPressed();

        System.out.println();
    }
}
