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
