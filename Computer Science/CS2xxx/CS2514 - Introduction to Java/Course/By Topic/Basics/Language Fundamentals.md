# Java Basics

* comment lines with `//`

    * comment blocks with `/*` to start and `*/` to end

* have to write return type of methods

* use `{}` to mark blocks

* `void` can only be used as a return type, not as the type of a variable

* don't forget semi-colons

* braces not needed for `if` or `else` blocks if there's only one statement in the block

    * though it's clearer to use braces

* don't need to use `this.` for instance attributes when there's no ambiguity

    * if the name clashes with a parameter, we'll need to

# From the Command Line

* use the command `javac filename.java` (in bash) to compile a java file – produces a file `filename.class`

* run a class with the command `java filename`

# Style

* line length should be below 76 characters

    * line continuations should be indented

* class constants should be named in UPPER_SNAKE_CASE

    * class constants are attributes which are `private`, `final`, and `static`

* class names should be nouns, in UpperCamelCase

* attributes and methods should be in lowerCamelCase

* use spaces for indentation (not tabs)

* should have one exit point from a function

    * so one return statement

    * create a variable called result and give it different values in different branches of the function, but return it at the end

# Main Method

Main method of a class will be run when the class is run. It must have this structure:

```java
public static void main(String[] args) {
    //code
}
```

Typically this is put inside its own `Main` class:

```java
public class Main {
    public static void main(String[] args) {
      // code goes here
    }
}
```

# Printing

Can print using these methods:

```java
System.out.println("Hello");
System.out.print("Hello");
```

* `println()` will print a whole line
* `print()` will only print what it's given

You can also print to error in the same way, which can be useful for showing things during writing/debugging but not during normal operation:

```java
System.err.println("Hello");
System.err.print("Hello");
```

# `public` vs. `private`

* public classes, methods, and attributes can be accessed from any class

* private methods, attributes, and inner classes can only be accessed by other members of their own class

    * usually don't use private classes at the top level

* all attributes should be private (encapsulation)

# `final`

* a final class can't be subclassed
* a final method can't be overridden
* a final variable can't be changed
    * though if it is an object reference, the object can still be changed though the reference can't (this includes arrays)

# `static`

* marks methods and attributes as class methods and class attributes

* class attributes only exist in one place, and each instance of a class accesses the same value

    * unlike instance attributes, where each instance has its own copy of the value

# Javadoc

Javadoc is a type of comment used for documentation – similar to docstrings in python. It's placed before the thing it's associated with:

```java
/**
 * Represents a short note.
 *
 * @author Noel Bourke
 */
public class Note {
    // implementation
}
```

* generally (Google style guide) you comment all public classes and all public members of those classes
* there are special tags `@author`, `@param`, `@return`, and more – all used as author above

# Formal Parameters vs. Actual Parameters

* formal parameters are the parameters inside a method definition

* actual parameters are the values passed to the method in a method call

# Call-by-Value Mechanism

To call a method with n parameters:

* define n fresh scratch variables (usually on the stack)

* evaluate the actual parameters from left to right

    * order is important because the expressions in the parameter list may have side-effects, e.g. `blah(var++, var--)`

* the results are assigned to the corresponding scratch variables

* evaluate the method body using the temporary scratch variables as the formal parameters

* upon return:

    * if there's a result, substitute it for the method call

    * remove the scratch variables from the stack

        * local variables defined inside a block will also be removed
