# BubbleSort

* Loop over the list, swapping adjacent elements if they're out of order

* Puts the next-biggest element in the next-last slot each time

## Time Complexity

* O(n^2) for best and worst case because it always does (n + n-1 + … + 1) comparisons

## Space Complexity

* Can be done in-place so O(1)

## Stability

* Stable once swap condition is left > right – elements with the same value will never be swapped past each other

# SelectionSort

* Find the next-smallest item each time and swap it into the next place from the start

    * growing sorted list from the front

## Time Complexity

* Worst case and best case the same - O(n^2)

    * have to search the whole unsorted section to find the next smallest item every time

    * n + n-1 + … + 1 = O(n^2)

## Space Complexity

* Can be done in-place so O(1)

* Otherwise O(n) for the PQ

## Stability

* Not stable

    * take the list [2, 3, 7, 4, 5, 2, 1]

    * first step will search the whole list for the 1, and then swap it with the first 2

    * first two is now after the second one: [1, 3, 7, 4, 5, 2, 2]

# InsertionSort

* Grow sorted list from the front

* Each time put the next item into the correct position in the sorted list

## Time Complexity

* Worst case - O(n^2)

    * list is already sorted backwards

    * have to shuffle each element the whole way to the front of the sorted section

    * 1 + 2 + … + n-1 comparisons = O(n^2)

* Best case - O(n)

    * list is already sorted

    * compare each element to the one before it - O(n)

## Space Complexity

* Can be done in-place so O(1)

* Otherwise O(n) for the PQ

## Stability

* stable

    * as long as you stop once you reach the same value when inserting

    * e.g. if you're inserting a 4 and the sorted section already contains 4s, the new 4 must go to the right of the existing 4s

# HeapSort

* Put everything into a heap, then take it out again

* Can be done in-place by growing a max heap from the front of the array and then taking the elements out one by one and putting them in the next-last place

## Time Complexity – O(n log n)

* O(log n) for each element added to heap

    * so O(n log n)

* O(log n) for each element removed from the heap

    * O(n log n)

* Best case: list already in max heap order – still O(n log n)

    * O(n) to grow

    * still O(n log n) to shrink

    * total O(n log n)

## Space Complexity

* O(n) for tree implementation – node for each element

* O(1) for array-based implementation because it can be done in-place

## Stability

* Not stable because of the heap

    * though possibly stable if the list is already sorted in descending order?

# MergeSort

* Split the list in two and recursively sort the sections, then merge them

    * to merge: repeatedly take the smaller of the next items in each section

    * base case: section with 0 or 1 elements is already sorted

* Difficult to do in-place, but can be done back-and-forth between two lists

## Time Complexity – O(n log n)

* Each merge is O(k) where k is the combined size of the sections

    * each level of the call stack is O(n) – e.g. two sections, each O(n/2)

* Depth of call tree is O(log n)

* So total is O(n log n)

* Best case is still O(n log n) because the same amount of merging and number of comparisons are done

## Space Complexity

* O(n) for bottom-up with two lists

* O(n log n) for implementations that create extra smaller lists

## Stability

* Stable as long as the left-hand element is taken first when merging and two elements are equal

    * e.g. if you're merging two lists and the front element is 3 in each of them, take the left one first

# QuickSort

* Choose a pivot

    * move all elements less than the pivot before it and the rest after it

    * put the pivot in between

    * sort the subsections either side of the pivot recursively

* Efficient implementation avoids shuffling elements through the list by swapping out of place ones

    * find one before the pivot that should be after, swap it with one that's after the pivot but should be before

* QuickSort is fastest if each pivot is the median value – there's an algorithm called median of medians which can guarantee this

* Slowest if each pivot is the next smallest or largest value – can choose a random pivot or shuffle the list at the start to avoid this

# Time Complexity – O(n^2) but O(n log n) on average

* Worst case – O(n^2)

    * if each pivot is the next smallest or next largest value

    * so the tree gets to maximum depth (n)

* Best case – better than O(n log n)?

    * each pivot is the median

    * tree depth is O(log n)

    * but it's less than n comparisons at each level, because the pivots from the last level aren't included, and there's only one comparison for each element that isn't the pivot in a given sublist

* Average – O(n log n)

## Space Complexity

* Can be done in-place, so O(1)

* If a new list is created, then O(n log n), possibly better

## Stability

* not stable with the random shuffle

* without it it might be

# BucketSort

* Make a bucket for each possible value, pass through the list, putting each item into the right bucket

* Then empty the buckets in order

* Not a comparison sort

## Time Complexity – O(n + N)

* N is the number of buckets, n is the length of the list

* Create buckets is O(N)

* Pass through the list to put in buckets is O(n)

* Processing buckets is O(N)

* O(n) assignments to create the list again

* Total of O(n + N)

## Space Complexity – O(n + N) or O(N)

* N buckets, n elements added across them

* though you could say that things can be moved to buckets rather than copied to them, in which case it's just O(N) space

## Stability

* Stable if buckets are FIFO

# RadixSort

* One bucket sort for each character (or digit), starting from the right

* Works because bucket sort is stable

## Time Complexity – O(mn)

* O(n + 10) for each digit (because there are 10 possible digits {0, 1, 2, …, 9} and so 10 buckets), which is ~= O(n) for n > 10

* So O(mn) total, where m is the maximum number of digits in the input list (e.g. if the largest number in a list of integers is 10749, m = 5)

* According to Ken's notes time complexity for radixsort is unclear, though, so I've probably oversimplified here

## Space Complexity – O(n) or O(1)

* O(1) for buckets

    * this is for base 10 numbers

    * for characters, it's constant but may be quite large if you need to support a lot of possibly characters (e.g. utf)

* O(n) for filling buckets

* Total of O(n)

* or possibly O(1) if you move rather than copy, as mentioned in bucketsort

## Stability

* stable because requires stable bucketsort
