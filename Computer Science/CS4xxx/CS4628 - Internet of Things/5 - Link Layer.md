---
title: Link Layer
dates:
- 05/02/2019
- 11/02/2019
- 12/02/2019
...

# 802.15.4

- defines both physical- and mac-layer standards, but the mac-layer ones are often not used, in favour of more efficient proprietary standards

## Device Types

Two types of device:

- fully-functional
  - can send beacons and route frames
  - can act as PAN co-ordinator
  - usually permanent power supply
- reduced function
  - can’t route frames
  - can only communicate with FFDs
  - usually battery-powered

## Topologies

Simplest is star, but it’s awkward to require everything to be within range of the PAN co-ordinator. Then you have cluster-tree, and mesh. In mesh there can be multiple paths from an RFD to the co-ordinator, which I think is the defining difference. (Cluster-tree looks like a tree)

## Frequencies

There are different frequency ranges allowed in different countries.

Higher frequencies have greater power efficiency, but penetrate walls less well, so sometimes lower frequencies are preferable.

## PHY

- Preamble indicates something is coming
- Start frame delimiter indicates the end of the preamble
- Length included in header

## MAC

- Four types
  - data
  - beacon
  - ACK
  - command

Large header overhead.

### Addresses

- no address signifies the co-ordinator

### Beacon-Enabled Mode (Superframe)

Generally the management of slots is done by the transceiver chip, to save you from needing to do it in the OS, which may be event-based.

- contention-based
  - slotted CSMA-CA
  - pick a slot, try, backoff if collision
- contention-free
  - reserved time slots
  - elect a leader to allocate the slots
  - some protocol for reserving them (there are a few)

## Time Synchronisation

Beacons are used for timesynchronisation. Without any synch, the clocks drift out by e.g. minutes after a day. Could use GPS on all nodes to get nanosecond precision, but that’s a huge energy drain.

Extend the duty cycle of the devices using the time between beacons (devices only need to wake up for beacons if they’re not sending or receiving) to save energy. This is a trade off with response time, though.

## Clear Channel Assessment

Simple version: check if the energy is over a certain threshold

More complicated: check for modulation scheme (sometimes there’s energy but it’s not using your communication scheme, so you can maybe transmit anyway without collision).

## Hidden Terminals

A and B both transmit to C, but can’t see each other. Collision happens at C, but A and B don’t realise.

- Powers from A and B are usually different, so you can ignore the weaker message and receive the stronger one correctly
- Also depends on which one starts first

So you can usually detect one of two messages in a collision. Can design protocols around transmitting at the same time in the hope that one message (or both) gets through ok.

Wifi uses CTS (Clear to Send) and RTS (Ready to Send) messages to overcome this problem, but for embedded devices this is a high energy overhead. Modern Wifi with higher data rates doesn’t do this anymore either though.

## Real World

-multi-path fading
  - signals bounce off walls etc., and you get multiple copies overlaid (not a single clear signal)
  - need to look this up

## Temperature Effects

[more here]

# Wireless MAC Limitations

- unbounded latencies due to contention (bad for real-time environments)
- no guaranteed bandwidth (even with GTS, only 7 slots)
- intrinsically unreliable

- prone to multi-path fading
- prone to readio interference
- cheap radio transceivers not suitable for harsh environments (e.g. temperature variations may break CSM-CA)

## Amendment

May want to go wireless to avoid being cut off by wire damage, to aid quick reconfiguration, etc.

Amendment to the standard in 2012:

- Enhances and adds MAC functionalities
- Aims to better support industrial markets
- Allows compatibility with the modifications proposed by the Chinese WPANs

Time-slotted channel hopping (TSCH):

- slotted access
- shared and dedicated slots
- multichannel communication
- requency hopping

## Network Formation

- Difficult due to frequency mismatch
- Use enhanced beacons
