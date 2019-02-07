---
title: Link Layer
date: 05/02/2019
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
