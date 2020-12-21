package ZooAnimals.Canine;
import ZooAnimals.Animals;
import ZooAnimals.Behaviors.*;

public class CanineParentClass extends Animals {

    public CanineParentClass(String CanineName, NoiseBehavior _nb) { 
        this.setName(CanineName); 
        this.setNoiseBehavior(_nb);
    }

}