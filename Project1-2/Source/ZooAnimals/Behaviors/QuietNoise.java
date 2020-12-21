package ZooAnimals.Behaviors;
import ZooAnimals.Animals;

public class QuietNoise implements NoiseBehavior {
    public String makeNoise() {
        return "  makes a quiet.";
    }
}