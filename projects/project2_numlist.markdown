---
layout: lab
title: Project 2
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__due date:__ February 23 at 11:59pm

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 2: Long Numbers

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other public or private forum). If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and Regions of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.
</div>

---
<br/><br/>
### Introduction and objectives


You are going to implement a class that allows us to represent numbers with unlimited number of digits. Your class will provide several operations that can be applied to such numbers.

In the process of doing this, you will practice your newly acquired skills of linked list manipulation.



<br/><br/>

__Main goals__:

- working with multi-file programs that include code written by others
- implementing a class given a specification
- implementing your own linked list

**Start early!** It may not seem like this project requires a lot of coding, but
debugging always takes time!


<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox"  checked=true >
<label for="interface" class="lbl-toggle"> User Interface </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program that provides the user interface is given to you. You can see
its [source code](project2/LongNumbers.java) and its [documentation](project2/project2/LongNumbers.html).


</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox" checked=true >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

This program does not use any command line arguments.

</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox" checked=true >
<label for="user" class="lbl-toggle"><code>Number</code> class </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your job for this project is to provide the implementation for the `Number` class.

You can find the documentation for its public methods [here](project2/project2/Number.html).

**Requirements and restrictions**
- The class has to use a linked list to represent the object. In fact, `Number` is
a linked list. You can implement it as a singly linked list of nodes that contain single digits. You can use dummy nodes at the start and end of the list, if you wish (but this is not something we discussed in class).
- The class should have an internal private `Node` class.
- You are not allowed to use any kind of `List` implementation provided by Java libraries.
- You are not allowed to use the `BigInteger` class provided by Java Libraries.
- All manipulations required to implement addition, multiplication and comparisons have to
be performed on nodes of the list. (You cannot convert the objects to their integer or string
equivalents and perform the operations on `int`, `Integer` or on characters of a string.)
Any kind of numerical computations
have to be performed on single digits only (although in some cases the result may have more than one digit).

In order to implement the addition and multiplication you should recall the methods of
performing these operations by hand (or long hand operations). If you do not remember how to
do this, here are some tutorials:
- [Long Hand Addition](http://www.makemathwork.com/help/topic_addition.htm)
- [Long Hand Multiplication](https://www.wikihow.com/Do-Long-Multiplication)
(There are many others you can find online.)

Hint: the function `multiplyByDigit()` in the `Number` class may come in handy in implementing
the general `multiply` operation. 



</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true">
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You do not need to implement any other classes, but you may if you wish. 

</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  checked=true >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102/notes/CodeConventions.pdf)
posted on the course website.

- You may not use any of the collection
classes provided in Java libraries. Do not use `LinkedList`, `Stack`, `Queue`,  or any classes implementing the `List` or `Queue` interfaces).

- You may not use the `BigInteger` class.

- You may use any exception-related classes.


</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  checked=true >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- Start by creating a skeleton of the class with all the required methods as stubs
(methods that take the right kind of argument, return the right type of value and, in practice, return
either 0 or null). This way your code compiles and can be run against the autograder
even if you cannot implement all of the methods.
- Work out the addition, multiplication and comparison algorithms by hand first. There are many details that you will need to think about and that may need you to completely rewrite your code
if you start by coding right away.
- Implement and test your methods one by one. Write the documentation for each method as you are
implementing it (yes, in this case you can copy and past from the [Number](project2/project2/Number.html) class. This makes you think about all the required pieces. Make sure that your code satisfies all the requirements from the documentation.



</div> </div></div>

<div class="wrap-collabsible">
<input id="grading" class="toggle" type="checkbox"  checked=true >
<label for="grading" class="lbl-toggle"> Grading </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


If your program does not compile or if it crashes (almost) every time it is run,
you will get a zero on the assignment. Make sure that you are submitting
functioning and documented code, even if it is not a complete implementation so that you can get partial credit.

If the program does not adhere to the specification, the grade will be low and
will depend on how easy it is to figure out what the program is doing and how to work with it.

The grade will be determined by several factors:
- 30 points: correct behavior of the program when run as the whole (i.e., we will run the
`LongNumbers` class that uses your implementation of the `Number` class)
- 30 points: correct behavior of the methods of the `Number` class
- 25 points: design, implementation and efficiency of the `Number` class
    (this will be determined by a code review)
- 15 points: proper documentation, program style and format of submission
   (this will be determined by a code review)

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox"  checked=true>
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

__For the purpose of grading, your project must be in the package called `project2`.
This means that each of your submitted source code files should start with a line:__

`package project2;`


Your should submit all your source code files (the ones with `.java` extensions only)
in a single __zip__ file or as individual file to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. You can see all the files on Gradescope.
Verify that there is nothing there that you did not intend to put it. You __DO NOT__ need to submit
the `LongNumbers.java` file.

You can produce a zip file directly from Eclipse (if this is what you are using):
 -  right click on the name of the package (inside the `src` folder) and select Export...
 -  under General pick Archive File and click Next
 -  in the window that opens select appropriate files and settings:
	 -  in the right pane pick ONLY the files that are actually part of the project,
		but make sure that you select all files that are needed
	 -  in the left pane, make sure that no other directories are selected
	 -  click Browse and navigate to a location that you can easily find on your system (Desktop or folder with the course materials or ...)
	 -  in Options select "Save in zip format", "Compress the contents of the file" and "Create only selected directories"
 -  click Finish

You may resubmit to Gradescope as many times as you wish before the submission link closes. But if you resubmit
after the grace period ends, your assignment will be subject to the late point deductions.

Some of the autograder tests for this project will be hidden. This means that you need to make the effort
to test your own implementation before you make the final submission.



</div> </div></div>


<div class="wrap-collabsible">
<input id="appendix" class="toggle" type="checkbox" checked=true>
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

#### Sample Run of The Program

```
123 + 987
1110
123 * 1111111111111111111111111111111111111
136666666666666666666666666666666666653
11111111111111111111111111111111111111 + 99999999999999999999999999999999999999999999999999999
100000000000000011111111111111111111111111111111111110
123 < 987
true
123 >= 9876
false
123 == 123
true
123 <> 123
false
33333333333333333333333 * 11
366666666666666666666663
33333333333333333333333*11
Illegal expression found: 33333333333333333333333*11
7 +3
Illegal expression found: 7 +3
100000000000000000 - 9999999999999999
Illegal operator found: 100000000000000000 - 9999999999999999

```

<br>
<br>
<br>

</div> </div></div>


</main>
