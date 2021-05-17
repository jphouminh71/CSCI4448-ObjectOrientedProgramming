package Command.Recievers;

public class Light {

    public boolean isOn;
    
    public Light() {
        this.isOn = false; 
    }

    public void flip() {
        if (this.isOn) {
            this.off(); 
        } else {
            this.on(); 
        }
    }

    private void on() {
        System.out.println("Light turned on.");
        this.isOn = true; 
    }

    private void off() {
        System.out.println("Light turned off.");
        this.isOn = false; 
    }

}
