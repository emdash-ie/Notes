# Intro

Java makes sure the right types are passed to functions – if you pass the wrong type, the code won't run.

When declaring variables, you have to provide the name and the type:

```java
int favouriteNumber = 4;
// you can leave out the value and specify it later:
int undecidedValue;
```

* variables have a type, which determines the values they can hold

    * when an object reference's type is `Object`, it can hold any object reference

* any object reference variable can be assigned the value `null`, which corresponds to nothing

# Primitive Types

Primitive types correspond to byte patterns – they are not objects. Names of primitive types are in lowercase.

* whole numbers:
    * `byte`
    * `short`
    * `int`
        * this is the standard choice
    * `long`
* floating point numbers:
    * `float`
    * `double`
        * this is the standard choice

The `int` and `long` types are 2's complement integers.

# Object Types

Types starting with uppercase letters are object reference types. Object variables have objects.

You can use capitalised versions of primitive types as wrapper classes for primitive type values:

```java
Integer number = new Integer(1);
```

In general the primitives are best, as they incur less overhead, though you do get some additional methods from the wrapper classes.

## Wrapper Classes

Java has a wrapper class for each primitive type. These wrapper classes have getter functions to access the primitive value:

```java
    final Integer iObject = new Integer(42);
    final int val = iObject.intValue();
```

* primitive `bool` variables have values of `true` and `false`
* The object wrapper for that has values of `True` and `False`

## Autoboxing & Unboxing

Writing code to convert to and from wrapper classes is tedious, and increases the code size.

Java automates some conversions.

### Autoboxing

If you use a primitive type when Java expects an object, Java will autobox it to the corresponding wrapper class. For example, an `int` becomes an `Integer`.

### Unboxing

Unboxing is the opposite process, and happens when you use one of these objects where Java expects a primitive type.

### Caching

When autoboxing and unboxing, Java will cache a limited number (e.g. from -128 to 127 for Integers) of wrapper class values. In the following code, `firstNumber` and `secondNumber` point to the same object:

```java
Integer firstNumber = 1;
Integer secondNumber = 1;

// prints 'true' because both numbers have the same value
System.out.println(firstNumber.equals(secondNumber));

// prints 'true' because firstNumber and secondNumber point to the same object
System.out.println(firstNumber == secondNumber);
```
