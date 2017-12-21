# Misc Info

---

## A Note on Using `xsl:value-of`

The node-list selected by the select attribute may contain more than one node.

In this case, only the first node will be evaluated.

### Example

	<xsl:value-of select="//person"/>
	
The select attribute here will match all descendant nodes of the current node which are people nodes. However, only the string value of the first node in the list of descendant person nodes will be output.

## `<` and `<=` Operators

You can't use `<` or `<=` as operators, as they will confuse the parser, which will think they're a start tag. Instead, you must use the entities `&lt;` and `&le;`. `>` and `>=` are fine.

## Content-Types

If generating xml from a python program, the content-type should be application/xml.