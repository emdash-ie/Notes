# Assignment 2

---

One node can represent a whole tree, since each node has children, and those children have children, and so on until you run out of nodes.

All the methods are recursive, so you check this node, and then figure out what function call to make involving the children. E.g. for searching, you figure out whether the current node is the right node, and if it isn't, you either call the search method of the left child or the search method of the right child.

Also, if your method returns a value, every possible path through that method must return a value – if you're calling the function recursively, you need to return the result of it instead of just calling it.

## String Method

There's no need for brackets or symbols in your `__string__()` method, you just need to output word by word in an in-order traversal. This will give the words in alphabetical order, e.g. `"bracket compass needle"`

## Word BST Gibberish

There's a problem with the way his `wordbst` function splits up the words in some of the text files (especially `lincoln.txt` because it uses double-dashes as em-dash style punctuation).

As long as you use his function unmodified, you will get the same results as he does, and the problem won't matter.