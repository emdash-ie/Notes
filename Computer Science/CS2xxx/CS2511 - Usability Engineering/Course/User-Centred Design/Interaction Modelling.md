# Intro

* some are very detailed and expensive, only used on large projects

* some are more entry-level and used on small projects

Two broad categories:

* task analysis

    * models only what happens (or is observable) during interaction

    * based on observation

        * e.g. asking questions of the users is not part of the specifications

* cognitive models

    * designed to incorporate some representation of the user's abilities, understanding, knowledge, etc.

    * the aim is to formalise knowledge gleaned by psychologists so that it can be employed in the design of computer systems

    * go a step further than task analysis

Note: not all cognitive models explicitly model memory or decision making. Some will just point out that (e.g.) memory was used at this point.

Three broad categories of Cognitive models:

* Hierarchical representations of the user's task and goal structure

    * these models deal directly with the issues of formulating tasks and goals

* linguistic and grammatical models

    * these models deal with articulation and translation between the system and the user

* physical and device-level models

    * these models deal with articulation at the human motor level rather than at higher levels

    * deals with unit tasks (e.g. changing gear in a car) – tasks which it is not worthwhile to break down into smaller tasks because we've become so good at them

        * you can be thinking about something else while changing gear

Some cognitive models directly embody knowledge about human perception, memory, etc.

Other cognitive models do not embody this knowledge directly, but model interaction in a way that makes it easy to identify […]

# Granularity

A major issue in the design and use of models is selecting the appropriate level of granularity.

* what is the top-level goal?

    * tends to be quite small tasks, as modelling is complicated even for medium-size tasks

    * most tasks for part of larger undertakings, so goals can be defined at many levels.

    * the choice is often determined by the system being modelled

* what is the lowest-level sub-goal?

    * should we break down the goals until we reach the level of individual finger and eye movements?

        * no, because they don't take much or any effort

    * the approach generally adopted is to identify sub-goals that are routine, learned tasks which do not involve problem-solving

        * these are known as unit tasks – either tasks that can't be broken down any further or have no real thought involved

Most modelling languages and techniques leave decisions on granularity to the user.

Generally use physical and device-level models for unit tasks, and the other two categories for higher-level tasks.

# Cognitive Complexity Theory

CCT is designed to model interaction, and in particular the amount of cognitive effort involved in performing a task with a particular interface.

CCT has two descriptions which operate in parallel:

* a description of the user's goals, based on a task-goal hierarchy and expressed through production rules

* a description of the system state, expressed as generalised transition networks, a form of state transition network

## Production Rules

This form:

```cct
if condition then action
```

* the condition is a statement about the contents of working memory

* the action is an elementary action, either internal (e.g. a change in the state of working memory), or external (e.g. a keypress)

A CCT analysis might have thousands of production rules. Usually the rules are written by packages, which can spot conflicts for you, etc.

The conditions attached to each rule are unique, so that only one rule can be active at a time.

Execution of a particular rule should change the state of working memory in such a way that it meets the conditions for another rule, which is then executed.

Note (in the example) the use is assumed to be storing information about the goal, the text being worked upon, and the cursor, all in working memory.

The working memory in CCT is supposed to correspond loosely to human short-term memory. If there are many things in working memory at any point, or a high average of things, the interface is probably hard to use.

## Strengths and Weaknesses

Kieras and Polson, who developed CCT, claim that complexity of an interface is reflected in the number of production rules required to describe the system using CCT.

The more rules, the harder the interface is to learn.

The number of items held in working memory also indicates how […]

However, some elements of the notation are purely structural, included solely to enable the system to function.

For example, it's sometimes necessary to place entries in working memory merely to serve as 'flags' which allow production rules to fire at the right moment.

It's not clear that such entries represent any genuine cognitive load.

Relative measures are generally useful, absolute measures aren't.

Another problem with CCT is that the amount of code required to describe even a small part of an interface can be enormous.

* this is a common problem with description methods

CCT production rules normally describe "expert" behaviour – the most appropriate sequence of actions to achieve the intended result.

However, CCT also supports the use of style rules which modify the way in which conditions and actions operate in production rules.

Style rules can be used to modify a CCT model to mimic different types of user, such as novices.

Bovair, Kieras, and Polson produced a list of style rules which can be used to reflect different types of user in a CCT description.

CCT production rules normally describe error-free performance, but there is nothing in the structure of CCT to prevent users writing production rules that model error conditions. However, in such cases the error behaviour must be explicitly specified in advance. […]

# Linguistic and Grammatical Forms

Another category of cognitive models.

These use formalisms such as:

* BNF (Backus-Naur Form)

* TAG (Task Action Grammar)

These are based on […]

## Backus-Naur Form

Consider a graphic application that has a polyline function.

The user selects the function from a menu, clicks at each of the points the line is to link, and then double-clicks to end it.

* `+` represents a sequence in order – this then this then this

* `|` used for logical OR

* Syntactic constructs (in lowercase) appear on the left side of a definition.

    * work down to […]

* Some syntactic constructs are recursive.

### Complexity

One measure of the complexity with BNF is to count the rules, but you can reformulate the rules by using complex rules rather than simple rules.

A better measure is to count the rules and the `+` and `|` operators in the description. This is better than just counting the rules, but it still dependent on the framing of the rules.

In practice, the problems aren't very important, as BNF is never used in an absolute sense, just comparatively. So as long as the BNF descriptions being compared are generated by the same person or team and pains are taken to ensure consistency, the problems don't matter.

## Task Action Grammar (TAG)

A failing of BNF-based measures is that they ignore many features of language and the user's knowledge.

For example, the UNIX commands `cp`, `mv`, `ln` all have a similar syntax and that makes them easier to remember.

If one didn't share the consistency, this would be reflected in a BNF description, but wouldn't affect the number of rules or operators used.

TAG is based on BNF but designed to capture some of the information ignored by BNF-based approaches.

It captures consistency by allowing the use of generic descriptions.

For example, the three UNIX commands would be described using a generic "file-command", then noting the differences between each command and the generic form.

## Issues With Cognitive Models

Most cognitive modelling languages and techniques are based on ideas and approaches developed for use with command-line interfaces (CLIs) rather than GUIs.

* better with CLIs, not as good with GUIs

Many were developed from formalisms used to describe natural languages, and later computer languages.

This is true of both Goal and Task Hierarchies and Linguistic and Grammatical models.

Most early GUIs were just window-managers for command-line systems.

Since all interactions on such systems were ultimately translated into textual operations, there was little reason to doubt the adequacy of a textual description.

More recently, researchers have begun to question the validity of using cognitive modelling languages to analyse interactions within GUIs.

While the functionality of graphical interactions can be described using such languages, it's not clear that all the factors of importance in the interaction can be described.

* many tasks can be carried out more quickly and effectively using a GUI than a CLI

* however, if the same functions are available in both the CLI and the GUI, many modelling languages will yield the same description for both

* thus they will fail to capture the efficiency improvement offered by the GUI

A grammar that fails to take account of these issues will not be able to analyse or predict the efficiency of a graphical interface.

These models no longer apply once you've reached the stage of unit tasks (routine, learned tasks). All the areas where GUIs perform better involve these tasks.

# Physical and Device Models

These seek to model interactions at the level of motor actions.

Unlike cognition, the human motor system is well understood and relatively easy to model.

In this way, physical and device models avoid some of the problems associated with other types of cognitive model.

Modelling interactions at such a low level produces very verbose descriptions.

Because of this, physical and device models are unsuitable for describing complete interfaces/systems.

They are typically used in conjunction with other, higher-level models:

* the overall interaction is specified in a high-level model

* some of the unit-tasks are modelled in a physical or device model

Physical and device models can yield reliable predictions concerning operations. (also useful in an absolute rather than relative sense)

## Fitts' Law

For a given system, the time taken to move a pointer onto a target varies as a function of:

* the distance the pointer has to be moved

* the size of the target

This is so consistent you can put numbers on it, and just look at the ratio of the two numbers.

```
t_m = a + b log_2(d+1 / s)
```

* t_m = movement time

* a = start/stop time

* b = device tracking speed

* d = distance moved

* s = target size (relative to the direction of movement)

`a` and `b` must be empirically determined for different operations, pointing devices, etc.

    * you can then try and improve the empirical values for them

### Implications

* pop-up menus are generally faster to use than fixed menus

* menus arranged like pie-charts, with all options equidistant from the starting point, are very efficient

* the efficiency of fixed, linear menus can be improved by:

    * placing frequently-used options near the start-point

    * placing the menu at (or near) the screen edge, so that it becomes infinitely large in the direction of movement, makes things much easier

Card, English, and Burr (1978) used Fitts' Law to show that the mouse was the most efficient pointing device available.

This work led to choice of a mouse by Xerox for the Star 8010 Information System, the first commercial system to use a GUI.

Macintosh pull-down menus can be accessed around five times faster than typical Windows pull-down menus.

* this is because they're at the edge of the screen and so you can't overshoot (infinite-width target)

Circular pop-up menus good because of equidistance but also infinite size in each direction – can't move out of the ring, cancel by clicking a particular icon.

* palette of 16 tools – put at one edge of the screen

[…]

### Cont.

Fitts' Law has proved extremely accurate when compared with measured figures.

It can be used, in modified form, to derive an index of difficulty (ID) for a pointing device.

It has also been extended to model many types of pointing/navigation/target-acquisition tasks.

For example, the Accot-Zhait Steering Law models the task of navigating along a path or tunnel of specified (variable) width.
