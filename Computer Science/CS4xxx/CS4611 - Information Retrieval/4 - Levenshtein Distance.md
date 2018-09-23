---
title: Levenshtein Distance
---

# Spelling Correction

Two main uses:

- Correcting documents being indexed
- Correcting user queries

Can do it with isolated words (won’t catch typos that give correct words, e.g. from -> form), or do it in a context-sensitive way.

# Correcting Queries

1) Assume there is a list of correct words from which the correct spellings come
2) We have a way of computing the distance between a misspelled word and a correct word

A simple correction algorithm: Return the correct word that has the smallest distance to the misspelled word.

However, it is computationally heavy to calculate the distance for all words. To get around this, we focus on ways to cut down the search space.

# Distances

- Edit distance (Levenshtein)
- Weighted edit distance
- k-gram …

# Edit Distance

The minimum number of basic operations that convert s~1~ to s~2~. For Levenshtein distance, the basic operations are insert, delete, and replace.

# Levenshtein Distance Computation

Use a table/dynamic programming approach as a form of memoisation for a recursive program.

- Start with the empty string
- Moving right/left is character insertions
- Moving down/up is deletion
- Diagonals are calculated as 1 plus the minimum of the cells to the left, above, and diagonally above and left
