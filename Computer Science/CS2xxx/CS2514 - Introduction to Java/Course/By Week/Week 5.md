# Interfaces

## Case Study

```java
public interface Animal {
    public void makeNoise(); /* No implementation */
    …
}

public class Cat implement Animal {
    …
    @Override
    public void makeNoise(); /* Must be implemented */
}
```

## Delegation

With interfaces we can simulate inheritance. It requires a lot more work but the resulting design may be better.

* The interface has no implementation, so you can't rely on a non-existing implementation.

We rely on object composition rather than inheritance.

We can re-use existing implementation efforts using delegation.

To implement the interface in a class `C`:

* We need a concrete class that implements the interface
* `C` implements the interface using a concrete class instance
    * A concrete class is one that can be instantiated (see below)
* `C` delegates the work to the concrete class instance

## Finally

* A class can only inherit from one superclass
* A class can implement multiple interfaces

# Abstract Classes

What happens if we create an Animal object (from the running example)? Some implementation is incomplete in that class, and what does it mean to have an object made from that class?

But we need the class for inheritance and for polymorphism.

So we make it an abstract class using a keyword `abstract`. This means that instances of the class can't be created.

```java
public abstract class Animal {
    …
}
```

* Now `Animal animal = new Animal()` will give an error.

Subclasses can also be abstract, e.g. the `Canine` and `Feline` classes from before.

A concrete class is a class that's not abstract.

You can still create polymorphic object references from an abstract class, and you can still create an array for a class:

[…]

## Abstract Methods

You can have abstract methods as well. They are defined in abstract classes and have no body:

```java
public abstract void roam();
```

* This allows you to specify a method that must be implemented/overridden in any subclass of the abstract class.

Abstract classes can have implemented methods as well.

## Encapsulate What Varies

Encapsulate what varies as objects that are passed to the superclass' constructor by the subclasses.

# Inheritance vs. Composition

Inheritance:

* lets us create subclasses – white-box reuse
* subclass inherits superclass behaviour
* subclasses can override superclass behaviour
* get code reuse for free
* cannot change behaviour at runtime
* violates encapsulation
    * subclass may rely on superclass implementation
    * subclass may break when superclass is changed

Composition:

* lets you compose classes – black-box reuse
* A client class may use an object
* you get code reuse but it takes more effort
* lets you change behaviour at runtime
* respects encapsulation
    * helps encapsulated classes focus on a single task

We should favour composition over inheritance, because it gives us more flexible design – we can encapsulate behaviour and we can change behaviour at runtime. This is the third design principle.

# The Strategy Pattern

* Defines a class of algorithms
* Encapsulates each algorithm
* Makes them interchangeable

See slides for an example, or google it (I think we may have to google it). Reference is Gamma et al, 2008.

# Enumerated Types

Many applications require groups of named constants. For example:

* A suit of cards: HEARTS, SPADES, CLUBS, and DIAMONDS
* Predefined colours: BLACK, WHITE, RED, BLUE, …

In Java named constants are called `enums`.

`Java enums` overcome most of the flaws of a pattern called `int enums`. `Java enums` are objects.

# Switch Statement

```java
switch (expression) {
    case (constant 1): statements 1
    case (constant 2): statements 2
    …
    default: default statements
}
```
By default cases will fall through into other cases, unless prevented with a `break` statement. Multiple guards means sharing statements among multiple cases:

```java
switch (expression) {
    case (constant 1):
    case (constant 2): statements 1
    default: default statements
}
```

# Int Enum Design Pattern

* Use constants with int value to represent subtypes

Problems with the `int enum` design pattern:

* Doesn't provide type safety (can compare things of different type)
* Maintainability:
    * programs with int enums are brittle
        * int enums are compile-time constants
        * they are compiled into clients that use them
        * client will break if enum constant changes
* ease of use:
    * int enums are difficult to use
        * it is difficult to translate them to Strings
        * no reliable iteration over all allowed values
* namespace
    * int enums have no private name space

# DIY

```java
public abstract class Beef {
    public static final Beef SHANK = new Beef() {
        @Override public double price() {return 1.0;}
    };
    public static final Beef SIRLOIN = new Beef() {
        @Override public double price() {return 2.0;}
    };
    public abstract double price();
}
```

[check this bit, especially about anonymous classes]

[check the serious problem]

# Java Enums

```java
public enum Apple {FUJI, PIPPIN}
public enum Orange {NAVEL, TEMPLE, BLOOD}
```

Each of these is a class. Each constant in braces is an instance of that class.

For each constant in any enum class, Java automatically defines one public final class attribute.

Name of the constant in class is class.constant.

All Java enum constructors are (implicitly) private.

All instance methods are final, except for `toString()`.

## Advantages

Java enums are type-safe.

Our programs are more maintainable because the enums aren't compiled as constants into clients. Rearranging values doesn't break clients.

Translating to strings is easy – `toString()`. Iterating over all enums is easy – `values()`.

Enum classes have a private name space.

## Methods in enum classes

* `compareTo(that)`
    * compares this enum with that one for order
* `equals(that)`
    * shallow equality just compares object reference values
    * this allows us to implement deep equality
* `hashCode()`
    * returns a hash code for this enum
    * worth studying
* `toString()`
    * returns the name of this enum constant
* `name()`
    * returns the original name of the enum
    * e.g. if `toString()` has been overridden
* `ordinal()`
    * returns the ordinal of this enum
    * e.g. if we have three apples, the first will have the value 0, the second the value 1, etc.

## Java Enums are Objects

[…]

## Implementing the Planet Class

```java
public enum Planet {
    MERCURY(3.303e+23, 2.439e+6),
    VENUS(…),
    …;

    Planet(double mass, double radius) {
        …
    }
}
```

* Here we're calling the Planet constructor for each planet we're describing.

### Specific Behaviour

Our Planet application is very well behaved – all method results depend on input and attributes only.

This is not always the case: consider a calculator application:

* There are four operations PLUS, etc
* we'd like to apply operations to doubles and get the result:
    * `double apply(double first, double second)`

The result also depends on the enum constant.

Common implementation is to use a switch on `this` in `apply` to match all possible values. However, if we add a new operation, we have to change the implementation of `apply`.

Better way to do it is to define an abstract method `apply` n the `Operation` class, and then provide an implementation for `apply` with each constant [see slides].

[left out a bunch – he's going very fast]
