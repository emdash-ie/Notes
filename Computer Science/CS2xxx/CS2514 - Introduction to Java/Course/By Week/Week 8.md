# Assignment 1 Returned

* Only 1 or 2 people got 100%.
* Most common problems were using static variables to represent object state and not using constants to represent literal values specific to the problem.
* Don't put any printing statements in your constructor, so that clients can make instances without side-effects.

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
