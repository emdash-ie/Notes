# Limits to Comparison Sorting

We can't do any better than O(n log n).

All the algorithms so far are based on repeated comparisons between pairs of elements. These comparisons provide the biggest chunk of the complexity.

How many do we need to do?

* Consider an arbitrary sorting algorithm that uses *only* comparisons to decide on the relative placement of elements.
* Consider an arbitrary input list consisting of some permutation of n distinct elements
* Build a binary tree to represent all possible sequences of comparisons that out algorithm does to the input list.
    * At each node in the tree, branch left if the test is true, branch right if not
* […]

E.g. consider any comparison sort of a list of three elements V1, V2, and V3. At the start, we know nothing about their relative ordering. With each node, write down everything we have learned in the current path. Pick the questions randomly.

Suppose we do the same for input lists of n distinct items. Every permutation of the input given will end a different leaf node.

Proof by contradiction:

* Suppose two different input permutations end up at the same leaf
* The leaf determines the final order of the input elements by their initial position
* But in the inputs there must have been some case where Vi < Vj in one list and Vi > Vj in the other
* For those two positions, the leaf will definitely choose one of the two orderings
* So one of the two input lists must end up with an incorrectly sorted output
* But each leaf in our tree correctly sorts the input -> contradiction
* So two different inputs must end up at different leaves.

So there must be one leaf for every possible permutation of the n distinct items – n! different permutations.

There are n! different leaf nodes. There must be at least n! nodes in the tree.

The tree must have at least depth log(n!).

n! = n * (n-1) * … * 1

At least n/2 factors in that product are >= n/2.

n! >= (n/2)^n/2^

[…]

so log(n!) = Ω(n log n).

So the depth of the tree is Ω(n log n).

So there is at least one path to a leaf of length Ω(n log n), which means at least one sequence requires that many comparisons.

So you cannot get a worst-case running time that's less than n log n.

This is a lower bound for all comparison-based sorting. We cannot get a comparison-based sorting algorithm which has worst-case complexity significantly better than heapsort or mergesort.

(Therefore heapsort and mergesort are Theta(n log n) in the worst case.)

There are now only two options for improving sorting algorithms:

1. Accept that we are not going to get anything significantly better, and just look at improving the expected case, or making small improvements to the worst case.
    * Quicksort did this.
2. Find some way of sorting that is not based on comparing pairs of input elements.

# Non-Comparison Sorting

Suppose we knew that all the elements in our input list had values (or keys) within a limited range (e.g. [0, N-1]).

Use a bucket array with a bucket for each value in the range.

* Iterate through the list, and enqueue each item in the bucket for its value
* Once the list has been processed, take each bucket in turn and dequeue its items into the list in sequence

This takes 2n steps, and then the list is sorted.

## Pseudocode

[…]

* N steps to create each bucket
* 2n steps to read each element and add to the correct bucket
* N steps to process each bucket
* n assignments of elements back into the list

This is O(N + n).

If N is not big compared to n (i.e. if N is O(n)), the the complexity is O(n).

If N is O(n^2) or worse, then the complexity is O(n^2) or worse.

You can get linear-time sorting if you know the range.

The space requirement is also O(N + n).

## Stable Sorting

A sort is stable if items that are equal in the sort appear in their original order.

A stable sorting algorithm is one that keeps the original order of any pair of items that have equivalent keys.

Stable sort is preferable because then we know something about the order in the output.

Formal definition:

* Let x0, x1, … xn be the items in the list in original order.
* Let the key for each item xi be xi.k, and resort the list by the key.
* […]

### Previous Algorithms

* Our bubblesort, insertionsort, mergesort, and (because we used a queue for each bucket) bucketsort were stable
* Our selectionsort, heapsort, quicksort were not

## Lexicographic Ordering

* Add 'a' characters to the smaller string so that they are the same length
* Compare first position
    * If they're equal, compare the second position
    * etc.

### Lexicographic Sort of 2-Tuples

* Use a stable sort
* Sort by the second element of each tuple
* Resort by the first element of each tuple

## Radix Sort

Apply the last technique using bucket sort.

O(N + n) for the first sort. O(N + n) for the second sort.

### With Integers

Sort by the last digit, then the next, and so on until you get to the first digit.

This cuts N down to 9 for each sort, giving O(9 + n) for each sort.

## Summary

Bubblesort:

* stable
* slower than other O(n^2) algorithms
* never used

Selectionsort:

* Unstable
* Slow, rarely used

Insertionsort:

* Good on input that's close to being sorted
* Can be easily adapted to sort an online stream of incoming data
* Usually better than other O(n^2) algorithms, reasonably fast on smaller inputs
* Often used inside recursive algorithms when the input list gets below a certain size

Heapsort:

* Complex to write
* Can be written in-place
* Not stable
* Worse-case time complexity is O(n log n)
* Generally slower in practice than other O(n log n) algorithms

Mergesort:

* Easy to write for linked lists, difficult for a bottom-up array sort
* Difficult to write in-place
* Most implementations are stable
* Worst-case time complexity is O(n log n)

Quicksort:

* Idea is simple, but need to be careful when implementing
* Can be written as in-place
* Not stable
* Normally faster than O(n log n) algorithms
    * Worst case O(n^2) but average is O(n log n)
* For a long time, thought to be the best practical algorithm

Bucketsort:

* Not a comparison sort
* Simple to understand and implement
* Normally implemented to be stable
* Worst case is O(N + n), where N is the range of values to be sorted
* Requires O(N) additional space

Radix:

* Distribution sort
* Multiple iterations of bucket sort on different keys
* Stable
* Worst case time complexity not clear – based on number of items in the key words, and the number of items
* Not in-place
