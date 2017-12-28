% 8: Unit Testing
%
% Thursday 26th of October, 2017

# Testing

There are a few kinds of tests performed by developers, e.g. unit tests, integration tests, and end-to-end tests.

System Under Test: the part of the system being tested

Depended On Component/Collaborator: an entity required by a system under test to fulfil its duties

In this module, we just look at unit testing.

## Unit Tests

Focus on an individual class, and control all aspects of the test context by replacing real collaborators with test doubles.

Unit tests don’t consider the users of the system they test, and are unaware of layers, external systems, and resources.

Unit tests are the tests that will verify a class’ expected behaviour.

They serve as live documentation of the code.

You can turn the process of creating unit tests into a design activity – it gets you thinking about how your code is going to be used (the user’s perspective).

# Interactions

Classes (with interactions?) can’t be thoroughly tested using just their API. You can test the interface but not correct operation.

# Unit Testing Frameworks

JUnit is an open-source testing framework for Java. It was built for unit testing, but also supports other kinds of test.

JUnit is widely supported, and has a large number of third-party extensions.

# JUnit Testing
