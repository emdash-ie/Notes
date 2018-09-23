---
title: Deliberative Agents
---

# Intro

A deliberative agent thinks ahead – tries out things in its head first.

# Advantages and Disadvantages

## Advantages

- Can simulate multiple successful solutions and find an optimal one
- Can avoid dead ends

## Disadvantages

- Can take too long to think, and your percept of the world is out of date

# Deliberative vs. Reactive

You can’t always be deliberative, you usually need to be both (e.g. reactions to save your hand from burning).

# Planning Sequences of Actions

Executing an entire sequence of actions is only possible in deterministic and single-agent environments. You’ll need to check if the world has changed, whether your action has succeeded.

# State Space

Planning is implemented as a search through a graph (state space), where the nodes are states of the world, and the edges are actions that transition between states.

Trying to find a path through the state space from an initial state to one of the possible goal states.

The graph is often too large to be stored in memory, so is stored implicitly by defining:

- the start states
- the set of actions for transforming states to other states
- the goal condition that can detect whether a given state is a goal state.
- possibly: a path cost function

# 8-puzzle

Only four operators because we view it as moving the blank space, not the numbered tiles.

# Water Jugs

- Restricting the states to integers is kind of cheating – anticipating that arbitrary filling of the jugs is useless.
- There are infinitely many solutions (paths to a goal state)
- There are 2 optimal solutions
