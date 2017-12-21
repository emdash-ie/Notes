# Sample Solution for Summer 2010

---

## Question 4

### (a)

(See associated image in Drive – note the layout is the same as Summer 2013, because the state transitions are the same, but the outputs are different)

### (b)

z \ x | 0 | 1
------|---|---
 **0**| 0 | 1
 **1**| 2 | 3
 **2**| 0 | 1
 **3**| 2 | 3
 
### (c)

The only one I can think of is (and shifts of it):

	1100110011001100…
	
(let me know if you see others)

### (d)

These changes do not affect the output, as this is a Moore machine — the output is a function only of the state. So Y can only change when the state changes. Only the value of X at each clock tick affects the value of Y.