# Partially Filled Arrays

You must fill the array before you can use it. You usually start filling at the bottom (index 0). Then fill the next position and so on.

```java
final Scanner scanner = new Scanner(System.in);
final int[] values = new int[scanner.nextInnt()];

int size = 0;
int next = 0;
while ((size != values.length) && (next >= 0)) {
    System.err.println("Next value (negative value to stop): ");
    next = scanner.nextInt();
    if (next >= 0) {
        values[size++] = next;
    }
}

final double percentage = 100.0 * size / values.length);
System.out.println("Percentage filled is " + percentage);
```

* We use `System.err` for the user prompts so that we can suppress that if desired and still get the output message.
    * Say we're testing with a stream of numbers and we don't need to be instructed about them, but we still want to see the result.
* No negative indices for arrays.
* Don't forget to initialise arrays. Operations on `null` cause runtime errors.

## Parallel Array Implementation

```java
public class AccountManager {
    private final String[] owners;
    private final double[] balances;

    public AccountManager(final int size) {
        final Scanner scanner = new Scanner(System.in);
        owners = new String[size];
        balances = new double[size];
        for (int index = 0; index != size; index++) {
            owners[index] = scanner.next();
            balances[index] = scanner.nextDouble();
        }
    }
}
```

## Class-Based Implementation

* Create an `Account` object to store in the array, which will hold the owner and the balance each time.

## Comparison

The parallel array implementation is not safe:

* Parallel array clients need access to all arrays:
    * `withdraw(owners, balances, nr, amount);`
    * This gives the client access to all account details
    * They can modify the array.
    * This violates encapsulation.
* Direct access for Account clients:
    * `account.withdraw(amount)`
    * Much safer.

# Designing Classes

Methods are good because:

* They provide reusable computations
* They're building blocks of complex computations
* Calls are the only mechanism to change private variables.

## Pass-by-Value Mechanism

Makes copies of the actual parameters.

1. Create a fresh variable for each parameter
2. For i from 1 to n:
    1. Evaluate the ith actual parameter
    2. Assign the result […]
[…]

* When putting automatic variables on the stack, the order they go in depends on the JVM.
    * In exams you can write them in any order, but make sure you label them correctly.

## Class Design

How do we choose the classes, attributes, and methods?

* Note: problem specifications for assignments will sometimes be incomplete

Look for actors in the specification. These actors do things and own things. The things they do are methods and things they own are attributes. Typically you're looking for nouns that are the subject/object (I forget which is which) in a sentence.

### Toy Class

```java
public class Toy {
    private final String name;
    private boolean used;

    public Toy(String name) {
        this.name = name;
        used = false;
    }

    // Getter and setter methods omitted.

    @Override
    public String toString() {
        return "Toy[name = " + name + "]";
    }
}
```

### Hand Class

```java
public class Hand{
    private final String type;
    private Toy toy;

    public Hand(String type) {
        this.type = type;
        toy = null;
    }

    public void take(final Toy toy) {
        // We cannot take a Toy if the Hand is full
        if (isFull()) {
            // output error
        } else if (toy.getUsed()){
            // We cannot take a used Toy

        } else {
            // Take to.
            // Formally mark toy as used
            toy.setUsed(true);
        }


    }
    public void drop() {
        if (isEmpty()) {
            // We can only drop a toy if we have one
            // Error message
        } else {
            //Drop our current toy
            // Formally mark toy as free
            toy.setUsed(false);
            toy = null; // check this
        }
    }

    public String getType() {
        return type;
    }
    public boolean isEmpty() {
        return toy == null;
    }
    public boolean isFull() {
        return !isEmpty();
    }
    […]
}
```

* top-down approach means using methods in others before we write them, in order to figure out that we need to write them
* Using strings for marking "left" and "right" is not ideal, because the compiler can't help you if another string is passed.
    * Another solution (still not ideal) is to introduce class constants defined to allowed values, but there are still problems.
        * These `LEFT` and `RIGHT` constants should be moved to the Hand class.
    * A better way is to define an object class that only has the two acceptable values, this way you can use the type to guarantee that only allowed values are passed.

## Designing Classes (cont.)

* `for` and `while` loops
* `invariants` - comments about object relationships
* linear search algorithm
    * proof of correctness with `invariants`
* top-down approach:
    * start with a description in English, revise the implementation step by step until you end up with Java

### `for` loop

```java
for ([initialisation]; [condition]; [update]) {
    [stuff]
}
```

* The initialisation is called first
* the condition is checked at the start of each loop
* The update is carried out at the end of every iteration
* be careful of 1s and ls looking similar
    * you should minimise the scope of variables to ensure that it only covers the loops
        * do this by declaring your counters in the initialisation section of the loop
        * this variable will only exist for the lifetime of the loop

```java
// do this:
for (int digit = 0; digit <= 1; digit++){

}
//not [insert]:
```

### `while` loop

```java
while ([condition]) {
    [stuff]
}
```

* you don't need braces if there's only one command in the loop, but you should use them to make things clearer

### `do while`

```java
do {
    [statement]
} while ([condition]);
```

* This will execute the statement before checking the condition, instead of checking first and doing the statement after, each time.
* It's equivalent to putting the statement in one extra time before a `while` loop.

### Invariants

Invariants relate the values of the variables in your program.

* They make the relationships explicit (a form of documentation)
* They may help you prove the program is correct
* They help you maintain your program
    * Easier to remember what your code is meant to do

You should state invariants as comments in your programs.

```java
if ([condition]) {
    // [condition]
} else {
    // ![condition]
}
```

* listing the condition in the comment helps make it clearer
* also with the `else`

```java
// [condition1]
while ([condition2]) {
    …
    // [condition1]
}
    // ! [condition2]
    // [condition1] && ![condition2]
```

```java
in i, sum;

i = 0;
sum = 0; // i <= 100 && sum == ) + 1 + … + i
while (i < 100) {
    i = i + 1;
    sum = sum + i; // i <= 100 && sum == 0 + 1 + … + i
}
```

### Linear Search

```java
int index = 0;

while (index < array.length && !satisfies(array[index])) {
    index++;
}
```

* We can put our search condition in the while condition like this
* You can prove that it's correct with invariants
* Not sure which ones we should put in here.

### Battleship

Simplified version:

* Only have one "dotCom"
* Represent it as a 3-value int array
    * Values are location cell numbers
    * Location cells are consecutive numbers between 1 and 7
* User guesses location cells
* If the user guesses right we announce a hit
* If there are three hits
[…]

Steps:

1. Figure out what the class is supposed to do
2. List the instance variables and methods
3. Write prep code for the methods
4. Write test code for the methods
    * helps clarify what the methods needs to do
    * helps design the method API
    * test code acts as documentation/contract
    * by writing test code early, we can use it early and eliminate bugs
5. write real code for the methods - write the class
6. debug and implement as required

* Note that these steps were developed before JUnit testing, which can be done instead of writing the test code.
* Read the book to find out how to write test code

### Code

```java
public String checkYourself([…]) {
    final int cell = Integer.parseInt(guess);
    final boolean found = findLocation(cell);

    hits += (found ? 1 : 0);
    // ternary operator - if found is true, the expression becomes 1
    //      if found is false, the expression becomes 0
    // So this increments hits if found is true

    return getResultAsString(found);
}
```

Need an instance variable that generates a random number. This comes from the random class:

```java
Random()
// There are a few constructors
Random(seed)
// seed must be a `long` value
// allows you to reproduce the same sequence of random numbers, e.g. for testing
```

```java
rand.nextInt(maxStartValue);
// this gives a random value up to but not including maxStartValue,
// assuming you've created the variable `rand` already
```
