# Speech Perception

Attempts to use speech in computer applications cause slow and inefficient communication.

But studies show human can communicate very efficiently using speech.

This is because human speakers are very careful when choosing:

* what to say at each point in an exchange
    * bear in mind what has already been said
    * also their impressions of the listener
* how to say it
    * format speech so that important information is highlighted, making it easier for the listener to identify

Speech is a co-operative activity, in which the speaker seeks to identify and meet the communication needs of the listener, and the listener provides feedback to the speaker to aid in this process.

It's important to understand how human speech communication works if we are to develop better speech-based computer interfaces. Speech communication also provides a useful model for other forms of human-computer interaction in the era of ubiquitous computers.

# Models of Speech Perception

More recent models assume a top-down approach:

* search speech stream and locate key-words
* identify the meaning of the key-words, then guess at the meaning
* if unsuccessful, analyse more words until the meaning has been extracted

Note:

* top-down models suggest we perceive speech in much the same we read text
* both types of model assume that speech is held in a temporary store during processing
* modern models fit well with the concept of humans as lazy processors

## Speech Content

When speaking, human beings:

* assess what is relevant to the listener at the current point
* construct a phrase containing this information, taking care to:
    * exclude information that is already known to the listeners or that they can infer
    * use as few words as possible without sacrificing clarity
* present the phrase with appropriate prosody
    * prosody is pitch, volume, pauses, gestures, etc.

In deciding what is relevant, an important factor is the distinction between new information and given information.

### New Information & Given Information

* a typical spoken phrase is constructed around one word
* this word is deemed by the speaker to contain new information not previously known to the listener or inferable from the context
* most of the remaining words either:
    * complete the grammatical structure
    * or provide redundancy by presenting information already known to the listener or inferable from the context
* such words are said to contain given information

### Content Words and Function Words

Some of the words within a phrase are essential, for example verbs and nouns. The phrase cannot be understood if they are omitted or mis-heard. These are *content words*.

Other words are not essential. The phrase can be understood even if they are omitted or mis-heard.

## Speech Delivery

When speaking, we provide prosodic cues to help our listeners parse the speech stream. Appropriate prosody helps the listener identify key-words (new information and content words).

### Intonation

* The pitch rises at the start of each phrase and falls at the end.
* Where several phrases follow in succession, each has a lower average pitch than its predecessor
* Within each phrase, a sharp change in pitch marks the position of the new information.

### Rhythm

* Stressed syllables of key words (new information, content words) are spoken at regular intervals and may also be marked by an increase in volume
* pauses are placed between words where necessary to support the rhythm
* longer pauses are placed between phrases

### Non-Speech Cues

Used to highlight the position of important information within the speech stream.

* gesture
* facial expression

## Collaboration, Clarification and Repair

Note we're just talking about speech that's focused on effective communication, e.g. 911 calls.

Successful speech communication relies on the maintenance of a shared context between speaker and listener(s).

As an exchange proceeds information is shared, and each participant relies on this shared context when formulating contributions.

In addition, each participant learns more about the other.

In general HCI using speech has been context-free.

Having a shared context makes it easier to decide how much background knowledge needs to be communicated and what can be excluded in order to keep utterances brief.

### Shared Context

* history of conversation
* impression of participants
    * knowledge
    * analytical skills
    * memory
    * expectations / boundaries
        * cultural
        * religious
        * other

In an effort to communicated efficiently, we often place too much reliance on this shared context – we provide incomplete information and hope that listeners will fill in the missing information by reference to the context.

This doesn't always work, with the result that communication breaks down.

Clarification and repair is important – it's part of what allows speech to be so effective. Forms a rapid feedback loop. This is often absent when speaking with machines.

If listeners do not understand something, this soon becomes clear to the speaker – lack of understanding may be signalled by various means:

* facial expression
* explicit request for clarification

When this happens the speaker usually responds by re-phrasing or providing more context.

# Designing Speech-based Interfaces

Speech can be used for input (speech recognition) and for output (speech synthesis).

Some systems use speech for both input and output (e.g. voicemail (?)) while others use speech only for output (e.g. SatNav), and a few use speech input in conjunction with visual output.

Speech-based interfaces are being used in an ever-wider range of applications, but while the necessary technology is available, there are generally very few guidelines. […]

## Speech Recognition

* Recent systems (e.g. Siri) use a brute force match against a large database of stored phrases to determine the meaning of the input utterance.

Speech recognition involves two steps:

* word recognition
* construction of meaning

Most of the problems with word recognition have been solved. However, recovering the meaning from a sequence of words is far more difficult. Many problems need to be overcome before computers can handle unprompted speech input (speech that has been stripped down).

Prompted speech is achieved by giving questions in a particular format – most people will respond in the same/expected format.

Even when the individual words are correctly recognised, speech is more difficult to analyse than written language. Converting speech into text and then using these doesn't work though.

Where you can train a system (e.g. Dragon Dictate), word recognition can be especially good.

There are number of reasons written language is easier than speech:

* speech has no punctuation – parsing cues are provided through a mixture of pausing, intonation and stress in ways that are complex and not fully understood
    * they also vary from person to person
* fragmentary phrases are common
    * we often don't finish sentences because we can see that the sentence has been understood
* repetition and re-phrases are common
    * partway through a sentence we may think of a better way to phrase it and start again
    * this is easy for humans to understand but difficult for machines to understand
* speech relies heavily on non-grammatical sentence forms (minor sentences)
    * a lot of words are stripped out

A major (or regular) sentence has the full grammatical form appropriate to its type, e.g. a statement with formal declarative structure.

A minor (or irregular) sentence has an incomplete or abnormal grammatical structure.

Speech makes extensive use of anaphora – e.g. using he/she/him/her/they/them rather than referring to a person or object by name.

Efficient speech communication relies heavily on other communication channels – gesture, facial expression, etc.

Ambiguous words, phrases, etc. are often used in order to achieve brevity, with the correct interpretation being signalled through prosody.

The speech context is dynamic, changing as the exchange progresses. Modelling this context is extremely difficult.

Until quite recently, speech recognition has been mainly used in applications involving:

* speech to text transcription, where recovery of meaning is not necessary
* tightly-constrained problem domains, where vocabulary can be limited and every word given a fixed meaning

Recently, the ability to rapidly search large databases of tagged speech samples has enabled more potential applications.

## Speech Synthesis

The design of speech output can be separated into two stages:

1. Deciding what should be said and when
2. Choosing appropriate prosody for each utterance

Some frameworks exist to assist in the design of dialogues, but much work still needs to be done.

Considerable work has been done on creating rules to generate valid prosody, but for best results the output must be hand-tuned.

To tell where the intonation needs to go, the context is required to spot the keywords in the sentence.

Current TTS (text to speech) systems generate high-quality synthetic speech, but studies show people still have more difficulty using synthetic speech than natural speech:

* people usually understand it as well as natural speech
* but understanding requires more effort than natural speech

The comprehensibility of speech can be assessed using a technique devised by Luce (1982):

* Subjects are presented with a passage of speech and asked to recall the way in which it is spoken.
* The more difficult the speech is to understand, the more subjects will recall of the syntax and surface structure

This suggest that people have to perform more analysis to extract meaning from poor-quality speech.

Here's another approach:

Comprehension of spoken tracts were compared under four conditions:

* natural speech, meaningful content
* natural speech, meaningless content
* synthetic speech, meaningful content
* synthetic speech, meaningless content

They found:

* subjects understood meaningful content
* word-recognition was better for meaningless content with natural speech

This all suggests that listeners rely more heavily on context when trying to understand synthetic speech.

A simplified version of the second approach, measuring word-recognition rates for standard passages of meaningless text is widely used for […]

Studies show that the gap between natural and synthetic speech has narrowed, but synthetic speech remains far more difficult to understand than natural speech.

This is probably because most synthetic speech lacks adequate/appropriate prosody and other cues.

Generally they struggle with new words.

## Applications

A number of standards exist that allow speech synthesis and recognition to be used on webpages:

* voiceXML
* XHTML + voice
* SALT (Speech and Language Tags)

Most browsers currently require plug-ins to handle speech, but a few have built-in support (e.g. Opera), and others will soon follow.

### Aircraft Maintenance

Interesting because it's a safety-critical domain. Also a lot of components have to be replace very frequently – there's maintenance every time a plane lands.

Several proprietary systems are in use which allow engineers to inspect aircraft and record their comments ("this needs to be replaced, this will soon", etc) through speech, thus leaving their hands free for the task.

The spoken comments are then automatically converted into maintenance schedules, lists of parts to order, etc.

This system is reliable because the vocabulary is precisely defined. Engineers are trained to use only the words in the vocabulary, and to use them only as defined by the system.

The system is *completely* reliable.

### Voice Mail Systems

These also rely on a defined vocabulary.

They normally recognise numbers, along with a set of defined words related to the domain. For example, a company might allow users to locate the nearest branch office by entering the name of a town or city.

# Applications Using Speech (cont.)

Screenreaders for blind and visually-impaired users.

Screenreaders convert the visual information on a screen into text, which is then converted into speech (or in some cases, Braille).

Typical features include:

* keyboard shortcuts for operations normally performed using the mouse
* all text made available through speech/Braille
* standard icons described using text
* use of scripts to customise applications
    * scripts difficult to write for an individual user, usually organisations make scripts available for a wide range of popular programs
* assignment of voices according to role/purpose
    * e.g. a male voice for commands, a female voice for content
* control of voice-selection, speech speed, prosody (by rule), etc.

One of the major challenges in the design of speech systems is to provide an overview that approximates a visual glance.

A glance allows sighted users to determine:

* how much information is present on a screen
* how it is organised
* whether/which parts are worth exploring further
* an appropriate strategy for exploring the information

Accessing information without the benefit of a glance is much more difficult and tiring.

Some experimental systems provide automatically-generated summaries of data. Others use spatial sound, etc, to convey metadata.

Another approach is to provide tools that re-order the data in various ways so as to allow the user to gain an overview of the dataset. For example, when a table is used, the information contained in the table structure needs to be conveyed.
