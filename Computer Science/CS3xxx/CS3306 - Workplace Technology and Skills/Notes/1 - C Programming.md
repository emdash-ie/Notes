---
title: "1: C Programming"
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

## ASCII Digits

To check if a character is a digit, you can compare it to the characters `'0'` and `'9'`:

```C
char c;

if (c >= '0' && c <= '9') {
    // c is a digit
}
```

You can also convert an ASCII digit to its corresponding number by subtracting `'0'` from it, as the number digits are guaranteed to be sequential in value:

```C
char c = '2' // Say c now holds the value 50
// '0' will have the value 48, since the digits values are sequential

int i = c - '0' // i = 50 - 48 = 2
```

## Function Declarations

You can declare a function in one place and define it in another – since functions have to be declared before they’re used, you might declare all your functions at the beginning of the file, to make them available to other functions:

```C
// Declare function "power"
int power(int m, int n);

main() {
    // Even though power hasn’t been defined yet, we can call it here because
    // it has been declared above
    int i = power(2, 5);
}

// Define function "power"
int power(int base, int n) {
    int i, p;
    p = 1;
    for (i = 1; i <= n; i++)
        p *= base;
    return p;
}
```
