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
* DCL (Data control language) – for managing permissions/access
  * `GRANT`
  * `REVOKE`

DML is the most commonly used, then DDL, then DCL.

## `SELECT` Statement

```sql
  SELECT [DISTINCT] ColumnList
  FROM TableList
  [WHERE Condition]
  [GOUP BY ColumnList
  HAVING […]]
```
## DCL (Data Control Language)

### User Account Management

* Creating a new user account requires:

    * a username

    * a password

    * a privilege level

You can also add a privilege level to an existing user.

```sql
GRANT CONNECT
TO Black
IDENTIFIED BY blacks_password;

GRANT RESOURCE
TO Black;

REVOKE RESOURCE
FROM Black;
```

There are three privilege levels:

* `CONNECT`

    * allows a user to log in to the DBMS

* `RESOURCE`

    * `CONNECT` + execute DDL statements

* `DBA`

    * `RESOURCE` + `GRANT`/`REVOKE` privilege

### Table Access Management

```sql
GRANT SELECT
ON companydb.employee
TO white;
```

This gives `SELECT` permission to white on the employee table of the companydb database.

You can also use `*` as a wildcard, either for all tables in a database, or all tables in all databases:

```sql
GRANT ALL
ON companydb.*
TO violet
IDENTIFIED BY passwdX;

GRANT ALL
ON *.*
TO violet
IDENTIFIED BY passwdX;
```

You can set whether people are allowed to grant the permissions they're given to others:

```sql
GRANT ALL
ON companydb.*
TO silver
WITH GRANT OPTION;
```

You can limit permissions to certain columns:

```sql
GRANT SELECT, UPDATE (Salary, SuperSSN)
ON companydb.employee
To Ruby, Green, Black;
```
