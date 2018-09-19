---
title: Leader Election
---

# LCR

# HS

- Complexity: $O(nlog(n))$
- Requires bidirectional ring

## Formal Model

## Communication Complexity

The communication complexity is $O(nlogn)$.

### Phase 0

Every process sends a token in both directions, so there are at most $4n$ messages ($out_{n_{+}}$, $out_{n_{-}}$, $back_{n_{+}}$, $back_{n_{-}}$).

Note: I don’t think this is correct. Each node taken individually could send 2 messages and receive 2 messages, but only if it is bigger than both of its neighbours. In that case, it won’t reply to its neighbours. Therefore, for nodes $\{n-1, n, n+1\}$, where $n$ is the local leader, there are at most $3 + 4 + 3 = 10$ messages, not 12.

### Phase $l > 0$

Every process sends a token only if it receives both its phase $l - 1$ tokens back.

This happens if it is not defeated by another process within distance 2^l-1^ in either direction. Within any group of $2^{l-1} + 1$, at most one goes on to initiate tokens at phase $l$.

So at most $\lfloor\frac{n}{2^{l-1}+ 1}\rfloor$ processes initiate tokens at phase l.

So the total number of messages sent in phase $l$ is at most $4(2^l \times \lfloor\frac{n}{2^{l-1}+1}\rfloor) \leq 8n$.

The total number of phases is at most $1 + \lceil logn \rceil$.

The total number of messages is bounded by $8n(1 + \lceil logn \rceil)$ and so is $O(nlogn)$.

### Time Complexity

The time complexity is $O(n)$.

The time for each phase $l$ is $2 \times 2^l = 2^{l+1}$ – the tokens go out and come back.

The final phase takes time $n$, an incomplete phase where tokens only travel outbound.

Second=last phase is phase $l = \lceil logn \rceil - 1$ and its time complexity is at least the total time complexity of all preceding phases.

Total time complexity of all phases (except for the last one): $2 \times 2^{\lceil logn \rceil}$.

Hence the total time is at most $3n$ if $n$ is a power of 2, and $5n$ otherwise. Therefore, the time complexity is $O(n)$.
