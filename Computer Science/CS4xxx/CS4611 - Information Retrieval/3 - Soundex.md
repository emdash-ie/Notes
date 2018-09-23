---
title: Soundex
---

# Soundex

Spells things phonetically to account for different spellings. Mostly used for names.

## Typical Algorithm

Turn every token into a 4-character reduced form. Do the same with…

1) Retain the first letter of the word.
2) Change all occurrences of the following letters to 0:
3) Change letters to digits as follows:
        - B, F,

These are groups of letters that are typically confused.

## How Useful?

It’s the classic algorithm – not super useful for information retrieval. Biased to names of certain nationalities. There are better algorithms.
