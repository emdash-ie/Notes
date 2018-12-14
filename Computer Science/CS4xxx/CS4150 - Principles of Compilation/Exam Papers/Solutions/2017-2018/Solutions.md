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

## (iii) (10%)

### Question

The characters `/*` introduce a C comment, which terminates with the characters `*/`. Comments do not nest. Give a nondeterministic finite state automaton that accepts the set of strings that are valid comments according to this definition.

### Answer

Using `^a` to mean any symbol in the language except `a`:

![](Images/Question 1 (iii).png)

# Question 2 (30%)

## (i) (7%)

### Question

Consider the following simplified grammar for the Tiny programming language:

```
<program> -> <stmtseq>
<stmtseq> -> <statement> <stmtseq2>
<stmtseq2> -> ; <stmtseq> | Empty
<statement> -> <ifstmt> | <repeatstmt> | <assignstmt>
<ifstmt> -> if <exp> then <stmtseq> end
<repeatstmt> -> repeat <stmtseq> until <exp>
<assignstmt> -> id := <exp>
<exp> -> num
```

Give a complete parse tree for the following Tiny program:

```Tiny
x := 17;
if 1 then y := 23 end;
z := 29
```

### Answer

![](Images/Question 2 (i).png)

## (ii) (3%)

### Question

Give a context-free grammar for the language consisting of strings of the form $0^n1^n$ over the alphabet {0,1}, i.e. strings containing some number of zeroes followed by the same number of ones.

### Answer

```cfg
<string> -> 0<string>1 | Empty
```

## (iii) (14%)

### Question

Give a context-free grammar for the language consisting of strings over the alphabet {0,1} that contain precisely the same number of zeroes and ones.

### Answer

```cfg
<string> -> Empty
  | <string><pair>
  | <pair><string>
  | 0<string>1
  | 1<string>0
  | <string><string>
<pair> -> 01 | 10
```

## (iv) (6%)

### Question

Draw a complete parse tree for each of the following strings:

(a) `000111`
(b) `010101`
(c) `00111100`

### Answer

(a):

![](Images/Question 2 (iv) (a).png)

(b):

![](Images/Question 2 (iv) (b).png)

(c):

![](Images/Question 2 (iv) (c).png)

# Question 3 (30%)

## (i) (14%)

### Question

Compute the FIRST and FOLLOW sets for the non-terminals of the Tiny grammar given above.

### Answer

#### FIRST

```
First(program) = {if, repeat, id}
First(stmtseq) = {if, repeat, id}
First(stmtseq2) = {;, epsilon}
First(statement) = {if, repeat, id}
First(ifstmt) = {if}
First(repeatstmt) = {repeat}
First(assignmentstmt) = {id}
First(exp) = {num}
```

#### FOLLOW

```
Follow(program) = {$}
Follow(stmtseq) = {$, end, until}
Follow(stmtseq2) = {$, end, until}
Follow(statement) = {;, $, end, until}
Follow(ifstmt) = {;, $, end, until}
Follow(repeatstmt) = {;, $, end, until}
Follow(assignstmt) = {;, $, end, until}
Follow(exp) = {;, $, end, until, then}
```

## (ii) (10%)

### Question

Complete the parse table for this language for the stack-based, table-driven LL(1) parsing algorithm.

### Answer

| Nonterminal | ;   | if  | then | end | repeat | until | id  | num | $   |
| ----------- | --- | --- | ---- | --- | ------ | ----- | --- | --- | --- |
| program     |     | x   |      |     | x      |       | x   |     |     |
| stmtseq     |     | x   |      |     | x      |       | x   |     |     |
| stmtseq2    | x   |     |      | x   |        | x     |     |     | x   |
| statement   |     | x   |      |     | x      |       | x   |     |     |
| ifstmt      |     | x   |      |     |        |       |     |     |     |
| repeatstmt  |     |     |      |     | x      |       |     |     |     |
| assignstmt  |     |     |      |     |        |       | x   |     |     |
| exp         |     |     |      |     |        |       |     | x   |     |

## (iii) (6%)

### Question

Write a succinct description of the stack-based, table-driven LL(1) parsing algorithm.

### Answer

The stack holds the result of the current production, and symbols are consumed from the input (and the stack is popped) while they match the top of the stack. When the next input symbol doesn’t match the top symbol on the stack, the table is checked for a production that converts the top symbol of the stack into something that starts with the next input symbol. The results of this production are then pushed onto the stack in place of its current top symbol.

Errors can be encountered in the table lookup or if the top of the stack is a terminal symbol which doesn’t match the next input token (meaning the current production hasn’t been matched).

# Question 4 (10%)

## (i) (5%)

### Question

Suppose we wish to augment the Tiny language with a simple for loop with the syntax shown below:

```Tiny
total := 0
for i := 1 to 100 do
  begin
  total := total + i
  end
```

Show how the grammar of question 2 may be modified to incorporate this feature.

### Answer

```Tiny
<statement> -> <ifstmt> | <repeatstmt> | <assignstmt> | <forstmt>
<forstmt> -> for id := <exp> to <exp> do begin <stmtseq> end
```

## (ii) (5%)

### Question

Give a general template for the translation of any for loop into three-address code. Use the example given above to illustrate the approach.

### Answer

- put initial value in counter
- start label
- check if counter is less than end value, store in temporary variable
- if temporary variable contains false, jump to end label
- loop body code
- jump to start label
- end label

For example:

```tac
total := 0;
i := 1;
loop1start:
t0 = i < 100;
if (t0 == 0) goto loop1end;
total := total + i
goto loop1start;
loop1end:
```
