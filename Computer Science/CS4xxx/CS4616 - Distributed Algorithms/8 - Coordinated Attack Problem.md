## Losing Messages

Distributed consensus with link failures.

### Battlefield Interpretation

Co-ordinated attack problem.

Intuition is that it isn’t possible. This is the case if you require too much.

There will be a small chance that we will get the wrong result (mixed 1s and 0s instead of all one or the other).

### Impossibility Result

- imposed conditions

### Drawing Messages

Instead of drawing an edge for the communication channel, we draw the communication pattern.

Time/rounds on the vertical axis, each process A is connected to one B in the previous round if A received information from B.

Every process is also connected to itself, to signify that it keeps whatever information it already had.

We usually don’t distinguish between a message that wasn’t sent and a message that was sent but not received.

# Information Level, Good Communication Pattern, etc.
