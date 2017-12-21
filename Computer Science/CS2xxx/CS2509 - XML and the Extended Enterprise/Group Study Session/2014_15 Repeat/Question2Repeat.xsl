<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="xml" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes" media-type="application/xhtml+xml"/>
	<xsl:template match="/">
		<html>
		<head>
			<title>
				People
			</title>
		</head>
		<body>
			<table>
			<tr><th>Surname</th><th>First Name</th><th>Photograph</th></tr>
			<xsl:for-each select="gossip/people/person">
				<xsl:sort select="surname"/>
				<xsl:sort select="firstname"/>
				<xsl:sort select="personID"/>
				<tr>
					<td><xsl:value-of select="surname"/></td>
					<td><xsl:value-of select="firstname"/></td>
					<td><xsl:value-of select="personID"/></td>
					<td>
						<img>
							<xsl:attribute name="src">
							<xsl:value-of select="photo"/>
							</xsl:attribute>
						</img>
					</td>
				</tr>
			</xsl:for-each>
			</table>
		</body>
		</html>
	</xsl:template>
</xsl:stylesheet>