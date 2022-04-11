---
layout: lab
title: Project 4
---

<div class="lab-right" markdown="1">
__Project 4__ <br>
__due date:__ April 26

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 4: Implement Your Own BST

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

In this project you will implement a binary search tree class based on a given specification. The specification is similar to the one for
TreeSet class provided by Java libraries, but your implementation will be very different.
<br/><br/>

The goal of this programming project is for you to master (or at least get practice on) the following tasks:
- implementing and working with a binary search tree structure
- testing your own implementation
- using and implementing iterators
- implementing generic classes
- implementing existing interfaces (`Iterable`, `Iterator`)


<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox"  checked=true  >
<label for="interface" class="lbl-toggle"> Implementing <code>BST&lt;E&gt;</code> </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The specification for this class is provided at [its javadoc page](http://127.0.0.1:4000/cs102/projects/project4/project4/BST.html).
You can use the source code that we wrote in class, but keep in mind that the class that you are implementing requires additional
functionality and you may need to rewrite some of the methods that were created in class.

#### <code>Node</code> class

The program should provide and use a nested class (to
learn more about nested and inner classes see: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
that provides nodes for your tree. The details of the implementation of that class are
up to you, but this class should be private:
```java
private class Node
```
HINT: to improve the performance of your BST algorithms, it may be useful to keep additiional data fields in
the nodes, i.e., more than just data, left and right.
Those design decisions are up to you. But you should explain in comments for this class, why you have
additional data fields if you chose to do so.

#### Iterator

The `BST<E>` class implements `Iterable<E>` interface. This means that its `iterator()` method needs to
return an instance of a class that implements the `Iterator<E>` interface. The `iterator()` method should
return an iterator instance that accesses the
values in the tree according to the inorder traversal of the binary search tree.
The two additional methods `preorderIterator()` and
`postOrederIterator()` need to return iterators that access the values in the tree according
to the preorder and postorder traversals, respectively.

The details of the implementation are up to you and you are free to implement more than one internal private iterator class.
The `next()` and `hasNext()` methods of the iterator classes should perform in O(1). The constructor of the iterator classes
should be O(N).

The remove method in the `Iterator<E>` interface is optional and you do not need to
provide the actual remove functionality. (This means that the method has to exist,
but instead of performing its function, it throws an instance of `UnsopportedOperationException`.)



</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  checked=true  >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly. Most of the methods of this class are completely independent. You should implement and test one at a time. You do need to write your own tests (as jUnit tests or a driver program) to determine if your code behaves according to the specification.
- Make sure that at all times you __have a working code!__
You should also implement stubs of methods that return `0`, `null`, `false`, ... . This way your code compiles, even though it may
not work completely.
- You should __backup__ your code after each time you spend some time working on it.
Save it to a flash drive, email it to yourself, upload it to your Google drive, push it to a private git repository,
do anything that gives you a second (or maybe third copy). Computers tend to break just a few days or even
a few hours before the due dates - make sure that you have working code if that happens.

</div> </div></div>

<div class="wrap-collabsible">
<input id="grading" class="toggle" type="checkbox" checked=true   >
<label for="grading" class="lbl-toggle"> Grading </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


If your code does not compile or if it crashes (almost) every time it is run,
you will get a zero on the assignment. Make sure that you are submitting
functioning and documented code, even if it is not a complete implementation so that you can get partial credit.

If the program does not adhere to the specification, the grade will be low and
will depend on how easy it is to figure out what the program is doing and how to work with it.

The grade will be determined by several factors:
- 50 points: class correctness: correct behavior of methods (this will be determined by the autograder)
- 15 points: design and the implementation of your code (this will be determined by a code review)
- 25 points: efficient implementation
   (this will be determined by a code review).
- 10 points: proper documentation, program style and format of submission
   (this will be determined by a code review)

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox"  checked=true >
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
