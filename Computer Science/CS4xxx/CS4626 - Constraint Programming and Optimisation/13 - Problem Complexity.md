---
title: Problem Complexity
dates: 14/03/2019
...

# Job Shop Scheduling

- some sample problems are very hard (FT10 was not solved optimally for many years)

# CSP Complexity

With $n$ variables, each with a domain of size $d$, there are $d^n$ possible complete assignments. We may have to consider them all.

# Reducing Complexity During Search

- backtracking cuts down search by identifying partial assignments that already violate constraints
- CBJ cuts down BT search by jumping back and skipping parts of the tree
- MAC (and FC) cuts down BT search by reducing the sizes of future domains
- variable and value ordering try to get bigger reductions and failures higher up the tree
- symmetry cuts out redundant areas of the tree

Have we now brought the complexity below exponential? (No.)

# NP-completeness

- Computers and Intractability (Michael R. Garey, David S. Johnson)
  - description of NP-completeness, includes list of all known NP-complete problems

# Approximate Solutions

If we abandon the guarantee of returning the correct answer, we can improve the runtime.

For decision problems, design algorithms which have a high chance of producing an assignment that satisfies the constraints, in reasonable time.

For optimisation problems, design:

- algorithms which have a high chance of producing the optimal assignment, in reasonable time
- algorithms which have a high chance of producing a good solution, in reasonable time

# Dispatch Rules for Scheduling

Build the schedule step by step, simulating manufacturing process. (Each job is a queue of tasks.)

```
start at time t = 0
while not all tasks scheduled
  while there is a machine free at time t and with available tasks waiting to be scheduled at time t on that machine
    sort the available (machine, task) pairs by priority
    schedule the highest priority pair
  increase t until a machine is free
```

# Randomised Construction Heuristics

Heuristic techniques that work for any problem.

Choose one path in a decision tree and follow just that:

```
while variables unassigned
  choose a variable to assign based on heuristic
  choose a value to assign based on heuristic
  propagate assignment to other domains
  if domain wipeout
    return fail
return assignment
```

Can use any variable and value ordering heuristics.
Use random selection to break ties.

Unlikely to succeed for tightly constrained problems.

# Probing

Repeat the last thing a few times.

```
while stopping criterion not met
  initialise problem
  while variables unassigned and not wipeout
    choose a variable to assign based on heuristic
    choose a value to assign based on heuristic
    propagate assignment to other domains
```

- Still unlikely to succeed for tightly constrained problems

# Randomised Restarts

Normal search but have a backtrack limit – once you’ve reached it restart. Allow yourself more backtracks each time you restart.

```
initialise backtracking limit
while not found a solution
  initialise problem
  backtracking search up to a backtrack limit or solution
  if solution return solution
  else increase backtracking limit
```

As long as the backtracking limit continues to increase, this will eventually return a solution (as the backtracking tree must be finite).

If the heuristics are good, this should find a solution quickly (but is not guaranteed to).

This is available in Choco, as restarts. Have to use it with a random dynamic branching strategy, or else you end up exploring the same part of the tree over and over.
