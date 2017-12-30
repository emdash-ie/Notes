% 8: Duality

# Intro

Duality allows you to transform algorithm problems into other algorithmic problems in a one-to-one fashion. The resulting problems may look quite different from the original ones, but are equivalent.

Duality plays a crucial role in NP-completeness. NP-complete problems are all connected to one another, mostly by duality, so that if you can solve one, you can solve them all.

# Graphs

## Independent Subset

An independent subset of a graph is a subset of vertices of the graph, none of which are connected by an edge.

Say we have a large number of processors using resources. We can represent the processors as nodes on a graph, where processors are connected by an edge if they use the same resource.

Finding a group of processors that can run simultaneously without conflicting over resources is equivalent to finding an independent subset on the graph. Finding the largest independent subset is useful because it allows us to run as many of the processors simultaneously as possible.

Finding a maximal independent subset (one that you can’t grow to be any bigger while remaining independent) is a problem that no-one has solved generally in faster than exponential time.
