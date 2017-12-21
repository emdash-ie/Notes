# Big Picture

Designing for application/program performance and energy efficiency on modern computers.

* What determines program performance?
* How are programs translated into machine language?
* How do hardware designers improve performance?

# Course Overview

* Fundamentals of computer design
* Hardware/software interface
* Program performance and improvement
* Hardware techniques to improve performance
* Hardware techniques to improve energy efficiency
* Instruction set principles
* Pipelining
* Memory hierarchy
* Parallel processors

# Understanding Performance

* What algorithm was used?
    * Determines the number of operations executed
* Programming language, compiler, architecture
    * Determines the number of machine instructions executed per operation
* I/O System (including OS)
    * Determines how fast I/O operations are executed
* Processor and memory system
    * Determine how fast instructions are executed

# 8 Great Ideas of Computer Architecture

1. Design for Moore's Law
    * Design for rapid change – by the time your computer is ready (3–4 years), it may be outdated
2. Use abstraction to simplify design
    * Represent hardware and software at different levels
3. Make the common case fast
    * Easier to improve on simple cases than complex ones
4. Performance via parallelism
    * Parallel operations are faster
5. Performance via pipelining
    * Sequential pattern of parallelism
6. Performance via prediction
    * Guess the outcome of a branch
7. Hierarchy of memories
    * Arranging memory according to cost/speed
8. Dependability via redundancy
    * Including redundant components for addressing failure

# Levels of Program Code

* High-level language
  * Level of abstraction is closer to the problem domain
    * This makes programmers more productive
  * Provides for productivity and portability
* Assembly language
  * The textual representation of instructions
* Hardware representation
  * Bits
  * Encoded instructions and data

# Computer Components

* Inputs
* Outputs
* Memory
* Processor (datapath and control units)

All classes of computer share these same components.

# Inside the Processor

* Datapath
    * performs operations on data
* Control
    * sequences the datapath, provides memory access
* Cache Memory
    * small fast SRAM memory for immediate access to data

All input to the processor goes to the (cache) memory first, and then the control determines when things are sent to the datapath.

# Memory

There are two classes of memory:

* Volatile main memory
* Non-volatile secondary memory

Volatile memory loses instructions and data when powered off.

Secondary memory examples:

  * Magnetic disk
  * Flash Memory
  * Optical disk (CDROM, DVD)
