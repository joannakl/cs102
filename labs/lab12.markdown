---
layout: lab
title: Lab
---

<!--
<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
Sept. 16
(whichever comes first)

__submission mode:__ group

</div>
-->

<main markdown="1" class="lab">

## Lab 12 How Many Words

This lab will give you some practice in submitting the types of problems you will be working on for project 5.



### Problem Statement

In an introductory English class, Professor Umbridge assigns the students
an impossible task of finding all the unique words in a ten-volume encyclopedia
of magic.
By her definition words are sequences of one or more consecutive alphabetic characters
in upper or lower case. Their uniqueness should be determined in a case insensitive way,
so  words like "magic", "Magic", "MaGiC" should be treated as the same.

As an upperclassman in the school, you and your friends decide to help, by writing
a program that will complete the task in a tiny fraction of the time and annoy Professor
Umbridge.

__Input__

The input is a text with up to 5,000 lines. Each line has at most 200 characters.
The input is terminated by EOF.

__Output__

A list of unique words that appear in the text, one per line. The output should be in alphabetical order and in lower case.
You are guaranteed that the number of unique words in the text is no more than 5,000.

__Example 1__

```
Input:
Professor Umbridge, Room 3789, +44-7911 123456

Output:
professor
room
umbridge


```


__Example 2__

```
Input:
In an introductory English class taught by Professor Umbridge assigns the students
and impossible task for counting all the unique words in a ten-volume encyclopedia
of magic.
By her definition words are sequences of one or more consecutive alphabetic characters
in upper or lower case. Their uniqueness should be determined in a case insensitive way,
so  words like "magic", "Magic", "MaGiC" should be treated as the same.

Output:
a
all
alphabetic
an
and
are
as
assigns
be
by
case
characters
class
consecutive
counting
definition
determined
encyclopedia
english
for
her
impossible
in
insensitive
introductory
like
lower
magic
more
of
one
or
professor
same
sequences
should
so
students
task
taught
ten
the
their
treated
umbridge
unique
uniqueness
upper
volume
way
words

```



</main>
