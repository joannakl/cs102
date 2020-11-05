---
layout: lab
title: Project 4
---

<div class="lab-right" markdown="1">
__Project 4__ <br>
__due date:__ November 14

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 4: Number Converter

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


This is a fairly short projects in which you will get a chance to practice your newly
acquired skills of writing recursive function. You will design a class that provides
a few static methods that perform conversion between different number systems (binary,
decimal, hexadecimal).

<br/>

The goal of this programming project is for you to master (or at least
get practice on) the following tasks:


- designing and writing recursive function
- using different number systems
- testing your own code

__Start early!__ This project may not seem like much work, but
debugging always takes time.



<div class="wrap-collabsible">
<input id="background" class="toggle" type="checkbox" >
<label for="background" class="lbl-toggle"> Background </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


To complete this project you need to be familiar with the binary, decimal and hexadecimal
number systems and how to convert one representation into another.

The binary number system uses two symbols: `0` and `1`. All values are represented using
sequences of zeroes and ones, for example: `1000111011`.

The decimal number system uses ten symbols: `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`.
All values are represented using sequences of these ten symbols.

The hexadecimal number system uses sixteen symbols: `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `A`, `B`, `C`, `D`, `E`, `F`.
All values are represented using sequences of these sixteen symbols. (The symbols `A`, ..., `F` are used to represent the decimal values of 10,
11, 13, 14, and 15.)

To distinguish between strings written in different numbers systems, it is customary to include prefixes
in strings that represent non-decimal numbers: `0b` for binary and `0x` for hexadecimal. In this way
- `0b101` is a binary number
- `101` is a decimal number
- `0x101` is a hexadecimal number.

In order to determine the value of any of the sequences written as binary, decimal or
hexadecimal, we need to multiply the values of symbols by the powers of the base for that
number system (2 for binary, 10 for decimal, 16 for hexadecimal). The powers are
determined by the position of the symbol. We count the positions from right to left in the
sequence and the counting starts at zero.

Examples:


- Given a binary sequence `0b11000111011`, its value is

    $$ \begin{equation}
    1\times2^{10} + 1\times2^9 +0\times2^8 +0\times2^7 +0\times2^6 +1\times2^5 +1\times2^4 +1\times2^3 +0\times2^2 +1\times2^1 + 1\times2^0 = \\
    1024 + 512 + 0 + 0 + 0 + 32 + 16 + 8 + 0 + 2 + 1 = \\
    1595
    \end{equation}$$


- Given a decimal sequence `1595`, its value is

     $$ \begin{equation}
    1 \times 10^3 + 5 \times 10^2 +  9 \times 10^1 + 5 \times 10 ^ 0 = \\
    1000 + 500 + 90 + 5 = \\
    1595
    \end{equation}$$

    (Since we tend to think of values of numbers in decimal, the value of the decimal sequence is exactly the same as
the sequence itself. )

-  Given a decimal sequence `63B`, its value is

    $$ \begin{equation}
    6 \times 16^2 +  3 \times 16^1 + 11 \times 10 ^ 0 = \\
    1536 + 48 + 11 = \\
    1595
    \end{equation}$$




</div> </div></div>



<div class="wrap-collabsible">
<input id="conversion" class="toggle" type="checkbox" >
<label for="conversion" class="lbl-toggle"> Conversion Algorithms </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


__Binary to Decimal and Hexadecimal to Decimal__

In order to convert a binary number to decimal or a hexadecimal number to decimal,
we need to follow the same steps as for calculation of the value shown in the previous section.
For each symbol in the binary/hexadecimal string, multiply the value of that symbol by the power of
two/sixteen corresponding to the position
of the symbol (positions are counted from right to left and start at zero). The sum of those products, gives us
the decimal equivalent. The prefixes of `0b` and `0x` are ignored in the conversion.

__Decimal to Binary__

To convert a decimal integer to binary sequence:

 -  calculate the new decimal value by dividing the decimal integer by two (integer division); the remainder from
 that division is the symbol at position zero in the binary sequence (positions are counted from right to left)
 -  calculate the next decimal value by dividing the decimal value from the previous step by two (integer division);
 the remainder from that division is the symbol at position one in the binary sequence
 -  ...
 -  continue until the decimal value is equal to zero


__Binary to Hexadecimal__

To convert a binary sequence to a hexadecimal sequence first pad the binary sequence with zeroes so that the sequence
length is a multiple of four. Start from right end and move towards the left end:

 -  convert the rightmost four symbols to the hexadecimal symbol with the same value
 -  convert the next four symbols to the hexadecimal symbol with the same value
 -  ...
 -  convert the last four symbols to the hexadecimal symbol with the same value

The following table shows the mapping from binary sequences to hexadecimal symbols:

| binary | hexadecimal |
|:---:|:---:|
| 0000 | 0 |
| 0001 | 1 |
| 0010  | 2  |
| 0011  | 3  |
| 0100  | 4  |
| 0101  | 5  |
| 0110  | 6  |
| 0111  | 7  |
| 1000  | 8  |
| 1001  | 9  |
| 1010  | A  |
| 1011  | B  |
| 1100  | C  |
| 1101  | D  |
| 1110  | E  |
| 1111  | F  |



__Hexadecimal to Binary__

To convert a hexadecimal sequence to a binary sequence convert each hexadecimal symbol to a binary
sequence consisting of exactly four symbols. Concatenate the binary sequences to form a sequence
representing the whole number.





</div> </div></div>



<div class="wrap-collabsible">
<input id="implementation" class="toggle" type="checkbox" >
<label for="implementation" class="lbl-toggle"> Implementation </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The class that you need to implement is the `Converter` class.
You can find its documentation at  [Converter](project4/Converter.html).

Note that this class should not provide a public constructor since there is no reason to create instances of the class.

The binary and hexadecimal sequences are represented using string with prefixes of "0b" and "0x" respectively.
The decimal sequences are represented using the `int` type.


__Your implementation is not allowed to use the `parseInt()` method provided by the classes in Java.
It is not allowed to use any methods from the `Math` class or `Integer` class.__

__All functions in the `Converter` class have to be recursive (or wrappers calling recursive functions).
Your implementation is not allowed to use any loops!__


</div> </div></div>




<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_f20/notes/CodeConventions.pdf)
posted on the course website.

- You may not use any methods provided by the `Math` class in Java.

- You may not use any methods provided by the `Integer` class in Java.

- You may not use any methods that automatically convert numbers from one system to another unless you are the one who implemented them.

</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly. Each method is independent of the others. You should
implement and test individual methods one by one.
- Make sure that at all times you __have a working code!__
You should start by writing stubs of methods that return `0` or `null`. This way your code compiles, even though it may
not work completely.  You can implement methods that perform one task at a time.
This way, if you run out of time, at least parts of your program will be functioning properly.
- You should make sure that you are __testing all methods__ that you implement. Even a single method running into an infinite loop
will prevent the autograder from completing.
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
- 50 points: correctness, i.e., correct behavior of the required methods
- 30 points: design and the implementation of the required classes and any additional classes
   (this will be determined by a code review)
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



<script src="https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-AMS_HTML&delayStartupUntil=configured" type="text/javascript"></script>
<script type="text/javascript">
  // var slideshow = remark.create();

  // Setup MathJax
  MathJax.Hub.Config({
      tex2jax: {
      skipTags: ['script', 'noscript', 'style', 'textarea', 'pre'],
        inlineMath: [ ['$','$'], ["\\(","\\)"] ],
        displayMath: [ ['$$','$$'], ["\\[","\\]"] ],
        processEscapes: true
      }
  });

  MathJax.Hub.Configured();
</script>
