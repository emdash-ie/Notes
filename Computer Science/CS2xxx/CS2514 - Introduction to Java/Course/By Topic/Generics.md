# Generic Types

* removing the need for runtime checks allows code to be made more efficient by the JVM

If interested, get book – [Naftalin and Wadler, 2009].

## Motivation for Generics

* an example where we might not know the type is if we read in an array index from the user
* the code on the slide will compile and then generate a runtime error
* want to tell the compiler "you can use the general implementation of the class, but there will only be objects of this type in the collection"
* ArrayList is a generic type

## Solution: Generic Types

* You assign a value to the type when you want to use a generic class
* Can also write `G<>` if the type can be inferred
* Avoids code duplication because you can implement the class once and use it for many types

## The Comparable Interfaces

* shallow comparisons just compare object references
    * get true if the references are the same
* deep comparisons compare attributes as well
    * e.g. two Integer objects might be deeply equal if they represent the same integer value

### Example

* if we had subtracted the two values, we might get overflow, which would damage the result

## A Simple Generic Class

* a class can depend on multiple types, which are comma-separated in the angle brackets

    * by convention use single upper-case letters to represent these types

        * keeps class definitions short

### Using the Generic Class

* can write `gi = new GenericClass<>(42);` due to type inference

## Wildcards with Extends

* won't be examined

### Example

* `nums.add(3.14)` isn't allowed because `? extends Number` guarantees that the objects in the ArrayList are all subclasses of Number, but doesn't tell us which subclass (they must all still be the same class)
    * so we don't know which type we're allowed add

* none of this is examinable

## MyList

* We implemented this as a recursive list class

    * code is available on moodle, lecture 13

Let's try to turn it into a generic implementation

* replace `ints` with `Comparables`

* do something, then have no more than one recursive call – tail recursion

* unchecked or unsafe operations is a serious warning

    * two objects may be of classes that implement Comparable but not be comparable to each other, e.g. an `Integer` and a `String`

    * we need to turn our list implementation into a generic class

## Generic Linked Lists

* T refers to the same class, so our list will always contain objects of the same class

* we had to use comparable things because we made quicksort an instance method

    * if we use a class method for this, then our list can contain objects that aren't comparable, but the quicksort method can only be used when the objects are comparable

# Iterators

An iterator is an instance of a class that implements the Iterable interface.

You can use the extended for loop with these objects.

* overriding the remove method is optional (but you have to override the other two)
