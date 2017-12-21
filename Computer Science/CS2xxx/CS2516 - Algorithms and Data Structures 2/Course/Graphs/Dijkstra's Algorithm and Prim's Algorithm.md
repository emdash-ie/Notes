# Djikstra's Algorithm

* once you've found a path, you keep going until you've found the cheapest path

    * this is when you try to expand from your target vertex (because you're always expanding from the cheapest current vertex)

* This will be the final continuous assessment

## heap vs. unsorted

* if the graph is dense, m is O(n^2)
* if the graph is sparse, m is O(n)

# Spanning Trees & Prim's Algorithm

* spanning tree is a subgraph of G that is a tree and contains every vertex

* minimum spanning tree is a spanning tree which has the lowest sum of weights of the selected edges

## Prim's Algorithm

* repeatedly include the minimum-weight edge from a vertex that's in the tree to a new vertex

### Complexity

### Proof

* for any algorithm you write, you should be able to prove that it does what you claim
