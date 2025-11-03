---
layout: lab
title: Project 3
---

<div class="lab-right" markdown="1">
__Project 3__ <br>
__due date:__ Oct. 27 at 11:59pm

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 3: <code>MDeque</code>

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other forum). You should not use code generation tools to create any part of the implementation for this project. 
If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and features of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.

If your submitted code matches closely or exactly code submitted by another person in the class, it will get a zero grade and the offense will be reported to the department and the dean. 
</div>

---
<br/><br/>
### Introduction and objectives


You are going to write a program that designs, implements and uses an <code>MDeque</code> (a double ended queue with fast access to its middle) to decode a sequence of numbers.



__Main goals__:

- Implement a data structure that will be used to solve a problem. (This will involve implementing a somewhat non-standard doubly linked list.)
- Use this data structure to solve a problem.
- Work with some existing code.
- Optimize your implementation to meet performance requirements.
- Implement a recursive algorithm.

**Start early!** This project should take a fairly short time to implement, but testing and debugging always take time.

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox" checked=true >
<label for="usage" class="lbl-toggle"> Program Usage and User Interaction</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is run with no command line arguments. If any command line arguments are provided, they should be ignored.

The user is prompted to enter two strings: First is the numerical sequence to be decoded. Second is the decoding key.
The program computes the decoded sequence and outputs it to standard output stream (`System.out`).

The `main()` method that performs these tasks is implemented and you should not be making
any changes to it.

</div> </div></div>

<div class="wrap-collabsible">
<input id="algorithm" class="toggle" type="checkbox" checked=true >
<label for="algorithm" class="lbl-toggle">Decoding the Sequence</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The decoding key is a string with characters `F`, `B`, `R`. Each of those characters is
an instruction to be applied to the numerical sequence in order to decode it.

- `F` drop/remove the front/first element in the sequence,
- `B` drop/remove the back/last element in the sequence,
- `R` reverse the sequence

The first two instructions (`F` and `B`) cannot be applied to an empty sequence. If such
an attempt is made, the decoding algorithm should detect it and produce appropriate
error message.

The reverse instruction (`R`) can be applied to an empty sequence (reverse of an empty sequence is an empty sequence).

The `Decode.java` file provides function stubs along with the documentation for three
functions:
- `isValid` that determines if a decoding key is a valid key
- `parseSequence` that converts a string containing the numerical sequence to an
`MDeque` object (see below for details about `MDeque` class)
- `decode` that decodes the given sequence following the decoding key

Your task is to complete the implementation of `isValid` and `decode` functions.

Source code:  [Decode.java](project3_mdeque/project3/Decode.java)

IMPLEMENTATION RESTRICTION: the `isValid` function should be implemented recursively.

#### Example of Decoding 1

```
sequence: 12, 6, 9, 20, 17, -8, 19, 22
decoding key: FBRFBR
```

```
instruction applied            resulting sequence
__________________________________________________
    F                       6, 9, 20, 17, -8, 19, 22
    B                       6, 9, 20, 17, -8, 19
    R                       19, -8, 17, 20, 9, 6
    F                       -8, 17, 20, 9, 6
    B                       -8, 17, 20, 9
    R                       9, 20, 17, -8
```


#### Example of Decoding 2

```
sequence: 12, 6, 9, 20, 17, -8
decoding key: FFBBRRFFBBRR
```

```
instruction applied            resulting sequence
__________________________________________________
    F                       6, 9, 20, 17, -8
    F                       9, 20, 17, -8
    B                       9, 20, 17
    B                       9, 20
    R                       20, 9
    R                       9, 20
    F                       20
    F
    B                       error: cannot drop from an empty sequence
    B
    R
    R
```


</div> </div></div>

<div class="wrap-collabsible">
<input id="implementation" class="toggle" type="checkbox" checked=true >
<label for="implementation" class="lbl-toggle"><code>MDeque</code> </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

We learned about stacks, queues, and deques. An _mdeque_ (pronounced "em-deck") is a
variation of double ended queue that also provides a fast access to the middle element.

The documentation for all the required public methods that you need to implement
is given at [its javadoc page](project3_mdeque/project3/MDeque.html). You may implement additional methods, if you wish. They should be private, unless they are designed for use by the
third parties. All methods need to be documented.

IMPLEMENTATION RESTRICTIONS:
- All push..., pop..., and peek... methods should be O(1) (including the ones that operate at the middle).
- The `toString` method should be implemented recursively.
- Your `MDeque` design needs to be based on a doubly linked list that you implement. (It does not need to be inheriting from another class, you just need to use the doubly linked
list design. You will need to keep track of the middle of the mdeque in addition to the
front and the back in order to meet the performance requirements.)




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
classes provided in Java libraries. Do not use `LinkedList`, `Stack`, `Queue`, `Deque`,  or any classes implementing the `List` or `Queue` interfaces).

- You may use any exception-related classes.

- Follow the implementation requirements outlined in this project to get full credit for
efficiency of methods implementing algorithms. If the requirement is to implement
something recursively, your program will not receive full credit if the algorithm is implemented iteratively.


</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  checked=true >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- Start by creating `MDeque` class with stubs for all required methods. You can then implement
them one by one and always have compilable code.
- Focus on implementing methods of the `MDeque` class that are needed to implement the decoding algorithm. The `toString` method may be a very useful in debugging the program.
- Design the validation and decoding algorithms __before__ implementing them.
- Test each method after you finish working on it so you know it is correct.
<!--
- You re not required to do it, but it may be a good idea to create unit tests for the `MDeque` class.
-->


</div> </div></div>

<div class="wrap-collabsible">
<input id="grading" class="toggle" type="checkbox"   checked="true" >
<label for="grading" class="lbl-toggle"> Grading and Submissions</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


If your program does not compile or if it crashes (almost) every time it is run,
you will get a zero on the assignment. Make sure that you are submitting
functioning code, even if it is not a complete implementation so that you can get partial credit.

The grade will be determined by several factors:

- 50 points: class correctness: correct behavior of methods of the required classes (this will be determined by the autograder), these points will be assigned as follows:
	- 0 points: code passes fewer than a half of the autograder tests 
	- 25 points: code passes [50-70)% of the autograder tests 
	- 35 points: the code passes [70-80)% of the autograder tests
	- 40 points: the code passes [80-90)% of the autograder tests 
	- 45 points: the code passes [90-95)% of the autograder tests 
	- 50 points: the code passes 95% or more of the autograder tests 	
- 35 points: design, implementation and efficiency of the required classes and any additional methods and classes if you chose to create them
    (this will be determined by a code review)
- 15 points: code documentation and style 
</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox"   checked="true" >
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

__For the purpose of grading, your project must be in the package called `project3`.
This means that each of your submitted source code files should start with a line:__

`package project3;`


Your should submit all your source code files (the ones with `.java` extensions only) to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. Do not submit the sample input files that you might have created. 
Once you submit, you should look at all the files that Gradescope has - make sure there is nothing there that should not be there. 

You may resubmit to Gradescope as many times as you wish before the submission link closes. But if you resubmit
after the grace period ends, your assignment will be subject to the late point deductions, unless you request to use your freebie days once you make your final submission.

For this project, you will see some of the results for the autograded unit tests. Some of the results will be hidden. (When some results are hidden, Gradescope does not display the score for the autograded part. )


</div> </div></div>



</main>
