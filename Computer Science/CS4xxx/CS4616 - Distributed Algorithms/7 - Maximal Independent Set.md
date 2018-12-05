---
title: Maximal Independent Set
dates:
- 7/11/2018
...

# Covered

## LubyMIS

Choice of independent set.

- random choice of identifiers, $n^4$
  - grid of possible identifier pairs between two processes: chance of conflict is $\frac{1}{n^4}$
- choose again if conflict
- remove local winners and their neighbours
- repeat until the graph is empty
- algorithm may not terminate (as random choice of identifiers may lead repeatedly to all processes left having the same identifier – this is unlikely by choice of $n^4$) so there needs to be some termination condition
- if algorithm produces an output it will be a correct output
