The filesystem implements all the operations required to manage files.

# The File Concept

A file is a contiguous logical address space.

Contains either data (numeric, character, or binary) or code.

# File Structure

A few options:

* None

    * sequence of words or bytes

    * data semantics lost, no way to get it apart again

* Simple record structure

    * a collection of related fields

    * lines

    * fixed length or variable length

* Complex structures

    * formatted document

    * relocatable load file

* Can simulate the last two (simple record structure and complex structures or formatted document and relocatable load file?) with the first method by inserting appropriate control characters

* controlled by:

    * the OS

    * the program

## File Attributes

* name

    * only information kept in human-readable form

* identifier

    * unique tag identifies the file within the filesystem

* type

    * needed for systems that support different types

    * UNIX file types (e.g. directory, pipe, device, link) or file formats?

* location

    * pointer to file location on device

* size

    * current file size

* protection

    * controls who can read, write, execute

* time, date, and user identification

    * data for protection, security, and usage monitoring

Information about files is kept in the directory structure, which is maintained on the disk.

# File Operations

A file is an abstract datatype. It offers the following operations:

* create

* write

* read

* reposition within file

* delete

* truncate

* open(F_i)

    * search the directory structure on disk for the entry F_i and move the content of the entry to main memory

* close(F_i)

    * move the content of the entry F_i in memory to the directory structure on disk

## Open Files

Several pieces of data are needed to manage open files.

* file pointer

    * pointer to the last read/write location

    * one for each process that has the file open

* file open count

    * counter of the number of times a file is open

    * allows removal of data from open file table when the last process closes it

* disk location of the file

    * cache of data access information

* access rights

    * per-process access mode information

## Open File Locking

Mediates access to a file.

Provided by some OSes and file systems.

Two kinds:

* mandatory

    * access is denied depending on locks held and requested

    * only one process

* advisory

    * co-operating processes may use locks to co-ordinate access to a file among themselves, but unco-operative processes are also free to ignore locks and access the file in any way they choose

# Access Methods

* sequential access

    * read next

    * write next

    * reset

    * no read after last write (rewrite) (?)

* direct access (n is a relative block number)

    * read n

    * write n

    * position to n

        * read next

        * write next

    * rewrite n

# File System Services

* create/remove file, address file, open/close file, read/write an open file, fetch/modify metadata of a file

* shared/exclusive access to a file

* algorithm for exclusive file access (reads like gibberish?):

    * if Q (queue of processes awaiting access) is non-empty, then add P to the tail of Q and return

    * If no process currently has exclusive access to the file, give P access and return

    * If P requests read-only access and Q is empty and the processes with current access are readers, give P access and return

    * Add P to the tail of Q and return

# Metadata

Metadata is data about the file – name, size, last modification date, owner, protection codes. It's managed by the OS and sometimes also by applications.

The file type is supported by some OS.

Filetypes are used in a number of ways, for example they can be used to control certain aspects of reading/writing such as end-of-line conventions for text files.

Files that are compressed are automatically decompressed when read.

Another aspect is assigning an application to the file.

(Different from file attributes in that it's stored within the file and is part of it, rather than stored and managed by the file system. I think.)

# The Filesystem Design

The filesystem process can be a part of the kernel or not – it can instead be a distinct process in the user space.

In the latter case, there are some issues:

* how does it handle system calls?

* how does it access process' memory space?

* how can it obtain process information that is stored in process tables?

* how does it access the drivers?

One possible answer: a new protocol of message-passing between processes.

## Management Data Structures

The FS uses two important data structures for file management:

* the open file table

    * entries for all open files

    * each entry stores file attributes (size, device, shared or not shared, etc.)

* the mount table

    * making a file system accessible is called mounting

    * the details of mounting a system vary considerably between filesystems

        * in some cases a device is referenced explicitly and the FS metadata is read at that time. For other systems, the new FS is added into an overall naming scheme. In these systems, the file names are determined by the mount operation rather than by the physical operation.
