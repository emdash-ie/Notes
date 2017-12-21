# Taking User Input

(E.g. the currency converter from before)

### The form

The user submits data through a form, then the program runs on the server, and the response to the user comes from the program.

Example form:

	<form action="response.py" method="get">		<input type="text" name="firstname" id="firstname">		<input type="text" name="surname" id="surname">		<input type="submit" value="Go!">	</form>
This produces this result:
<form action="" method="get">	<input type="text" name="firstname">
	<input type="text" name="surname">	<input type="submit" value="Go!"></form>
##### Notes:
* You can label the boxes using `<label>`, but you need an id attribute for each input so you can make a label for it.
* You can use the placeholder attribute to display label text in the box, that is then overwritten on input. This is useful for small screens.
* You can use set the disabled attribute to prevent a user from entering text into that input. This can be handy for displaying output in a form.