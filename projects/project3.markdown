---
layout: lab
title: Project 3
---

<div class="lab-right" markdown="1">
__Project 3__ <br>
__due date:__ October 29

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 3: Implementing Lists, Stacks and Queues

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub or any other public forum). If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and features of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.
</div>

---


<br/><br/>
### Introduction and objectives

In this project you __will not__ be writing a complete program. Instead, you will be developing
classes that implement given interfaces. In order to check the correctness of your implementation
you should create your own programs that use your classes and test each of the implemented methods carefully.

<br/>

The goal of this programming project is for you to master (or at least
get practice on) the following tasks:


- writing classes
- implementing interfaces
- implementing your own linked list
- implementing your own stack
- implementing your own queue
- testing your own code

**Start early!** This project may not seem like much work, but
debugging always takes time.



<div class="wrap-collabsible">
<input id="list" class="toggle" type="checkbox" >
<label for="list" class="lbl-toggle"> Linked list </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

A doubly linked list that implements the following interface.
 The name of your class should be `MyList<E>`.


```java
// List  ADT
public interface List<E> {

	/**
	* Adds an element 'item' at position `pos`, shifts elements starting at `pos` by
	* one position to the right (higher position values)
	* @param item the element to be added to this list
	* @param pos postion at which `item` should be added
	* throws NoSuchElementException if `pos` < 0 or `pos` > size
	* throws IllegalArgumentException if `item == null`
	*/
	public boolean add(E item, int pos) throws NoSuchElementException;

	/**
	* Removes and returns an element at position `pos`, shifts elements starting
	* at `pos+1` by one to the left (lower position values)
	* @param pos the position from which the element should be removed
	* @ return the element removed from the list
	* throws NoSuchElementException if pos < 0 or pos >= size
	*/
	public E remove(int pos) throws NoSuchElementException;

	/**
	* Removes and returns an element equal to `item`, shifts elements starting
	* at the next position by one to the left (lower position values)
	* @param item element to remove
	* @return the removed element, or null if element equal to `item` is not in this list
	*/
	public E remove (E item);

	/**
	* Determines if 'item' is in the list and if so returns its position
	* @param item to locate in this list
	* @return position of `item` in this list or -1 if `item` is not found in this list
	*/
	public int find (E item) ;

	/**
	* Retrieves and returns an element from position `pos`
	* @param pos the position of item to return
	* @return element stored at position `pos`
	* throws NoSuchElementException if pos < 0 or pos >= size
	*/
	public E get( int pos) throws NoSuchElementException;

	/**
	* Returns the current number of elements in this list
	* @return the number of elements in this list
	*/
	public int size();

	/**
	* Removes all elements from this list, so it is once again empty.
	*/
	public void clear();

	/**
	* Determines if this list is equal to `obj`.
	* @obj an Object that is compared to this list for equality
	* @return true if this list is equal to `obj` (same elements in the same order)
	*         false, otherwise
	*/
	public boolean equals(Object obj);

	/**
	* Returns a string representation of this list. The string is constructed by
	* concatenating all elements of this list separated by a comma and a single space.
	* There should be no comma after the last element.
	* @return a string representation of this list.
	*/
	public String toString ();
}

```

</div> </div></div>



<div class="wrap-collabsible">
<input id="stack" class="toggle" type="checkbox" >
<label for="stack" class="lbl-toggle"> Stack </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

A stack using singly linked reference structure that implements the following interface.
 The name of your class should be `MyStack<E>`.

```java
//Stack ADT

public interface Stack<E> {
	/**
	* Add an element to the top of this stack
	* @param item to be added to this stack
	* throws IllegalArgumentException if `item == null`
	*/
	public void push ( E item ) ;

	/**
	* Remove and return the element from the top of this stack
	* @return the element from the top of this stack or null if this stack is empty
	*/
	public E pop () ;

	/** Return the element from the top of this stack.
	* @return  the element from the top of this stack or null if this stack is empty
	*/
	public E top () ;

	/**
	* Determines if this stack is equal to `obj`.
	* @obj an Object that is compared to this stack for equality
	* @return true if this stack is equal to `obj` (same elements in the same order)
	*         false, otherwise
	*/
	public boolean equals(Object obj);

	/**
	* Returns a string representation of this stack. The string is constructed by
	* concatenating all elements of this stack separated by a comma and a single space.
	* The bottom of the stack should be the leftmost element and the top of the stack
	* should be the rightmost element. There should be no comma after the last element.
	* @return a string representation of this stack.
	*/
	public String toString () ;
}
```

</div> </div></div>



<div class="wrap-collabsible">
<input id="queue" class="toggle" type="checkbox" >
<label for="queue" class="lbl-toggle"> Queue </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

A queue using an array-based structure that implements the following interface. The name of your class should be `MyQueue<E>`.

```java
public interface Queue<E> {
	/**
	* Add an element to the back of this queue
	* @param item to be added to this queue
	* throws IllegalArgumentException if `item == null`
	*/
	public void enqueue ( E item ) ;

	/**
	* Remove and return the element from the front of this queue.
	* @return the element from the front of this queue or null if this queue is empty
	*/
	public E dequeue () ;

	/** Return the element from the front of this queue.
	* @return  the element from the top of this queue or null if this queue is empty
	*/
	public E peek () ;

	/**
	* Determines if this queue is equal to `obj`.
	* @obj an Object that is compared to this queue for equality
	* @return true if this queue is equal to `obj` (same elements in the same order)
	*         false, otherwise
	*/
	public boolean equals(Object obj);

	/**
	* Returns a string representation of this queue. The string is constructed by
	* concatenating all elements of this queue separated by a comma and a single space.
	* The front of the qyeye should be the leftmost element and the bacj of the queue
	* should be the rightmost element. There should be no comma after the last element.
	* @return a string representation of this queue.
	*/
	public String toString () ;
}

```


</div> </div></div>




<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_f20/notes/CodeConventions.pdf)
posted on the course website.

- You may not use any of the collection classes that are implemented in Java libraries. All three classes
have to be implemented _from scratch_ by you.

</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly. Each class is independent of the other classes. You should
implement and test individual method one by one.
- Make sure that at all times you __have a working code!__
You should start by writing stubs of methods that return `0` or `null`. This way your code compiles, even though it may
not work completely.  You can implement methods that perform one task at a time.
This way, if you run out of time, at least parts of your program will be functioning properly.
- You should make sure that you are __testing all methods__ that you implement. Even a single method running into an infinite loop
will prevent the autograder from completing.
- Each class that you submit __will be tested by itself without the context of other classes that you are implementing for this assignment__. <br>
This means that you need to make sure that your methods can perform their tasks correctly.
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


If your code does not compile or if it crashes (almost) every time it is run,
you will get a zero on the assignment. Make sure that you are submitting
functioning code, even if it is not a complete implementation so that you can get partial credit.

If the code does not adhere to the specification, the grade will be low and
will depend on how easy it is to figure out what the program is doing and how to work with it.

The grade will be determined by several factors:
- 40 points: class correctness: correct behavior of methods of the required classes and correct behavior of the program
	as a whole (this will be determined by the autograder)
- 20 points: design and the implementation of the required classes and any additional classes
   (this will be determined by a code review)
- 20 points: efficiency of the implemented methods (are the operations implemented optimally or do they use unnecessary
resources in computing the results)
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
or any project files that your IDE might produce.

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


</div> </div></div>


</main>
