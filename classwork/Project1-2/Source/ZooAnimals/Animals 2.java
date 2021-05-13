package ZooAnimals;
import java.util.Random;
import ZooAnimals.Behaviors.*;

public abstract class Animals {

    // noise behavior delegate
    private NoiseBehavior nb;

    private String name;            

    public void setName(String givenName) { this.name = givenName; }
    public void setNoiseBehavior(NoiseBehavior _nb) { this.nb = _nb; }
    
    public String getName() { return this.name; } 
    public String getType() { return this.getClass().getSimpleName(); }

    // Concrete methods that all animals should support
    public int decideActionHelper() {
        Random rand = new Random();
        return rand.nextInt(100);   // generate 0 - 99
    }

    public String sleep() {
       String statement = String.format("%s the %s sleeps", this.getName(), this.getType());
       return statement;
    }

    public String roam() {
        String statement = String.format("%s the %s roams", this.getName(), this.getType());
        return statement;
    }

    // going to amake the animal make a noise when they wake up , makes more sense
    public String wakeUp() {
        return makeNoise();
    }

    public String makeNoise() {
        String noiseStatement = this.getName() + " the " + this.getType() + nb.makeNoise();  // appending to delegate print out
        return noiseStatement;
    }

    public String eat() {
       String statement = String.format("%s the %s is eating.", this.getName(), this.getType());
       return statement;
    }
}