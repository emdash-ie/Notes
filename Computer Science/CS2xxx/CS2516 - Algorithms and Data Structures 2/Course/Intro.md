# Info

This course will take what we did in CS2515 and expand on it:
  * Bigger data structures
  * Harder problems

* All programming examples and assignments will use Python 3.
* 80% final exam, 20% CA and in-class tests
* Labs Tuesday morning, 09:00–11:00
* It's assumed you're spending at least 8 hours per week per 5 credit module.

## Book

No required textbook. Recommended textbooks:

[get from notes]

# Overview

1. Revision of CS2515
2. Complexity and analysis
  * Will formalise complexity more than last term
3. Sorting and selecting
4. Graphs
  * e.g. maps or social networks
5. Sample algorithms in text processing, matching, and memory management

# Revision of CS2515

Almost everything in Python is an object, stored in some location in memory.

There are 2 underlying ways of implementing data structures:

* Array-based
* Linked structures

## Array Implementations

An array is a sequence of items all of the same type, laid out one after another in a fixed-size chunk of memory (i.e. a sequence of bits). Because we know the size of each item, we can compute the location of any item in the array and jump straight to it in constant time.

But, if we want to add items beyond the fixed size, we have to create a new array of the right size and copy the data across.

## Linked Structure Implementations

* A node is an object containing references to an item and to other nodes.
* A collection of nodes referring to each other creates a data structure, but where each node can be placed anywhere in memory.
* To access a particular item, we need to iterate through a chain of references.
* There's no limit on the size (apart from the total memory in the system).

## Main Linked Structures in CS2515

1. Linked list – a linear sequence
  * If we are given a location it's easy to update, but it's slow to search
2. Binary search tree
  * Reasonably fast to update and fast to search (assuming the tree is balanced)
3. AVL tree – a balanced binary tree
  * Reasonably fast to update and fast to search because it's always balanced

## Two Types of Tree in CS2515

1. Binary search tree – use it for search
  * for each node, all left descendants are lesser, and all right descendants are greater
2. Binary heap – use it for priority queues
  * for each node, all descendants have lower priority (and the tree is full, except possibly for the lowest level, which is full from left up to a point and then empty)
  * the most efficient implementation uses an array-based list, not a linked tree

## Maps and Hashing in CS2515

* Used an array-based list, possibly with other lists in each cell.
* Maps are good for fast lookup and storage
  * The key for a value helps tell you where it will be stored.
  * Almost always fast lookups by controlling the size of the underlying array, but occasionally can be slow (long chains, large buckets, etc.)

# CS2515 Exam

* Most of the exam was bookwork.
* There were 3 questions
  * Question 1 on linked lists and stacks
  * Question 2 on binary heaps
  * Question 3 on maps and hashing
  * In general question 1 was done best.

## Main Issues

### Final part of Q1

This was the MinStack.

The best solution is to use two stacks, where the value in the second stack is the minimum value at the time of the corresponding value in the first stack.

E.g. if you push a value that's not smaller than the top of the second stack, you push the value on the top of the second stack onto it again. When popping from the main stack, you also pop from the second stack.

When doing these unseen questions, make sure that your solution works.

Many people used a variable to track the min, and never explained that you then need to search the stack if you pop the min.

### Question 2

Question 2 was about binary heaps rather than binary search trees – some people answered only on binary search trees.

Either people didn't read the question carefully enough, or didn't cover it when revising.

### Question 3

* This was all bookwork, but from the last couple of lectures.
* This wasn't done as well as question 1.

Either people didn't understand it, or didn't cover it when revising.

# Recursion

## Activation Records

When Python executes a function, it creates an activation record which stores:

* variables passed in as parameters
* local variables created inside the function
* the point in the function source code it has reached

It pushes this onto a stack of activation records.

When it finishes executing the function, it:

* pops the record off the stack and deletes it, remembering any return value
* moves to the record now on top of the stack, and returns to the point in the source code it had reached, and passes in the return value

Note global variables are stored somewhere other than this stack, and can be accessed at any point.

* If you want to use a value returned from a function, every path through the code must reach a return statement in the function.
  * Otherwise the value will be deleted when the function is finished.

## Recursive Programs

Every recursive function must have two things:

* A base case
  * This is a non-recursive code block that returns [check]
* A recursive call with parameters that bring you closer to the base case.

## Memory

With recursive functions on big data structures, you may end up with many activation records, taking up a large amount of memory.

## Unbounded Recursion

E.g. if you're not moving towards your base case in a recursive function.

Unbounded recursion uses a lot of memory very quickly, and behaviour is technically unspecified, as you may overwork the CPU.

Python avoids this by putting a limit on the call stack. It's normally set at something like 100 calls, but you can change this if you need to.
