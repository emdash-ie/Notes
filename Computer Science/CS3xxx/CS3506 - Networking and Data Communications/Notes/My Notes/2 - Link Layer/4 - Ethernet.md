% 4: Ethernet
%
% Tuesday 7th of November, 2017

# Intro

Ethernet is the dominant technology – it’s simple and cheap, and widely deployed.

Hard to replace it with token LANs or ATM, because it’s so dominant.

# Frame Structure

Need preamble to show that a packet is starting, because otherwise you don’t know when packets are coming. It also allows you to synchronise the clocks between sender and receiver.

The type field identifies a higher-layer protocol – usually IP but sometimes others e.g. AppleTalk in the past.

The CRC is checked at the receiver, and the frame is silently dropped if there are errors.

# Characteristics

Ethernet has no connections – no handshaking between senders and receivers.

No ACKs or NAKs are used, and so the channel is unreliable.

There’s no flow control, so if a receiver can’t receive as fast as the sender can send, packets will be dropped. It’s assumed that this won’t happen, and in practice it doesn’t.

Ethernet is unslotted – there’s no time synchronisation.

# Standards

802.3 are the ethernet standards.
