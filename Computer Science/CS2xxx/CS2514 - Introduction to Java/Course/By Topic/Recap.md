# Objects

Java is an object-oriented language.

Objects have state and behaviour.

State: what objects know

Behaviour: what objects do

To implement object state we need to define instance attributes (and assign values to them).

To implement behaviour, we define instance methods.

Constructor ensures a class is equipped with the proper initial state.

The class:instance relationship is a 1:n relationship. Instances of a class may have different state by their instance attributes.

There are also class attributes – every instance of a class have access to the same value. These shouldn't be used to represent instance state.

## Polymorphism

If we have an object reference of type `Object`, then we can only call methods defined in the `Object` class, even if the object is, say, an `Integer`.

# Call-by-Value

Very important to understand the call-by-value mechanism.

Two types of parameter:

* formal parameters are the parameters inside a method definition

```java
public void function(int a, String b) {
    // a and b are the formal parameters
}
```

* actual parameters are the values passed to the method in a method call

```java
function(1, "hello");
```

To call a method with n parameters:

* define n fresh scratch variables (usually on the stack)

* evaluate the actual parameters from left to right

    * order is important because the expressions in the parameter list may have side-effects, e.g. `blah(var++, var--)`

        * evaluated left-to-right (if var is 2 beforehand), the parameters are (2, 3), evaluated the other way they're (1, 2)

* the results are assigned to the corresponding scratch variables

* evaluate the method body using the temporary scratch variables as the formal parameters

* upon return:

    * if there's a result, substitute it for the method call

    * remove the scratch variables from the stack

This also happens if you have local variable definitions inside a block:

```java
// var doesn't exist here
int f() {
    int var = 1;
    // var exists here
}
// var doesn't exist here
```

## Common Errors

* using instance attributes instead of temporary variables

```java
public class Clazz {
    private int result;

    private int f(int arg) {
        result = arg + 3 * arg * arg;
        …
        return result;
    }
}
```

* this won't work if f is recursive, for example, because the recursive call will share the same value for `result` instead of having its own variable

Should look like this:

```java
public class Clazz {
    private int f (int arg) {
        int result = arg + 3 * arg * arg;
        …
        return result;
    }
}
```

* local variables will also be on the stack, which is faster than the part of memory instance attributes will be stored in

# Call-by-Value Simulation

```java
public int fib(int n) {
    int result;
    if (n <= 1) {
        result = n;
    } else {
        result = fib(n - 1) + fib(n - 2);
    }
    return result;
}
```

Evaluating `fib(2)`:

* define initial state for the stack:

    * create a scratch variable on the stack to hold the argument

* evaluate the argument

* put the result into the scratch variable on the stack

* evaluate the function using the value 2 for `n`

* have to create space for `result` on the stack as it's a local variable

* enter the else clause

* evaluate `fib(n - 1) + fib(n - 2)`

* create space on the stack for the parameter for the first call

* evaluate `n - 1` and put the result in the parameter on the stack

[…]

# Inheritance

Aim to build a class hierarchy.

In the hierarchy there are superclasses and subclasses – subclasses inherit from superclasses.

A subclass can have no more than one superclass (in Java). A superclass may have several subclasses.

The superclass defines the common behaviour by defining public instance methods, and (usually) providing default implementations for these methods.

Subclasses may reuse these behaviours or provide new behaviour by overriding the methods.

Subclasses may also define additional behaviour.

## Usefulness

This is useful because you can share implementation defined in superclass – don't have to rewrite the code.

* makes sure any errors only have to be fixed in one place, too

* subclasses can alter behaviour of methods without breaking other classes that depend on the implementation

* the subclass—superclass relationship should be an "is-a" relationship, e.g. a cat is an animal

# Abstract Classes

Abstract classes can't be instantiated. This makes sense in an inheritance hierarchy where we want to put common behaviour in a class (e.g. Feline) but we don't want to be able to create instances of that class. Instead we want to create (e.g.) Cats, which are Felines (Cat is a subclass of Feline).

# Abstract Methods

Abstract methods are methods which are not implemented, but must be implemented in subclasses.

Note: methods that are overridden should be preceded by `@Override`, which checks to make sure you're overriding a method (catches typos)

# Final Classes

A final class is a class that can't be subclassed.

Many built-in classes are final, so that their behaviour can't be changed.

# Final Method

A final method can't be overridden.

# Interface

All method definitions in an interface are abstract. Classes which implement the interface must override all methods defined in the interface.

A class may implement multiple interfaces.

Names of interfaces are usually nouns/noun phrases or adjectives/adjective phrases.

Using interfaces to create class hierarchies makes very clean implementations but takes a lot of work to implement.


[missed a bit]

# Enums

## Int Enums

* flawed design pattern (design anti-pattern)

    * can compare apples to oranges

## Java Enums

```java
public enum Colour {
    RED, YELLOW, GREEN;
}
```

* java will automatically create objects for these constants

* get `toString()` conversions for free (converts to the name of the constant)

* use UPPER_SNAKE_CASE as they're constants

* get enumeration for free, and a method to return an array of possible values

```java
public enum Planet {
    MARS(10.0), EARTH(5.0);

    private Planet(final double mass) {
        this.mass = mass;
    }
}
```

* here we use a constructor for the enumerated types

* we can also define public instance methods which use this value

* you can also override methods for each type:

```java
public enum Student {
    EOIN(115600700) {@Override public int getMark(int assignmentNumber) {
        // implementation
    }};

    public abstract int getMark(int assignmentNumber);
}
```

* you can also have nested enums

# Generics

* parameterise a class over one or more types

* allows us to use the class for, e.g. a set of Integers or a set of Doubles

    * only have to define the class once, as a generic

* creating arrays inside a generic class is non-trivial and we're not expected to know it

```java
public class Reference<T> {
    private T reference;

    public Reference(final T reference) {
        this.reference = reference;
    }

    public T getReference() {
        return this.reference;
    }

    public void setReference(final T reference) {
        this.reference = reference;
    }
}
```

* can omit types if they can be inferred (diamond notation):

    * `final Reference<Integer> reference = new Reference<>(1);`

* could use a generic implementation by setting all types as `Object`, but then different types can go in the same class

    * also, when getting values, you'll need to cast whatever you get if you want to use it as another type
