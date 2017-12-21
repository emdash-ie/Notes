In the past, when a new computer was designed, the design process started with a bunch of applications, and tried to optimise the computer according to these applications. This is no longer the case.

# Memory

Unlike the plain-space memory we saw for the sensor OS, in a general-purpose computer we have the memory hierarchy.

* Faster access but lower capacity memory closest to the CPU (which is the fastest device in the system).
* Slower access and higher capacity memory further from the CPU.

When a variable is brought into the CPU, it leaves multiple copies along the memory hierarchy, which need to be updated if the variable is modified.

## Virtual Memory

Originally programs were restricted by the size of the memory (e.g. if your program needed 65kB but you only had 64, it wouldn't run).

Now we have virtual memory, where addresses in a virtual memory space are mapped to some physical address. Originally this was done in software by the kernel, but now we have a dedicated unit called a memory management unit, which carries out this mapping quickly (in hardware).

* Many software processes handled by the kernel are being gradually moved to hardware, which is faster.

Memory is a very expensive resource, that needs to be shared between different processes. This is why we need to manage it.

The memory addresses issued by the CPU are physical addresses. The process layout is specified in terms of virtual addresses though.

### Address Translation

* Base registers
    * The virtual address is added to the content of a base register – the result is the physical address
    * Compared to a limit
    * Can change the content of the base register
* Segmentation
    * Dedicated registers for different segments
    * Different segments store different parts of the program
        * code
        * data
        * stack
    * Possible to use CPU dedicated registers, or the higher-order bits of the VA point
    * Still limited for processes
* Paging
    * Most flexible concept
    * Physical space and virtual space divided into pages of the same size
    * Pages in the virtual space are contiguous, but pages in the physical space can be anywhere
    * Aim to allocate few pages to a process
    * *Page frame* is any space in the physical memory where page could go
    * If a page is 4 KiB, we need 12 bits (as 2^12 = 4096) for an offset, to address any part of a page
    * VA = virtual address
        * page address and offset within the page
        * page address identifies a row in a page table
            * that row provides the physical location in memory of the corresponding page frame
            * the offset is used to identify a specific address within that page
        * page table has extra bits – control info for the kernel
            * e.g. a read-only marker
            * presence – is the page in memory or not?
                * e.g. initially when the process starts, not all pages are brought into physical memory
                * so we have some addresses that don't map to physical memory
                * these are allocated physical memory as needed
                * Alternatively, physical memory might be nearly full, and this page was swapped to the disk to make space
            * modified – at least one write operation has occurred in this page
                * only modified pages will be updated on the disk
                    * would be very expensive to do it for all pages
            * access – info in this page has been accessed [check]

### Multi-Level Page Table

* top-level page table is smaller, and the second-level page tables that we're not currently using don't need to be in memory

For example:

* 32-bit VA, 4 KiB (= 2^12^ bytes) page size

* 12 bits of VA needed to index the page in bytes

* other 20 bits of VA split in two:

    * 10 bits used to choose a row in the top-level page table

        * this row tells us which second-level page table to go to

    * other 10 bits used to select a row in the second-level page table

If we're only using one page, we need to have the top-level page table in memory, but we only need to have one of the second-level page tables in memory, and the rest can be swapped out.

So we have 2^10^ entries in the top-level table and 2^10^ entries in the second-level table, giving a total of 2^10^ + 2^10^ = 2^11^ entries. If each entry is 4 bytes, then we have to use 2^11^ * 4 = 2^13^ bytes = 8 KiB of memory to store the page tables.

If we had one single-level table, the whole thing would need to be in memory at once, so we would need 2^20^ * 4 = 4 MiB of memory to store the page table.

Using more than two levels provides further saving of space, but access to pages gets slower (already with the two-level table we have to read 3 memory locations instead of 2).

### Allocation

OS provides this memory service to processes in two forms:

* explicit allocation
    * process specifies the location of memory it needs
* implicit allocation
    * process specifies how much memory but not where it is

De-allocation can also be explicit or implicit (when areas not addressed by code are freed).

### Memory Layout

Generally OSes are using segmentation and paging together. There're code segments for pages of code, etc.

* Segmentation is preferred for protection – gives good control of the space allocated to a process, prevents a process from accessing other processes' code.
* But a process can only start if it has a minimum number of pages allocated to it.
* If a process only has small chunks of data, it doesn't make sense to waste a whole page.
* There's a block of memory with variable size, allocate blocks of memory to different processes
    * A page may not be given to a process, but instead used by the kernel and split into blocks which are allocated to different processes.
    * This gives rise to security of different processes accessing each other's data
    * Used so by processes that share data

Some of the memory space can be non-functional, if there are some memory chips that aren't installed.

## Memory Management Example

* Blocks are built on top of pages – each block is a number of pages. The size can be variable.

You could have a bit vector with one bit per page to mark whether a page is available. The kernel can check this vector to find an available page to use.

However processes generally need several pages, not just one or two, so allocation is typically done per block, using blocks of variable size.

We can then organise information about these blocks into a list:

* starting address of the block
* how many pages the block is (an integer)
* pointer to the next block position

Now searching this list to find an available block is O(n). We could arrange the list as a tree or a hash to speed this up.

The system could learn which sizes are mostly requested by processes, and organise the blocks to optimise for that, or just run as needed.

Now we have two possibilities:

* work at the page level
* work at the block level

Working like this will give us fragmentation, though – we'll have memory that isn't used. There are two types:

* internal (when not an entire allocated space is used)
    * process only uses 3 KB out of 4 KB in a page
* external (some blocks are too small to ever be allocated)

Allocation processes try to minimise both kinds of fragmentation.

## Selection Policies

### First-fit

Take the first block from the list that is greater than or equal to the requested size. If the request can't be met, it fails.

This tends to cluster allocations towards the low memory addresses – the low memory area gets fragmented, while the upper memory area tends to have larger free blocks.

### Next-fit

Start the search (for the next acceptable free block) with the next block after the last allocation, wrap around at the end. If returned to the starting point without allocation, the process fails.

This leads to a more even allocation of free memory.

### Best-fit

Allocates the free block that is closest in size to the request (very little internal fragmentation).

Tends to create significant external fragmentation, but keeps large blocks available for requests of larger size.

### Worst-fit

Allocate the largest block for each request.

This is good if most requests are of similar size, as external fragmentation will be minimised.

### The Buddy System

All blocks are a power of 2 in size. Let n be the size of the request. Locate a block of at least n bytes and return it to the requesting process:

1. If n < the smallest allocation unit, set n to be the smallest size
2. Round n up to the nearest power of 2. Select the smallest k such that 2^k >= n.
3. If there is no free block of size 2^k then recursively allocate a block of size 2^k+1 and split it into two free blocks of size 2^k.
4. Return the first free block of size 2^k in response to the request.

Each time a block is split, a pair of buddies is created – they'll either be split or paired together.

* It is easy to determine (by looking at bit k+1) which is the buddy of a block.
* This method tends to have very low external fragmentation. The price paid is more internal fragmentation.
* The block that is de-allocated is a buddy to a free block – they are merged in order to create a larger free one.

#### Advantages

* small blocks are allocated quickly
* larger blocks are split in two
    * eventually followed by the merge of the two blocks (the initial block is restored)
    * larger blocks size is maintained

## Over-allocation Techniques

Not all allocated blocks are in use all the time – seldom used blocks can be transferred to disk.

*Swapping* is transferring one blocked process' memory space on disk. When the process becomes active, it'll be restored.

* If the process shares code […]
* […]

### Segment/Page Swapping

There's a presence bit which tells whether the memory space is available on RAM or has been swapped to disk. If the stuff is on disk, the bit triggers an interrupt to retrieve the data from

If the hardware supports only a limited number of segments (code, data, stack), only those can be swapped. A larger number of segments allow for more memory space to be freed by swapping.

Paging is a similar technique but involves pages correspond to a finer-grained level.

# Memory-mapped Files

Within the kernel space, there's memory reserved for buffers. This memory will be allocated as required to speed up some functions.

When a file is requested from storage, a page or two of the file is read into memory in one operation (rather than an individual operation for each sector or reading the entire file at once). Pages are pulled into memory as needed (demand paging).

From now on, that buffer is reserved for this file. Everything in that buffer can now be accessed very quickly, rather than requiring a read from the disk.

# Windows NT Memory Management

Windows NT uses memory-mapped files (as one way to prevent processes having access to each others' content?).

[…]

## Page Management

When a process needs to read a page and is using its max working set size, then the choice of page to be replaced comes from its set.

* General purpose OSes are difficult to optimise because you don't know what kind of applications will be used
    * companies are focusing on optimising their OSes

## Windows NT Page Frame State Machine (diagram)

# Linux Memory Management

3 models:

* use pages
* use blocks (of variable sizes)
* slab(?) of memory
    * used when some processes need very small amounts of memory (far less than a page, e.g. 64 bytes)

## System Calls

* memory-mapped file operation for `execve()` speeds things up and is more efficient
    * for other system calls, there's no need to do this because the code is already in memory

## Allocation Mechanisms

* buddy system

## Example

Main memory: 4 MB
page = 4 KB

This means 1024 pages.

So we decide the first block should be 1 page.

The next will be a block of 2 pages, then 4 pages, and so on.

block: 1 page
block: 2 pages
block: 4 pages
…
block: 32 pages

Say we have a request of size n bytes. We try to find the smallest k such that 2^k >= n.

If n is 700 B, then 1 block of one page will be enough.

Say n is 7254 B – in that case we need a block of 2 pages free. Say there are none free. Then we need to find a block of 4 pages.

Once we've found this, we split it in two – half will be allocated to this process and half will be marked as free.

If we can't find a block of 4 pages, we look for a block of 8 pages. If we've found this, the 8 will be split into two blocks of 4, and one of the blocks of 4 will be split into 2 blocks of 2 pages. One of those will be allocated to the process and one will be marked as free.

When these blocks become free, it's very easy to merge them to make larger blocks.

## Slab Allocator

* Works similarly to the buddy system, but just for small size (e.g. a few bytes).
* Good for reducing internal fragmentation

## Page Management

* a possibility is to use 4-level page-table design
    * four levels of indirection (4 tables)
    * not all levels are used, but that's what the system provides
    * uppermost bits of VA index a page global directory
    * second field is used as a pointer to another page directory
    * finally we get to a page table

## Analysis

* Android uses paging and memory mapping
    * but many mobile systems do not use paging
        * because it's expensive, either in software or in the micro-architecture

## Summary (Memory Management)

Main memory management means a set of services:

1. monitoring free memory
    * this is the basic service provided by the kernel
2. allocation to processes
3. replacement
4. memory mapping

The first 3 can be implemented as individual services or just as one service.

These are used all the time, so implementation is important – they need to run quickly.

Security is also important – guaranteeing that processes can't have their memory space modified by other processes. This isn't covered in this course.
