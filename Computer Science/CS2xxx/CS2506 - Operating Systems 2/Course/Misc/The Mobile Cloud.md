# Intro

* this is about research, and Grigoras' research area

* (not on the exam)

Infrastructure made up of two kinds of device:

* mobile devices

* the cloud – large datacenters with lots of resources

Mobile devices are still limited in resources – mobile applications can offload resource intensive work to the cloud for execution.

The most important resource that's limited on a mobile device is energy. We have to be very careful of this when designing mobile applications.

The point of contact between a mobile device and the internet is changing all the time, so mobility is important and needs to be managed.

Gmail is a simple example of a mobile cloud service.

The trend now is to develop more and more complex applications that require a lot of computing.

Mobile enterprise:

* don't keep employees in offices all day long

* anyone can be mobile, but it's important to keep connectivity

* connectivity is for access to enterprise resources (as well as communication)

    * file system, computing engine

Context awareness:

* if working with PCs, we sit in one place (the environment is the same all the time)

* with mobile devices the environment/context is constantly changing

* many mobile applications take advantage of this now

* context can be about the user as well as the environment – e.g. the kind of activity the user is engaging in now.

* depending on the activity of the user, the system may react (e.g. with application suggestions)

* preferences also form part of the context – filters that allow some applications to run or not

* preference for phone to be on silent when the activity is a meeting (very simple example)

* context also about the device – memory use, battery level, processes, etc.

Mobile applications are very different from classic applications because they can use this context.

# MANET

* mobile ad-hoc networks

    * used a lot these days, e.g. in war, during natural disasters (when the infrastructure is down)

    * also for drones

    * autonomous vehicles can talk to each other to alert about road conditions, etc.

    * for natural disasters (when infrastructure is down), can deploy a cloudlet, which can be tailored to the specific situation and provides access to mobile devices

        * in australia there's work as well, but they're not using a cloudlet – some other resource-powerful device

        * very important to get access to maps during natural disasters, e.g. where are the gas pipes

* e.g. for sharing files, between a few mobile devices

* up to now, the management of these networks was carried out by the devices themselves

    * but if the networks split into smaller ones, devices lose connection

        * can manage this with the cloud implementation

    * merging networks need to check for duplicate IPs

        * this consumes a lot of energy

# Challenges

* everything's fine if the network works perfectly

    * continuous, uninterrupted, high-quality connection to the cloud

    * difficult in case of mobility

* generally these applications require high-volume data transfer, but this is high energy-cost for mobile devices

* bandwidth on 3G/4G networks is low – get high latency which slows down cloud applications

* cost of communication infrastructure can be quite high

* need to reduce communication between the mobile client and the cloud as much as possible

* also try to do it as asynchronously as possible

# Computing Models

* browse app store, find app, download, install, and use it

    * after a while you don't use the application anymore, but it's still consuming resources

    * in time, number of apps builds up ("maybe I'll use it someday")

    * maybe it doesn't make sense to keep them all on the device

* install mobile clients to servers hosted by companies' private clouds

    * mobile client can learn a lot about you and report it to the company, which data can be used for profit

    * lose privacy

* offloading

    * collected some environment data, after one week want to do some analysis

    * offload all data to the cloud, processing happens there, get results back

* pay-as-you-use middleware support

    * have access to what you need when you need it, have access through a cloud application

    * gives you control – know what you need and when and only pay for what you use

# Cloud Personal Assistant

Software entity in the cloud that would work on behalf of the user.

* user subscribes to the service, system creates the assistant

* cloud assistant can find information that can help the user (according to user's preferences)

    * e.g. I'm going to China soon and I don't know anything about where to go, hotels, etc.

    * when it's ready, returns the results to the user

* benefit: don't need to be connected all the time

    * assistant can notify you when the results are ready, and you can then go and receive the results

# Reference Architecture

* user authorisation/verification/authentication unit

* instance of personal assistant created for each person who subscribes

    * store task history with the instance – learns the habits of the user

    * prepare repetitive task sequences

* context processor

    * context history

        * communicate with assistant before journey when there will be no internet

        * assistant can use history from previous journeys, e.g. last week there were roadworks in this area

The personal assistant needs to discover the services/applications the user requires.

Say the user wants to discover services – how will the service be found? The user and provider may describe a service quite differently.

Bluetooth has a discovery protocol. Adopted a simple protocol using numbers. Ideally, though, it should be something human-readable.

# CAMCS Layers

The idea is that as soon as the user has sent the task, they can disconnect.

# Some Applications

* synchronise files on different clouds

    * only have to tell the assistant to do it, then it handles authentication on all different clouds

* asynchronous data processing in the cloud

    * "find this math library, do this processing, and here's the database you should use to get the data"

    * calculation happens while you're travelling, when you arrive at the destination, you receive the results

* group-based collaboration

    * in companies, when there's a new project, management try to see what skills they need

    * then try to find these people – maybe there are a few but they're already engaged in projects

    * big companies have offices everywhere, so the set of skills is what is important, not the location

    * personal assistants can talk to each other, figure out who's appropriate

    * this is very time-consuming to do manually, so doing it in the background is very beneficial
