---
layout: lab
title: Project 3
---

<div class="lab-right" markdown="1">
__Project 3__ <br>
__due date:__ March 30 at 11:59pm

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 3:  Finding Your Way Out Of A Maze

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


<iframe width="560" height="315" src="https://www.youtube.com/embed/oUfjXUra0cM?rel=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen style="float:right; margin:10px" ></iframe>

You are going to write a program that uses our new data structures, stack and queue, to explore a maze and,
hopefully, find a way out of it. There are many algorithms that use different data structures and different
strategies to explore mazes. In this assignment you will try three such approaches. In all of these approaches
you will start from some initial position within the maze and evaluate the neighboring locations until either you
find a way out, or you discover that there is no way out. The rough outline of the approaches is to
examine locations around the current position and decide which need to be examined further and which definitely
do not lead to an exit (more details below in the algorithm description).



<br/><br/>

__Main goals__:
be able to get out of a maze.

The other goal of this programming project is for you to master (or at least get practice on) the following tasks:

-  using and understanding command line arguments
-  implementing stack and queue classes according to the provided interface
-  implementing recursive algorithms
-  writing classes
-  working with existing code

**Start early!** This project should take a fairly short time to implement, but testing and debugging always take time.

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox" checked=true >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is run with __two command line arguments__ (you can either run it in a terminal or in an IDE, like Eclipse, as long as
there is a way of specifying the command line arguments for the program).

If the program is run with fewer than two arguments, it is an error (the program prints an error message and terminates).

If the program is run with more than two arguments, the additional arguments are ignored.

The first command line argument is a name of an input file containing a maze to be used by the program. (This project
comes with two such files. You can, and should, create your own mazes for testing.)
The name of the file can be entered as an absolute or relative path.

The second command line argument is one of the following keywords: `stack`, `queue`, or `rec`. If any other keyword is
used, the program prints a message indicated that this option is not supported.
(The meaning of the keywords is described below.)


</div> </div></div>

<div class="wrap-collabsible">
<input id="algorithm" class="toggle" type="checkbox" checked=true >
<label for="algorithm" class="lbl-toggle"> Algorithm </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


You should be able to solve the above maze on paper easily. But how do you tell a computer to find a way out?
The computer cannot just look at the whole maze and figure out where the nearest exit is. Think of yourself
being stuck in a maze without having a _global_ view. You only have a local view of what is immediately next to
you and before you take a step it might be wise to decide if there ever might be a reason to come back to your
current location. The algorithm below describes this type of search for a way out of a maze.

The program should keep a set of locations that need to be examined (places that we might need to get back to in order to test another alternative,
for example when we have two choices and we can only follow one of them right away).
The exact representation of this set does not matter from the point of view of the algorithm.
At the very beginning the set consists of a single location that is the initial position.
We explore the maze by repeating the following steps:


- if the set is empty, there is no way out of the maze - algorithm ends;
- otherwise we take the next element from the set
  -  if the location that we just picked has been visited before, no need to look at it again, we skip the rest of this step
  -  if the location is an exit, we found the solution - algorithm ends
  -   otherwise, we examine all of the neighbors of that location
    (the order does not matter and for a more interesting simulation, the order of "examining the neighbors" should be randomized),
    for each location that is not a wall, we add it to the set of locations we are maintaining and then mark the current location as visited

The iterative version of this algorithm is implemented for you.
- __Your first task is to provide two different implementations for the "set of locations" that is used in the algorithm. For this purpose you need to implement a stack of locations and a queue of locations (details below).__
- __Your second task is to rewrite the algorithm in such a way that it does not require the use of additional data structure (i.e., the stack or the queue). Such algorithm should be recursive.__ The code provides the basic structure of the wrapper function, but you need to design the actual recursive part of it.

</div> </div></div>

<div class="wrap-collabsible">
<input id="implementation" class="toggle" type="checkbox" checked=true >
<label for="implementation" class="lbl-toggle">Implementation </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The project comes with several classes that provide a program that implements a maze simulation.
Study the source code to understand what it is doing.

The classes given to you are:
- `Labyrinth` - the class that represents a 2D rectangular maze
- `Simulation`- the actual program that simulates an exploration of a maze
- `PossibleLocations` - the interface that provides requirements for the two classes that you need to implement
- `Location` - the class that represents a position/location of a single square in the maze
- `SquareType` - the enumerated type describing different types of squares in the maze
- `LabyrinthSearchException` - the exception type thrown by the `Labyrinth` class

Your task is to provide two different implementations of the `PossibleLocations` interface and the recursive version of the `searchForWayOut` algorithm.


__You may implement additional classes if you wish. You are not allowed to modify any of the classes provided to you as part of this project with the only exception being the implementation of the `searchForWayOut` method in the `Simulation` class.__


### `PossibleLocationsStack` class

This class should implement the `PossibleLocations` interface. __It should be a reference based stack__ (the implementation should use
a linked list like storage for its nodes) - the program will not get credit for this part if the stack is implemented in a different way. You have to implement all of this class yourself. You cannot use any of the Java
provided classes that implement a stack or a list.

Note that in order to implement the interface the typical `push` method needs to be called `add` and the typical `pop` method
needs to be called `remove`.

You my implement additional methods if you wish.


### `PossibleLocationsQueue` class

This class should implement the `PossibleLocations` interface. __It should be an array based queue__ (the implementation should use
an array, not an `ArrayList` object, as storage) - the program will not get credit for this part if the queue is implemented in a different way. You have to implement all of this class yourself. You cannot use any of the Java
provided classes that implement a queue or a list.

This class should be able to handle any number of elements to be stored in the queue. This means that you will need to _grow_
the array when its size reaches the capacity of the storage array. Make sure that this is done efficiently.

This class should provide two constructors:
- a default constructor
- a one parameter constructor that takes a single integer as its parameter - this value indicates the initial capacity of the
 array

### `searchForWayOut` recursive method in the `Simulation` class

This method should provide a recursive implementation of the algorithm that finds the way out of the maze. It should follow the same logic as its recursive version.
It cannot use a stack or queue to store the possible location that need to be revisited.



</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  checked=true >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_s22/notes/CodeConventions.pdf)
posted on the course website.

- You may not use any of the collection
classes provided in Java libraries. Do not use `LinkedList`, `Stack`, `Queue`,  or any classes implementing the `List` or `Queue` interfaces). You may use the `ArrayList` class within your recursive method to store the return values from functions in other classes defined in the project.

- You may use any exception-related classes.


</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  checked=true >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- Start by creating a skeleton of the classes with all the required methods as stubs
(methods that take the right kind of argument, return the right type of value and, in practice, return
either 0 or null). This way your code compiles and can be run against the autograder
even if you cannot implement all of the methods.
- The two classes and the recursive algorithm are independent of one another. You can implement one thing at a time and failing to implement or complete one will not affect grading of the other parts.
- Implement and test your methods one by one. Write the documentation for each method as you are
implementing it (yes, in this case you can copy and paste much of the documentation from the documentation of the interface). This makes you think about all the required pieces. Make sure that your code satisfies all the requirements from the documentation.



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
- 50 points: correctness: correct behavior of methods of the required classes (this will be determined by the autograder and some manual evaluation)
- 30 points: design, implementation and efficiency of the required classes and any additional classes
    (this will be determined by a code review)
- 20 points: proper documentation, program style and format of submission
    (this will be determined by a code review)


</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox"  checked=true>
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

__For the purpose of grading, your project must be in the package called `project3`.
This means that each of your submitted source code files should start with a line:__

`package project3;`


Your should submit all your source code files (the ones with `.java` extensions only)
in a single __zip__ file or as individual files to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. You can see all the files on Gradescope.
Verify that there is nothing there that you did not intend to put it. You __DO NOT__ need to submit
the the classes that you did not modify (i.e., do not submit the
`Labyrinth`, `PossibleLocations`, `Location`, `LabyrinthSearchException` or `SquareType` classes).

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
<label for="appendix" class="lbl-toggle"> Sample Runs of The Program </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


<iframe width="560" height="315" src="https://www.youtube.com/embed/oUfjXUra0cM?rel=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

<iframe width="560" height="315" src="https://www.youtube.com/embed/oDLOrhI1Cz4?rel=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

<iframe width="560" height="315" src="https://www.youtube.com/embed/phmEd_NcfHA?rel=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

<iframe width="560" height="315" src="https://www.youtube.com/embed/fgi9P1j-71Q?rel=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

<iframe width="560" height="315" src="https://www.youtube.com/embed/aLifhWtNiJM?rel=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

<iframe width="560" height="315" src="https://www.youtube.com/embed/O5MYRnRdPQ4?rel=0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

<br>
<br>
<br>

</div> </div></div>


</main>
