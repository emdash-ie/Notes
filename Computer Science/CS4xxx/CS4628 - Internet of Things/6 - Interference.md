---
title: Interference
dates:
- 19/02/2019
...

# Motivation

Networks usually have to share a frequency space, e.g. WiFi and Zigbee coexist, or there can be interference caused by electric devices like microwaves.

Problem space:

- How does interference impact on performance?
- Packet reception rate? Energy consumption? Other stuff?
  - Devices may wake up to receive a message, mistaking interference for an incoming message.
- Can we estimate interference impact before deployment?
- How can we capture interference in a deployment area?
  - Can we find stable, predictable patterns?

# Capturing Interference

Interference is produced from a variety of sources, varying in frequency, duration, and strength. What detail of the interference signal do we need to capture?

How meaningful is a captured pattern for predictions?

Nodes that are deployed anyway should be used to measure interference (to save hardware cost, time, and enable later re-sampling).

Could also record many environments to get a “typical” environment profile.

Traces can be recorded by high-ferquency sampling of RSSI.

- This is memory intensive
- Need to reduce the data volume

Could only sample whether interference is above a threshold, which reduces the memory requirement. (Record busy and idle periods.)

Can reduce volume further by recording only statistical properties (probability distribution functions).

# Packet Reception Rate Prediction

[more here]
