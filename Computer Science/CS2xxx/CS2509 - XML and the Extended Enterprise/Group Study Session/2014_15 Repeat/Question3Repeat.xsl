<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
	<xsl:output method="xml" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes" media-type="application/xhtml+xml"/>
	<xsl:template match="/">
		<html>
		<head>
			<title>
				Articles
			</title>
		</head>
		<body>
			<table>
			<tr><th>Title</th><th>Authors</th><th>Date of Publication</th><th>Celebrities Mentioned</th></tr>
			<xsl:for-each select="gossip/articles/article">
				<xsl:sort select="year"/>
				<xsl:sort select="month"/>
				<xsl:sort select="day"/>
				<xsl:sort select="title"/>
				<xsl:variable select="articleID" name="articleID"/>
				<tr>
					<td><xsl:value-of select="title"/></td>
					<td>
						<xsl:for-each select="/gossip/wrote/writing[articleID = $articleID]">
							<xsl:variable select="authorID" name="authorID"/>
							<xsl:value-of select="/gossip/people/person[personID = $authorID]/firstname"/>
							<xsl:value-of select="/gossip/people/person[personID = $authorID]/surname"/>
							<xsl:if test="not(position() = last())">, </xsl:if>
						</xsl:for-each>
					</td>
					<td><xsl:value-of select="year"/>-<xsl:value-of select="month"/>-<xsl:value-of select="day"/></td>
					<td>
						<xsl:for-each select="/gossip/mentionedIn/celebrity[articleID = $articleID">
							<xsl:variable select="celebrityID" name="celebrityID"/>
							<xsl:value-of select="/gossip/people/person[personID = $celebrityID]/firstname"/>
							<xsl:value-of select="/gossip/people/person[personID = $celebrityID]/surname"/>
							<xsl:if test="not(position() = last())">, </xsl:if>
						</xsl:for-each>
					</td>
				</tr>
			</xsl:for-each>
			</table>
		</body>
		</html>
	</xsl:template>
</xsl:stylesheet>