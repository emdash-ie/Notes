# Graph Traversals

The standard traversal is to visit all the vertices that can be reached from some starting vertex.

We'll start with two basic ones:

* depth-first search
* breadth-first search

## Depth-first Search

* Go as far as you can
* Whenever you hit a dead end, retrace your steps until a new path is available to you

In longer terms:

* mark the first vertex
* choose an edge, and move along it to the opposite vertex – mark it
* don't visit any vertex you've visited before
* when there are no unmarked vertices adjacent to the current one:
    * backtrack to the vertex before the current one and try the next edge from there
* when we are back at the first vertex and there are no more edges we can try:
    * stop

Pseudocode (for a recursive implementation):

```pseudo
depthfirstsearch(graph, v):
    mark v
    for each edge (v, w)
        if w has not been marked
            mark w
            depthfirstsearch(graph, w)
```

* relies on the marking existing outside of the recursion

This algorithm is quite efficient, but gives strange paths. You could implement DFS non-recursively using a stack.

### Properties

1. The set of vertices marked in DFS is the connected component of G containing v.
2. The set of marked vertices and the edges that led to them in DFS form a rooted spanning tree of the connected component, rooted at v.
3. The worst-case running time of DFS is O(n + m), where n is the number of vertices and m is the number of edges.

## Edges in a Graph

For a simple undirected graph with n vertices, there are `0 + 1 + … + (n-1)` edges (as long as no vertex can be linked to itself). This is equal to `0.5 * (n - 1) * n`, which is O(n^2).

# Breadth-first Search

Depth-first search is easy to implement and is fast, but some vertices close to the start vertex are not discovered until late in the traversal. The resultant tree has very long paths to some vertices.

Breadth-first search says to visit all vertices that are 1 hop away from the start vertex, then all that are 2 away, and so on.

The resultant tree will contain the shortest path to each vertex.

## Python code

## Properties

* Should get into the habit of proving these things
* Since the number of edges could be O(n^2), this and depth-first search could be O(n^2), depending on the graph.

# Directed Graphs

* Use an ordered pair for each edge instead of a set

* Now the max number of edges is `n * (n-1)`, because there can now be two edges between each pair (one in each direction)

## Traversals

* Have to change the definition of connected component now

# Transitive Closure of a Graph

* The vertices you can get to from each vertex

## Computing Transitive Closure

* could also use breadth-first search (doesn't matter if it's an undirected graph)

### V2 (Floyd-Warshall Algorithm to compute the transitive closure)

* This looks complicated but we'll see why it's useful later with a certain problem
* Adding intermediate vertices that are allowed in the path with each iteration
