---
title: Finite Automata
---

# Finite Automaton

An abstract device which categorises input strings as *accepted* or *rejected*.

Operation:

- Place token on start state
- For each input symbol in the token, move the token along the edge whose label matches the symbol
- Accept the input if it is on an accepted state once you’ve worked through all the symbols

# Definition

A deterministic finite automaton consists of:

- $\Sigma$
        - an alphabet
- $S$
        - A finite set of states
- $s_0$
        - A start state
- $A$
        - A set of accept states
- $T = (S, E)$
        - A directed graph in which each edge in $E$ is labelled with one or more elements of $\Sigma$ and no two edges starting at one state share a label.

# Transition Table

You can also represent the transition graph for a finite automaton as a table.

# Formal Acceptance Criterion

The automaton *accepts* a string $x_1x_2…x_n$ if there is a path in $T$ from the start state to one of the accept states such that for each $i$, the $i$th edge on the path has $x_i$ in its label. All other strings are rejected.
