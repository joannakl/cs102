---
layout: lab
title: Project 4
---

<div class="lab-right" markdown="1">
__Project 4__ <br>
__due date:__ November 15

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 4: WayFinder: A Recursive Puzzle Solver

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other forum). If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and features of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.
</div>

---
<br/><br/>
### Introduction and objectives

The goal of this project is to implement a program that finds all solutions to a number puzzle. __The solution that you will implement has to use
a recursive algorithm to find all the ways through the puzzle.__

The puzzle uses an array of positive integers. The objective is to find a _path_ from index zero to the last index in the array.
At each step we need to know the distance to be traveled and the direction.
Each entry in the array is a number indicating the distance to be traveled on this particular leg of the path.
The player (your program) needs to decide the direction (if the move should be made to the right or to the left).

Here is an example. In each step the bold number indicates the current location.
The starting position is always at index 0.

<img width="600" alt="Way Finder Example" src="img/way_finder_1.png" />

This puzzle has more than this one solution. The directions for each step can be altered to produce other solutions.

<br/><br/>


The goal of this programming project is for you to master (or at least get practice on) the following tasks:
- designing a program from scratch (deciding what classes and method should be part of the program)
- writing recursive functions



**Start early!** This project may not seem like much coding, but debugging and testing always takes time, especially for recursive algorithms.

In this project you need to decide how many classes you wish to create and what methods
need to be developed. You can take an approach that uses a single class or you can
take a more object oriented approach that uses more than one class. This is up to you.
You should name your program (i.e., the class with the `main` method) `WayFinder` - this
means that the class is implemented in a file called `WayFinder.java`.


<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox"  >
<label for="interface" class="lbl-toggle"> User Interface </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program has to be a console based program (no graphical interface).
The user should not be prompted for any information (all required information for the program to run should be
entered as command line arguments).
The output of the program should be printed to standard output stream.
Any error messages should be printed to the
standard error stream.


</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox" checked=true >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is started from the command line (or run within an IDE). It expects two command line arguments.
<br>

The program should be given the array to work with via __command line arguments__ (this is the `args` array parameter to the `main` method).
This means that the program should be run using, for example:

`    java WayFinder 3 6 4 1 3 4 2 5 3 0 `

The command line arguments represent the values for the array. Restrictions:
- all values have to be non-negative integers in the range of 0 to 99 inclusive
- the last value has to be zero


If the program is executed with non-existent or invalid command line arguments, it should print an error message and terminate.

The program __should not be interactive__. All input should be provided as the command line arguments. The user should not be prompted
for any additional information.


</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"  >
<label for="user" class="lbl-toggle"> Results/Output </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The program has to calculate and display __all possible solutions to the puzzle__ or determine that no such solutions exist.
The output of the program should match the format described below exactly (the correctness of the solutions will be determined based on
textual matching of the program's output to the correct solution).

The output for multiple paths through the puzzle should be separated by a single blank line.
The last line (after all the paths are printed) should conclude the total number of paths that can be successfully taken to solve the puzzle.

For each path, every step through the puzzle has to be displayed. For each step, the entire array should be printed and the _current_ location
should be indicated with either `L` or `R` indicating which direction the next step is taken in.

Each value in the array should be printed within a 2 digit field (right aligned) with additional space, or character `L` or `R` (for the
current value) following the number. The values should be separated by the commas and spaces immediately following the commas.
The entire array should be surrounded by square brackets.

The format of a 6-element array should be:

`[DDS,SDDC,SDDS,SDDS,SDDS,SDDS]`

where `D` stands for a digit, `S` stands for a space character, `C` stands for a character (either `L` or `R`) indicating the direction. Note that
there should only be one value in the entire array that is followed by the direction character!

Here are a few examples:

`[ 3 ,  4 , 11 ,  2L, 25 ,  0 ]` means that the current location is at index 3 and the next move will be two to the left

`[ 3 ,  4 , 11 ,  2R, 25 ,  0 ]` means that the current location is at index 3 and the next move will be two to the right

`[ 3R,  4 , 11 ,  2 , 25 ,  0 ]` means that the current location is at index 0 and the next move will be three to the right


__Hint:__ If you are not familiar with the `String.format()` method, this may be a good idea to learn more about it.

</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true">
<label for="classes" class="lbl-toggle"> Program Execution Examples </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>



Here are a few examples of the program execution.

Program run using:

`   java WayFinder  3 -2 9 0 `

```
ERROR: the puzzle values have to be positive integers.
```


Program run using:

`   java WayFinder  3 6 0 1 3 4 2 5 3 0 `

```
No way through this puzzle.
```



Program run using:

`   java WayFinder  2 1 2 0  `

```
No way through this puzzle.
```



Program run using:

`   java WayFinder  3 6 4 1 3 4 2 5 3 0 `

```
[ 3R,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1L,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4R,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2R,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3L,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4R,  2 ,  5 ,  3 ,  0 ]

[ 3R,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1R,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3L,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6R,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5L,  3 ,  0 ]
[ 3 ,  6 ,  4R,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2R,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3L,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4R,  2 ,  5 ,  3 ,  0 ]

[ 3R,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1R,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3R,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5L,  3 ,  0 ]
[ 3 ,  6 ,  4R,  1 ,  3 ,  4 ,  2 ,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2R,  5 ,  3 ,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4 ,  2 ,  5 ,  3L,  0 ]
[ 3 ,  6 ,  4 ,  1 ,  3 ,  4R,  2 ,  5 ,  3 ,  0 ]

There are 3 ways through the puzzle.
```



Program run using:

`   java WayFinder 6 9 3 10 2 1 5 8 9 1 2 5 4 8 10 7 6 0 `

```
[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5L,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9R,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2L,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]

[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5L,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9R,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2R,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4L,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]

[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5R,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5R,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6L,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2L,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]

[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5R,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5R,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6L,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2R,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4L,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]

There are 4 ways through the puzzle.
```

Note that the following is NOT a valid path since it performs extra unnecessary steps (a short loop marked with arrows) that are not needed in order to reach the end.

```
[ 6R,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5R,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]  <--
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5L,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]  <--
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5L,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9R,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9 ,  1 ,  2L,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
[ 6 ,  9 ,  3 , 10 ,  2 ,  1 ,  5 ,  8 ,  9R,  1 ,  2 ,  5 ,  4 ,  8 , 10 ,  7 ,  6 ,  0 ]
```



Program run using:

`   java WayFinder 0 `

```
[ 0 ]
There is 1 way through the puzzle.
```



</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_f21/notes/CodeConventions.pdf)
posted on the course website.

- You have to use a recursive algorithm to solve the puzzle. You will not get any credit for an iterative algorithm.

- You may use any exception-related classes.


</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly: for example, implement the part of the code that reads and parses the input file, then implement and test individual classes, then implement the part that provides the interactive part of the program, ... .
- Make sure that at all times you __have a working program!__
You should also implement stubs of methods that return `0` or `null`. This way your code compiles, even though it may
not work completely.  You can implement methods that perform one task at a time.
This way, if you run out of time, at least parts of your program will be functioning properly.
- You should make sure that you are __testing the program on much smaller data set__ for which you can determine the correct
output manually. You can create  a test input file that contains only a few rows.
- You should make sure that your program's results are consistent with what is described in this specification
by running the program on carefully designed test inputs and examining
the outputs produced to make sure they are correct.
The goal in doing this is to try to find the mistakes you have most likely made in your code. <br>
__DO NOT__ test your program on the entire large input file. This may take a long time and you will never know
if the results are correct or not.
- Each class that you submit __will be tested by itself without the context of other classes that you are implementing for this assignment__. <br>
This means that you need to make sure that your methods can perform their tasks correctly even if they are executed in situations that would not
arise in the context of this specific program.
- You should __backup__ your code after each time you spend some time working on it.
Save it to a flash drive, email it to yourself, upload it to your Google drive, push it to a private git repository,
do anything that gives you a second (or maybe third copy). Computers tend to break just a few days or even
a few hours before the due dates - make sure that you have working code if that happens.

</div> </div></div>

<div class="wrap-collabsible">
<input id="grading" class="toggle" type="checkbox"  >
<label for="grading" class="lbl-toggle"> Grading </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


If your program does not compile or if it crashes (almost) every time it is run,
you will get a zero on the assignment. Make sure that you are submitting
functioning and documented code, even if it is not a complete implementation so that you can get partial credit.

If the program does not adhere to the specification, the grade will be low and
will depend on how easy it is to figure out what the program is doing and how to work with it.

The grade will be determined by several factors:
- 60 points: class correctness: correct behavior of methods of the required classes and correct behavior of the program
	as a whole (this will be determined by the autograder)
- 10 points: design and the implementation of your code
- 10 points: efficient implementation of the required classes
   (this will be determined by a code review). Efficient algorithms should not explore
		paths that cannot possibly lead to an exit and should attempt to detect such situations as early as possible.
- 20 points: proper documentation, program style and format of submission
   (this will be determined by a code review)

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox" >
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

__For the purpose of grading, your project must be be in the package called `project4`.
This means that each of your submitted source code files should start with a line:__

`package project4;`


Your should submit all your source code files (the ones with `.java` extensions only)
in a single __zip__ file to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. You can see all the files on Gradescope.
Verify that there is nothing there that you did not intend to put it.

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



</main>
