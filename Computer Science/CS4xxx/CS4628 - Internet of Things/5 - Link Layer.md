---
title: Link Layer
dates:
- 05/02/2019
- 11/02/2019
- 12/02/2019
- 18/02/2019
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

# Bluetooth and Bluetooth Low-Energy

- Wireless technology for cable replacement
- Designed for phones, e.g. for connecting to headsets
  - This means it is unsuitable for other purposes sometimes

## Key Features

Low-power
[more here]

## Frequency Spectrum

- chose 2.4 GHz, as it’s unregulated space in most countries
- conflicts with other things (e.g. Wifi)

Transmit power grouped into classes, trading power consumption for transmission range.

Security: challenge/response authentication, AES-128

Radio frequency hopping: 1600 times/sec. Common hopping sequence for all devices of a piconet.

## Piconet

Leader-follower split – leader sends clock and device ID to followers. No direct communication between followers.

## Scatternet

Piconets with overlapping devices.

Hopping times and frequencies are not synchronised, so you get random collisions. 10 piconets within the saem range decrease the data rate by roughly 10%.

A device can share different piconets (a bridge device), but can only be leader in one.

## Looking for Nearby Devices

Discoverable devices enter inquiry scan state periodically to make themselves available to inquiring devices.

[more here]

## Basic Communication

Slots are dedicated to a leader or a specific follower. Leader polls followers and follower uses next slot to answer.

There are contol packets as well as data packets:

- `NULL` packet for ack (follower has no payload to transmit)
- `POLL` packate when leader has no payload to send

As leader organises slots and polls, it’s continuously active even if there’s no data to transmit. This power use is impractical for an IoT device, which is why bluetooth isn’t very suitable. (Leader device for normal bluetooth would be e.g. a phone, where the battery capacity is big enough that this isn’t as much of a concern.)

## Mixed Synchronous and Asynchronous Communication

- still poll and request, but some difference?

## Error Correction

When packet doesn’t get through due to interference, it’s usually the header bits that have been interfered with. To counteract this, the header is transmitted 3 times.

Couple of options for data:

- transmit 3 and make a majority decision (2 say this, 1 says that, the 1 must be corrupt)
  - 1/3 data rate
- use (15,10) Hamming code
  - 2/3 data rate
- no protection
  - full data rate

## Bluetooth to Bluetooth Smart™

Some problems with bluetooth:

- not low-power enough for coin cells and energy harvesting
  - traditional bluetooth is connection-oriented, maintains a link even if no data is flowing
  - long an complex discovery process
- piconet only supports up to 7 follower devices

## Bluetooth Low-Energy (BLE)

New standard to overcome limitations with bluetooth. Based on Nokia’s WiBree technology, merged into standard in 2010 (Bluetooth v4.0).

Main features:

- new physical layer
- new advertising mechanism for easy discovery and connection
- explicit support for broadcasting applications
- asynchronous connectionless MAC
- low-enery (1–50% of classic bluetooth)
- [more here]

### Dual Mode or Single Mode

Typically one chip will support both bluetooth classic stack and BLE stack, being a dual-mode chip. This makes the chips complicated (sometimes more powerful than the main CPU, to manage the complexity).

### Physical Layer

3 advertisement channels, in between WiFi channels (to avoid interference).

### Device Roles

Four roles:

- connection-based:
  - central device
  - peripheral device
    - can operate as follower (e.g. thermometer, heart rate sensor)
- unidirectional-communication:
  - observer
    - scans for ads without initiating connections
  - broadcaster

[more here]

### Advertising Mechanism

- central device can query peripheral device for details
- can have non-connectible devices, which only broadcast and don’t receive

### Generic Attribute Profile

Profiles contain services, which contain characteristics.

[more here]

### Latency

Very low-latency connection (~3 ms per transaction).

### Control

Bluetooth abstracts a lot of the difficulties of the communication, but takes control away from the application. Isn’t used where that control is needed.
