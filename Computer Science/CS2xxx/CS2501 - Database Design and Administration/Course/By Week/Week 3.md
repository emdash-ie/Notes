```sql
SELECT Pnumber, Pname, Plocation
FROM Project
WHERE Pnumber IN
    (SELECT Pno
     FROM WORKS_ON
     GROUP BY Pno
     HAVING COUNT(*) = MAX(COUNT(*))
```

* MySQL won't allow the code above (even though it's correct SQL) because it won't allow function calls within function calls (`COUNT` inside `MAX`).

```sql
SELECT Fname, Lname
FROM EMPLOYEE
WHERE Ssn <> '128490127'
    AND Dno =
        ( SELECT Dno )
        […]
```

* In MYSQL, subqueries can only return single columns – you have to use separate conditions.
    * This is not incorrect SQL, it's just not supported in MySQL.

# Joins

Conceptually, joins make all possible combinations of rows between the tables given. In practice, the `WHERE` condition is used by the implementation to eliminate rows as the join is compiled.

```sql
SELECT CONCAT(UPPER(Lname), ', ', Fname) AS Name
FROM EMPLOYEE, DEPARTMENT
WHERE Dno = Dnumber
    AND Dname = 'Research'
ORDER BY Name;
```

If it was `Dno` in both tables, we'd use dot notation to distinguish them:

```sql
…
WHERE EMPLOYEE.Dno = DEPARTMENT.Dno
…
```

We can also use aliases to shorten these table names:

```sql
…
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.Dno = D.Dno
…
```

Joins are more general than subqueries, and sometimes you have to use them (e.g. when the columns in the result table come from different source tables).

* A subquery can't use `SELECT DISTINCT`, or `ORDER BY` [check].
