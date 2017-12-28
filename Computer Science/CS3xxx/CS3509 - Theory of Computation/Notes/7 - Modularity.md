% Modularity

# Intro

If we know information about the running time of two programs, what can we say about the running time of a program made by combining them?

# Exact Time Modularity

Given two programs $P_1$ and $P_2$ and an input $I$, we run $P_1$ on $I$, and then run $P_2$ on the output from $P_1$.

The time for the whole operation must be the sum of the time $P_1$ takes and the time $P_2$ takes. Here’s the equation which describes that:

$T_{P_{1};P_{2}}(I) = T_{P_{1}} + T_{P_{2}}(P_{1}(I))$

# Worst-case Time Modularity

Worst-case running time doesn’t obey the same equation as above, because the worst-case output of $P_1$ won’t necessarily produce a worst-case input for $P_2$.

That is, if $I$ is an input that gives the worst-case running time for $P_1$, then the result of $P_1(I)$ won’t always be an input that gives the worst-case running time for $P_2$. Here’s an equation that describes that:

$T^W_{P_1;P_2}(A) \neq T^W_{P_1}(A) + T^W_{P_2}(O_{P_1}(A))$

(Here $A$ is a set of possible inputs, and $O_{P_1}(A)$ is the output that $P_1$ produces on this set.)

## Semi-Modularity of Worst-case Time

### Output-based Version

Even though the worst-case time for the combination isn’t equal to the sum of the worst-case times for $P_1$ and $P_2$, it *is* less than or equal to it, which is still useful.

The longest the combination can possibly take is if the worst-case times line up, and the worst-case input for $P_1$ produces a worst-case input for $P_2$ – the worst-case time for the combination will be less than or equal to this value.

Here’s an equation describing that:

$T^W_{P_1;P_2}(A) \leq T^W_{P_1}(A) + T^W_{P_2}(O_{P_1}(A))$

(Here again, $A$ is a set of possible inputs and $O_{P_1}(A)$ is the output that $P_1$ produces on this set.)

### Size-based Version

Rather than talking about the worst-case time of $P_2$ run on the *output* of $P_1$, we can look at the worst-case time of $P_2$ on the *size of output* produced by $P_1$.

If $P_1$ runs on inputs of size $m$ and produces outputs of size $n$, then the longest the combination can take is the sum of the worst-case time for $P_1$ on inputs of size $m$ and the worst-case time for $P_2$ on inputs of size $n$.

Here’s an equation which describes that:

$T^W_{P_1;P_2}(m) \leq T^W_{P_1}(m) + T^W_{P_2}(n)$

#### Proof

To prove this, use the output-based equation from above. Let $A$ be the collection of inputs of size $m$, and then the output of $P_1$ on $A$ will be a subset of the possible inputs for $P_2$ of size $n$. The longest the combination can take is if this subset contains the worst-case input of size $n$ for $P_2$.
