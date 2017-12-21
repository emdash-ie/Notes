# Intro

Most existing software is written to exploit a single-core processor and doesn't take advantage of multi-core processors.

* need significant performance improvement (otherwise might as well just use a faster uniprocessor)

There are difficulties:

* partitioning

    * need to separate out the bits that could be parallelised

* co-ordination

    * e.g. have to co-ordinate to get results

* communications overhead

    * must be a controller controlling each divided unit, management of these requires communication

# Amdahl's Law

* sequential part can limit speedup

# Instruction and Data Streams

An alternative classification based on the number of instructions and data streams.

E.g. MIMD – multi-instruction, multi-data

* SPMD – single-program, multi-data

    * a parallel program on a MIMD computer

    * conditional code for different processors

## Single Instruction Multiple Data (SIMD)

* operates element-wise on vectors of data

    * e.g. MMX and SSE instructions in x86

        * multiple data elements in 128-bit registers

* all processors execute the same instruction at the same time

* simplifies synchronisation

* reduced instruction control hardware

* works best for highly data-parallel applications

    * loops in programs

## Vector Processors (as opposed to scalar processors)

* highly pipelined function units

    * an elegant interpretation of SIMD

* stream data to/from vector registers to units

    * data collected from memory into registers

    * results stored from registers to memory

* don't know what a vector is in this context, but the width of the registers in important

    * you can execute an entire loop in one operation

* significantly reduces instruction-fetch bandwidth

## Vectors vs. Scalars

* vector architectures and compilers

    * single vector instruction is equivalent to executing entire scalar loop

    * explicit statement of absence of loop-carried dependencies

        * reduced checking in hardware

    * regular access patterns benefit from interleaved and burst memory

        * burst memory – copy a lot of memory in one go

    * avoid control hazards by avoiding loops

* better power and energy savings than scalar architecture

    * less instruction and memory bandwidths and less hazard checking

* don't see much vector architecture these days

    * have the problem of context-switching being harder

    * can get scalar processing nearly as good

    * would have to discard scalar architecture – not worth it?

# Multithreading

* performing multiple threads of execution in parallel for a single processor

    * replicate registers, PC, etc.

    * fast switching between threads as compared to processes

        * this is context-switching – very slow for full processes

    * uses virtual memory mechanism to share memory

Two approaches:

* fine-grain multithreading

    * switch threads after each instruction

    * interleave instruction execution

    * if one thread stalls, others are executed

* Coarse-grain multithreading

    * only switch on long stalls (e.g. L2 cache miss)

    * simplifies hardware, but doesn't hide short stalls (e.g. data hazards)

## Simultaneous Multithreading

Combines fine-grain and coarse-grain multithreading.

* in a multiple-issue dynamically scheduled processor

    * schedule instructions from multiple threads

    * instructions from independent threads execute when function units are available

    * within threads, dependencies handled by scheduling and register renaming

    * tries to use up all instruction bandwidth by taking instructions from different threads and running them simultaneously

Example: Pentium-4 HT

* two threads: duplicated registers […]

# Multiprocessor Shared Memory

SMP – shared memory multiprocessor

* hardware provides single physical address space for all processors

* synchronise shared variables using locks and cache coherence

    * lock: a process locks a variable and until it unlocks it, no other process can write to it (or lock it)

Two styles of SMP access time:

* uniform memory access – latency does not depend on processor

* non-uniform memory access – variable access time depending on processor

# Example: Sum Reduction

How do you split a task across multiple processes so that each does an equal amount of work?

This uses divide and conquer approach:

* half the processors add pairs, etc.

# History of GPUs

* originally in high-end computers, then available as an expansion, now commonly pre-installed

* different aims than the microprocessor community

# GPU Architecture

Processing is highly data-parallel

* GPUs are highly multithreaded

* use thread switching to hide memory latency

    * less reliance on multi-level caches

    * hardware multithreading

* graphics memory is wide and high-bandwidth

Trend toward general purpose GPUs

* heterogeneous CPU/GPU systems

* CPU for sequential code, GPU for parallel code

Programming languages / APIs

* DirectX, OpenGL

* C for Graphics (Cg), High Level Shader Language (HLSL)

* Compute Unified Device Architecture (CUDA)

# Classifying GPUs

They don't fit nicely into SIMD/MIMD model

* conditional execution in a thread allows an illusion of MIMD

    * but with performance degradation

    * need to write general purpose code with care
