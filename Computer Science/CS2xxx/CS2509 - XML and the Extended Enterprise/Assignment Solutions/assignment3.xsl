<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
     xmlns="http://www.w3.org/1999/xhtml">
    <xsl:output method="xml" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
        doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes" media-type="application/xhtml+xml"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Customers with Multiple SIM Cards</title>
            </head>
            <body>
                <table>
                    <tr><th>First Name</th><th>Surname</th><th>No. of SIM Cards</th></tr>
                    <xsl:apply-templates select="/database/mobilePhoneCustomers/customer"/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="customer">
        <xsl:variable name="sim_count" select="count(/database/sims/sim[customerID = current()/customerID])"/>
        <xsl:if test="$sim_count > 1">
            <tr>
                <td><xsl:value-of select="firstname"/></td>
                <td><xsl:value-of select="surname"/></td>
                <td><xsl:value-of select="$sim_count"/></td>
            </tr>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>
