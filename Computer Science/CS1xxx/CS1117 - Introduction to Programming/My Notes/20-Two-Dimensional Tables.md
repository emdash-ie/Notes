# Two-Dimensional Tables

---

## Representing Tables

We use lists within lists, e.g. `[[1, 2, 3], [4, 5, 6]]` represents:

|1|2|3|
|-|
|**4**|**5**|**6**|

You can then reference a cell by using two indices: `my_table[0][1]` gives the second cell in the first row.

### Sizes

The number of rows will be `len(t)`, and as long as all the rows have the same length (we are assuming this for our purposes), the number of columns will be `len(t[0])`.

However, this last statement will crash with an empty table.

---

##### Assignments & Handouts

* Assignment #21: Two-Dimensional Tables