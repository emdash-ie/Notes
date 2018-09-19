# Reinforcement Learning

## Delayed Rewards

- e.g. with a chess game, the reward comes at the end when you win

## Convergence

- When a state’s Q-values are improved (become better estimates), then its predecessors’ will be improved the next time they are visited, as their cumulative Q estimate is better.
- Eventually this algorithm will converge to a perfect solution, given a deterministic environment and some other assumptions.
- This algorithm is quite slow to converge though.

## Varying $\epsilon$

You can start with a high value for $\epsilon$, and then decrease it over time, which may increase convergence speed. It’s generally not necessary for this algorithm, but may be used for other ones.

## Lack of Similarity Recognition

Algorithm doesn’t generalise from one state to similar states. Neural networks are used to do that.
