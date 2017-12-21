# Sorting

Sorting is important because it's everywhere. Physical sorting (mail, cards in card game hands, library books), interfaces (holidays by cost, financial results in a spreadsheet), software (Google search results, data structures for ease of searching, for assigning jobs to processors).

To write efficient software, you have to understand sorting, and know which algorithms to use when.

## Bubble Sort

Basic sort algorithm, easy to write down.

```python
def bubble_sort(mylist):
    n = len(mylist)
    for i in range(n-1):
        for j in range(0, n-1 - i):
            if mylist[j] > mylist[j+1]:
                mylist[j], mylist[j+1] = mylist[j+1], mylist[j]
```

* Worst case gives `0.5*(n-1)*n` comparisons, which is O(n^2^).
* Worst case O(n^2^) swaps.

## Sorting Using Priority Queues

A priority queue is a data structure to which we can add items, and from which we can remove the item with the top priority.

Outline sorting algorithm:

* for each item in our list, add it to the PQ
* then repeatedly remove the top item from the PQ and put in successive cells in the list

```python
def pq_sort(mylist):
    pq = PriorityQueue()
    for i in range(len(mylist)):
        pq.add(mylist[i], None)
    for i in range(len(mylist)):
        mylist[i] = pq.min()
[check this]
```

### Sorting With an Unsorted Linked List PQ

*Selection* sort – main task is selecting the next smallest item.

Adding an item to the PQ is O(1), so the cost of the first loop is O(n).

Removing the top item requires a linear search over all items in the list, so n-1 comparisons. Each time we remove an item, the list shrinks by 1, and we make one assignment back into our original (array-based) list.

* O(n^2^) comparisons, n assignments

Best case (for n)?

The best case is also O(n^2^) comparisons and n assignments – same as worst case.

### In-place Sorting

Sorting using a separate priority queue requires extra space.

So we sort in place to make sure we don't run out of space for large n.

#### In-place Selection Sort

Treat the unsorted input array as the PQ list implementation (so no build cost). Instead of removing the top item, swap it into the correct cell, and shrink the 'view' of the PQ.

1. find the smallest item, swap it with cell 0
2. find the smallest item in the rest of the list, swap it with cell 1
3. repeat until sorted

* Worst case: O(n^2^) comparisons, n swaps.
* Best case: O(n^2^) comparisons, n swaps.

[get python code]

### Sorting With a Sorted Linked List PQ

Insertion sort: main task is inserting each item in the right place.

Adding an item to a sorted linked list of length n takes at most n comparisons, and if we are lucky, just 1 comparison. It always takes 1 assignment.

Adding n items to an initially empty PQ takes 0+1+2+...+(n-1) = O(n^2^) comparisons and n assignments for worst case.

Removing top item is O(1).

Best case: O(n) comparisons, n assignments.

### In-place Insertion Sort

Treat the unsorted array as the stream of items to be added to the PQ list implementation, and gradually expand the sorted list from the front (growing the 'view' of the PQ). Search the PQ to find the insertion place.

Copy the new item, shuffle the others down one place, insert the new item.

[get python code]

* Worst case: O(n^2^) comparisons and O(n^2^) swaps.
* Best case: O(n) comparisons, and 0 swaps.

### Sorting With a Binary Heap PQ

Heap sort: all the action takes place with heap operations.

Adding an item to a binary heap which has n items takes O(log n) comparisons and swaps. So adding all n items takes log(2) + log(3) + ... + log(n-1).

Each of these is <= log(n), and there are <=n of them, so O(n log n) to build the PQ.

Removing the top item from a binary heap with n items takes O(log n), so by the same arguments, to rebuild the array takes O(nlogn) comparisons and swaps.

So that's 2nlogn, which is O(n log n). O(n log n) is a lot better than O(n^2^).

Represent the heap using a list as before.

### In-place Heap Sort

Treat the unsorted input array as the stream of items to be added to the PQ, and gradually expand an array-based heap from the front.

Next item added to heap goes into last position, so it is already in the right starting place. Now bubble up to find its correct position.

The list is not a sorted list, though.

### Using a Max Heap

The heap is not a sorted list.

Instead, we will do two phases, and in the first phase, we will build a *max* binary heap. Same as before, but now each item must be larger than or equal to its children.

#### Phase 1

Build a max heap from the front.

#### Phase 2

In the final output, we want the biggest item at the end, so we remove it from the heap, copy the last item up and then bubble it down, leaving the last place free to re-insert the biggest item.

Iterate until the virtual heap is empty, and we're back to a sorted list.

#### Complexity

* O(n log n) to build the max heap
* O(n log n) to turn the max heap into the sorted list
