# Objects

* Java makes sure the right types are passed to functions.
* Every object in Java belongs to a unique class. Every object is an instance of a class.
* Every class has its own API. The API defines a common protocol and describes how to use the class:
    * The names of methods
    * types of arguments
    * purpose of arguments
    * return value
    * side effects
* Global variables are stored on a heap
    * Local variables within functions are usually stored on the stack
* When declaring variables in Java, you have to provide the name and the type. You may also provide the value.

## Types in Java

Java has a few numeric (primitive) types:

* whole numbers:
    * `byte`
    * `short`
    * `int`
    * `long`
* floating point numbers:
    * `float`
    * `double`

These are primitive types because they correspond to byte patterns (or something?).

For whole numbers, `int` is usually a good choice, unless you need a really big number.

For floating point numbers, use `double`.

## Operations on Numbers

Note the `int` and `long` types are 2's complement integers, so there is one more value less than 0 than there is greater than 0. The unary minus functions differently with this value.

## Primitive Types

A type starting with a lowercase variable is a primitive type. It corresponds to a byte pattern.

## Object Types

Types starting with uppercase letters are object reference types. Object variables have objects.

You can use capitalised versions of primitive types as wrapper classes for primitive type values:

```java
Integer number = new Integer(1);
```

In general the primitives are best, as they incur less overhead, though you do get some additional methods from the wrapper classes.

### Wrapper Classes

Java has a wrapper class for each primitive type. These wrapper classes have getter functions to access the primitive value:

```java
    final Integer iObject = new Integer(42);
    final int val = iObject.intValue();
```

* primitive `bool` variables have values of `true` and `false`
* The object wrapper for that has values of `True` and `False`

### Autoboxing & Unboxing

Writing code to convert to and from wrapper classes is tedious, and increases the code size.

Java automates some conversions.

#### Autoboxing

If you use a primitive type when Java expects an object, Java will autobox it to the corresponding wrapper class. For example, an `int` becomes an `Integer`.

#### Unboxing

Unboxing is the opposite process, and happens when you use one of these objects where Java expects a primitive type.

### Caching

Java caches a limited number of wrapper class values. So `new Integer(0) == new Integer(0)` evaluates as true – both object references point to the same object representing the number 0.

This guarantees shallow equality for small number of boxed values:

* If `o1.equals(o2)`, then `o1 == o2`.

This doesn't work for all numbers. `new Integer(666) == new Integer(666)` evaluates as false.

Caching is implemented because it saves memory, rather than creating a new object to represent 0 every time we make a new `Integer` with value 0.

In general caching works for small primitive values. Here are the ranges:

* `boolean`: `true` and `false`
* `byte`: 0-255
* `char`: `\u0000-\u007f`
* `short`: -128 – 127
* `int`: -128 - 127

### Using Variables in Methods

* You can't use variables that don't have a value yet. The following will give a compiler error:

    int number;
    int square = number * number;

### Comments

Comments have a couple of purposes:

* Describing the purpose of a variable of method.
* [more here]
* There are multi-line comments and javadoc comments. Javadoc comments are a special kind of multi-line comment.

### Variable Names

* By convention, variable names should be nouns.
* For non-constant variables, use `lowerCamelCase`.
* For constant variables, use `UPPER_CASE_WITH_UNDERSCORES`.
* Variable names should be descriptive.

### Variable Types

You can't do this because the types don't match:

```java
    Dog barney = new Giraffe();
```

### Working With Objects

Before you can use an object, you must construct it by calling a constructor for it. There may be several constructors with different signatures.

### Constructor Process

1. The new operator creates memory to represent the object.
2. The constructor uses its arguments to initialise the object.
[…]

### Method Declarations

To define a method you provide:

* The name of the method
* The return type
* The names and types of the formal parameters

```java
public int getWidth() {/* Implementation omitted. */}
```

* You use `void` for a method without a return value.

If the argument types are different, the names may overlap. This is called overloading:

* Multiple methods with the same name but different argument signatures, e.g. one takes one string, one takes two ints.

### Accessor and Mutator Methods

An accessor method returns information about an object without modifying the object, e.g. `rectangle.getWidth()`.

A mutator method modifies an object's instance variables, e.g. `rectangle.setWidth(4.0)`.

### State and Behaviour

State should be implemented by instance variables and behaviour by instance methods.

* Too much (object) state slows down the JVM.
* An object's behaviour should determine its state.

Start writing a class by thinking about its behaviour, then you can add state as required.

# Implementing a Tally Counter Class

We'll call the class `Counter`.

## Behaviour

* Increment the counter - `public void incrementValue()`
* Maybe reset the counter
* Return the current count - `public int getValue()`

## State

We can see from the behaviour that we need a counter value.

* Counter value - `private int value`

## Implementation

```java
// Class for representing tally counter objects.
public class Counter {
    // The current tally counter value
    private int value;

    // Returns the current counter value
    public int getValue() {
        return value;
    }

    // Increment the counter
    public void incrementValue() {
        value += 1;
    }
}
```

* Note that the comments should be javadoc comments.
* You may need auxiliary methods if methods are getting long.
* Explicit constructor not shown.
* Don't have to write `this.value` as there's no conflict.
    * If a formal parameter had the name `value` we'd have a conflict, for example.

## Instance Variables

* You write `tally.value` to access the value of a specific counter object (inside the class).

## Encapsulation

Instance variables should be private.

* Prevents malicious access to the variables
* Makes it easier to use the API
* Allows implementation to change without breaking code that uses it

For similar reasons, methods that aren't/shouldn't be part of the API should be private.

* Allows you to remove methods in future.

## Automatic Variables

Variables declared in methods are "automatic" – they only live for the lifespan of their block.

* Use these for intermediate computations rather than instance attributes.

# Arrays

Arrays are a special data type in Java. They are objects that contain other things.

There are two kinds:

1. Arrays consisting of primitive data type values
2. Arrays consisting of object reference values

The type of an array determines the type of its values.

* Before you use an array you have to create it.
    * When doing this you have to specify the array's length.
    * The length remains fixed.

You can put things into the array and retrieve things from the array.

You can only access arrays with index value:

* Only `int` index values are allowed
* They must be non-negative
* They must be smaller than the length of the array

## Initialisation

```java
final int[] numbers = new int[10];
System.out.println("");
[…]
```

## Default values

New arrays will be initialised with the default value for the type.

* boolean: `false`
* char: `\u0000`
* numeric: `0`
* object: `null`

## Arrays with Primitive Type Values

```java
byte[] nums = new byte[5];
nums[1] = 4;
```

## Arrays Do Not Grow

The length attribute of a java array is final. You can't assign any values to array.length.

Minimum size is 0 and maximum size is the max int size.
