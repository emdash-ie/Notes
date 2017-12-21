# Assignment 4

---

* Put your name and student number in a comment at the top.
* We can assume the user will correctly press a digit followed by an operator followed by a digit followed by `=` every time.
* The label needs to be updated after each button press.
* Don't get caught up in the mathematics – it's mainly about setting up the user interface and callbacks

## `lambda`

To call a callback function and pass parameters to it, we use lambda:

	but = Button(root, text="press me!", command=(lambda: callback1(2, 3)))
	
This allows us to have several buttons calling the same function but passing different arguments to it.

## `grid`

We use `.grid()` instead of `.pack()` to get our grid layout for the calculator:

	but = Button(root, text="press me!", command=(lambda: callback1(2, 3)))
	but.grid(row=2, column=1)
	
## Stub

We'll be given a stub file with the basic outline for the class, which we will complete.

This stub is on Moodle.