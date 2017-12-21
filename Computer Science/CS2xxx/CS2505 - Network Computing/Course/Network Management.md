# Intro

Network:

    * autonomous system with 100s or 1000s of interacting hardware/software components

    * other complex systems requiring monitoring, control

        * jet airplane

        * nuclear power plant

        * others?

"Network management includes the deployment, integration, and co-ordination of the hardware, software, and human elements to monitor, test, poll, configure, analyse, evaluate, and control the network and element resources to meet the real-time, operational performance, and quality of service requirements at a reasonable cost."

## Infrastructure for Network Management

* managed devices contain managed objects whose data is gathered into a Management Information Base (MIB)

## Network Management Standards

Main ones:

* OSI CMIP

    * Common Management Information Protocol

    * designed in the 1980s

    * standardised too slowly, became too complex

* SNMP

    * simple network management protocol

    * internet roots (SGMP)

    * started simple

    * deployed, adopted rapidly

    […]

# Internet-standard Management Framework

* SMI (structure of management information) – a language for describing networks

* MIB (management information base)

* SNMP Protocol operations and transport mappings

* Security and administration

# SMI

A language used to define the information stored in MIB.

Combine basic data types into objects, combine objects into modules.

No commands.

Language independent – just have to conform to the message format.

# SNMP MIB

MIB module specified via SMI module-identity.

* 100 standardised MIBs, more vendor-specific ones

* object ID is unique across all objects

## SNMP Naming

* ISO Object Identifier tree

    * each branchpoint has name, number

    * hierarchical naming of all objects

    * company can ask for a range of numbers, and can publish the objects they create or keep them secret

# SNMP Protocol

* used in two different ways:

    * request-response

        * polling

        * doesn't scale for checking for errors

    * trap

        * interrupt mode

        * agent sends a trap message to the managing entity

            * "if that variable exceeds this threshold, send me this message"

        * one alert may not mean anything

            * clever bit is the software on the backend that detects patterns in these alerts

## Message Types

* GetRequest, GetNextRequest, GetBulkRequest

    * "get me data"

* InformRequest

    * manager to manager: "here's MIB value"

* SetRequest

    * manager to agent: set MIB value

* Response

    * agent to manager: value, response to request

* Trap

    * agent to manager: inform of exceptional event

## Message Formats

* same format used for requests and responses

* can run on top of TCP or UDP

    * hence the request IDs

* time stamps important in trap mode useful for debugging

    * assumes devices clocks are pretty synchronised

    * NTP: network time protocol (application-layer protocol to ensure that nodes can figure out what the real time is – assumes some computer on the network knows the real time)

## Security and Administration

* encryption

    * shared-key encryption for ensuring privacy of messages (pre-arranged key)

* authentication

    * compute a hash of the message and send it with the message

    * encrypt the hash with the key

    * ensures who the message came from

* protection against playback attacks

    * playback attacks are where you capture packets and send them again later on

    * use a nonce to protect against this

        * randomly-generated time-sensitive number

        * common: encrypt the time of day and include with the message

* view-based access control

    * SNMP entity maintains database of access rights, policies for various users

    * database itself […]

# The Presentation Problem: ASN.1

* used for sending information in an architecture-independent way

* would be used for presentation layer in OSI model

* SNMP agents and manager may have different ways of representing data, leading to misinterpretation of message contents

## Potential Solutions

1. Sender learns receiver's format. Sender translates into receiver's format. Sender sends.

    * but what if you add a new receiver? have to update the sender

    * every sender and receiver needs to know all formats

2. Sender sends. Receiver learns sender's format. Receiver translates into receiver-local format.

    * now every receiver needs to know what format everything's sent in

    * every sender and receiver needs to know all formats

3. Sender translates into host-independent format. Sends. Receiver translates to receiver-local format.

## ASN.1 Abstract Syntax Notation 1

* defined on Basic Encoding Rules (BER):

    * specify […]

    * all data encoded as a triple (Type, Length, Value)

# Summary

* network management

    * very important – 80% of network "cost"

    * ASN.1 for data description

    * SNMP protocol as a tool for conveying information

* network management: more art than science

    * what to measure/monitor

    * how to respond to failures?

        * a lot of machine learning based on patterns of things that have happened

    * alarm correlation/filtering?
