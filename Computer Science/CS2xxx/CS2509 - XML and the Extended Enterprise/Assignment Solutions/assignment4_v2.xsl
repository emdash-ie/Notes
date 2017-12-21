<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
     xmlns="http://www.w3.org/1999/xhtml">
    <xsl:output method="xml" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
        doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes" media-type="application/xhtml+xml"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Suspicious Customers</title>
            </head>
            <body>
                <table>
                    <tr><th>First Name</th><th>Surname</th></tr>
                    <xsl:apply-templates select="/database/mobilePhoneCustomers/customer"/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="customer">
        <xsl:if test="/database/sims/sim[customerID = current()/customerID]/simID =
            /database/calls/call[countryCodeOfOtherParty = 49
                            and areaCodeOfOtherParty = 31
                            and numberOfOtherParty = 124567]/simID">
            <xsl:choose>
                <xsl:when test="confirmedIdentity = 1">
                    <tr>
                        <td><xsl:value-of select="firstname"/></td>
                        <td><xsl:value-of select="surname"/></td>
                    </tr>
                </xsl:when>
                <xsl:when test="count(/database/sims/sim[customerID = current()/customerID]) = 1">
                    <tr style="color:orange">
                        <td><xsl:value-of select="firstname"/></td>
                        <td><xsl:value-of select="surname"/></td>
                    </tr>
                </xsl:when>
                <xsl:otherwise>
                    <tr style="color:red">
                        <td><xsl:value-of select="firstname"/></td>
                        <td><xsl:value-of select="surname"/></td>
                    </tr>
                </xsl:otherwise>
            </xsl:choose>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>
