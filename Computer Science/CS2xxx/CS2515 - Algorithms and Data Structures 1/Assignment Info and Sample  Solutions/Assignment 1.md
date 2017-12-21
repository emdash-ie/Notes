# Assignment 1

---

## DLL Music Library

We're using a doubly-linked list to represent a music library management system. You could do this without a doubly-linked list, but you need to do it with one for this assignment.

You have the option of implementing the music library as a DLL, or implementing the DLL separately and using it in the music library implementation – either's fine.

He suggests using a sorting algorithm you already know, such as bubble sort, for sorting the music library, as complexity will not be important.

## Details

It's due Thursday 27th of October at 6pm.

It's submitted through the command line like with CS1117 last year. 

* `submit-ADS1 [filename]` – Note that this has been changed from what we were initially told.

All work submitted must be your own work.

## Recommendations

Dr. Brown recommends you draw pictures as you go, rather than just working with code. It helps to give you a mental model of what all the references mean.

Specifically for the `swap_adjacent` method, he recommends assigning the four nodes (the two nodes passed in, the node before them, and the node after them) to variables `x`, `y`, `z`, and `w` when you start out. This leads to longer code but makes it more likely that you'll get it working. Once you have it working you can remove these extra assignments.