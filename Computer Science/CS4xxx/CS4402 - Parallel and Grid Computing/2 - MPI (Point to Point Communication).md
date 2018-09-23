---
title: MPI (Point to Point Communication)
---

# MPI

Message Passing Interface is a specification for the developers and users of message passing libraries. By itself it isn’t a library, just a specification for one.

Goal is to provide a widely used standard for writing message passing programs.

We are using MPICH.

# Programming Model

MPI lends itself to most distributed memory parallel programming models. We are using SPMD.

Parallelism is explicit – programmer must identify it and implement parallel algorithms using MPI constructs.

The number of tasks dedicated to run a parallel program is static – MPI2 enables controlling this dynamically.

# General MPI Program Structure

- header includes
- main function
        - initialise MPI environment
        - get basic MPI elements: size, rank, etc.
        - do parallel work
        - terminate the MPI environment
- other functions

# Environment Management Routines

MPI_Init(&argc, &argv)
: Initialises environment

MPI_Abort

…

# Splitting Loops

How do we split a sequential loop?

- n iterations -> n/size iterations per processor

How can I schedule these across the processors?

- uniform block partitioning
- round robin

# Laws

Amdahl: If the serial code we want to parallelise has a serial part, speedup can’t exceed a certain threshold.

Gustafson: If we have a serial part in the parallel code, that’s ok – we don’t have an upper bound.

# Point-to-point Communication

Communication between two processes.

Different types of send/receive routines:

- blocking send, blocking receive
- non-blocking send, non-blocking receive
        - uses buffers
- synchronous
        - blocking plus handshaking
