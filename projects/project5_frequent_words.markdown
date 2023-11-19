---
layout: lab
title: Project 5
---

<div class="lab-right" markdown="1">
__Project 5__ <br>
__due date:__ Dec. 3

__submission mode:__ individual



</div>

<main markdown="1" class="lab">

## Project 5: Frequent Words

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

The program you complete in this project will compute a list of all unique words and count how many times they occur in a given input file. The same computation is performed using a sorted linked list and a binary search tree. These data structures are used to store the unique words and perform the computation. 

The main objective of this project is to be able to compare the relative performance of these two data structures for solving this problem. 

The goal of this project is for you to master (or at least get practice on) the following tasks:

- implementation of a reference based sorted list (this can be a modification of the sorted linked list 
you implemented for project 3, or a new implementation specifically for this project),
- implementation of a reference based binary search tree. 


**Start early!** This project may not seem like much coding, but debugging and testing always takes time, especially for recursive algorithms.


<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox" checked=true >
<label for="usage" class="lbl-toggle"> <code>FrequentWords</code> class</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The program usage and the user interface are already implemented as part of the 
<a href="../projects/project5_frequent_words/FrequentWords.java"><code>FrequentWords</code></a>
 and 
<a href="../projects/project5_frequent_words/FileParser.java"><code>FileParser</code></a> classes. 
These classes obtains, parse and use the command
line arguments. They open, read and parse the content of the input file and 
write the results to an output file. 

You should not make any modifications to that class. 

</div> </div></div>



<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true">
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program needs to implement three classes described in this section. 
You may, but you are not required to, implement other classes.

#### <code class="code_title">Word</code> class

This is the class that represents words and their counts. 
It should provide the following public methods:

- `Word(String word)` <br/>
One argument constructor that takes a string as the argument and creates 
a new `Word` object with the given string and count of 1. 

- `int incrementCount()` <br/>
A method that increments the count associated with this `Word` object
by 1 and returns the updated value of the count. 

- `String getWord()` <br/>
A method that returns the word associated with this `Word` object. 

- `int getCount()` <br/>
A method that returns the count associated with this `Word` object. 

- `String toString()` <br/>
A method that returns the string representation of this `Word` object.
The representation should consist of the count that is right aligned 
within a field of 5 characters, followed by two spaces, followed by the 
word itself. Here are some examples of such string representations:

    ```
    12345  computer
       67  hello
      890  coffee
        3  flavor
    ```

This class should implement `Comparable<Word>` interface. The `Word` objects 
should be compared according to the natural ordering of the words
that they store. (Counts are irrelevant for comparison.)

This class should override the `equals` method. Two `Word` objects are 
equal if their words and counts are equal. 



#### <code class="code_title">SortedLinkedList</code> and <code>BSTIndex</code> classes

These classes should implement the <a href="../projects/project5_frequent_words/Index.java">`Index` interface</a>. 

In addition they both should provide implementation of the `equals` method
and the `toString` methods inherited from the `Object` class. 

Two `Index` objects are considered equal if they contain the same number 
of elements, and those elements are pairwise equal (when retrieved from the 
`Index` object according to the natural ordering of the `Word` objects). 
<br/>NOTE that this implies that two different implementations of the `Index` interface
should be able to be compared using this `equals` method. 

The string representation  of an `Index` object consists of a list of 
all the `Word` objects sorted by their natural ordering, enclosed in square brackets ("[]"). 
Adjacent elements are separated by the characters ", " (comma and space). 

Since the classes implementing the `Index` interface need to implement the
`Iterable<Word>` interface, both of these classes need to provide an internal class
implementing an iterator.
<br/>NOTE, that this iterator should provide implementation 
for the `remove` method (since it is used in the `FrequentWords` class.)


</div> </div></div>



<div class="wrap-collabsible">
<input id="output" class="toggle" type="checkbox"  >
<label for="output" class="lbl-toggle"> Program Input and Output </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program input can be any text file. The interesting results will 
be obtained from running the program on large input files. 
<a href="https://www.gutenberg.org/">Project Gutenberg</a> may be a source of interesting large files.
But, for testing purposes, you should work with small carefully created files 
for which you know the count results. 


The program produces a timing report in the console window. It also 
writes the list of the most frequent words to the output file.

The output for the timing results will be similar to this:

```
INFO: Reading file took 434801 ms (~   0.435 seconds).
INFO: 565405 words read. 

Processing using Sorted Linked List
INFO: Creating index took 76474070 ms (~  76.474 seconds).
INFO: 19783 words stored in index.
INFO: Pruning index took 192947 ms (~   0.193 seconds).
INFO: 2446 words remaining after pruning.

Processing using Recursive BST
INFO: Creating index took 134945 ms (~   0.135 seconds).
INFO: 19783 words stored in index.
INFO: Pruning index took 17063 ms (~   0.017 seconds).
INFO: 2446 words remaining after pruning.

```

The content of the output file is too large to show, but here are 
a few excerpts:

```
10520  a
   25  abandon
   54  abandoned
   26  abandoning
  107  able
 1016  about
...
   22  olmutz
 3996  on
  356  once
 2111  one
   54  ones
 1292  only
   64  onto
   99  open
...
  297  side
  135  sides
   33  sigh
   55  sighed
   88  sight
   45  sign
   59  significance
...
  548  yes
   53  yesterday
  339  yet
 3835  you
  441  young
   32  younger
  814  your
   25  yours
  117  yourself
   44  youth
   40  zherkov
```



</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102/notes/CodeConventions.pdf)
posted on the course website.

- You have to work with your own implementation of a BST class and your own
implementation of the SortedLinedLists class. It should be based on the one we have been using in class, but it cannot be based on one of the implementations in Java libraries.

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
output manually. You can create  a test input file that contains only a few words.
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
- 50 points: class correctness:correct behavior of methods of the required classes and correct behavior of the program
- 20 points: design and the implementation of your code
- 10 points: efficient implementation (this will be determined by a code review)
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


Your should submit all your source code files (the ones with `.java` extensions only) to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. Do not submit the data
file or any data files that you might have created. 
Once you submit, you should look at all the files that Gradescope has - make sure there is nothing there that should not be there. 

You may resubmit to Gradescope as many times as you wish before the submission link closes. But if you resubmit
after the grace period ends, your assignment will be subject to the late point deductions.

For this project, you will see some of the results for the autograded unit tests. Some of the results will be hidden. (When some results are hidden, Gradescope does not display the score for the autograded part. )



</div> </div></div>



</main>
