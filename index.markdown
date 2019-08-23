---
layout: default
title: Course Essentials
---

# Course Essentials
---

<iframe class="calendar" src="https://calendar.google.com/calendar/embed?height=300&amp;wkst=1&amp;bgcolor=%23ffffff&amp;ctz=America%2FNew_York&amp;src=bnl1LmVkdV9qYnM2MjBraXZmMWE3cDA4aGFqMGhmN2VmY0Bncm91cC5jYWxlbmRhci5nb29nbGUuY29t&amp;color=%238E24AA&amp;showTitle=0&amp;showNav=0&amp;showPrint=0&amp;showCalendars=0&amp;mode=AGENDA"  height="300"  frameborder="0" scrolling="no"></iframe>

<p class="hang" markdown="1"><span class="emph">Class meetings:</span> <br>{{ site.course_time }}
(attendance is mandatory).</p>

<p class="hang" markdown="1"><span class="emph">Recitations</span>  (attendance is mandatory): <br>
{{ site.recitation_section1 }}: {{ site.recitation_time1 }}, {{ site.recitation_instructor1_full }} <br>
{{ site.recitation_section2 }}: {{ site.recitation_time2 }}, {{ site.recitation_instructor2_full }} <br>
{{ site.recitation_section3 }}: {{ site.recitation_time3 }}, {{ site.recitation_instructor3_full }}
</p>

<p class="hang" markdown="1"><span class="emph">Office hours:</span> <br>
<span class="name">Joanna:</span>
{{ site.instructor_office_hours }} ({{ site.instructor_office_hours_location }})
<br>
<span class="name">{{site.recitation_instructor1_name}}:</span> {{site.recitation1_office_hours}} <!--({{site.recitation1_office_hours_location }})-->
<br>
<!--
<span class="name">{{site.recitation_instructor2_name}}:</span> {{site.recitation2_office_hours}} ({{site.recitation2_office_hours_location }})
<br>
-->
<span class="name">{{site.recitation_instructor3_name}}:</span> {{site.recitation3_office_hours}} <!--({{site.recitation3_office_hours_location }})-->
</p>


<p class="hang" markdown="1"><span class="emph">Class discussion board:</span> [Piazza]( {{site.piazza_site}}) <br>
Post all course related questions to the discussion board. If you have questions
related to your grading, you can post on Piazza privately or visit the office hours. <br>
For those registering late: you can [self sign up on Piazza]( {{site.piazza_signup}}) for this class (make sure you use
your netID email address, or you may end up being removed from the site once we update the roster).
</p>

<p class="hang" markdown="1"><span class="emph">Tutors:</span>  the tutors are going to be available starting
the second week of classes in room {{site.tutor_location}}; here is their [schedule]( {{ site.tutor_schedule_link }}) (updated with any last minute changes)
</p>


<p class="hang" markdown="1"><span class="emph">How to get help?</span> </p>

- ask questions on the class discussion forum (Piazza) and read the questions posed by other students
- ask questions in recitations and during lectures
- get help from the tutors
- talk to us (we cannot help, unless we know there is an issue).
- go to office hours

<p>
Make sure you let us know as soon as you feel lost in the course. Do not wait till you
start getting failing grades because it might be too late by then.
</p>



# Course Description
---
**Data Structures**

CSCI-UA 102 Prerequisite: Introduction to Computer Science (CSCI-UA 101). <br>
__NOTE: The prerequisite means that you DO NEED TO KNOW AND REMEMBER the material from CSCI-UA 101.__<br>
Offered in the fall and spring. 4 points.<br>
Use and design of data structures, which organize information in
computer memory. Stacks, queues, linked lists, binary trees:
how to implement them in a high-level language, how to analyze their
effect on algorithm efficiency, and how to modify them.
Programming assignments.<br>

__This course assumes that students had at least one semester course in Java programming language.
All programming assignments are given in Java and students need to be able to write fairly involved
programs from the very first project.__

# Important Dates
---

<p class="hang" markdown="1"> **Midterm Exam (these dates may change if there are any class schedule changes):** <br>
{{ site.midterm_exam_date }}
</p>
<p class="hang" markdown="1"> **Final Exam:**
(date and time subject to change by CAS, check the dates posted by the department
[here]( {{site.final_exams_link}} ) ) <br>
{{ site.final_exam_date }}
</p>

{% include   {{ site.info }} %}

<br>
<br>
