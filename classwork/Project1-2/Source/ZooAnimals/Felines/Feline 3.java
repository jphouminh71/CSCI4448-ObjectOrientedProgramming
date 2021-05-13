package ZooAnimals.Felines;
import ZooAnimals.Animals;
import ZooAnimals.Behaviors.*;

public class Feline extends Animals {
    public Feline(String givenName, NoiseBehavior _nb) { 
        this.setName(givenName);
        this.setNoiseBehavior(_nb);
    }

}