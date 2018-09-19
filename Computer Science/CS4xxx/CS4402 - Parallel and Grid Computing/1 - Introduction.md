# Hardware

We will mostly work on networked machines, but there is also a 100-processor cluster in UCC that we can apply for accounts for.

# Assessment

Assignment near the end: Develop a couple of parallel sorting algorithms, and test and compare them.

# What Is Parallel Computing?

An attempt to minimise total execution time through the simultaneous use of multiple computing resources.

# Laws

## Amdahl’s Law

Start from:

1) A sequential program that runs in $T$ seconds
2) $n$ processors to parallelise the sequential computation
3) $f$% of code is serial
   - Serial = not parallelisable

Find the speedup if no communication.

### Result

$$S(n) = \frac{n}{f(n - 1) + 1}$$

### Remarks

1) $S(n)$ increases when $n$ increases
2) $S(n)$ decreases when $f$ decreases
3) $f = 0 \Rightarrow S(n) = n$
4) $f = 1 \Rightarrow S(n) = 1$
   - No speedup
5) $S(n) \leq \frac{1}{f} \mid f \neq 0$

## Gustafson’s Law

Start from:

1) A parallel program with execution time $T$
2) $n$ processors to run in parallel
3) $f$% of the parallel code is serial

Find the speedup with no communication.

### Result

$$S(n) = f(1 - n) + n$$

### Remarks

Remarks 1-4 from before still hold, but:

1) $S(n)S is not bounded
