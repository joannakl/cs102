---
layout: lab
title: Project 3
---

<div class="lab-right" markdown="1">
__Project 3__ <br>
__due date:__ <del>March 25 </del>March 30

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 3: Exploring a Maze

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


<img width="400" alt="Example Maze" src="img/maze01.png" style="float:right; margin:10px"/>

You are going to write a program that uses our new data structures, stack and queue, to explore a maze and,
hopefully, find a way out of it. There are many algorithms that use different data structures and different
strategies to explore mazes. In this assignment you will try two such approaches. In both of these approaches
you will start from some initial position within the maze and evaluate the neighboring spaces until either you
find a way out, or you discover that there is no way out. The rough outline of both approaches is to
examine spaces around the current position and decide which need to be examined further and which definitely
do not lead to an exit (more details below in the algorithm description).
<br/><br/>

__Main goal__: the main goal of this programming project is to get out of a maze.

The other goal of this programming project is for you to master (or at least
get practice on) the following tasks:

- working with multi-file programs
- writing classes
- implementing existing interfaces
- working with existing code
- implementing your own doubly linked list
- implementing your own stack and queue

**Start early!** This project requires you to write several classes and
debugging always takes time.


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

__But, this part of the project is already done, so you do not really need to worry about it.__

</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox" checked=true >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is started from the command line (or run within an IDE). It expects two command line arguments.
<br>

The first command line argument should be a name of an input file containing a maze to be used by the program. This project
comes with two such files, see the appendix. You can (and should) create your own mazes for testing.
The name of the file can be entered as an absolute or relative path.
<br>

The second command line argument should be one of the following keywords: `stack` or `queue` (or at least a keyword that starts with
the letter 's' or the letter 'q'). If any other keyword is
used, the program prints a message indicating that this option is not supported.
(The meaning of the two keywords is described below.)

The user may start the program from the command line or run it within an IDE like
Eclipse - __from the point of view of your program this does not matter__.

</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"  >
<label for="user" class="lbl-toggle"> Solving the Maze - An Algorithm </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>



You should be able to solve the above maze on paper easily. But how do you tell a computer to find a way out?
The computer cannot just look at the whole maze and figure out where the nearest exit is. Think of yourself
being stuck in a maze without having a ”global” view. You only have a local view of what is immediately next to
you and before you take a step it might be wise to decide if there ever might be a reason to come back to your
current location. The algorithm below describes this type of search for a way out of a maze.

The program should keep a set of spaces that need to be examined (places that we might need to get back to in order to test another alternative,
for example when we have two choices and we can only follow one of them right away).
The exact representation of this set does not matter from the point of view of the algorithm.
At the very beginning the set consists of a single space that is the initial position. We explore the maze by repeating the following steps:


- if the set is empty, there is no way out of the maze - algorithm ends;
- otherwise we take the next element from the set
	- if the space that we just picked has been visited before, no need to look at it again, we skip the rest of this step
	- if the space is a way out, we found the solution - algorithm ends
	- otherwise, we examine all of the neighbors of that space
  (the order does not matter and for a more interesting simulation, the order of "examining the neighbors" should be randomized),
  for each space that is not a wall, we add it to the set of spaces we are maintaining and then mark the current space as visited



__This algorithm is implemented for you. Your task is to provide two different implementations for the "set of spaces" that is used
in the algorithm. For this purpose you need to implement a stack of spaces and a queue of spaces (details below).__


</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true">
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The project comes with several classes that provide a program that implements a maze simulation.
Study the source code to understand what it is doing. You do not have to understand every detail (although there is no reason for you not to) to be
able to implement the parts of the program that are missing.

The classes given to you are:
-  [`Labyrinth`](project3/Labyrinth.java) - the class that represents a 2D rectangular maze
-  [`LabyrinthSearchException`](project3/LabyrinthSearchException.java) - the class defines the exception thrown by the `Labyrinth` class during the search process
-  [`Simulation`](project3/Simulation.java)- the actual program that simulates an exploration of a maze
-  [`PossibleLocations`](project3/PossibleLocations.java) - the interface that provides requirements for the two classes that you need to implement
-  [`Location`](project3/Location.java) - the class the represents a position/location of a single square in the maze
-  [`SquareType`](project3/SquareType.java) - the enumerated type describing different types of squares in the maze



Your task is to provide an implementation of a doubly linked list class and two different implementations
of the `PossibleLocations` interface (that use your own doubly linked list class for their internal storage) included in the project.

You may implement additional classes if you wish.
__You are not allowed to modify any of the classes or interfaces provided to you as part of this project. We will compile your code with the original definitions of those classes.__
(The only exception to this is if some changes are announced to the entire class to provide any corrections that may be needed.)

#### <code class="code_title">DoublyLinkedList</code> class

Your class should be called `DoublyLinkedList<E>`. It should be a generic class that does not permit `null` elements.

Your class should implement the following methods and interfaces:

- `boolean   add​(E e)   `

	Appends the specified element to the end of this list. Returns `true` if this list changed as a result of the call. Returns `false`
	if the specified element is `null`.

	Parameters:

  `  e` - element to be appended to this list

	Throws:

    `ClassCastException` - if the class of the specified element prevents it from being added to this list

- `boolean   add​(E e, int pos)   `

	Inserts the specified element at the specified position `pos` in this list. Shifts the element currently at that
	position (if any) and any subsequent elements to the right (adds one to their indices).
	Returns `true` if this list changed as a result of the call. Returns `false`
	if the specified element is `null`.

	Parameters:

  `  e` - element to be added to this list

	`  pos` - position at which the element should be added;  `0 <=pos <= size()`

	Throws:

	`ClassCastException` - if the class of the specified element prevents it from being added to this list

	`IndexOutOfBoundsException` - if `pos` is out of range `(pos < 0 || pos >= size())`

- `void   clear()   `

	Removes all of the elements from this list. The list will be empty after this call returns.

- `boolean   contains​(Object o)   `

	Returns `true` if this list contains the specified element.
	More formally, returns `true` if and only if this list contains at least one element `e` such that `Objects.equals(o, e)`.

	Parameters:

  `  o` - element whose presence in this list is to be tested

- `boolean   equals​(Object o)   `

	Compares the specified object with this list for equality. Returns `true` if and only if the specified
	object is also an instance of a `DoublyLinkedList` , both lists have the same size, and all corresponding pairs of elements in the two lists are equal.
	In other words, two lists are defined to be equal if they contain the same elements in the same order.

	Parameters:

	`  o` - the object to be compared for equality with this list


- `E get(int pos) `

	 Returns the element at the specified position in this list or `null` if such position does not exist.

	 Parameters:

	 ` pos` - index of the element to return

- `boolean   isEmpty()   `

	Returns `true` if this list contains no elements.


- `int indexOf( Object o ) `

	Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	More formally, returns the lowest index `i` such that `(o==null ? get(i)==null : o.equals(get(i)))`, or `-1` if there is no such index.

  Parameters:

  `   o` - element to search for

- `boolean   remove​(Object o)   `

	Removes the first occurrence of the specified element from this list, if it is present.
	If this list does not contain the element, it is unchanged. More formally, removes the
	element with the lowest index `i` such that `Objects.equals(o, get(i))` (if such an element exists).
	Returns `true` if this list contained the specified element (or equivalently, if this list changed as a result of the call).

	Parameters:

	`o` - element to be removed from this list, if present

	Throws:

	`ClassCastException` - if the type of the specified element is incompatible with this list

	`NullPointerException` - if the specified element is `null`


- `E  remove​(int pos)   `

	Removes the element at the specified position `pos` in this list.
	Shifts any subsequent elements to the left (subtracts one from their indices).
	Returns the element that was removed from the list.

	Parameters:

	`pos` - the index of the element to be removed

	Throws:

	`IndexOutOfBoundsException` - if `pos` is out of range `(pos < 0 || pos >= size())`

- `int size()    `

	Returns the number of elements in this list.


-  `String toString()`

   Returns a string representation of this list.
	The string representation consists of a list of the collection's elements in the order they are
	returned by its iterator, enclosed in square brackets (`"[]"`).
	Adjacent elements are separated by the characters `", "` (comma and space).
	Elements are converted to strings as by `String.valueOf(Object)`.


- `Iterable<E>` interface

	- `Iterator<E>   iterator()   `
	Returns an iterator over the elements in this list. This iterator should return elements in the same order
	in which they are stored in this list.


#### <code class="code_title">StackOfSpaces</code> class
This class should implement the `PossibleLocations` interface. It should be a reference based stack that uses your
own doubly linked list as the internal storage. Note that in order to implement
the interface the typical `push` method needs to be called `add` and the typical `pop` method
needs to be called `remove`.

You my implement additional methods if you wish.

#### <code class="code_title">QueueOfSpaces</code> class
This class should implement the `PossibleLocations` interface.  It should be a reference based stack that uses your
own doubly linked list as the internal storage. Note that in order to implement
the interface the typical `enqueue` method needs to be called `add` and the typical `dequeue` method
needs to be called `remove`.

You my implement additional methods if you wish.



</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_s21/notes/CodeConventions.pdf)
posted on the course website.

- The data file should be read only once! Your program needs to store the data
in memory resident data structures.

- You may not use any of the collection
classes provided in Java libraries. Do not use `LinkedList`, `Stack`, `Queue`,  or any classes implementing the `List` or `Queue` interfaces).

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
- 50 points: class correctness: correct behavior of methods of the required classes and correct behavior of the program
	as a whole (this will be determined by the autograder)
- 20 points: design and the implementation of the required classes and any additional classes
   (this will be determined by a code review)
- 10 points: efficient implementation of the required classes
   (this will be determined by a code review)
- 20 points: proper documentation, program style and format of submission
   (this will be determined by a code review)

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox" >
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

__For the purpose of grading, your project must be be in the package called `project3`.
This means that each of your submitted source code files should start with a line:__

`package project3;`


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


<div class="wrap-collabsible">
<input id="appendix" class="toggle" type="checkbox" checked=true>
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

#### Input files

You can download two sample input files:
- [maze01.txt](project3/maze01.txt)
- [maze02.txt](project3/maze02.txt)

Legend for the mazes:
- `x` indicates a solid wall (no way to pass)
- `o` indicates an exit (this should be used only around the outer walls)
- ` ` (empty space) indicates open corridors

#### Sample Runs

- [using maze01.txt file and a stack](https://youtu.be/8YqiFVMHLlE)
- [using maze01.txt file and a queue](https://youtu.be/k4D4jHmK3KI)
- [using maze02.txt file and a stack](https://youtu.be/xbDSQrH7_sk)



<br>
<br>
<br>

</div> </div></div>


</main>
