# Graphs

A graph is an abstract representation of the relationships between a set of objects.

We'll see how to implement them efficiently and how to implement efficient algorithms for processing them.

## Intro

A simple graph is a pair (V, E) where V is a set of vertices, and E is a set of edges. Each edge is a set {x, y} of two vertices.

* degree of a vertex is the number of edge sets that contain x
* vertices x and y are adjacent if there's an edge {x, y}
* edge {x, y} is incident on x (and on y)
* the neighbours of a vertex x are all other vertices adjacent to x

In a multigraph, E is a bag of edges rather than a set of edges, so there may be multiple edges {x, y} in E for the same pair of vertices x and y.

In a directed graph, each edge is an ordered pair (x, y).

* The out-degree of a vertex is the number of edges with x as the first element of the pair
* the in-degree of a vertex is the number of edges with x as the second element of the pair

A weighted graph has a function w from E to some set, defining a weight with the edge.

We can also associate labels from some set L with either vertices or edges.

## Vertex and Edge ADTs

* Vertex
    * `element()` – returns the id of the vertex
* Edge
    * `vertices()` – returns the pair of vertices the edge is incident on
    * `opposite(x)` – if the edge is incident on x, return the other vertex
    * `element()` – return the label of the edge

We don't ask each vertex what they're connected to, because they may be involved in multiple graphs. Instead we ask the specific graph.

## (Undirected) Graph ADT

There is no one agreed ADT for a graph. This is one possible one:

    * `vertex()` – return a list of all vertices
    * `edges()` – return a list of all edges
    * `num_vertices()` – return the number of vertices
* most important methods:
    * `num_edges()` – return the number of edges
    * `get_edge(x, y)` – return the edge from `x` to `y`
    * `degree(x)` – return the degree of vertex `x`
    * `get_edges(x)` – return a list of all edges incident on `x`
* these help us create or edit graphs:
    * `add_vertex(element)` – add a new vertex with element element
    * `add_edge(x, y, element)` – add a new edge between x and y, with element element
    * `remove_vertex(x)` – remove vertex `x` and all incident edges
    * `remove_edge(e)` – remove edge `e`

Remember you can have a graph with an vertex that has no edges, but if you delete a vertex, you must also delete all edges that contain that vertex.

An edge's element might be the weight or label for that edge.

## Implementing the ADT

The main operations are retrieving vertices and edges, so we want those to be efficient. Updating will be relatively rare.

For the edges, there are 4 main options:

1. a list of edges
2. adjacency list
    * for each vertex, store a list of the edges incident on it
3. adjacency map
    * for each vertex, store a map of the edges incident on it, using the other vertex as the key
    * better than the adjacency list if the vertices have high degree
4. adjacency matrix
    * maintain a 2D array, where `matrix[i][j]` contains a reference to the edge {i, j} (or between the ith and jth vertices)

### Edge List

Maintain the vertices and edges in unordered linked lists.

* two linked lists, one for edges, one for vertices
    * each edge has references to two vertices

Can improve this by adding references back to the linked list from each edge or vertex.

Searching for the edges that are incident on a certain vertex involves crawling the entire (linked) list of edges and checking if each one is incident on the vertex.

#### Complexity

`n` is the number of vertices, `m` is the number of edges.

Space complexity is O(n + m).

time complexity:

* `get_edge(x, y)` – O(m)
    * must check each edge
* `degree(x)` – O(m)
* get edges O(m)

* add O(1)
* add edge O(1)

* `remove_edge()` – O(1)
* `remove_vertex()` – O(m)
    * must check each edge

Would it make a difference to use sorted lists?

### Adjacency List

Maintain a list of vertices. Each vertex points to a list of edges that are incident on it.

#### Complexity

Space complexity: O(m + n)

* get edge O(min(degree(x), degree(y)))
* degree O(1)
* get edges O(degree(x))

* add vertex O(1)
* add edge O(1)

* remove edge O(1)
* remove vertex O(degree(x))

We've replaced all O(m) complexities with O(1), or O(degree). We would expect it the be faster.

### Adjacency Map

Maintain a list of vertices. Each vertex maintains a hash-map of its edges, using the other vertices as the key.

#### Complexity

Space complexity: O(n + m)

* get edge O(1) expected
* degree O(1)
* get edges O(degree(x))

* add vertex O(1)
* add edge O(1) expected

* remove edge O(1) expected
* remove vertex O(degree)

### Adjacency Matrix

Associate a unique integer in 0 to n-1 with each vertex. Maintain a 2D array, where `cell[i][j]` contains a reference to that edge.

#### Complexity

Space complexity is now O(n^2).

* get edge O(1)
    * fastest we've seen
* degree O(n)
* get edges O(n)

* add vertex O(n^2)
* add edges O(1)

* remove edge O(1)
* remove vertex O(n^2)

Some advantages, but some things are slower. This is wasteful for graphs with few edges (sparse graphs).
