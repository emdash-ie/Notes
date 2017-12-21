#!/usr/local/bin/python3

from cgitb import enable
enable()

from cgi import FieldStorage, escape
import pymysql as db
form_data = FieldStorage()

connection = db.connect('cs1dev.ucc.ie', 'nfb2', 'aiphaehe', '2019_nfb2')
cursor = connection.cursor(db.cursors.DictCursor)

cursor.execute("""SELECT * FROM customers""")

print("Content-Type: text/html")
print()

result = """
<html>
    <body>
        <table>
            <tr>
                <th>Customer ID</th>
                <th>Name</th>
                <th>Address (Line 1)</th>
                <th>(Line 2)</th>
                <th>(Line 3)</th>
                <th>Phone Number</th>
            </tr>
"""

for row in cursor.fetchall():
    result += "<tr>\n<td>%s</td>\n<td>%s</td>\n" % (row['customerID'], row['name'])
    result += "<td>%s</td>\n<td>%s</td>\n" % (row['addressLine1'], row['addressLine2'])
    result += "<td>%s</td>\n<td>%s</td>\n</tr>\n" % (row['addressLine3'], row['phoneNumber'])
    
result += "</table>\n</body>\n</html>"

print(result)