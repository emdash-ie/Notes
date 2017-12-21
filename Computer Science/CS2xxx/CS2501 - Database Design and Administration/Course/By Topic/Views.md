# Views

Views (a.k.a. derived tables) are definable windows into one or more tables of an SQL database.

They give two main advantages:

* You can grant access to a view without granting access to the base tables it's derived from

    * This allows you to give someone access to some columns or rows of a base table but not others

* You can provide alternate database structures to some people

    * This can simplify access to the database for those people

## View Definition

Example:

```sql
CREATE VIEW HoustonEmployeesD5 AS
SELECT Ssn, Fname, Lname, Sex, Salary
FROM EMPLOYEE
WHERE Address LIKE '%Houston, TX'
    AND Dno = 5;
```

When someone submits a `CREATE VIEW` statement, two things happen:

* the DBMS validates the `SELECT` command
* the DBMS stores the text of the `SELECT` statement and labels it according to the name you gave
    * it stores this in the database directory

Note no validation takes place at this point.

This allows the views to remain consistent with the base tables when they change.

* You can also rename columns in views, and create views from other views.

```sql
CREATE VIEW HER_1 (StaffId, Name, Sex, Salary) AS
SELECT SSn, CONCAT(Lname, ', ', Fname), Sex, Salary
FROM EMPLOYEE, DEPARTMENT
WHERE Dno = Dnumber
    AND Address LIKE '%Houston, TX'
    AND Dname = 'Research';
```

Anyone can create a view who has the permission to run the `SELECT` query that creates it.

## View Manipulation

You can use `SELECT` queries on views just as you would on base tables.

## View Implementation

When this is done, a part of the DBMS called the query modifier retrieves the view definition from storage and merges it with the text of the input query. The query modifier is a text-based algorithm that runs very quickly. The result of the merging is the query that is run by the DBMS.

## View Updatability

* Using views for `UPDATE`, `INSERT`, and `DELETE` statements often doesn't make sense as it's not clear what they would mean in relation to the base tables.

Some DBMSs (including MySQL) don't allow any commands other than `SELECT` to be used on views.

Others (e.g. Oracle) impose some constraints, typically allowing views to be modified if:

1. They are derived from a single base table
2. They contain all `NOT NULL` columns of that base table.
3. They do not contain any function calls in their `SELECT` clause.

Views not meeting these conditions can be marked as "not updatable" when created.
