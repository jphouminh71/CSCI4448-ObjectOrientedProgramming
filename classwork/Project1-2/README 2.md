Strategy Pattern Implementation:
    Implemented for makeNoise Behavior.

    The method that is implemented Strategy is the 'makeNoise' method for Animals. Each animal
    has the ability to set the the certain kind of noise {NoNoise, QuietNoise, LoudNoise} manually, but we decided to just pass the specific initial behavior for each animal at instantiation time.
        Again, every aninimal is able to change the way they 'makeNoise' manually, but decided to set the initial behavior 
        of each animal at instantiation time to keep code cleaner.


    Modified Files / Directories: 
        - New Directory 'Behaviors' that holds the source code for the different noise behaviors
        - Updated all constructors to take in a specific noise behavior in /Animals
        - In Animals.java , created a setter method for the noise behavior 


Observer Pattern Implementation: 
    Essentially, all employees are obeservers of the clock. Announcer observers the ZooKeeper and ZooFoodServer and after each day all subcribers will unsubscribe from their publishers and resubscribe once the next zoo day comes into play.

Assumptions / Decisions: 
    1. All Animals have a delegate for 'makeNoise'. They will be initialized by default with one
    2. We decided to implement the time format as military time format to keep it easy to implement. If we were to take this further and
    cleaned up the output, we would most likely bring in a date formatter. 


Collaborators: 

    dev: Jonathan Phouminh
    email: joph0114@colorado.edu

    dev: Zachary Chommala
    email: zach4259@colorado.edu

    dev: Bao Nguyen
    email: bang4255@colorado.edu


Steps to compile program: 
    javac $(find . -name '*.java')
    java Main



RESOURCES: 

    Observables in java: https://docs.oracle.com/javase/7/docs/api/java/beans/PropertyChangeListener.html
    StringtoInt: https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
    Dictionary: https://www.geeksforgeeks.org/java-util-dictionary-class-java/