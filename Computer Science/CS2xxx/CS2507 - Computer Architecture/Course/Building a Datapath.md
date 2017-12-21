# The Processor

The CPU performance factors are:

* The instruction count
    * this is determined by the ISA and the compiler
* CPI and cycle time
    * This is determined by the CPU hardware

To investigate these we'll examine two MIPS implementations:

* A simplified version
    * This is a simple subset that shows most aspects:
        * memory reference
        * arithmetic/logical
        * control transfer
* A more realistic pipelined version

## Instruction Execution

There are two basic steps for all instructions:

1. Program counter -> instruction memory [?]
    * fetch the instruction
2. Register numbers -> register file
    * load data
    * read/write registers

Depending on the instruction class, then:

* Use ALU to calculate:
    * arithmetic result
    * memory address
[…]

## Building a Datapath

A datapath is a set of elements that process data and addresses in the CPU.

### Instruction Fetch

* requires two state elements
    * instruction memory
    * program counter
* increments PC with an added

### R-Format Instructions

* The MIPS instructions with 3 registers (source1, source2, and destination).

1. Read two register operands
2. Perform arithmetic/logical operation
3. Write register result

### Load/Store Instructions

1. Read register operands
2. Calculate address using 16-bit offset
    * use ALU, but extend
3. For:
    * Load – read memory and update register
    * Store – write register value to memory

### Branch Instructions

1. Read register operands
2. [check]

# ALU Control

the ALU is used for:

* Load/Store – uses the add function
* Branch – uses the subtract function
* R-Type instructions – uses a function depending on the funct field

# Datapath Control

A datapath needs a control because it has sequential circuits which must be clocked.


# Implementing Jumps

Jumps use word addresses.

* Update the PC with concatenation of (in order):
    * top 4 bits of old PC value
    * 26-bit jump address
    * 00
* So there's an upper and lower limit to how far you can jump.

* Need an extra control signal decoded from the opcode
    * called a jump control
    * set only when opcode has the value of 2

# Performance Issues

The longest delay (longest path) determines the clock period. The longest path is the load instruction:

* instruction memory -> register file -> ALU -> data memory -> register file

It is not feasible to vary the clock period for different instructions, because it becomes too complicated.

So all instructions are delayed to fit the longest, which violates the design principle of making the common case fast.

Pipelining can be used to improve performance.

## Pipelining (At the Instruction Level)

Overlap execution to give parallelism.

## MIPS Pipeline

Five stages, one step per stage:

1. Instruction fetch from memory (IF)
2. Instruction decode & register read (ID)
3. Execute operation or calculate address (EX)
4. Access memory operand (MEM)
5. Write result back to register (WB)

Assume the time for the stages is:

* 100 ps for register read or write
* 200 ps for other stages

This gives a total time of 800 ps for the load word instruction:

1. 200 ps for instruction fetch
2. 100 ps for register read
3. 200 ps for ALU operation
4. 200 ps for memory access
5. 100 ps for register write

Whereas the `beq` instruction had now memory access or register write, and so only takes 500 ps.

Pipelining works by allowing e.g. the instruction fetch operation for the second instruction to start while the rest of the first instruction happens.

### Pipeline Speedup

If all stages are balanced (take the same time), then the time between instructions for pipeline is = time between instructions without a pipeline / number of stages.

If things aren't balanced, then the speedup is less.

Note that the speedup is due to increased throughput – the latency (time for each instruction) does not decrease.

## Pipelining and ISA Design

MIPS is designed for pipelining:

* All instructions are 32-bits
    * this makes it easier to fetch and decode in one cycle
    * compare with x86, which has 1- to 17-byte instructions
* Small number of regular instruction formats (R-format, I-format, jump)
    * can decode and read registers in one step
* load/store addressing
    * can calculate address in 3rd stage, access memory in 4th stage
* Alignment of memory operands (word alignment)
    * memory access takes only one cycle

## Hazards

Some situations prevent starting the next instruction in the next cycle.

* structure hazards
    * a required resource is busy
* data hazards
    * need to wait for previous instruction to complete its data read/write
* control hazard
    * deciding on control action depends on previous instruction
    * can't make the decision what to run next till that instruction has finished

### Structure Hazards

Conflict for use of a resource.

In MIPS pipeline with a single memory:

* load/store requires data access
* instruction fetch would have to stall for that cycle
    * this would cause a pipeline "bubble"

So pipelined datapaths require separate instruction/data memories (or separate instruction/data caches). This way you can fetch an instruction and access data (from different instructions) at the same time.

[missed a lecture on Monday] - week 6?

# Multi-Cycle Pipeline

* At each stage, different sections (instruction fetch, instruction decode, execution, memory, write back) are being used by/for different instructions.

## Pipelined Control

The control signals are derived from each instruction. Control lines start with execution stage.

Control signals are passed along from stage to stage with the instruction until they're used – each stage uses the control signal that's for it and passes the others along.

Instruction fetch doesn't need control signals, because it's always either fetching the next instruction or fetching a branch instruction.

## Hazards (cont.)

### Data Hazards

Consider this sequence which has dependencies (the same number needs to be used in subsequent stages):

```MIPS
sub $2, $1, $3
and $12, $2, $5
or $13, $6, $2
add $14, $2, $2
sw $14, 100($2)
```

We can resolve hazards with forwarding. How do we detect when to forward?

Assuming $2 has the value 10 before the subtraction and -20 after the subtraction.

#### Detecting the Need to Forward

Pass register numbers along the pipelines.

* e.g. `ID/EX.RegisterRs` = register number for Rs sitting in ID/EX pipeline register

* ALU operand register numbers in EX stage are given by: `ID/EX.RegisterRs`, `ID/EX.RegisterRt`

There is a data hazard when:

* `EX/MEM.RegisterRd` = `ID/EX.RegisterRs`
* or `EX/MEM.RegisterRd` = `ID/EX.RegisterRt`

So at these points we need to forward from EX/MEM pipeline register.

There's also a data hazard when:

* `MEM/WB.RegisterRd` = `ID/EX.RegisterRs` or `= ID/EX.RegisterRt`

At these points we need to forward from MEM/WB pipeline register.

But these conditions only require forwarding when the forwarding instruction will write to a register, so we check:

* If `EX/MEM.RegWrite` or `MEM/WB.RegWrite` is set.
* That `Rd` for that instruction is not `$zero`.

Remember that in MIPS every use of `$zero` as operand yields an operand value of 0, so every instruction that uses `$zero` as the destination register will always output a 0.

## Double Data Hazard

You can also have a double data hazard, which needs different treatment. Consider this sequence:

```MIPS
add $1, $1, $2
add $1, $1, $3
add $1, $1, $4
```

Both hazards occur.

We want to use the most recent result at the MEM stage.

So we have revise the MEM hazard condition – only forward if EX hazard condition isn't true (make sure execution hazard is taken care of before we handle the memory hazard).

## Data Hazard and Stalls

Data forwarding doesn't work when instruction tries to read a register following a load instruction that writes the same register.

Something must stall in the pipeline for a combination of load followed by an instruction that reads its result.

Therefore, we need a hazard detection unit to tell when to stall.

### Load-Use Hazard Detection

Check when using instruction is decoded in ID stage.

ALU operand register numbers in ID stage are given by `IF/ID.RegisterRs` and `Rt`.

We have a load-use hazard when:

* `ID/EX.MemRead and ((ID/EX.RegisterRt = IF/ID.RegisterRs) or (ID/EX.RegisterRt = IF/ID.RegisterRt))`

If we detect a load-use hazard, we need to stall and insert a bubble.

### How to Stall the Pipeline

* Force control values in ID/EX register to 0
    * EX, MEM, and WB do *nop* (no operation)
* prevent update of PC and IF/ID register
    * using instruction is decoded again
    * following instruction is fetched again
    * 1-cycle stall allows MEM to read data for `lw`
        * can subsequently forward to EX stage

# Hazards (cont.)

We saw that stalls reduce performance, but that we need them to enable pipelining.

The compiler can arrange code to avoid hazards and stalls, but this requires knowledge of the pipeline structure (it's difficult).

## Branch Hazard

We don't know the result of a branch until after the memory access step.

Before we know, the instructions following the branch are executed in the meantime (static prediction). If we are branching, the intermediate instructions need to be discarded.

The number of cycles lost waiting for the branch instruction is called the `branch delay`.

### Reducing Branch Delay

Try moving the hardware that determines the outcome to the ID stage (previously it was in the ALU). This comprises:

* a target address adder
* a register comparator

This will allow us to forward the result and branch earlier.

* intermediate instructions are made into a bubble – they will not change anything, though the calculations will be performed.

### Data Hazard

If a branch instruction uses a register that's the destination register from previous instructions, then that result might not be ready in time for the branch instruction – this gives us a data hazard within the branch hazard.

If the branch instruction requires a value from (e.g.) an `add` instruction immediately before it, then we have to stall the branch instruction for one cycle.

If the branch instruction comes right after a load instruction, we have to stall the branch for 2 cycles.

### Dynamic Branch Prediction

In deeper and superscalar pipelines, branch penalty is more significant. Dynamic branch prediction is used for this.

* record every branch that's taken in a table or buffer
    * if we encounter a branch again, we guess that we'll do the same thing as last time (if we took it then, we'll predict that it'll be taken this time)
    * this makes sense for loops in programs, where it'll repeat multiple times from a branch condition

* The table is indexed by recent branch instruction addresses
* If the guess is wrong, we flush the pipeline and flip the prediction

#### 1-Bit Predictor

* Only looks at the last branch condition outcome to make prediction
* This mispredicts things a little with nested loops (at the starts and ends of inner loops)

#### 2-Bit Predictor

* Only changes prediction on two successive mispredictions

#### Calculating the Branch Target

Even with a predictor, we need to calculate the target address (the address jumped to if the branch is taken). This gives a 1-cycle penalty for a taken branch.

We can use a branch target buffer (a cache of target addresses) to overcome this. It's indexed by the PC when instructions are fetched. If there's a cache hit and the instruction is predicted as taken, we can fetch the target immediately.

# Instruction-level Parallelism

* Deeper pipeline
    * make the pipeline longer (more stages)
        * break up the longest stage
        * less work per stage -> shorter clock cycle

* multi-issue
    * replicate pipeline stages to give multiple pipelines.

## Multiple Issue

* two types:
    * static
    * dynamic

Compiler does most of the work in static multiple issue. Detects and avoids hazards by packaging issue slots in different ways.

In dynamic multi-issue, the CPU does more of the work. Resolves hazards using techniques we've seen at runtime.

## Speculation

* another form of prediction
* used so subsequent instructions can be started quickly

### Compiler/Hardware Speculation

* compiler speculation known as static speculation
* hardware speculation known as dynamic speculation

### Speculation and Exceptions

In static speculation, we can add ISA support for deferring exceptions to a later stage. (Is this a real exception or a false one caused by the re-ordering of instructions?).

In dynamic speculation, we buffer the exception until instruction completion to determine if it is real. If the exception still exists at a later stage, it's a real exception.

### Static Multiple Issue

* compiler needs info about pipeline.

#### Scheduling Static Multiple Issue

Compiler must remove some/all hazards while reordering instructions into issue packets with no dependencies within a packet.

## Example: MIPS with Static Dual Issue

* two-issue packets (each packet has two instructions)
* empty things padded with `nop`s

* have to duplicate the hardware
* new ALU is not used for normal arithmetic operations, and so is simpler (is still needed for load word instructions)

### Hazards in Dual-Issue MIPS

* load-use hazard
    * include a nop to stall

### Scheduling Example

* it looks like the multi-issue code will put the result in the wrong array position to me, but he insists that it's right
* performance is poor, so we use loop unrolling (see below)

# Loop Unrolling

* replicates loop body to achieve more parallelism
    * does it also predict decrements?
* have to use different registers for each replication, to avoid different replications using the same register (looks like a dependency to the compiler even though it isn't)

# Dynamic Multiple Issue

## Dynamic Pipeline Scheduling

* allow out-of-order execution but writeback has to be in order (to give correct result)

## Dynamically Scheduled CPU

## Register Renaming in Dynamic Scheduling
