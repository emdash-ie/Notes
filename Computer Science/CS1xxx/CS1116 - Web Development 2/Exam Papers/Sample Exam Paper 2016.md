# Sample Exam Paper

---

## Notes

* There will be two questions in the final exam, and the divide will follow the sample. The first question will be server-side Python and the second question will be client-side Javascript. The first question is more heavily weighted.
* The exam will take the full 90 minutes.
* There is partial credit, so even if you're not sure, write something.
* For each question, read through the full question before starting. There will be many helpful details.
* **Do not write your database details on the exam. This compromises the anonymity of the exam paper and will be reported as an attempt to influence the marker.**
* Sketch an answer before you begin the problem, in pseudocode.
* No marks will be given for sketching, only for code, so don't run out of time while sketching. I.e. rough work will not be marked. If there are bits you can't do, put in a sketch description of the bits.
* You won't lose marks for misremembering names of functions etc slightly (e.g. connection.cursor(db.cursors.DictCursor).
* If you run out of space on a line, continue on the next line.
* Good revision would be to do the lab sheets again.

## Sample Question 1: Server-side

* This year it's about someone running a marathon. There's a database.

### Pseudocode/Solution Notes

	imports - given
	
	print content type, blank line
	
	initialise variables, including form_data, 
		empty string: bandname, gig_date, result
	
	if user has submitted data: (since it's self-processing)  
		bandname - getfirst (escape)
		gig_date - getfirst
		(variable names given by form)
		
		if bandname or gig_date: 
		# only do this stuff if you've been sent one of them
			
			try:
				connect to db & create cursor
				
				if bandname:
					cursor.execute('''SELECT * FROM gigs WHERE bandname = %s''', 												\ (bandname))
					
					if cursor.rowcount == 0:
						result = '<p>Unknown band</p>
				
				if gig_date:
					try:
						valid_date = strptime(gig_date, '%Y-%m-%d')
					except ValueError:
						result = '<p>Invalid date</p>'
				
				if result == '': 
					if bandname and not gig_date:
						cursor.execute('''SELECT * FROM gigs WHERE bandname = %s''', 												\ (bandname))
					
					elif gig_date and not band:
						execute query
					else:
						execute query
						
					result = '<table>'
					for row in fetch all:
						result += ...
					result += '</table>'
			
				close db
			
			except db.Error:
				result = apology
	
	else: print form (given)
	
### Note on getfirst

Use the two-parameter version `getfirst(..., '')` to protect against getting Nonetypes (which cause problems with escape) – it will replace it with the empty string.

### Python

	imports - given
	
	print content type, blank line
	
	form_data = FieldStorage() 
	bandname, gig_date, result = ''
	
	if len(form_data) != 0:  
		bandname = escape(form_data.getfirst('bandname', '').strip())
		gig_date = escape(form_data.getfirst('bandname', '').strip())
		
		if bandname or gig_date: 
		# only do this stuff if you've been sent one of them
			
			try:
				connection = db.connect(…)
				cursor = connection.cursot(db.cursors.DictCursor)
				
				validate bandname (requires checking that it's in the db)
				if rowcount == 0:
					result - error message (invalid band)
				
				validate gig_date
				try
					strptime
				except
					result - error message (invalid date)
				
				if both are ok: (result is still empty)
					if band but no date:
						execute query
					elif date but no band:
						execute query
					else:
						execute query
						
					result = '<table>'
					for row in fetch all:
						result += ...
					result += '</table>'
			
				close db
			
			except db.Error:
				result = apology
	
	else: print form (given)
	
## Sample Question 2: Client-side

* Much less about logic than question 1. More about the javascript.

Three things it could be about:

* Drawing on a canvas with javascript (e.g. a game)
* Talking to a form (like this example)
* Changing html and css (e.g. a slideshow)

### Pseudocode/Solution Notes

	(function() {
		
		vars
		
		document.addEventListener(init...);
			
		function init() {
			querySelectors (#feet, #inches, #metres, #message1, #message2, #form)
			form.addEventListener(submit, convert)
			
		function convert(event):
			feet error message = ''
			get what was typed
			if empty {
				error
			} else {
			if not an integer {
				error
			} else if less than 0 {
				error
			} else if greater than 10 {
				error
			}}
			
			validate inches (similar to above)
			if both are ok {
				convert to metres & display
			}
			event.preventDefault();	
	
	
	
	})();
	
### Javascript

	(function() {
		
		var form_element;
		var feet;
		var message1;
		var inches;
		var message2;
		var metres;
		
		document.addEventListener('DOMContentLoaded', init, false);
			
		function init() {
			feet = document.querySelector('#feet');
			inches = document.querySelector('#inches');
			metres = document.querySelector('#metres');
			message1 = document.querySelector('#message1');
			message2 = document.querySelector('#message2');
			form_element = document.querySelector('form');
			
			form.addEventListener('submit', convert, false);		}
			
		function convert(event):
			var feet_error = '';
			var feet_text = feet.value.trim();
			if (feet_text === '') {
				feet_error = 'Required';
			} else {
				var feet_number = ~~Number(feet_text);
			if (String(feet_number) !== feet_text) {
				feet_error = 'Must be an integer';
			} else if (feet_number < 0) {
				feet_error = 'Must be >= 0';
			} else if (feet_number > 10) {
				feet_error = 'Must be <= 10';
			}
			
			var inches_error = '';
			var inches_text = inches.value.trim();
			if (inches_text === '') {
				inches_error = 'Required';
			} else {
				var inches_number = ~~Number(inches_text);
			if (String(inches_number) !== inches_text) {
				inches_error = 'Must be an integer';
			} else if (inches_number < 0) {
				inches_error = 'Must be >= 0';
			} else if (inches_number > 11) {
				inches_error = 'Must be <= 11';
			}
			
			message1.innerHTML = feet_error;
			message2.innerHTML = inches_error;
			
			if (inches_error === '' && feet_error === '') {
				// convert to metres
				metres.value = (conversion stuff)
			}
			event.preventDefault();	
	
	
	
	})();