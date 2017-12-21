# Info

* The moodle course is CS2501.2017
* Early part will revise what we did in CS1106 and extend it.
* 80 marks for exam, 5 assignments each 4 marks (totalling 20) – 100 marks overall
* 22 lectures, 5 2-hour labs

# Overview

* Use and application of Database Management Systems (DMBSs)
  * Database configuration
  * SQL
    * Data manipulation language (retrieval, recording, modification, removal)
    * Data definition language (creating, altering, removing structures)
    * Data control language (data security and integrity)
      * Who has what permission on what components of the database.
  * Views (aka virtual tables)
    * These allow you to create a much richer representation of data by tailoring a DB to specific users and applications.
  * Database programming
    * Embedding SQL within programs (ESQL)
    * Web-SQL interface programming (PHP)
* Implementation of database systems
  * Database directory
    * This describes the database, and is central to all query evaluation. (Queries are validated against this.)
  * Relational algebra/calculus
    * SQL is converted/compiled to this intermediate form.
  * Query evaluation and optimisation
* Design of database systems (how to find the useful set of tables for an application)
  * Entity-relationship modelling
  * UML modelling
    * This is an extension of entity-relationship modelling
  * Normalisation
    * We may or may not cover this – it's not really used anymore

# Intro

A relational database is a collection of data organised into several related tables. The rows in the tables are sometimes called relations and the columns are sometimes called attributes.

A database management system (DBMS) is a software system whose purpose is to support storage of and controlled access to databases. These are often called databases for convenience.

## Users

Users of a DBMS may be:

  * Casual online users
    * E.g. us
    * Sit down, write a query, test that it works, put it in a program.
  * Programmers
    * Write programs for other users to use to interact with the database
  * Parametric end-users
    * Run programs and supply parameters to those programs to get different results
    * Largest class of users – typically don't know that they're using a DBMS.
    * E.g. staff in a records office
  * Database administrators
    * A database is a shared resource – you need someone to manage it.
    * Important for managing security.

## Configuration of a DBMS

A DBMS is usually installed as a server (listening on e.g. TCP/IP port 156).

Incoming requests are always SQL requests – the DBMS takes these and executes them.

A bunch of different clients can be used, and they can be text-only or graphical. Examples include HeidiSQL, MySQL Workbench.

Most DBMSs have interfaces (APIs – application programming interfaces) to multiple programming languages, to make them more useful.

Different DBMSs use slightly different flavours of SQL, but generally speaking if you can use one you can use them all.

# SQL

SQL is a set of commands divided into three groups:

* DDL (Data definition language)
  * `CREATE`
  * `DROP`
  * `ALTER`
* DML (Data manipulation language)
  * `SELECT`
  * `DELETE`
  * `UPDATE`
  * `INSERT`
* DCL (Data control language)
  * `GRANT`
  * `REVOKE`
  * These are for managing permissions/access

DML is the most commonly used, then DDL, then DCL.

## DML

### `SELECT`

```sql
  SELECT [DISTINCT] ColumnList
  FROM TableList
  [WHERE Condition]
  [GOUP BY ColumnList
  HAVING […]]
```

### Things to Note

With a `SELECT` statement with a `WHERE` condition, every row is checked – if the condition is true, the row is added to the output. If the condition is false, it isn't.

Note that the `DISTINCT` option is slow, because it sorts the table to remove duplicates. Usually, you avoid sorting in SQL if possible.

`Address LIKE '%Houston%'` allows arbitrary-length strings in place of the % symbols.

* `Salary BETWEEN 20000 AND 30000`
* `Dno IN (4, 5)`
* `CONCAT(Lname, ', ', Fname)`
  * Concatenates the given strings.
* `SELECT Ssn AS "Staff Id"`
  * Gives a column name to use in the result.
* String matching is case sensitive.
  * Some people make sure their databases are kept clean, format-wise
  * It's also possible to turn off case-sensitivity for string matching
  * It's also also possible to do the conversion when you retrieve it:
    * `SELECT … WHERE UPPER(Lname) = 'SMITH'`
* `WHERE SOUNDEX(Lname) = SOUNDEX('SMITH')`
  * `SOUNDEX` converts strings to sequences of phonemes
  * It's good for one-syllable words, but not great for words with more syllables – gets worse as it goes
