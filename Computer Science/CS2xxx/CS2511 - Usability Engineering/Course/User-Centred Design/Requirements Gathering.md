# Usability Design Process

* Often good to have a mix of approaches and know which to use best for different circumstances

## What Is the Area of Expertise?

* pen-and-paper walkthrough is without a computer in sight
    * they have to think about it as they do it, so it becomes a very honest representation
    * you can find which steps are easily forgotten

## Who Are the Users?

* what are they good at?

* attitude = motivation
    * e.g. fun?

* generally better to design for small, tightly-defined groups

### Segmentation

* Place people along axes for each criterion

### Personas

* Makes it easier for the designer to think about the groups – e.g. "how would 'George' find this?"

* better than e.g. a really large requirements document

# Personas

* It has been found that a product developed to meet the specific needs of a particular group often meets the needs of a much wider group.
    * Rolling luggage was originally designed for airline pilots and air crew
    * ballpoint pens were originally designed for people who didn't have the hand-eye co-ordination to use fountain pens
    * cassette tapes were originally designed for blind people (who couldn't thread reel-to-reel tape)

## Primary Users and Secondary Users

* This is less common nowadays

Example: a ticket-booking system

* primary users are sales assistants
* secondary users are customers

Needs of the two groups may be different. Both sets of needs should be identified and catered for.

## What Do the Users Want to Do?

Need to distinguish between:

* normative needs
    * needs identified by professional designers/developers
* user needs
    * expressed needs
        * what end-users say they want
    * felt needs
        * what end-users actually want from the system

Users may lack the technical vocabulary or understanding to express felt needs. Unmet felt needs are often expressed as a general dissatisfaction with a system. Users will often not use the system in this case.

This is a huge problem which has never been fully solved (e.g. the NHS computerised database system).

Sometimes end-user needs may be excessive and impractical, but this does not mean they can be ignored. You should explain why you've designed it in a different way from that.

## Determining User Needs

The traditional methods are:

* direct observation
    * though people may behave different when observed
* questionnaires
* interviews

### Direct Observation

You can study existing users of similar systems.

Ideally you should observe people who are using the system for their own ends, unprompted by you.

For example, if the task is to develop a better ATM interface, you could use video to monitor people using existing ATMs and note any problems they encounter.

This is rarely possible, due to:

* ethics/confidentiality issues
* work is distributed over different places
* work is done co-operatively

An alternative is to ask a group of people to carry out certain relevant operations in the laboratory, and then observe them.

This gives no guarantee that they are carrying out the same operations in the same way as they would if unprompted.

Might be worth using both techniques in parallel though.

#### Artefacts

Where an application is based on existing systems, it may be possible to use an artefact (an object or aid used in the performance of a task) to identify non-normative needs.

This can tell you which parts of the process are difficult, or provide clues as to how users work with a system and what problems they encounter. Examples:

* notes stuck to the computer detailing keyboard shortcuts
* reference manuals kept close at hand (perhaps with some pages well-thumbed), or photocopied sheets from reference manuals pinned in a prominent position
    * shows which things people find difficult to remember
* manuals created by the users themselves
* computer keys tippexed and drawn over with reminders of shortcuts, etc.

### Questionnaires

Questions might cover:

* how much experience they have with relevant systems
* did they encounter particular problems?
* if they have tried competing systems, did they find one easier to use than another, and if so then in what way?

Questioning can be carried out through questionnaires or interviews.

Good questionnaire has 10-15 questions and no more – if you can't find it out with that many questions, you need to use another method.

Closed questions are ones where the user is choosing preset answers, open questions allow the user to put in their own answers.

* designer/developer inevitably starts from their own perspective, and is most like
*
* there are ways for checking a questionnaire for normative bias, but this won't identify topics excluded altogether by bias
* important to get the questionnaire reviewed by others
* can be good to get a test run
    * ask something like "did this questionnaire seem to be in favour of software A or software B?"

### Interviews

Can use walkthroughs where direct observation and questionnaires won't work.

These are conducted during face-to-face interviews, with pen and paper only.

This allows the subject to describe the process as they see it rather than as it is usually carried out.

Tells you which steps in a process are important to the user. Missing steps suggest that they are easily forgotten – may have to remind users.

Walkthroughs can be conducted at any stage of the design process.

Can also be a good sign of what to put in a questionnaire.

#### Compared to Questionnaires

* interviews are usually less structured
    * this can be overcome to some extent by having the interviewer use a fixed list of questions
    * this removes the main advantage of an interview – the opportunity to ask questions spontaneously as they arise
* questionnaires provide a more formal structure setting than interviews, ensuring consistency between respondents
    * removes the risk of bias from an interviewer, ensuring respondents are free to provide their own perspective

Often good to use both.

# How Will the Application Be Used?

Consider an ATM:

* it will be used outside, so it must be usable in all weathers
* screen must be viewable under all lighting conditions
    * and you may want a simple screen layout
* users might be wearing heavy clothing that impedes movement and makes them clumsier
    * might not want complicated interaction techniques

In general, users may only be able to devote part of their attention to the task because:

* they are surrounded by other people and feel pressured or concerned about their privacy
* they are simultaneously trying to control small children
* they may be driving

Applications on PCs and mobile devices generally pose fewer problems since the user has more control over where and how. There may still be issues with distraction, privacy, etc.

Issues to be considered include:

* physical aspects
    * lighting, noise levels, space/layout
* safety aspects
    * distractions (for safety-critical systems)
* social aspects
    * individual or group working, task-sharing or dependency, etc.
        * which data is shared between people in a group, how much
        * role of each person in the group, etc.
* organisational aspects
    * IT policy, user support, etc.
        * e.g. permissions to access documents
