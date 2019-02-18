---
title: 7 - Operating Systems
dates:
- 18/02/2019
...

# Intro

OS knowledge is useful to know about how viruses and buffer overflows work.

# Process Memory and Stack

- Stack keeps track of function calls to know where to jump when a function returns. It also holds local variables, function parameters, return values.
- Text area contains compiled programs (or rather program instructions).
- Data section contains (e.g.) string literals from programs
- Heap contains runtime-allocated data (e.g. using `malloc` in C or `new` in Java)
- Heap and Stack grow towards each other

# Memory Organisation

Each process in an OS uses virtual memory. Can’t address memory outside this process – get a segfault when addressing non-existant memory or memory you don’t have permission to access.

The OS does provide APIs to communicate between processes (e.g. linux OS call `process_vm_read()`).

OS kernel code or shared libraries are mapped into each process’ virtual memory space.

# Simple Protection: Base and Limit

For every memory access, test that requested addresses fall between values `base` and `limit` – could use two registers, which the OS sets when switching processes. One problem here is that process code needs to know where it is stored in order to know which memory addresses it can access.

# Separate Address Spaces

Processes expect zero-based addresses, 0–n. Ideally we’d dynamically re-map addresses to hide the actual physical addresses from processes.

## Relocation Registers

On address access:

- check address is less than the limit
- if so add it to the offset to find the actual physical address

Usually bundled into a Memory Management Unit (MMU).

# Segmentation

Each process has some number of segments, and use base and limit per segment instead of per process.

# Fixed Size Memory Allocation: Paging

[more here]

# Common Configuration

- segmentation is rarely used
  - offers more flexible protection, but is visible to programmer (unlike paging)

[more here]

# Outro

- this is just an overview, based on linux, with a security focus
  - more to an OS than covered here
