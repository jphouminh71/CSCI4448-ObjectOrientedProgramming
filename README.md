# Head First Design Patterns (Java 14)
---

"Program to an interface" - the declared type of variables should be a supertype, usually an abstract class or interface, so that the objects assigned aren't tied to a specific class

```js
    Animal animal = new Dog(); 
    animal.makeSound();   // bark() 
```
<br>

### "Delegation is favored over inheritance."
* Not only does it let you encapsulate a family of algorithms into their own set of classes, but it also lets you change behavior at runtime. 

<br>

## Strategy Pattern  <br>
--- 

**Definition**: defines a family of algorithms , encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from the clients that use them. 

* Allows you to encapsulate different behaviors or Algorithms that can be dynamically swapped for an object to use. By creating a delegate to different algorithms and behaviors it decouples the need to refactor specific classes that use the same algorithms / behaviors. 

"We could have just as easily use the same techniques for a set of classes that implement the different ways to compute sales tax for each state".  <br>
* States are the "Ducks" 
* Tax Computation Algorithms are the different ways the "duck" can "Fly" 

## Observer Pattern 
--- 

