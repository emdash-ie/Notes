# Uniqueness

If all edges have distinct weights then there is a unique minimum spanning tree (MST).

## Proof

Assume there are two MSTs, $T_1$ and $T_2$. Pick $e$, the edge of least cost in $T_1$ that is not in $T_2$.

Now add $e$ to $T_2$, which creates a cycle. Pick an edge $e' \neq e$ in the cycle. The cost of $e$ is less than the cost of $e'$. Removing $e'$ lowers the cost, so $T_2$ is not a minimum spanning tree.

There may be a problem with this proof (how do you know such an $e'$ exists?) – he will email an updated version.

Update: If such an $e'$ exists, then the proof is as above. If $e'$ does not exist, then every edge in $T_2$ is already in $T_1$, and so there is already a cycle in $T_1$, which is not possible because $T_1$ is a tree.

# Cycles

Consider $N$ vertices. Make edges by picking one edge per vertex that starts at that vertex and ends at another (create outgoing edges).

This will always create a cycle.

Proof: Assign the out-edges one-by-one (in a path). The target of each out-edge must be a vertex that doesn’t already have an out-edge. When you get to the last vertex, the only options for the final edge are nodes that already have out-edges.

## Uniqueness

In fact, there will be exactly one cycle in the resulting graph (if the graph is connected).

To have two cycles, some node would have to have two outgoing edges.
