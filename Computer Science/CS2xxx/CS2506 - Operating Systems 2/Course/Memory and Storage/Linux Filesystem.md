# Meta

* will finish the course next week

* then a week of practice

* then a week of review

If there's anything you'd like to be covered/discussed more, let him know.

# Intro

Questions at the beginning are what is covered.

# The Virtual Filesystem

* main concept used by linux

This is a layer of abstraction - sits on top of any physical filesystem.

Exposes to applications a number of common services and generic file operations.

* organised as a collection of base classes, one for each area of file system activity.

* manages kernel-level file abstractions in one format for all file systems

* receives system call requests from user level (e.g. write, open, stat, link) and resolves them

    * based on the information brought in when a system is mounted

* interacts with a specific file system based on `mount point traversal`

* receives requests from other parts of the kernel, mostly from `memory management` and `process management`

For each VFS service, the specific file system has a structure containing function pointers defining the operations it provides.

* keep a datastructure with pointers to the relevant functions in the underlying filesystem

    * brought in when mounted

[…]

* VFS and underlying filesystems exist in the kernel space

* requires a lot of memory, which is why it didn't exist in older operating systems

# Main Components

* `superblock`

    * information about the mounted filesystem (metadata)

* `inode`

    * information about a specific file

* `file`

    * information about an open file

* `dentry`

    * information about a directory entry

All files are part of a directory, and there are entries in a d_node which map the filename onto a specific inode. Superblocks are stored on the disk, and inodes point to them.

## Superblocks

When a filesystem is mounted, a FS-specific function is called to load an internal representation of the FS metadata. Named after the original UNIX on-disk metadata, this is called the superblock.

A member of the internal superblock structure points to a structure of type `struct super_operations`. This structure contains a number of function pointers that are needed to carry out operations on a mounted FS.

Although the name suggests that these functions are primarily related to superblocks, they're actually more related to managing inodes. (~)

Superblock gives info about inodes. (?)

### Superblock Data Structure

* Total number of inodes

* file system size in blocks

* free block counter

[…]

## Inode Structure

An inode represents an individual file.

Some interesting structure members:

* `alloc_inode()`

    * allocate the memory for and initialise an in-memory inode structure

* `read_inode()`

    * read an inode from the FS

[…]

One member points to a structure which contains function pointers for operations with specific files and directories. (~)

Directories are implemented as lists of directory entries. The VFS maintains in the main memory a cache of directory entries that provides a mapping from file names to inodes. They can be quickly searched to avoid unnecessary disk accesses. (This is a heavy load on memory, along with everything else.)

In addition to the inode operations, the internal inode structure also points to a structure of type struct file_operations. When a file is opened, an internal structure representing the open file is created. This structure points to file operations […]

Everything from the diagram at the beginning is brought into memory. For a large filesystem, this is a heavy load on memory.

# The EXT3 Filesystem

Probably the most-used in Linux.

In any disk or partition with this filesystem, the first block is reserved for boot. The next block is a superblock, which is replicated in several places in the FS. (block size can vary from 1024 to 8192 bytes)

Divides the FS into block groups, each having a copy of the superblock. The following block is a one-block group descriptor table, and then two blocks of free bitmaps – one for free blocks within the group and one for free inodes within the group. Following are inode blocks. the rest of the blocks are for data.

The strategy is to keep the blocks allocated to a file in the same group together with its inode. (In each group, …)

Each entry of the directory structure contains the file name and the i-number. To speed up directory searches, there's an option for adding a hash table to the directory.

Note: ask about how the hash table speeds up the searches.

There's also a journal, which is like a log for what the filesystem has done recently. Used for tracking errors.

## EXT3 Name Lookup

The `open()` system call enters the kernel with the function `sys_open()`. The major function is to locate the inode that corresponds to the path name passed by the application.

The open sys call checks the permission of the operation with the inode and then builds the internal open file data structure.

After about seven nested function calls, the VFS function `_link_path_walk()` is invoked, to follow the path name along the directory tree.

Path can be absolute or relative […]

## Write Operation

When the file is open, the application can call `read()` and/or `write()`.

Writing to a file begins by determining the point where writing starts (part of the open file structure). After that, the control is passed to VFS, where the request is checked to make sure that it doesn't violate security (e.g. file open read-only) or other limitations. Then the control is passed to the EXT3 specific write function.

# Linux I/O

In Linux, all device drivers appear as normal files.

There are three categories of devices.

There are block devices, character devices, and network devices. […]

## Block Devices

Block devices provide the main interface to all disks.

Unit of transfer is the block – generally corresponds to one sector.

The request manager manage the reading/writing of the bugger used in a block device transfer. A separate list of requests is stored for each block device driver. This list is maintained in sorted order of increasing starting sector number. A request will be removed from the list after […]

Merged if they involve neighbour sectors. […]

## Disk Organisation

The surface of the disk platter is logically divided into circular tracks that are subdivided into sectors. The set of tracks that are at one arm position makes up a cylinder.

The disk is addressed as a one-dimensional array of logical blocks. […]

## Disk Scheduling

Important to consider the performance.

The access time = seek time + rotational latency.

The disk bandwidth is the number of bytes transferred divided by the total time between the first request for service and the completion of the last transfer.

Disk scheduling optimises the above metrics by good decisions on the next disk request to be served.

### Strategies

* First come first served (FCFS)

    * all requests serviced as they arrive

    * fair but doesn't provide fastest service

        * example: sequence of requests to blocks on cylinders: 42, 211, 234, 19, 87

* Shortest seek time first (SSTF)

    * Service all the requests close to the current head position before moving far away

    * may cause starvation for some requests, meaning it is non-optimal

#### SCAN Scheduling

Also known as the elevator algorithm.

The head moves from one end to the other, servicing requests as it reaches each cylinder, then reverses direction, etc.

Assuming a uniform distribution of requests, when the head approaches one end, relatively few requests are in front of it (depends on how space is allocated). The heaviest density at this point is at the other end of the disk.

C-SCAN (Circular SCAN) tries to provide a more uniform wait time. Everything is the same except when the head arrives at one end it returns immediately to the other end without servicing any requests.

* In practice neither algorithm is implemented as above. The arm only goes as far as the final request in each direction. Then it reverses direction without going all the way to the end of the disk. These are called LOOK and C-LOOK.

### Selection of I/O Scheduling Algorithm

Pattern of I/O requests has a substantial impact on the overall performance. E.g. if there's only on erequest, all algorithms behave the same. (Have we many or few requests right now?)

The file allocation strategy is important – less arm movement if the file is stored contiguously. If the file is indexed (therefore the index is cached in the main memory and it's easy to locate the blocks that belong to the file), the blocks can be widely spread on the disk.

The location of directories and index blocks is also important. We can have the directory on the first cylinder, or on the middle cylinder, the latter generally leading to less arm movement.

Caching directories and index blocks reduces the need for arm movement.

Other system operations such as demand paging (bringing into the main memory pages that belong to a (user?) process) have higher priorities than application I/O. If these operations occur frequently, they'll have a significant impact on the operation of the scheduler.

### I/O Scheduling in Linux Kernel

* read queue, write queue, different deadlines

* Similar to the elevator algorithm but associates a deadline with each request

* If several requests correspond to neighbour sectors they are merged

[…]

## Character Devices

Any character device driver registered to the kernel must also register a set of functions that implement the file I/O […]

[…]

# Network-attached Storage

Accessed remotely over the network. Access is by remote procedure call (RPC).

The storage is normally implemented as a RAID array with an RPC interface.

In addition to the physical system, we can have a non-volatile RAM cache for storing data that doesn't lose information if the power is down.
