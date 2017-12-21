# Operations on Integers

## Addition

* overflow if result out of range (result goes higher than the highest positive number or lower than the lowest negative number)
    * if adding two positive operands and the result sign bit is 1
    * if adding two negative numbers and the result sign bit is 0
* no overflow if adding a positive and a negative operand
    * adding a positive number to a negative number will always raise it – take it away from the lowest negative number
    * adding a negative number to a positive number will always lower it – take it away from the highest positive number

## Subtraction

Add negation of second operand.

* overflow if result out of range
    * subtracting positive from negative and result sign bit is 0
        * equivalent to adding two negative numbers
    * subtracting negative from positive and result sign bit is 1
        * equivalent to adding two positive numbers
* none if subtracting two operands of same sign

## Dealing with Overflow

Some languages (e.g. C, Java) ignore overflow.

* Use MIPS `addu`, `addui`, `subu` instructions
    * 'u' stands for unsigned

Other languages (e.g. Ada, Fortran) require raising an exception.

* Use MIPS `add`, `addi`, `sub` instructions
* on overflow, invoke exception handler
    * Save PC in exception program counter (EPC) register
    * Jump to predefined handler address
    * `mfc0` (move from coprocessor reg) instruction can retrieve EPC value, to return after corrective action

## Multiplication

* You can multiply as if in decimal and just read the answer as binary.

* Product is allocated length equal to the sum of operand length.

[…]

#### Faster Multiplier

* Use multiple adders
    * cost/performance tradeoff
* Can be pipelined
    * several multiplications performed in parallel

#### MIPS Multiplication

Two 32-bit registers for product:

* HI: most-significant 32 bits
* LO: least-significant 32 bits

Instructions:

* `mult rs, rt` or `multu rs, rt`
    * 64-bit product in HI/LO
* `mfhi rd` / `mflo rd`
    * Move from HI/LO to rd
    * Can test HI value to see if product overflows 32 bits

### Division

#### Faster Division

* Can't use parallel hardware as in multiplier.
    * Subtraction is conditional on the sign of the remainder
* Faster dividers generate multiple quotient bits pre step
    * still require multiple steps
    * solution current uses future prediction and correction strategy

#### MIPS Division

* Use HI/LO registers for result
    * HI: 32-bit remainder
    * LO: 32-bit quotient

* Instructions
    * `div rs, rt` / `divu rs, rt`
    * No overflow or divide-by-0 checking
        * software must perform checks if required
    * Use `mfhi` and `mflo` to access result

## Floating-point Real Numbers

Representation for non-integral numbers (including very small and very large numbers).

Like scientific notation.

General form: `±1.xxxxxx_2 * 2^yyyyy^`

* Binary points (rather than decimal points)

There are `float` and `double` in C. This will be explained later.

### Floating-point Standard

Defined by IEEE in Std 745-1985 (in 1985).

Developed in response to divergence of representations – portability issues for scientific code.

Now almost universally adopted.

Two representation:

* Single precision (32-bit)
* Double precision (64-bit)

```
x = (-1)^S^ * (1 + Fraction) * 2^(Exponent - Bias)^
```

* S is the sign bit (0 for non-negative, 1 for negative)
* Significand is `1 + Fraction`
* Exponent: excess representation: actual exponent + bias
    * ensures exponent is unsigned
    * single: bias = 127
    * double: bias = 1203

The bias was brought in to help sorting (?) as e.g. -1 contains mostly 1s and so looks very large, while +1 contains mostly 0s and looks very small [check this].

#### Floating-point Range

Exponents `11111111` and `00000000` are reserved.

So the actual smallest value is 1 - 127, which gives -126.

So the smallest value is ±1.0 * 2^-126^ = [check].

The largest value is ±2.0 * 2^127^ = 3.4 * 10^38^ in decimal.

#### Floating-point Example

Represent -0.75:

* Subtract powers of 2 (from +0.75 and negate the answer) - each one subtracted corresponds to a 1 in the correct column of the binary result
* Alternatively, multiply the remainder by 2 and keep subtracting the same power of 2 (2^-1, which is 0.5).
    * You have to track which column you're on.
* This is equivalent to long division by 2.

1. Subtract 0.5 from 0.75 – this corresponds to 0.1 in binary.
    * The remainder is 0.25.
2. Subtract 0.25 from the remainder – this corresponds to 0.01 in binary.
    * The remainder is 0.
3. Since the remainder is 0, we're done. The answer is 0.11 in base 2.

Alternative:

1. Subtract 0.5 from 0.75 – this corresponds to 0.1 in binary.
    * The remainder is 0.25.
2. Multiply the remainder by 2 – this gives 0.5.
3. Subtract 0.5 from the remainder – because of our multiplying by 2 this corresponds to 0.01 in binary.
    * The remainder is 0.
4. Since the remainder is 0, we're done. The answer is 0.11 in base 2.

### Floating-point Addition

* Convert the values to binary
* Align the decimal points (remember each shift corresponds to multiplying or dividing by 2)
* Add the numbers
* Keep the power (which should now be the same)
* Normalise the result and check for over-/under-flow
* Round and renormalise is necessary

#### Floating-point Adder Hardware

* Much more complicated than an integer adder.
* Doing a calculation in one cycle isn't possible.
    * If you slow down the clock to fit FP operations, you'll slow all instructions down
* Instead, calculations take multiple clock steps
    * They can also be pipelined

### Floating-point Multiplication

In decimal:

1. Add exponents
2. Multiply significands
3. Normalise result
4. Round and renormalise if necessary
5. Determine sign of result from signs of operands

In binary:

1. Add exponents (unbias them first)
2. Multiply significands
3. Normalise result and check for over-/under-flow
4. Round and renormalise if necessary
5. Determine sign of result

#### FP Multiplicator Hardware

* Similar in complexity to FP adder.
    * Uses a multiplier for significands instead of an adder
* FP arithmetic hardware usually does:
    * additions, subtraction, multiplication, division, reciprocal, square-root
    * floating point to integer conversion (and back)
* Operations usually take several cycles
    * Can be pipelined

### Floating-point Instructions in MIPS

There are separate floating-point registers:

* 32 single-precision registers: $f0 … $f31
* Use two neighbouring ones together for double-precision

Floating point operations only work with floating-point registers.

There are also separate load and store instructions [check these].

Single-precision arithmetic:

* `add.s`, `sub.s`, `mul.s`, `div.s`

E.g. `add.s $f0, $f1, $f6`

Double-precision arithmetic:

* `add.d`, `sub.d`, `mul.d`, `div.d`

E.g. `mul.d $f4, $f4, $f6`

Single and double-percision comparison:

* `c.eq.s`, `c.lt.s`, `c.le.s`
* `c.eq.d`, […]
* These set or clear a floating-point condition bit

Brach on floating-point condition:

* `bc1t`, `bc1f`
    * branch if the condition bit is true, branch if the condition bit is false

[Note: need to look up `lwc1` and `lwc2`.]

### Accurate Arithmetic

There are extra bits for precision (guard, round, and sticky).

These allow you to choose rounding modes, which allows you to control what's happening in the intermediate stages.

Not all FP units implement all options, though. Most programming languages and FP libraries just use the defaults.

Floating-points have limited size (precision). These limits must be remembered and programs must be written accordingly.

# Subword Parallelism

* Designed to address multimedia applications
* Graphics and audio applications can take advantage of performing simultaneous operations on short vectors using parallelism.

E.g. 128-bit adder can simultaneously perform:

* sixteen 8-bit adds
* eight 16-bit adds
* four 32-bit adds

This is also called data-level parallelism, vector parallelism, or SIMD (single instruction, multiple data).

## x86 FP Architecture

* Based on 8087 FP coprocessor
    * Used a push-down stack
* Intel provided 128-bit extension register for FP operations
    * four single-precision numbers (since a single-precision operation uses 32 bits)
    * two double-precision numbers
* In 2011 Intel doubled the width to 256 bits
    * Single operation can support 8 single-precision operations

## Pitfalls

* Left shift multiplies by 2. However, right shift only divides by 2 for unsigned integers
* For signed integers, an arithmetic right shift replicates the sign bit.
    * Doesn't give the right division result

## Associativity Pitfall

Parallel programs may interleave operations in unexpected orders, so associativity may not hold.

* This is a problem where you're combining large numbers and small numbers

## Floating Point Accuracy

* Intel Pentium FDIV bug in 1994
* Even small inaccuracies can be a big problem
