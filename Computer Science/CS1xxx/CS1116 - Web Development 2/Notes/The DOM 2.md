# The DOM (2)

---

## Recap

* To find nodes: `querySelector`, `querySelectorAll`
* To create new element nodes: `document.createElement`
* To create new text nodes: `document.createTextNode`
* To insert an extra child node: `appendChild`
* To change the text of a text node: assign to `nodeValue`
* To change the value of an attribute of an element node: assign to an element node's properties

## Changing an Element's CSS in JavaScript

JavaScript can retrieve and change an element's CSS by accessing and setting properties of its `style` object.

Example:

	some_node.style.color = 'blue'
	some_node.style.fontStyle = 'italic'
	some_node.style.border = "1px solid black"

**Note** that if something in CSS has a hiphen in the name (e.g. background-color), the hiphen is removed and the next letter is capitalised (e.g. backgroundColor).

### HTML5 and the `div` Tag

* Reminder that `<div>` is discouraged in HTML5, and instead should be used by e.g. `<section>`, etc. when appropriate.

## Slideshow Example

### Display

* = inline — the element doesn't force start on a new line and takes only the width it needs
* = block — the element starts on a new line and takes the full width available
* = none — the element isn't displayed and takes up no space

### Visibility

* = hidden — the element isn't displayed but takes up space as normal
* = visible — the element is visible

### Limitation

* You can only do one slideshow per page with this code. Major limitation.

## CSS vs. JavaScript

You can do a lot with CSS. You don't always need JavaScript.

