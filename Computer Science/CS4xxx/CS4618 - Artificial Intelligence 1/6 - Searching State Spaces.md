---
title: Searching State Spaces
---

# Path vs. Tree vs. Space

- The state space is all states reachable from the start state.
- The tree is all of these nodes the algorithm has actually visited (removed from the agenda).
- The path is the path from the current node in the tree back to the root.

# Completeness

- depth-first is not complete
- breadth-first is complete

# Time Complexity

- b is the branching factor (average number of successors)
- d is the depth of the shallowest goal
- breadth-first:
        - Worst case: $O(b^{d+1})$
        - Best case: $O(b^{d})$
- depth-first:
        - 
