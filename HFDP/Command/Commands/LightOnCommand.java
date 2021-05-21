package Command.Commands;

import Command.Command;
import Command.Recievers.*;

// NOTE: In this implementation you are 'flipping' a switch and therefore both interactions are happening on a single button.
// Too handle different methods for the Light you should create separate Command objects for the actions
// LightOffCommand.java , etc...
public class LightOnCommand implements Command {
    Light light; // reference to the command Reciever

    // constructor - sets the specific light to command
    public LightOnCommand(Light light) {
        this.light = light; 
    }

    // The invoker doesn't need to know how to execute the command, they just know that it can be execute
    // If you wanted to capture the specific button that was pressed to execute a command accordingly, you could probably pass in the id of the button 
    // in the paramters so you can execute accordingly, but you would have to map the commands to a specific button and interchanging commands might be annoying
    // but in the case of a remote you don't normally remap buttons once they are set. 

    // OR you can add a second 'execute' in the interface to support another execute method, then set all second executes to return null if they aren't being used. 
    public void execute() {
        this.light.flip(); 
    }    
}
