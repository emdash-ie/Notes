% More C Programming
%
% Tuesday 7th of November, 2017

[…]

# Function Macros

Macros don’t check types or allocate spaces for their parameters, and so are faster than functions. Converting small, frequently used functions to function macros can increase execution speed a lot.

Macro arguments and body must be surrounded by parentheses to get the precedence correct.

There are some built-in macros defined in the ANSI standard for e.g. getting the current line number, compilation time, or filename.

## Disadvantages

Macro arguments are re-evaluated at each mention in the macro body, so any side-effects will happen multiple times.

Macros are expanded each time they appear in the source code, making the source code larger (whereas function bodies are compiled once).

It is more difficult to debug programs that contain macros.
