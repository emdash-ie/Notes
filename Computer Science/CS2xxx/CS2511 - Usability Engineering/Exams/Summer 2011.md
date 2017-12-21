# Question 1

## (a)

### Question

It has often been predicted that conventional GUIs will soon be replaced with 3D interfaces. However, while the technology to display 3D graphics is now generally available, 3D interfaces are used only in a few, specialised applications.

Describe the major factors involved in 3D visual perception and discuss their significance for the future development of such systems.

### Answer (might be a bit long)

The main factors involved in 3D visual perception are:

* binocular vision

* head movement

* monocular cues

* familiarity / pattern-matching

If some of these cues are absent, users can compensate for them (and may not be consciously aware they are missing), but will find it more tiring to use a system.

Good 3D depends on reproducing all of these cues. Some cues (e.g. monocular cues and familiarity/pattern-matching) are straightforward to reproduce, but others (binocular vision and head movement) are more difficult. Reproduction of difficult cues leads to expensive systems, which hinders widespread use.

Binocular vision is made up of two cues – retinal disparity and eye-convergence.

Retinal disparity relies on the two eyes seeing slightly different scenes. The further away an object is, the greater the retinal disparity. Retinal disparity can be reproduced using 3D glasses to separate what each eye sees.

Eye-convergence comes from adjusting the focus of our eyes to see objects at different distances. Feedback from the eye muscles tells us how much adjustment we made, and therefore how far away an object is. Eye-convergence is the hardest cue to reproduce on a computer screen.

Head movement is used in conjunction with binocular vision, comparing retinal images and eye-convergence information from two or more slightly different positions. This can be reproduced using sensors that track the head movement, and update the display to match.

Aside from the cost of reproducing all cues, we are more ok in general with 2D views being abstract – we expect 3D views to be more realistic. This may change as we get more used to 3D views though.

## (b)

### Question

Studies have shown that people experience more difficulty reading text from a computer display than from a printed sheet. Summarise the research findings in this area, and suggest some measures that might be taken to minimise these problems when presenting text on computers.

### Answer

Summarised research:

* people read from a computer screen 25% slower

* people scan more on screen – read progressively less as they move down the screen

* people dislike scrolling

* people dislike wordy text on computer screens

It's thought that screens don't support adult reading strategies.

* research shows that long words are recognised as quickly as single characters, suggesting that words are recognised by shape rather than by identification of characters

* so it's important not to impede pattern recognition on screens

Suggested measures:

* use a type-face with distinct patterns to aid pattern recognition

    * avoid block capitals

* minimise the amount of text by removing unnecessary material

    * lessens the impact of scanning

    * though it's best to include as much relevant information as possible for tasks that involve comparison/analysis/decision-making

* avoid descriptions

* break up the text using bullet points

* if using long passages of text is unavoidable, try to minimise the complexity of the text

## (c)

### Question

A number of statistical tests are commonly used to analyse data gathered during usability testing.
Explain why so many different tests are needed, indicating the type of data each is designed to analyse.

Give an example of a test that might be used to analyse each type of data.

### Answer

Many different tests are needed because there are many variables that affect whether a test can be used:

* the number of (groups of) samples

    * most tests compare two groups of samples, while some tests can be used to compare more than two groups of samples

* whether the groups from which the data is drawn are related or not

* the quality of the data (nominal, ordinal, interval, or parametric)

[not going into more detail here because I think he said we won't be asked this]

# Question 2

## (b)

### Cognitive models are classified variously as task/goal hierarchies, linguistic/grammatical models, and physical/device-level models. Using examples, compare the three types of model, noting their relative advantages and disadvantages.

task/goal hierarchies:

* supposedly provide measure of how hard an interface is to learn (CCT)

    * though sometimes you have to put entries in working memory just to serve as flags which allow production rules to fire at the right moment

        * it's not clear that these entries represent any cognitive load

* relative measures are generally useful, but absolute measures aren't

linguistic/grammatical models:

* tend not to work as well for GUIs as for CLIs

    * give the same results for both for certain things even though they have been shown to easier on GUIs

    * all the areas where GUIs perform better involve unit tasks, which these models don't apply to (unlike physical/device-level models)

physical/device-level models:

* the motor-system is well-understood and relatively easy to model, unlike cognition

    * these models produce reliable results/predictions

* very verbose, so can't be used to describe complete interfaces/systems

* produces absolute figures that can be used to compare different systems (e.g. Fitts' Law)

    * whereas e.g. BNF needs to be generated (consistently) by the same team for two systems to compare them

    * and CCT is mainly only good for relative comparisons also

### Explain how cognitive modelling differs from other modelling/analysis techniques, such as task analysis.

Task analysis only models what happens or is observable during an interaction, whereas cognitive models aim to incorporate some representation of the user's abilities/understanding/knowledge.
