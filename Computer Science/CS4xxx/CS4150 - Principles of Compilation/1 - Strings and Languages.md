# Formal Languages

A formal language is a notation that is a set of strings conforming to some pattern/structure. Typically they’re described in e.g. regular expressions or context-free grammars.

# Symbols, Alphabets, and Strings

Alphabet
:   A finite set of symbols

String
:   A finite sequence of zero or more symbols from a specific alphabet

- Also $\epsilon$, which represents an empty string

# String Length and Equailty

Length of a string $xyz$ represented by $|xyz|$.

Strings are equal if they match in length and every symbol is the same and in the same position.

# String Concatenation

Uses the $.$ operator:

$$abcd \cdot efg = abcdefg$$

$$\epsilon \cdot xyz = xyz = xyz \cdot \epsilon$$

# Repetition

$x^n$ is $n$ repetitions of $x$ concatenated together:

$$x^n = x \cdot x \cdot x \cdot … x$$

$$x^0 = \epsilon$$

# Language

A set of strings over a specific alphabet.

- $\emptyset$ is used to represent the empty language.

# Concatenation of Languages

- $L_1 \cdot L_2$ contains all concatenations of $s_1 \in L_1$ and $s_2 \in L_2$

- $L^2 = L \cdot L$, $L^2 = L \cdot L \cdot L$, …

- $L^2D^3 = L \cdot L \cdot D \cdot D \cdot D$

    - Given $D = {0, 1, … 9}$ and $L = {a, b, … z}$, then $L^2D^3$ is the set of strings which have two letters followed by three digits.

# Set Closure

$L^* = L^0 \bigcup L^1 \bigcup …$
