#!/usr/local/bin/python3

from cgitb import enable
enable()

from cgi import FieldStorage, escape
import pymysql as db
form_data = FieldStorage()

result = """Content-Type: text/html

<html>
<head>
    <title>Data Entry for Customers Table</title>
</head>
<body>
    <form method="get" action="part_a.py">
        <input type="text" id="customerID" name="customerID" placeholder="Customer ID" value="%s"/>
            <input type="text" id="name" name="name" placeholder="Name" value="%s"/>
            <input type="text" id="addressLine1" name="addressLine1" placeholder="Address (line 1)" value="%s"/>
            <input type="text" id="addressLine2" name="addressLine2" placeholder="Address (line 2)" value="%s"/>
            <input type="text" id="addressLine3" name="addressLine3" placeholder="Address (line 3)" value="%s"/>
            <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" value="%s"/>
            <input type="submit" value="Submit"/>
    </form>
</body>
</html>
"""

if len(form_data) != 0:
    customerID = escape(form_data.getfirst('customerID', ''))
    name = escape(form_data.getfirst('name', ''))
    addressLine1 = escape(form_data.getfirst('addressLine1', ''))
    addressLine2 = escape(form_data.getfirst('addressLine2', ''))
    addressLine3 = escape(form_data.getfirst('addressLine3', ''))
    phoneNumber = escape(form_data.getfirst('phoneNumber', ''))
    inputs = [customerID, name, addressLine1, addressLine2, addressLine3, phoneNumber]
    
    if '' not in inputs:
        try:
            connection = db.connect('cs1dev.ucc.ie', 'nfb2', 'aiphaehe', '2019_nfb2')
            cursor = connection.cursor(db.cursors.DictCursor)
        
            cursor.execute("""INSERT into customers (customerID, name, addressLine1, addressLine2, addressLine3, phoneNumber)
                              VALUES (%s, %s, %s, %s, %s, %s)""",
                              inputs)
            connection.commit()
        except db.Error:
            print(result % ('', '', '', '', '', ''))
            cursor.close()
            connection.close()
        else:
            print(result % (customerID, name, addressLine1, addressLine2, addressLine3, phoneNumber))
            cursor.close()
            connection.close()
    else:
        print(result % ('', '', '', '', '', ''))
else:
    print(result % ('', '', '', '', '', ''))
