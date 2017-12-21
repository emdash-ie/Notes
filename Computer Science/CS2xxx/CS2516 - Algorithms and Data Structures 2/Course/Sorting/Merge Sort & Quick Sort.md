# Merge Sort

Heap sort had complexity O(n log n) and sorted in-place. Is it work looking at more sorting algorithms?

* Are there algorithms with better worst case complexities?
    * Even with the same complexity, maybe the lower order terms are better?
* Are there algorithms with better average complexity?
* Is it worth it using in-place sorting?
* Are there other problem-solving strategies we could look at?

## Divide and Conquer

This is a general problem solving strategy used throughout computing.

* If a problem is simple, solve it in a single step
* If a problem is too complex to solve in a single step:
    * Divide it into multiple pieces
    * Solve the individual pieces
    * Combine the pieces to get a solution

Typically this is implemented using multiple recursion.

### Sorting

* If an input list is of size 1 or 0, do nothing
* Otherwise:
    * Split it into two almost equal sublists
    * Sort the first sublist
    * Sort the second sublist
    * Merge the two sublists into a combined list

All the work is done in the merging.

#### Merging

* Say you have two sorted lists of size 4 to be merged into a sorted list of size 8.
* Point at the first two elements
    * Put the smaller into the new list and move its pointer forward
* Look at the two elements you're now pointing at
    * Put the smaller into the new list and move its pointer forward
* Repeat until finished

## Complexity

Merge sort is O(n log n), which is the same as heap sort. It's also O(n log n) in space complexity.

## Alternative Analysis: Recurrence Equations

The base case is O(1). Merge is O(n), so we will write it as `c*n`.

Time to sort a list of length n (`t(n)`) for n > 1, is then:

```
t(n) = 2*t(n/2) + c*n
```

But `t(n/2)` must then be 2*t(n/4) + C*n/2, so we can plug it in recursively.

So t(n) = `2^k * t(n/(2^k)) + kc*n`.

This eventually stops when the list is of size 1, which happens when k = log_2(n). But t(n/(2^k)) = t(n/(2^log_2(n))) = O(1) since list is length 1.

So `t(n) = n + log_2(n)*c*n which is O(n log n)`

This kind of analysis is needed for some algorithms.

## Alternative Merge Sort Implementations

1. Implementing merge sort on linked lists is probably easier.
    * Don't have to create new lists.
2. Merge Sort on arrays can be implemented bottom-up rather than top-down, using just O(n) extra space:
    * Create a new empty list of size n, called list 2
    * For each pair of cells in the original list
        * Merge into sorted pair in corresponding cells in list 2
    * For each successive group of 4 cells in list 2
        * Merge into sorted group of 4 in corresponding cells in original list
    * Repeat

# Quick Sort

Worst-case complexity is worse than the last couple we've looked at, but on average it's much quicker.

With merge sort all the work was done in the combination – dividing was easy. What if we put all the work into clever dividing, and let combining fall into place?

Think of building a binary search tree from a list, and then doing an in-order traversal to create the sorted list.

* building the tree:
    * best case is O(n log n)
    * worst case is O(n^2)
* traversing the final tree:
    * O(n)

Procedure:

```pseudocode
make the first element of the list the root of a tree
for all elements in the list
    if they are less than root
        put them in a left list
    else
        put them in a right list
    if the left list is not empty
        build the root's left sub tree from it
    if the right list is not empty
        build the root's right sub tree from it
```

Quick sort applies this procedure but without actually building the tree.

Procedure for doubly-linked lists:

```pseudocode
quicksort(start, end):
    if start.next != end and start != end:
        pivot = start
        node = pivot.next
        while node is not the end
            nextnode = node.next
            if node.elt < pivot.elt
                move node in front of pivot
                if first move
                    start = node
            node = nextnode
        quicksort(start, pivot)
        quicksort(pivot.next, end)
```

## Array-based Lists

We want to be able to do it on arrays, in-place. We need to avoid shuffling elements along the array.

* When dividing, search from both ends, and swap positions of any elements that are on the wrong side of where the pivot will go.

```pseudocode
sort(list, pivot, end):
    while searches not crossed
        search right from pivot for a bigger item
        search left from end for a smaller item
        if searches not crossed
            swap items
    swap pivot with small item
    sort(list, small, pivot)
    sort(list, pivot+1, end)
```

## Analysis

* Each level of the tree takes at most n comparisons, and at most n/2 swaps
* If the input list is sorted, then worst case depth of the tree is n, […]

## Median Pivot

We know a balanced tree has depth log n, when each node has equal numbers of descendants on the left and the right. So if we could choose a pivot each time that splits its sublist into two equal parts, our quicksort tree would also be log n depth, and the runtime would be O(n log n).

We need to pick the median as the pivot every time.

There's an algorithm ("median of medians") to find the median of an unsorted list in time O(n), but it's complicated. You could run that first and in theory that'll give quicksort a worse-case bound of O(n log n). In practice, though, it's very slow, as the terms in the quadratic for "median of medians" are huge.

## Random Pivot

Choosing a random pivot will destroy the bias from getting a sorted or near-sorted list.

It can be shown that the *expected* running time for a random pivot selection is O(n log n). The worst case is still O(n^2), since it's still possible the randomness won't help in certain cases, but it's much less likely.

A simpler solution is to create a random shuffle of the top level list, and then call the existing algorithm.

This adds `n` calls to `randint` and `n` swaps. This doesn't change the expected runtime or the worst-case bound.

In practice, quicksort is still faster than merge sort or heap sort with the random shuffle most of the time.
