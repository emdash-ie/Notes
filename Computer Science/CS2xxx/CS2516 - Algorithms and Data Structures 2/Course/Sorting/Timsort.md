## Timsort

* Specifically designed for Python by Tim Peters in 2002.
* It's a hybrid of mergesort and insertion sort, designed to perform well when the data is already partially sorted.
* It's stable.

Timsort:

* finds 'runs' – sequences of items already in order
* merges runs together
* runs of short length are combined with larger ones using insertion sort, but this is too complex and too detailed to present in this module

Its worst-case complexity is O(n log n), its best case is O(n), and it is believed to be faster than quicksort in most cases.

It is now also the default sorting algorithm in Java and in Android.

The original description is [here](https://svn.python.org/projects/python/trunk/Objects/listsort.txt).
