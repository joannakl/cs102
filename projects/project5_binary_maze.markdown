---
layout: lab
title: Project 5
---

<div class="lab-right" markdown="1">
__Project 5__ <br>
__due date:__ Dec 4

__submission mode:__ individual



</div>

<main markdown="1" class="lab">

## Project 5: Binary Tree Maze

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other forum). If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and features of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.

If your submitted code matches closely or exactly code submitted by another person in the class, it will get a zero grade and the offense will be reported to the 
department and the dean. 
</div>

---
<br/><br/>
### Introduction and objectives

The goal of this project is to implement a program that uses a binary search tree to model a binary tree maze exploration: Our hero starts 
at the root of the maze and needs to find their way to the exit. Your program will produce a list of all the possible paths that
our hero can take to find the exit.

The binary tree maze is represented by a binary search tree. Nodes in this tree represent places where the paths fork. They are also 
places at which our hero can earn some life points. They use one life point to get from one node to the next.
When our hero starts on a particular path, they cannot go back. Some of the paths lead to trap doors (not a desirable scenario), others lead to exits. 
Your job is to supply a list of the paths that lead to exits. 
See example below for more details.



As usual: **Start early!** 


---

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

The input file describes the binary tree maze. Each line in the input is a single node in the maze (node in a BST). The format of each line is as follows:

`LABEL LIFE_POINTS`

In the above, `LABEL` is a string with the name of the node. The alphanumeric comparison of the labels determines the shape of the tree.
`LIFE_POINTS` is a number of life points that our hero can collect at that node. 

The binary maze tree should be constructed by adding nodes with specified labels to the tree one at a time in the order listed in the input file. 
See below for an example.


If the program is executed with non-existent or invalid command line argument, it should print an error message and terminate:

```
Error: the file FILE_NAME does not exist.
```

(where `FILE_NAME` is the name of the file that was specified on the command line). 

If the file contains any lines that do not contain sufficient node information, they should be ignored. For example: 
- If a line of the input file contains only one string,
the information for the life points is missing, so that line should be ignored. 
- If a line of the input file contains two string, as in `AA BB`, the line does not contain valid life point information, so that line should be ignored.   
- (But, note that the label itself can contain digits, so a line that contains a sring `111 2` is valid.)

If the file contains lines with additional strings after the life point specification, those additional strings should be ignored, but the line should be used to create a node. 

If the input file is empty (or does not contain any valid node descriptions), the program should print an error message and terminate: 

```
Maze does not contain any nodes.
```

The program **should not be interactive**. All input should be provided as the command line arguments. The user should not be prompted for any additional information.
</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"   checked="true">
<label for="user" class="lbl-toggle"> Results/Output </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The program has to calculate all possible paths through the maze that lead to the valid exits that are reachable by our hero. Valid exits are 
leaves in the tree that are at the lowest level. But our hero needs to have enough life points to reach such an exit. If the life points 
run out before the exit can be reached, the path to such an exit should not be listed among the ones recommended by your program. 

The program output should consist of a number of lines equal to the number of valid paths.
Each valid path should consist of a space separated list of the node labels in order in which they are followed from the root of the tree to 
the leaves that are valid exits.
The paths should be printed in order from _left_ to _right_ in the binary search tree that represents the maze (this is also the alphanumeric ordering of the paths).

</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true">
<label for="classes" class="lbl-toggle"> Example </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


<center>
<img width="600" alt="Binary Tree Maze Example" src="img/binary_tree_maze.png" />
</center>

The above figure depicts visually a tree that results from the following input file

```
J 2
G 1
Q 0
B 0
I 1
A 0
C 1
E 2
D 0
H 1
F 0
L 3
R 1
U 0
S 1
V 1
T 1
K 2
O 0
P 1
N 2
M 0
```

The starting point for the maze is at its root at node lebeled "J".
The valid exits from the maze are at the nodes at the lowest level. They are labeled "D", "F", "M", and "T". 
There are trap doors at any leaf node that is not at the lowest level. They are nodes labeled "A", "H", "K", "P", and "V". 

The tree also shows the number of life points that the hero can collect
at each of the life-points. Note that if a number of life points that our hero has in their position when they get to a node (including the points they collect at that node) is less than one, the hero cannot go anywhere since they need
exactly one life-point to travel from one node to the next. 

There are several possible paths through the maze depicted above, but not all of them are feasible since our here does not have a sufficient number of life points to travel down all of them. The four paths that reach the bottom-most level are `J G B C E D`, `J G B C E F`, `J Q L O N M`, and `J Q R U S T`. The last path does not allow our hero to collect enough life points to make it to the bottom-most level. 

In this case, the program should produce three lines of output in the order from left to right:

```
J G B C E D
J G B C E F
J Q L O N M
```


</div> </div></div>




<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true">
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The design of classes is up to you, but you do need to implement certain classes to represent certain entities in the program. You need to make decisions about how to design these classes to produce an efficient and well-put-together program. Make sure that all methods that you include in a particular class belong in that class.


#### <code class="code_title">BinaryTreeMaze</code> class

This is the class that is the program. This means it has the 	`main` method. This class is responsible for parsing and validating
the command line arguments, reading and parsing the input file, producing any error messages,
handling any exceptions thrown by other classes, and producing output.






#### <code class="code_title">BST&lt;E&gt;</code> class


This is a generic `BST<E>` class. The specification is similar to the one for
`TreeSet` class provided by Java libraries, but your implementation will be very different.

The specification for this class is provided at [its javadoc page](project5/project5/BST.html).
You can use the source code that we wrote in class, but keep in mind that the class that you are implementing requires additional
functionality and you may need to rewrite some of the methods that were created in class.

NOTE: normally, all data fields in the class should be private. But since the `BST` class serves as a base class for the `Maze` class below,
its data fields can be made protected instead to allow the subclass to access these data fields.

<br/>

__<code>Node</code> class__

The program should provide and use a nested class (to
learn more about nested and inner classes see: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
that provides nodes for your tree. The details of the implementation of that class are
up to you, but this class should be private (or protected, if there is a good reason for it):

```
private class Node
```

HINT: to improve the performance of your BST algorithms, it may be useful to keep additional data fields in
the nodes, i.e., more than just data, left and right.
Those design decisions are up to you. **But you should explain in comments for this class, why you have
additional data fields if you chose to do so.**

<br/>

__Iterator__


The `BST<E>` class implements `Iterable<E>` interface. the class should provide three different ways of iterating through the 
tree following three different orders: inorder, preorder and postorder. 

The default iterator is returned by the `iterator()` method. It should 
return an instance of a class that implements the `Iterator<E>` interface. The `iterator()` method should
return an iterator instance that accesses the
values in the tree according to the inorder traversal of the binary search tree.

The two additional methods `preorderIterator()` and
`postOrederIterator()` should return iterator objects that access the values in the tree according
to the preorder and postorder traversals, respectively.

The details of the implementation are up to you and you are free to implement more than one internal private iterator class.
**The `next()` and `hasNext()` methods of the iterator classes should perform in O(1). The constructor of the iterator classes
should be O(N).**

The remove method in the `Iterator<E>` interface is optional and you do not need to
provide the actual remove functionality. (This means that the method has to exist,
but instead of performing its function, it throws an instance of `UnsopportedOperationException`.)

RESTRICTION: You should not use an iterator that is already implemented in one of the Java classes (like the one in the `ArrayList` class). In practice, this would 
be a good idea, but the objective here is for you to implement your own iterators. 




#### <code class="code_title">Maze</code> class

This should be the class that inherits from your own `BST<MazeNode>`.
Your class should represent the maze itself (therefore, it should not be generic and its nodes should store data items of type `MazeNode`).
It is up to you to decide how to implement this class, which methods to provide etc. The important distinction is that the `Maze` class should contain all the methods that are specific to the maze itself, not the general BST methods that are inherited from the `BST` class. 


#### <code class="code_title">MazeNode</code> class

This class should represent the points in the maze at which our hero can collect life-points and at which they need to make a decisions as to which way to continue. It should be capable of storing the label of the node and the number of possible life points our hero can collect at this maze node. It may be useful (or may be even necessary) to implement the `Comparable` interface.

Note that his is NOT the same as the internal `Node` class for the `BST` class itself. It is the *data* stored in the node of the BST. 


#### <code class="code_title">Hero</code> class

This class should represent our hero traveling through the maze. An object of this class should be capable of keeping track of all the life points that our hero possesses at any given time. This information should be updated as the hero travels along the different potential paths through the maze. 

<br/>
<br/>

You may, but you are not required to, implement other classes.

</div> </div></div>



<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102/notes/CodeConventions.pdf)
document.

- You have to work with your own implementation of a BST class. It should be based on the one we have been using in class, but it cannot be based on one of the implementations in Java libraries.

- The BST class that you implement should be just a basic binary search tree. Do not try to implement a balanced tree (doing this will change the shape of the maze and will result in incorrect paths). 

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
- 45 points: class correctness: correct behavior of methods of the required classes (this will be determined by the autograder), these points will be assigned as follows:
	- 0 points: code passes fewer than a half of the autograder tests 
	- 20 points: code passes [50-70)% of the autograder tests 
	- 35 points: the code passes [70-80)% of the autograder tests
	- 40 points: the code passes [80-90)% of the autograder tests 
	- 45 points: the code passes 90% or more of the autograder tests 
- 10 points: correct behavior of the program when executed as a whole with several different intput files  
- 15 points: design and the implementation of your code (this will be determined by a code review)
- 15 points: efficient implementation
   (this will be determined by a code review)
- 15 points: proper documentation, program style and format of submission
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


Your should submit all your source code files (the ones with `.java` extensions only) to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. Do not submit the data
file or any data files that you might have created. 
Once you submit, you should look at all the files that Gradescope has - make sure there is nothing there that should not be there. 


You may resubmit to Gradescope as many times as you wish before the submission link closes. But if you resubmit
after the grace period ends, your assignment will be subject to the late point deductions.


For this project, you will see some of the results for the autograded unit tests. Some of the results will be hidden. (When some results are hidden, Gradescope does not display the score for the autograded part. )



</div> </div></div>



</main>
