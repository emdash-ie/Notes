# Exceptions

---

Exceptions are errors that the Python interpreter encounters, for example when you try to open a file for reading that doesn't exist.

You can write programs to do specific things when these errors are encountered by using `try` and `except`.

## Try and Except

	try:
		open(filename, 'r')
		# Do stuff with the file
		
	except FileNotFoundError:
		print('Error: file not found')
		
If a FileNotFoundError occurs while executing the code in the `try` block, the code in the `except FileNotFoundError` block will be run instead of the rest of the try block.

## Else

It can be neater to keep only the stuff likely to throw the error in the try block, and you can do that with an `else` block:

	try:
		open(filename, 'r')
	except FileNotFoundError:
		print('Error: file not found')
	else:
		# Do stuff with the file
		
The else block will be run only if no errors were encountered during the try block.

---

###### Handouts & Assignments

* Handout 16 - Exceptions
* Assignment 13 - Reading and Writing Files & Exceptions