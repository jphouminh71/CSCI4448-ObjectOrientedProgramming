# Head First Design Patterns (Java 14)

"Program to an interface" - the declared type of variables should be a supertype, usually an abstract class or interface, so that the objects assigned aren't tied to a specific class

```js
    Animal animal = new Dog(); 
    animal.makeSound();   // bark() 
```
<br>

### "Delegation is favored over inheritance."
* Not only does it let you encapsulate a family of algorithms into their own set of classes, but it also lets you change behavior at runtime. 

### Open Closed Principle
* Classes should be open to extension, but closed for modification

### Guidelines for Dependency Inversion Principle
* No variable should hold a reference to a concrete class.
* No class should derive from a concrete class. (Should derive from interfaces and abstract classes)
* No method should override an implemented method of a base class. 
    - Override abstract methods
    - If it's implemented in the base class, it's mean to be used by subclasses 

### Single Responsibiliy Principle
* Each class should only be responsible for one thing. Ask yourself, "Does adding this method or attribute concern the task this class is built to handle?"


### Hollywood Principle 
* "Dont call us we will call you"

This design principle states that we want our high-level components to call low-level components, not the other way around. Kind of like how in react you pass down props to children for them to do their work. 

This principle reiterates the dependency inversion principle: "Depend on abstractions, not concrete classes." 

<br>

## Interface vs Abstract Classes
---
Consider using **abstract classes** if any of these statements apply to your situation:  

* In the java application, there are some related classes that need to share some lines of code then you can put these lines of code within the abstract class and this abstract class should be extended by all these related classes.
* You can define the non-static or non-final field(s) in the abstract class so that via a method you can access and modify the state of the Object to which they belong.
* You can expect that the classes that extend an abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
<br>


Consider using **interfaces** if any of these statements apply to your situation:  

* It is a total abstraction, All methods declared within an interface must be implemented by the class(es) that implements this interface.
* A class can implement more than one interface. It is called multiple inheritances.
* You want to specify the behaviour of a particular data type, but not concerned about who implements its behaviour.

<br>

## Strategy Pattern  <br>
--- 

**Definition**: defines a family of algorithms , encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from the clients that use them. 

* Allows you to encapsulate different behaviors or Algorithms that can be dynamically swapped for an object to use. By creating a delegate to different algorithms and behaviors it decouples the need to refactor specific classes that use the same algorithms / behaviors. 

"We could have just as easily use the same techniques for a set of classes that implement the different ways to compute sales tax for each state". 
    Ex. States are the "Ducks" , Tax Computation Algorithms are the different ways the "duck" can "Fly" 
<br><br>
## Observer Pattern 
--- 
* Allows objects to keep other objects informed about events occurring within a software system (can be dynamically assigned). If the Subject is changed then all the observers are notified. If needed then an observer may query for information 

    Ex. Have a Global Clock class that will notify all observers when certain times hit. Or Having a service notify all all components when new data is recieved
<br>

## Decorator Pattern
---
* This pattern provides a powerful mechanism for adding new behaviors to an object at runtime. This mechanism is based on the foundation of 'wrapping'. The difference is not as decoupled as the strategy pattern. 

    Ex. Making a Starbucks Service and wrapping each base drink with condiments.
<br>

## Factory Pattern (Simple / Abstract)
--- 
* Factory Method is one way of following the dependency inversion principle - one of the OO principles. 
* "Depend upon abstractions. Do not depend upon concrete classes." 
* Normally "high-level" classes depend on "low-level" classes. Instead, they BOTH should depend on an abstract interface. 
<br>

## Singleton Pattern
---
* Used to ensure that only on instance of a particular class ever gets created and that there is just one (global) way to gain access to that instance 
* Provides a global access point. (Kind of bad because using global variables causing thread safety issues)
* Consider alternatives for multithreading uses. 

#### Components of Singleton
- private constructor
- private static instance variable to store the single instance
- public static method to gain access to that instance
- this method creates object if needed; returns it 
<br>

 Typical we see singleton in object pools such as thread pools! 
<br>

## Command Pattern
--- 
1. Start at Client
2. **Client** Object - CreateCommandObject() - a Request
    - Command_Object knows
        - Who is the target reciever
        - What actions do I need the Receiver to execture (**Reciever Methods**)
3. **Command_Object** - defines Execute()
    - Command.Execute() will be called to invoke specified Receiver actions
4. **Invoker** - Command_Object.Execute()
    - The Invoker calls Command_Object.Execute()...
    - What the timing is of executing that command may vary (thread safety needs consideration)
5. **Receiver** executes the Receiver actions in the Command_Object whe the Invoker says to 
<br>

## Facade Pattern
---
"Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that maeks the subsystem easier to use."
* Facade works best when you are accessing a subset of the subsystem's functionality
    - You can also add new features by adding it to the Facade (not the subsystem); you still get a simpler interface
* Facade not only reduces the number of methods you are dealing with but also the number of classes and also decouples a client from a subsystem of components.

* Essentially its just encapsualtion on a large sub-system that makes it easier for the client to interact with. 

Facade works best when you are accessing a subset of the subsystem's functionality aka you don't need to use the helper methods.

<br>

## Adapter Pattern
--- 
The adapter pattern provides steps for converting an incompatible interface with an existing system into a different interface that is compatiable. 

Adapter lets classes work together that couldn't otherwise because of incompatible interfaces. 
 - the client makes a request on the adapter by invoking a method from the target interface on it
 - the adapter translates that request into one or more calls on the adaptee using the adaptee interface 
 - the client recieves the results of the call and never knows there is an adapter doing the translation 

<br>

 ## Template Pattern 
 ----
Recall that encapsualtion should be thought of as "any kind of hiding" especially the hiding of "things that can change". We can hide data but also 

- methods, objects, type, behavior, implementations, design details, etc. 

Templates encapsulate algorithm implementations. It defines the skeleton of an algorithm in a method, deffering some steps to be implmeented by the subclasses.

1. Make the algorithm abstract
2. Each step of the algorithm is represented by a method
3. Ecapsulates the details of most steps in the subclasses. 

Templates are used to encapsulate algorithm implementations. 

* Defines the skeleton of an algorithm without changing the algirhtms structure
* Each step of the algorith mis represented by a method
* Encapsualtes the details of the general steps. The special steps are abstracted for the subclasses to implement

We try to make steps of an algorithm more abstract and specified its structure in the superclass. 

You will see the Template method used a lot for creating design frameworks. The framework will speicfy how something should be done and framework adopters can provide implementations of their own. 

**Template vs Strategy**: Template focuses on ecapsulating specific steps of algorithsm where strategy focuses on encapsulating entirely different algorithms. 

<br>

## Iterator Pattern
--- 

<em> Iterator issue is best demonstrated through code </em>

In this example we see the iterations are doing the same exact thing, but implemented differently
```
// Inconsistency Issue
for (int i = 0; i < lunchItems.length; i++) {
    MenuItem menuItem = lunchItems[i]; 
}

for (int i = 0; i < breakfastItems.size(); i++) {
    MenuItem menuItem = breakfastItems.get(i)
}
```
<em> The Solution </em>: Make an object that iterates any iterable object in a standard way. 

```
// ask breafast menu for an iterator of its breakfast items
Iterator iterator = breakfastMenu.createIterator(); 

while (iterator.hasNext()) {
    MenuItem menuItem = iterator.next(); 
}

Iterator iterator = lunchMenu.createIterator(); 

while (iterator.hasNext()) {
    MenuItem menuItem = iterator.next();
}
```

Iterators come pre-baked in with Java so as long as its a set of iterable objects. Vectors, LinkedLists, Stacks, Priority-Queues, etc. 
 
**Main Points**

1. Takes the job of iterating over an aggregate and encapsulates it in another object, ex having an iterator that does dfs or bfs in a tree or graph
2. When using an iterator, we relieve the aggregate of the responsiblly of supporting operations for traversing its data. 
3. Iterators provide common interfaces fro traversing the items of an aggregate. 
4. Removes duplication of iteration code

**note**: Can be overkill for simpler applications. 
<br>

## Composite Pattern
---
Intent: Allows compsoing objects into tree structures, treating individual and composed objects the same way. 

This pattern is best shown through code but essentailly you build a hierarchy of elements that can in themseleves, compose eachother. 


The textbook in chapter 9 shows you how you can utilzie the composite pattern to build a system and then use the iterator to go over all of it. 




<br><br><br>












