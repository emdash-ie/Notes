# SQL Recap

SQL is DDL, DML, and DCL.

## Arithmetic Expressions & Functions

Arithmetic Operators:

* `+`
* `-`
* `*`
* `/`

Numeric Functions:

* `ABS(x)`
* `CEILING(x)`, `FLOOR(x)`
* `COS(x)`, `SIN(x)`, `TAN(x)`
* `EXP(x)`
* `LOG(x)`

## Example: Find the Name of Male Employees Aged Between 21 and 25

```sql
SELECT Fname Lname
FROM EMPLOYEE
WHERE Sex = 'M'
    AND DOB BETWEEN DATE_SUB(CURDATE(), INTERVAL 25 YEAR)
                AND DATE_SUB(CURDATE(), INTERVAL 21 YEAR)
```

* `CURDATE()` gives the current date
* `DATE_SUB()` subtracts amounts from dates
    * Accounts for leap years based on the calendar
* This won't actually work in MySQL
    * MySQL won't allow you to have a function within a function

## Statistical Data Retrieval

* `MAX(Salary)`
    * Gives the maximum entry in Salary
* `MIN(Salary)`
    * Gives the minimum entry in Salary
* `AVG(Salary)`
    * Gives the average for Salary
* `COUNT(*)`
    * Counts the number of rows in the result table
    * Normally used with `*` as the argument (one exception - `DISTINCT ColumnName` as below)
* `COUNT(DISTINCT expr)`
    * Counts the rows containing `expr`
    * Example:
    ```sql
    SELECT COUNT(DISTINCT ESSN)
    FROM DEPENDENT
    […]
    ```
* `SUM(Hours)`
    * Gives the sum of the entries for Hours
* You always get a result table with a single value (a singleton) when using these functions.

Note that the where condition happens before the averaging, so this query below finds the average salary for female employees in department number 5:

```sql
SELECT AVG(Salary)
FROM EMPLOYEE
WHERE Dno = 5
    AND Sex = 'F'
```

### GROUP BY

`GROUP BY` is used for computing statistics over groups of values, rather than individual values.

It sorts by a specified column, and then groups together all rows which have the same value for that column. Then it treats each group as a separate table.

E.g. finding the maximum salary in each group:

```sql
SELECT Dno, MAX(Salary)
FROM EMPLOYEE
GROUP BY Dno
```

The `WHERE` clause is evaluated before the `GROUP BY`, e.g.:

```sql
SELECT Dno, AVG(Salary / 12)
FROM EMPLOYEE
WHERE Sex = 'F'
GROUP BY Dno
```

### HAVING

* The `HAVING` clause is evaluated after separation by `GROUP BY` – it applies to groups, rather than rows.
* Usually contains a function.

```sql
SELECT Dno, AVG(Salary)
FROM EMPLOYEE
GROUP BY Dno
HAVING AVG(Salary) > 35000
```

1. Group the table by department number
2. Eliminate groups with average salary less than 35000
3. Display the department number and average salary of each remaining group

### Example: Find the Average Female Salary in Departments of More Than 100 Employees

You might try this:

```sql
SELECT Dno, AVG(Salary)
FROM EMPLOYEE
WHERE Sex = 'F'
GROUP BY Dno
HAVING COUNT(*) > 100
ORDER BY 2
```

1. Eliminate all male rows
2. Group by department number
3. Eliminate groups with less than 100 rows
4. Display department number and average salary for each remaining group, ordered by average salary.

However, here the `COUNT` clause only counts female employees, because the male employees were removed first. So only departments with more than 100 *female* employees are kept.

* `ORDER BY 2` orders by the second column.
    * For computed columns, you have to specify the column positionally rather than by name.

To do what we want, we need subqueries.

## Subqueries

* These go in brackets, and evaluate earlier than the rest of the query.

Example:

```sql
SELECT CONCAT(Lname, ', ', Fname) AS Name
FROM EMPLOYEE
WHERE Sex = 'M'
    AND Dno IN
        (SELECT Dnumber
         FROM DEPT_LOCATIONS
         WHERE Dlocation = 'Houston')
ORDER BY Name
```

1. Get the department numbers of all departments in Houston
2. Eliminate all employee rows who're female or are in a department not in Houston (using the list of numbers from above)
3. Display the concatenated name of all remaining employees, ordered by name.

* `IN` is an inter-block connective – there are more later
* You can't use `DISTINCT` or `ORDER BY` in subqueries.
* MySQL has another limitation to subqueries, which we'll see later.

### Interblock Connectives

```sql
SELECT Lname, Fname
FROM EMPLOYEE
WHERE Salary =
    (SELECT MAX(Salary)
     FROM EMPLOYEE)
```

* Equality is only legal when a subquery only returns a single value.

```sql
SELECT Lname, Fname
FROM EMPLOYEE
WHERE Salary >=ALL
    (SELECT Salary
     FROM EMPLOYEE)
```

```sql
SELECT Lname, Fname
FROM EMPLOYEE
WHERE Sex = 'F'
    AND Salary =
        (SELECT MAX(Salary)
         FROM EMPLOYEE
         WHERE Sex = 'F'))
```

* Comparison Operators:
    * `=`
    * `!=`
    * `>`
    * `<`
    * `>=`
    * `<=`
    * These can only be used when a subquery returns a single value.
* Set Comparison Operators:
    * Any of the comparison operators followed by `ANY` e.g. `=ANY`.
    * Any comparison operator followed by `ALL`.
* Set Inclusion Operator:
    * `IN`
    * `NOT IN`
* Existential Quantifier:
    * `EXISTS`
    * `NOT EXISTS`
    * These can only be used with a specific kind of subquery (synchronised subqueries) that we'll see later.
