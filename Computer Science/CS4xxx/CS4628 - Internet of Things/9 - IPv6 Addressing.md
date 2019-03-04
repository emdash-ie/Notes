---
title: IPv6 Addressing
dates:
- 4/03/2019
...

# Intro

Current routing protocols are not suitable for smart object networks. IETF formed the ROLL working group to work on a solution. First question: mesh-under or route-over?

Problems with mesh-under:

- path properties hidden in lower layer, makes IP routing hard
- assumes the same link-layer technology across the whole network

# IPv6 Addressing

An IPv6 address has 128 bits. Defines an interface connected to a link. An interface often has multiple addresses. Every address except the unspecified address has a scope – this specifies which part of the network it’s valid in, can be a global or non-global (link) scope.

## Address Classes

Three classes: unicast, multicast, anycast. No broadcast address.

- Unicast:
  - uniquely identifies an IPv6 interface
- Multicast:
  - identifies a group of IPv6 addresses
- Anycast:
  - assigned to multiple interfaces
  - A packet sent to an anycast address is delivered to just one of these interfaces (usually the nearest one)
  - “Nearest” is decided by the routing protocol
  - Used for redundancy and load-balancing

## Abbreviation Rules

1. Leading zeroes must be suppressed (0222 -> 222)
2. A 16-bit block with all zeroes is zero (0000 -> 0)
3. Consecutive zeroes can be represented as `::` (:0000:0000: -> ::)
  - Can only do this once
  - Not for a single 0 field
  - `::` is greedy (2001:0db8::0001 -> 2001:0db8::1)
  - Have to replace only the longest run of zeroes by `::`
  - When multiple candidates are longest, shorten the first one

## Special Addresses

1. Unspecified address: (`0:0:0:0:0:0:0:0` -> `::`)
2. Loopback address: (`0:0:0:0:0:0:0:1` -> `::1`)

## Prefix Notation

Specifies how much of the address is used as network address, and how much indicates the host. Example: `2001:db8:0:56::/64`

Prefix length can range from 0 to 128, typical length is 64. Usually:

- 48 bits for global routing prefix
- 16 bits for a subnet ID
- 64 bits for an interface ID
  - Typically made from the MAC address, following a specific procedure (EUI-64 identifier?)

A prefix identifies a set of addresses.

## Reserved Multicast Addresses

1. All-nodes multicast address
  - `ff02::1`
2. All routers multicast address
3. Solicited-node multicast address
  - Used instead of ARP (uses MAC address to get IP address)

# Stateless Auto-configuration

A device can autonomously derive its link-local and global addresses – protocol is based on ICMPv6.
