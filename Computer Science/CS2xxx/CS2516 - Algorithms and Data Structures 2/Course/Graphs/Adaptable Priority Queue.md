# Adaptable Priority Queue

Extend the priority queue to allow these with reasonable complexity:

* updating the key of an item
* reading the current key of an item
* removing an item

Update PQ ADT by:

* returning a reference to the Element when an item is added

    * calling program can store this and get access later

* storing some location information in the Element

    * this will be related to the implementation of the APQ

    * need to maintain this consistently through operations

## ADT

* `add(key, item)`

    * add a new item into the priority queue with a certain priority, and return its element in the APQ

* `min()`

    * return the value with the minimum key

* `remove_min()`

    * remove and return the value with the minimum key

* `is_empty()`

* `length()`

* `update_key(element, new_key)`

    * update the key of an element and rebalance the APQ

* `get_key(element)`

    * get the key of an element

* `remove(element)`

    * remove the element from the APQ and rebalance

```python
class Element:
    """ A key, value and index. """
    def __init__(self, k, v, i):
        self._key = k
        self._value = v
        self._index = i

    def __eq__(self, other):
        return self._key == other._key

    def __lt__(self, other):
        return self._key < other._key

    def _wipe(self): self._key = None
        self._value = None
        self._index = None
```

## Unsorted List Implementation

* `add(key, item)`

    * create the Element, append to the list, return the Element

    * O(1)*

* `min()`

    * search the list for the Element with minimum key, return (key, value)

    * O(n)

* `remove_min()`

    * search the list for Element with minimum key, swap it with last place, pop, return (key, value)

    * O(n)

* `update_key(element, new_key)`

    * update the Element's key

    * O(1)

* `get_key(element)`

    * return the Element's key

    * O(1)

* `remove(element)`

    * use Element's index to swap it into last place, pop, return popped (key, value)

    * O(1)*

## Array-Based Heap Implementation

* `add(key, item)`

    * create the Element, append to the list, bubble up, return Element

    * O(log n)*

* `min()`

    * return (key, value) of first Element in the list

    * O(1)

* `remove_min()`

    * swap first Element with last place, pop, bubble down from top, return (key, value) of removed Element

    * O(log n)*

* `update_key(element, new_key)`

    * update the Element's key, compare to parent, either bubble up or down

    * O(log n)

* `get_key(element)`

    * return the Element's key

    * O(1)

* `remove(element)`

    * use Element's index to swap it into last place, pop, bubble up or down, return popped (key, value)

    * O(log n)*

Also, whenever we swap two elements, we have to update the index values in the Elements.
