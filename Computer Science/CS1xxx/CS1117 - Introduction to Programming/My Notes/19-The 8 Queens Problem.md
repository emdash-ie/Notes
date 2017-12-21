# 8 Queens Problem

---

## Background

A chessboard is an 8 x 8 board of squares.

A queen (in chess) can move vertically, horizontally, or diagonally, any number of squares.

If there's another piece on a square the queen can move to, the queen can capture that piece by moving to that square.

## Problem

Can you fit 8 queens on the board such that none can capture another?

How might you systematically try to come up with an arrangement of 8 queens on a chessboard?

## Solution

Take a 4 x 4 board as an example, and attempt that.

### Representing the Board

Since you can only have one queen on each row, you can use a single list with the positions of each queen in each row to represent the board:

	[1, 3, 0, 2]

The above list represents a 4 x 4 board with a queens in positions (0, 1), (1, 3), (2, 0), and (3, 2), where each pair is (row, column).

Since we'll know the size of the board at all times in the function, we'll just use the list to track occupied rows, so that this list:

	[1, 3]
	
Represents a board (of any size) with a queen at position 1 in the first row and another at position 2 in the second row.

### Checking a New Position

With each new position, we need to make sure it's not under attack from any placed queen. We must check vertically and diagonally. (We only ever place one queen on a row, so we don't need to worry about horizontal threats.)

#### Vertically

Walk through the list of existing queens and check that the suggested position is not already in the list. (If you're trying to put a queen in position 0 in the current row, make sure there's no 0 in the list.)

#### Diagonally

We need to check squares along two diagonals, where the co-ordinates are worked out for the first by decreasing the row and decreasing the column, and for the second by decreasing the row but increasing the column, in steps of 1 each time.

### Solution Code (for any size of board)

See handout #26.

---

##### Handouts & Assignments

* Handout 26
* Assignment 20