# Instruction Set Architecture: The Language of the Computer

The instruction set is the repertoire of instructions of a computer.

Different computers have different instruction sets, but there are many aspects in common.

Early computers had very simple instruction sets. Simplified implementation.

Many modern computers also have simple instruction sets, though expanded.

## MIPS Instruction Set

Stanford MIPS commercialised by MIPS Technologies (www.mips.com).

This has a large share of embedded core market.

Typical of many modern ISAs:
  * Intel x86
  * ARMv7
  * ARMv8

### Arithmetic Operations

Add and subtract each have three operands:

  * two sources
  * one destination

    add a, b, c   # a gets b + c

* All arithmetic operations have this form.

* Design Principle 1: Simplicity favours regularity
    * Regularity makes implementation simpler
    * Simplicity enables higher performance at lower cost
    * Separation of source and destination is the simplicity (?)

C code:

```C
f = (g + h) - (i + j);
```

Compiled MIPS code:

```MIPS
add t0, g, h    # temp t0 = g + h
add t1, i, j    # temp t1 = i + j
sub f, t0, t1   # f = t0 - t1
```

### Register Operands

Arithmetic instructions use register operands/

MIPS has 32 32-bit registers (32 x 32-bit register file.)

* Each register can store up to 32 bits.
* They're numbered from 0 to 31.
* 32-bit data is called a "word".

Assembler names:

* $t0, $t1, … $t9
    * temporary variables
* $s0, $s1 … $s9
    * saved variables

Design Principle 2: Smaller is faster. If we have more registers, the clock time has to increase. If we keep the number of registers low, we can have a faster clock time, but we need to spend more time swapping things. It's a compromise.

MIPS code:

    add $t0, $s1, $s2
    add $t1, $s3, $s4
    sub $s0, $t0, $t1

### Memory Operands

Main memory is used for composite data (arrays, structures, dynamic data).

To apply arithmetic operations, we need to load values from memory into registers, and then store the result from registers into memory.

Memory is byte addressed (each address identifies an 8-bit byte).

Words are aligned in memory (address must be a multiple of 4).

MIPS is big-endian:

* Most significant byte is at the least address of a word
* Opposite of little-endian

#### Example

C code:

    g = h + A[8];

Compiled MIPS code:

    * we have the base address of A in $s3, g in $s1, and h in $s2
    * The index of 8 requires an offset from the base address of the array of 32 (4 bytes per word – 4 * 8 = 32)

    lw $t0, 32($s0)

C code:

    A[12] = h + A[8];

Compiled MIPS code:

    lw $t0, 32(£s3)     # load word
    add $t0, $s2, $t0
    sw $t0, 48($s3)     # save word

### Register vs. Memory

* Registers are faster to access than memory
* Operating on memory data requires loads and stores
    * more instructions to be executed
* Compilers must use register for variables as much as possible
    * only spill to memory for less frequently used variables
    * Register optimisation is important

### Immediate Operands

* Constant data specified in an instruction  
    `addi $s3, $s3, 4`
* The add-immediate command can add a value to a stored register and stored the value in the same register
* To do negative numbers, use `addi` with a negative constant:  
    `addi $s2, $s1, -4`

Design Principle 3: Make the common case fast

    * Small constants are common
    * Immediate operand avoids a load instruction

### The Constant Zero

MIPS register 0 ($zero) is the constant 0. It can't be overwitten.

It's useful for common operations, e.g. moving between registers:

    add $t2, $s1, $zero

### Unsigned Binary Integers

Range of an n-bit unsigned integer is 0 – 2^n - 1

### 2's Complement Signed Integers

Given an n-bit number:

    x = -x_(n-1)2^(n-1) + […]

* If the most significant digit is a 1, it's a negative number.
* There's one more negative number than there are positive numbers.
* To negate a 2's complement number, you invert all binary digits, and then add one to it.

### Signed Extension

Representing a number using more bits – putting an 8-bit number in 16-bit memory, for example.

* Replicate the sign bit to the left.
    * For unsigned values, extend with 0s.

### Representing Instructions

Instructions are encoded in binary (machine code).

MIPS instructions are encoded as 32-bit instruction words. This provides the ability to map registers into numbers.

    * This layout is called instruction format.

### Register Numbers

* `$t0` to `$t7` are mapped to register numbers 8-15
* `$t8` to `$t9` are mapped to register numbers 24-25
[…]

### MIPS R-Format Instructions

This is the format for register-format MIPS instruction. These all have 3 operands.

* op: 6 bits
    * operation code
* rs: 5 bits
    * register source [check]
* rt: 5 bits
    * [check]
* rd: 5 bits
    * destination register
* shamt: 5 bits
    * shift amount
* funct: 6 bits
    * function e.g. add

### MIPS I-Format Instructions

* op: 6 bits
* rs: 5 bits
* rt: 5 bits
    * destination or source register number
* constant or address: 16 bits
    * offset added to base address in rs

### Memory: Stored-program Concept

Everything is in memory, just in different locations (source code, compiler, machine code, data).

Two key principles:

* Instructions represented in binary, just like data
* Instructions and data stored in memory

Programs can operate on programs, e.g. compilers, linkers.

Binary compatibility allows compiled programs to work on different computers – standardised ISAs.

### Logical Operations

Instructions for bitwise manipulation.

* `sll` - shift left
* `srl` - shift right
* `and`, `andi` - bitwise AND
[…]

Shifting left and filling with 0s is multiplying by powers of 2.

Shifting right and filling with 0s is dividing by powers of 2.

#### AND Operations

These are useful to mask bits in a word – you can select some bits, clear others to 0.

    and $t0, $t1, $t2

#### OR Operations

Useful to include bits in a word – set some bits to 1 while leaving others unchanged.

    or $t0, $t1, $t2

#### NOT Operations

Useful to invert bits in a word. In MIPS, the NOR operation is used by NORing with zero.

    nor $t0, $t1, $zero

### Conditional Operations

Branch to a labeled instruction if a condition is true, otherwise continue sequentially.

MIPS supports two:

1. `beq rs, rt, L1`
    * If rs == rt branch to instruction labelled L1
2. `bne rs, rt, L1`
    * If rs != rt branch to instruction labeled L1

There's also an unconditional jump:

    j L1

MIPS assembler handles label addresses.

### Basic Blocks

A basic block is a sequence of instructions with:

* no embedded branches (except at the end)
* no branch targets (except at the beginning)

A compiler identifies basic blocks for optimisation.

An advanced compiler can accelerate execution of basic blocks.

### More Conditional Operators

Set a result to 1 if a condition is true, otherwise set the result to 0.

* Set less than:

    slt rd, rs, rt

* Set less than (immediate):

    slti rt, rs, constant

These are used with `beq` and `bne`:

    slt $t0, $s1, $s2
    bne $t0, $zero, L

### Signed vs. Unsigned

`slt` and `slti` are for signed comparisons.

Unsigned equivalents are `sltu` and `sltui`.

Important distinction because negative signed numbers will be read as large unsigned numbers by unsigned comparisons and vice-versa.

### Procedure Calling

Procedures allow programmers to concentrate on a portion of a task at a time. Each includes a parameter to interface with the rest of the program. Equivalent to functions.

Steps:

1. Place parameters in special registers
2. Transfer control to the procedure
3. Acquire storage for the procedure
4. Perform procedure's operations
5. Place result in register for caller
6. Return to place of call

#### Register Usage

* `$a0` to `$a3` are argument registers for passing parameters.
    * numbers 4-7
* `$v0` and `$v1` are registers for result values
    * numbers 2 and 3
* temp
* saved
* `$gp`
    * global pointer for static data (number 28)
* stack pointer `$sp`
* frame pointer `$fp`
* return address `$ra`

#### Procedure Call Instructions

Special instruction for procedure call: "jump and link"
```mips
    jal ProcedureLabel
```
* Address of following instruction put in `$ra`.

## Procedure Call Instructions

### Jump and Link

```mips
jal ProcedureLabel
```

* Address of following instruction put in $ra
* Jumps to target address

```mips
jr $ra
```
* Unconditional jump
* Copies $ra to program counter
* Can also be used for computed jumps (e.g. for case/switch statements)

## Leaf Procedure and Stack Memory

A leaf procedure is a procedure that does not call another procedure.

You can use `push` to add an element to the stack and subtract from the stack pointer.

### Example

```C
int leaf_example(int g, h, i, j)
{
    int f;
    f = (g + h) - (i + j);
    return f;
}
```

```mips
addi    $sp,    $sp,    -4
sw      $0,     0($sp)
add     $t0,    $a0,    $a1
[…]
```

* Note we save the value on `$s0` in the stack when the function is called, to preserve the value in this memory, and load it again
* We use `-4` for the incrementation of the stack pointer because there are 4 bytes in a word, and we are storing a word for one register

## Non-Leaf Procedures

These are procedures that call other procedures.

For a nested call, the caller needs to save the following on the stack:

* Its return address
* Any arguments and temporaries needed after the call

These are restored from the stack after the call

### Example

[…]

* We have to save the return address when the procedure is called, and any arguments

## Local Data on the Stack

* Frame pointer points to the first word of a procedure frame

[…]

## Memory Layout

* Dynamic data is the heap
    * Arrays, other data that can grow are stored here
* Static data is pointed to by `$gp`, with +/- offests
* Text is the program code
[…]

## Character Data

* Byte-encoded character sets
    * ASCII: 128 characters (95 graphic, 33 control)
    * Latin-1: 256 characters (ASCII + more graphic characters)
* Unicode: 32-bit character set
    * Used in Java, C++ wide characters, …
    * Most of the world's alphabets, plus symbols
    * UTF-8, UTF-16: variable-length encodings

### String Copy Example

Copies a null-terminated string to a new string.

```C
void strcpy (char x[], char y[])
{
    int i;
    i = 0;
    while ((x[i] = y[i]) != '\0')
        i += 1;
}
```

[…]

* Have to store `$s0`
* Use the `lbu` (load byte unsigned) command to copy each character (each character in C is a byte).
* Use `addi $sp, $sp, 4` to pop 1 item from the stack
* `sb` is save byte (I'm guessing)

## 32-bit Constants

Most constants are small – 16-bit immediate is sufficient.

For 32-bit constants:

```MIPS
lui $s0, 61
```

* Use this command with the value represented by the left 16 bits
* This then clears the right 16 bits of $s0 to 0

Then you do:

```MIPS
ori $s0, $s0, 2304
```

* This copies in the right digits (which in this number have the value 2304).

## Branch Addressing

[…]

PC-relative addressing is used for 32-bit addresses in a 16-bit space.

## MIPS Addressing Mode Summary

1. Immediate Addressing
2. Register Addressing
3. Base addressing
4. PC-relative addressing
5. Pseudodirect addressing

# Parallel Execution Synchronisation

Two processors sharing an area of memory

* P1 writes, then P2 reads
* Data race if P1 and P2 don't synchronise (P1 might re-write a value before P2 has a chance to read it)
    * result depends on order of accesses

Hardware support is required.

* Atomic read

[…]

## Synchronisation in MIPS

* load linked: `ll rt, offset(rs)`
    * Loads a particular area and blocks other people from writing to it
* store conditional: `sc rt, offset(rs)`
    * this succeeds if the location isn't changed since the `ll`
        * returns 1 in rt
    * fails if location is changed
        * returns 0 in rt

### Example

```MIPS
try: add $t0, $zero, $s4
     ll $t1, 0($s1)
     sc $t0, 0($s1)
     beq $t0, $zero, try
     add $s4, $zero, $t1
```

## Program Translation and Startup

[…]

## Assembler Pseudoinstructions

* Most assembler instructions represent machine instructions 1-to-1
* Pseudoinstructions are ones that don't:\
    `move $t0, $t1` -> `add $t0, $zero, $t1`
    `blt $t0, $t1, L` -> `slt $at, $t0, $t1`
                         `bne $at, $zero, L`

## Producing an Object Module

* The Assembler (or compiler) translates program into machine instructions
* Provides information for building a complete program from the pieces
    * header: describes contents of object module
    * text segment: translated instructions
    * Static data segment: data allocated for the life of the program
    * relocation into: for contents that depend on absolute location of loaded program
    * symbol table: global definitions and external refs
    * debug info: for associating with source code

## Linking Object Modules

* Produces an executable image
    1. Merges segments
    2. Resolve labels (determine their addresses)
    3. Patch location-independent and external regs
* Could […]

## Dynamic Linking

Code is compiled into different blocks, and those blocks only have to be re-compiled when they're changed.

* Only link/load library procedure when it is called.
    * This requires the procedure code to be relocatable.
    * We avoid image bloat caused by static linking of all (transitively) referenced libraries.
    * This automatically picks up new library versions.

### Lazy Linkage

When a particular function or procedure is called, the links are made – it doesn't need to be linked up before execution.

The first time a particular thing is linked, there are some setup steps. Subsequent calls have to go through fewer steps and are faster.

# Starting Java Application

Java uses the Java Virtual Machine with the goal of being able to run on any system.

* Code is first compiled to java bytecode
    * This is a very quick compilation
* The "Just In Time" compiler compiles bytecodes of "hot" methods into native code for host machine
    * Methods that are used often are compiled by this compiler.
    * Ones that are used less often won't be compiled, and will be interpreted by the JVM instead.
    * compromise between execution speed and portability

Java used to be much slower than C, but is catching up in recent years.

# Bubble Sort Procedure

## C

```C
void sort(int v[], int n)
{
    int i, j;
    for (i = 0; i < n; i++) {
        for (j = i - 1; j >= 0 && v[j] > v[j + 1]; j -= 1) {
            swap(v, j);
        }
    }
}
```

* To convert to MIPS, we put v in `$a0`, k in `$a1`, […]

## MIPS

```MIPS
move $s2, $a0
move $s3, $a1

move $s0, $zero
for1tst:    slt $t0, $s0, $s3
            beq $t0, $zero, exit1
[…]
```

* don't forget array indices from C have to be multiplied by 4 in MIPS (each index in C corresponds to a word, but memory is byte-addressable in MIPS – 4 bytes in a word of 32 bits, so we multiply by four).
    * These are added to the base address for the array
* Remember you have to manage the stack pointer yourself – decrementing by 4 for each value you store.

# ARMv7 and MIPS Similarities

* ARMv7 is the most popular embedded core

The two are similar in many ways:

* both announced in 1985
* instruction size: 32 bits
[…]

Differences:

* ARMv7 has 9 data addressing modes
* MIPS only has 3
    * register
    * constant immediate
    * register and displacement

* ARMv7 only have 15 32-bit registers
* MIPS has 31 32-bit registers

## Compare and Branch

MIPS uses the contents of registers to evaluate conditional branches.

ARMv7 uses condition codes for the result of an arithmetic/logical instruction:

* negative, zero, carry, overflow
* compare instructions to set condition codes without keeping the result
* this is what we saw in CS1110/1111 with Samphire

Each instruction can be conditional – you can jump based on any instruction, rather than having to use a specific comparison one.

* This can avoid the necessity of branching because of a single instruction
    * i.e. you only need your instruction and your jump command
    * not jump, check, branch, etc.

## ARMv8

The new version is 64-bit, and ARM redesigned now.

* ARMv8 resembles MIPS:
    * No conditional execution field (flags)
    * Immediate field is 12-bit constant
    * PC is no longer a GPR
    * GPR set expanded to 32
    * Addressing modes work for all word sizes
    * Divide instruction
    * Branch if equal/branch if not equal instructions

These changes were made because (I think) it's faster now and they can afford to use branch if equal instructions, which are clearer. (Not certain of that.) Possibly just the revisions made it faster.

# Intel x86 ISA Evolution

* Evolution with backward compatibility
    * 8080 (1974): 8-bit microprocessor
        * accumulator plus 3 index-register pairs
    * 8086 (1978): 16-bit extension to 8080
        * CISC
    * 8087 (1980): floating-point coprocessor
        * adds FP instructions and register stack
    * 80286 (1982): 24-bit addresses
        * segmented memory mapping and protection
    * 80386 (1985): 32-bit extension (now IA-32)
        * additional addressing modes and operations
        * paged memory mapping as well as segments

To guarantee backward compatibility, the instruction set only adds instructions – existing ones are never changed or removed. There are now about 900 instructions.

## Basic x86 Addressing Modes

Two operands per instruction.

* source/destination operand
* second source operand

The first can be a register or memory. The second can be either of those or an immediate value.

* register -> register
* register -> immediate
* register -> memory
* memory -> register
* memory -> immediate

Memory addressing modes:

* address in register
* register + displacement
* […]

## x86 Instruction Encoding

Variable length encoding:

* postfix bytes specify addressing mode
* prefix bytes modify operations

## Comparison to MIPS and ARMv7

x86 computers are more difficult to build because of the complex instructions.

Market size advantage:

* frequently used components of x86 are not too difficult to implement
* Intel and AMD have experience in this area

In the post-pc era, x86 has not been competitive in personal mobile devices (it's mostly ARM and MIPS).

# Fallacies

* Powerful instructions -> higher performance
    * fewer instructions are required
    * but complex instructions are hard to implement
        * may slow down all instructions, including simple ones
    * compilers are good at making fast code from simple instructions (in complex instruction sets)
* Use assembly code for high performance
    * but modern compilers are better at dealing with modern processors
        * compilers know more than you do
    * and more lines of code -> more errors and less productivity

# Pitfall

Sequential words are not at sequential addresses

* increment by 4, not by 1
* MIPS uses a 32-bit word that's equivalent to 4 bytes

# Exceptions and Interrupts

Different ISAs use the terms differently. In general they're "unexpected" events that require a change in flow of control.

In MIPS:

* exceptions arise within the CPU
    * e.g. undefined opcode
    * overflow
    * syscall
* interrupts are from an external I/O controller

It's difficult to deal with these without sacrificing performance.

## Handling Exceptions

The current MIPS implementation generates two types of exceptions:

1. undefined instruction
2. arithmetic overflow

Handling steps:

1. Save address of offending (or interrupted) instruction in the Exception Program Counter (EPC)
2. Save an indication of the problem in the Cause register
3. Transfer execution to the operating system
    * this takes appropriate action by using the EPC to determine where to restart program execution

## Vectored Interrupts

This is an alternative to handling exceptions.

The handler address is determined by the cause – each instruction is given an address (which specifies how to handle it)?.

When the exception occurs, that address is copied to the EPC and pushed to the OS.

## Handler Actions

1. Read cause, transfer to relevant handler
2. Determine action required
3. If restartable
    * take corrective action
    * use EPC to return to program
4. Otherwise
    * terminate program
    * report error using EPC, cause

## Exceptions in a Pipeline

These are seen as another form of control hazard (branch hazard).

* Need to complete previous instructions before transferring control to the handler.

Handling of these is similar to a mispredicted branch.

## Exception Properties

* Restartable or not
    * pipeline can flush the instruction, let the handler execute, and return to the instruction if it is
        * the instruction is refetched and executed from scratch
* Address saved in EPC register
    * identifies causing instruction
    * PC + 4 is actually what's saved (the handler subtracts 4 again)

## Multiple Exceptions

* out-of-order completions: second instruction could finish before the first (in a pipeline)

### Imprecise Exception Handling

* Let the OS work out which instruction had exceptions, rather than working it out in hardware
