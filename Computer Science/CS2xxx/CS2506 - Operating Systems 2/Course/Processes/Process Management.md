# Processes

A process is:

* an instance of a running program
* the context associated with a program in execution

A process consists of:

* the executable (the code/instructions)

* data

* management info

The data and management info make up the process context.

## Process Context

The context represents state information:

* program values/variables, stored in the user space

* management information (process descriptor), stored in the kernel space

The following things form the process descriptor – the main component of the process context:

* process ID
    * a unique integer value
* parent process ID
* real user ID
    * the id of the user who started this process
* effective user ID
    * the user whose rights the process carries
        * usually the same as the real user
* current directory
    * the start directory for looking up relative pathnames
* file descriptor table
    * a table with data about all input/output streams opened by the process
    * indexed by an integer value called the file descriptor
* the environment
    * list of strings of format `VARIABLE = VALUE` used to customise the behaviour of certain programs
* code area
* data area
* stack
  * for calling programs
* heap
  * for additional memory space when required
* priority
* signal disposition
    * masks indicating which signals are awaiting delivery and which are blocked
* umask
    * mask value used to ensure that specified access permissions are not granted when this process creates a file

## Basic Process States

* Ready
  * Can go from this to Running
  * Comes here when created
* Running
  * Can go from here back to ready or to blocked
    * E.g. might block itself while waiting for an I/O operation to finish
  * Can terminate from here
* Blocked
  * Can go from here back to ready

Nowadays we have much more complex sets of states than this basic example.

## Process Management

* Create
  * The internal representation of the process is created
  * Initial resources allocated
    * Resources will change over time.
  * Initialise the program that is to run the process.
* Terminate
  * Release all resources
  * Possibly inform other processes of the end of this one
* Change program
  * The process replace the code it is executing (by calling exec)
  * This is useful when we have multiple processes and we want them to do different things
  * We start with a parent process, and then use different children to do different things (multi-threading)
* Block
  * Wait for an event, e.g. the completion of an I/O operation
* Awaken Process (and put in queue)
  * After sleeping, the process can run again.
  * Waits for its turn once awakened.
* Switch process
  * process context switching (another process takes control of the CPU)
* Schedule process
  * Take control of the CPU
* Set process parameters
  * e.g. priority
* Get process parameters
  * e.g. CPU time so far

When a process is ready to run, it is sent to a ready-to-run queue, where it competes with other processes.

# Processes, Threads, and Scheduling

## Child Processes

A process can create a child process identical to it by calling `fork()` (the UNIX function). As the kernel creates a copy of the caller, two processes will return from this call.

When fork is called, the process saves its state, then switches control to the kernel process which will create the copy.

The parent and child will then continue to execute asynchronously, competing for CPU time shares.

CPU time is allocated to processes in constant-size chunks. Say a user process calls `fork()` before the end of its time-slice. Then the kernel process for this purpose takes over for the rest of the time-slice. At the boundary of every time-slice, the scheduler (another kernel process) takes control and decides which process (of all competing processes – it'll be the highest-priority one) takes control for the next time-slice.

The child and parent will have the same priority, as the child is an identical copy of the process, including the context. They will have different IDs, however, as they are distinct processes.

Generally, the child is used to compute something different from the parent. The `fork()` returns the child ID to the parent, while it returns 0 to the child itself. For this reason, `fork()` is placed inside an if test. The if block will be run by the parent, and the else block will be run by the parent. The two processes work from the same code, but are directed to different sections of it.

## Process Genealogy

All processes are descendants of the `init` process, whose PID is 1. The kernel starts init in the last stage of the boot process.

The init process then reads system init scripts and executes more programs, completing the boot process.

* every process has only 1 parent

* every process can have 0 or more children

* processes which share a parent are called siblings

## Threads

Switching process takes a lot of time, because the processes have to save their state, usually to the main memory.

A thread is known as a lightweight process. Within a process we can have several threads (execution flows) which share the process context, including code.

The context private to each thread is represented by the registers file and stack, the priority and own id. Generally the thread switch within the process is handled by the thread library, without calling the kernel. It is very fast as the thread context is minimal.

When a process starts execution […]

Say we have a process which has a main thread, and 2 new threads (so 3 execution flows). When this process takes control of a time-slice, the threads within the process are executed in turn according to their priority (each thread has its own priority).

Creating multiple threads makes a lot of sense when we have many CPU cores, to take advantage of parallel processing.

### Advantages and Disadvantages

* Threads provide concurrency, which can be exploited by many-core computers.
  * Concurrency also corresponds to the internal structure of many programs.
* If a thread changes directory, all threads in the process see the new current directory.
* If a thread closes a file descriptor, it will be closed in all threads.
* If a thread calls `exit()`, the whole process, including all its threads, will terminate.
* If a thread is more time consuming than others, all other threads will be starved of CPU.
