<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="xml" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes" media-type="application/xhtml+xml"/>
	<xsl:template match="/">
		<html>
		<head>
			<title>
				Number of Recordings
			</title>
		</head>
		<body>
			<table>
			<tr><th>Name of singer</th><th>Number of recordings</th></tr>
			<xsl:apply-templates select="/bodhran/people/person">
				<xsl:sort select="surname"/>
				<xsl:sort select="firstname"/>	
			</xsl:apply-templates>
			</table>
		</body>
		</html>
	</xsl:template>
	<xsl:template match="person">
		<xsl:variable select="personID" name="ID"/>
		<tr>
			<td><xsl:value-of select="firstname"/></td>
			<td><xsl:value-of select="count(/bodhran/recordings/recording[singerID = $ID])"/></td>
		</tr>
	</xsl:template>
</xsl:stylesheet>
<xsl:stylesheet [...] xmlns="http://www.w3.org/1999/xhtml">
	<xsl:template match="/">
		<html>
		<head>
			<title>
				Number of Recordings
			</title>
		</head>
		<body>
			<table>
			<tr><th>Name of singer</th><th>Number of recordings</th></tr>
			<xsl:for-each select="/bodhran/people/person">
				<xsl:sort select="surname"/>
				<xsl:sort select="firstname"/>
				<xsl:variable select="personID" name="ID"/>
				<tr>
					<td><xsl:value-of select="firstname"/></td>
					<td><xsl:value-of select="count(/bodhran/recordings/recording[singerID = $ID])"/></td>
				</tr>
			</xsl:for-each>
			</table>
		</body>
		</html>
	</xsl:template>
</xsl:stylesheet>