# Complexity Analysis

Programs that take too long to finish are useless – good programming skills will not compensate for poor algorithms.

We need to understand how much work our algorithms will require for different inputs – learn to avoid bad or inefficient design patterns.

We also need to understand the limits – some problems can't be solved without at least a minimum amount of work. Don't waste time trying to design something that is impossible to achieve.

## Revision

We measure complexity in terms of the number of basic steps – quick constant-time operations:

* reading a value
* assigning a value
* comparing two values
* simple arithmetic operations
* calling a function
* returning a value

Our main concern is wort-case complexity:

* We want to know how bad it could get, and use that as a performance guarantee
* The complexity is based on the size of the input, n – how many items in a list, or in a tree, or rows in a file
* We are only concern about large inputs
    * asymptotic analysis: as n tends to infinity, how many steps as a function of n?

## Big O

For two functions f and g operating on positive integers, f(n) is O(g(n)) is there is an integer constant k >= 0 and a real constant C > 0 such that for all n bigger than k:

    f(n) <= C*g(n)

We can think of O(g(n)) as specifying a set of functions that are not significantly worse than g.

### Standard Function Hierarchy

O(c) C O(log(n)) C O(n) C O(nlogn) C O(n^2) C O(n^3) ... C O(2^n) C O(n!)


* Polynomials are classified by their highest degree.

It is correct to say that n^2 + 3n + 5 is O(n^3), but that's not as useful as saying that it's O(n^2).

Though sometimes looser bounds are all you need and are easier to guarantee from looking at your code.

There is a massive difference between a polynomial bound and O(2^n), which is taken as the boundary between efficient and non-efficient algorithms.

## Big Omega

Never better than a constant multiple.

f(n) is Ω(g(n)) if there is an integer constant k >= 0 and a real constant C > 0 so that for all n bigger than k […]

### Example: Prove fibonacci(n) is Ω((3/2)^n)

For all n >= 3, fib(n) > fib(n-1).

We know fib(n) = fib(n-1) + fib(n-2).

So for all n >=4, fib(n) < fib(n-1) + fib(n-1)

So fib(n) < 2*fib(n-1)

So 1/2 * fib(n) < fib(n-1)

Now take k = 2 and C = 1/2.

When n = 3, fib(n) = 2 and C * (2/3)^n = 27/16 which is < 2

Assume true for n = p for some p >= 3. Consider n = p + 1.

fib(p + 1) = fib(p) + fib(p-1)

fib(p+1) > fib(p) + 1/2 * fib(p) which is = 3/2 * fib(p)

fib(p+1) > 1/2 * (3/2 ^ p+1)

So result true by induction.

## Big Theta

Has an upper and lower bound, showing that f is not significantly different from g.

If you can prove that something is O(f(n)) and Ω(f(n)), then you already have Theta(f(n)).

### Example: n^2 + 3n + 5

* We already know this is O(n^2).

Now pick k = 0.

n^2 + 3n + 5 <= n^2 + 3n^2 + 5n^2 = 9n^2

C2 = 9

n^2 <= n^2 + 3n + 5

So C1 = 1

It's always between n^2 and 9n^2.

## Amortised Analysis

The true cost to the CPU of appending to a Python list of size k:

* if there is space, c units of time to assign value to the next cell
* If there is not space, then:
    * kc units of time to copy k values across to new list
    * c units of time to assign the value

In the analysis, we will charge a fixed cost for each append no matter what space is available or what size the list is.

* For simple appends, this builds up a profit
* Which we then spend on the complex appends

How much should we charge to ensure that we never run at a loss (for big enough lists)?

* This value is the amortised complexity of the operation.

Assume the fixed c units of time are worth €1. Simple append is €1, complex append is €(k+1). Let's charge €3 per append.

[get this bit]

In general, you want the charge to be as low as possible to still cover the cost.

For amortised complexity, you use an `*`: `O(1)*`

## Recursive Function Complexity

Basic approach:

1. count the worst-case work done by a single activation, without the recursive call
2. count the worst-case number of recursive calls
3. multiply the two counts together

### Example: Powers

Instead of stepping through powers one at a time: x^n * x^n-1 * …

We do this: x^n/2 * x^n/2

This means instead of n recursive calls, we have log(n), with still a constant number of operations in each call.

This is significantly faster, and reduces the number of calls on the activation stack, meaning you're less likely to hit the memory limit.

### Example: du

`du` is a Linux utility to calculate the size of a directory subtree.

If there are n total directories, then each directory will be processed once and only once, and if there are t files in total, then the algorithm will be O(n+t).

## More on Recursion Complexity

### Example: Fibonacci

```python
    def fib1(n):
        if n < 2:
            return 1
        elif n == 2:
            return 1
        return fib1(n-1) + fib1(n-2)
```

#### Analysis

All constant except the recursive calls, and we need two recursive calls per activation.

However, the 2nd is repeated inside the first. We're calling fib(n-2) again inside fib1(n-1), meaning we're calling it twice.

E.g. to get fib(7) we have to get fib(6) and fib(5). [etc]

* fib(7) and fib(6) are called once
* fib(5) is called twice
* fib(4) is called 3 times
* fib(3) is called 5 times
* fib(2) is called 8 times

This is extremely inefficient. It can't do numbers higher than about 12.

The number of calls for f(n) is > 2 ^(n/2).

So the algorithm is Ω(2^n) [check]

### Example: Efficient Fibonacci

Each call to fib(n) computes fib(n-1) also. We will return them both.

```python
    def fib(n):
        (a,b) = _fib(n)
        return a

    def _fib(n):
        if n == 1:
            return (1, 0)
        elif n == 2:
            return (1, 1)
        (a, b) = _fib(n-1)
        return (a + b, a)
```

This is linear.

### Exercise: More Efficient Fibonacci Using Matrices

[check]

* You can get it to O(log(n)) using matrices and a trick from lecture 2.
