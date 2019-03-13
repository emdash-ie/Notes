---
title: Search Heuristics
dates: 12/03/2019
...

# Intro

# Value Ordering

## Searching for One Solution

For every problem, there is a perfect value ordering.

If we could guarantee to pick the best value each time, the solving time would be linear in the number of variables.

However, we can’t – CSP with binary constraints is NP-complete.

Can we find a method that works well on average?

## Optimisation Problems

Need to keep searching until we prove that the best we’ve found can’t be beaten. So does value ordering matter?

Each time we find a solution with quality = k, we can post a constraint saying the quality of any new solution must be > k.

If we can compute an upper bound on the solutions below each node in the search tree, we might be able to eliminate whole sub-trees.

Then finding high quality solutions early will reduce the space.

## Problems With No Solutions

If the problem has no solution, we’d like to identify this as quickly as possible (and stop searching).

For a given node in the search tree (variable), we have to try each value, so value ordering seems useless.

But if we maintain AC after each value failure, and we have chosen a good value, we could discover a wipeout (and so a backtrack) without trying any other values.

## Principles

General principles:

- If we are on a path to a solution, we want to choose a value that is likely to be in the solution
- If we are on a path that cannot lead to a solution (but haven’t spotted it yet), we want to try a value whose removal is most likely to reveal that there is no solution below this point

It’s hard to define a function that will achieve both of these goals. We’ll assume there is a solution, and just aim to speed up that case.

## Methods

- min-conflicts
- cruciality
- promise

[more here]

# 2-Way Branching

- Every node has two branches
  - Either X is trying with value v, or X cannot have value v
- Variable is chosen afresh each time

# Impacts Strategy

- Specifically tailored for 2-way branching

Before search, for each variable and value, do a limited depth search, and measure the size of the problem at each leaf.

This gives an estimated impact of each value choice.

Average the impact scores for each of its values to get the estimated impact of a variable.

Use these impact values to pick the first variable and value.

During search, update these impact scores by observing the actual impact of each value choice (i.e. the change in the product of the future domains).
