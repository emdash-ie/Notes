# Intro

* for every problem, we can have many approaches for solving it

* e.g. thread vs. process vs. activity

* need to analyse and compare approaches, see the benefits and disadvantages of each

# OS Architecture, Models, Concepts

* Computing resources, multiplication, virtualisation

    * virtualisation is very important

        * associated with many areas of computer science, especially IoT

        * saw it with virtual file system in Linux, which was to accommodate different file systems

        * also the virtual machine in/with Android

    * multiplication

        * now we have multiple physical copies of the same resource

            * e.g. many CPUs instead of just one

            * have to deal with scheduling and load-balancing with many cores

* Layer architecture, services

    * most OSes now built on concept of a service – OS provides a set of services to users and their applications

        * flexibility, openness, ease of management, updating

* Models: hierarchical, service-based, component-based

    * e.g. TinyOS, where software is a combination of components

* Process, task, activities

    * similar but managed differently by the OS

        * all about computation in the program

    * processes are quite complex because of admin info

    * tasks (remember TinyOS) are different to processes – no admin info

        * sequence of instructions that is brought to the queue, ready to be executed

        * round-robin scheduling

        * lack of admin info possible because tasks are fully known beforehand

        * TinyOS v2 more complex, allows for priorities, etc.

    * activity

        * Android

        * mobile, highly interactive OS

        * can go from one activity to another across processes

        * important difference is user is interacting with an activity – visible phase

        * hosted within processes

# Process Management

* process definition, structure, lifecycle, states

* creation of child processes

    * fork, vfork, clone – very important to know the difference between fork and vfork

* threads

* process management in Linux

* process creation in Linux

# Scheduling

* purpose of scheduling

    * deciding which process takes control of the system for the next time slice

* FIFO, shortest-time first

* priority-based, multilevel feedback queues (parameters adjusting at run-time)

* two-level scheduling

* real-time scheduling

* group and domain scheduling

    * many-core systems

    * simple approaches, e.g. one core for OS and one for user

    * complex approaches, e.g. consider all processes and schedule according to group or domain

    * group is about affinity of processes (e.g. sharing data, IPC)

    * domain is about hardware resources (characteristics of cores and cache memory are very important)

        * assume all packages/cores are the same

    * there are systems where packages are different

        * can be optimised for specific types of process (e.g. numerical analysis, image processing)

* load balancing

    * important in many-core systems as well as scheduling

    * partly about energy efficiency

* Linux scheduling

# Memory Management

* address translation

* virtual memory (pages, page table)

    * using virtualisation here

    * expand memory across the storage, using e.g. pages

    * process has variable number of pages allocated to it

    * pages have flags indicating how they were used (present, modified, etc.)

    * now implemented in hardware (CPU), rather than in the OS

        * address translation, page management

* free space, fragmentation

    * strategies try to reduce fragmentation as much as possible

* memory allocation algorithms, over-allocation/swapping

* replacement algorithms

    * if everything is allocate, what is a good candidate for replacement?

* Windows NT page working set

    * memory is full – if a process needs a new page, an existing page needs to be replaced

    * either local choice – replacement done with a page in use by that process

    * or global choice – replacement done with a page chosen from all processes

* Linux memory management

# I/O Management

* different from memory because different devices are very different from each other

    * generally grouped into character devices or block devices

* I/O subsystem

* drivers' interaction and families

    * families is a recent development

    * generic family which characterises all devices of the same type, even if performance is different

        * similar to virtualisation

* device driver structure

* representation of devices in Unix

* I/O devices in Linux

* I/O schedulers

    * […]

    * different deadlines for read and write

* sensors

    * especially for mobile devices

    * how sensors return data – continuously, on demand, event-triggered

    * allow context-aware applications

# The Filesystem

* not much here has changed recently

    * though look at how this can be ported to clouds – research topic at the moment

* file concept, structure, operations

* filesystem services, metadata, management

* directories

* storage management

* linux virtual filesystem – interesting to study more

    * structure

    * main components

    * superblock

    * inode

* EXT3, disk scheduling

* Block, character devices

* RAID management – also interesting to study

# Overview

* didn't focus only on one OS, tried to bring in aspects of several

    * not just general purpose OSes

    * sensor OSes are important now/soon

    * also mobile OSes

    * can look at the differences between them

        * note: look at difference between activity and process

        * ask why things are different

* good to evaluate different approaches, not just one

* best way is to take the simplest approach

    * people don't adopt sophisticated solutions, complex algorithms

    * complex solutions are prone to errors

* potential of mobile devices not fully exploited

    * applications and even OS don't provide means to fully exploit resources

    * a lot to do here, worth considering as a future career

Sample questions will be posted tomorrow, we'll talk about the exam on Wednesday.
