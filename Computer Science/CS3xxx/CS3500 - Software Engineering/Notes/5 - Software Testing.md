# Goal

The goal for testing is to improve confidence in […]

A test case is a document, which has a set of test data, pre-conditions, expected results and post-conditions, developed […]

# Black-box vs. White-box Testing

In black-box testing, you ignore implementation details and focus on the behaviour, based on specification/interfaces. Typically this is done by dedicated testers.

In white-box testing, the focus is on the implementation. Typically this is done by software developers.

# Quality Assurance vs. Quality Control

Quality assurance is doing things that (you believe) will lead to better quality.

Quality control is checking the actual product to make sure it’s of good quality.

# Code Coverage

Code coverage is the percentage of your code that is covered by test cases. In practice, 80-90% is a good amount – 100% is not ideal because it takes too much time to write and run tests, and isn’t necessary.

## Types

1. Statement coverage
    - count each statement that is executed as part of a test
2. Branch coverage
    - considers each branch/decision point
3. Data flow coverage
    - considers the use/assignment of data/variables

# Cyclomatic Complexity

To tell how many test cases are needed, you can check the cyclomatic complexity of the code.

To do this, the structure of the code is represented as a graph, and then analysed.

# Static Testing Techniques

Static analysis techniques don’t execute the software. The analysis is either performed manually by people, or automatically by tools.

## Group Walkthroughs

Designed/programmer leads members of the development team through the code. Participants can ask questions and make comments.

This can be formal or informal, and is typically done in a meeting room with an overhead projector.

## Peer Review

Code is reviewed by a co-worker/peer. Peers may spot errors that the original author didn’t see.

* more common these days than group walkthroughs

This is an extremely useful activity.

Ideally this should be done objectively and not between close friends.

It’s extremely common in open source software development.

## Automated Analysis

Tools can conduct static analysis. They are similar to compilers, but rather than translating a program, they perform semantic analysis.

# Dynamic Testing Techniques

## Unit Testing

Unit testing involves testing individual subprograms, subroutines, or procedures in a program.

There is a `unittest` module in python that can be used for this.

## Integration Testing

Combine components and make sure they still behave according to their specification.

## System Testing

Test the whole system, embedded in its target environment, to verify it behaves as expected.

## Regression Testing

Re-running of a test-suite after modifying a program, to ascertain that no new faults were introduced.

Typically, this is a combination of unit testing, integration testing, and system testing, often run automatically after checking in code changes.

This is very common in agile methods.

# Assertions

These can be used to check assumptions in your code. When switched off, their performance overhead disappears.

Assertions make your assumptions clear to other people reading the code, and can make you more aware of potential issues.
