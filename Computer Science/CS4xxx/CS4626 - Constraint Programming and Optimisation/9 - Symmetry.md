---
title: Symmetry
dates:
- 19/02/2019
...

# Intro

- last lecture on modelling
- after this we’ll look at algorithms and theory

# Overview

Symmetry allows you to get rid of equivalent solutions/states, speeding up the solver.

# Crystal Maze Revisited

For the crystal maze problem, you can see this in rotational or reflective symmetry with the graph diagram.

Also, the numbers are equivalent, in some sense. [more here]

## Impact of Symmetry

If searching for all solutions, then we can maybe just search for one solution and generate others using the symmetry rules.

Also, if we find (e.g.) that $X_2 = 2$ has no solution, then we know that there is no solution where $X_5 = 2$. This can allow us to cut out some of the search space.

Similarly, if there is no solution in which $X_i$ takes the value `1`, then there’s also no solution where it takes the value `8`.

# Symmetry in Constraint Solving

Two main approaches:

1. At the modelling stages, add extra constraints to remove the symmetries
  - but we must make sure we leave at least one solution in each symmetry group
  - our constraints must be correct
2. Modify the search procedure to detect and avoid symmetries during search

We will focus on the first approach.

# Breaking Symmetry by Posting Constraints

## Crystal Maze

- post a constraint $X_2 < X_5$
  - vertical symmetry
- post a constraint $X_1 < X_3$
  - horizontal symmetry

## Magic Square

Many symmetries:

- rotate 90
- rotate 180
- rotate 270
- reflect in horizontal
- reflect in vertical
- reflect in down-right diagonal
- reflect in up-right diagonal

These constraint are hard to determine correctly (hard not to add too many constraints and cut out some solutions).

## Bin Packing

Can swap the bins, as they’re identical. Can also swap any indentically-sized items.

## Matrix Model

Common way to model many problems. Depending on the problem, many of the rows (or columns) may represent interchangeable objects.

# Social Golfer

- many symmetrical solutions

# Matrix Model: Symmetry

For any matrix model, define two solutions $S_1$ and $S_2$ as symmetric if and only if [more here]

# Lexicographic Ordering

- Can break symmetry by using lexicographic ordering on the rows
- Trying to then use lexicographic ordering on the columns breaks the order on the rows
- However, for any matrix model where the rows and columns are both interchangeable, if there is a solution then there is always at least one solution where both are lexicographically ordered (but they are not necessarily unique – some can can be formed from one another using the symmetry rules)

# Global Constraints in Choco

- there are constraints for lex-ordering
