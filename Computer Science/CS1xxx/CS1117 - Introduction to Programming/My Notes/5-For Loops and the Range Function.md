# The 'for' Statement & The 'range' Function

---

### The 'for' Statement

The `for` statement is a type of loop, allowing you to execute the same code a bunch of times:

	for item in 'abcde':
		print(item)
		linenum = linenum + 1
		
This code sets item to 'a', prints it, increases linenum by 1, then sets item to 'b' and prints that, and increases linenum by 1 again, and so on until it's done all the letters in 'abcde'.

* `linenum = linenum + 1` can be abbreviated as `linenum += 1`
* This works for the other arithmetic operators as well.

### The 'range' Function

If n is an int which is greater than or equal to 0, range(n) produces the sequence `0, 1, 2, … n-1`.

Example:

	range(5)	=> 	[0, 1, 2, 3, 4]

It can also be called with two parameters to specify an alternate start-point:

	range(5, 10) => [5, 6, 7, 8, 9]

---

###### Handouts & Assignments

* Handout 4 - The 'for' Statement
* Handout 5 - The 'range' Statement
* Assignment 3 - The 'for' Statement
* Assignment 4 - The 'range' Statement