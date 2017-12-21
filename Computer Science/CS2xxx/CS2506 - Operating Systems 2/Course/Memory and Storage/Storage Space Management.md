# Storage Space Management

* free space on disks similar to main memory but also dealing with sectors

* need to preserve consistency between main memory, cache, and disk

## File System Metadata

Most filesystems have a header. This describes the file system as a whole and gives a starting point for locating files in the system. It includes:

* the total size of the filesystem
* the amount of free space
* the date of the last mount
* the location of the free space data structures
* starting point for any name lookup

The header can be in a fixed location (e.g. the first block of the disk). But we will probably have many copies of the header (to ensure it doesn't get lost). Locations may store pointers to a common file.

## Disk Structure

Disk can be divided into partitions.

* RAID is a redundant array of inexpensive disks – this can be created virtually through partitions

    * multiple copies of things protects against failure and also speeds up access

A partition can be used raw or formatted with a file system.

Partitions are also known as minidisks and slices.

Something containing a file system is known as a volume. […]

As well as general-purpose filesystems, there are many special purpose filesystems which are customised specifically for embedded systems. They have specific structure corresponding to the type of data managed by applications.

    * optimised for fastest access to data

## Free Space Management

Unlike main memory, allocation is done in fixed-size blocks (block is typically a multiple of a sector (where a sector is 512 bytes)). Sectors used by a file may not be contiguous.

Can use either a free bitmap or linked lists (embedded in the free blocks) for tracking free memory. Where do we store the free bitmap though? Generally keep a copy in the kernel space in main memory, but then we need consistency. Also, we want to have the disk operating completely separately. If we place it in the middle of the disk, then we can reduce the amount of movement of the write head required to check it.

## Allocation

Simplest solution is to allocate contiguously. If the file grows, there needs to be enough space after the last block – if there isn't, the file must be moved to another space.

Another option is to allow the file to spread out, but keep the blocks as close as possible.

A linked list can be used to represent the blocks allocated to a file. This list can be a separate data structure, or each pointer to the next block is stored in the current one. If the list is sorted, it should contain only block numbers. It the size of the structure is larger than the block size, the list itself will be distributed on more blocks that point to each other.

Another approach is to use an array of pointers, one for each data block in the filesystem – each entry gives the next block of the file. This still requires a linear search.

To speed up the access time, the index blocks can be organised in a tree – with 512-byte blocks, the root will store 128 pointers addressing 128 index blocks that each address 128 data blocks, etc. This gives a logarithmic search.

These data structures need to be managed all the time as blocks change around.

## Directories

A collection of nodes containing information about all files in the filesystem. (?)

The directory maps a subset of names to file metadata – size of the file, file ownership, security characteristics, […]

A directory is also a file.

### Operations Performed on Directories

Similar to files:

* search for a file
* create a file
* delete a file
* list a directory
* rename a file
* traverse the filesystem

### Directory Models

* single-level

    * all files are the in the same directory, and must have unique names

* two-level

    * a separate directory for each user

        * there is the master file directory (MFD) and one user file directory (UFD)

* tree-structured

    * users can create their own subdirectories

        * one bit in each directory entry defines the entry as a file or as a directory

    * path is unique: names don't have to be

* acyclic-graph

    * allows directories to share subdirectories and files [check]

### Implementation of Sharing

In UNIX a new directory entry called `link` is created – it's a pointer (absolute or relative path name) to another file or subdirectory. The link is resolved by using the path name to locate the real file.

Another implementation is to duplicate the information about the shared resource in all directories sharing it. All directory entries about that file are the same. This solution raises the problem of consistency – a file can have multiple absolute filenames.

This is not as important at the moment, as many people are using co-operative access things like google docs. Several people can write at the same time (usually on their own copies, which are then integrated in some way).

## Consistency Checking

The filesystem checks to see if free blocks are indeed free. This is done periodically or when a mount operation is executed.

As this is time consuming, log files can be used – for example, when a file is deleted:

* remove the directory entry
* free the data blocks
* free the metadata structure

If the system crashes during any of these operations, the file system is left in an inconsistent state. As in databases, the delete operation should be either entirely executed or not. The journal contains enough information to control the operation.

## Block Caching

Similar to operation between main memory and cache memory (entire cache line brought in at once).

Transfer between disk and main memory is by whole blocks. The OS reserves memory space for file caches (buffers).

A kernel thread will take care of data synchronisation – each block in the cache that's marked modified is queued to be written on the disk and then marked as clean.

Synchronisation is also forced when a file system is unmounted.

As the cache space is limited, the problem of block replacement needs to be solved. The strategy used to replace a block is least-recently-used (LRU).

Two things to take care of (also described in points above):

1. Space management (page replacement in main memory)
2. Consistency (change will occur in main memory, and should be propagated to the disk)

## Summary

All data structures involved in storage are copied to the main memory for fast access and processing by the filesystem.
