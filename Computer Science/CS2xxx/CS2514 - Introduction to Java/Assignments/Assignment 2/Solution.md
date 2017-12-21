# Overview

* lots of different mistakes made

* will be implementing today and will point out mistakes

* we won't do the exact same thing, but most points will apply

# Notes

* need (understandable) javadoc comments that describe the API

    * want to be able to understand those comments without understanding the class

    * don't describe implementation in general

* may also need comments inside your code for describing algorithms etc.

* don't implement the frame as a boolean `hasFrame`:

    * attribute `hasFrame` is not used at all

```java
public abstract class Bike {
    // this is a bad technique – don't use it
    private boolean hasFrame;

    public Bike() {
        hasFrame = true;
    }

    public void printComponents() {
        System.out.println("I have a frame");
    }
}
```

* don't represent the frame as a String

    * no type safety – the `frame` variable can hold a string "Wheels"

    * using only a Component class doesn't fix this either

    * instead we should have a class hierarchy for Components

```java
public abstract class Bike {
    // this is a bad technique – don't use it
    private String frame;
    private String wheels;

    public Bike() {
        frame = "Frame";
        wheels = "Wheels";
    }

    public void printComponents() {
        System.out.println(wheels + " " + frame);
    }
}
```

* `printComponents` method in the Bike class shouldn't be abstract because we want to reuse it

# Implementation

* see files in Java folder
