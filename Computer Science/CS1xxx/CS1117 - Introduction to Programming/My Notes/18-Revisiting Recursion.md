# Revisiting Recursion

---

## Variable Scope

You can define variables outside of functions that can then be used by the functions:

	def F():
		print(n)

	n = 5
	F()			--> 5
	
However, if you have n redefined inside the function, the local variable takes precedence over the global variable inside the function.

Python also doesn't allow the following:

	def F():
		print(n)
		n = 7
		print(n)
		
	n = 5
	F()
	
This is because we're using print(n) the first time to refer to global n, and the second time to refer to local n, which is weird.