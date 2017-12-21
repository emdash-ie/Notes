# Haptic Perception

General term covering various forms of perception based on touch.

Visual and auditory perception are associated with specialised organs groups in a small area.

By contrast, haptic perception takes place all over the body, and the various parts of the body differ considerably in their response to pressure, etc.

There are three types of sensory receptor in the skin:

* thermoreceptors which respond to heat and cold
* mechanoreceptors which respond to pressure
* nociceptors respond to intense heat, pressure, or pain

In computing applications, we are mostly concerned with mechanoreceptors.

We have two types of mechanoreceptors:

* rapidly-adapting
    * these react to rapid changes in pressure but do not respond to continuous pressure
* slowly-adapting
    * these respond to continuous pressure

Sensitivity is greatest when both types of mechanoreceptors are stimulated – you can do this by having a pressure that's changing slightly.

## Sensory Acuity

What's the smallest distance apart you can detect two points of pressure?

This is measured using the two-point test – press two small points against the body and move them further apart until it becomes possible to feel two distinct pressure points rather than one. The smaller the distance at which both points can be detected, the greater the sensory activity.

The fingers and thumbs have the greatest acuity. The distance on the fingers is around 10 times smaller than on other parts of the body, such as the arms.

Sensory acuity varies considerably among individuals – it can be improved with training, within certain limits. Blind people who read Braille generally have better sensory acuity than non-Braille readers.

## Kinaesthetic Feedback

Kinaesthetic receptors in our joints and muscles tell us where our limbs, fingers, etc. are relative to the rest of our body.

This is important in many rapid actions, e.g. typing or playing a musical instruments.

Kinaesthetic receptors are of three types:

* rapidly-adapting
    * respond only to changes in the position
* slowly-adapting
    * respond to both changes in position and to static position
* static
    * respond only to static position of limbs

## Haptic Memory

As with auditory perception, we have a short-term sensory memory for haptic experience.

It functions in a very similar way to the auditory store:

* haptic events are stored as they are experienced
* new experiences replace older ones in the memory
* if no new haptic events are experienced, previous events remain in the store

## Some Applications

The Optacon is a tactile reading device developed for use by blind people:

* 144 pins arrange in a 24 x 6 grid
* each pin is driven by a miniature solenoid, allowing it to be raised or lowered
* the source material is scanned using a video camera
* the image is converted into a tactile display on the pins

The Optacon was very successful, despite the amount of learning required.

It works best when the camera is moved steadily across a passage of text, thus producing slow but continuous movement of the pins.

This stimulates both slowly-adapting and rapidly-adapting mechanoreceptors.

Users find it much harder to identify an image if the camera is held still (though it may be desirable with a complicated image).

Numerous attempts have been made to use haptics to enable a blind user to explore a GUI.

One solution is a refreshable, tactile display, comprising a grid of moving pins (e.g. one for each pixel).

Then the pins could present both images and text (either directly or as Braille).

Such displays have been developed, but are very expensive and little used.

They're good for diagrams and maps, but not great for GUIs that need to be navigated. There's no colour, and if an event happens on a part of the screen you're not currently touching, you'll miss it.

Tactile displays are dropping in price a lot, and will probably be used in future.

### Braille Mouse

This is an alternative to the big displays – whatever's under the cursor is presented to the user on the top of the mouse.

The mouse is usually constrained within a frame which represents the edges of the screen so you can tell where you are on the screen.

Another option is to separate the mouse and the tactile display – one hand can be used to navigate the display while the other rests on a feedback device. An example of this is the Moose. Alerts etc. can be immediately transferred to the feedback device, as is possible with the braille mouse.

### Touch Screens

* No physical buttons to guide the fingers, only visual buttons/icons
    * presents problems for blind people

One solution is to use vibration feedback to indicate movement over virtual boundaries between buttons.

This approach can also be used to convey information to sighted people in 'eyes busy' applications.

This approach works well – people rapidly adapt to it and feel a keyboard that isn't there.

### Resistance

* provision of force-feedback to simulate resistance
    * e.g. in servo-controlled systems

Early aircraft used cable of hydraulic controls which provided a two-way link between the joystick and the control surfaces (wing-flaps etc.). In servo-controlled systems, the joystick just sends signals – they are one-way only.

Mod

### Three-dimensional Virtual Objects

* Prices has come down from thousands to a few hundred
