package Command;

// Remote control with one single button
// if we wanted to add more buttons we would just have the slot hold more commands via sets
public class SimpleRemoteControl {

    Command slot; // the button that controls our device 

    public SimpleRemoteControl() {}

    public void setCommand(Command command) {
        this.slot = command; 
    }

    public void ButtonPressed() {
        slot.execute();
    }
}
