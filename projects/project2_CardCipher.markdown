---
layout: lab
title: Project 2
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__step 1 due:__ September 27 at 11:59pm <br>
__step 2 due:__ October 7 at 11:59pm

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 2: Card Cipher

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

You are going to design and implement a program that allows a user encrypt or decrypt a message using the _card cipher_ (the details of which are described later in this document).

You may have heard about _Caesar Cipher_ algorithm. It is a very simple algorithm used to encrypt a message: each letter in the plain text message is replaced by a letter some fixed number of positions down the alphabet. For example, a plain text message: `Hello Data Structures` would be encrypted as one of the following three depending on the shift used: 



| Description                       | Encrypted Message                |
|-----------------------------------|-----------------------------------|
| Encrypted message using shift by 1 | `Ifmmp Ebub Tusvduvsft`          |
| Encrypted message using shift by 5 | `Mjqqt Ifyf Xywzhyzwjx`          |
| Encrypted message using shift by 10| `Rovvy Nkdk Cdbemdeboc`          |


The _Card Cipher_ is more sophisticated: each letter in the plain text message is replaced by another letter (just like in the _Caesar Cipher__, but the shift amount changes from one letter to the next depending on its position in the message and on the initial configuration of a simplified card deck (hence the name). 

The purpose of this project is to design a program that allows the user to specify the encryption card deck and either encrypt a new message or decrypt a previously encrypted message. Both the encryption card deck and the message to be encrypted/decrypted will be provided in an input file given to the program as a command line argument.   


<br/><br/>

__Main goals__:

The goal of this programming project is for you to master (or at least
get practice on) the following tasks:

- working with multi-file programs
- reading data from input files
- using and understanding command line arguments
- using the `ArrayList` class
- writing classes
- working with existing code
- extending existing classes (inheritance)
- parsing data
- working with exception handling

Many of the skills that you need to complete this project
are based on the material covered in cs101. But there might be certain
topics for which you did not have to write a program or that you forgot.
Make sure to ask questions during recitations, in class and on Ed.

**Start early!** This project requires you to write several classes and
debugging always takes time.


<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox"  checked="true" >
<label for="interface" class="lbl-toggle"> User Interface </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program has to be a console based program (no graphical interface) - this
means that the program should not open any windows or dialogs to prompt user
for the input.

</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox"   checked="true">
<label for="usage" class="lbl-toggle"> Program Usage and Input File</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

#### Program Usage 

The user may start the program from the command line or run it within an IDE like
Eclipse - __from the point of view of your program this does not matter__.
The program expects one command line argument. When the user runs the program, they provide the name of the input
file as a command line argument. (This way the user can specify input files that contain different card decks and different messages).

If the name of the input file provided as a command line argument is incorrect or the file cannot be
opened for any reason, the program should display an error message and terminate. It should not prompt the user for
an alternative name of the file.

If the program is run without any arguments, the program should display an error message and terminate. It should not prompt the user
for the name of the file.

The error messages should be specific and informative, for example:

`Error: the file message.txt cannot be opened.`

or

`Usage Error: the program expects file name as an argument.`

The above error messages generated by your code should be written to the `System.err` stream (not the
`System.out` stream). If you are not sure what the difference is, research it or ask questions.

#### Input File

The input file will contain at least three lines of text:

- Line 1: the configuration of a card deck (i.e., initial arrangements of cards to be used)
- Line 2: a keyword indicating if the message should be encrypted or decrypted: `encrypt` or `decrypt` 
- Line 3 to the end of the file: the actual message 


For example:

```
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28
encrypt
HELLODATASTRUCTURES
```

or 

```
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28
decrypt
PUWTU
CFUU
ZJZUFZZCDJ
```


The __card deck__ is represented using integer values from 1 to 28. We are using a two-suite deck, for example diamonds, ♢, and spades, ♠. The mapping from cards to numbers is as follows:

 
| A♢ | 2♢ | 3♢ | 4♢ | 5♢ | 6♢ | 7♢ | 8♢ | 9♢ | 10♢ | J♢ | Q♢ | K♢ |
|----|----|----|----|----|----|----|----|----|-----|----|----|----|
| 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | 10  | 11 | 12 | 13 |

and 

| A♠ | 2♠ | 3♠ | 4♠ | 5♠ | 6♠ | 7♠ | 8♠ | 9♠ | 10♠ | J♠ | Q♠ | K♠ |
|----|----|----|----|----|----|----|----|-----|----|----|----|----|
| 14 | 15 | 16 | 17 | 18 | 19 | 20 | 21 | 22  | 23 | 24 | 25 | 26 | 

and two Jokers with numbers 27 and 28. 

(For this project, you do not need to do anything specific with the above mapping. In the future versions of the project, you may need to convert initial deck from the card names to the actual numbers.) 

The message itself, either plain text or encrypted, is specified with uppercase letters and no characters other than the letters (all spaces and punctuation characters are removed). This means that the encrypted message will also contain only the upper case letters. 

If the initial message is specified on multiple lines, the encrypted/decrypted message should also be printed on multiple lines.


For this project, the input file is guaranteed to be _correct_. This means that
- the card deck is guaranteed to be valid 
- the line 2 keyword will either be _encrypt_ or _decrypt_, nothing else 
- the message will contain only upper case letters. 
 

</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"   checked="true">
<label for="user" class="lbl-toggle"> User Interaction </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program has NO user interaction. It should not prompt the user for any information. 


<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"   checked="true">
<label for="user" class="lbl-toggle"> Card Cipher Algorithm </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The major difference between the Caesar cipher and the _Card Cipher_ is that each letter in the plain text message is treated differently. The _Card Cipher_ shifts each letter by a different number based on the _keystream_ value produced by the card cipher algorithm. 

Assume that _keystream_ sequence of values is: 1, 2, 3, 4. and the message is "DATA". This means that in the encrypted message 'D' is shifted by 1 positions to 'E'. 'A' is shifted by two positions to 'C'. 'T' is shifted by three positions to 'W'. And the second 'A' is shifted by four positions to 'E'. The finally encryption is "ECWE". 
In practie, the keystream values are not sequential numbers, of course. 

The card cipher algorithm takes several steps to generate each keystream value:

1. Find the a joker with value 27. Exchange it with the card beneath (after) it in the deck, to move the card down
the deck by one position. 
(If the joker is the last card in the deck, exchange it with the first card.) For example, if the deck is 

    `11 5 15 16 4 14 13 26 23 7 19 6 20 28 10 12 17 22 1 9 24 18 27 3 21 2 8 25`
    
    then after this step it will be 
    
    `11 5 15 16 4 14 13 26 23 7 19 6 20 28 10 12 17 22 1 9 24 18 3 27 21 2 8 25`

1. Find the joker with value 28. Move it two cards down by performing two exchanges. For example, if the deck is 
    
    `11 5 15 16 4 14 13 26 23 7 19 6 20 28 10 12 17 22 1 9 24 18 3 27 21 2 8 25`
    
    then after this step it will be 
    
    `11 5 15 16 4 14 13 26 23 7 19 6 20 10 12 28 17 22 1 9 24 18 3 27 21 2 8 25`

1. Perform a triple cupt: swap the cards above/before the first joker (the one closest to the top of the deck) with the cards below/after the second joker. For example, if the deck is

    `11 5 15 16 4 14 13 26 23 7 19 6 20 10 12 28 17 22 1 9 24 18 3 27 21 2 8 25`

    then after this step it will be 
    
    `21 2 8 25 28 17 22 1 9 24 18 3 27 11 5 15 16 4 14 13 26 23 7 19 6 20 10 12`

1. Take the bottom card from the deck. Count down from the top card by a quantity of cards equal to the
value of that bottom card. (If the bottom card is a joker, let its value be 27, regardless of which joker it
is.) Take that group of cards and move them to the bottom of the deck. Return the bottom card to the
bottom of the deck. For example, if the deck is
    
    `21 2 8 25 28 17 22 1 9 24 18 3 27 11 5 15 16 4 14 13 26 23 7 19 6 20 10 12`
    
    then the value of the bottom card is 12. We count the first twelve cards: these are the cards from 21 down to 3. We shift 
    these twelve cards to the bottom of the deck and then place 12 on the bottom:
    
    `27 11 5 15 16 4 14 13 26 23 7 19 6 20 10 21 2 8 25 28 17 22 1 9 24 18 3 12`

1. Take the top card and record its value. Put the
card back on top of the deck and count down the deck by that number. Record the value of the NEXT
card in the deck, but don’t remove it from the deck. This is the keystream value.
If that next card happens to be a joker, don’t record
anything. Leave the deck the way it is, and start again from the first step, repeating until that next card
is not a joker. For example, if the deck is
    
    `21 2 8 25 28 17 22 1 9 24 18 3 27 11 5 15 16 4 14 13 26 23 7 19 6 20 10 12`
    
    the top card's value is 21. Then we count down 21 cards, the value of the next card is 23. Since it is not a joker, 
    this is the keystream value. 
    
To compute the next keystream value, we repeat the algorithm starting the final state of the deck from the previous computation. 


</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"   checked="true">
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You need to provide an implementation of several classes that store the data and
compute the results when the program is executed.

In particular, your program must implement and use the following classes.
You may implement additional classes and additional methods in the required classes, if you wish.

You cannot change the signatures of methods that are required. 


#### <code class="code_title">CardDeck</code> class

The `CardDeck` class should be used to store and manipulate the card deck used for the encryption. 
__This class should inherit from the   `ArrayList<Record>` class.__ 

- The class needs to provide a one-arg constructor that creates a `CardDeck` object given a particular sequence of cards. 
    
    `public CardDeck ( int[] initialDeck );`
     
There should not be a default constructor. 

In addition, the class should implement the following methods: 

- `public int nextKeystreamValue() ` -  computes and returns the next keystream value

- `public String toString() ` - returns the string comtaining the values corresponding to the cards in the current state of the deck; the
values should be enclosed in a set of square brackets and each value should be separated by a comma and a space.

- `public int [] getDeckValues () ` - returns the values corresponding to the cards in the current state of the deck as an integer array

HINT: You should design and implement a number of helper methods (should be private) that help you in computation of the keystream values. The algorithm described in the previous section should NOT be implemented in one method. Instead, it should be broken down into small steps (some of which may be reusable) that can be implemented and debugged separately. 



#### <code class="code_title">Encryptor</code> class

This class performs the task of the encryption. It is constructed with a particular deck of cards based on which the keystream values are generated to perform the encryption.

It should provide a one-arg constructor `public Encryptor(CardList deck)` that creates a new `Encryptor` object with the specified initial card configuration. 

It should also provide the `encrypt` method that given a plain text string returns the encrypted version 
`public String encrypt(String s)`.   



#### <code class="code_title">Decryptor</code> class

This class performs the task of the decryption. It is constructed with a particular deck of cards based on which the keystream values are generated to perform the decryption.

It should provide a one-arg constructor `public Decryptor(CardList deck)` that creates a new `Decryptor` object with the specified initial card configuration. 

It should also provide the `decrypt` method that given an encrypted string returns its plain text version 
`public String decrypt(String s)`.   



#### <code class="code_title">CardCipher</code> class
The `CardCipher` class is the actual program. This is the class that should contain the `main` method.
It is responsible for opening and reading
the input file, creating appropriate objects, executing the necessary computations and pritinig results. 
It should handle any
exceptions thrown by your other classes and terminate gracefully, if need be, with
a friendly error message presented to the user: The program should never just reprint the
exception message as a way of handling an exception. These messages are rarely
readable to the ordinary user and make it seem like the program crashed in response to the exception.

You may implement other methods in this class to modularize the design.

</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102/notes/CodeConventions.pdf)
posted on the course website.

- The data file should be read only once! Your program needs to store the data in memory resident data structures.

- You may not use any of the collection
classes that were not covered in cs101 (for this assignment, do not use `LinkedList`, `Stack`, `Queue`, `PriorityQueue`, or any classes implementing the `Map` interface). You can, and should, use the `ArrayList` class.

- You may use any exception-related classes.

- You may use any classes to handle the file I/O, but probably the simplest ones
are `File` and `Scanner` classes. You are responsible for knowing how to use the classes that you select.

- The `CardCipher` class is responsible for reading input from standard input and printing output to standard output. 
No other classes should be reading from or writing to those streams. 

</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly: for example, implement the part of the code that reads and parses the input file, then implement and test individual classes, then implement the part that provides the interactive part of the program, ... .
- Make sure that at all times you __have a working program!__
You should also implement stubs of every method that return `0` or `null`. This way your code compiles, even though it may
not work completely.  You can implement methods that perform one task at a time.
This way, if you run out of time, at least parts of your program will be functioning properly.
- You should make sure that you are __testing the program on small data sets__ for which you can determine the correct
output manually. You can create  a test input file that contains only a few rows.
- You should make sure that your program's results are consistent with what is described in this specification
by running the program on carefully designed test inputs and examining
the outputs produced to make sure they are correct.
The goal in doing this is to try to find the mistakes you have most likely made in your code. <br>
<!--
__DO NOT__ test your program on the entire large input file. This may take a long time and you will never know
if the results are correct or not.
-->
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
<label for="grading" class="lbl-toggle"> Grading and Submissions</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

This project will be submitted in two steps. The first step is designed to make sure that you have a good starting point for the project and that 
you setup all your tools and submission properly to send you on a path to success in the second step. The second step is going to be your final submission.
In each step you can submit as many times as you wish before the due date. You cannot use your _freebie days_ for step one of the project. You can
request to use them for the second part. 

#### Step One (due September 27 at 11:59 PM)

You will be working on this part in recitations on Friday. The deliverable for this step are documented stub files for each class. Here is an example 
of such a sub file for a class called `Point2D` that is designed to represent a point in two-dimensional space. 

```
package project2; 

/**
 * The Point2D class represents a point in 2D space with x and y coordinates.
 */
public class Point2D {

    // Instance variables for the x and y coordinates
    private int x;
    private int y;

    /**
     * Default constructor that initializes the coordinates to (0, 0).
     */
    public Point2D() {
        // TODO: Implement this method.
    }

    /**
     * Constructor that initializes the coordinates to the given values.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Point2D(int x, int y) {
        // TODO: Implement this method.
    }

    /**
     * Returns the x coordinate.
     * @return The x coordinate.
     */
    public int getX() {
        // TODO: Implement this method.
        return 0;
    }

    /**
     * Sets the x coordinate to the given value.
     * @param x The new x coordinate.
     */
    public void setX(int x) {
        // TODO: Implement this method.
    }

    /**
     * Returns the y coordinate.
     * @return The y coordinate.
     */
    public int getY() {
        // TODO: Implement this method.
        return 0;
    }

    /**
     * Sets the y coordinate to the given value.
     * @param y The new y coordinate.
     */
    public void setY(int y) {
        // TODO: Implement this method.
    }

    /**
     * Returns a string representation of the point in the format (x, y).
     * @return A string representation of the point.
     */
    @Override
    public String toString() {
        // TODO: Implement this method.
        return "";
    }
}

```

The above class does not have any implementation, but it compiles and other classes can make calls to methods 
provided by this class. Of course, these method calls will not return correct results. The stub class does not need to mention all data fields
that will be required for the final implementation, but it is a good idea to list the ones that are definitely need to be part of the class. 

Your job for step one is to create documented stubs like this for every required class. DO NOT submit any implementation for this step. 
Make sure that you document the classes and methods using Javadoc style. 

#### Step 2 (due October 7 at 11:59 PM)

In the second step, you will need to implement the actual code for all the classes. 

If your program does not compile (should not be the case if you submitted step 1 successfully) or if it crashes (almost) every time it is run,
you will get a zero on the assignment. Make sure that you are submitting
functioning code, even if it is not a complete implementation so that you can get partial credit.

#### Grading 

The grade will be determined by several factors: 

- 20 points: (based on step 1 submission) proper documentation, format of submission, and stub-only implementation
   (this will be determined by a the autograder and the code review); if your step 2 submission omits the documentation, 
   you will likely lose most if not all points awarded for step 1 submission; if your step 1 submission misses the 
   documentation, but you include complete documentation in your 
   step 2 submission, you will get half of the credit for this part
- 45 points: class correctness: correct behavior of methods of the required classes (this will be determined by the autograder), these points will be assigned as follows:
	- 0 points: code passes fewer than a half of the autograder tests 
	- 20 points: code passes [50-70)% of the autograder tests 
	- 35 points: the code passes [70-80)% of the autograder tests
	- 40 points: the code passes [80-90)% of the autograder tests 
	- 45 points: the code passes 90% or more of the autograder tests 	
- 10 points: correct behavior of the program as a whole (this will be determined by the autograder and some manual evaluation)
- 25 points: design and the implementation of the required classes and any additional classes
   (this will be determined by a code review)

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox" >
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The submission format and requirements are the same for both steps. 

__For the purpose of grading, your project must be be in the package called `project2`.
This means that each of your submitted source code files should start with a line:__

`package project2;`


Your should submit all your source code files (the ones with `.java` extensions only) to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. Do not submit the data
file or any data files that you might have created. 
Once you submit, you should look at all the files that Gradescope has - make sure there is nothing there that should not be there. 

You may resubmit to Gradescope as many times as you wish before the submission link closes. But if you resubmit
after the grace period ends, your assignment will be subject to the late point deductions, unless you request to use your freebie days once you make your final submission.

For this project, you will see some of the results for the autograded unit tests. Some of the results will be hidden. (When some results are hidden, Gradescope does not display the score for the autograded part. )


</div> </div></div>


<div class="wrap-collabsible">
<input id="appendix" class="toggle" type="checkbox" >
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

#### Sample Interactions

Here is a sample run of a program with the short input file shown at the 
top of this specification: 

```
Welcome to Login Stats!

Available commands: 
  first USERNAME   -   retrieves first login session for the USER
  last USERNAME    -   retrieves last login session for the USER
  quit             -   terminates this program 


first joanna
joanna, terminal 1, duration    8 days,  2 hours, 26 minutes, 40 seconds
 logged in: Tue Apr 04 06:22:47 EST 1972
 logged out: Wed Apr 12 08:49:27 EST 1972
 
last joanna
joanna, terminal 4, duration    0 days,  2 hours, 43 minutes, 20 seconds
 logged in: Wed Apr 12 14:26:37 EST 1972
 logged out: Wed Apr 12 17:09:57 EST 1972
 
first vincent
vincent, terminal 3, duration active session
 logged in: Wed Apr 12 08:49:57 EST 1972
 logged out: still logged in
 
last vincent
vincent, terminal 5, duration    0 days,  0 hours, 16 minutes, 39 seconds
 logged in: Wed Apr 12 14:26:38 EST 1972
 logged out: Wed Apr 12 14:43:17 EST 1972
 
first chenfeiyu
chenfeiyu, terminal 1, duration   12 days,  0 hours, 53 minutes, 20 seconds
 logged in: Wed Apr 12 14:23:17 EST 1972
 logged out: Mon Apr 24 15:16:37 EST 1972
 
last chenfeiyu
chenfeiyu, terminal 1, duration   12 days,  0 hours, 53 minutes, 20 seconds
 logged in: Wed Apr 12 14:23:17 EST 1972
 logged out: Mon Apr 24 15:16:37 EST 1972
 
first bruno
No user matching bruno found

next joanna
Error: this is not a valid command. Try again.

last satya
satya, terminal 2, duration   19 days, 21 hours, 47 minutes,  8 seconds
 logged in: Tue Apr 04 06:22:49 EST 1972
 logged out: Mon Apr 24 04:09:57 EST 1972
quit
```

</div> </div></div>


</main>
