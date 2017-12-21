# Challenge

* given source text file, want to search for the first occurrence of a character string

* can't do similar thing to making a binary search tree before because we're looking for an arbitrary character string, not a word

# First Attempt

Brute force:

* look for the first character

    * if you find it, check if the next character is the second character, etc

        * if not, move on

Need to check a couple of things:

* make sure we haven't gone off the end of the string we're searching

* […]

## Complexity

If searching for a string of 7 'a's ('aaaaaaa') in a string ('aaaaaabaaaaaab…'), we waste a lot of time checking 'a's when we know (after the first check of each set of 6 'a's) that the string can't be found here.

If `n` is the length of the source text and `m` is the length of the target, we may need `0.5 * m * (m + 1)` checks, repeated `n/m` times, which is `O(n * m)`.

# Second Attempt

* jump forward every time you match some letters to the letter that failed

    * this misses some matches, though, so doesn't work

## Computing the Maximum Jump

* don't need to look at the source, can just look at the target for repetitions

* since we're not looking at the source, we can compute the jumps based only on the target, and do it offline before we begin

* look at each position: what happens if I fail here

### Computing the π Table

# Knuth Morris Pratt Algorithm for String Matching

This is what we have when we use the π table.

## Complexity

Inside the loop there are only O(1) operations.

We continue round the loop when j increases by 1, or i decreases (since i is assigned to π(i-1) […])

The worst we can do is always change i each time round the loop. Since i only increases when j increases, it has a maximum of n steps up. Therefore it has a maximum of n steps down.

Therefore the loop is executed a maximum of 2n times, which is O(n). The initialisation was O(m), therefore the algorithm is O(n + m).

This is optimal for the worst case, since you have to look at every character in the source at least once, and every character in the target at least once.

# Longest Common Subsequence

* used in molecular biology and forensics

* used in the UNIX `diff` command

We'll define the distance between two strings as the minimal number of additions or deletions that transforms the first string into the second.

    * only allow additions and deletions – replacing a letter with another counts as one addition and one deletion

    * can't re-order letters except by additions and deletions

Characters identified as unchanged are called a common subsequence (allows spaces).

We want to identify the length of the longest common subsequence.

## Rules

If you add the same character to the end of two sequences, the length of the longest common subsequence increases by one.

If you add two different characters to the end of the two sequences, you may get an improvement, which will only be an improvement of 1.

[…]

Represented differently, these become:

1. `if s[j] == t[k] then L_j+1_k+1 = 1 + L_j_k`

2. `if s[j] != t[k] then L_j+1_k+1 = max(L_j+1_k , L_j_k+1)``

## Method

Fill in a table with all possible L values. Know all the left and top values, because one subscript is 0, which means the result is 0.

From that we can work out L_1_1, and work along the second row, then the third row, etc.

The bottom right cell in the result table is the answer.

## Rebuilding

We have the length of the longest common subsequence – how do we find a common subsequence with the right length?

As we go down the table diagonally, if there's an increase of 1, then we added two matching characters.

* Start in the bottom right corner and move up or left until we reach [0,0].

    * Only move to a lower value if it is a diagonal as above

    * otherwise, prefer to move up – if you can't move up without going to a lower value, go left instead

# Dynamic Programming

This solution method is dynamic programming. Trying to find some optimal answer to a problem, we break the problem into smaller chunks, find the optimal answers for the chunks, recombine them in deterministic ways.

To work efficiently, we should be able to use the subproblem solutions more than once.

We've seen other examples of dynamic programming already.
