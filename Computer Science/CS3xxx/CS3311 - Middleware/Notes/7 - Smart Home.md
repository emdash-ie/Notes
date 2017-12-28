Note: this is still part of Discovery Services, and needs to be integrated

# Home Gateway Middleware Initiative

[…]

A second goal was to help unskilled people manage their devices (updates, etc.). This would be done by allowing operators to have access to the devices in people’s homes and perform updates and so on. To have this access we need more than a router, which is what the home gateway device is.

At the moment we have a number of devices (e.g. router, sky box, etc.) which have some overlap in functionality – a home gateway device could replace these to prevent duplication of functionality.

## Device Lifecycle

Devices can be in a number of states:

* detected (initial state)

* ready

    * in this state devices can be controlled remotely

* offline

    * power-saving state

* updating

    * device is being updated

* blocked

    * from here it can return to the detected state

* departing

## Remote Access

For security reasons, there should be remote access to the home gateway device, but not to the devices on the network inside the gateway (e.g. the fridge in the house). All remote access should be mediated by the home gateway.

## UPnP

When devices have been detected, the control point can add them to a database, which tracks all devices present along with their services.

## Cloud Access

Would like to have devices on the network interacting with one another, and accessing cloud-based applications.

This is difficult to implement for a few reasons:

* heterogeneity of devices

    * devices from different companies which aren’t interoperable

* devices use different network-layer protocols

    * need some bridges to work with these

* there are different device representations (~)

    * need a virtual device layer, where we can find which generic description/interface to use for a specific device

    * need to figure out which drivers to use

* we also need connectors (remote and local)

    * this is software that handles receipt of and translation of messages

    * allow connections to devices (?)

The home gateway is now looking a lot like an operating system, with resources and etc.

# Cloud Apps

E.g. a smart meter – measures things, and sends the data to the company’s cloud, where the data is analysed and can be accessed by both users and the company.

Not great because the user doesn’t have control over their own data.

## Managed vs. Manageable Devices (on device discovery and management slide)

Managed devices are devices that are currently on the home network and are being managed.

Manageable devices are devices that may yet join the network – e.g. if you don’t have a tv on the network, it’s helpful to have a description of one so that if you get one it’ll work.

# Adding IoT to the Smart Home

UPnP+ specifications extend UPnP to make it work for cloud applications.

# Discovery Service Conclusions

[…]

Generally, xml has been used so far to solve the problem of describing services.
