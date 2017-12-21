# Intro

* The support the OS provides for parallel execution.

# Content

Application: matrix multiplication

* clear example of the potential for parallel execution

* split problem into groups of lines, each group allocated to one process

* these processes share some data though

    * the shared stored will be stored in cache L2 (this is OS support)

Speedup is the execution time sequentially, divided by the execution time in parallel. This is generally less than the number of cores (which is the theoretical potential speedup).

* pipeline model

    * computation split into successive operations, which can be executed by different cores

    * all these operations can overlap

Parallel execution of an application:

* multiple processes running in parallel

    1. create multiple processes / threads

        * benefit of threads is that the context of the process is used

        * but data protection is an issue

    2. data sharing

    3. mutual exclusion to data that is updated

    4. scheduling / synchronisation

        * if we have fewer cores than processes

* shared data

* communication

    * t_comm / t_comp << 1 – communication should be very efficient

# Summary

* parallel computing still not prevalent in mass devices, just high-performance computing

* some operating systems are better than others at providing the means for parallel execution

* this material is not examinable, but is useful/interesting
