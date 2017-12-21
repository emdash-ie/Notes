# Info

* 24 lectures, 80%-20% split
* CA will be test and lab assignments
  * Test in the middle of the year (if at all)
* Some lectures will use the blackboard
  * At these we have to take our own notes

All assignments have an official deadline and a grace deadline, you can submit until the grace deadline.

# Content

* Class definitions
* Procedural and data abstraction
* Associations between objects
* Class hierarchies and inheritance
* Polymorphism and dynamic method binding

Assignments will never tell you how to implement something – you're supposed to figure that out.

# Book

* Head First Java by Kathy Sierra and Bert Bates. Second edition or newer.

## Optional Extra Books

* Effective Java by Joshua Bloch (get it if you like programming)
* Java Puzzlers by Joshua Bloch and someone else
* Head First OO Analysis and Design
* Design Patterns Elements of Reusable OO Software (very technical, get if you like OO design)

# What is Java?

* A programming language
* A compiler (the javac compiler)
  * Compiles to java byte code
* A virtual machine
  * Interprets java byte code

You use the command `javac filename.java` in the command line to compile a java file. This will produce a file `filename.class`.

Run the program by calling the `java` command on the main class (corresponds to the main function).

# Example Java

```java
public class Song {
  private String title;
  private String artist;

  public String getTitle() {
    return title;
  }

  public void playSong() {
    // play song
  }
}
```

* comment lines with `//`
* have to declare whether methods and attributes are `public` or `private` (or maybe others, but we will only study those two)
  * private classes are useful in some situations, but not at the top-level
* have to write return type of methods
* use `{}` to mark blocks
* `void` can only be used as a return type
* don't forget semi-colons

# `main()` in Java

```java
public class Main {
public static void main(String[] args) {
  // code goes here
}
}
```

* `static` shows that it is a class method (rather than an instance method), which is needed for the main method

# Printing

  System.out.println("Hello");

You can also print to error:

  System.err.println("Hello");

# Creating New Objects

For a class "Dog":

  Dog john = new Dog();

This creates a new `Dog` object and calls it "john". You need to have the first `Dog` because you're declaring the type of the object reference.

Dot notation used to access public attributes and methods:

  john.size = 2.0;
  john.bark();

# Objects in Java

The java language doesn't specify how objects are implemented – that's up to each compiler.

An object reference is like a remote control that can control different objects – they have a type, and so can only control objects of one type. You can't do this:

```java
Cat remote = new Cat;
House remote = new House;
[…]
```

But you can do this:

```java
Cat remote = new Cat();
Cat other = new Cat();
remote = other;
```

Two exceptions:

* `final` variables can only take 1 value, they can't be changed
* When an object reference's type is `Object`, it can take any object reference

Any object reference variable can be assigned the value `null`, which corresponds to nothing.

# About `public`

Here's a class with some mistakes:

```java
public class Balance {
    private int value = 1;
    private int numberOfTransactions = 0;

    public void add(int increment) {
      value = value + increment;
      numberOfTransactions = numberOfTransactions + 1;
    }
}
```

* Note that attributes (here `value` and `numberOfTransactions`) can be initialised in an explicit constructor or just in the class like this.
  * An explicit constructor makes sure they're all in one place though.

The fix is this:

```java
public class Balance {
    private static final int INITIAL_VALUE = 1;
    private int value = INITIAL_VALUE;
    private int numberOfTransactions = 0;

    public void add(int increment) {
      value = value + increment;
      numberOfTransactions = numberOfTransactions + 1;
    }  
}
```

This way, if the initial value of the first int needs to be changed later, it'll only have to be changed in one place.

# Note Class

```java
        /**
         * one-line description
         * @author
         */
```
This above is a javadoc comment. The first line should be a one-line description of the class. Since we're making a note class, that description might be, "A class to represent a short Note."

For our assignments, we need to write this, and we should put our name and probably student number in the author section.

These should be at the top of the class, and before public members.

```java
public class Note {
    private static int MAX_LENGTH = 40;
    private final String comment;

    private Note(final String comment) {
        this.comment = comment;
    }

    public static Note createNote(final String comment) {
        final Note result;
        if (comment.length() > MAX_LENGTH) {
            result = null;
        } else {
            result = new Note(comment);
        }
        return result;
    }

    public void print() {
        System.out.print(comment);
    }
}
```

* Normal comment blocks start with `/*` and end with `*/`. You can also comment a single line with `//`.
* Class names should be nouns, always written uppercase.
* Use spaces for indentation and not tabs.
* We want to guarantee that notes have to be short, have to be under a certain length.
* For this we need a maximum value. Rather than make this an instance variable, which will copy it for every instance, we're going to make it a class attribute, so all classes will point to the one value.
    * We use the identifier `static` to make class attributes.
* Names can contain letters and underscores, and other symbols.
    * We're to use the convention that class attributes are written in all-caps.
    * Our names should start with letters.
    * Names should be meaningful – one-letter names are not meaningful.
* We use `final` for the comment itself, purely by choice (we don't want the comments in this class to be changeable).
* `comment` is an instance variable, as each instance needs to have its own note.
* We're using a private constructor. We're gonna provide an API for clients, and that way we can easily change the details of our constructor and no-one will be harmed.
* We use `final` in the constructor to prevent people from making an assignment in the method call, which can be done in Java but is probably a mistake.
* Note that assignment is not equality.
* We're providing a class method for the service of creating a new note. If it was an instance method, we'd have a chicken-and-egg problem, as we'd need to have a note before we could use the method.
* Reminder that formal parameters are the ones written in class definitions. Actual parameters are the ones passed to a method from the outside.
* If given an invalid comment, we're going to return a null reference, and otherwise we'll return the new note.
* Much clearer to have only one return statement at the end of a function, rather than having more than one.
    * We'll use a result variable, and we make it final as a safeguard.
* Lines should not exceed about 76 characters, short lines should be used instead.
    * line continuations should be indented on the next line
* The braces are not needed for if or else blocks if there's only one statement in the block, but it's clearer to use them even then.
* We could implement the method for printing a note as a class method, but then we'd have to pass the note as an argument. It makes more sense as an instance method.
* We use `System.out.print()` rather than `System.out.println()`, as `println` adds a newline at the end, which we don't want.
    * In this we could have used `this.` to be clear, but we don't need it now, because the name doesn't conflict with a formal parameter name.
    * We usually use `System.err` instead of `System.out` to record error rather than print to the user.
    * The output and error can be redirected e.g. in bash:
        * `java Note > output 2> errors`
        * note `>` is shorthand for `1>`
        * This allows you to automate your testing, e.g. using `cmp`.
            * `If cmp output correct_output; then
                   #
               else
                   ...
               fi`
* It is possible to program in Java entirely using class methods, but then you must always pass the objects to the methods.
    * e.g. `public static void print(final Note note) {}`

# Call By Value Mechanism

There is often a question about this on the exam.

In Java, method calls use a call by value mechanism.

You can think about this as each method call making a copy of the actual parameters and using those copies for the formal parameters in the method.

Here's how you can think of the process:

* For each formal/actual parameter
    * create a fresh variable
    * usually stored on the stack at runtime
        * this mechanism is also used for blocks
* From left to right evaluate and assign the actual parameters
* Carry out the statements in the body of the method
* If there's a return value, substitute it for the method call
* Upon return remove the temporary variables

## Example

```java
public static int fib(final int n){
    if (n <= 1) {
        return n;
    } else {
        final int result = fib(n-1) + fib(n-2);
        return result;
    }

}
```

We can simulate a call to this method for an actual parameter of 2:

* put the actual parameter (in this case 2) on the stack, call it n
* now n is not <= 1, so we enter the else clause
* temporary variable `result` is created and put on the stack
* we now need to evaluate the two calls to fib to figure out the value to give `result`
* the new actual parameter (1) is put on the stack and labelled n
* this time n is <= 1, so we return n
* this value (1) is substituted for the first internal call to `fib`, and n is removed from the stack
* the next actual parameter (0) is put on the stack and labelled n
* again n is <= 1, so we return n
* 0 is substituted for the second internal call to `fib`, and removed from the stack
* result is evaluated (1), and returned
* the stack is cleared
