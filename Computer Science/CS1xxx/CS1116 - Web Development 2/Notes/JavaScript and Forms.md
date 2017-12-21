# JavaScript and Forms

---

### &lt;span&gt; Tag

Similar to div but used on bits of text, rather than bits of space. Its use in HTML 5 is supposed to be just for when no other tag (e.g. em, strong) seems appropriate.

## Combining Server- and Client-Side

We use a python program on the server side, and a javascript program on the client side.

We have to do the validation on both the client and server sides.

* The user could have javascript disabled, which is why we need to check again on the server side. 
* They could also screw with the javascript, since it's stored on their end. 
* Finally, they could send data by typing into the URL, which will not be handled by the javascript.
* It's advantageous to do it client-side to prevent excess communication/traffic to our server. Speeds it up, too.

The python code is as normal, except that we also include a &lt;script&gt; tag in the page that is output through the print statement.

### The JavaScript (Version 2)

We use an event listener on the form (`form_element.addEventListener('submit', validate_input, false);`) to detect when the user submits the data through the form, at which point we run a function to check the input.

Checking for an integer in JS is very difficult. His two lines of code work, but it's awful. We don't need to understand this (and he didn't really explain it, except that it's the best he's got - he hates javascript):

	var number = ~~Number(trimmed_text);
    if (String(number) !== trimmed_text) {
        return "Must be a whole number";

The following code prevents the form from being submitted, as we don't want erroneous data to be sent to the server:

	if (feet_msg || inches_msg) {    
            event.preventDefault();
        }
        
The `preventDefault()` method can be run on any event, e.g. to stop the user from scrolling by preventing the scrolling events from causing scrolling, or prevent clicking on hyperlinks from opening the page.

### Version 3

We now use event listeners to do the validation as you type. When the user clicks into the next box, the validation is run:

	feet_input.addEventListener('change', validate_input, false);
    inches_input.addEventListener('change', validate_input, false);
    
The event 'change' is when the data is put into the box.

### Version 4

We can get rid of the python program and do all the calculations (and validation) on the client side in the javascript program.

Note that we use `preventDefault()` all the time now, because we no longer want to send any data using the form. We also have no action, so we could probably leave this line out.

Cost/benefit:

* Compared to version 2, we now send more data if we use the form once, because we have to send the program, which is bigger than the data.
* However, if we use the form multiple times, we don't retrieve the form each time, so we make a huge save here.

We must use a server-side approach:

* If we need to work with a database, which will be stored on the server.