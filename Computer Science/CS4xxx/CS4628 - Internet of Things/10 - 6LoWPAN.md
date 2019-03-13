---
title: 6LoWPAN
dates:
- 5/03/2019
...

# Intro

IPv6 over low-power wireless personal area networks. Avoids some of the large overhead of IPv6, which doesn’t suit embedded devices.

# Adaptation Layer

## Dispatch Byte

First byte of the payload used as a dispatch byte. First two bits signal which 6LoWPAN headers are used:

- `00`: Not a 6LoWPAN frame
- `01`: IPv6 addressing header
- `10`: Mesh header
- `11`: Fragmentation header (6 lower bits are 100xxx)

# Header Compression
