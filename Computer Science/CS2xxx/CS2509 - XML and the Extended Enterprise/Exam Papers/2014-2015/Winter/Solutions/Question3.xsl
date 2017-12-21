<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="xml" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes" media-type="application/xhtml+xml"/>
	<xsl:template match="/">
		<html>
		<head>
			<title>
				Song Information
			</title>
		</head>
		<body>
			<table>
			<tr><th>Title</th><th>Composer</th><th>Lyricist</th><th>Number of recordings</th></tr>
			<xsl:for-each select="bodhran/songs/song">
				<xsl:sort select="title"/>
				<xsl:variable select="composerID" name="composerID"/>
				<xsl:variable select="lyricistID" name="lyricistID"/>
				<xsl:variable select="songID" name="songID"/>
				<tr>
					<td><xsl:value-of select="title"/></td>
					<td><xsl:value-of select="/bodhran/people/person[personID = $composerID]"/></td>
					<td><xsl:value-of select="/bodhran/people/person[personID = $lyricistID]"/></td>
					<td><xsl:value-of select="count(/bodhran/recordings/recording[songID = $songID])"/></td>
				</tr>
			</xsl:for-each>
			</table>
		</body>
		</html>
	</xsl:template>
</xsl:stylesheet>