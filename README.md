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

## 