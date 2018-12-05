---
title: Algorithms in General Synchronous Networks
---

# Strongly-Connected Directed Graphs

A directed graph is strongly connected if there is a path from each vertex in the graph to every other vertex in the graph.

The diameter of such a graph is finite.

# Context

We consider arbitrary strongly connected digraphs $G = (V, E$) with $n$ nodes.

Processes only communicate over directed edges of the digraph.

Nodes are named via indices $1, …, n$ but, unlike the ring’s indices, these have no special connection to the nodes’ positions in the graph.

The processes do not know their indices, nor those of neighbors, and refer to neighbors by local names.

If a process $i$ has the same process $j$ as incoming and outgoing neighbor, then we assume that $i$ knows the two processes are the same.

# Leader Election in a General Network
