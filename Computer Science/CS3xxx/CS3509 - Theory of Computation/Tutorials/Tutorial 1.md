% CS3509 Tutorial 1
%
% Tuesday 17th October, 2017

Q: Demonstrate that there is no program that decides whether input programs terminate on input 0.

a) Assume the program does exist.

    * Call the program H0. We’ll show that we could use it to solve the halting problem.

b) Define a new program Q.

    * Q is identical to P, except that whatever input it’s given, it always runs P on i, ignoring its own input.

c) [Q has solved the halting problem]

Q: Demonstrate there is no program … on input 10.

a) Assume the program does exist.

    * Call it H0

b) Define Q.

    * Q ignores its input, and runs P(i)

    * Q(10) terminates if and only if P(i) terminates

    * Since H0 can tell if Q(10) terminates, H0 can tell if P(i) terminates, which means it has solved the problem

c) H0 has solved the halting problem, which is impossible – contradiction.

# Problem 1 (page 64)

a) Assume T exists.

b) T can solve the halting problem.

    * If T can show how many 5s are output, then it can show whether any number of 5s is output.

    * So T can solve the problem above.

    * So T can solve the halting problem (by our reasoning above).
