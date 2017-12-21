# Summary for CS2503

---

## `man` and `info`

`man` is used to view the manual – type `man <cmd>` or `info <cmd>` to get info on a command.

* `man -k <keyword>` to search the summaries
* `man -K <keyword>` to search the full text

## Pipes

For passing the output of a command into the input of another. They work from left to right:

	cat myfile | grep key | sort | lpr
	
