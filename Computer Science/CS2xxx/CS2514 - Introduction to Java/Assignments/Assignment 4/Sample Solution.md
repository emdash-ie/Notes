# Info

* representing level with an attribute is a waste of space

    * this can be computed

    * use a recursive method which increments an argument instead

* same for indentation

    * also better to print than append, as the append is O(n^2^)

* common mistake to represent relative level of indentation as a string literal

    * then you have multiple copies of the string - hard to maintain

    * better to have a constant class attribute

* see file `BinaryTree.java` for solution

    * the enum solution is fancy but possibly overkill, and a bit strange that the Node methods recurse back to the Traversal

    * might have been better to switch on the Node values in the Traversal enum
