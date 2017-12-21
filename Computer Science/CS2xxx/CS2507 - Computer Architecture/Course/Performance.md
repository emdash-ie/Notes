## System Performance

One measure is the response time/execution time – how long it takes to do a task.

Another is the throughput – the total work done per unit time (e.g. tasks per hour). This is especially important for servers.

We'll focus on the response time.

Adding a faster processor affects both, but adding more processors affects throughput more.

### Relative Performance

Define this as 1 / the execution time.

Now we can represent "X is n times as fast as Y" more naturally.

### Measuring Performance

The `Elapsed Time` is the total time to complete a task:

    * Includes Processing, I/O, OS overhead, Idle time

The `CPU Time` is the time spent processing a given job.

    * Doesn't include I/O time or time spent on other jobs in the middle.

    * Made up of the user CPU time and the system CPU time.

Different programs are affected differently by CPU and system performance.

### CPU Clocking

* The operation of digital hardware is governed by a constant-rate clock – everything happens on clock steps.
* The clock period is the duration of a clock cycle.
* The clock frequency is the number of cycles per second, and is the inverse of the period.

The CPU execution time for a program is the number of clock cycles multiplied by the time each cycle takes.

You can represent this as: # of cycles / clock rate.

Performance can be improved by:

* reducing the number of clock cycles

* increasing the clock rate

Hardware designers often need to trade off clock rate against cycle count.

The number of clock cycles can be found by multiplying the number of instructions (the instruction count) by the number of cycles per instruction (the CPI).

So we can redefine the CPU Time as (Instruction Count x CPI) / Clock Rate.

The instruction count for a program is determined by the program, the ISA, and the compiler.

The average CPI is determined by CPU hardware. If different instructions in a set have different CPIs, then the average CPI is affected by the balance of those instructions.

### Performance in General

CPU Time = (Instructions per program) x (Clock cycles per instruction) x (Seconds per clock cycle)

Performance depends on:

* Algorithm: Affects IC, possibly CPI
* Programming language: affects IC, CPI
* Compiler: affects IC, CPI
* ISA: affects IC, CPI, Tc

Time is the only reliable measure of performance.

# Power Trends

Clock rates increased until 2004, with the pentium 4 processor, which had a clock rate of 3600. However, this had a huge power consumption, and the heat made it behave erratically, so since 2004, clock rate has been staying roughly the same, while power consumption has been decreasing.

The dominant IC technology is CMOS, and the power consumption is given by this equation:

* Power = Capacitive load x Voltage^2 x Frequency

Recently, we've been keeping the power low by decreasing the voltage (from 5V to 1V). It's difficult to make ICs work below 1V, though.

Once we've hit the power wall, it makes sense to move to multiprocessors.

# Multiprocessors

* Multicore multiprocessors
  * Require more than one processor per chip
* This requires explicit parallel programming
  * Compare with instruction level parallelism, where the hardware executes multiple instructions at once, which is hidden from the programmer
  * Requires knowledge of the architecture
  * This is hard to do:
    * programming for performance
    * load balancing
    * optimising communication and synchronisation

# Benchmarks

Benchmarks are used to tell the difference between processors when you haven't actually tried them.

## SPEC Power Benchmark

Power consumption of servers at different workload levels.

* Calculate the performance at each 10% increment

* Note that the power is not proportional to the load for servers.
    * We're trying to design this at the moment though, as that would save energy and make it easier to manage energy consumption.
* Servers work well at 100%.
* The best servers around the world typically work only at 50%, though.

Some of the reason for higher power use than expected at low load is power leak from transistors, which are now very small.
