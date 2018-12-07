---
title: 2017-2018 Exam Solution for CS4150
---

# Question 1 (30%)

## (i)

### Question

The C programming language defines the lexical syntax of floating constants as follows: A floating constant consists of an integer part, a decimal point, a fraction part, an E, and an optionally signed integer exponent. The integer and fraction parts both consist of a sequence of digits. Either the integer part or the fraction part (not both) may be missing; either the decimal point or the E and the exponent (not both) may be missing.

Give a regular expression that captures this set of strings.

### Answer

```regex
 (([0-9]+ . [0-9]*) | (. [0-9]+)) (E (+|-)? [0-9]+)?)
| ([0-9]+ E (+|-)? [0-9]+)
```


### Method

Examples (ignoring the optional exponent sign):

1. `51.345E20`
2. `.345E20`
3. `51.E20`
4. `51E20`
5. `51.345`
6. `51.`
7. `.345`

No mention of signs in the initial integer part (just described as a sequence of digits), so I’m gonna ignore that complexity.

Also, I’m gonna use `.` to mean a literal dot, rather than matching any character, as it’s sometimes used.

Could deal with cases separately and then combine that (spaces added for clarity):

1. `[0-9]+ . [0-9]+ E (+|-)? [0-9]+`
2. `. [0-9]+ E (+|-)? [0-9]+`
3. `[0-9]+ . E (+|-)? [0-9]+`
4. `[0-9]+ E (+|-)? [0-9]+`
5. `[0-9]+ . [0-9]+`
6. `[0-9]+ .`
7. `. [0-9]+`

We could combine these, but that would make it really big.

I think we can break it down into these cases:

- The integer is present, decimal point is present, fraction is optional, and exponent is optional
  - Covers cases 1, 3, 5, 6
- The integer is optional, decimal point is present, fraction is present, and exponent is optional
  - Covers cases 1, 2, 5, 7
- The integer is present, decimal point is optional, fraction is optional, and exponent is present
  - Covers 1, 3, 4
- The integer is optional, decimal point is optional, fraction is present, and exponent is present
  - Without a decimal point, this is the same as having the integer and exponent required

So that’s three regexes combined:

- `[0-9]+ . [0-9]* (E (+|-)? [0-9]+)?`
- `[0-9]* . [0-9]+ (E (+|-)? [0-9]+)?`
- `[0-9]+ .? [0-9]* E (+|-)? [0-9]+`

Which gives the following monster:

```regex
([0-9]+ . [0-9]* (E (+|-)? [0-9]+)?)
  | ([0-9]* . [0-9]+ (E (+|-)? [0-9]+)?)
  | ([0-9]+ .? [0-9]* E (+|-)? [0-9]+)
```

Instead, let’s try combining all 7 individual case regexes and simplifying them:

1. `[0-9]+ . [0-9]+ E (+|-)? [0-9]+`
2. `. [0-9]+ E (+|-)? [0-9]+`
3. `[0-9]+ . E (+|-)? [0-9]+`
4. `[0-9]+ E (+|-)? [0-9]+`
5. `[0-9]+ . [0-9]+`
6. `[0-9]+ .`
7. `. [0-9]+`

- Number 3 and 4 are very similar, so it should be possible to combine them.
- Number 5 can be combined with either 6 or 7
- Number 2 and 7 can be combined by making the exponent optional
- Same for 1 and 5 and 3 and 6

Here’s with the exponent combinations:

1. `[0-9]+ . [0-9]+ (E (+|-)? [0-9]+)?`
2. `. [0-9]+ (E (+|-)? [0-9]+)?`
3. `[0-9]+ . (E (+|-)? [0-9]+)?`
4. `[0-9]+ E (+|-)? [0-9]+`

- We can now combine numbers 1 and 2 here by making the integer part optional
- Or 1 and 3 by making the fractional part optional

Here‘s with 1 and 3 combined:

1. `[0-9]+ . [0-9]* (E (+|-)? [0-9]+)?`
2. `. [0-9]+ (E (+|-)? [0-9]+)?`
3. `[0-9]+ E (+|-)? [0-9]+`

This gives us a result (only) slightly smaller than the monster from earlier:

```regex
  ([0-9]+ . [0-9]* (E (+|-)? [0-9]+)?)
| (. [0-9]+ (E (+|-)? [0-9]+)?)
| ([0-9]+ E (+|-)? [0-9]+)
```

Here’s that spaced out more nicely:

```regex
  ([0-9]+ . [0-9]* (E (+|-)? [0-9]+)?)
| (       . [0-9]+ (E (+|-)? [0-9]+)?)
| (         [0-9]+  E (+|-)? [0-9]+)
```

- We can also join the first two together in the middle:

```regex
 (([0-9]+ . [0-9]*) | (. [0-9]+)) (E (+|-)? [0-9]+)?)
|                       ([0-9]+    E (+|-)? [0-9]+)
```


## (ii) (10%)

### Question

Give a deterministic finite automaton for the language of Part (i).

### Answer

![](Images/Question 1 (ii) Answer.png)

### Method

1. Start with the acceptable paths, building up a tree
  - Mark accept states as you go
2. Simplify the tree
  - I did this as I went
3. Add in unacceptable paths and a possible black hole state

I’m still ignoring leading signs because they weren’t mentioned, but you can add them easily enough.

#### 1 & 2: Acceptable Paths and Simplifying

We can start with a run of numbers, or a decimal point. I’ll do the decimal point first:

- A decimal point
- A non-empty run of digits
- An optional exponent

![](Images/Question 1 (ii) Method 1.png)

Now starting with a run of digits, there are two options:

- A nonempty run of digits
- An exponent

Or:

- A nonempty run of digits
- A decimal point
- An optional run of digits
- An optional exponent

Adding in the first of these options, our graph is now:

![](Images/Question 1 (ii) Method 2.png)

Note instead of creating a new path for the exponent, we can reuse the existing one, because it would be identical. We can’t reuse C for G though, because G isn’t an accept state.

Adding the second option:

![](Images/Question 1 (ii) Method 3.png)

Here we can reuse C and its subtree because everything after the decimal point is the same as our first path.

#### 3: Unacceptable Paths

The language of symbols is: $L = \{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, +, -, E, .\}$

So for every missing outward path in the graph, add a path to a black-hole state, which isn’t an accept state and contains only self-loops.
