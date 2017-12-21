<?xml version="1.0"?>
	<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
        <xsl:output method="html"/>
        <xsl:template match="/"> <xsl:apply-templates/> </xsl:template>
		<xsl:template match="customers"><html xmlns="http://www.w3.org/1999/xhtml">

            <head>
              <title>Customers</title>
            </head>

            <body>
                <table>
                    <tr>
                        <th>Customer ID</th>
                        <th>Name</th>
                        <th>Address (line 1)</th>
                        <th>Address (line 2)</th>
                        <th>Address (line 3)</th>
                        <th>Phone Number</th>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>

            </html>
        </xsl:template>
        <xsl:template match="customer">
            <tr>
                <xsl:apply-templates/>
            </tr>
        </xsl:template>
        <xsl:template match="customerID|name|addressLine1|addressLine2|addressLine3|phoneNumber">
            <td><xsl:value-of select="."/></td>
        </xsl:template>
	</xsl:stylesheet>
