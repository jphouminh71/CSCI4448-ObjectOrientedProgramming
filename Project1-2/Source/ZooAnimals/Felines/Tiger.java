package ZooAnimals.Felines;
import ZooAnimals.Felines.Feline; 
import ZooAnimals.Behaviors.*;

public class Tiger extends Feline {

    public Tiger(String givenName, NoiseBehavior _nb){ super(givenName, _nb); }

    @Override
    public String sleep() {
        int probability = decideActionHelper();
        if (probability <= 29) {
            return this.roam();
            
        }
        else if (probability >= 30 && probability <= 59 ) {
            return this.makeNoise();
           
        }
        else if (probability >= 59) {
            return this.sleep();
            
        }
        String statement = String.format("%s the tiger is sleeping.", this.getName());
        return statement;
    }

}