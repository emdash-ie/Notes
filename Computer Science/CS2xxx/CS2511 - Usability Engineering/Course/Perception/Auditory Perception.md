# Auditory Perception

Like the visual system, the human auditory system can be divided into two stages:

* physical reception of sounds
* processing and interpretation

Like the visual system, the auditory system has strengths and weaknesses:

* certain things can't be heard even when present
* processing allows sounds to be constructed from incomplete information
    * e.g. the fundamental of a bass instrument

Sound has pitch, timbre, and loudness.

## Pitch

We talk about JND again with pitch (just noticeable difference). This is pretty constant for pitch but varies for frequency because of the logarithmic scale.

## Loudness

We adapt to loudness, so it's not a good cue.

Human beings are very poor at judging the loudness of sounds that are heard for less than 0.2 seconds. These sounds seem much quieter than they are.

Perceived loudness varies with frequency (strongest in the centre).

## Timbre

The timbre of a sound is determined by the relative level of its harmonics and by its amplitude envelope (the way in which the amplitude varies over the time). The envelope helps us distinguish between instruments with similar harmonic content.

## Localisation of Sound Sources

* Stereo hearing allows us to locate the source of a sound by comparing the sound at each ear
    * we compare amplitude between each ear (interaural intensity)
    * also compare time of arrival (interaural delay)
        * we can recognise differences of 10 microseconds or less between the time of arrival of a sound at each ear
    * stereo hearing works in the horizontal plane only and is least effective in the middle range of audible frequencies
* Head movement allows us to improve the localisation accuracy of stereo hearing
    * localisation accuracy better for non-musical sounds
    * localisation best straight ahead and straight behind
        * front-back reversals happen but are less common for clicks and noises
    * localisation varies with frequency
        * good below 1000 Hz, based on timing/phase differences
        * poor between 1000 and 3000 Hz
        * good above 3000 Hz, based on intensity differences
* Analysis of reflected versus direct sound yield information about the route a sound has travelled to reach us.
* Familiarity / pattern-matching affects localisation accuracy – both ways
    * e.g. we see a ventriloquist's dummy's mouth move and assume the sound is comping from there

## Vertical Localisation

Research has shown the the average listener can reliably distinguish only three vertical source locations.


### Distance

Judgment of distance is based partly on intensity – the quieter the sound, the further away the source.

Distance also affects:

* The audio spectrum of the sound – some frequencies travel better than others
    * bass frequencies don't travel very well
* The balance between reflected and direct sound – the further the sound has travelled, the more likely it is to include a significant percentage of reflected components

### Head-Related Transfer Functions

Sound localisation can be improved by tailoring the sound distribution.

Ideally, HRFTs should be tailored to suit the individual. However, this is complex and costly.

Researchers are currently trying to develop non-individualised HRTFs which will give a useful improvement in localisation accuracy for a substantial percentage of the population.

## Sensory memory for Audio

As with other senses, it appears that there is a sensory memory associated with the hearing system – the echoic memory.

It stores the last few seconds of incoming sound, in its raw form. There's disagreement as to how long the store is, but studies agree that there's a store.

## speech and Non-Speech Sound

Research suggests that the human hearing system responds differently to speech than to other sound.

## Summary

Human beings are good at:

* Detecting changes in pitch, and distinguishing between differing successive pitches
* recognising and distinguishing between rhythmic structures
* recognising and distinguishing between familiar timbres
* localising the source of low-pitched and high-pitched sounds in the horizontal plane

We're bad at:

* recognising absolute pitches, or distinguishing between different pitches presented at significantly different times
* detecting changes in loudness (unless the changes are huge)
* recognising and distinguishing between unfamiliar timbres
* localising the source of mid-pitched sounds in the horizontal plane
* localising the source of all sounds in the vertical plane

## Applications

In mainstream computing, sound is rarely used as a primary means to communicate information.

It is used mainly for:

* simple warnings (success, failure, etc.)
* to make educational applications more engaging
* in entertainment […]

[…]

Sound is used more extensively in a number of specialised fields, including:

* applications for blind and visually-impaired people
* hands-free/eyes-free applications

Sound has been used in interfaces in a number of ways. Synthetic speech is easy to use, and its meaning is immediately obvious.

But speech is a relatively slow method of presenting information and places a heavy load on cognitive resources.

Two different approaches have been developed:

* Auditory icons are based on natural sounds, and are intended to be instantly recognisable to the user.
    * However, it can be difficult to find appropriate sounds to represent many functions.
* Earcons are musical motifs, etc., which are structured so as to convey information. This overcomes the problem of associating sounds with functions, but the user has to learn the meanings of the earcons in each application.
    * e.g. a particular rhythm means one thing, a particular timbre means another thing

A newer idea is speech-earcons (Spearcons):

* Spearcons use speech which has been speeded-up until it is only just recognisable.
    * users can initially identify the meaning of a spearcon by listening carefully to the speech
    * however, as they learn the meaning of each spearcon, they can ignore the speech content and treat it as non-speech sound
        * this involves much less cognitive effort.

## Applications

TIDE Maths projects used sound to help blind people work with mathematical equations:

* 3D sound projection was used to place each term of a polynomial expression at a unique position in space
* To avoid overloading the user with sounds, each expression had a characteristic 'background' sound which it made when not selected
    * e.g. the same sound but muffled/mumbled
* When selected, the term would be spoken out, with non-speech sound used to indicate parentheses, grouping, etc.
    * e.g. tone for each parenthesis and a continuous tone inside the pair

Placing things in 3D space allowed users to employ spatial memory rather than relying solely on short-term memory.

In one implementation, the terms could be manipulated using a data glove. This further improved performance, perhaps because it allowed use of both spatial and haptic/kinaesthetic memory.
