---
title: Heap Overflows
dates:
- 04/03/2019
...

# Intro

The heap is used for dynamic memory allocation (i.e. allocation at runtime).

# Heap Implementations

There are many implementations of the heap, allowing you to use a memory allocater other than the default C one. Usually, they’re trying to optimise memory management in some way.

# Heap Chunks

```C
unsigned int *buffer = NULL;
buffer = malloc(0x100);
```

The code above gives you a heap chunk, which contains the data (a pointer to this is returned), and the chunk also stores the chunk size and the previous chunk size in spaces before the data. I.e. at `*(buffer -1)` and `*(buffer - 2)`.

The lowest 3 bits in the chunk size field are used as flags (so the smallest chunk size is 16 bytes):

- `PREV_INUSE`
- `IS_MMAPPED`
- `NON_MAINAREA` (?)

# Heap Overflow

Instead of overflowing buffers on the stack, can overflow those on the heap. Objects on the heap may include function pointers, and if you can change this to another function, you can gain control of the program.

There is no equivalent of a stack canary.

You could make the heap non-executable, but there will always be memory space somewhere that is executable.

# Heap Spraying

Put your attack code into the heap multiple times in different places, and when you redirect into the heap you’re more likely to hit your attack code.

# Dangling Pointers

[more here]
