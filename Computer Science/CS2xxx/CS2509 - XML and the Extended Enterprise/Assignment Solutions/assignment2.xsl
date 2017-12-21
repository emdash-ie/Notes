<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
        doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes"/>
    <xsl:template match="/">
        <html xmlns="http://www.w3.org/1999/xhtml">
            <head>
                <title>Unconfirmed Customers</title>
            </head>
            <body>
                <table>
                    <thead>
                        <tr><th>First Name</th><th>Surname</th><th>County</th></tr>
                    </thead>
                    <tbody>
                        <xsl:apply-templates select="/database/mobilePhoneCustomers/customer">
                            <xsl:sort select="countyName" order="ascending"/>
                            <xsl:sort select="surname" order="ascending"/>
                            <xsl:sort select="firstname" order="ascending"/>
                        </xsl:apply-templates>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="/database/mobilePhoneCustomers/customer">
        <xsl:if test="confirmedIdentity = 0">
            <tr>
                <td><xsl:value-of select="firstname"/></td>
                <td><xsl:value-of select="surname"/></td>
                <td><xsl:value-of select="countyName"/></td>
            </tr>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>
