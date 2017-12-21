# What is the Internet?

Important points:

* There are many different connection types
* The internet is many networks, rather than just one

## Nuts & Bolts View

* Protocols control sending and receiving of messages
  * Examples: TCP, IP, HTTP, Skype, Ethernet
* The internet is a network of networks
  * It is loosely hierarchical
  * There's a public internet and private intranets
    * Private intranets e.g. in companies. Typically use the same protocols as the public internet, the difference is just who has access.
* Internet standards
  * RFCs (Requests for comments) are where standards are published.
  * They're published by the IETF (the Internet Engineering Task Force).
  * Anyone can attend the working groups where standards are defined.

## Service View

* Communication infrastructure enables distributed applications.
  * Examples: Web, VoIP, email, games, e-commerce, file sharing
* Communication services provided to apps:
  * Reliable data delivery from source to destination
  * "Best effort" data delivery
    * Occasionally the data won't get there, but methods of dealing with this are supplied.

## Protocols

* Sets of rules governing the exchange or transmission of data between devices.

People are very good at adapting to nuances of speech and social interaction (including different languages), but computers work best when there is no ambiguity in the communication. This is why we need protocols.

Protocols define:

* format and order of messages sent and received among network entities
* actions taken on message transmission or receipt

### Request-Response Protocols

This covers most network protocols:

* The client sends a message to a server requesting some information.
* The server responds by sending back a message to the client.

### Specifying Protocols

You need to specify the following:

* The set of message types (e.g. request, response, error)
* The format of each message
* The action to be taken when a message is received, including what response to send

If the specification is unambiguous, different implementations should be compatible.

### Implementing Protocols

* Network protocols are usually implemented in software.
* The software must faithfully implement the protocol specification.
    * The choice of programming language and operating system doesn't matter.
* This software must be installed at the client and server computers.
    * As long as the specification was adhered to, independent implementations *should* work together.

### Types of Protocols

* each protocol is designed for a specific purpose
* the most crucial protocols allow messages to be routed to the right destination and reliably delivered
    * their operation is largely invisible to end-users
* other protocols are more familiar, e.g.:
    * HTTP, which allows web browsers to send requests to web servers
    * BitTorrent, for peer-to-peer file sharing

# A Closer Look at Network Structure

* Network edge
  * Applications and hosts
* Access networks, physical media
  * Wired/wireless communication links
* Network core
  * interconnected routers
  * network of networks

# The Network Edge

The network edge is made up of end systems (hosts), which run application programs (e.g. web, email).

* Client/server and peer-to-peer relationships are defined only in software. To the network they look the same.

## Access Networks and Physical Media

How do you connect end systems to edge routers?

* Residential access nets
* Institutional access networks (university, company)
* Mobile access networks

Important criteria for comparing networks:

* Bandwidth (in bits per second)
* Is it shared or dedicated?
  * Is it 100 Mb/s for the neighbourhood or just for me?
* Price
* Security

Access networks are the first connection, from users devices to a router.

## Dial-Up Modem

* Rarely used anymore, but important because many parts of broadband specifications were developed in this context.
* Lowest-cost option, because everyone already had a telephone connection
* Telephone network is analogue, so all bits have to be converted to sounds for transmission.
  * Converted back to bits by the central office when sending to the ISP.
  * Correction: Connection from home to central office is analogue – internal communication between switches in the telephone network is digital.
* Can never get more than 64/56 kb/s, because of the way the telephone network works.
* Charged per minute.
* Can't take a phone call at the same time.

## DSL

* Can use a single line for phone and internet at the same time.
* DSLAM in the central office splits voice communication and internet communication to send to different places.
* Still uses existing phone infrastructure, so it's still cheap
* Rates are improving over time
* Note asymmetric down vs. up rates
  * Assumption: we download far more than we upload
  * Up until a few years ago, most people never uploaded
  * Nowadays with video broadcasting, torrenting, etc. people upload far more
* The closer you are to the central office (close = say 2-3 km) the better your data rate
  * Signal attenuates over distance (in any medium)
  * When further away, there's more uncertainty, so more redundancy is required
  * So the data rate has to be lowered

## Residential Access: Cable Modems

* Dominant in the U.S. but uncommon in Ireland
  * Only company is Virgin here
* Very important that it's shared access rather than dedicated access
* Mix of different technologies
* Separate channels for upstream and downstream as before

## Fibre to the Home

* Best option you can have (gold standard)
* Light is very fast, so low latency and high transmission rates

## Ethernet Internet Access

* Different requirements for institutions
  * Lots of different computers
  * Constant connection
* Internal data rates are very high, so the external data rates need to be *very* high.

## Wireless Access Network

* Data rates depend on a couple of things
  * Distance because of attenuation
    * If you're close to a base station, you'll get really good rates
* Always shared
  * Including WiFi
* Inherently less secure than a wired connection
  * Anyone can easily capture any traffic going back and forth

## Home Networks

## Physical Media

Difference between ethernet cabling categories is down to the materials used. Better materials means better speed capabilities.

### Coax

* Very rarely used these days, except for tv

### Fibre

* Cables surrounded by rubber to keep them dark as shielding


* Communication within buildings almost always copper
* Communication between buildings, between cities, between continents usually fibre
  * More data to deal with close to the core of the internet

### Radio

* Sometimes asymmetric communication - I can hear you but you can't hear me
  * This doesn't happen with wired communication
* Less secure and less reliable
  * Before WGB, used to be a wireless signal sent from the top of the Kane to other lecture building – foggy mornings meant terrible data rates

# Network Core

What we need to do (for the last section and this one and possibly in the future) is understand how different technologies differ across a number of different criteria.

The core of the network is made up of routers and switches.

The fundamental question is: how is data transferred through the net?

How can we forward data in the best way possible?

* Fastest
* Most efficient
* Most accurate?

There are two ways to transfer data:

* circuit switching:
    * dedicated circuit per call
    * this is used for the telephone net
* packet switching:
    * data is sent through the net in discrete chunks
    * this is used for the internet

Today's lecture is about why we use packet switching and not circuit switching.

## Circuit Switching

End to end resources are reserved for a call between two endpoints.

* link bandwidth is the switch capacity
* resources are dedicated – there's no sharing
* performance is circuit-like/guaranteed
* call setup is required
    * you need to tell the network in advance what you need

### Network Resources

* Divide them (e.g. bandwidth) into pieces
    * pieces are allocated to calls
    * resource piece is idle if not used by owning call (no sharing)

### FDM and TDM

#### FDM (Frequency-division multiplexing)

You allocate a different frequency to each user.

This is used in cable tv.

#### TDM (Time-division multiplexing)

Each user gets a time quantum.

    * First user goes
    * Then second
    * …

Each user gets the full channel for their time period.

The size of the time quanta determines how many users you can support over a fixed unit of time.

TDM is used in the digital telephone network.

## Packet Switching

* Divide file into chunks, send them one after the other
* Packets from different users share resources
* Each packet uses the full link bandwidth
* Resources used as needed

Resource contention:

* Aggregate resource demand can exceed amount available
* congestion: packets queue, wait for link use
    * the queue can overflow and packets can be lost
* store and forward: packets move one hop at a time
    * node receives complete packet before forwarding

### Statistical Multiplexing

Multiplex packets from users based on a statistical model onto one link.

* Some time slots are empty – no packets were in the queue to send at that time.

### Store and Forward

* Entire packet must arrive at a router before it can be transmitted on the next link.
* Transmission delays at each link are summed to give the total transmission delay.

## Packet Switching vs. Circuit Switching

* Packet switching allows more users to use the network.

Assume each user needs 100 kb/s when "active", and is active 10% of the time.

In circuit switching, we can support 10 users on a 1 Mb/s link.

In packet switching, we can support at least 10, depending on the probability of users being active at the same time.

If we have 20 users at the same time:

* In circuit switching, 10 users get no connection, they have to wait till the circuit is free
* In packet switching, 20 users get a connection, but are not getting the speed they need

If we have 1 user:

* In packet switching, the user gets the full bandwidth
* In circuit switching, the user still gets one tenth of the bandwidth

### Winner

Packet switching is good for bursty (VBR rather than CBR) data:

* resource sharing
* simpler, no call setup

But it has excessive congestion:

* packet delay and loss
    * protocols are needed for reliable data transfer, and congestion control

How can you provide circuit-like behaviour?

    * we need bandwidth guarantees for audio/video apps
    * this is still an unsolved problem - most solutions are not widely used

## Internet Structure

* very roughly hierarchical
* At the centre, "tier-1" ISPs (e.g. Global Crossing, Level 3, Sprint, AT&T)
    * They provide national/international coverage
    * They treat each other as equals
    * They interconnect (peer) privately
        * This to allow customers from different ISPs to access through their ISP to another
* "Tier-2" ISPs: smaller (often regional) ISPs
    * These connect to one or more ISPs
* "Tier-3" ISPs and local ISPs
    * last hop ("access") network (closest to end systems)

A packet passes through many networks.

As a general rule, you don't want too many hops, as the more hops lead to a greater chance to encountering congestion.

There's a utility called traceroute on unix systems which can tell which networks your communication goes through.

# Network Performance Metrics

## How Do Loss and Delay Occur?

* Packets queue in router buffers
* Packet arrival rate to the link exceeds the output link capacity
* Packets queue, wait for turn
* Arriving packets are dropped if there are no free buffers

Transmission delay is a function of bandwidth. If you have a higher bandwidth you can push things onto the connection faster.

There's also queueing delay.

### Four Sources of Packet Delay

1. processing delay
    * check bit errors
    * copy over to output queue
    * determine output link
    * usually negligible
2. queueing
    * time waiting at output link for transmission
    * depend on congestion level of route
    * depend on number of hops (routers)
3. propagation delay
    * function of the distance
    * = d / s (length of link / propagation speed in medium)
    * s e.g. 2 * 10^8 m/s in copper
    * can't change the distance or the speed of light easily, so have no control over this
4. transmission delay
    * L / R
    * L is the packet length
    * R is the link bandwidth

Size of what you're sending affects whether transmission delay or propagation delay is most relevant.

Nodal delay = processing delay + queueing delay + transmission delay + propagation delay

### Queueing Delay

Traffic intensity = `La/R` where:

* L is the packet length
* a is the average packet arrival rate
* R is the link bandwidth

### Packet Loss

Packets get dropped when router queues fill up. Lost packets may be resent from the source, or not.

### Throughput

Throughput is end-to-end.

It's the rate (bits per time unit) at which bits are transferred between sender and receiver.

* instantaneous is the rate at a given point in time
* average is the rate over a longer period of time

# Network

Common enough to have questions where you're given a network and you have to work out the delay.

Start by writing this equation: `D = T + P + Q` (processing delay is ignored as it's usually not significant).

* Next think about which of these you need to calculate
    * If there are no routers there's no queueing delay
    * If we're not told how long the wire is we can't calculate the propagation delay

# Throughput

What is the average end to end throughput when Rs < Rc? It's Rs.

When Rc < Rs? It's Rc.

The bottleneck link is the link on the end to end path that has the lowest available data rate. That one determines your throughput.

## Internet Scenario

The per-connection end-to-end throughput is min(Rs, Rc, R/10), where R is the shared link in the middle for 10 connections. In practice it's nearly always Rc.

# Network Protocol Architecture

Today's networks are very complicated (lots of different types of connections, lots of connections), and have very different applications (web, streaming, VoIP, gaming).

To deal with complexity:

* We need to cope with heterogeneity of function and requirements, including for example:
    * network speed, errors, latency
    * application security, reliability, quality of service
* Need to facilitate evolution of network elements and applications
    * upgrade to better technology
    * adapt to changing needs

## Layered Architectures

This is somewhat similar to abstraction in OOP.

* Similar network functions are grouped together into distinct layers
* Layers are organised in a stack, representing increasing functionality
    * And the dependency of a layer on the layer below
* Layering is an abstraction that enforces modularity
    * Makes it easier to change the network functions

Each layer implements a service via its own internal-layer actions, relying on services provided by the layer below.

### Internet Protocol Architecture

5. Application layer (L5)
    * This does application-specific functions (e.g. http, email, DNS, BitTorrent)
4. Transport layer (L4)
    * Common end-to-end delivery functions like reliability, security, e.g. TCP
3. Network layer (L3)
    * Core network functions for delivery of a packet across multiple links to the destination, e.g. IP (Internet Protocol)
    * There's only one protocol here (hourglass structure)
2. Link layer (L2)
    * Functions to deliver a packet across a single link, such as for error detection, e.g. WiFi
1. Physical layer (L1)
    * Defines the operation of a physical communication medium e.g. optical fibre

### ISO/OSI Reference Model

This is not widely used. It's considered to be a bit too complicated.

7. Application
6. Presentation
    * Allow applications to interpret meaning of data, e.g. encryption, compression, machine-specific conventions
    * This stuff is done in the application layer in IPA
5. Session
    * Synchronisation, checkpointing, recovery of data exchange
    * Also implemented in application layer in IPA
4. Transport
3. Network
2. Link
1. Physical

### Encapsulation

Each layer (except the physical layer) adds its own header. This is called encapsulating the packet.

In a router in the middle, the link header will be removed and replaced with a new one. This is needed because each link is different.

# Network Security

The field of network security is about:

* how bad guys can attack computer networks
* how we can defend networks against attacks
* how to design architectures that are immune to attacks

The fundamental problem is that the internet was not originally designed with (much) security in mind:

* original vision
[…]

## Malware

Malware can get in hose from a virus, worm, or trojan horse.

Spyware malware can record keystrokes, web sites visited, upload info to collection site.

Infected host can be enrolled in a botnet, used for spam and DDoS attacks.

Malware is often self-replicating: from an infected host, it can spread to […]

[…]

## Packet Sniffing

Record all packets passing through the network.

## IP Spoofing

Send a packet with a false source address.

## Record-and-Playback

Sniff sensitive info (e.g. password) and use later.

* password holder *is* that user from system point of view

# History

* Minimalism is important – you should be able to plug things into the internet and go with minimum effort.
* Best effort service model (anything else too hard)
* Stateless routers
* Decentralised control (greater resilience)
