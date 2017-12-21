# Guidelines

* recently, the aim is to remind people of certain things, rather than tell them

* some guidelines are about branding as well as usability, e.g. Apple's guidelines

* because guidelines are missing a lot of information, they need to be interpreted carefully

* exam questions in this area are likely to be "here's a guideline, how is this likely to be applied in certain situations?" or "what is this guideline about?"

* guidelines and the use of personas are meant to help you remember

## Schneiderman's Golden Rules

### Strive for Consistency

* greyed out menu options also good for people using screen readers – they can always jump to option number 7, for example

### Cater for Universal Usability

* plasticity – if presenting something in a way that makes sense visually, the same information should be available without seeing the visual representation

### Offer Informative Feedback

* match feedback to the level of the action

    * still feedback for all actions

### Design Dialogs to Yield Closure

* help users to use memory effectively

    * tell people at all stages whether they need to remember stuff or can forget it

    * if users get used to forgetting about stuff when given a dialog that yields closure, they will usually remember stuff until they get that dialog

### Prevent Errors

* this is for errors that can't be tolerated

#### Example: keypad entry

* get users to think about the number in more than one way

    * they're unlikely to make two different mistakes (one each time)

* main solution is to select a range and then enter a fixed number of digits

    * provide reinforcement to different senses also good

### Permit Easy Reversal of Actions

* undo arrived with incremental feedback

* ability to explore without consequence helps you learn faster + better

    * also relieves anxiety

    * parents and kids with video recorders

        * kids have more time

        * kids didn't pay for it

### Support internal locus of control

* users want to feel they're in charge

* some things undermine this, reducing satisfaction and creating anxiety:

    * unexpected changes in the interface state

    * tedious sequences of data entry

        * though sometimes you can't avoid this

    * difficulty obtaining information

* delays above 0.1 s make users feel less in control

* delays above 1 s make users annoyed / frustrated, which reduces quality of work

* delays above 10 s lead to users doing other things while waiting, meaning lack of concentration as well as frustration affects quality of work

    * all of above due to effort of retaining things in short memory for a long time, as well as getting bored

### Reduce short-term memory load

* don't need to worry about long-term memory

* keep displays simple

* consolidate multi-page displays

    * e.g. when comparing two things on a shopping website

    * because then they need to hold a lot of different details in memory

* minimise window changes

* where appropriate, provide access to lists of essential codes, [more here]

## Screen as External Memory

* task status – what stage you're currently at

* details of selected options

* details of rejected options

# Software Accessibility

* W3 accessibility guidelines

* a lot of companies aim to conform to the ADA, as the US government is a very large purchaser of software

    * much legislation also applies to webpages developed for profit

* don't expect all software to be available to everyone (e.g. don't require photoshop for blind people)

    * reasonable steps

## Visual Impairment / Blindness

* need to distinguish between images that are just for decoration and images that contain useful content

    * so that people don't spend ages trying to find out what's in an image when it wasn't important anyway

* valid tabbing order for boxes

1. graphics

2. mouse/keyboard support

3. screen reader compatibility

    * semantic html5 means screen reader always knows where to look for (e.g.) the navbar

## Hearing Impairment / Deafness

* captioning not just transcript, need link with visual events

* separate background and foreground sounds

## Physical Disabilities

* provide shortcuts to overcome keyboard difficulties

* keyboard/mouse/single-switch support

## Speech Impairment

* anywhere speech input is used

## Cognitive and Neurological Disabilities

* navigation

    * e.g. dyslexia – dyslexic people can have difficulty picking important content out when a webpage is content-heavy

* use of language

* flickering or strobing

    * disabling before encountering should be possible

# Software Accessibility (cont.)

## Web Accessibility Initiative

* issued the Web Content Accessibility Guidelines (WCAG)

* html is a good way of presenting information for blind/visually impaired people because of the separation between content and presentation

### 4 Principles

* Everything has to be perceivable

    * users must be able to perceive the information being presented (it can't be invisible to all of *their* senses)

* Operable

    * users must be able to operate the interface (the interface cannot require interaction that a user cannot perform)

* Understandable

    * users must be able to understand the information in the interface (the content or operation cannot be beyond their understanding)

* Robust

    * users must be able to access the content as technologies advance (as technologies and user agents evolve, the content should remain accessible)

    * use stuff that's likely to be supported going forward

### Checkpoints

Each guideline is accompanied by a number of checkpoints which are given priorities:

* if priority 1 are not satisfied, the page will be impossible for some groups of users to access

    * conformance level A means satisfies priority 1 checkpoints

* if priority 2 checkpoints are not satisfied, the page will be difficult for some groups of users to access

    * AA means priority 1 and 2 are satisfied

* if priority 3 checkpoints are not satisfied, the page will be somewhat difficult for some groups of users to access

    * AAA means priority 1, 2, and 3 are satisfied

### Guidelines

Note: these are all priority 1 headings.

#### Perceivable

##### 1.1

Perceivable – 1.1 Provide text alternatives for any non-text content so that it can be changed into other forms people need

* e.g. use `name` and/or `alt` to identify the purpose and/or describe the content of all non-text elements

Exceptions:

* controls/inputs

* time-based media (dealt with elsewhere)

* sensory (any element communicating by other means, e.g. colour)

* captchas (most websites provide audio captchas)

* decoration, formatting, etc. (may function as a distraction – should be clearly labelled or supplied so it's not part of the content of the page)

##### 1.2

Provide alternative for time-based media.

Pre-recorded audio and video material should be accompanied by alternatives that provide the same information through an alternative modality.

Unless the caption is an alternative for text (and is labelled as such), an alternative should be provided that is synchronised with the media.

##### 1.3

Create content that can be presented in different ways without losing information or structure.

* information, structure and relationships conveyed through presentation should be programmatically determinable or available in text

* when the sequence in which content is presented affects its meaning, a correct reading sequence can be programmatically determined

* sensory characteristics: instructions provided for understanding and operating content should not rely solely on sensory characteristics of components such as shape, size, visual location, orientation, or sound.

##### 1.4

Make it easier for users to see and hear content, including separating foreground from background.

* colour should not be used as the only visual means of conveying information, indicating an action, prompting a response, or distinguishing a visual elements

* if any audio on a web page plays automatically for more than 3 seconds, either a mechanism is available to pause or stop the audio, or a mechanism is available to control audio volume independently from the overall system volume level

Information conveyed through colour alone may be missed by:

* people who are colour-blind

* users with monochrome or non-graphical displays

Therefore:

* only use colour for aesthetic effect or to reinforce information presented by other means

* ensure that foreground and background colour combinations provide good contrast when viewed by someone with colour-blindness or when viewed on a black and white screen

You can try:

* using a maximum of six colours plus black & white

* choose colours that offer good contrast

    * there are guidelines showing the intrinsic brightness of different colours

* ensure that colour is only used to provide redundancy by testing the webpage in black and white:

    * take a black and white screenshot of the page – if there is good contrast in it, the colour-contrast is probably good

    * set all colours using a stylesheet and test with a stylesheet that simulates a monochrome display

#### Operable

##### 2.1 Make all functionality available from a keyboard

* all functionality of the content should be operable through a keyboard interface without requiring specific timings for individual keystrokes, except where the underlying function requires input that depends on the path of the user's movement and not just the endpoints

* no keyboard trap – if keyboard focus can be moved to a component of the page using a keyboard interface, then it must be possible to move focus away from that component using only a keyboard interface

    * can happen with e.g. credit card number entering, where if you try to leave the box without entering a number it's flagged as an error and focus is redirected to the box again

##### 2.2 Provide users enough time to read and use content

* if a time limit is set by the content, ensure at least one of the following is true:

    * the user is allowed turn off the time limit before encountering it

    * the user is allowed to adjust the time limit before encountering it over a wide range that is at least ten times the length of the default setting

    * the user is warned before time expires and given at least 20 seconds to extend the time limit with a simple action (for example by pressing the space bar), and the user is allowed to extend that time limit at least ten times

* this may apply e.g. with time limits for discounts or buying tickets

* time-based media may cause problems - screenreaders are event driven, and may report every clock tick to the user if there's a clock created

* for moving, blinking, scrolling, or auto-updating information, ensure all of the following are true:

    * anything that starts automatically, lasts more than five seconds, and is presented in parallel with other content has a mechanism for the user to pause, stop, or hide it

    * for any auto-updating information that starts automatically and is presented in parallel with other content has a mechanism for the user to pause, stop, or hide it, or to control the frequency of the update

[check these]

##### 2.3 Do not design content in a way that is known to cause seizures

Web pages should not contain anything that flashes more than three times in any one-second period.

* guidelines are actually more complicated than this

##### 2.4 Provide ways to help users navigate and find content

A mechanism should be available to bypass blocks of content that are repeated on multiple web pages.

* html5 makes this easier

Web pages should have titles that describe topic or purpose.

* may save people time, replace glancing

If a web page can be navigated sequentially and the navigation sequences affect meaning or operation, focusable components receive focus in an order that preserves meaning and operability.

I should be possible to determined the purpose of each link from the link text alone or from the link text together with its programmatically determined link context.

Examples:

* title each frame to facilitate frame identification and navigation

* use `optgroup` to group `option` elements inside a `select`

* group form controls with `fieldset` and `legend`

* use nested lists where appropriate

    * screenreaders can look just at the top-level, for example

* use headings to structure documents, etc.

#### Understandable

##### 3.1 Make text content readable and understandable

It should be possible to programmatically determine the default human language of each web page.

For example:

* specify the language of the document so that automatic content-retrieval systems can locate documents in the required language

* identify sections (e.g. quotes, captions) in different languages by using the `lang` attribute so that speech-synthesisers etc. can adjust accordingly

##### 3.2 Make web pages appear and operate in predictable ways

* when any component receives focus, it does not initiate a change of context

* changing the setting of any user interface component should not automatically cause a change of context unless the user has been advised of the behaviour before using the component

* if sighted, you can immediately see what's changed – not so if relying on a screenreader

##### 3.3 Help users avoid and correct mistakes

* if an input error is automatically detected, the item that is in error should be identified and the error described to the user in text

* labels or instructions should be provided when content requires user input

* e.g. use labels for your inputs that are linked in the code

#### Robustness

##### 4.1 Maximise compatibility with current and future user agents, including assistive technologies

* in content implemented using markup languages, elements should:

    * have complete start and end tags

    * be nested according to their specifications

    * not contain duplicate attributes

    * where IDs are used, they should be unique

* name, role, value: for all user interface components:

    * it should be possible to determine the name and role programmatically

    * is should be possible to set states, properties, and values programmatically

    * notification of changes to these items should be available to user agents, including assistive technologies

### Summary

* just because a page is accessible doesn't mean it's usable
