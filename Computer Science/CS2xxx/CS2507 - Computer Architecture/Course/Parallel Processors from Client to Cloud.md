# Intro

Goal: connecting multiple computers to get higher performance

* multiprocessors

* scalability, availability, power efficiency

    * power efficiency is the most compelling reason for multiprocessing

Task-level (process-level) parallelism:

* high throughput for independent jobs

parallel processing program:

* single program run on multiple processors

multicore microprocessors

* chips with multiple cores/processors

# Hardware and Software Classification

Hardware:

* Serial (pentium 4) and parallel (e.g. intel core i7).

Software:

* sequential, e.g. matrix multiplication

* concurrent, e.g. operating system

Sequential/concurrent software can run on serial/parallel hardware.

The challenge is making effective use of parallel hardware.

# Message Passing Multiprocessors

* each processor has a private physical address space

* hardware sends/receives messages between processors

## Loosely Coupled Clusters

* network of independent computers

    * each has its own private memory and OS

    * two level of connection

    * connected using I/O system

        * e.g. ethernet/switch, internet

* suitable for applications with independent tasks

    * web servers, databases, simulations

* high availability, scalable, affordable

* problems:

    * high administration cost (prefer virtual machines)

    * low interconnect bandwidth

        * compare processor/memory bandwidth on an SMP (single-memory processor?)

## Grid Computing

* separate computers interconnected by long-haul networks

    * e.g. internet connections

    * work units farmed out, results sent back

* can make use of idle time on PCs

    * e.g. SETI@home, World Community Grid

    * Over 5 million computer users in more than 200 countries

## Cloud Computing

* a new class of network based computing that takes place over the internet

    * basically storing, processing, and accessing data over the internet

    * uses a collection/group of integrated and networked hardware, software, and internet infrastructure (called a platform)

* these platforms hide the complexity and details of the underlying infrastructure from users and applications by providing a very simple graphical interface or API

* in addition, the platform provides on-demand services that are always on, anywhere, anytime, anyplace

### Cloud Deployment Models

4 basic models:

* private cloud

* public cloud

    * companies worried about sensitive data

* hybrid cloud

    * keep private cloud, use public for less sensitive data

* community cloud

## Interconnection Networks

Network topologies – arrangements of processors, switches, and links:

* bus

    * flat communication

* ring

    * uses switches to provide higher bandwidth capacity than the bus

* 2D mesh

* N-cube

* fully-connected

    * too expensive

    * also difficult to alter

## Network Characteristics

* performance

    * latency per message (unloaded network)

    * throughput

        * link bandwidth

        * total network bandwidth

        * bisection bandwidth

    * congestion delays (depending on traffic)

* cost

* power

* routability in silicon

## Parallel Benchmarks

* traditional benchmarks use fixed code and data sets

* linpack – matrix linear algebra

    * performance/latency (world's fastest computer)

* SPECrate – parallel run of SPEC CPU programs

    * determines throughput performance

    * job-level parallelism

* SPLASH: Stanford Parallel Applications for Shared Memory

    * mix of kernels and applications, strong scaling

    * mainly looks at throughput

* NAS (NASA Advance Supercomputing) suite

    * computational fluid dynamics kernels, weak scaling

    * weak scaling as in not focused on scaling (or something)

    * focuses on latency, like linpack

* PARSEC (Princeton Application Repository for Shared Memory Computers)

    * multithreaded applications using Pthreads and OpenMP

    * throughput and latency

## Modelling Performance

* architectural diversity – multithreading, SIMD, GPUs

    * need for simple performance model for all architecture types

* parallel computers peak floating-point performance

    * depends on kernel speed on a given computer

* arithmetic intensity – a ratio of floating-point operations per byte of memory accessed by a program

    * memory system demand

* stream benchmark provides peak memory performance

### Roofline Diagram

Ties together the peak FP performance, the arithmetic intensity, and the peak memory performance.

* Defines an upper bound to performance

### Optimising Performance

Optimise FP performance:

* balance adds & multiplications

* improve superscalar ILP and use of SIMD instructions

    * loop unrolling

Optimise memory usage by reducing bottlenecks:

* software prefetch

    * avoid load stalls

* memory affinity

    * allocate thread and data on the same processor

    * avoid non-local data accesses

* choice of optimisation depends on arithmetic intensity of code

    * arithmetic intensity is not always fixed

        * may scale with problem size

        * caching reduces memory accesses

            * increases arithmetic intensity

## Fallacies

* peak performance tracks observed performance

    * marketers like this approach

    * in multiprocessor, they simply multiply

    * need to be aware of bottlenecks that limit performance

* Amdahl's law doesn't apply to parallel computers

    * since we can achieve linear speedup

    * but only on applications with weak scaling

## Pitfalls

* not developing the software to take account of a multiprocessor architecture

    * example: using a single lock for a shared composite resource

        * serialises accesses, even if they could be done in parallel

        * Silicon Graphic Operating System

        * a possible solution: use finer-granularity locking

## Conclusion

* goal of multiprocessors is to achieve higher performance by using multiple processors

* difficulties:

    * developing parallel software

    * devising appropriate architectures

* SaaS (software as a service) importance is growing and clusters are a good match

* performance per dollar and performance per joule drive both mobile and warehouse-scale computing (WSC)

* SIMD and vector operations match multimedia applications and are easy to program

    * for x86 we expect:

        * two cores per chip every two years

        * double SIMD width every four years
