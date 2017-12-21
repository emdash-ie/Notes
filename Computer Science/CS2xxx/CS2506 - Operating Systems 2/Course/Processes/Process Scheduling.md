## Scheduling

Historically, the CPU is allocated to one process until its completion (batch processing). After this period of time, the CPU was time-shared by multiple processes ready to execute.
As the CPU is time-shared, processes compete for the next available time slot.

The scheduler is the kernel process that implements an algorithm that decides which process gets the CPU next.

* The scheduling process needs to be fair to all processes.
* Processes ready to execute are organised in a queue (the ready to execute queue), from which the scheduler selects the next one.
* A process takes control of the CPU by having its state restored, after the state of the previous process is saved.
* A process can have control of the CPU for at most one time slice (represented by `tau` seconds).
* The execution time of the scheduler should be very short, as it needs to operate just on the boundary of a time slice.
    * The execution time of the scheduler shouldn't depend on the number of processes to execute. (Should be a constant-time operation.)
    * Uses a binary vector with one flag per process (in Linux) to ensure this.

### Scheduling Strategies

#### First-Come First-Served (FCFS a.k.a. Round Robin)

* Processed are getting CPU control in their order in the queue.
* One possibility is to have control of the CPU until the process finishes – non-preepmtive execution. This may lead to starvation of other processes.
* So the best solution is to time-share the CPU.
[more here]

##### Example: shortest process first

If the CPU isn't time-shared (and so is batch-processed), the order in which processes are scheduled is important.
* Processes can be ordered according to their execution time.
* If processes get control in the increasing value of their execution time, the average turnaround time is better than in the random order.
    * turnaround time is the waiting time + the execution time
    * average turnaround time is the sum of turnaround times for each process, divided by the number of them
        * important for admin – gives a measure of how long a process will stay in the system until its completion
    * the time consumed from the moment the process is ready for execution until its completion.

Say you have four processes with their completion times in brackets: a(50), b(60), c(20) and d(45).

In that order, the turnaround times will be: 50, 110, 130, 175.

The average turnaround is then 465/4.

If you order them as shortest-first, the turnaround times become: a(115), 175, 20, d(65).

* To do this though, you need to know the execution times of all the processes, and you need to know that they'll all start at the same time.
  * These characteristics exist in embedded systems.

#### Priority Scheduling

* processes are different, some interactive and some computationally demanding.
  * The time for some is dominated by I/O, and for some is dominated by CPU time.
  * A process with no I/O can't be switched to a blocked state(?)

So we assigned a priority to processes. This is an integer – the lower the value, the higher the priority.

* kernel processes have higher priority than user processes
* give fast, interactive processes higher priorities
* historically, the priority was assigned in advance, but nowadays processes can have their priorities changed at runtime
  * this can happen when a process has to wait a long time for an I/O operation with a hard drive
    * The priority is increased once the operation is finished.
  * This can also happen with a CPU-intensive operation
    * If it gets a couple of time slices to itself, the priority may be decreased to allow access for other processes

##### Multilevel Feedback Queues

* Several queues, each associated with a priority level. Initially each process gets a priority that puts it on a certain level.
* After consuming each time-slice, the process priority is lowered to the next level, until it reaches the lowest acceptable priority. At that level, the strategy is round-robin.
* [more here]
* Generally we have at most 4-16 queues/priority levels.
  * With sensors and embedded systems, we have at most 4.
* For each process, we have a highest acceptable priority and a lowest acceptable priority.

###### A Process for Power Management

Many systems have an idle process, which has the lowest priority. When there is no other process to execute, the CPU is given to the idle process, which switches the system into sleep state(s), to manage power consumption.

The idle process implements the kernel power policy manager, which owns the decision-making and the set of rules used to determine the appropriate frequency/voltage operating state. It may make decisions based on several inputs, such as end-user power-policy, processor utilisation, battery level, or thermal conditions and events.

The processor driver is used to make actual state transitions on the kernel power policy manager's behalf.

Note the idle process can be quite complex, because of the amount of input parameters. Also a sleep state wouldn't involve just the CPU, but also other hardware components.

The system needs to switch back to the active state when there are new processes.

##### MFQ (cont.)

As well as the priority changing at runtime, there can be a different time-slice size for each priority level, where low-priority levels get much larger time slices, as they are tasks which take longer. This is often increased exponentially for lower priority levels, e.g. the time-slice for level i might be q*2^i^

If a process didn't complete at level i, then its priority is lowered and its time-slice is increased.

###### Two-Level Scheduling

Sometimes, there are too many processes that can't fit in main memory at the same time. So some will have be stored on the disk. But the process of restoring the process in the main memory while others are saves on the disk is time-consuming – this can lead to thrashing.

One solution is to use two-level scheduling:

* a higher-level, long-term scheduler that runs more slowly (maybe every n time-slices) will select the subset of processes resident in the main memory
* processes in the main memory are then managed by a different scheduler, lower-level and short-term

99% of the time, only the short-term scheduler is running – the other is only launched when the system is struggling.

###### Real-time Scheduling

* Keeps doing the same thing forever until you switch it off.
* Event-driven systems – system responds to events signalled by interrupts.
* Mostly short processes
* Have to meet deadlines
    * e.g. `a` has to happen every 400 time units, `b` every 500 time units, `c` every 700 units, `d` every 900 units.

Say we have those processes, and each will execute in less than the time slice of 100 time units.

In general we can pick the ones with the earliest deadlines first. When things have the same earliest deadline, we need another priority to choose which one. Could be whichever one had control longest ago.

###### Multi-Core Systems

* A package is two cores and one L2 cache.
* On each core we can have processes that are totally independent of one another, or processes that belong to the same application.
    * If they belong to the same application, then they share data.
* We can also have different threads of the same process.
    * These share everything (code, data, etc)
    * All of this shared stuff needs to be stored in L2.

In hardware, L2 is split into a number of blocks, and access is by a grid. Cores can't access the same block at the same time. So they can't access the exact same data at the same time.

We can't eliminate contention, but we can reduce it by designing well.

First scheduling policy: group scheduling

* Put processes together that share data (and possibly code) - these processes are said to have affinity for one another.

Many multi-core systems are mobile devices powered by batteries, so energy usage is important and must be managed. With multiple packages, we have to decide at any time whether we should use all packages, or keep one in a sleep state to save energy. If execution time is not important, the scheduler will choose to use just one package, and won't turn on the second. This is the second scheduler policy.

All cores don't have to be loaded to the same degree – some can be overloaded and some can be underloaded. We can define an average load, which is the boundary between under- and over-loaded.

If one core is overloaded and one is underloaded, we want to move processes from one to the other – this is load balancing. This is a new attribute of the scheduler specific to multi-core systems.

What is load? We can define it as the amount of time spent busy in a certain period of time.

The third scheduler policy is domain scheduling.

* This is a hardware perspective, concerned with resources.

A domain is a group of cores that share the same specifications and share the same load-balancing and scheduling policies.

We can create hierarchies of domains. Say level 1 is any package used alone in a four-package system. Say level two is two packages used at once, and level 3 is all packages used.

* For level 1 we have 4 domains
    * Level 1 is a two-core system
* For level 2 we have 2 domains
    * Level 2 is a four-core system
* For level 3 we have 1 domain
    * Level 3 is an 8-core system

We can have different scheduling policies then for each domain.

* For level 3 we might say that if a package has low load, we'll switch it off and distribute tasks to other processes
    * This would be an energy-saving policy
* For level 2 we might use load-balancing for a policy (balance the load across cores in each domain)
    * We can have different policies in different domains of the same level
* For level 1 we might say "if exec: move to another core" (this also mentioned for level 3)
    * Alternatively, on one particular domain we might pair processes that are CPU-intensive (but use little memory) on one core and processes that are memory-intensive (but use little CPU) on the second core.

With this process we're creating virtual machines:

* 1 with 8 cores
* 2 with 4 cores each
* 4 with 2 cores each

The scheduler has prior info about processes:

* Memory access patterns
* Resources that are required

It gets this info from previous executions (collects runtime info), or it can use heuristics to anticipate resource usage.

# Scheduling (cont.)

Different operating systems may implement these scheduling principles in different ways, or may not implement all of them. Group and domain scheduling are popular.

# UNIX

## Primitive calls

* `fork()` creates a new process that is an exact copy of the parent process
* `exec()` replaces the code of the existing program with a new one
* `exit()` allows a process to voluntarily terminate
* `kill()` allows a process with appropriate privilege to terminate another process
* `wait()` allows a process to pause until a child process has finished, and pick up its exit status

## Process States

In addition to running, blocked, and ready, there are a few additional states:

* `SSLEEP` – a blocked state where the process cannot be awakened by a signal
* `SWAIT` – a blocked state that allows the process to be awakened to handle a signal
* `SRUN` – Identifies running and ready processes. The `u` variable contains the process table info of the currently running process
* `SIDL` – a process is created but the copy of its parent's memory space can not be done immediately
* `SZOMB` […]
* […]

## Process Table

The process table uses some flags to record the status of the process in respect to memory (the process is in memory or swapped out) and tracing.

The process table is divided in two:

* The first part is an array of structures as part of the kernel space. These structures hold admin info, state info, id, scheduling info.
* The other part is data not needed when the process is swapped out, and is part of the user space. User structures are swapped along with the rest of the process' memory space – this is to preserve space.

## Scheduling

The scheduler uses process priorities. The actual scheduling code is in the context

* priority is dynamically updated:
    * `p = min(127, c/(16 + 100 + n))`
    * `n` is a parameter called nice – if this increases, the priority lowers
* two-level scheduler

# TinyOS

Very simple compared to what we've seen with a general purpose computer. There are many other OSes for sensors, but this one is interesting because it shows how simple and basics things can be.

It's also very similar to OSes for internet of things devices.

Tasks, events and commands execute in the context of the frame and operate on its state.

* CPU typically 8 or 16 bits
* Processor typically 4 MHz
* Memory in KB
* No virtual memory, segmentation, or paging

Energy has to be managed as tightly as possible.

* Computation has to be very fast
* Communication has to be done as seldom as possible.

We have sensors deployed in the environment, which create sensor networks that are used to push sample data towards a server. The server does storage.

Each sensor works as a router, as well as doing its sampling work.

The OS must have a footprint of KBs or less in main memory. Remember the memory here is just a plain location, addressed simply. No files, no virtual memory.

Modular system.

This is an OS for tiny sensors that provides a set of system SW components. Only the necessary parts of the OS are compiled with the application, meaning each application is built into the OS.

An application wires OS components together with application-specific components – a complete system consists of a scheduler and a graph of components.

A component has four interrelated parts:

* A set of command handlers
    * commands are input
    * generally target tasks
* A set of event handlers
    * events are input
* A fixed-size frame
* A bundle of tasks

The component may also be a source of events or of commands.

A task is not a process – we don't have the concept of a process here.

A task defines a computation that corresponds to some function.

E.g.:

* `get ADC data` – get data from the ADC (from the sensor)
* `send packet` – for communication

At most 10/20 instructions.

* All tasks execute until completion.
    * unless there is an event
    * events interrupt tasks that are currently in execution
        * control is taken by that event handler

Event handlers do very simple things. Generally they "post" tasks – pushing them into the ready queue. The only other things they do are small things, e.g. incrementing a counter or assigning a local variable.

* events can be interrupted by other events

When the ready queue is empty, the core is switched to a sleep state, but the sensors aren't, as they still need to act as a router.

The whole system is a graph of components.

* some of these are OS components
    * timer, radio, routing, etc.
* some are application-specific
    * sensors and specific processing

Commands can't trigger events, because that could create cycles.

If a task is posted but there's no space in the ready queue (in TinyOS v1), it fails. Since the queue is a shared resource, one misbehaving component can ruin everything.

In version 2, now tasks have priorities, and the scheduler can run earliest deadline first. The order of execution can be changed.

One byte of state is allocated per task, this gives us 255 possible priority levels – it's assumed there's less than 255 tasks in the system.

A basic post will fail if and only if the task has already been posted and has not started execution.

## TinyOS Timer

Different sensors can have very different sampling periods (a few seconds, a few hours).

## Field Monitor Application

Sampling takes time, and with the task/event structure, the CPU doesn't have to be waiting for the data. The task can be `get ADC data; return immediately`, and then the CPU will send the command to the ADC and then continue with the next task. When the data is ready in the ADC, an event will be sent to tell the CPU that the data is ready.

Remember that energy consumption for communicating (e.g. by radio) is orders of magnitude greater than energy consumption in the rest of the system.

The units onscreen are all software, except the RFM, the ADC, and the HWClock. As a designer, we wouldn't see these as hardware but as components that we can use in our application.

### Active Messages

The message includes the destination handler and nothing else (besides the message itself). This keeps things simple.

We don't have to transport layer, we don't have the protocol stack (IP, TCP) from the internet.

### Main

The main is just for initial setup (e.g. variable initialisation), it's not involved after that, so no events ever need to go to the main.

Note there's no monitoring of the sensors to make sure they're ok and still working.

# Android

The concept was that the handheld is the new PC, so we need a complex general purpose OS.

However, android also includes non-OS things like middleware and applications. Applications like the phone, the messages, etc. are basic and built-in.

He'll focus on activity and intent and how activities are managed in Android on Monday.

# Android

* kernel, middleware services, applications
* (extends beyond a classic operating system)
* has its own JVM (Dalvik VM)
* shares components and data among applications
* applications reuse components from one another
    * a process may skip some components
    * execution flow can jump from one process to another
        * this is inter-process communication (IPC)
        * (possibly just on the same component)
* this is an event-driven operating system, rather than a general-purpose operating system
    * for general-purpose system, all interaction is by commands
    * for this, the operating system may respond to user events if it has the resources
    * [check difference between general-purpose OS and event-driven OS]
* applications have a non-visible part to their lifecycle

## Android Applications

Applications don't have a single entry point for everything in the application (no `main()` function, for example). They have components that the system can instantiated and run as needed.

An *intent* is an amalgamation of ideas such as windowing messages, actions, inter-process communication, publish/subscribe models and application registries.

Intents define intention to do some work (e.g. broadcast a message, start a service, launch an activity, dial a phone number, answer a call). They can also be used by the system to notify the application of specific events (e.g. arrival of a text message).

*Views* are UI elements that can be used to create a user interface.

An *activity* is a UI concept. Usually it represents a single screen in the application. It can contain one or more views.

*Content providers* allow to expose data to sharing by multiple applications.

A *service* is a background process, either local or remote.

## Lifecycle

The android application lifecycle is managed by the system based on the user needs, available resource, etc.

The system decides if an application can be loaded or it is paused or stopped.

The activity currently used (has visibility) get higher priority, while an activity not visible can be killed to free resources.

Each android application runs in a separate process which hosts its own virtual machine. [dynamically changing priority, etc]

* `onCreate()`
    * -> `onStart()`
* `onStart()`
    * -> `onResume()`
* `onResume()`
    * -> Running -> `onPause()`
        * another activity comes in front of the activity
* `onPause()`
    * -> `onResume()`
        * the activity comes to the foreground
    * -> `onStop()`
        * the activity is no longer visible
    * -> killed -> `onCreate()`
        * other applications need memory
        * user navigates back to the activity
* `onStop()`
    * -> `onDestroy()`
    * -> `onRestart()`
        * the activity comes to the foreground
    * -> killed -> `onCreate()`
* `onRestart()`
    * `onStart()`
* `onDestroy()`
    * shut down

If a user interacts with an application, that application gets the highest priority.

## Tasks

With IPC (e.g. we want to display a street map from GPS), we are starting a task following the user's commands.

A task is a sequence of activities that make the execution flow.

The fact that you're allowed go from one process to another is very different from general purpose OSes.

### Task Stack

A task is a stack of activities. The top of the stack contains the current activity.

If a new task is started, the previous one is saved and switched to the background. So the stack is preserved, but is not the running task. It's still in the memory. We may have more than one stack that's in the background at once. Activities in the stack are never re-arranged, just pushed and popped.

If the system needs resources, it can delete activities from the stacks, or delete whole stacks.

This is how different applications are kept available to the user.

# Linux

Processes and threads are tasks. (Different from android tasks).

## System Calls

There are nearly 300 system calls, many related to process management:

* `fork()`
* `vfork()` is a variation on `fork()` that eliminates the copy of the parent memory space in the case where `fork()` is quickly followed by an `exec()` call. The child uses the parent memory space until invoking `exec()`. The parent is suspended this time.
* `clone()` allows specification of which of the parent's resources are to be shared with the child and which are to be copied.
    * specification is with clone flags
* `execve()` allows a process to specify a program to begin running in place of the current one.
* [more here]

## Scheduler Calls

* `sched_setscheduler()` allows a process with enough privileges (system) to change the policy and priority level the scheduler uses for the specified process
[…]

## Process State

* TASK_RUNNING
* TASK_INTERRUPTIBLE
* TASK_UNINTERRUPTIBLE
* TASK_STOPPED
* TASK_TRACED
* TASK_ZOMBIE
    * still consuming resources?
* TASK_DEAD

## Process Creation

`fork()`, `vfork()`, and `clone()` all call `do_fork()`.

* if it's `vfork()`, the parent needs to be suspended
    * the parent will return to ready when the child calls `exit()` or `exec()`
* the child can be in a stopped or ready state initially
* `alloc_pid()` is called to give the child a process id
    * this will try to use `last_pid + 1`, but it will have to check that it's not in use
    * this searching could be very slow, so a bit vector is used – the first 0 that's found gives the new PID

The parent can return to ready if the call came from `fork()` or `clone()`.

# Linux Scheduler

This gives preference to interactive processes and processes with lower `nice` values.

* two multilevel feedback queues – one for active processes, one for expired processes
* uses a bitmap to quickly determine which queue is the highest priority nonempty one
[…]

Two classes of process:

* real-time (RT)
    * these are scheduled according to SCHED_FIFO or SCHED_RR (round robin).
    * first-in-first-out processes will always complete
    * round-robin ones will return but with the same priority
    * these are processes which generally don't use a full time-slice
* time-sharing
    * these work as described before

## Priorities

Real-time processes have a static priority in the range [0, 99].

Time-sharing processes have a priority in the range [-20, 19]. Internally they are scaled to the range [100, 139].

Smaller values correspond to higher priorities.

Remember each priority level is a queue. If a real-time process from a round-robin queue doesn't complete, it'll return to the end of the queue it came from.

[check all of this bit, lots of info here]

If there are no more time-sharing processes in the active structure, the time-sharing parts of the active and expired structures are swapped.

`tick()` is a system call which checks what a core is running.

* if the core is idle, it might rebalance the load from other cores
* if the current process is from the expired set, this is considered an error
    * this can happen if there are no active processes left and no swap occurred to swap the active processes with the expired processes
    * it's an error because we only want active processes to have controller

# The Linux Scheduler

* runs in constant time because it uses a bit vector (where each bit is set if and only if there are processes waiting in the corresponding queue) to check which process to run
