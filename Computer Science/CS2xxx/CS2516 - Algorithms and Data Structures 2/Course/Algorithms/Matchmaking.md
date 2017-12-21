# Intro

* Given n men and n women, can we find a good heterosexual matching?

* everybody ranks every possible partner from 1 to n

    * top choice, second choice, etc.

    * no ties allowed in ranking, have to rank everyone

* A stable matching is one where no two people have an incentive to ignore the matching and run off with each other

    * never have P matched with X but prefers Y at the same time as Y matched with Q but prefers P

    * e.g. Bob matched Isobel but prefers Carol, Carol matched with Dave but prefers Bob

# Questions

* is there always a stable matching?

* can we write an algorithm guaranteed to find a stable matching, if we know there is one?

* how efficient is the algorithm?

* are all stable matchings equal in quality, or are some better than others?

* what happens if there are ties (i.e. if person X has no strict preference between P and Q)?

* what happens if a person doesn't rank all possible partners?

* what happens if we allow m-to-1 matchings instead of 1-1?

    * match multiple people to 1 person

# Algorithm

```psuedocode
while there are unmatched men
    select an unmatched man
    if there are no women left on his list
        remove the man
    else the man proposes to the top-ranked woman still on his list
        if the woman is not engaged
            reply "ok" and both become engaged
        else if the woman thinks the main is not better than her current partner
            reply "no" to the man, who remains unmatched
            the unmatched man removes the woman from his list
        else (and so the woman thinks this man is better than her current partner)
            reply "ok" to the main and both become engaged
            send a Dear John letter to current partner, who is now unmatched
            the unmatched man removes the woman from his list
```

# Answers

* Does the algorithm terminate?

    * every man steps through their list making proposals, and so will eventually find a match or will reach the end of their list

* Does the algorithm compute a match for everybody?

    * no woman is ever matched to two men at the same time

    * no man is ever matched to two women at the same time

    * once a woman is proposed to, she never becomes unmatched (only trades up)

    * suppose some man is never matched – then some woman is also never matched, since there are equal numbers. That means she is never proposed to. But since all men rank all women, the unmatched man must have proposed to her – contradiction.

* Is the matching stable?

    * suppose not. Then there are a man M and a woman W such that M is matched with X but prefers W, and W is matched with K but prefers M. M must have proposed to W before X, and W must have rejected him for a more preferred match. But women never change to a lower-ranked match. So W must prefer K to M. Contradiction.

* Can we write an algorithm which is guaranteed to find a stable matching?

    * we have an algorithm that always terminates, always finds a match for every man and every woman, and always produces a stable matching. So yes.

* Is there always a stable matching?

    * since our algorithm can always find one, then yes.

# Implementation

* How should we maintain the data in the algorithm?

Unmatched men – process in some order, so use a queue

Rakings:

* men: need to move through list in order – a dictionary of lists with the key being the man and the value being the ranking list

* women: need to find the ranking for an arbitrary man, never changes – a dictionary of dictionaries: key = woman, value = dictionary of ranks

## Complexity

O(n) steps to build the initial singleman queue and man_next indices

O(n^2) to build the women rank dictionaries

Each man makes at most n proposals, so O(n^2) proposals in total.

Each proposal requires no more than a constant number of dequeuing, etc.

Total time complexity is therefore O(n^2).

# Men vs. Women

As the algorithm is presented, every man receives their highest possible ranked woman, where possible means "could appear in a stable matching".

* this can be proven but is complicated

Also, every woman receives their lowest possible ranked man.

Switching the order of the input arguments inverts this.

Notes:

* incomplete lists and ties still allows stable matchings, for revised definitions of stable.

* m-to-1 matchings are also guaranteed

[…]

# Algorithm Relevance

* this is a nobel prize winning algorithm (stable marriage, Gale-Shapley), with the extensions and associated theory

    * first thing in decades that gave a solution that didn't require money (look it up)

Extending it to m-to-1 matchings allows applications in:

* matching medical graduates to hospitals in US, Canada, Scotland, Norway, etc.

    * 30,000 graduates at a time (in the US)

    * stable matching important

    * hospital-optimal or student-optimal?

* matching internet users to available servers

* matching passengers to drivers in ride-sharing systems

* matching kidneys to recipients in international organ transplant schemes
