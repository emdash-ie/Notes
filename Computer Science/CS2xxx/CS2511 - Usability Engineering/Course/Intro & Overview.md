# Brief History

## Early Computers

The earliest computers were experimental, and were programmed and operated by the people who designed and built them. It was impossible to use them without knowing a lot about their internal structure.

Binary code was used for input and for output (bright light is a 1, dull light is a 0).

There was very little distinction between operation and programming – no long-term storage of programs.

## Mainframes

Large mainframes were the next generation – they were programmed and operated by highly trained staff. No-one except them had access to the computer.

A command language was used for control, and printed output could be formatted as required.

* Computers were expensive and relatively rare, so it was important to use them at maximum potential. You couldn't afford to let them be idle.

* Entering code online would be too slow, so they were batch-programmed.

    * Tasks were prepared offline

    * Batches loaded and run in sequence

    * Operator intervention was just running batches and getting things back working.

    * No interaction while a batch was running

## Terminal-and-Server or Desktop Systems

These were programmed and operated by trained staff.

* A command language used for control

* Printed output could be formatted as required, and the screen display could be formatted to some extent.

* Lots of training was involved for office workers to use them.

In order to use a command language effectively, the operator must know a large number of commands and the correct syntax for use with each of them. Psychologists were employed to help create command-sets that were easy to remember. They developed the first guidelines for user-interface design:

* Use memorable command names
* Keep command names short
* Use consistent syntax where possible

While command languages within a company were pretty consistent, UNIX at the time was very inconsistent, because the whole idea was that different organisations could contribute commands.

## Difficulty

Still, even well-designed command-languages are difficult to learn. In the 1960s, a number of researchers set out to improve this.

A key problem with command languages is that they rely heavily on recall. Psychological research suggests that humans are better at recognition than recall.

Recognition requires less mental effort than recall, and is about twice as fast and three times as accurate (Nobel, 2001). This has been well-known since about the 1930s.

We can see this in facial recognition, or recognition of things in photos.

## Short-Term Memory

Human short-term memory is also quite limited. We can only hold a few items in memory at any one time. This makes it difficult to perform mental operations that involve more than a few pieces of data. Think of comparing different computers with all their info and prices.

However, such tasks become much easier if we write the data down or display it on a screen.

## Spatial Memory

Human beings have excellent spatial memory. It's hard to define, but for example if we're distracted from reading something, when we come back we can easily remember which part of the page we were on. This is tied into pattern recognition (a mix of upper and lowercase letters makes this easier).

Recalling where an item is displayed typically requires less memory than recalling what information it contains.

So the challenge facing researchers was to:

* Reduce reliance on recall
* Support recognition wherever possible
    * e.g. by using the screen as a form of external memory

## Direct Manipulation

Ben Shneiderman (in 1982) analysed a number of graphical interfaces and concluded that the features that made them successful were:

* Visibility of objects
* Replacement of complex command-languages with actions to manipulate visible objects directly
* Incremental action at the interface with rapid feedback
    * E.g. something moving as you drag it
* Reversibility of actions
    * We expect an "undo" for everything, but it wasn't common in the past
    * Follows from incremental action with rapid feedback
    * Once you know there's no danger and you can undo everything, you're encouraged to explore, and learn by playing
* Syntactic correctness of actions (every action is legal)
    * Illegal actions were made difficult to do, and things were greyed out to show that they weren't desirable actions
* Few/no changes of mode
    * E.g. different modes in a text editor
    * When modes existed, they should be visually signalled (e.g. with a different cursor)

He coined the term Direct Manipulation to describe the style of interaction supported by such interfaces.

## Modern

GUIs supporting Direct Manipulation are still the basis of most contemporary computing.

Direct Manipulation has also been extended to accommodate new interaction technologies such as touch-screens and 3D navigation and display.

However, we're moving into new eras – speech, auditory, and gestural interaction don't suit the concept of Direct Manipulation as well.

Efforts to use such technologies effectively are driving the development of new interaction styles.

## Summary

* Early Computers
  * Minimal interaction
  * Little distinction between operation and programming
    * Lots of expertise required for all use
  * All interaction based on computer's requirements
    * e.g. binary output
* Modern Computers
  * Extensive interaction
  * Control, authoring, scripting, programming, etc.
    * Many different levels of expertise supported
  * Interaction increasingly based on user's requirements

# Evolution of Interaction

Driving Factors:

1. Reductions in cost and size
2. Need to support a wide range of users
3. Application to a wider range of tasks
4. Development of new interaction techniques

## Reductions in Cost and Size

Early computers were expensive, and so had to be used to full potential. There was little need or opportunity for interaction.

Modern computers are small and cheap, which allows each user to have many computers. Computers are mostly idle.

## Need to support a wide range of users

Early computers could only be operated by highly-trained staff.

Modern computers are used by a wide range of people with varying needs:

  * novices and experts
  * frequent and occasional users
  * users with special needs

Improvements in accessibility are increasingly being driven by legal requirements, e.g. the Americans with Disabilities Act, the UN Convention on the Rights of Persons with Disabilities.

## Application to a wider range of tasks

Early computers were used for a limited range of tasks.

Modern computers used for a wider range of tasks:

* Casual/occasional tasks for which training is not feasible

    * It's not reasonable to expect people to become expert at using every application they encounter, particularly applications they use infrequently.

        * It is easy enough to support occasional/non-expert users in simple tasks.

        * It is more difficult to support occasional/non-expert users in complex tasks.

    * Web applications and smartphone apps are becoming as sophisticated as stand-alone applications.

        * However, users have little commitment to individual applications.

        * They are unlikely to read complex instructional material, and if they find a site complex or difficult they'll go elsewhere

* We're increasingly using software in place of people.

* Safety-critical control applications

    * Computers are widely used in military/aircraft systems, medical systems, plant control (nuclear/chemical/etc.)

    * Even highly trained staff make mistakes, so software has to be designed to prevent mistakes wherever possible.

* Games and other entertainment applications

* Hands-free applications

## Development of new interaction techniques

* touch screens (including multi-touch screens), 3D displays
* joysticks, 3D mice, and other input devices
* speech synthesis and recognition
* tactile feedback devices
* spatial and other auditory displays
* image recognition, eye-tracking, movement tracking, etc.

# The Future

In the future, it is likely that human-computer interaction will become more like human-human interaction:

* proactive rather than reactive
    * e.g. if you're speaking to someone, they're usually anticipating your needs at that moment
    * we don't tell people things we think they already know
    * in speech, both sides are equal participants
* context-aware
    * if you make the same mistake several times with a computer you get the same message
    * with a person, they'll realise they're not getting through to you and will change what they're saying
* adaptive
    * rather than work the same way for everyone, software changes to deal with different people
    * e.g. e-learning – does this learner work better with pictures or text?

## Reactive vs. Proactive Systems

### Proactive

* systems or user can initiate actions
* user attention is elsewhere (hands-free, eyes-free)
* context-aware
* adaptivity essential for effective operation

### Reactive

* user always initiates actions
* computer is focus of user attention
* context-free
* little need for adaptability

# Usability Engineering

## Accessibility

Some users may have special needs. Software should be designed so that users with special needs can use it as easily as other users can, but this is difficult to achieve.

For example, people who are blind/visually-impaired can operate GUIs with the help of a screen reader. However, screen-reader users tend to:

* work more slowly
* make more errors
* report higher levels of fatigue

Giving users with special needs the same level of access as other users is a major challenge.

Wherever possible, users should be able to enter data and receive feedback in a form that is natural and appropriate to the task at hand.

## Summary

A good interface should:

* be as easy to learn and remember as possible
    * but sometimes learning new skills is unavoidable or desirable
* contain functions that are genuinely useful
    * exclude functions that increase complexity without improving utility
    * offer sufficient flexibility to cope with changing work-patterns
* enable users to work efficiently
    * it should be possible to achieve goals quickly and with few errors
    * may want low throughput but low number of errors made
* be easy and pleasant to use
    * not place a high cognitive load on the user
    * allow the user to feel in control

Users:

* may have a very different view of that task/application domain from our own

* may differ considerably - we may have to design with several distinct groups of users in mind

* may change in their abilities/requirements while using the software

* may give all of only part of their attention to a task

* may vary in their motivation

* may be using a system for themselves of on behalf of somebody else

* will find the system more efficient and pleasant to use if we minimise the amount of translation required at the interface

# Key Skills/Knowledge in HCI

* Interaction styles
    * e.g. direct manipulation
* Interaction technology
    * e.g. a mouse is the best compromise
* Human psychology/perception/etc.
    * memory
    * perception of colours
* Design/Evaluation techniques
    * guidelines
        * Some people think guidelines are useful, some think they're unhelpful
    * metrics
        * used as soon as possible in the creation of something
    * modelling
        * can be done before investing time and effort into something
    * iterative design and evaluation

## Interaction Styles

* Command language
* Form filling
* Menu selection
* Function keys
* Question and answer
* Direct manipulation
* Anthropomorphic / natural language

## Interaction Technologies

* Input
    * pointing/selection (mouse, joystick, touchscreen, eye-gaze)
    * text entry (keyboard, keypad, speech)
* Output
    * Visual
    * Audio
    * Tactile

## Human Psychology and Perception

* Visual Perception
* Auditory perception
* Tactile
* Memory
    * will start with this

## Guidelines

* Web content accessibility guidelines
* eight golden rules (Shneiderman)
* Smith & Mosier Guidelines for UI software
* OSF Style Guide
* Johnson's GUI Bloopers
* Human interface guidelines (Apple)
* Speech interface guidelines (Larson)

## Metrics

These are used once you have a system, to measure it – kind of a counterpart to guidelines

* SUMI, WAMMI
* Accessibility validators

## Modelling Techniques

Won't go into these in any detail, just a flavour of them

* Task Analysis

    * hierarchical task analysis

    * knowledge-based analysis

    * entity-relationship techniques

* Cognitive Modelling

    * task-goal hierarchies

    * linguistic/grammatical models

    * device-level models

## Design & Evaluation Techniques

* Questionnaire design

* Experimental design

* Statistical analysis

    * Was the difference relevant?

* Iterative design and evaluation

    * Part of a design cycle
