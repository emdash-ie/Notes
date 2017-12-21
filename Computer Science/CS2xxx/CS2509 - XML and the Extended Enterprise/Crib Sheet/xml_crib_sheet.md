# XML Crib Sheet

## XML Doctype

	<!DOCTYPE people SYSTEM "personnel2.dtd">

## Version Type

	<?xml version="1.0" encoding="utf-8"?>

## Stylesheet Tag (for outputting XHTML)

	<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
	     xmlns="http://www.w3.org/1999/xhtml">	
	     
## Output Tag (for outputting XHTML)

    <xsl:output method="xml" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
        doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" indent="yes" media-type="text/html"/>
        
## 	Sort Tag

	<xsl:sort
		select = string-expression
		lang = {nmtoken}
		data-type = {"text"|"number"|qname-but-not-ncname}
		order = {ascending|descending}
		[…]
	/>
	
## Call Templates

	<xsl:call-template name="show_item">
		[parameters]
	</xsl:call-template>
	
### Parameters

This goes in the call-template instruction:

	<xsl:with-param name="thisNum" select="./@num"/>
	
This goes at the start of the template:

	<xsl:param name="num"/>
	
Names are irrelevant – parameters are specified positionally.

## Attributes

	<xsl:attribute name="href">
		[value of attribute]
		[…]
	</xsl:attribute>
	
The attribute tag must come before any other content in its parent.

### Alternative

Escape braces:

	<a href="{href}">
		[…]
	</a>