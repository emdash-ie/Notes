# Nested Classes

* Java doesn't allow multiple classes at the top-level
    * have to nest subsequent classes inside the first
* nested classes can see attributes belonging to outer classes
    * does that include private attributes?
* you can have several inner classes
    * this is very useful for gui applications
        * main class represents state
        * inner class instances listen to events and can modify the main class state when an event occurs

# Local Classes

* You can define classes inside methods
    * more encapsulated than inner classes
* anonymous classes commonly used for extending a class or implementing an interface for a method parameter
* visibility doesn't matter because it only exists inside its method

# Static Classes

* defined at top level of another class
* no access to outer class instance methods or attributes

* these and GUIs will not be examined

# Anonymous Classes

* class without a name
* extends a single class or implements a single interface
* combines class definition and instance creation
    * can't have an explicit constructor
    * body should override all necessary methods

# Nested Interfaces

* interfaces that extend more interfaces

# Implementing Quicksort

* need to represent linked lists first
    * going to just facilitate adding at the front in constant time

See `Example.java` and `List.java`. There may be deliberate mistakes.

* args array collects command-line arguments given when calling `java`
    * could get arguments from file by `java Example `cat file``
* our quicksort will be a destructive sort
    * we will sort be re-arranging the references in the linked list
* use an inner class `Link` for the nodes
    * private class because clients of the list class should not know anything about the links
    * static class because it doesn't need to know about attributes in the outer class
* pointer for null to represent empty list
* using delegation in outer class for `add` and `print`
    * call respective methods of the `Link` class
* link class can be entirely private and we can still see everything about it in the outer class
