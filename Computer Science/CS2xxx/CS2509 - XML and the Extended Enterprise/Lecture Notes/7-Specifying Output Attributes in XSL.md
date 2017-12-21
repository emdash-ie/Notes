# Specifying Output Attributes in XSL

---

## Motivating Example

Take this XML document:

	<?xml version="1.0"?>
	<people>
		<person>
			<name>fred</name>
			<url>http://fred.com</url>
		</person>
		<person>
			<name>tom</name>
			<url>http://tom.com</url>
		</person>
	</people>
	
We want to generate a HTML table where the urls are used as the href attributes in `<a>` elements.

### Mistaken Approach

We might use an `<xsl:value-of>` statement in the href attribute, but this won't work – text in the quotes required for the href attribute will be treated as plain text and won't be evaluated. The browser will complain about ill-formed XHTML.

	[…]
	<a href="<xsl:value-of select="./url"/>">
	[…]

## First Approach

Use the stylesheet as follows:

	<a>
		<xsl:attribute name="href">
			<xsl:value-of select="./url"/>
		</xsl:attribute>
		<xsl:value-of select="./name"/>
	</a>

You use an `<xsl:attribute>` element for each attribute that you want to specify.

Any `<xsl:attribute>` elements used must come before any other content in the parent element.

## Alternative Approach

Use escape braces.

	<a href="{href}">
		<xsl:value-of select="name"/>
	</a>