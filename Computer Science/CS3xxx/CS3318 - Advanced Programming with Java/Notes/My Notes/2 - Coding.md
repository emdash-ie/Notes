# Readability of Code

* reader should be easily able to correctly interpret what the code does

* code should be economical, but not to the point where this compromises intelligibility

* you have control over naming and over coding style

    * also naming conventions

    * also programming idioms (solutions typical/common to the language)

# Programming Style

* programming style is not about self-expression

* programming style is about reducing errors

    * a program must communicate to the computer and to the reader

Use a familiar style unless there’s a benefit in departing from it.

# Code Style and IDEs

* most allow you to apply a predefined code style to your project

# Code Checking Tools

* e.g. lint

* statically identify problems with the code (without executing it)

# General Principles

* Make your programs look like what they do.

* Avoid forms that are difficult to distinguish from common errors.

* If there is a feature of a language that is sometimes problematic, and if it can be replaced with another feature that is more reliable, then always use the more reliable feature.

# Java Code Conventions

## Why?

* 80% of the lifetime cost of a piece of software goes to maintenance

* hardly any software is maintained for its whole life by the original author

* code conventions improve the readability of the software, allowing engineers to understand new code more quickly and thoroughly

* If you ship your code as a product, you need to make sure it is as well packaged and clean as any other product

## Naming

* make programs more understandable & easier to read

* can give info about the function of the identifier (e.g. whether it’s a constant or a class)

## Order of Keywords

* using a conventional order makes code easier to read

* Java has a recommended order (e.g. `public static final`)

# Issues with Languages

[…]

* Effect Systems

    * http://www.eff-lang.org/handlers-tutorial.pdf

* Extended Static Type Checking

* Meta-theory

    * Most programming languages have no formalisation of their semantics

* Cost Models

    * The complexity bound is calculated on the resources consumed by performing a computation, letting a programmer check the cost of a program: http://www.raml.co

* Parallelism

    * Languages providing abstract forms of control flow and data batching/locality, into which a program can cast itself, to permit exploitation of heterogeneous computers

    * Usually hidden in the compilation process

* Parametric Mutability
