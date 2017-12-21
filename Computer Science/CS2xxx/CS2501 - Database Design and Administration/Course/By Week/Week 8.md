# Database Programming

* most people interact with databases through programs (parametric users)

    * they don't need to know that they're interacting with a database

In the past there was typically one mainframe, which contained the DBMS and the applications for interaction. Embedded SQL (ESQL) was used.

This changed to a client-server model, where the applications run on the client, and communicate with the server. ODBC (a small extension to ESQL) is used for this.

Then everything moved to the internet. At this point, PHP and ASP were developed specifically for interfacing databases with the internet. Looking at PHP and ASP, you can see how they developed from ESQL.

## ESQL

* note all examples are in pseudocode

    * this is to keep the emphasis on how the program interacts with the database, and not coding in a particular language

* `INCLUDE SQLCA` is for status information – what happened? did it work? etc. It's a data structure shared between the DBMS (which can write into it) and the program (which can read from it).

* program needs to log in and be verified using a username and password

    * if the login was unsuccessful, there's no point continuing

    * the program checks the SQLCA to determine whether it was successful or not

        * the value accessed will be 0 if the command was correct, a negative value if there was an error, and a positive value if there was an exception

    * program also needs to log out at the end

        * connection is closed anyway when the program terminates, but need to make sure SQLCA datastructure is deleted

* `INTO` line puts the selected results into the specified variables

    * colon prefix is used to indicate a local variable

* stafflookup program is made easier by the fact that we're looking up based on a unique key – the result will either be a single row or nothing

    * so we know that we only need a single variable for each column in the result

* Since programs contain SQL and whatever language they're written in, there needs to be something marking the SQL code (telling the other compiler/interpreter to ignore it)

    * pre-compilers also used to solve this problem – they validate and compile just the embedded SQL statements (like an interactive interpreter)

        * extract the individual statements, compile to machine code, put comments around the result code within the host code, which then goes through a normal compiler

            * then use a linker to link all the individual machine code segments into a single executable

### SQL Communication Area

* a datastructure that contains information on the database interactions

    * SQLCode is a numeric value, where 0 means success, a negative number means an error happened, and a positive value means an exception happened

    * there are then different positive numbers for different exceptions, e.g. 100 to say that the query ran but retrieved nothing

        * same for errors, e.g. -56 says you don't have permission to execute the query you tried to run

### Example: StaffRecord

* Will check that the staff number given doesn't already exist

* error feedback isn't very comprehensive – would need to be more specific in a proper program

### Example: StaffList

* may get multiple results
