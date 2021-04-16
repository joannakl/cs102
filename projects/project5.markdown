---
layout: lab
title: Project 5
---

<div class="lab-right" markdown="1">
__Project 5__ <br>
__due date:__ May 2

__submission mode:__ individual



</div>

<main markdown="1" class="lab">

## Project 5: BST-Mountain Adventure

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

The goal of this project is to implement a program that uses a binary search tree to model a mountain hiking expedition: A hiker starts at the top of the mountain.
They need to find their way down the mountain with limited resources to survive and overcome obstacles. Your program will produce a list of all the possible paths that
the hiker should take to survive.

The mountain is represented by a binary search tree. Nodes in this tree represent a rest-stops. The hiker restocks their supplies at those rest-stops. But they may also
encounter obstacles at the rest-stops. Some of the supplies that they carry with them may help them pass through the obstacles. The paths from the root down represent possible trails.
One the hiker starts a single path, they do not have an option of going back. Some of the paths lead to cliffs, others leads to the bottom of the mountain.
See example below for more details.



**Start early!** This project may not seem like much coding, but debugging and testing always takes time, especially for recursive algorithms.

---
<br/>

The credit for this project idea goes to Karl R. Rosenberg and Abhinav Gupta.
<br/>

<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox" checked=true >
<label for="interface" class="lbl-toggle"> User Interface </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program has to be a console based program (no graphical interface).
The user should not be prompted for any information (all required information for the program to run is provided in the input file given as a command line argument).
The output of the program should be printed to standard output stream.
Any error messages should be printed to the standard error stream.


</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox" checked=true >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is started from the command line (or run within an IDE). It expects one command line argument: the name of the input file.
<br>

The input file will be a test file. Each line in the input describes a single point on the mountain (node in a BST). The format of each line is as follows:

` LABEL  SUPPLIES  OBSTACLES`

In the above, `LABEL` is a string with the name of the rest stop. The alphanumeric comparison of the labels determines the shape of the tree.
`SUPPLIES` is a (possibly empty) list of supplies that the hiker will get at this rest-stop. Valid supplies are `food`, `raft`, `axe`.
`OBSTACLES` is a (possibly empty) list of obstacles that the hiker will encounter at this rest stop.  Valid obstacles are `fallen tree` and `river`.

See below for an example.


If the program is executed with non-existent or invalid command line argument, it should print an error message and terminate.

If the file contains any additional (and invalid) strings in the description of a rest-stop, they should be ignored.

The program \textbf{should not be interactive}. All input should be provided as the command line arguments. The user should not be prompted
for any additional information.
</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"   checked="true">
<label for="user" class="lbl-toggle"> Results/Output </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The program has to calculate all possible paths down the mountain that lead all the way down that the hiker can take and survive.

The program output should consist of number of lines equal to the number of safe paths.
Each safe path should consist of a space separated list of the rest-stop labels in order in which they are followed from top of the mountain to the bottom.
The paths should be printed in order from _left_ to _right_ in the tree that represents the mountain.

</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true">
<label for="classes" class="lbl-toggle"> Example </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


<center>
<img width="800" alt="Way Finder Example" src="img/BST-mountain.jpg" />
</center>

The above figure depicts visually a tree that results from the following input file

```
J food raft food
E fallen tree
G food axe river
I food fallen tree
H
F
B food
A
D axe food
P
L food food river
R axe food raft
Q
K
N axe
M
O
```


`food` is a single ration that lasts hiker the time needed to traverse a single segment of the trail (a single edge in the tree)

`axe` is needed when the trail is obstructed by a `fallen tree`. The hiker cannot pass a `fallen tree` obstacle unless they have an `axe`.
Once they use the `axe`, it becomes dull and cannot be used again.

`raft` is needed when the train continues through a river. The hiker cannot pass a `river` obstacle unless they have a `raft`.
Each `raft` is designed for single river crossing - once used, it cannot be used again.

There are many possible paths down the mountain depicted above, but only two lead to safety.

- `J E B A`, `J E B D C`, `J E G F`, `J E G I H` - the hiker reaches rest-stop `E` and cannot continue without an `axe`.
- `J P L K` - the hiker reaches rest-stop K and falls off the cliff.
- `J P L N M`, `J P L N O` - the hiker uses the `raft` at rest-stop `L` and with new food supplies continues to the bottom of the mountain at either `M` or `O`.
- `J P R Q` - the hiker reaches rest-stop Q and falls off the cliff.

In this case, the program should produce two lines of output:

```
J P L N M
J P L N 0
```


</div> </div></div>




<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true">
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The design of classes is up to you, but you do need to implement certain classes to represent certain entities in the program. You need to make decisions about how to design these classes to produce an efficient and well-put-together program. Make sure that all methods that you include in a particular class belong in that class.


#### <code class="code_title">BSTMountainAdventure</code> class

This is the class that is the program. This means it has the 	`main` method. This class is responsible for parsing and validating
the command line arguments, reading and parsing the input file, producing any error messages,
handling any exceptions thrown by other classes, and producing output.

#### <code class="code_title">BSTMountain</code> class

This should be the class that reuses as much as you can of the `BST<E>` class that we have been using during lectures and recitations.
Your class should represent the mountain itself (therefore, it should not generic and its nodes should store data items of type `RestStop`).
It is up to you to decide how to implement this class, which methods to provide etc. The only restriction is that it must implement an actual binary search tree.
You cannot just use one of the BST implementations that is in Java libraries.


#### <code class="code_title">RestStop</code> class

This class should represent a single rest stop. It should be capable of storing the label of the rest stop along with a list of the supplies that a hiker
can collect at this rest-stop and a list of obstacles  that a hiker may encounter at this rest-stop. It may be useful to implement the `Comparable` interface.



#### <code class="code_title">Hiker</code> class

This class should represent a hiker traveling down the mountain. An object of this class should be capable of keeping track of all the supplies that the hiker
has in their possession. This information should be updated as the hiker travels along a trail and consumes supplies (by either eating along the way, or using the tools
to clear the path, or cross the river).


You may, but you are not required to, implement other classes.

</div> </div></div>



<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_s21/notes/CodeConventions.pdf)
posted on the course website.

- You have to work with your own implementation of a BST class. It should be based on the one we have been using in class, but it cannot be based on one of the implementations in Java libraries.

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
- 50 points: class correctness: correct behavior of the program in many different input files
- 20 points: design and the implementation of your code
- 10 points: efficient implementation
   (this will be determined by a code review)
- 20 points: proper documentation, program style and format of submission
   (this will be determined by a code review)

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox" >
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

__For the purpose of grading, your project must be be in the package called `project5`.
This means that each of your submitted source code files should start with a line:__

`package project5;`


Your should submit all your source code files (the ones with `.java` extensions only)
either in a single __zip__ file or as individual files to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce, or any other files created by your operating system and file system.
You can see all the files on Gradescope.
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
