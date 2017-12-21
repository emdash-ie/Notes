(this is my own attempt, I'll scan his tomorrow – mine are pretty close)

# Question 1: Objects and Classes

## (a) Define object state and object behaviour.

* object state is what an object knows

* object behaviour is what an object does

## (b) How do you implement object state and object behaviour?

* object state is implemented with instance attributes

* object behaviour is implemented with instance methods

## (c) Why can't a class attribute represent object state?

* a class attribute has one value per class, so each object of that class references the same value

* objects can't have their own state

# Question 2: Inheritance

## (a) Explain inheritance and polymorphism.

* Inheritance: If a class inherits from another class, objects of the inheriting class have methods from the other class as well.

* Polymorphism: If an object has type A, then it can be referred to as being of type A or of any type which is a superclass of A (any type A inherits from).

## (b)

* The "is-a" test is used to check relationships between objects for suitability for inheritance. If saying "An Object A is an Object B" makes sense, then it makes sense for an Object A class to inherit from an Object B class.

## (c)

* The `@Override` notation in Java throws an error if the marked method does not override another method. It is useful to help catch typos and other errors as early as possible.

## (d)

* To overload a method means to provide another implementation with an alternate signature (i.e. a method where the number of formal parameters or the types of formal parameters are different).  An example would be if we want to provide multiple constructors for an object, which allow defaults to be used for some or all of the state:

```java
public class Pencil {
    private static final int DEFAULT_LENGTH = 4;
    private static final String DEFAULT_WEIGHT = "HB";
    private static final boolean DEFAULT_RUBBER = false;

    private int length;
    private String weight;
    private boolean hasRubber;

    public Pencil(int length, String weight, boolean hasRubber) {
        this.length = length;
        this.weight = weight;
        this.hasRubber = hasRubber;
    }

    public Pencil(String weight) {
        Pencil(DEFAULT_LENGTH, weight, DEFAULT_RUBBER);
    }

    public Pencil(int length) {
        Pencil(length, DEFAULT_WEIGHT, DEFAULT_RUBBER);
    }

    public Pencil() {
        Pencil(DEFAULT_LENGTH, DEFAULT_WEIGHT, DEFAULT_RUBBER);
    }
}
```

# Question 3: Class Design

```java
public abstract class Book {
    private final String title;
    private final int pageCount;

    public Book(final String title, final int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public abstract double getPrice();

    public int getPageCount() {
        return this.pageCount;
    }

    public String getTitle() {
        return this.title;
    }
}

public abstract class PaperBook extends Book {
    private static final double PRICE_PER_PAGE = 0.15;
    private final double coverPrice;

    public PaperBook(final String title, final int pageCount, final double coverPrice) {
        super(title, pageCount);
        this.coverPrice = coverPrice;
    }

    @Override
    public double getPrice() {
        return this.getPageCount() * PRICE_PER_PAGE + this.coverPrice;
    }
}

public class Paperback extends PaperBook {
    private static final double COVER_PRICE = 1.0;

    public Paperback(final String title, final int pageCount) {
        super(title, pageCount, COVER_PRICE);
    }
}

public class Hardcover extends PaperBook {
    private static final double COVER_PRICE = 5.0;

    public Hardcover(final String title, final int pageCount) {
        super(title, pageCount, COVER_PRICE);
    }
}

public class EBook extends Book {
    private static final double PRICE_PER_PAGE = 0.1;

    public EBook(final String title, final int pageCount) {
        super(title, pageCount);
    }

    @Override
    public double getPrice() {
        return this.getPageCount() * PRICE_PER_PAGE;
    }
}
```

# Question 4: Iterators and Generics

## (a) Complete PartialIterableClass

```java
import java.util.Iterator;

public class PartialIterableClass implements Iterable<String>  {
    private String[] things;

    public PartialIterableClass(String[] things) {
        this.things = things;
    }

    public Iterator<String> iterator() {
        return new ThingsIterator(this.things);
    }

    private class ThingsIterator implements Iterator<String>{
        private int currentPosition;
        private String[] things;

        public ThingsIterator(final String[] things) {
            this.things = things;
            this.currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentPosition < this.things.length;
        }

        @Override
        public String next() {
            return this.things[this.currentPosition++];
        }
    }
}
```

## (b) Generic class Pair

```java
public class Pair<T, S> {
    private T firstItem;
    private S secondItem;

    public Pair(final T firstItem, final S secondItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
    }

    public T getFirstItem() {
        return this.firstItem;
    }

    public void setFirstItem(final T firstItem) {
        this.firstItem = firstItem;
    }

    public S getSecondItem() {
        return this.secondItem;
    }

    public void setSecondItem(final S secondItem) {
        this.secondItem = secondItem;
    }
}
