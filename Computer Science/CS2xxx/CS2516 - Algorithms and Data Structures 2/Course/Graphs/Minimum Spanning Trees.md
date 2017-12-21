# Minimum Spanning Trees

* spanning tree is a subgraph of G that is a tree and contains every vertex

* minimum spanning tree is a spanning tree which has the lowest sum of weights of the selected edges

## Prim's Algorithm

* repeatedly include the minimum-weight edge from a vertex that's in the tree to a new vertex

### Complexity

### Proof

* for any algorithm you write, you should be able to prove that it does what you claim

## Kruskal's Algorithm

Prim's algorithm worked by building a single tree one edge at a time until all vertices in the graph are in the tree.

There is another approach based on joining trees together until all vertices are in the graph.

* start by saying every vertex is its own tree

* look for the cheapest edge that combines two trees

* repeat

No proof yet, think about it before next week.

### Efficient Implementation

* use a priority queue for storing edges

    * efficient removal of minimum-cost edge

* use a dictionary mapping vertices to the tree they're part of

* represent each tree by a stack of vertices (or any sequence)

* when joining trees:

    * pop each element from the smaller tree
    * point the dictionary value for that element at the bigger tree
    * push the element into the bigger tree

#### Complexity

O((n + m)logn)

* better tree merging gives better complexity
