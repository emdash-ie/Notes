# Battleship (cont.)

```java
final int maxStartValue = MAX_CELL_VALUE - CELLS_IN_DOT_COM + 1;
final int cell = rand[…];
[…]
```

[check out alternative implementations in lecture notes]

This implementation contains a bug. You can see the specific bug in the book if you want to fix it.

# Class & Instance Methods

Class methods are owned by the class:

* There is one method/variable per class
* To access the method/variable you need the class
* Class attributes are for representing class state
* Class methods are for class behaviour

Instance methods are owned by instances:

* There is one method/variable per instance
* To access the method/variable you need the instance
* Instance attributes are for representing object state
* Instance attributes are for object behaviour

There are two ways statements can access an instance attribute:

* Direct – they have access to the object reference for the instance
    * For this you have to use dot notation: `reference.attribute`
* Indirect – they are in an instance method of the class that has been called on the instance
    * For this you don't need dot notation (unless there's ambiguity): `attribute`

# Notation for Classes

You can always write `class.method(arguments)`.

Inside the defining class you may write `method(arguments)`.

The same applies for variables.

# Inheritance

Two main advantages:

* increases ability to reuse implementation effort
* separates class-specific code from general code

Common code is put in a common, more abstract class (the superclass).

```java
public class Surgeon extends Doctor {
    public Surgeon() {
        worksAtHospital = true;
    }

    @Override
    public void treatPatient() {
        // specific patient treatment
    }

    public void makeIncision() {
        // additional behaviour
    }
}
```

* This is how to implement a subclass in java.

There are classes that support arrays that grow:

```java
import java.util.ArrayList;

final ArrayList<Animal> animals = new ArrayList<Animal>();

animals.add(new Dog());
animals.add(new Cat());
animals.add(new Hippo());
```

Enhanced `for` notation:

```java
for (Animal animal: animals) {
    animal.makeNoise();
}
```

* = for each animal in animals

## Hierarchy

Rather than make an `Animal` superclass and subclass every animal individually from that, it's useful to note that you can split animals into `Canines`, `Felines`, and `Others`, where canines have stuff in common and felines and stuff in common.

This way you have to write less code.

E.g. all canines can use the same roaming method, rather than writing that method for each individual animal class within that group.

* all canines eat meat
* all canines roam in packs

## Superclass Constructor

Calling the superclass constructor should be the first call in the constructor for the Canine class.

You do that like this:

```java
class Canine extends Animal {
    private static final boolean EATS_GRASS = false;
    public Canine(final String picture){
        super(picture, EATS_GRASS, hungerLevel);
    }
}
```

* `super()` calls the constructor for the superclass

# Interfaces

## Overloading

Two methods with the same name may overload each other. This is when you have two methods with the same name but a different signature. The signature of a method is its name and its argument types. A different signature might be:

* e.g. different numbers of arguments
* e.g. same number of arguments but at least one different type

Class constructors may also be overloaded.

### Example

```java
public void f(int x) {}
public int f(double x) {}
private void f(int x, double y) {}
public void f(double x, int y) {}
```

* Which method is called is determined by the types of arguments passed in. If you call `f()` and pass it one `int`, the first definition here will be called.

The following doesn't work:

```java
public void f(int x) {}
private int f(int y) {}
```

* return types or visibility isn't enough, the parameter numbers and types need to be different
* it's not enough to just call the parameters something different

## Constructor Overloading

Constructors can be overloaded, and they can call each other. You do this using `this(…)`. This should be the first call in a class constructor if it's used.

This lets you implement easy client-friendly constructors.

* A general constructor does the work
* The friendly versions call `this()`
* The friendly version may do additional configuration [check]

### Example

```java
public class NameObject {
    private static final String DEFAULT_NAME = "Object";
    private final String name;

    // Default constructor
    public NamedObject(final String name) {
        this.name = name;
    }

    // Special-purpose constructor
    public NamedObject() {
        this(DEFAULT_NAME);
    }
}
```

* The special-purpose constructor here allows you to have a default value if the constructor is called without an argument

# Motivation for Interfaces

Interfaces are similar to classes, where the API is defined, but not the implementation.

Say you have a sorting algorithm. The algorithm works for certain kinds of objects. Say it works for Integers and you'd like to use the algorithm for Doubles. Ideally you'd like to reuse the algorithm's implementation.

You use an interface for this.

* We could do this by overloading methods, but then we'd have the same code in multiple places, leading to changes having to be made in multiple places and mistakes propagating.

## Interfaces

```java
public int linearSearch(final Comparable[] things, final Comparable key){
    int index = 0;
    while ((index != things.length) && (things[index].compareTo(key) != 0)){
        index++;
    }
    return (index < numbers.length) ? index : -1;
}
```

* `Comparable` is an interface that defines `compareTo`.
    * If classes like `Double` etc. provide an implementation of `compareTo`, then they can be used in this.

### Contract

We want to restrict the type of parameter to make sure the parameter has the behaviour we need.

We do this using an interface, which is a multi-stage process:

1. define the interface (once)
2. implement the interface (any number of times)

### Defining the Interface

It's like defining a class. You provide the name of the interface.

You provide the API of the public instance methods.

You don't provide an implementation of the instance methods.

#### Example

```java
public interface Sellable {
    public double getPrice();
    public void sellTo(final Buyer buyer);
}
```

* Note there's no implementation

Once you've defined it, you can implement it.

### Implement the Interface

A class may implement an interface by overriding all methods defined in the interface. In order to be an implementation of the interface, it *must* override all methods define in the interface.

#### Example

```java
public class Cat implements Sellable {
    …
    private final double price;
    private Buyer owner;
    public Cat(…){
        …
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void sellTo(final Buyer buyer){
        // implementation
    }
}
```

## Substitution Principle for Interfaces

Say we have an interface called `Interface`. Say we have a variable `var` of type `Interface`.

At runtime you may assign `var` any reference to an instance of a class that implements `Interface`.

More generally, if a class implements `Interface` you may use its instances when an `Interface` object reference is expected.

This is called the *Liskov substitution principle*.

Say the `Dog` class implement the `Animal` interface. Then you can use a Dog when Java expects an Animal.

```java
Animal animal = new Dog();
```

## Substitution Principle for Classes

If a class extends `Clazz` you may use its instances when a `Clazz` object reference is expected. Say […]

```java
Animal animal = new Dog();
```

## Polymorphism

The term means the occurrence of [check].

With polymorphism the type of reference variable and of object may be different. An `Animal` object reference may reference a `Dog` object, as long as the `Dog` class extends the `Animal` class (or implements the `Animal` interface).

The type of the object, not the type of the reference, determines which instance method is called.

This is also known as late binding.

## Polymorphic Methods

Formal parameters and return types can be polymorphic. With formal parameter `Animal` the actual parameter may be a `Dog` type. The same for return types.
