# Sample Solution for Summer 2013

---

## Question 1

### (a)

The minimum possible number of input variables is 6, as any smaller number of input variables wouldn't have enough rows in the truth table (5 would have 2^5 = 32) to give terms to the CPOS, where each term corresponds to a row from the truth table.

### (b)

## Question 4

### (a)

(see accompanying image in Drive – I need to figure out how to put pictures in these files)

### (b)

z \ x | 0 | 1
------|---|---
 **0**| 0 | 1
 **1**| 2 | 3
 **2**| 0 | 1
 **3**| 2 | 3
 
### (c)

No, there is no such input sequence. If you start at state 3 (the only state which outputs 1), none of the states you can go to can return you to state 3 on the following step.

### (d)

Yes. This sequence of input values will:

	011101110111…
	
Note for the first state the output is undefined, so the output value sequence here will actually be this:

	-10011001100…
	
If we want to have an extra 1 at the start, we just need to add an extra 0 or 1 to the start of our input sequence.