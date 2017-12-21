Exam/Mark Details
=================

70% of the module grade is final exam/test.

30% is in-class tests.

Exam date (for CS1106 and CS5021 students) is fixed at 14th of December
at 16:30. See your exam timetable for room details.

No DB lab tomorrow and no lecture on Friday.

Test no. 2 has been marked, and you can collect your copy in the lab
tomorrow afternoon at 4 p.m. The marks will be posted after this.

The last question on the exam was discarded because most people didn't
get it (some people did), so the exam was marked out of 90 and scaled
up. As the test was more difficult than the first, marks were lower
generally, though there were 1 or 2 people who scored 100%.

Sample Paper
============

Question 1 was short questions about non-SQL info.

Question 2 was on table creation and manipulation, rather than select
queries.

Question 3 was an SQL question, with six parts in increasing order of
difficulty.

Question 1
----------

A question on an ER diagram like part (iii) is quite common.

Question 2
----------

Need to know datatypes for data definition.

Example code:

> CREATE TABLE weatherstats\
> (station VARCHAR(20),\
> day DATE,\
> max\_temp FLOAT(3,1),\
> min\_temp FLOAT(3,1),\
> rainfall FLOAT(4,1),\
> PRIMARY KEY (station, day)\
> );

Question 3
----------

Over half the marks. Lab-style SQL stuff.

The DB will be one of the ones we've done in labs.

Your solutions can mix subqueries and joins if required.
