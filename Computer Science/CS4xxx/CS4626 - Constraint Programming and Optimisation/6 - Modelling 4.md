---
title: Modelling 4 (Bin packing)
date: 31/01/2019
...

# Applications

- Processor scheduling
- Allocating movie files to hard disks
  - How many disks are needed?

# Problem

Can we fit these m objects into these n identical bins?

# Formal Model

Input:
- $[s0, s1, …]$: list of object sizes
- k: number of bins
- c: bin capacity

## Models:

#. Matrix of sizes per bin
  - Needs SetVars and so on
#. List of one number per object, allocating it to a bin
  - Hard to work out the bin size constraints (but we will see how to do this at some point)
#. Matrix of ${0,1}$ membership per object per bin
  - Uses stuff we already know

# Complication

Can we minimise the number of bins?

- Keep track of which ones are used, and aim to minimise that variable.

# Performance

- Model 2 above is quickest, along with the global `binpacking` constraint.

# Exercise

Experiment with choco classes on a bin packing problem, with different data (use a data loader to pull data from file).

- Try changing the search heuristics
- What heuristics would you use by hand?
