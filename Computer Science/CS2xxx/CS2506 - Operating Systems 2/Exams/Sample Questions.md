# 2. Analyse the structure and functions provided by the kernel of an OS

The kernel is a collection of services/functions that make up the core of the OS. They offer a level of abstraction from the hardware of the computer. This abstraction is useful because code can be written to run on an operating system rather than on a specific platform, and then it will run on any platform which supports that operating system.

The main components of the kernel are:

* device drivers

* file system manager

* process management

* memory management

* network services

The device drivers are used to accommodate I/O devices that vary considerably in how and how fast they communicate with the OS. They hide low-level details of these devices from the user and provide a uniform method of interaction with devices.

The file system manager organises data storage into files and directories. It hides the low-level details of e.g. disk blocks from the user. The file system manager can also exist in the user space instead of the kernel space, in which case it needs new ways of (e.g.) accessing the device drivers or handling system calls. One possible way would be a message-passing protocol for between processes.

Process management is concerned with allocating resources to processes and scheduling their execution. In

# 49. How does a device driver work?

A device driver is a piece of software that extends the kernel (runs with kernel privileges). It interacts with processes and with the hardware device controller.

There are two control flows within the driver:

* the first is executed on behalf of a process requesting a service

    * a process requests an I/O service and passes parameters to the driver

    * the driver translates these parameters into controller parameters, which it delivers to the device controller

* the second responds to interrupts

    * the controller issues an interrupt

    * the driver handles the interrupt, possibly passing information back to the relevant processes

These two control flows share a common data structure. As the first flow can be interrupted, the two must co-ordinate their access to a shared request queue. The two flows use mutual exclusion techniques to prevent corruption of the queue.

# 50. Explain the concept of driver families.

Driver families provide a level of abstraction that accommodates all devices of the same type.

A driver becomes a member of a family through inheritance, and inherits the data structures and behaviours common to the family. It can use these to, for example, scan the SCSI bus as the SCSI Parallel family defines.

A driver will also implement member functions that the family invokes.
