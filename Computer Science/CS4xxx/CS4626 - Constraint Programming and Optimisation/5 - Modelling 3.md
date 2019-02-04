---
title: More Modelling
date: 29/01/2019
...

# Loading Boxes on to Trucks

- many types of item
- known profit per item type
- known weight per item type
- known stock level for each type
- how many of each to load onto a truck

# Model

Variables: number of each item type loaded
Values: `[0, stock(item_type)]`

Constraints:
- don’t exceed max weight for truck
- ensure profit > P

# Knapsack Problem

- truck problem is an example of this
- this is NP-hard
- there is a Choco knapsack Constraint to do this in one go
  - this is *way* faster

When making a model, use complex existing constraints wherever they apply.
