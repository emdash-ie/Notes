# Question 1

## (a)

### (i)

* employee SSNs must be unique can be done with a `UNIQUE` or `PRIMARY KEY` constraint.

* supervisor must be an employee can be done with a `FOREIGN KEY` constraint

* employee's department must be valid can be done with a `FOREIGN KEY` constraint

* sex must be 'F' or 'M' can be done with a `CHECK` constraint

### (ii)

* names must be in a standard format

    * to do this you could limit direct access to the database to just the admin and have everyone else interact with the database through programs, which do their own validation on the inputs

## (b)

[don't know]

# Question 2

## (a)

The table descriptor in the database directory will be altered. The specific tables altered will be `COLUMNS` and `SYSCOLUMNS` for statements that add, delete, or modify columns.

## (b)

For example:

```sql
GRANT UPDATE
ON table
TO username;
```

This would change `SYSTABAUTH`, either adding a new row for the user and the table, or modifying the existing row. It may also add an entry to `CATALOG`/`SYSCATALOG`.

## (c)

The structure of the tables is complicated and assumes a lot of knowledge from the user for direct interaction. Nowadays interacting through scripts is encouraged instead. [Not sure. Also not sure what he means by an example.]

## (d)

1. Does the table `EMPLOYEE` exist?

    * check `SYSCATALOG`

2. Does the user running the query have grant option for for `INSERT`

    * check `SYSTABAUTH`

3. Does `User007` exist?

    * check `SYSUSERAUTH`

If all these conditions are true, the statement will succeed.

## (e)

Create a local copy of the table. If you have resource permissions, you can then put the info into a new table of your own.

# Question 3

## (a)

* if the info you want to display in the output comes from multiple tables/views, you can't use subqueries, and so have to use a join instead

## (b) Find the identity and name of each dependent of an employee working for the Research department

* not sure what identity means? They don't have an ID or SSN

    * have gone with selecting the employee's SSN

### (i) As a Join

```sql
SELECT Dpnd.ESSN, Dpnd.DEPENDENT_NAME
FROM DEPENDENT Dpnd, EMPLOYEE E, DEPARTMENT Dprt
WHERE Dpnd.ESSN = E.SSN
    AND E.DNO = Dprt.DNUMBER
    AND Dprt.DNAME = 'Research';
```

### (ii) As a Subquery

```sql
SELECT ESSN, DEPENDENT_NAME
FROM DEPENDENT
WHERE ESSN IN (
    SELECT SSN FROM EMPLOYEE
    WHERE DNO IN (
        SELECT DNO FROM DEPARTMENT
        WHERE DNAME = 'Research'
    )
);
```

* Have used `WHERE DNO IN` rather than `WHERE DNO =` to allow for multiple departments called 'Research'.

## (c) Specify the definition of a view that would simplify the query of (b) above. It should be of the form DependEmpDept (Dependent_Name, SSN, Dno) and contain details of dependents, employees and departments.

```sql
CREATE VIEW DependEmpDept (ENAME, ESSN, DPND_NAME, DPRT_NUM, DPRT_NAME) AS
SELECT CONCAT(E.FNAME, ' ', E.LNAME), E.SSN, Dpnd.DEPENDENT_NAME, Dprt.DNUMBER, Dprt.DNAME
FROM DEPENDENT Dpnd, EMPLOYEE E, DEPARTMENT Dprt
WHERE Dpnd.ESSN = E.SSN
    AND E.DNO = Dprt.DNUMBER;
```

# Question 4

## (a) Embedded SQL

### (ii) Why and how is the INTO clause employed in ESQL – a feature that is absent in standard interactive SQL?

It's used to store results from a query into variables, e.g.:

```sql
SELECT Fname, Lname, Address, Tel_No
INTO :FirstName, :LastName, :Address, :Telephone
FROM STAFF
WHERE Sno = :StaffNum
```

### (iii) Why is the FOR UPDATE OF ... clause sometimes used with the SELECT statement in ESQL?

To allow updating of a value as a cursor is being used to look through the results of an SQL statement. `FOR UPDATE OF` maintains linkage between result tables and the original tables.
