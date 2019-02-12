---
title: "Modelling 5: Scheduling"
dates:
- 07/02/2019
- 12/02/2019
...

# Scheduling Problem

- set of resources we can use
- set of tasks to be completed
- each task requires some use of the resources for some amount of time

Goal: find a start time for each task, and a resource

# Variants

E.g.:

- Can tasks be interrupted?
- Are tasks restricted to specific resources?
- Do tasks have deadlines?
- Do tasks have release dates?
  - Can’t be done before a certain date
- Can tasks operate at the same time?
- Do tasks consume resources which must be renewed?
- Do tasks give value when completed?

There are different methods that work well for different variants of scheduling problems, e.g.:

- A.I. search
- Local search (hill climbers, genetic algorithms, etc.)

# Complexity

Most scheduling problem types are NP-hard.

Many instances are too hard to solve optimally, so heuristic and approximate solutions are needed.

# Job Shop Scheduling

A job is a set of tasks, and each job has one task per resource.

The tasks in a job are totally ordered, and one must finish before the next one starts. (But the order of resource use may be different in each job.)

Only one task can be active on a machine at any one time.

Given a solution, the finish time of the last task to finish is the makespan. Usually aiming to minimise this.

# Disjunctive Graph

Directed edges represent strict precedence. Start with task order, gradually add resource order as the scheduling process. Length of longest path in resultant directed graph is the makespan.

# Simple Constraint Model

Each task is a variable, with the set of possible start times. $t.end = t.start + t.duration$

Constraints:

- any two tasks requiring the same resource must not overlap
  - $t.end \leq s.start$ or $s.end \leq t.start$
- any task in a job must finish before the next one starts
- for all tasks z which are the last ones in their job: $z.end \leq makespan$

# Elements of the Choco Model

Choco provides a Task class, whose objects maintain a start time variable, a duration variable, and an end time variable.

This provides the `start + duration = end` constraint.

# Cumulative Constraint

The global constraint `cumulative` in Choco solves this problem.

- `height` is how much of the resource a task takes up (for us it’s the total capacity)
- `capacity` is how much of the resource there is (for us it’s 1)

# SimpleJSS Example

- experiment with different search strategies

# Better Model

Could specify total ordering on tasks instead of assigning a start time to each task. This gives a smaller space, but is more complex. For now we won’t look at this model.

# Scheduling Jobs on Multi-capacity Resources

- multiple tasks allowed per machine
- [more]
- [more]

## Applications

- processes competing for memory
- vehicle repairs with limited garage capacity
- managing power use (e.g. to stay below a certain limit imposed by a company)

# Finite Capacity Resource Scheduling

- Each resource has a maximum capacity at any time point
- Each task has a duration and a resource consumption
- [more here]

## Sample Problem

- can split any task across rows (resource is simply additive)
  - hence not rectangle-packing problem

## Constraint Model

Each task has a start time, a duration, an end time, and a consumption rate. Duration and consumption are fixed.

$start + duration = end$

Define a task to be active in time `t` if $t \in [start, end - 1]$. (Finishes immediately before $end$.)

Assign start times to the tasks so that for each time point, the sum of the consumption rates for each active task is less than or equal to the resource capacity.
