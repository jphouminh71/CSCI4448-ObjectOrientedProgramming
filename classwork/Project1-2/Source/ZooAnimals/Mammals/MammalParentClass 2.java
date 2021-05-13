package ZooAnimals.Mammals;
import ZooAnimals.Animals;
import ZooAnimals.Behaviors.*;

public class MammalParentClass extends Animals {

    public MammalParentClass(String givenName, NoiseBehavior _nb){ 
        this.setName(givenName); 
        this.setNoiseBehavior(_nb);
    }

}