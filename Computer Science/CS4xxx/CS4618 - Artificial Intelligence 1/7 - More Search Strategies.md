---
title: More Search Strategies
---

# Least-Cost Complexity

## Time

Worst-case: $O(b^m)$

## Space

Worst-case: $O(b^m)$

- Unlike depth-first search, we can’t reclaim space as we go
- Best-case is much better than DFS, though

# Greedy Complexity

## Time

Worst-case: $O(b^m)$

- May explore the entire graph
- Worth working out best-case

## Space

Worst-case: $O(b^m)$

- Worth working out best-case

# A* Search Complexity

$O(b^m)$ as before

Again worth doing the best cost – it’s the same for all three algorithms. ($O(bd)$ – first path is the best path.)

# Choosing Between 2 Heuristics

3 criteria:

- admissability
        - An admissable algorithm allows you to use $A*$ search
- cost of computation
- how close the estimates are to the correct cost
        - Which underestimates the least
