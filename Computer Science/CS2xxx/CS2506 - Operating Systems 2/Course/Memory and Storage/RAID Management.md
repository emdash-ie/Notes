# Problem

* Avoid losing files/data due to disk failures.

Solution: replicate files and store them on different disks

Example: SME with a local network. Transparently, when a file is stored, 2 or 3 copies are created and stored on randomly selected disks. Only the main copy is visible. This is a software solution.

* you also need a coherency preservation protocol

    * to synchronise changes in the working copy to other copies

# New Context

Disks of extremely large capacity are now available.

Also many companies have decided to move their data from their own storage to big datacentres.

New requirements:

* reliability

    * Datacentres also replicate files in other datacentres on other continents (in case of earthquake, etc.)

* fast access to data

* fault tolerance

    * can't bring error probability to 0, so need to deal well with them

* scalability

    * especially the I/O channels to the disks

* ease of management

* transparent administration

* secure access to data

# RAID Concept

* solves some of these issues but not all of them

The concept of RAID was introduced about three decades ago – taxonomy was first established by Patterson in 1988.

Provides improved reliability by redundancy.

* increases mean time to failure

* frequently combined with NVRAM to improve write performance

    * memory hierarchy

Can have size different levels/configurations of RAID.

Frequently, a small number of hot-spare disks are left unallocated, automatically replacing a failed disk and having data rebuilt onto them.

## Faster Access Time by Parallelism

* can allow parallel access to data

Data striping:

* splitting the bits of each byte across multiple disks – bit-level striping. With 8 disks, bit `i` will be stored on disk `i`. As a result, the "sector capacity" increases 8 times, the same for the access rate.

    * allows the 8 bits of a byte to be accessed at the same time

* This can be generalised to include a number of disks that is either a multiple of or divides into 8. For example, for two disks, every second bit goes to the second disk.

Another popular solution is to split data at the block level rather than at the bit level. In block-level striping, blocks of a file are striped across multiple disks: with n disks, block `i` goes to disk `(i mod n) + 1`.

* the performance is better because there's less overhead

* not sure why

# RAID Levels

Mirroring (duplication of all data) provides reliability but is expensive. On the other hand, striping provides high data-transfer rates but not reliability.

Different models that combine reliability and low cost were proposed.

## RAID Level 0

Striping at the level of blocks but without any redundancy.

Benefits:

* best performance is achieved when data is striped across multiple controllers with only one drive per controller

    * in hardware

    * each disk has a separate I/O channel (this is expensive)

* very simple design, easy to implement

Disadvantages:

* not a true RAID because it is not fault-tolerant – the failure of one drive will result in all data in an array being lost

    * major disadvantage

## RAID Level 1

Disk mirroring – copying one disk on another.

Benefits:

* one write or two reads possible per mirrored pair.

* twice the read transaction rate of single disks, same write transaction rate as single disks

* 100% redundancy of data means no rebuild is necessary in case of a disk failure, just a copy to the replacement disk. Under certain circumstances, RAID1 can sustain multiple simultaneous drive failures

* transfer rate per block is equal to that of a single disk

* simplest RAID storage subsystem design

Disadvantages:

* Highest disk overhead of all RAID types (100%) – inefficient

    * because of coherence maintaining protocol

* typically the RAID function is done by system software, loading the CPU/server and possibly degrading throughput at high activity levels. Hardware implementation is strongly recommended.

## RAID Level 2

Use an error-correcting code (ECC), with RAID 0. One disk stores the 1st bit of all bytes, another disk the 2nd, etc.

Three disks store the error-correcting bits. On read, the ECC verifies correct data or corrects single disk errors.

Benefits:

* on-the-fly data error correction

* extremely high data transfer rates possible

* the higher the data transfer rate required, the better the ratio data disks / ECC disks

    * high cost

* relatively simple controller design compared to RAID levels 3, 4, and 5

Disadvantages:

* very high ratio of ECC disks to data disks with smaller word sizes

[…]

* theoretical

## RAID Level 3

bit-interleaved parity organisation – improves on level 2 by using only one disk for parity

## RAID Level 4

block-interleaved parity organisation

[…]

## RAID Level 5

block-interleave distributed parity, spreads data an parity among all disks

## RAID Level 6

block-leve striping with double distributed parity. Double parity provides fault tolerance up to two failed drives.

## RAID (0 + 1)

First data is striped, then those disks are mirrored.

## RAID (1 + 0)

First data is mirrored, and then striped.

# Selection of RAID Level

* RAID 0

    * high-performance applications where data loss is not critical

* RAID 1

    * high reliability with fast recovery

    * high cost

* RAID 1+0/0+1

    * both performance and reliability are important, e.g. in small databases

* RAID 5

    * preferred for storing large volumes of data

* RAID 6

    * not supported currently by many RAID implementations

# Implementation of RAID

* in the kernel, e.g. RAID 0, 1, or 0+1

    * software is most flexible but brings additional load on the CPU

    * works well with a dedicated CPU

* in the host-bus adapter hardware

    * this isn't flexible

* in the hardware of the storage array. The OS needs to implement the file system on each of the volumes

* in the storage area network layer by disk virtualisation

    * can correspond to remote storage

    * can be similar to cloud storage

# Linux RAID Support

* 2.6 kernel supports md (multiple devices): arrays can be built on top of entire disks or on partitions

* mdadm is now the standard RAID management tool and should be found in any modern distribution. (http://linux.die.net/man/8/mdadm)

* mdadm has 7 major modes of operation – normal operation […]

[…]

# Questions

Could RAID 1 achieve better performance of read requests than RAID 0? How?

Consider a RAID 5 architecture with five disks – the fifth stores the parity block. How many blocks are accessed in order to perform the following?

* a write of one data block

* a write of seven continuous blocks of data

# Summary

* old idea, but very important to modern datacentres
