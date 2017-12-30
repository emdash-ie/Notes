% 13: CORBA

# Intro

CORBA (standing for Common Object Request Broker Architecture) is a specification for distributed systems that was proposed by OMG (?).

There are several implementations of the specification.

The idea is that there are heterogenous systems (in terms of OS, programming languages, and protocols), and we need to be able to deploy a distributed system across all of these systems – how do we get them all to work together? We need to hide the heterogeneity.

# Decisions

Some decisions were made:

* use object-oriented technology
    - desirable for encapsulation, separation of interface and implementation
        * interface is defined in IDL (Interface Definition Language – a general standard)
        * now any language that has a mapping to IDL can be used
* provide services required by distributed applications – these are provided by the request broker
    - remote execution
    - discovery of services
    - name service
    - event notification (can include alerts)
    - remote activation

# Structure

Clients and servers talk to one another through the object request broker. An IDL stub and IDL skeleton are compiled from the IDL interface for the client and server. This is the structure when running on one system.

When running on separate computers, there’s an object request broker on each computer, and these communicate with one another using IIOP (Internet Inter-ORB Protocol – an application-level protocol that runs on TCP/IP).

# Object Request Brokers

Every entity in the system connects to a broker, which works on its behalf.

These have a couple of different roles:

* aiding the discovery of new services
    - this is called the trade service – a trader stores service offers
    - a client can use the broker to search for services matching certain attributes
        * we need a mechanism for dynamic invocation of services (since there won’t be a pre-existing stub and skeleton for this client-service combination)
* providing remote execution
* allocating service instances to different requesting clients
    - need to activate the service if it isn’t running
    - need to allocate resources to a new instance of the service
    - need to de-activate the service (not sure when)
    - need to save state of service instances (e.g. if it’s part of a transaction)
* managing security
    - credentials are provided by clients, and are checked on the server side

# Deployment

How is the ORB deployed? Is it just one piece of code?

There are multiple solutions:

* deployed as one process
    - this is pretty heavy (lots of code)
* deployed as many processes, running across one or more computers

# Summary

CORBA is old, but is still widely-deployed, e.g. by banks.
