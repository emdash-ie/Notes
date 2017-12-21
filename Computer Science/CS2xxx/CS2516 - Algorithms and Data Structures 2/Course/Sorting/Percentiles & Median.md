# Percentiles / Median

To find the median/percentile of an unsorted list, you can use sorting techniques.

## Method 1

## Method 2

```pseudo
for each element in list:
    add element to a sorted linked list
step through linked list to position k
```

Worst case is for a sorted list, which gives O(n^2) additions followed by k steps.

## Method 3

* Sort algorithm
* Read position

O(n log n) for merge or heap sort. O(n^2) for quick sort, but O(n log n) on average.

## Method 4

* apply quicksort idea to identify element in position k
    * called decrease and conquer

```pseudo
pick a pivot
sweep through list to gather all items less than, equal to, or greater than pivot
if more items 'less than pivot' than k
    recurse on all items less than pivot
else if more items 'less than or equal to pivot' than k
    return pivot
else
    recurse on all items greater than pivot
```

### Analysis

Worst case - always choose a pivot that only decreases the list by 1 item. This is O(n^2) for small k.

By a similar argument to quicksort, you can show that the average time for a list of length n is O(n).

* There is an algorithm called median of medians to guarantee O(n) runtime, but it requires handling of very large coefficients.

## Exercise

See notes. Developing and testing multiple versions of quickselect. Which is fastest on average?
