---
title: IPv6 Basics
dates:
- 25/02/2019
...

# Intro

- revised version of IPv4

Mainly invented to deal with IPv4 address exhaustion, as all IPv4 address blocks have been allocated as of 2011.

# Network Address Translation

NAT was used to bridge the gap between IPv4 and IPv6, but breaks network transparency and causes problems.

[more here]

# Base Header

Only has 8 fields (vs. 14 for IPv4). Ditched some stuff that hasn’t been useful.

Still a much bigger header, which means a lot of overhead for IoT applications.

# Extension Header

Base header is followed by 0 or more extension headers.
