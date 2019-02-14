---
title: Global Constraints
dates:
- 14/02/2019
...

# Intro

A global constraint is a relation over an unlimited number of variables.

They generally represent a meaningful sub-problem – known problems may have efficient algorithms to handle them.

Global constraints are the key to the success of constraint programming:

- They simplify problem modelling
- They can speed up solving significantly (though they don’t always)

# Catalogues

- https://cv.archives-ouvertes.fr/nicolasbeldiceanu
  - Catalog shows all known global constraints
- sofdem.github.io/gccat
  - web frontend, search, etc.
  - last updated 2014
  - easier to use

# Max

Usage: `max(IntVar max, IntVar[] vars)`

Constrains the maximum value assigned to variables in `vars`. For the constraint to be satisfied, the argument `max` has to have a value equal to the largest assigned value in `vars`.

# Count

`count(int value, IntVar[] vars, IntVar limit)`

Exactly `limit` of `vars` are assigned `value`.

# Global Cardinality

`globalCardinality(IntVar[] vars, int[] values, IntVar[] occurrences, boolean closed)`

For each `i`, the number of times `values[i]` is assigned in `vars` should be equal to `occurrences[i]`.

Note:

- `values` and `occurrences` must be the same length
- if `closed` is `true`, then the domains of `vars` are restricted to the values in `values`

# N Values

`nValues(IntVar[] vars, IntVar nValues)`

The number of distinct values assigned to `vars` is `nValues`.

# Element

`element(IntVar value, int[] table, IntVar index)`
`element(IntVar value, int[] table, IntVar index, int offset)`
`element(IntVar value, IntVar[] table, IntVar index, int offset)`

Expresses:

- $value = table[index]$
- $value = table[index - offset]$

Indexing into an array with a variable as the index. (Offset mainly used to manage 1-based and 0-based arrays)

# Regular

`regular(IntVar[] vars, IAutomaton automaton)`

The sequence of values taken by the variables in `vars` must be a word accepted by the FSA `automaton` (for example, `automaton` could be given as a regular expression).

Standard application is employee scheduling. (Matching laws on shifts, etc.)

## Regular Expressions

`public FiniteAutomaton(String regexp)`

Create a finite automaton based on a regular expression. Only allowed use digits or numbers, or the Java RegExp constants.

# Modelling Example: Warehouse Location

A retail outlet supplies its shops from a number of central warehouses. Each shop must be supplied by only one warehouse, but a warehouse can supply many shops.

For each (warehouse, shop) pair, there is a supply cost based on the travel distance between them. There is a fixed cost to maintain a warehouse. Each warehouse has a maximum number of shops it can supply.

Find the subset of warehouses that minimises the total cost while supplying all the shops.

## Binpacking View

- as we did before, with some extra constraints

## Using Global Constraints

- variable with a warehouse choice per shop
- list of count variables for the number of shops supplied per warehouse
- `warehouseActive` array of bool vars using an element constraint – 1 iff the warehouse has been assigned a shop
- `shopCost` array of `IntVars` using an element constraint – read the cost from the input using `shopSupply` to provide the index
