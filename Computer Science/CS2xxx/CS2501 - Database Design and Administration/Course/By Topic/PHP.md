* putting the @ symbol before a call suppresses error messages

* you can only have string variables in php

* `.` is used for string concatenation

* `MYSQL_FETCH_ROW()` returns a string representing the next row in the table

    * there are hidden separators between the contents of each field, allowing you to access each field using indices

* can use `MYSQL_FETCH_ASSOC()` instead to get an associative array, indexed by field name

* `HTMLSPECIALCHARS` suppresses interpretation of html tags within strings

* global variables start with `$_`

    * you can't use this for non-global variables

* `$_GET` and `$_PUT`

    * `$_GET` is a global variable that holds data submitted by GET from a form, indexed by the name parameter of the input

There are errors in his programs – some don't connect to the database that need to, and vice-versa.
