# Q2(ii)

* not looking for code for an adjacency map implementation, just a description

* dictionary with vertices as keys and all edges containing that vertex as values

* space complexity O(n + m)

* time complexity

    * get_edge – O(1) expected

    * degree – O(1) expected

    * edges - O(max(degree))

    […]

# Q2 (iii)

* out_edges

* in_edges

* in_degree

* out_degree

* start

* end

# Q2 (iv)

* DAG is a directed graph with no cycles that follow the direction of the graph

* topological sort is all vertices in the graph listed in an order such that if there's an edge v_i to v_j, then v_i comes before v_j  in the list

# Q2 (v)

* work on vertices with in-degree 0

# Q2 (vi)

* combine the graphs and then run the topological sort algorithm

* will need to define what combining the graphs means
