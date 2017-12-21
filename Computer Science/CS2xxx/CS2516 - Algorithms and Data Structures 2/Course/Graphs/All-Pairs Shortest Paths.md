# All-Pairs Shortest Paths

* can create a lookup structure in advance to process later

* that structure tells us the weight of the shortest path between any two vertices

    * doesn't tell us which path
## First Attempt

```pseudocode
for each vertex v in the graph
    compute the shortest path from v to all vertices using Dijkstra
```

## Second Attempt

* adapt floyd-warshall algorithm for finding the transitive closure

```pseudocode
create nxn 2d array
put 0 in all the diagonals
for each vertex v1
    for each other vertex v2
        if the cost of reaching v2 from v1 through the allowed vertices (starts at the empty set) is lower than the cost currently in the graph, put the new cost in
add a vertex to the allowed vertices and repeat
```

## Complexity

This is O(n^2 + n^2 + n^3) = O(n^3).

This is better than Dijkstra-heap with a dense graph (and same as Dijkstra-list, but tends to be faster).

If the graph is sparse, this is higher complexity than repeated Dijkstra-heap.
