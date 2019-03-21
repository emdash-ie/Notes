---
title: Local Search
dates:
- 21/03/2019
...

# Intro

Changing tack to avoid getting stuck in local maxima.

# The Space of Assignments

We can try forgetting the tree, and just try the assignments (leaves of the tree) in some way.

The assignment space in 2D is now represented by a grid, where each square is a complete assignment.

Generating a first assignment is easy (rand choice for each variable).

How to move? Define a neighbourhood function which specifies a set of neighbours, e.g. for assignment X the set of all assignments X' where only one variable has a different value.

Then we just define a search strategy […]

[…]

# Min-Conflicts

Surprisingly good, as it’s a very simple algorithm. Works well on problems with lots of solutions (that’s lots kind of relative to the number of assignments, but kind of not – if the number of assignments is increasing but so is the number of solutions, this still improves).

It’s a specific form of hill-climbing, but it’s possible to get stuck in a local maximum.

# Iterated Hill-Climbing

Repeat hill-climbing a few times, stopping when we hit a limit or the global minimum.

# Variants

How do we construct the initial solutions? Greedy heuristics with random variation seems to work best, but you need to ensure diversity in the generated initial solutions. You could also make a large move from a previous good assignment.

How do we define the neighbourhood and move selection?

- Consider all neighbours and take the best (reasonably small neighbourhood function).
- Take the first improvement we find.

# Simulated Annealing

[…]

# Tabu Search

Rather than restart each time we hit a local minimum, force the search to keep moving. (Need to be careful search doesn’t slip into a previous local minimum.) Maintain a list of assignments that have been visited recently, and so shouldn’t be revisited.

More successful techniques maintain a tabu list of operators that produce the neighbours (if in the last 20 moves I changed variable X, then I can’t modify it now) – reject a tabu move unless it gives the best assignment so far.

This is probably the best method for very large, difficult scheduling problems.

# Genetic Algorithms

[…]

# Meta Heuristics

These last few approaches have all been this. Heuristics that tell you how to operate other heuristics.

There are many more:

- ant colony optimisation
- particle swarm optimisation
- memetic algorithm (GA with hill climbing)
- artificial immune systems

# Local Search and CSP – Issues

Most local search methods give no guarantee of finding an optimal solution (or even of getting close). Most require insight into the problem details to design good representations, move operators, and neighbourhoods. Most have many parameters, which require extensive experimentation for each problem class.

Many of them struggle on optimisation problems with complex and difficult constraints. Assignments with good scores may be very far away from valid solutions.

But they can be time-limited, and so offer practical solutions. Many best-known solutions to real problem instances have been obtained via metaheuristics.
