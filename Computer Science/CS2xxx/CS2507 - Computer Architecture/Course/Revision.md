# Intro

* don't just focus on what we're revising now – everything is important

* slides might not be online, to prevent people from focusing on them too much

# Overview

* fundamentals of computer design

* hardware/software interface

* program performance and how it can be improved

* hardware techniques to improve performance

* hardware techniques to improve energy efficiency

* instruction set principles

* pipelining

* memory hierarchy

* parallel processors

# Computer Architecture – 8 Great Ideas

1. Design for Moore's Law

    * design for rapid change

    * design process for computer takes a long time, so predict rapid change

2. Use abstraction to simplify design

    * representing hardware and software at different levels

3. Make the common case fast

    * easier to improve on simple cases than complex ones

4. Performance via parallelism

    * parallel operations are faster

5. Performance via pipelining

    * sequential pattern of parallelism

6. Performance via prediction

    * operating based on healthy guess

    * cost of misprediction important

7. Hierarchy of memories

    * arranging memory according to cost/fastness

    * memory the main limitation on the program speed (since the processor is faster)

8. Dependability via redundancy

    * including redundant components for addressing failure

    * parallel processors

# Hardware/Software – Program Translation

* application software (top)

    * written in high-level languages (far from machine language)

* system software

    * compiler: translates HLL code to machine code

        * assembler the first type of translator (not compiler?)

    * operating system: service code

        * handling I/O

        * managing memory and storage

        * scheduling tasks & sharing resources

* hardware (bottom)

    * processor, memory, I/O controllers

## Levels of Program Code

* high-level language

    * level of abstraction closer to problem domain

    * provides for portability and productivity

* assembly language

    * symbolic representation of machine instructions

    * human-understandable

* hardware representation

    * bits

    * encoded instructions and data

Note: diagram with assembler, compiler, linker, loader important – learn to reproduce it.

# Computer Components

* classic components:

    * inputs

    * outputs

    * memory

    * processor (datapath and control units)

Same components for all kinds of computer (desktop, server, supercomputer, embedded system).

## Inside the Processor

* datapath

    * performs operations on data

* control

    * sequences datapath, memory access

* cache memory

    * small fast SRAM memory for immediate access to data

# Understanding Performance

Number of things matter:

* algorithm

    * determines number of operations executed

* programming languages, compiler, architecture

    * determine the number of machine instructions executed per operation

* I/O system (including OS)

    * determines how fast I/O operations are executed

* processor and memory system

    * determine how fast instructions are executed

## System Performance

* response time:

    * how long it takes to do a task

    * aka. execution time

    * important for personal mobile device

* throughput

    * total work done per unit time

        * e.g. tasks/transactions per hour

        * focus of servers

How are response time and throughput affected by:

* replacing the processor with a faster version?

* adding more processors?

## Measuring Performance

* elapsed time

    * total time to complete a task, including all aspects (processing, I/O, OS overhead, idle time)

    * determines system performance

* CPU time

    * time spent processing a given job

        * does not include I/O time or other jobs' shares

    * user CPU time and system CPU time

    * different programs are affected differently by CPU and system performance

## CPU Performance

`CPU time = CPU clock cycles * clock cycle time = CPU clock cycles / clock rate`

* important to be able to reproduce this

Performance is improved by:

* reducing number of clock cycles

* increasing clock rate

Hardware designer must often trade off clock rate against cycle count.

# MIPS

* Stanford MIPS commercialised by MIPS Technologies (www.mips.com)

* Large share of embedded core market

    * […]

* typical of many modern ISAs

    * Intel x86

    * ARMv7

        * this and v8 mostly mobile devices

    * ARMv8

## Arithmetic Operations

* add and subtract, three operands

    * two sources and one destination

    * `add a, b, c      # a gets b + c`

* all arithmetic operations have above form

* design principle 1: simplicity favours regularity

    * regularity make implementation simpler

    * simplicity enables higher performance at lower cost

## Register Operands

* arithmetic instructions use register operands

    * every operand must first be in a register

* MIPS has a 32 x 32-bit register file

    * used for frequently accessed data

    * numbered 0-31

    * 32-bit data called a word

* assembler names

    * $t0 – $t9 for temporary values

    * $s0 - $s7 for saved variables

        * for saving state (on stack) when calling another procedure

        * automatically saved when you call another procedure (or possibly just when `push` command is used?)

* design principle 2: smaller is faster

    * MIPS has a small number of registers, and they're not that big

    * desire to maintain fast clock cycle time

Translation of C code to MIPS (and vice-versa) will be on the exam.

## Memory Operands

Main memory is used for composite data (arrays, structures, dynamic data).

To apply arithmetic operations:

* load values from memory into registers

* store result from register to memory

Important to note that memory is byte-addresses in MIPS (each address identifies an 8-bit byte).

Words are aligned in memory:

* address must be a multiple of 4

MIPS is big-endian:

* most-significant byte at least address of a word

```MIPS
lw $t0, 32($s3)
add $s1, $s2, $t0
```

## MIPS R-Format Instructions

Fields for register-format instrutions:

* `op`: 6 bits

    * operation code

* `rs`: 5 bits

    * first source register number

* `rt`: 5 bits

    * second source register number

* `rd`: 5 bits

    * destination register number

* `shamt`: 5 bits

    * […]

* `funct`: 6 bits

    * […]

## MIPS I-Format Instructions

* immediate arithmetic and load/store instructions

    * `rt` is destination or source register number

    * `constant` can be positive or negative in two's complement

        * allows `addi` to do subtraction

* `op`: 6 bits

* `rs`: 5 bits

* `rt`: 5 bits

* `constant or address`: 16 bits

## Procedure Calling

* procedure allows programmers to concentrate on a portion of a task at a time

    * includes parameter to interface to the rest of the program

* steps required for calling procedure

    1. place parameters in registers

    2. transfer control to procedure

        * backs up saved registers first

    3. acquire storage for procedure

    4. perform procedure's operations

    5. place result in register for caller

    6. return to place of call

A leaf procedure is one that doesn't call another.

A non-leaf procedure calls others (or can call others).

# Floating Point

* representation for non-integer numbers

    * including very small and very large numbers

Like scientific notation:

* -2.34 x 10^56

In binary:

* ±1.xxxxx_2 * 2^yyyy

* x's called binary points (rather than decimal points)

* normalised form has only one digit in front of the decimal point, and that digit isn't a zero

Used for `float` and `double` types.

## IEEE Floating Point Format

`x = (-1)^s * (1 + Fraction) * 2^(Exponent - Bias)`

* exponent affects range

* fraction affects precision

Operations always a tradeoff between precision and range.

Exponent: excess representation: actual exponent + bias

* bias makes exponents all unsigned

Important to know how to convert floating point numbers to binary.

## Floating-point Addition & Multiplication

* numbered steps

# Instruction Execution

* two basic steps:

1. PC -> instruction memory

    * fetch instruction

2. Register numbers -> register file

    * […]

Depending on instruction class, use ALU to calculate:

* arithmetic result

* memory address to load/store

* branch target address

Also access data memory for load/store

Put the target address or the address of the next instruction on the program counter.

# Building a Datapath

Datapath is the elements that process data and addresses in the CPU

* e.g. registers, ALUs, muxes, memories

We will build a MIPS datapath incrementally

* […]

* the longest execution path determines the clock period

    * critical path: load instruction

        * instruction memory -> register file -> ALU -> data memory -> register file

* not feasible to vary period for different instructions

* pipelining improves throughput but not latency

# Hazards

# Multiple Issue

# Memory

* principle of locality (temporal & spatial)

## Memory Hierarchy Levels

* block is the unit of copying – may be multiple words

## DRAM Technology

* tries to couple refreshing, reading, and writing together to be more efficient

## Direct Mapped Cache

## N-Way Associative

## Fully Associative
