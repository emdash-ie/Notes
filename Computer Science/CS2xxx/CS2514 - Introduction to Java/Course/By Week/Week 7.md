# Linked Lists (cont.)

* We continued implementing Quicksort with linked lists in Java (see `../Implementing Quicksort`).

# Assignment 1

* We'll get assignment 1 back on Monday.

* Everyone made similar mistakes for the assignment

    * Some we definitely should have known not to make

* Should have comments

* Should have sensible variable names

# Recursion

* a recursive function does not *have* to call itself

* Lower order computations = computations that are smaller in some way

## Controlling the Size

## Proof by Contradiction

## Computing Factorials

## Fibonacci

* If you want to become famous, don't become a pop star or celebrity – those don't last. Become a composer or mathematician instead.

### Tracing the Calls

* This is an inefficient method, as there are duplicated calls

    * becomes exponentially slow

## Towers of Hanoi

### Intermediate State

* Often useful to first try to find a recursive solution, and if that's inefficient, then change to an iterative solution

### Alternative Solution

* Ranges are empty for the base case

### Java

Note you can find the number of the third peg by subtracting the sum of the other peg numbers from the sum of all of the peg numbers.

* moveDisk just prints the move

# Binary Search

* return negative number if the element isn't found

* `mid = (lo + hi) / 2` causes rounding error if

    * lo is maximum int value and hi is value just below

    * gives negative result

## Comparable Interface

* lots of classes already implement this

## Tail Recursion (For Fibonacci)

* work up from the start values (0 and 1) until you get to the number you want

    * prevents duplication of calls

So:

1. Compute first pair
2. If not there yet, compute next pair
3. Repeat until there

A method is tail recursive if it has no more than recursive calls at the current level. (?)

Implementing this is a suggested exercise. You can then easily turn it into an iterative solution.

```java
private static int f(P p, int pos) {
    int result;
    if (pos == 0) {
        result = p.get(1);
    } else {
        result = f(new P(p.get(1), p.get(0) + p.get(1), pos - 1));
    }
    return result;
}
```
