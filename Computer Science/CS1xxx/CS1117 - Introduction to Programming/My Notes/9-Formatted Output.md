# Formatted Output

---

The % operator is used for formatting output for display on the screen:

	print('The value of n was %i' % (n))
	
You use `%i` for displaying an integer, `%s` for a string, and `%f` for a float.

With a string or integer, you can specify how much space to put around the item:

	print('%15s' % ('Chelsea'))
	
* This code will print Chelsea preceeded by 8 spaces, for a total length of 15 characters.
* You can use negative values to align it left instead of right, e.g.

	`print('%-15s' % (Chelsea))`
	
With floats you can specify the precision:

	print('%.3f' % (3.141592654)) => 3.142
	
---

###### Handouts & Assignments

* Handout 14 - Formatted Output

