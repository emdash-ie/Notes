# Design of a User Study

* have a prediction

* choose subjects

[…]

# Quality of Data

When designing a test or questionnaire, careful thought should be given to the kind of data it will generate.

If our aim (for example) is to gather ideas on how to improve a system, then a qualitative questionnaire will be suitable.

However, if we hope to demonstrate that our system is better than existing systems in some way, we may want to use a statistical test to prove this.

In the latter case we will need to design our test or questionnaire carefully to ensure it yields testable data.

Statisticians classify data under the following headings:

* nominal-scaled data

    * lowest quality (very noisy)

    * there is no numerical relationship between scores

    * e.g. a score of 2 is not necessarily higher than a score of 1

    * possibly useful for checking if a certain error (represented by a certain score) has happened a lot

* ordinal-scaled data

    * a score of 2 is higher than a score of 1, but not necessarily twice as high

    * data obtained from questionnaires is usually ordinal-scaled

    * better quality

* interval-scaled data

    * a score of 2 is exactly twice as high as a score of 1

    * timing data is usually interval-scaled

    * better quality (less noisy – can see trends with fewer subjects)

* parametric data

    * data must be interval scaled

    * The scores must be drawn from a population that has:

        * a normal distribution

            * if subjects measured on factors relevant to the study, result would follow a normal distribution

        * a normal variance

            * the spread of scores must be the same as that found in the general population

    * best quality (least noisy)

Most test in usability engineering use ordinal-scaled data or interval-scaled data. Parametric data is usually too expensive / too much effort for the benefit it gives.

Rather than counting errors, can count time lost due to errors, giving interval-scaled data.

The higher the quality of the data we gather, the fewer samples we will need to draw valid conclusions.

In some cases, it's not possible to design a test that yields parametric or interval-scaled data. In such cases there is no option but to gather nominal or ordinal-scaled data and take a large number of samples.

# Data Analysis

Say we have conducted a study to evaluate an interactive training system.

The design is as follows:

* 2 groups of 20 subjects

* randomly assign the subjects to groups

* one group performs a set task using our system (experimental condition), the other group […]

## Frequency Distribution

* presents the data without loss

* presents it in a form that allows the characteristics of the data to be understood more easily than is possible using just the raw data

## Average

* especially for small groups, one outlier can significantly affect the average

## Standard Deviation

* measure of dispersion in the scores

* adds info over just presenting the average

# Normal Distribution

* research has shown that many […]

* because it's symmetrical, mean, mode, and median all have the same value

* can be defined using only the mean and the standard deviation

* the percentage of scores falling above or below a given value of standard deviation is fixed.

# Statistical Inference

All the techniques described so far are intended to describe or summarise data.

Sometimes we need to go further and attempt to prove that:

* there is a significant difference between two sets of experimental data

* there is a significant difference in a particular direction, e.g. that data-set a is better in some way than data-set b

This is known as drawing statistical inference.

# Significance

When designing experiments, we try to keep all possible factors stable with the exception of one, the independent variable, which we deliberately manipulate in some way.

We then measure another variable, the dependent variable, to see how the change in the independent variable has affected it.

However, we can't assume that all changes in the dependent variable are due to our manipulation of the independent variable.

Some changes will almost certainly occur by chance.

The purpose of statistical testing is to determine the likelihood that the results occurred by chance.

We can never prove beyond doubt that any differences observed are the result of changes in the independent variable rather than mere chance occurrences.

However, we can determine just how likely is it that a given result […]

Before testing, we formulate two hypotheses:

* any difference arise purely as a result of chance variations (the null hypothesis).

* any differences arise – at least in part - as a result of the change in the independent variable

    * the alternate or experimental hypothesis

Statistical tests allow us to determine the likelihood of our results having occurred purely by chance. They allow us to decide whether we should accept the null hypothesis or the alternate hypothesis.

We usually express probability on a scale from 0 to 1. We can't prove anything for certain, but we can express our result to a level of probability.

The significance level (e.g. p <= 0.05) indicates that the likelihood of the observed difference having occurred as a result of chance factors is less than some amount (e.g. one in 20).

We choose a level of significance in advance, then test for it:

* if the outcome is greater than our chosen significance level, we accept the null hypothesis

* if the outcome is equal to or less than our chosen significance level we accept the alternate hypothesis

## Level of Significance

What's an appropriate level to test for?

* if we choose a relatively high value of significance (e.g. 1 in 10), we are more likely to obtain results, but the results will be wrong more often

    * this is known as a type 1 error

* if we choose a very low value, we can place more confidence, but we may fail to find a correlation when it does in fact exist

    * this is known as a type 2 error

There is no correct value for significance, but the value p <= 0.05 is commonly used and is regarded as a good compromise.

When a more stringent test is required (e.g. because the result is controversial or the findings may be used in a critical application), a value of p <= 0.01 is sometimes used.

In industry, a study is usually only done once, but in research, studies are replicated and repeated.

## Choice of Test

When choosing a test, the following factors should be taken into account:

* two-sample or k-sample (more than two)

    * most tests compare two groups of samples, e.g. the results obtained from comparative tests on two different systems

        * wherever possible design for a two-sample test

    * some tests can be used to compare more than two groups of samples, e.g. the results obtained from comparative tests on three or four different systems

* related measures or independent measures

    * different tests are used depending upon whether the two (or more) groups from which the data is drawn are related or not

    * repeated measures is best, because if you've just matched your subjects, you may not match them on all relevant criteria

* nominal, ordinal, interval, or parametric data

These three factors are the principal factors to be taken into account when designing a study and choosing a statistical test.

There are tests available to suit every combination of those factors. Various software packages are available to carry out these and similar tests.

The main task facing […].
