# Intelligence

Intelligence comes in degrees – it isn’t just that you have it or you don’t. This also applies to computers.

# Agents

An agent is anything that perceives its environment through sensors and acts upon that environment through effectors.

- Includes us and other living creatures

percepts
:   Inputs through sensors

agent functions
:   Function which decides what to do

effectors
:   Things used to act on the world, e.g. hands

## Robots

Robots are embodied agents, situated in physical environments.

## Software Agents

Software agents are situated in virtual environments.

- Used to sometimes be called softbots

## Sense, Plan, Act

Continuously:

1. Use sensors
2. Decide on next action
3. Carray out action

A.I. concerns itself with the plan phase: implementing an action function that maps from percept sequences to the actions agents can perform.

- Percept sequence i.e. potentially using past percepts

# Environments

Things on the right are roughly harder to deal with, and capability :

- Fully observable vs. partially observable
    - Does the agent know the full state of the world?
- Deterministic vs. stochastic
    - This is from the agent’s point of view, not from a god point of view
    - Deterministic: If I carry out the same action in the same circumstances, I get the same action every time.
- Single-step vs. sequential
    - Single-step: You can make a decision without thinking about subsequent decisions
    - e.g. QA robot in a factory making a decision about each cake the factory produces
- Static vs. dynamic
    - Static: While planning, the world doesn’t change
- Discrete vs. continuous
    - Discrete: Each variable can take on a value like integers (e.g. not arbitrary precision)
- Single-agent vs. multi-agent
    - How many agents

# Reactive and Deliberative Agents

Reactive: An agent that makes a decision based only on its current percept.
Deliberative: Think ahead (e.g. simulating actions in your head)

- Rough definition

# Table-driven Agent

- Reactive (no memory, won’t think ahead)

1. Walk
2. Turn(Right, 2)
3. Walk
4. Walk
5. Turn(Left, 2)
6. Turn(Left, 2)
7. Turn(Left, 2)
8. Turn(Left, 2)

- This is not autonomous
- A table-driven approach is possible when the number of states is finite.
- It is practical when the number is small
