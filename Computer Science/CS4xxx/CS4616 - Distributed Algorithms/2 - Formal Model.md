# Notation

Use a graph – nodes are the processes, and directed edges are channels along which messages can be sent.

in-nbrs~i~
:   Processes from which there is an edge to i

out-nbrs~i~
:   Processes to which there is an edge from i

distance(i, j)
:   Shortest path between i and j (or infinity)

diam
:   The maximum $distance(i, j)$ in the graph – the maximum (shortest) communication distance

# Processes, States, Transitions

Some fixed message alphabet $M$ (for the leader election it was the set of all unique IDs), with $null$ representing the absence of a message.

A process has four components:

- $states_i$
    - a (possibly infinite) set of states
- $start_i$
    - a nonempty subset of $states_i$, which are the start/initial states
- $msgs_i$
    - a message-generating function mapping $states_i \times out-nbrs_i$ to elements from $M \cup \{null\}$
- $trans_i$
    - a state-transition function mapping $states_i$ and vectors of $M \cup \{null\}$ to $states_i$

# Channels and Execution

Each channel holds at most a single message.

Execution of the system begins with the processes in arbitrary start states, and the channels empty. Then the process repeatedly performs two steps, in lock-step:

1. message-generating function applied to current state to generate messages, messages placed in channels
2. state-transition function applied to current state and incoming messages, messages in channels cleared

# Rounds

The model is deterministic – the two functions are proper functions,

# Halting, Inputs, Outputs

We can distringuish some of the states as *halting states* – no further activity can occur from these states. No messages are generated and the only transition is a self-loop.

Inputs and outputs are encoded in states. Multiple start states to cover input values. Outputs appear in output variables, which record only the first write operation.

# Executions

A state assignment is an assignment of a state to each process in the system. An execution is an infinite sequence as follows:

C~0~, M~1~, N~1~, C~1~, …

- M~1~ is the messages sent
- N~1~ is the messages received

# LCR (Leader election algorithm)
