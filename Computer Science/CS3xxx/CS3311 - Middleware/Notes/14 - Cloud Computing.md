% Cloud Computing

# Intro

Cloud computing provides scalable, virtualised infrastructure, platforms, and applications as on-demand services, priced by usage.

This is somewhat similar to an old mainframe-terminal system, where the terminals just handle input/output, and the mainframe is shared between many terminals and users.

By scalable, we mean that irrespective of the number of clients, the cloud system will meet the resource requirements.

Cloud computing is always done/accessed over the network.

With virtualisation, the physical resources are better utilised, as the physical resources can be shared among many virtual machines/service instances.

# Service Models

* Infrastructure as a Service (IaaS)

	- You get the hardware as a service, to do with as you will.

* Platform as a Service (PaaS)

	- The entire environment you’re using (e.g. Java, editors, etc.) is provided, and you can use it to make applications.

* Service/Application as a Service (SaaS)

	- E.g. Google Docs

# Advantages

Cloud computing offers a number of advantages to companies:

* Rapid prototyping and manufacturing

	- Don’t waste time buying computing resources and developing them when you want to build something new

* Meeting unpredictable demand

	- Cloud infrastructure can expand and collapse as needed, which would be difficult with your own infrastructure.

There are also advantages for IT:

* A robust, highly available platform
	- high uptime
* Good scalability
* Effective use of resources and energy
	- cost-effective

# Benefits

1. Economies of Scale

	- major cloud suppliers can purchase hardware more cheaply than regular businesses

	- easy to scale up/down the system based on demand

2. Pay as You Go
	- more customers/users -> more processing power and storage -> pay more
	- when you have more customers you can *afford* to pay more

3. Low Entry Costs
	- there is no long-term financial commitment
	- not e.g. stuck with one company forever

4. […]

5. […]

# Cloud Model

Couple of models available:

* public cloud
* private cloud
* hybrid cloud

A private cloud belongs to an organisation, and only members/employees have access. A public cloud can be accessed by anyone. Hybrid is some combination of public and private, e.g. creating private clouds within public clouds.

# Major Players

Commercial:

* Microsoft Azure
* Amazon EC2, S3
* Google AppEngine, BigTable
* IMB Cloud
* Yahoo, Salesforce, etc.

Open Source:

* OpenStack
* Eucalyptus Systems
* Globus

# Virtual Machines

Multiple virtual machines share one hardware resource.

The hypervisor is run on the host OS, and guest OSes run on the hypervisor.

# OpenStack

A cloud operating system that controls pools of resources and provides means of controlling them.

The OpenStack project consists of 3 components:

1. Compute (Nova) is used to manage and offer VMs through hypervisors
2. Object Store (Swift) provides redundant storage for static objects.
3. […]
