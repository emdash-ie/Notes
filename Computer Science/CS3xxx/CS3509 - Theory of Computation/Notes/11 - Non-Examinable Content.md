% NP-Completeness

# Intro

This material will not be on the exam.

# Efficient Certification and the Definition of NP

The input to a computational problem is a finite binary string S, which encodes the input (e.g. binary representation of Godel).

A decision problem X is identified with a set of binary strings on which the answer is "Yes".

An algorithm $A$ solves the problem $X$ when $A(S) = "yes" \leftrightarrow S \in X$.

$P$ is the class for which $A$ has polynomial running time. $NP$ is the class for which a solution can be efficiently verified.

# Definition of $P$

$P$ is the set of all problems $X$ for which there exists a polynomial time algorithm $A$ that solves $X$.

A polynomial-time algorithm is one which terminates on input $S$ in $O(P(|S|))$ steps (where $P$ here is a polynomial in $|S|$).

# Definition of $NP$

In order to check a solution, we need an input $S$ and a separate “certificate” string $t$ that contains evidence that $S$ is a “Yes” instance of problem $X$.

## Efficient Verifier

$B$ is an efficient verifier for a problem $X$ if the following 2 properties hold:

1. $B$ is a polynomial-time algorithm that takes 2 arguments: $S$ and $t$
2. There is a polynomial function $P$ such that, given an input string $S$:

	$S \in X \leftrightarrow \exists t | |t| \leq P(|S|) AND B(S, t) = “yes”$

## Definition of $NP$

$NP$ is the set of all problems $X$ for which there exists an efficient certifier.

# SAT and 3-SAT Problems

Suppose we have `N` boolean variables $x_{1}, …, x_{N}$.

$X = {x_{1}, …, x_{N}}$

A term is a variable $x_{i}$, or its negation $\overline{x_{i}}$.

A clause it a disjunction (sequence of ORs) of terms.

Finally, we consider conjunctions of clauses, e.g. $x_{1} \land (x_{2} \lor \overline{x_{3}})$.

We look at these because DeMorgan’s laws show that any logic problem can be represented in this form.

A truth assignment for $X$ is a function assigning a value to each variable $x_{i}$.

A truth assignment satisfies a conjunction of clauses if the conjunction of clauses evaluates to 1.

The SAT problem is whether you can make a program that will compute in polynomial time a truth assignment for a conjunction of clauses.

It turns out that if you can find a polynomial-time solution for this problem, you can find a polynomial-time solution for a lot of problems (e.g. the independent subset problem).

# NP-Complete Problem

Note: skipping 3SAT $\leq\_{P}$ Independent Set

We can’t solve $P = NP$, and we know that P is contained in NP.

So we focus on the hardest problems in NP.

An NP-complete problem X is:

1. A problem in NP
2. For every problem Y in NP:
	* $Y \leq_{P} X$ (Y is easier than X)

## Comments

1. If X is an NP-complete problem, then X is solvable in polynomial-time if and only if $P = NP$.

Then, if any problem in NP cannot be solved in poly-time, no NP-complete problem can be solved in polynomial-time.

But do NP-complete problems exist? Why can’t there be two problems X' and X'' such that $X' \nleq_{P} X''$ and $X'' \nleq_{P} X'$? Why can’t there be infinitely many problems that keep growing harder?

In fact, NP-complete problems *do* exist.

## Circuit Satisfiability

Circuit satisfiability is an NP-complete problem.

A circuit in our context is a hardware circuit consisting of logic gates $\land$, $\lor$, and $\neg$.

More formally, a circuit is a directed acyclic graph (a tree), where:

1. The leaves are labeled either with constants 1 or 0, or with boolean variables (e.g. x, y, etc.)

	* the constants are to specify the datastructure, and the variables are to specify the inputs

2. Every node is labeled with a boolean operator: $\neg$, $\land$, or $\lor$.

3. There is a single node (the root or output node) which represents the result computed by the circuit. If this result is 1, then the circuit is satisfiable.

It’s not surprising that this is NP-complete – a program that could compute this for any circuit can do a lot.

## Intuitive Reason for NP-Completeness of Circuit Satisfiability

Goal: pick X in NP and show X $\leq_{P}$ Circuit Satisfiability.

Any algorithm that takes a fixed number of bits as input (say $n$), and produces a yes or no answer can be represented as a circuit of the type we’ve just defined.

Given S (input), we want to decide whether $S \in X$ using a black box that can solve instances of circuit satisfiability.

### Proof (ish)

We know $X \in NP$, so X has an efficient certifier $B(S, t)$. So to determine whether $S \in X$ for a particular size of S, we need to find whether there is a t such that $B(S, t) = 1$. (Remember $|t| \in P(O(|S|)), from certifier definition.)

If we can find this, we have resolved that Circuit Satisfiability is NP-complete.

View B(S, t) as an algorithm with $N + P(N)$ inputs. Now encode it as a circuit, and then determine the satisfiability of the circuit in polynomial time using the black box.
