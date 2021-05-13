package ZooAnimals.Canine;
import ZooAnimals.Canine.CanineParentClass;
import ZooAnimals.Behaviors.*;

public class Dog extends CanineParentClass{
    
    public Dog(String dogName, NoiseBehavior _nb ) { super(dogName, _nb); }

    @Override
    public String roam() {
        int probability = decideActionHelper();
        if (probability <= 24) {
            return this.dig();
        }
        
        String statement = String.format("%s the dog is roaming.", this.getName());
        return statement;
    }

    private String dig() {
        String statement = String.format("%s the dog is digging.", this.getName());
        return statement;
    }
}
