# NAT – Network Address Translation

Have the same external IP addresses for all interfaces on an internal network, and map different port values to different unique internal IP addresses.

Has the benefit that it doesn’t use up too many addresses, and also allows you to change the layout of your network much more freely.

Also, no-one can connect directly to your machine.

There are some situations (e.g. running a web server) where this is a disadvantage – you’d like to be able to connect to the internal computers from outside.

## Things to Worry About

* Still limited to about 60,000 internal addresses per external address

* Router is now doing quite a lot of work allocating port numbers for every flow

* Routers should only process up to layer 3 – NAT violates the end-to-end argument.

    * end-to-end: push functionality to edge of network, only do in the middle what’s absolutely necessary

    * p2p protocols have difficulty with NAT

* Address shortage should instead be solved by IPv6

## Nat Traversal Problem

Want to contact a server that’s behind NAT.

* solution 1 – static mapping (manually assign ports)

* solution 2 – Universal Plug and Play

    * automates static mapping, has lease times

* solution 3 – relay (e.g. Skype)

## ICMP

This is a protocol that’s used by hosts & routers to communicate network-level information:

* error reporting
* echo request/reply (used by ping)

Protocol doesn’t require responses (some people may not want to reply due to e.g. corporate sensitivity of info, etc.).

The protocol is a network-layer protocol above IP (ICMP messages stored in IP datagrams).

### Traceroute and ICMP

Send a series of UDP segments to the destination, with sequential TTL values. When the TTL expired ICMP responses come in, we know the first-hop, second-hop routers etc.

## IPv6

The initial motivation was that the 32-bit address space was soon to be completely allocated.

The key question was how to deal with the shortage of addresses.

Studied inefficiency of allocation in phone network hierarchical addressing, concluded that 128 bits were needed to account for that inefficiency.

However, now the IP header is going to be very big, leading to a lot of redundancy.

There’s now a 40-byte header (up from 20).

There were also some additional motivations:

* make sure the new header format helps speed processing/forwarding

* change the header to facilitate QoS

    * the idea that some flows are more important than others

* security

    * not considered for IPv4

* mobility

To save space, some things were removed:

* checksum

    * most link-layer protocols have their own methods of detecting bit errors, so it seems redundant

    * also because the TTL changes at each hop, the checksum has to be recalculated at every hop

* fragmentation

    * now packets that are too big will be dropped, and an ICMP message sent back to the sender to tell them to break it up and send it again

    * this simplifies things

### IPv6 Header

New features:

* priority

    * used for QoS

* flow label

    * mark datagrams as being from the same flow

* next header

    * allow easy extension of header protocol with a reference to the next header (like in a linked list)

    * can add e.g. security headers or timing headers

### IPv6 Addresses

Classless addressing/routing (similar to CIDR)

Notation is 16-bit hex numbers separated by colons.

IPv6 adds explicit support for locally-unique addresses, and they have also reserved spaces within the address space and been careful about allocating addresses.

### IPv6 Auto-Configuration

Replaces DHCP. Broadcast an address to the network to say you’re going to use it, asking if anyone else is using it.

### Other Changes

[…]

* ICMPv6

### Extension Headers

* Routing

    * Specify that you don’t want packets travelling over a specific network

* Fragmentation
* Authentication
* Encapsulation
* Hop-by-hop option
* Destination options

### Transition From IPv4 to IPv6

Not all routers can be upgraded simultaneously.

* How will the network operate with mixed IPv4 and IPv6?

    * Tunnel IPv6 inside IPv4 (putting IPv6 packets inside IPv4 packets)

        * What about fragmentation at the IPv4 bit?


