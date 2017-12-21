# Intro

Might use guidelines in the early stages, whereas heuristics and metrics assume you have some design already done, even if it's just a basic prototype.

Both approaches involve analysing a prototype to see how usable it is.

# Heuristics

* techniques based on experience that help in problem solving

* tend to be quick and rough – a means of arriving at a 'good enough' solution

* rules of thumb, educated guesses, intuitive judgments, common sense

## Approach

A number of evaluators examine an interface and assess its compliance with a set of recognised usability principles (the heuristics).

Heuristics are general rules (usually around 10 of them are used) which describe common properties of usable interfaces.

Similar to guidelines but framed to be used in an analytical rather than generate manner (assessing existing things rather than creating new things).

* each evaluator is asked to assess the interface in the light of the heuristics

* each evaluator should work through the interface several times

* evaluators should either write down their comments or verbalise them, so they can be recorded or noted by an observer

* if an evaluator encounters problems with the interface the experimenter should offer assistance, but not until the evaluator has assessed and commented upon the problem

    * don't offer assistance immediately, so that you can see how bad the problem is

Evaluators work alone so they can't influence one another. Only when all the evaluators have assessed the system individually should the results be aggregated and the evaluators allowed to communicate with one another.

This communication may be useful at this point.

The number of evaluators is typically between 3 and 10, and they should have no prior knowledge of the interface or of the goals of the project.

Using a single evaluator - even an experienced one - may not identify all the usability problems in an interface because different people identify different problems.

Nielsen (1992) conducted a study:

* 19 evaluators were asked to assess an interface against a set of heuristics

* between them they identified 16 usability problems

* some evaluators identified a far higher percentage of problems than others

* some problems were only identified by one or two evaluators, who were not necessarily the evaluators who found a higher percentage of problems

Using a large number of evaluators increases the likelihood of identifying problems but may also increase costs.

Nielsen concluded that four evaluators is the best compromise between cost and effectiveness.

# Metrics

* more expensive

* more time-consuming

* more reliable

* give quantitative results

    * can compare, e.g. "this one got 80% and the other got 75%, so let's go with the first"

* distinguish from Usability Testing, where we're comparing (e.g.) two products from two companies

    * here we're testing against a known standard embedded in the rules

## Techniques

Usually involve asking a group of users to perform a specified task (or set of tasks).

The data gathered may include:

* success rate (task completion/non-completion, % of task completed)

* time

* errors (number of errors, time wasted by errors)

* use of help/documentation (number of instances, time spent)

* failed commands (number, how often repeated)

* user satisfaction (a subjective measure)

Once gathered, the data may be presented in a number of ways:

* aggregated to yield either a set of scores, each reflecting a different aspect of usability, or a single overall usability rating

* analysed statistically to yield values that can be expressed to known level of uncertainty

# Examples

## Cognitive Walkthrough

* Doesn't really belong in either category, but is often grouped with metrics

* aims to evaluate the steps required to complete a task and identify mismatches between the way the user thinks about the task and the way the designer thinks about the task

Involves the following stages:

* user selects a task to be performed

* user writes down all the steps required to complete the task

* for each action in the task, the user:

    * explores the prototype, notes, available information

    * selects the action that appears to match the required action most closely

    * interprets the system's responses and assesses if any progress has been made towards completing the task

As the user is doing this, evaluators attempt to answer the following questions for each step:

* how does the user know what to do next?

* can the user connect the description of an action with what they are trying to do?

* can the user tell if they have made the right choice on the basis of the feedback supplied by the system?

## SUMI (Software Usability Measurement Inventory)

A number of subjects are asked to use a system and then complete a questionnaire about it. At least 12 subjects are required, preferably far more.

This is quite expensive, and usually happens late in the process, not as early as heuristics.

The questionnaire typically contains 50 questions, of which the following are examples:

* This software responds too slowly to inputs

* the instructions and prompts are helpful

* the way that system information is presented is clear and understandable

* I would not like to use this software every day

Questionnaires are machine-assessed – can notice if people contradict themselves, assign a weighting to answers where people were paying attention / thinking about the questions.

Note the mix of positive and negative questions. People will too easily fall into the pattern of (e.g.) deciding they like the product and so not really reading the specific questions, just selecting the positive responses.

* 50 questions is a lot of questions

    * people will follow a large question if they're paid

### Results

The results are analysed to give scores on the following scales:

* efficiency

* affect

* helpfulness

* control

* learnability

The designers of SUMI claim that it has a high level of reliability.

Reliability is measured by asking several different groups of subjects to fill in questionnaires for the same system. If the scores for each group are similar, it can be assumed that the questionnaire is revealing information about the system, not the subjects.

# Automated Testing

Since webpages follow an open-source standard, it's possible to test some of their features automatically.

Some automated testers only check the validity of the code, but others test for conformance with usability and accessibility guidelines.

Examples:

* paid-for services such as IBM's Rational Policy Tester Accessibility Edition

* free, online checkers such as:

    * WAVE (http://wave.webaim.org)

        * possibly more sophisticated than the other free examples

    * TotalValidator (http://www.totalvalidator.com)

    * Cynthia Says (http://www.cynthiasays.com)

        * quite popular

They automatically check many of the accessibility issues listed in the WCAG, e.g.:

* inclusion of alt text, summaries, table header information, etc.

* contrast between foreground and background colours

Where a page is found to violate the guidelines, most testers identify the type of error and the line of html code on which it occurs.

Many accessibility issues cannot be checked automatically, so testers usually issue a number of warnings for things to check manually.
