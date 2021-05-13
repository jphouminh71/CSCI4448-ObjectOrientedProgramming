package ZooAnimals.Behaviors;
import ZooAnimals.Animals;

// STRATEGY PATTERN: Defining basic interface taht will serve as interface for types of sleep behaviors
// SleepingLoudly and SleepingQuietly.
public interface NoiseBehavior {
    public String makeNoise();
}