# XHTML

---

## Overview

XHTML is one of the many XML-based languages that have been defined. It is a cleaned up version of HTML, reformulated using XML DTD technology.

There are three XHTML DTDs (corresponding to the three versions of HTML 4):

* Strict (should be used when rendering is controlled by CSS)
* Transitional (to be used for browsers that do not support CSS)
* Frameset (allows the use of `<frame>` tags due to popular demand)

It's designed to be compatible with XML-oriented user-agents, as well as HTML 4-oriented user agents.

## XHTML vs. HTML

* An XHTML document must be a well-formed XML document and must be valid according to one of the DTDs listed above.
	* It must contain one root element.
	* The root element must be delimited by `<html>` and `</html>` tags.
	* All XHTML tags and attributes must be in lower case.
	* Every non-empty element must have start and closing tags.
	* The start tag for an empty element must have a final `/`.
	* Elements must be properly nested.
	* Attribute values must be quoted.
	* Attributes must have values.
* CSS and JavaScript in the file must be escaped using CDATA tags as they're not XML:

		<style>
		<![CDATA[
			body {background-color:white;}
		]]>
		</style>