# Application Layer

We use the internet to do a lot of different things – the applications are different in terms of what they expect from the network underneath.

As we go through, think about how each application is different from the ones we've already seen in terms of how it interacts with the network. The further down the stack you go, the fewer protocols there are.

We will look at a lot of examples – we're aiming to learn the principles and concepts, not the particular details of any particular protocol.

## Creating a Network App

Write programs that

* run on different end systems
* communicate over the network
* e.g. web server software communicates with browser software

No need to write software for network-core devices, means anyone can go and write an application that communicates with any protocol, and it'll work over the internet.

Having applications only on end systems allows for rapid app development and propagation.

### Internet Addressing

Every computer on the internet gets a unique IP address:

* This is assigned when it connects to the network
* Used to identify the destination when sending a packet
* Used by receivers to check who sent the packet (and to reply)

For convenience we often use hostnames, but these are mapped to a corresponding IP address when sending a packet.

* e.g. cs1.ucc.ie -> 143.239.75.218

Using hostnames is easier and less error-prone for people.

### Application Architectures

* client-server
    * including data centres / cloud computing
    * e.g. web server – expect it to always be available, whereas clients come and go
    * always-on host with permanent IP address
    * clients may have dynamic IP addresses
    * clients don't communicate directly with each other
* peer-to-peer
    * bunch of clients get together and exchange info
    * no always-on server
    * peers are intermittently connected and change IPs
    * highly scalable but difficult to manage
* hybrid of those
    * e.g. Skype
        * voice over IP P2P application
        * centralised server to find the address of a remote party (and tell what address you're currently at)
        * client-client connection is direct, not through a server
    * Instant messaging
        * similar to above

## Processes Communicating

Within the same host, two processes communicate using inter-process communication, which is defined by the OS.

Processes in different hosts communicate by exchanging messages.

* A client process initiates communications
* A server process waits to be contacted
* applications with P2P architectures have client processes and server processes

### Sockets

A process sends/receives messages to/from its socket. A socket is an API.

1. have to make choice of transport protocol
2. have the ability to fix a few parameters
    * e.g. allocate lots of buffer memory to me because I'm going to get a lot of messages

### Addressing Processes

Host device has unique 32-bit IP address (IPv4) – this is combined with a port number to give an identifier associated with a specific process on a host.

## App-layer Protocol

This defines:

* the types of messages exchanged
    * e.g. request/response
* message syntax
    * what fields in the message are and how the fields are delineated
* message semantics
    * meaning of the information in the fields
* rules for when and how processes send and respond to messages

Most protocols are public-domain protocols, mostly available on (IFC website?):

* defined in RFCs
* allow for interoperability
* e.g. HTTP, SMTP, BitTorrent

There are also proprietary protocols:

* e.g. Skype, ppstream

## What Transport Service Does an Application Need?

Different apps expect different things:

* data loss
    * some apps (e.g. audio, voice, games) can tolerate some loss
    * most apps (e.g. file transfer, email) require 100% reliable data transfer
* timing
    * some apps (e.g. internet telephony, interactive games) require low delay to be effective
* throughput
    * some apps (e.g. multimedia) require minimum amount of throughput to be effective
    * most apps (elastic apps) make use of whatever throughput they get
        * e.g. downloading files happens at whatever speed is available
* security
    * does an app need encryption, authentication

## Popular Internet Transport Protocols

Only two are widely used, though many others exist. TCP is dominant (about 98% of traffic), though UDP is likely to grow going forward.

* TCP (Transmission Control Protocol)
    * very complex
    * provides reliability end-to-end
    * uses sequence numbers to detect lost or out-of-order packets
        * these are retransmitted (extra delay)
    * additional features to control the sending rate so as to match the available network and receiver buffer capacity
        * features to try to avoid congestion on the network
    * doesn't provide:
        * timing guarantees
        * minimum throughput guarantees
        * security
* UDP (Unreliable Datagram Protocol)
    * much simpler than TCP
    * very basic delivery service that offers no guarantees about delivery between sending and receiving processes
    * does not provide:
        * timing guarantees
        * rate control
        * minimum throughput guarantees
        * security
    * very common for UDP to be disabled because it has features that network admins hate
        * firewalls usually block it
    * Programs like Skype try to use UDP if it's available, but revert to TCP if it isn't

Question to think about: why use UDP?

# Applications

Concentrate on the differences and commonalities between all of these applications.

## Web and HTTP

Some jargon first:

* web page consists of objects
* objects can be html files, jpeg images, java applets, audio files
* base html file which includes several referenced objects
    * each object is addressable by a URL

### HTTP

Doesn't matter what the clients are running (OS, programs) as long as they generate requests in the right format (http).

* Always uses TCP.
    * mostly because it needs reliability

### TCP Basics

TCP requires the sender and receiver to set up a connection.

* before any user data is transferred
* has to be closed again when finished

This incurs delays (round-trip time delays - RTT). These delays are both for open and closing connections, and both of those areas are important.

When designing applications, we need to think about how the performance of the transport layer affects the performance of our applications.

It is dangerous to design applications without knowing about the performance characteristics of lower layers. Don't choose TCP without knowing about its efficiency.

# HTTP

* The client initiates a TCP connection (creates a socket) to the server on port 80
* The server accepts TCP connection from the client
* HTTP messages (application-;ayer protocol messages) exchanged between browser and web server
* TCP connection closed

## Stateless Protocol

At the protocol level (i.e. not cookies) http is stateless. This makes the protocol simpler.

State makes protocols very complex:

* past history (state) must be maintained
* if server/client crashes, their views of state may be inconsistent, must be reconciled

## Non-Persistent HTTP

Because we choose TCP (because we need reliability), we incur performance overheads for setting up the connection. This leads to some strange behaviour.

If we want to load a page with several images, the setup and closing of the TCP connection is repeated for each image, even if the images are on the same host. So we incur a lot of delay.

First optimisation:

* Send off image TCP requests in parallel instead of in series

Normally there's a limit of about 10 parallel TCP connections per server. Lots looks like a DOS attack.

## Persistent HTTP

HTTP 1.1 introduced persistent HTTP, where multiple objects can be sent over a single TCP connection between a client and a server. It's used when there's a bunch of objects on one server.

Raises the question of when to close the connection.

## Pipelining

Next optimisation:

* Send requests in parallel

This isn't very widely used, and there'll be an explanation later.

## HTTP Messages

* In ASCII (human-readable)
    * Binary formats are much more efficient (each ASCII character takes a byte)
    * But binary formats are a pain to deal with
    * You can easily view and debug ASCII protocols
    * Binary-based protocols tend to be preferred where link efficiency is important, otherwise ASCII

## HTTP Requests

`HEAD` is sometimes useful to e.g. check the size of a file or when it was last modified, without downloading it.

# Cookies

* Part of the application but kept in the header for the http protocol.
* State information, but not protocol-level information
    * Doesn't tie together multiple http sessions

* Cookies permit sites to learn a lot about you
* You may supply name and email to sites
    * They can learn a lot about you as a real person

# Web Caching

* All requests go through a proxy server
* Proxy stores webpages requested
    * Can then deliver the cached version instead of sending a request for the original again
    * This decreases load on the origin server and reduces latency for cached pages
* Have to empty the cache as it fills

Caching provides great reduction in congestion, but won't work for https traffic (each page is encrypted so it can only be viewed by whoever requested it).

Also, what about websites which change? How do you know whether a website has changed and you therefore need to get the newest version.

To get around the latter:

* Send a conditional GET – only get it if it was modified since the attached date and time.
    * If it hasn't been modified, then an error is sent back
        * In this case use the cache version

There are other problems:

* The cache can't provide customised experience because it doesn't understand your cookie
* Personalised advertising is ruined
* Content providers don't get any detailed information about how you're using their page
    * e.g. it's too slow

Content providers can put a "do not cache" line in the header, and most do this for a lot of their content.

# HTTP/2

Main goal is to reduce page load times:

* binary encoding and header compression
    * binary rather than ASCII
* server can "push" content that it believes the client will need, e.g. interdependent objects
    * potentially huge benefits
    * might send you stuff you don't want, which might cost you a lot or be annoying
* Eliminates head-of-the-line blocking from HTTP/1.1 for pipelining by allowing asynchronous request/response
    * answers had to came in order in HTTP/1.1 – server could work in parallel, but couldn't send later responses before earlier ones
    * now they can be sent asynchronously
* concept of multiplexing prioritised "streams" of requests/responses over a HTTP/2 session

# FTP

One of the oldest protocols on the internet.

Opens two TCP connections:

* one for control (I want this file, etc.)
    * this is a persistent connection, which stays for the length of the conversation
* a different connection for each transfer
    * these are non-persistent (closed after the file is transferred)
    * can disable this if you want to use one TCP link to send multiple files

Control connection is ASCII.

* Separates control and data.

# Email

Three major components:

* user agents
* mail servers
    * acts as both client and server
        * has to send email to other servers
* simple mail transfer protocol (SMTP)
    * uses TCP because it needs reliability

## SMTP

Emails are transferred directly between servers. Unlike the postal service, there are no intermediaries – establishes a direct connection to the destination server and sends it.

* By default all messages are assumed to be 7-bit ASCII
    * This is extended by MIME
        * allows e.g. attachments

There's handshaking protocols, including checking if the server you're contacting has the particular user.

* Uses persistent connections

* Is a push protocol, unlike HTML
    * "I've got an email to push to you"

* Multiple objects sent in multipart message

## Mail Access Protocols

For retrieval of emails by client from server.


[…]
* IMAP
    * more features
    * assumes you keep messages on server
* HTTP
    * gmail, hotmail, etc.

### POP3

* ASCII
* pull-based

# DNS (Domain-Name System)

* Unlike the others, this is crucial to the operation of the internet.
    * Without it you could only visit sites whose IPs you already know.

Host names are much easier to remember and communicate to people than IP addresses.

DNS is a distributed database implemented in the hierarchy of many name servers.

It's an application-layer protocol:

* hosts, routers, name servers communicate to resolve names

It's a core internet function, but it's implemented at the edge of the network, which makes it easier to change.

## Services

* Aliasing
    * canonical, alias names
* mail server aliasing
    * which gmail.com computer handles email?
* load distribution
    * replicated web servers
        * set of IP addresses for one canonical name
        * e.g. redirect different people to different machines that have the same content

DNS is not centralised to avoid having a single point of failure, or having excess traffic volume to a single server.

## Distributed, Hierarchical Database

* Root DNS Servers
    * Top-level domain servers (e.g. .com, .org)
        * servers for different organisations, e.g. amazon, yahoo
            * may have more below this, e.g. for different departments

Imagine that it works like this:

1. client queries root server for amazon.com, which tells the client where the .com server is
2. queries .com for amazon, tells the client where amazon is
3. queries amazon, which tells the client which machine to contact

There are 13 root name servers worldwide.

### TLD and Authoritative Servers

* Usually run by companies (e.g. Network Solutions for .com).

* Authoritative Servers are the ones for each organisation, which are an authoritative source

### Local Name Server

Each ISP has one – also called default name server. Typically you contact these, and they contact the higher-up servers if needed.

## Name Resolution

Iterative version and recursive version.

## Caching

Caching done at every level. Stored values timeout to lessen cache inconsistency.

Root name servers not often visited.

Very unlikely that you have to worry about a cache filling up, because they're only storing small values.

Argument for using a timeout rather than checking with the origin server is that cache consistency is not very serious.

## DNS Records

* Known as resource records

Four fields:

* name
* value
* type
* ttl

### Type = A

`name` is hostname
* `value` is IP address

### Type = NS

* `name` is domain
* `value` is hostname of authoritative name server for this domain

### Type = CNAME

* `name` is alias name for some canonical name
* `value` is canonical name

### Type = MX

* `value` is name of mailserver associated with `name`

Types CNAME and MX allow you to have many servers accessible at the same url.

# DNS (cont.)

* important to remember that you can take DNS out and the lower layers all still work totally fine
* local computer only ever talks to your local nameserver, which talks to all the other nameservers on your behalf
    * recursive resolution requires keeping state on all intermediate servers
        * this gets messy, and so is less used

## Caching

If DNS didn't have caching, it wouldn't scale as well as it does (the root servers would always be too busy).

## Inserting Records into DNS

* different TLDs have different requirements and different costs
    * .ie is more strict (you have to prove you're a representative of a real company or etc.) and so better-managed
* may want the flexibility of moving webserver from one computer to another
    * so use an alias for the main address (www.networkutopia.com maps to 2141nj.networkutopia.com)
    * only have to change 1 DNS address (the alias)

# File Distribution

Could just use FTP, but this is bad:

* Response time gets very high for large numbers of users or files

## Mirror Sites

* user is the one who selects a mirror

### Issues

* need fast copying between mirrors to ensure consistency of files
* need to think about how to guide users to spread load across mirrors

## Content Distribution Networks (CDNs)

* created to address issues with mirrors
* essentially automated mirrors
* user is directed to a mirror by the CDN (rather than picking one themselves)

CDNs have large servers distributed globally.

* CDNs often place servers at the edge of the backbone network (e.g. Netflix in .ie)
* need to be able to react very quickly to e.g. a new very popular video on youtube
* a lot of deciding how many replicas and where is to do with AI and machine learning

### Overlay Network

* CDN visualises its own network sitting on top of the internet
* avoids large amounts of same data repeatedly travelling large sections of the internet
    * reduces congestion
    * improves latency
    * reduces server load
* redirection can be done with DNS or HTML

### Partial Site Delivery

* origin server can now see all users that request content from it
    * same as caching downsides

### CDN vs. Caches

* something only goes in a cache if it's been requested (reactive)
    * CDNs are proactive

* caches give low access time as a side effect – actually more concerned about reducing network traffic

Note: there are agreements (SLAs) between CDN providers and content providers about guaranteed latency, provision of measurements, etc.

## P2P

* changes over time – different peers online at different times
* you can distribute files much more effectively than client-server, but how do you search for the info you're looking for? Who has it?

* highly scalable and good performance, but difficult to manage

* client-server is linear in download speed for large numbers of clients
    * p2p is logarithmic

### BitTorrent

* uses TCP for reliability

* pull-based
    * you tell peers you want it, they don't know otherwise
* designed in a way that encourages you to share the pieces you have with other users

* torrent definition
    * group of peers exchanging pieces of a file

* tracker normally gives you a subset of the entire number of users
    * tracker is specified in the torrent descriptor file

* while downloading, peers must upload pieces to other peers
    * once finished, you can leave or stay
    * BitTorrent is reputation-based – if you often seed, you will get better connections (though it won't go far above your connection speed because that would be a waste)

* neighbours are the set of users you're connected to on the overlay network

* need to randomly select a peer every now and then and send files to them in order to allow new users to join the network
    * other than that it's by how much they're sending you

* high upload rate important to P2P

### Distributed Tracking

#### DHT

* want spread evenly because otherwise many lookups going to one node

##### Circular DHT

### Skype

## Streaming

* mostly video
    * makes for the majority of network traffic

### Client-side Buffering, Playout

# File Distribution (cont.)

## Streaming Stored Video (cont.)

* most info applies to streaming audio as well

* client-side buffer acts as a cushion

## Client-side Buffering

* buffer starvation is when the buffer is empty

* the bigger the buffer, the bigger the initial playout delay

    * user experiences large delay before the video plays

    * if the user decides at the beginning they don't want it, there's a lot of data wasted

        * a big problem if the user is charged by the amount of data

## Streaming Multimedia: HTTP

* used for most video streaming today

* this is new

    * in the past it would've always been expected to be UDP because video tolerates loss

* we use http because it's common and gets through firewalls

### DASH

* this is an MPEG standard

* most widely-used

    * Netflix and Youtube use proprietary standards that have been reverse-engineered and seem very similar to DASH

* 4s pretty typical for a chunk

* GET request for each chunk

* what algorithm should the client use for deciding when to fetch each chunk?

    * this isn't specified in the standard

* Netflix has about 100 different quality levels per chunk

* In practice, most clients pick the best server at the beginning, but don't make that decision again later

    * distributed DASH is new and is likely to change this

### Case-study: Netflix

* Since 2014, Netflix have made their own CDN, use that rather than those mentioned on the slides

* the older system allowed them to get set up very quickly, without having to put the infrastructure in place first

* diagram is probably correct rather than the preceding slide

    * registration and accounting kept on Netlix's own servers

## Summary

* in-band and out-of-band control

    * separate channels for control messages is out-of-band, example is FTP

    * HTTP is in-band
