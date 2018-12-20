# Intro

Clustering groups similar objects according to some distance metric.

The goals:

- If two objects are in the same cluster, their distance is small
- If two objects are in different clusters, their distance is big

Has several applications, including identifying population niches in genetic algorithms in an attempt to maintain diversity.

# Algorithms

Most can be grouped point-assignment or hierarchical algorithms.

Point-assignment groups assign objects to random (or arbitrary) clusters and then repeatedly re-consider each object.

Hierarchical algorithms produce a tree of clusters, either agglomerative (bottom-up: start with every object in an individual cluster) or divisive (top-down: start with one cluster containing all objects and split).

There are other aspects of clustering algorithms:

- partitioning: can objects be in more than one cluster?
- hard vs. soft: is membership in a cluster boolean or fuzzy?
- which distance measures they work for (some don’t work for e.g. cosine)
- whether they assume the dataset is entirely in memory
- whether they assume all data is available up-front (vs. arriving over time)

We won’t have time to cover these details.

# k-Means Clustering

This is the best-known point-assignment algorithm.

- assumes you know the number of clusters ($k$) in advance
- partitions a dataset $X$ into $k$ subsets
- uses the centroid of a cluster:
  - featurewise mean of the examples in the cluster

## Centroids

1. 2, 4, 6
2. 4, 3, 7
3. 3, 2.5

# Inertia and Convergence

- at some point, the inertia may converge even if the centroids keep changing

# Choosing $k$

- Choosing $k$ involves some amount of domain knowledge
- To improve quality of clustering, try to incorporate domain knowledge in e.g. the distance measure or the data (more features, more semantic features)
