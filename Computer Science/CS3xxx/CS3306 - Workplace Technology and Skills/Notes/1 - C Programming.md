---
title: 1: C Programming
dates:
- 15th January 2018
...

# Intro

Book: Kernighan & Ritchie – The C Programming Language (optional)

# C Programming

## Character Input/Output

You can use the `getchar()` and `putchar()` functions to take chars as input and to output them.

```C
#include <stdio.h>

main() {
    int c;
    c = getchar();
    while (c != EOF) {
        putchar(c);
        c = getchar();
    }
}
```

## Expressions

You can also shorten this code by doing more in the while condition:

```C
while ((c = getchar()) != EOF) putchar(c);
```

Here the assignment expression (`c = getchar()`) also has a result, which is the value assigned to `c`. This value is then compared to `EOF`.
