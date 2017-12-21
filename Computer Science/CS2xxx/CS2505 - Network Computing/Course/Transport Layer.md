# Transport Layer

## Services and Protocols

* Every layer uses different names for the messages to emphasise that they're slightly different because you've usually added/stripped a header

## Multiplexing / Demultiplexing

* the most fundamental thing done by the transport layer
* info about how to demultiplex things must be stored in the transport layer

### How Demultiplexing Works

* source port often unimportant, picked randomly by client

### Connectionless Demux

* different clients can use the same source port numbers

### Connection-oriented Demux

* need to link destination with source

## UDP

* essentially just provides multiplexing/demultiplexing

* commonly blocked by firewalls because there's no congestion control

* most protocols (including UDP) will throw away a message if the checksum fails

* checksums are not absolutely reliable

## Principles of Reliable Data Transfer

* as the sender, how do I know my file didn't get there?

* have an unreliable channel at the network layer

    * congestion is the main reason – packets get dropped from queues

    * packets can also get corrupted over wireless networks

    * packets can arrive in the wrong order

### Getting Started

* packet has extra header with info required by the reliable data transfer protocol

* protocols often generated from finite state machines that are written by people (rather than writing the protocol line by line)

* gradually complicate specification/requirements (1.0, 2.0, …)

* checksums not great, but we'll assume for the moment they're sufficient

    * also cyclic redundancy checks (CRC) – much stronger than checksums

* A without bar in state machine diagram means "no action taken"

2.1 sender has four states – two for each packet

* two sequence numbers is enough because the next packet isn't sent until the current one has definitely arrived

* In 3.0 receiver will send ACK0 if it gets packet 1 but it's corrupted

* 3.0 is called a "stop and wait" protocol

    * performance is terrible because you don't send a second packet until a whole round-trip time has happened

    * "stop and wait" protocols are used in wifi, where the round-trip time to the access point is very small


## Reliable Data Transfer (cont.)

* stop and wait operation used in wifi connections because they're unreliable, and the round-trip time to the access point is small

### Pipelined Protocol

* send a bunch of packets
* then receive acks for those

Two main types:

* go-back-n
* selective repeat [check]

TCP is a mixture of these two

Pipelining can improve throughput hugely.

#### Go-Back-N

* sender sends up to N packets in the pipeline

* receiver sends cumulative acks (stops if there's a gap)

* sender keeps timer for the oldest unacked packet, and retransmits all unacked packets if the timer expires

* in practice, acked packets wouldn't be kept by the sender, just deleted once acked

* logic is "if one got lost, some or all of the rest probably did as well"

* inefficient if there are many packets in the pipeline (large window) and an error occurs

    * all packets will be retransmitted unnecessarily

#### Selective Repeat

* sender up to N unacked packets in pipeline

* receiver acks individual packets

* sender maintains timer for each unacked packet, resends the packet when its timer expires

* receiver needs a buffer as packets may arrive out of order

* in practice wouldn't keep acked packets, but would mark that they've been received and acked

* receiver's window needs to be limited because otherwise connections could easily use up all its memory

* not sure about acking of packets from before base - N

##### Dilemma

* what minimum sequence number do you need if given the window size?

## TCP

* hasn't changed much over time (since the 1970s), except for some algorithms for congestion control and some other things

    * it has stood the test of time

* call packets "segments" at the transport layer

Assumes point-to-point – one sender and one receiver. UDP doesn't assume this.

Byte stream – no message boundaries. (where segments start and end is irrelevant to the application layer)

Full duplex – bi-directional data flow in a connection.

Have to set up a connection before sending any data.

Flow controlled – sender will not overwhelm receiver.

Congestion control – ensures sender won't overwhelm the network.

Two options for sending segments smaller than the maximum segment size (MSS):

1. timeout
2. push request from application

Segments can also be sent when the buffer reaches the MSS.

### TCP Segment Structure

* source port and destination port used for multiplexing and demultiplexing

* sequence numbers and ack numbers needed for selective repeat or go-back-n

    * these count numbers of bytes of data, rather than packets or segments

    * needed because TCP is a stream of data rather than a sequence of messages

* treats application data as a meaningless bunch of bits (encapsulation)

* need a header length because the options section has variable length

* note: when looking at headers, important to think about the implications of the sizes of fields

* we can have 2^32 unique sequence numbers

    * with a 2.5 Gb/s link sending constantly, you'll wrap around in 14 seconds, which is a problem

    * TCP solves this using a timestamp in the options section

* protocols tend to start fields on word boundaries because it makes processing easier at the receiving end

Flags:

* A marks as ack

* U means urgent

    * not widely used

* S marks a SYN

    * used for establishing connection

### TCP Connection Management

#### Setup

Three-way handshake:

* client sends SYN

    * specifies initial sequence number

        * usually picked at random to allow for successive short connections between the same client and server

* server responds with SYNACK

    * also allocates buffers and specifies initial server sequence number

* client sends ACK, which may contain data

#### Closing

* either party sends a FIN message

* other party receives, sends its own FIN

* first party receives FIN, sends an ACK, and then waits for a short while before closing the connection (say 1-2 minutes)

### TCP Sequence Numbers and ACKs

ACKs and data are sent in the same messages.

* sequence number refers to the byte stream number of the first byte in the segment's data

    * in an empty message (an ACK with no data), it's the same as the last number

* ACK number refers to the next expected byte

    * cumulative ACK

### TCP Reliable Data Transfer

* offers pipelining

* uses cumulative ACKs

* uses a single transmission timer

* retransmissions are triggered by:

    * timeouts

    * duplicate ACKs [need to work this one out]

* […]

### TCP Sender Events

Note not using FSMs because it's too complicated.

When data is received from an application:

* create segment with sequence number

* sequence number is the byte-stream number of the first data byte in the segment

* start timer if not already running (think of timer as for the oldest unacked segment)

[…]

* pseudocode is simplified: don't send packets straight away to the network layer (MSS etc.)

#### Retransmission Scenarios

* lost ACK

* premature timeout

### TCP ACK Generation (Optimisations)

* receiver receives in-order segment with expected sequence number, all data up to expected sequence number already acked

    * delay the ACK – wait up to 500 ms for next segment. If no segment, send ACK

* arrival of in-order segment with expected sequence number. One other segment has an ACK pending.

    * Immediately send single cumulative ACK, ACKing both in-order segments.

* arrival of out-of-order segment with higher than expected sequence number. Gap detected.

    * immediately send duplicate ACK indicating sequence number of next expected byte.

    * helps sender tell that the link is still good if only one segment doesn't get through, allows fast retransmit

### Fast Retransmit

If the sender receives 3 ACKs for the same data, it assumes the segment after the ACKed data was lost.

* made a dramatic improvement to TCP throughput

[…]

### TCP Selective ACKs

* non-mandatory extension that is widely used

* receiver can ACK a sequence of bytes in addition to the number of the next expected bytes

    * even if there's a gap, confirms some segments did arrive

* sender can re-send only packets that haven't arrived

### TCP Round-trip Time and Timeout

* timeout for stop-and-wait protocol in a wifi access point is pretty deterministic (easy to work out), once you've sent your packet

* note: stop-and-wait in wifi is actually used in the link layer

* for end-to-end tcp, it's much harder – have to account for transmission and queueing delays on all routers

Dangers of getting timeout wrong:

* under-estimate

    * redundant packets transmitted, decreasing throughput (and contributing to congestion)

* over-estimate

    * decrease throughput because lots of waiting

So we want the timeout to be longer than the roundtrip time.

Sender keeps a running average of the roundtrip times and uses that to set the timeouts. (ignores retransmissions)

#### Current Model

`EstimatedRTT = (1 - a)*EstimatedRTT + a*SampleRTT`

* Exponential weighted moving average

    * want to balanced between the influence of the average value and of the most recent value

        * want to ignore outliers, but don't want to ignore sudden changes to the network

* influence of past sample decreases exponentially fast

* typical value: `a = 0.125`

#### Example

Note: samples jump around mostly due to queueing dynamics

#### Setting the Timeout

* Look at the variance of the estimate to tell how accurate it is

    * use a weighted moving average of the variance

* add a safety margin to account for that

    * through experimentation, it's been seen that a margin of 4 times the variance average works well

* if every packet has the same RTT, then the deviation will be 0

### TCP Flow Control

* Without flow control, if the receiver's buffer fills up, the sender will keep sending and a lot of packets will be discarded.

* flow control matches the send rate to the receiving application's drain rate

#### How It Works

* receiver keeps track of unused buffer space as `rwnd` (receive window)

* receiver advertises unused buffer space by including `rwnd` value in segment headers

* the sender limits the number of unACKed bytes to `rwnd`

    * this guarantees the receiver's buffer doesn't overflow

#### Example

Slow receiver:

* receiver buffer fills up and window shrinks to 0

* sender learns of empty window and stops

* sender buffer fills up with bytes from its application process

* sender TCP asks OS to block the application process

* once the receiver catches up, the window opens again, and the sender TCP learns the new window size

    * how does it learn the window size again? It's not sending anymore, so there's nothing for the receiver to ACK

    * uses probing – sends a 1-byte message every now and then to trigger an ACK from the receiver

        * chose this over having the receiver send an ACK when the window opens because it doesn't seem to fit with the philosophy of TCP – normally everything a receiver does is a response to something it was sent

* sender resumes transmission

* sender buffer frees up

* sender TCP asks OS to unblock sender process

### TCP Congestion Control

* reduce sending rate so as not to lose things in the network buffers between the sender and receiver

* harder than flow control because there are more buffers, and their occupancy doesn't just depend on what you send

Goal:

* TCP sender should transmit as fast as possible, but without congesting the network

    * how do you find a rate just below the congestion level?

* decentralised: each TCP sender sets its own rate, based on implicit feedback:

    * ACK: segment received (a good thing!), network not congested, so increase sending rate

    * lost segment: assume loss due to congested network, so decrease sending rate

        * could be for other reasons (e.g. packet was corrupted), but is almost certainly because of congestion

        * this assumption caused problems in early wireless networks

            * no longer a problem because wireless networks now recover lost packets at lower layers

    * needs to be decentralised, because of the rapid changing of the network (buffer occupancy, etc.)

    * there are explicit feedback methods, e.g. DECBIT and ECN

        * ECN isn't widely used because it's complicated (even though it is widely deployed)

#### Bandwidth Probing

By increasing on ACK receipt and decreasing with each loss (with a faster decrease than increase), you get a sawtooth plot.

#### Congestion Window

sender limits rate by limiting number of unACKed bytes in pipeline:

    * last_byte_sent - last_byte_acked <= cwnd

    * `cwnd` is the congestion window, only relevant to the sender

    * the sender is limited by `min(rwnd, cwnd)`

#### More Details

* segment loss event:

    * timeout – no response

        * cut `cwnd` to 1

    * 3 duplicate ACKs – at least some segments getting through (recall fast retransmit)

        * cut `cwnd` in half (less aggressive than on timeout)

* ACK received:

    * slowstart phase

        * increase exponentially fast at connection start or following timeout

    * congestion avoidance

        * increase linearly (increase by one every time you get an ACK)

### TCP Slowstart

* start with `cwnd = MSS`

* available bandwidth may be >> MSS/RTT

    * desirable to quickly ramp up to a respectable rate

* increase rate exponentially until first loss event or when threshold reached

* increase threshold with each ACK you receive (this gives exponential behaviour), increase by MSS

[…]

### Transition into/out of Slowstart

`ssthresh` – `cwnd` threshold maintained by TCP

* on loss event – set `ssthresh` to `cwnd / 2`

    * remember half of TCP rate when congestion last occurred

* when `cwnd >= ssthresh` – transition from slowstart to congestion avoidance phase

### TCP Congestion Avoidance

AIMD – additive increase, multiplicative decrease

* when cwnd > ssthresh grow cwnd linearly

    * increase it by 1 MSS per RTT

    * approach possible congestion slower than in slowstart

    * implementation […]

### Fast Recovery

3 duplicate ACKs treated differently from full timeout

## Flavours of TCP

There are many different flavours.

Reno and Tahoe are the most popular – Reno is the most widely deployed one.
