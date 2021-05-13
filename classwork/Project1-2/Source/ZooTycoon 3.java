import ZooAnimals.Animals;
import ZooAnimals.Felines.*;
import ZooAnimals.Canine.*;
import ZooAnimals.Pachyderms.*;
import ZooAnimals.Mammals.*;
import ZooAnimals.Behaviors.*;
import Employees.*;
import java.io.*;
import java.util.*;


final public class ZooTycoon {
    // Zoo Attributes
    private int dayCount = 0; 
    private int animalCount = 20;
    ZooKeeper zookeeper; 
    ZooAnnouncer zooannouncer; 
    ZooClock zooclock;
    ZooFoodEmployee server;
    Animals[] animal_list = new Animals[20];

    public int getDayCount() { return this.dayCount; }
    public int getAnimalCount() { return this.animalCount; }
    public void setDayCount(int givenDayCount) { this.dayCount = givenDayCount; }
    public void setAnimalCount(int givenAnimalCount) { this.animalCount = givenAnimalCount; }

    // days: Amount of days to operate zoo
    public ZooTycoon(int days) throws FileNotFoundException {
        this.setDayCount(days);
        this.setAnimalCount(0);
        initializeZoo();
    }

    public void initializeZoo() throws FileNotFoundException {

        // creating the felines 
        Cat cat_one = new Cat("Charles", new NoNoise());
        Cat cat_two = new Cat("Cole", new NoNoise());
        Lion lion_one = new Lion("Larry", new NoNoise());
        Lion lion_two = new Lion("Luke", new NoNoise());
        Tiger tiger_one = new Tiger("Tigger", new NoNoise());
        Tiger tiger_two = new Tiger("Travis", new NoNoise());

        // creating the canines
        Dog dog_one = new Dog("Doug", new LoudNoise() );
        Dog dog_two = new Dog("Dale", new LoudNoise());
        Wolf wolf_one = new Wolf("William", new LoudNoise());
        Wolf wolf_two = new Wolf("Whitney", new LoudNoise());
        

        // creating the mammals
        Gorilla gorilla_one = new Gorilla("Gerald", new QuietNoise());
        Gorilla gorilla_two = new Gorilla("Gavin", new QuietNoise());
        Platypus plat_one = new Platypus("Perry", new QuietNoise());
        Platypus plat_two = new Platypus("Patrick", new QuietNoise());

        // creating the pachyderms
        Elephant ele_one = new Elephant("Ellie", new LoudNoise());
        Elephant ele_two = new Elephant("Elijah", new LoudNoise());
        Hippo hippo_one = new Hippo("Harry", new LoudNoise());
        Hippo hippo_two = new Hippo("Hermione", new LoudNoise());
        Rhino rhino_one = new Rhino("Rick", new LoudNoise());
        Rhino rhino_two = new Rhino("Rainey", new LoudNoise());

        // call setNoiseBehvaior if you want to change the noise behavior of any of these animals
        // rhino_one.setNoiseBehavior(new QuiteNoise());

        // adding the animals to the array
        animal_list[0] = cat_one;
        animal_list[1] = cat_two;
        animal_list[2] = lion_one;
        animal_list[3] = lion_two;
        animal_list[4] = tiger_one;
        animal_list[5] = tiger_two;
        animal_list[6] = dog_one;
        animal_list[7] = dog_two;
        animal_list[8] = wolf_one;
        animal_list[9] = wolf_two;
        animal_list[10] = gorilla_one;
        animal_list[11] = gorilla_two;
        animal_list[12] = plat_one;
        animal_list[13] = plat_two;
        animal_list[14] = ele_one;
        animal_list[15] = ele_two; 
        animal_list[16] = hippo_one;
        animal_list[17] = hippo_two;
        animal_list[18] = rhino_one;
        animal_list[19] = rhino_two;
        
        // initalizing employees
        this.server = new ZooFoodEmployee("Jon");
        this.zookeeper = new ZooKeeper("Zach");
        this.zooannouncer = new ZooAnnouncer("Bao");
        this.zooclock= new ZooClock();

        zookeeper.fetchAnimals(animal_list);   // giving the zookeeper access to animals
        operateZoo();
    }


    // having all observers subscribe 
    private void assignListeners() {
        zookeeper.addPropertyChangeListener(zooannouncer);
        server.addPropertyChangeListener(zooannouncer);

        zooclock.addPropertyChangeListener(zookeeper);
        zooclock.addPropertyChangeListener(server);
        zooclock.addPropertyChangeListener(zooannouncer);
    }


    // having all obserables unsub their subcribers
    private void resignListeners() {
        zookeeper.removePropertyChangeListener(zooannouncer);
        server.removePropertyChangeListener(zooannouncer);

        zooclock.removePropertyChangeListener(zookeeper);
        zooclock.removePropertyChangeListener(server);
        zooclock.removePropertyChangeListener(zooannouncer);
    }

    private void operateZoo() throws FileNotFoundException {
        PrintWriter _outFile = new PrintWriter("dayatthezoo.out");
        zooannouncer.outFile = _outFile;
        zookeeper.outFile = _outFile;
        server.outFile = _outFile;

        int currentDay = 1;   // count day zero as the first day 
        while (currentDay != this.getDayCount()+1){
            assignListeners();
            _outFile.println("---------------------------------------");
            _outFile.println(String.format("DAY %s AT THE ZOO!", Integer.toString(currentDay)));
            _outFile.println("---------------------------------------");
            while (zooclock.incrementTime()){
                int currentTime = zooclock.getTime();
                _outFile.println(String.format("TIME (military): %s ", currentTime));
            }
            currentDay = currentDay + 1;
            resignListeners();
        }
        _outFile.close();  
        return;
    }
}
