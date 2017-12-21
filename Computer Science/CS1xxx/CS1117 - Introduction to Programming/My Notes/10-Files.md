# Files

---

## Open

We use the function `open()` to read files and write to them.

	def ReadFile(filename):		filehandle = open(filename, 'r')		for line in filehandle:			print(line)
* This function will read the lines of a file one by one by using a for loop over the file handle.The second parameter for `open()` specifies whether we're reading or writing. For reading it should be 'r', for writing it should be 'w'.
As well as looping over files as above, you can use the `.readline()` method on file handles, which will return one line:
	line = filehandle.readline()
There's also a `.readlines` method that will return all the lines of the file in a list.
## Close
You should call `.close()` on the file handle once finished with it, to free up system resources.## File Handles
The file handle is used for all interaction with the file. It remembers the location of a file on disk and how far through the file it has already gone.
## Files

Files are just sequences of characters.
The newline character (`'\n'` in Python) is detected as the point where one conceptual line ends and the next starts within the file. In the above code, for example file `'Ann\nTim\nSue\nNed\n'`, `line` is initially set to `'Ann\n'`, then to `'Tim\n'`, and so on.
---
###### Handouts & Assignments
* Handout 15 - Reading and Writing Files
* Assignment 12 - Reading Files
* Assignment 13 - Reading and Writing Files & Exceptions