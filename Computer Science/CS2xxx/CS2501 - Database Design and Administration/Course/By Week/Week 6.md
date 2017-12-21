# Views (a.k.a. virtual tables, derived tables)

Base tables have a security problem:

* You can't hide some columns from people
    * e.g. give read access to the employee table but hide the salary column
* You can't hide some rows from people

Views solve this problem, and also make data requests simpler.

## View Definition

When someone submits a `CREATE VIEW` statement, two things happen:

* the DBMS validates the `SELECT` command
* the DBMS stores the text of the `SELECT` statement and labels it according to the name you gave
    * it stores this in the database directory

Note no validation takes place at this point.

This allows the views to remain consistent with the base tables when they change.

### Examples

```sql
CREATE VIEW HoustonEmployeesD5 AS
SELECT Ssn, Fname, Lname, Sex, Salary
FROM EMPLOYEE
WHERE Address LIKE '%Houston, TX'
    AND Dno = 5;
```

* Create a view containing certain information on Houston-based employees of the research department:

```sql
CREATE VIEW HER_1 (StaffId, Name, Sex, Salary) AS
SELECT SSn, CONCAT(Lname, ', ', Fname), Sex, Salary
FROM EMPLOYEE, DEPARTMENT
WHERE Dno = Dnumber
    AND Address LIKE '%Houston, TX'
    AND Dname = 'Research';
```

* In the above one we rename the columns

You can also create views from other views:

```sql
CREATE VIEW HERWORK AS
SELECT Pno, Pname, Plocation, Hours
FROM WORKS_ON, PROJECT, HER_1
WHERE Pno = Pnumber
    AND Dnum = Dnumber;
```

* Anyone can create a view who has the permission to run the sql `SELECT` query that creates it.

## View Manipulation

You can use `SELECT` queries on views just as you would on base tables.

When this is done, a part of the DBMS called the query modifier retrieves the view definition from storage and merges it with the text of the input query. The query modifier is a text-based algorithm that runs very quickly. The result of the merging is the query that is run by the DBMS.

* Views are not particularly useful for `UPDATE`, `INSERT`, and `DELETE` statements, as it's often not clear what they would mean in relation to the base tables.
