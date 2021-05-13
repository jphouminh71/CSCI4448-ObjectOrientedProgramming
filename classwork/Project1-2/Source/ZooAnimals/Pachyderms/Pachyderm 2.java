package ZooAnimals.Pachyderms;
import ZooAnimals.Animals;
import ZooAnimals.Behaviors.*;

public class Pachyderm extends Animals {

    public Pachyderm(String givenName, NoiseBehavior _nb) { 
        this.setName(givenName); 
        this.setNoiseBehavior(_nb);
    }

    @Override
    public String roam() {
        int num = decideActionHelper();
        if (num <= 24) {
            return this.charge();
        }
        else {
            String statement = String.format("%s the pachyderm roams.", this.getName());
            return statement;
        }
    }
    
    public String charge() {
        String statmement = String.format("%s the %s charges.", this.getName(), this.getType());
        return statmement;
    }
}
