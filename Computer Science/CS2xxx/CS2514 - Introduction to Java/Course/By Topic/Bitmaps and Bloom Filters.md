# Bitmaps and Bloom filters

Bloom filters are probabilistic (answers aren't 100% correct), but very space efficient.

Bitmaps are not practical for large sets.

## Bitmaps

A bitmap represents the members of a given index set. May be represented using a boolean array.

Java doesn't specify how to represent a boolean (it's up to each JVM implementation). If the booleans are represented as ints, this would be a waste of memory, especially if the index size is large.

In practice bitmaps are often represented as int arrays.

### Basic Representation

`Bitmap(int capacity)` – create a bitmap

#### Implementation

* probably would be good to make the `Bitmap` class final

    * that way public methods can't be overridden

    * can allow the compiler to optimise

* ternary operator use in `add` and `remove` is an optimisation because in theory it would allow the two statements to be done in parallel

* size handled manually to be more efficient

### `int` Representation

#### Manipulating Bits

* arithmetic method is too slow

### Some Facts

* operations are constant time under the assumption that array access by index is O(1) – this is not always the case

## Bloom Filters

* can't answer questions about size

* can't remove from the set

* can improve quality of the answer by increasing the size of the filter a little bit

### Implementation

* union of bits is numbered from the right

### Application: Detecting Malicious Websites

* assume we want to know whether a given URL is malicious

* hash the URL into hash codes `h_0`, … `h_n-1`

* if bit `h_i` = 0 for some i, then the URL isn't known

* otherwise the URL is known (but this may be a false positive)

At this point there are two possibilities:

* trust the answer

* use a slow database operation to see if the URL is known

This speeds up detection of malicious websites largely if the majority of websites are not malicious. Google uses this.

### Application: Probabilistic Spell Checker

Start with an empty bloom filter B.

For each allowed word, add the word's hash code to B.

[…]

### Application: Pre-Processing Database Joins

* computing the join takes a lot of time, and removing redundant rows also takes a lot of time.

* using bloom filters takes us from O(|T1| * |T2|) to O(|T1| + |T2|)

    * |T1| is the number of rows in table T1

Start with an empty bloom filter.

For every row in T1, look at the tuples for common attributes, fill bloom filter with it (once per row).

Look at every row in T2, if they're not in the bloom filter we can remove the rows (can also do that with T1).

Note: `public int hashCode()` is defined in the Object class. It's generally advised that objects depending on this should override the method to get better performance.

This is done in e.g. `HashSet` in Collections.
