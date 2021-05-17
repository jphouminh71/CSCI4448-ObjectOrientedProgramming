package Command.Commands;

import Command.Command;
import Command.Recievers.*;

public class LightOnCommand implements Command {
    Light light; // reference to the command Reciever

    // constructor - sets the specific light to command
    public LightOnCommand(Light light) {
        this.light = light; 
    }

    // The invoker doesn't need to know how to execute the command, they just know that it can be execute
    public void execute() {
        this.light.flip(); 
    }    
}
