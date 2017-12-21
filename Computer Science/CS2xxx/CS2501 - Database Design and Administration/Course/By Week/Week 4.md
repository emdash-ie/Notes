# Joins (cont.)

Using joins to find the name of all employees working in the same department as Joyce English:

```sql
SELECT RE.Fname, RE.Lname
FROM EMPLOYEE LE, EMPLOYEE RE
WHERE LE.Dno = RE.Dno
    AND LE.Ssn != RE.Ssn
    AND LE.Fname = 'Joyce'
    AND LE.Lname = 'English';
```

Find the name of employees working in the same department as Joyce English who earn more than her:

```sql
SELECT RE.Fname, RE.Lname
FROM EMPLOYEE LE, EMPLOYEE RE
WHERE LE.Dno = RE.Dno
    AND LE.Ssn != RE.Ssn
    AND LE.Fname = 'Joyce'
    AND LE.Lname = 'English'
    AND LE.Salary < RE.Salary;
```

* Note that now the Ssn condition is unnecessary, because one row can't have two salary values, so the salary condition excludes all rows with the same person on each side.

## Left Outer Join

Any normally unmatched row from the left table will automatically match a null row appended to the right.

E.g. find the name of every Texas-based employee, together with the name & relationship of any dependents they might have:

```sql
SELECT Fname, Lname, Dependent_Name, Relationship
FROM EMPLOYEE LEFT JOIN DEPENDENT
WHERE Ssn = Essn
    AND Address LIKE '%TX';
```

* For most implementations besides MySQL, you can use the following notation instead of `LEFT JOIN`:

```sql
SELECT […]
FROM EMPLOYEE, DEPENDENT+
WHERE […]
```

# Synchronised Subqueries

Also called:

* Correlated subqueries
* Subequeries with interblock reference

The inner block refers to a column in its parent block. (You can only refer up one level.)

They evaluate more like joins than subqueries.

MySQL syntax:

```sql
SELECT Fname, Lname
FROM EMPLOYEE E
WHERE 'Research' IN
    (SELECT Dname
     FROM DEPARTMENT
     WHERE Dnumber = E.Dno)
```

* For other implementations, you don't need to use an alias with employee.
    * You can just write `…WHERE Dnumber = Dno`.
* Note using `=` instead of `IN` will work because you can be sure that you won't get two results from the subquery

The order of evaluation is changed. The query evaluates top-down:

1. Look at the first row of the `EMPLOYEE` table.
    1. Evaluate the interblock reference
    2. Evaluate the subquery
    3. Include or don't include the row
2. Look at the second row of the `EMPLOYEE` table.
    1. Evaluate the interblock reference
    2. Evaluate the subquery
    3. Include or don't include the row
[…]

The subquery is run once for each row, which is potentially very inefficient.

Regular subqueries are much more efficient, and joins are probably more efficient as well.

Here're examples where you might have to use synchronised subqueries:

* Find the name and id of all departments employing people from Houston:

```sql
SELECT Dnumber, Dname
FROM DEPARTMENT D
WHERE EXISTS
    (SELECT *
     FROM EMPLOYEE
     WHERE Address LIKE '%Houston%'
         AND Dno = D.Dnumber);
```

* Find the name and id of all departments employing no-one from Houston:

```sql
SELECT Dnumber, Dname
FROM DEPARTMENT D
WHERE NOT EXISTS
    (SELECT *
     FROM EMPLOYEE
     WHERE Address LIKE '%Houston%'
         AND Dno = D.Dnumber);
```

# Inserting Data

By default new rows are entered at the bottom of the table.

* In general you can only add data to one table at a time

```sql
INSERT INTO EMPLOYEE
VALUES ('Joan', 'J', 'McGregor', […]);
```

You can populate tables from other tables:

```sql
INSERT INTO HOUSTON_STAFF
SELECT Ssn, Dno, Salary
FROM EMPLOYEE
WHERE Address LIKE '%Houston%';
```

# Modifying Data

You can only modify data in one table at a time.

Address

```sql
UPDATE EMPLOYEE
SET Address = '18 Maple, Austin, TX',
    Salary = 50000
WHERE Ssn = '123457689';
```

Give all employees of department 5 a 20% raise:

```sql
UPDATE EMPLOYEE
SET Salary = Salary * 1.2
WHERE Dno = 5;
```

You can use subqueries (and joins, in MYSQL) to build the condition, but you can only ever update in one row.

# Deleting Data

You can only delete data from one table at a time.

```sql
DELETE
FROM EMPLOYEE
WHERE Fname='Jennifer'
    AND Lname='Wallace';
```

# Verification

When you get input to a table, you should verify the format and also any references to other tables (e.g. referencing a department that doesn't exist).

This prevents your table from getting very messy.

In practice, a lot of database administrators will restrict insert permissions to a small number of people, and will only allow insertion through a program that verifies the input.

The same things apply to deletion of rows.

Three options:

* Do nothing (allow people to screw up the database)
* Specify rules that the DBMS might apply to modification commands
    * This slows down insertions, modifications, and deletes
* Perform data modification under program control
