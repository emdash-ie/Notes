# Assignment 17

---

## Sorting Data with Multiple Fields

* This is a return to simpler assignments.
* Make sure you understand the programs on handout 22 before attempting the assignment.
* Problem 1 is straightforward—it's a helper.
* Note that both problems 2 and 3 don't return any output, instead just sorting the existing data quietly.

#### InsertionSort()

The problem involves sorting a list of tuples. The code is virtually identical to the code in the handout, except that checking if one tuple comes before or after another is slightly trickier. Manning recommends writing a helper function to implement that comparison, one which returns a Boolean. That function will also need to know (maybe via a parameter) whether to sort the tuples by the ages in them or by the names.

#### SelectionSort()

The helper function from above is also helpful for this problem.