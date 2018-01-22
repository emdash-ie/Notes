---
title: "2: Design Patterns"
dates:
- 18th January 2018
- 22nd January 2018
...

# Intro

“Each pattern describes a problem which occurs over and over again in our environment, and then describes the core of the solution to that problem […]”

A design pattern is a common solution to a recurring design problem.

They are trade-offs, favouring some qualities over others, and so encode design decisions.

A group of related patterns is called a pattern language.

Books:

- Gang of Four
- POSA

# Well-Known Design Patterns

## Façade Pattern

* Named by analogy with the façade of a building.

## Proxy Pattern

Problem: A client need access to services of another component – direct access is technically possible, but may not be appropriate.

The client communicates with a stand-in for the component. The stand-in provides the same interface as the component, but can perform additional pre- and post-processing steps.
