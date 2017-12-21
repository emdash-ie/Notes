# Directed Acyclic Graphs

## Directed Graphs

* directed graph ADT same as undirected, but the order of the vertices in each edge is treated as significant
* add a few methods to the graph as well

```pseudo
Edge
    get_start()
    get_end()

Graph
    in_degree(x)
    out_degree(x)
    get_in_edges(x)
    get_out_edges(x)
```

* `in_degree` and `get_in_edges` look at edges pointing at x
* `out_degree` and `get_out_edges` look at edges pointing away from x
* a path is a sequence of vertices, such that each pair of adjacent vertices in the sequence is a directed edge in the graph
* a cycle (in a directed graph) is a path of length >= 1 which starts and finishes at the same vertex

## Directed Acyclic Graphs

* can draw any binary relation over a single set as a directed graph
    * an order relation's representation can't contain a cycle

* a directed acyclic graph must have at least one vertex with in-degree = 0

    * proof: work backwards from any vertex over the in-edges

        * you'll reach a vertex of 0-degree or the graph contains a cycle

### Topological Sort

Given a directed acyclic graph, a topological sort is an ordered sequence of all vertices in the graph such that if two vertices x and y in the graph have a directed edge (x, y), then x appears before y in the sequence.

* There can be multiple topological sorts for one DAG

#### Algorithm

* mark all vertices of in-degree 0 as available

* for each vertex that's available

    * add to the end of your sort

    * decrement the in-degree of all vertices this vertex has an edge onto

        * mark any of those vertices available if they have an in-degree of 0

#### Code

```python
def topological_sort(self):
    # assumed to be operating on a DAG
    in_edge_count = {} # map of (vertex:in_degree) pairs
    output = []       # list of vertices in sort order
    available = []   # vertices with no active in-edges
    for v in self._structure:
        in_count = self.in_degree(v)
        in_edge_count[v] = in_count
        if in_count == 0:
           available.append(v)
    while len(available) > 0:
        w = available.pop()
        output.append(w)
        for e in self.get_out_edges(w):
            u = e.opposite(w)
            in_edge_count[u] -= 1
            if in_edge_count[u] == 0:
                available.append(u)
    return output
```

### Exercises

Write an algorithm which takes an arbitrary directed graph and returns True if it's a DAG, and False if it isn't.

    * do a breadth-first or depth-first search of the graph

        * keep track of all vertices you've seen

        * if you see one you've seen already, return False

    * if you get to the end of the graph return True

What is the complexity of the topological sort algorithm?

    * every vertex considered once in the for loop

    * every vertex considered once in the while loop

    * every outward edge from every vertex considered once in the inner for loop

    * O(2n + m) (= O(n+m)?), where n is the number of vertices and m is the number of edges
