# True-False Questions

There tend to be true-false questions, like:

* A router is classified as an edge or core device?

    * core

* HTTP is an application layer protocol.

    * true

* DNS is mainly used to find the IP address corresponding to a hostname.

    * true

    * also does some geolocation-type features

* Link bandwidth is measured in ms.

    * false

* Checksum in UDP allows the receiver to detect errors in the received segment.

    * true

* SNMP is a protocol for internet email delivery.

    * false

    * actually network management

* 10,000 kbps > 100 mbps?

    * false

* DSL uses the existing phoneline rather than a dedicated fibre link.

    * true

* UDP uses port numbers to identify the destination host computer.

    * false

    * port numbers identify the process on the destination computer

* there are 5 layers in the internet protocol architecture

    * true

    * 7 layers in the OSI model

# Autumn 2013

## Q1 (b)

* bandwidth […]

* throughput […]

* queueing delay measure in ms, amount of time packets spend in queue between the sender and destination (queues are in routers)

* congestion is when the queues in routers are overflowing and packets are getting dropped. A router is congested if it drops a packet because the queue is full.

* statistical multiplexing is about sharing links – sender is given access to the whole link for the duration of sending its packet. Copes very well when there isn't a fixed number of senders, and when you don't know what the traffic demand of the senders is. Can have congestion though.

## Q2 (a)

* technical attributes: latency, contention, security, bandwidth, symmetric/asymmetric

* latency related to throughput

* contention: connection shared or do you have it all to yourself?

    * e.g. ADSL not shared with neighbours

    * at some point you share the link (after the access point)

    * cable modems shared with neighbours

    * fibre to the home should have no contention

        * depends on the type of fibre

    * cellular is shared

* security

    * wireless is the easiest for someone to capture your packets

    * more difficult for other technologies

* bandwidth

    * fibre to the home is the gold standard (based on the technology)

    * ADSL limited by distance from central office

    * cable modems limited by contention

    * cellular is the lowest

* symmetric

    * ADSL is asymmetric

    * cable modems also asymmetric

    * fibre to the home usually symmetric

    * cellular usually asymmetric

## Q2 (b)

* calculation question

i. 1 Mb/s is the bottleneck

ii. calculation

    * think about queueing delay, transmission delay, and propagation delay

    * normally would need to calculate propagation delay yourself

    * propagation delay on each link

    * need to calculate transmission delay for each link

# General Points

* less is more and bullet points are appropriate

* this year's exam will be roughly the same (structure-wise) as previous years

* these things will not be on the *summer* exam:

    * ftp / email

    * network management

    * lab material (socket programming etc.)

    * network security and network history

* lecturer is open to emails and also you can send him sample answers for feedback
