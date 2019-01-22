# Tiny and Low-Cost

- Getting the cost low enough is a problem – at the moment things cost more than their benefit in a lot of cases

# Wirelessness

- Sometimes you already have wires in place, which means you can avoid the problems of wireless communication
- Also doesn’t have to be radio-based – can use e.g. visible light (LEDs + photosensors)
- But for most a radio transceiver is used
- WiFi normally not used (missed reason)

# Data Rates

If using LoRa, you can transmit 2-3 kilometers, but a lot of the time that’s unnecessary. If the receiver is pretty close, then it’d be more power-efficient to configure the LoRa for low range for this communication.

For LoRa, there are something like 7,500 configuration options, so you have to deal with that if configuring.

# Protocol Control

For many transceivers, you don’t have access to the protocol they use – you just give them some bytes to transmit. The amount of abstraction varies, trading amount of control for effort required in software.

# Recent Improvements

Both processor speed and storage have increased recently, enabling more applications.

# Communication

Not just simple embedded systems anymore, you also have interaction with the physical world and communication.

But now everything seems to be networked anyway, even the most trivial devices. (E.g. cars, brake lights)

# Communication Patterns

- Single-hop vs. multi-hop.
- one-to-one vs. one-to-many

With one-to-many, want to minimise power use (e.g. power cost of forwarding). Maybe minimising power use per node as well?

Communication pattern configuration (e.g. of a tree) needs to be dynamic, as wireless links change in quality over time. Communication is also lossy. (Lossless communication takes a lot of power.)

Can be useful to avoid all this trouble (e.g. with LoRa) by using direct communication with a base station. In this way you swap one problem domain for another, which may suit your application better.

Because of lossy nature, hop count isn’t enough – also need to know about the link quality. E.g. also ETX (expected number of transmissions) as a metric.

# Interconnection

- Technical: design of protocols and mechanisms
  - device level
  - network level
- Non-technical: how to spread the tech and awareness of the tech
  - evolvability
    - we don’t know the future of the tech, so for embedded devices etc. we don’t want to limit ourselves to what we have thought of already
  - standardisation
  - interoperability

# Power

- Radio transmission and listen are the biggest power consuming activities
