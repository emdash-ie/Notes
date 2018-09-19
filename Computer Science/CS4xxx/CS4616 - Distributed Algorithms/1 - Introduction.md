# Distributed Algorithms

Distributed algorithms are algorithms which run on a number of interconnected processes, which pass messages to each other. Each process runs independently, with only a limited amount of information. The algorithms should work correctly even if the individual processes work at different speeds and some of them fail.

We will start with a synchronous model, to simplify the problem – execution proceeds in synchronous rounds. We will use a formal way to model distributed systems, involving a graph of processes and channels between them – the model helps to understand, and prove the correctness of, the algorithms.

There is a book called Distributed Algorithms by Nancy Lynch, which goes into more detail.

## Chapter 2

The model uses state machines to represent each process.

Invariant assertions – properties that are true of all reachable states of a system. Assertions are proved by induction on the number of steps in the system execution.

## First Exercise: Leader Election

A number of processes, organised into a ring. Each process can only communicate with its neighbours.

A token is passed around to give each process the chance to send messages – how do you choose a leader to generate a new token?

# Efficiency

Can use the number of rounds (time complexity) or the number of messages (communication complexity) to measure the efficiency of distributed algorithms.
