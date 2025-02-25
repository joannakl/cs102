---
layout: lab
title: Project 3
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__due:__ March 6 at 11:59pm <br>
__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 3: Card Cipher, Take 2

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

<span class=new>This project is a _redo_ of project 2. The idea behind the project is exactly the same. But you will use your own implementation of a linked list instead of using the `ArrayList` to build your `CardDeck` class. </span>

<span class=new>(The changes in this document, as compared to the project 2 specification, are indicated by bold purple text for easier identification.)</span>


You are going to design and implement a program that allows a user to encrypt or decrypt a message using the _card cipher_ (the details of which are described later in this document).

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

`Usage Error: the program expects filename as an argument.`

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


| Card (Diamonds) | Value | Card (Diamonds) | Value |   | Card (Spades) | Value | Card (Spades) | Value |
|:---------------:|:-----:|:---------------:|:-----:|:-:|:-------------:|:-----:|:-------------:|:-----:|
|       A♢        |   1   |       8♢        |   8   |   |      A♠       |  14   |      8♠       |  21   |
|       2♢        |   2   |       9♢        |   9   |   |      2♠       |  15   |      9♠       |  22   |
|       3♢        |   3   |      10♢        |  10   |   |      3♠       |  16   |     10♠       |  23   |
|       4♢        |   4   |       J♢        |  11   |   |      4♠       |  17   |      J♠       |  24   |
|       5♢        |   5   |       Q♢        |  12   |   |      5♠       |  18   |      Q♠       |  25   |
|       6♢        |   6   |       K♢        |  13   |   |      6♠       |  19   |      K♠       |  26   |
|       7♢        |   7   |                 |       |   |      7♠       |  20   |               |       |



and two Jokers with numbers 27 and 28. 

(For this project, you do not need to do anything specific with the above mapping. In the future versions of the project, you may need to convert initial deck from the card names to the actual numbers.) 

The message itself, either plain text or encrypted, is specified with uppercase letters and no characters other than the letters (all spaces and punctuation characters are removed). This means that the encrypted message will also contain only the upper case letters. 

If the initial message is specified on multiple lines, the encrypted/decrypted message should also be printed on multiple lines.


For this project, the input file is guaranteed to be _correct_. This means that
- the card deck is guaranteed to be valid 
- the line 2 keyword will either be _encrypt_ or _decrypt_, nothing else 
- the message will contain only upper case letters and will be specified on one or more lines. 
 
 
#### Program's Output

The program should print out the encrypted/decrypted message. It should not print anything other than the message itself. If the original message was 
specified on multiple lines, the program should print that same number of lines.  

Each line of a multi-line message should be encrypted/decrypted using the state of the card deck that results from enrypting/decrypting the previous line. I.e., the original
deck configuration should only be used to process the first character of the first line. Each consecutive step should use the state of the deck that was produced by the previous step. 
 

</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"   checked="true">
<label for="user" class="lbl-toggle"> User Interaction </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program has NO user interaction. It should not prompt the user for any information. 


</div> </div></div>

<div class="wrap-collabsible">
<input id="algo" class="toggle" type="checkbox"   checked="true">
<label for="algo" class="lbl-toggle"> Card Cipher Algorithm </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The major difference between the Caesar cipher and the _Card Cipher_ is that each letter in the plain text message is treated differently. The _Card Cipher_ shifts each letter by a different number based on the _key_ value produced by the card cipher algorithm. 

Assume that _key_ sequence of values is: 1, 2, 3, 4. and the message is "DATA". This means that in the encrypted message 'D' is shifted by 1 position to the right (think of the alphabet going from left to write as we move from 'A' to 'Z') to 'E'. 'A' is shifted by two positions to 'C'. 'T' is shifted by three positions to 'W'. And the second 'A' is shifted by four positions to 'E'. The final encryption is "ECWE". 

In practice, the key values are not sequential numbers, of course and they are generated as describe below.

#### Generating key values  

The card cipher algorithm takes several steps to generate each key value:

1. Find the joker with value 27. Exchange it with the card beneath (after) it in the deck, to move the card down
the deck by one position. 
(If the joker is the last card in the deck, exchange it with the first card.) For example, if the deck is 

    `11 5 15 16 4 14 13 26 23 7 19 6 20 28 10 12 17 22 1 9 24 18 27 3 21 2 8 25`
    
    then after this step it will be 
    
    `11 5 15 16 4 14 13 26 23 7 19 6 20 28 10 12 17 22 1 9 24 18 3 27 21 2 8 25`

1. Find the joker with value 28. Move it two cards down by performing two exchanges. For example, if the deck is 
    
    `11 5 15 16 4 14 13 26 23 7 19 6 20 28 10 12 17 22 1 9 24 18 3 27 21 2 8 25`
    
    then after this step it will be 
    
    `11 5 15 16 4 14 13 26 23 7 19 6 20 10 12 28 17 22 1 9 24 18 3 27 21 2 8 25`

1. Perform a triple cut: 
    - find two jokers in the deck (cards with values 27 and 28), 
    - split the deck into three parts: top (before/above the first joker), middle (between the two jokers), and bottom (after/below the second joker)
    - swap the top and the bottom parts, the middle part remains unchanged 
    
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

1. Look at the top card’s value (which is again 1-27, as it was in the previous step, i.e., treat 28 joker as 27) and record it. Put the
card back on top of the deck and count down the deck by that number. Record the value of the NEXT
card in the deck, but don’t remove it from the deck. This is the key value.
If that next card happens to be a joker, don’t record
anything. Leave the deck the way it is, and start again from the first step, repeating until that next card
is not a joker. For example, if the deck is
    
    `27 11 5 15 16 4 14 13 26 23 7 19 6 20 10 21 2 8 25 28 17 22 1 9 24 18 3 12`
    
    the top card's value is 27. Then we count down 27 cards, the value of the next card is 12 (the last card). Since it is not a joker, 
    this is the key value. 
    
To compute the next key value, we repeat the algorithm starting the final state of the deck from the previous computation. 

The first key value from the above steps is 12. If we run the algorithm again, the second key value is 22, the third 23 and the fourth is 11 .


#### How to encrypt using key values 

To encrypt a message we need a plain text message and an initial deck configuration. We use the deck to generate 
a sequence of key values equal in length to the number of characters in the message. 

Encryption steps shift each letter down (or right) by the number of positions specified by the key value. 
Let's use the "DATA" as our plain text message and the deck from the previous section. The four key values 
are 12, 22, 23 and 11.  

`D` is shifted by 12 positions, so it becomes `P`: 

```
          *
 A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
             1  2  3  4  5  6  7  8  9 10 11 12
                                              *
```

`A` is shifted by 22 positions, so it becomes `W`: 

```
 *
 A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22
                                                                   *  
```


`T` is shifted by 23 positions. But, since `T` is only six positions away from the end of the alphabet,
we will think of our alphabet as circular, so when we reach `Z` we continue counting 
at `A`. (HINT: This is when modular arithmetic comes in handy:`%26`.) This way `T` is encrypted to `Q`: 

```
                                                          *
 A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
                                                             1  2  3  4  5  6
 7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 
                                                 *  
```



`A` is shifted by 11 positions, so it becomes `L`: 

```
 *
 A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
    1  2  3  4  5  6  7  8  9 10 11 
                                  *  
```

The encrypted message is "PWQL". If we started with a different deck configuration, the encrypted message would be different. 




#### How to decrypt using key values

 
To encrypt a message we need the encrypted message and an initial deck configuration that was used to encrypt it. 
We use the deck to generate 
a sequence of key values equal in length to the number of characters in the message. 

Decryption steps shift each letter up (or left) by the number of positions specified by the key value. 
Let's use the message that we encrypted in the previous section "PWQL" and the same deck from the previous section. 
The four key values are exactly the same 12, 22, 23 and 11.  

`P` is shifted by 12 positions, so it becomes `D`: 

```
                                              *
 A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
         12 11 10  9  8  7  6  5  4  3  2  1
          *
```

`W` is shifted by 22 positions, so it becomes `A`: 

```
                                                                   *  
 A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
22 21 20 19 18 17 16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1
 *
```


`Q` is shifted by 23 positions. But, since `Q` is only sixteen positions away from the start of the alphabet,
we will think of our alphabet as circular again, so when we reach `A` we continue counting 
at `Z`. This way `Q` is encrypted to `T`: 

```
                                                 *
 A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1         
                                                         23 22 21 20 19 18 17 
                                                          *  
```



`L` is shifted by 11 positions, so it becomes `A`: 

```
                                  *  
 A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
11 10  9  8  7  6  5  4  3  2  1
 *
```

The decrypted message is "DATA". If we started with a different deck configuration (one that was not used for encryption) then
the message would not be decrypted correctly.  




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


#### <code class="code_title">MyLinkedList</code> class


<span class="new">
This should be your own implementation of a __generic singly linked list__. You can use the code
that we worked on together in lectures and recitations as a starting point, but there are a lot of methods that you need to implement that we did not implement in class. 
<br/>
Your implementation should follow the specification at <a href="project3_CardCipher/project3/MyLinkedList.html">MyLinkedList</a>
</span>



#### <code class="code_title">CardDeck</code> class

The `CardDeck` class should be used to store and manipulate the card deck used for the encryption. 
<span class="new">
__This class should inherit from the   `MyLinkedList<Integer>` class.__ This does mean that implementation of several of 
the methods in this class will need to change. 
</span> 

- The class needs to provide a one-arg constructor that creates a `CardDeck` object given a particular sequence of cards. 
    
    `public CardDeck ( int[] initialDeck );`
     
There should not be a default constructor. 

In addition, the class should implement the following methods: 

- `public int nextKeyValue() ` -  computes and returns the next key value

- `public String toString() ` - returns the string containing the values corresponding to the cards in the current state of the deck; the
values should be enclosed in a set of square brackets and each value should be separated by a comma and a space.

- `public int [] getDeckValues () ` - returns the values corresponding to the cards in the current state of the deck as an integer array

HINT: You should design and implement a number of helper methods (should be private) that help you in computation of the key values. The algorithm described in the previous section should NOT be implemented in one method. Instead, it should be broken down into small steps (some of which may be reusable) that can be implemented and debugged separately. 



#### <code class="code_title">Encryptor</code> class

This class performs the task of the encryption. It is constructed with a particular deck of cards based on which the key values are generated to perform the encryption.

It should provide a one-arg constructor `public Encryptor(CardDeck deck)` that creates a new `Encryptor` object with the specified initial card configuration. 

It should provide the `encrypt` method that given a plain text string returns the encrypted version 
`public String encrypt(String s)`. If this method is called with an empty string or a null string, it should return an empty string or null string, respectively.  

The state of the deck used by this object should be constantly updated. The first call to the `encrypt` method should use the initial 
deck configuration (as it was specified in the constructor). Consecutive calls should use the state of the deck as it was left by the previous call to `encrypt`.  

The class should provide a method that allows the user to retrieve the current state of the deck: `publict CardDeck getDeck()`. This method should return different decks if the `encrypt` method is called between two consecutive `getDeck` calls. 


#### <code class="code_title">Decryptor</code> class

This class performs the task of the decryption. It is constructed with a particular deck of cards based on which the key values are generated to perform the decryption.

It should provide a one-arg constructor `public Decryptor(CardDeck deck)` that creates a new `Decryptor` object with the specified initial card configuration. 

It should provide the `decrypt` method that given an encrypted string returns its plain text version 
`public String decrypt(String s)`.   If this method is called with an empty string or a null string, it should return an empty string or null string, respectively. 

The state of the deck used by this object should be constantly updated (just like for the `Encryptor` class). The first call to the `decrypt` method should use the initial 
deck configuration (as it was specified in the constructor). Consecutive calls should use the state of the deck as it was left by the previous call to `decrypt`.  

The class should provide a method that allows the user to retrieve the current state of the deck: `publict CardDeck getDeck()`. This method should return different decks if the `dencrypt` method is called between two consecutive `getDeck` calls. 



#### <code class="code_title">CardCipher</code> class
The `CardCipher` class is the actual program. This is the class that should contain the `main` method.
It is responsible for opening and reading
the input file, creating appropriate objects, executing the necessary computations and printing results. 
It should handle any
exceptions thrown by your other classes and terminate gracefully, if need be, with
a friendly error message presented to the user: The program should never just reprint the
exception message as a way of handling an exception. These messages are rarely
readable to the ordinary user and make it seem like the program crashed in response to the exception.

You may implement other methods in this class to modularize the design.

</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"   checked="true" >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102/notes/CodeConventions.pdf)
posted on the course website.

- The data file should be read only once! Your program needs to store the data in memory resident data structures.

- You may not use any of the collection
classes that were not covered in cs101 (for this assignment, do not use `LinkedList`, `Stack`, `Queue`, `PriorityQueue`, or any classes implementing the `Map` interface). <span class=old>You can, and should, use the `ArrayList` class.</span>

- You may use any exception-related classes.

- You may use any classes to handle the file I/O, but probably the simplest ones
are `File` and `Scanner` classes. You are responsible for knowing how to use the classes that you select.

- The `CardCipher` class is responsible for reading input from a file, printing output to standard output and printing errors to standard error streams. 
No other classes should be reading from or writing to those streams. 

</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"   checked="true"  >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly: for example, implement the part of the code that reads and parses the input file, then implement and test individual classes, ... .
- Make sure that at all times you __have a working program!__
You should also implement stubs of every method that return `0` or `null`. This way your code compiles, even though it may
not work completely.  You can implement methods that perform one task at a time.
This way, if you run out of time, at least parts of your program will be functioning properly.
- You should make sure that you are __testing the program on small input files__ for which you can determine the correct
output manually. 
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
<input id="grading" class="toggle" type="checkbox"   checked="true" >
<label for="grading" class="lbl-toggle"> Grading and Submissions</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


If your program does not compile (should not be the case if you submitted step 1 successfully) or if it crashes (almost) every time it is run,
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
- 10 points: correct behavior of the program as a whole (this will be determined by the autograder and some manual evaluation)
- 25 points: design, implementation and efficiency of the required classes and any additional classes
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



<div class="wrap-collabsible">
<input id="appendix" class="toggle" type="checkbox"   checked="true" >
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Here is a detailed trace of how the card deck changes after encryption/decryption of each letter of a given message. 

Note: if you are on a narrow display, the right hand side of the trace will be cut-off. The lines are not wrapping to simplify
the comparison between the state of the decks at different steps. 


#### Example 1

Input file:

```
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28
encrypt
HELLODATASTRUCTURES
```

How does encryption happen: 

```



Input: HELLODATASTRUCTURES

Card deck:       [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28]
Intializing algorithm.

generated key: 8
Card deck after: [4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 27, 2, 3, 28]
H --> P 
generated key: 16
Card deck after: [8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 27, 3, 4, 28, 6, 7, 5]
E --> U 
generated key: 11
Card deck after: [6, 7, 28, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 5, 27, 4, 3]
L --> W 
generated key: 8
Card deck after: [17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 5, 4, 27, 6, 7, 8, 3, 28, 10, 11, 12, 13, 14, 15, 16, 9]
L --> T 
generated key: 6
Card deck after: [27, 7, 8, 3, 10, 11, 28, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6]
O --> U 
generated key: 25
Card deck after: [26, 1, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6, 27, 8, 3, 10, 11, 17, 18, 28, 19, 20, 21, 22, 23, 24, 25, 7]
D --> C 
generated key: 5
Card deck after: [10, 11, 17, 18, 19, 20, 28, 26, 1, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6, 21, 22, 23, 24, 25, 7, 27, 3, 8]
A --> F 
generated key: 1
Card deck after: [28, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6, 21, 22, 23, 24, 25, 7, 3, 27, 10, 11, 17, 18, 19, 20, 26, 8, 1]
T --> U 
generated key: 20
Card deck after: [26, 8, 1, 28, 4, 12, 13, 14, 15, 16, 9, 6, 21, 22, 23, 24, 25, 7, 3, 10, 27, 2, 11, 17, 18, 19, 20, 5]
A --> U 
generated key: 7
Card deck after: [6, 21, 22, 23, 24, 25, 7, 3, 10, 2, 27, 26, 8, 1, 4, 11, 17, 18, 19, 20, 5, 28, 13, 14, 15, 16, 9, 12]
S --> Z 
generated key: 16
Card deck after: [2, 15, 16, 9, 12, 27, 8, 1, 4, 11, 17, 18, 19, 20, 5, 13, 14, 28, 6, 21, 22, 23, 24, 25, 7, 3, 10, 26]
T --> J 
generated key: 8
Card deck after: [27, 1, 4, 11, 17, 18, 19, 20, 5, 13, 14, 6, 21, 28, 2, 15, 16, 9, 12, 22, 23, 24, 25, 7, 3, 10, 26, 8]
R --> Z 
generated key: 26
Card deck after: [9, 12, 22, 23, 24, 25, 7, 3, 10, 26, 8, 27, 4, 11, 17, 18, 19, 20, 5, 13, 14, 6, 21, 2, 15, 28, 16, 1]
U --> U 
generated key: 3
Card deck after: [19, 20, 5, 13, 14, 6, 21, 2, 15, 16, 1, 28, 9, 12, 22, 23, 24, 25, 7, 3, 10, 26, 8, 27, 11, 17, 18, 4]
C --> F 
generated key: 6
Card deck after: [8, 11, 27, 19, 20, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 17, 18, 4, 28, 22, 23, 24, 25, 7, 3, 10, 26, 12]
T --> Z 
generated key: 5
Card deck after: [17, 18, 4, 22, 23, 28, 8, 11, 24, 25, 7, 3, 10, 26, 12, 27, 20, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 19]
U --> Z 
generated key: 11
Card deck after: [28, 24, 25, 7, 3, 10, 26, 12, 20, 27, 17, 18, 4, 22, 23, 8, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 19, 11]
R --> C 
generated key: 25
Card deck after: [27, 24, 18, 4, 22, 23, 8, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 19, 11, 28, 7, 3, 10, 26, 12, 20, 17, 25]
E --> D 
generated key: 17
Card deck after: [7, 3, 28, 10, 26, 12, 20, 17, 25, 27, 18, 4, 22, 23, 8, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 19, 11, 24]
S --> J 

Output: PUWTUCFUUZJZUFZZCDJ
```


#### Example 2

Input file:

```
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28
decrypt
PUWTU
CFUU
ZJZUFZZCDJ
```

How does decryption happen: 

```



Input: PUWTU

Card deck:       [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28]
Intializing algorithm.

generated key: 8
Card deck after: [4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 27, 2, 3, 28]
P --> H 
generated key: 16
Card deck after: [8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 27, 3, 4, 28, 6, 7, 5]
U --> E 
generated key: 11
Card deck after: [6, 7, 28, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 5, 27, 4, 3]
W --> L 
generated key: 8
Card deck after: [17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 5, 4, 27, 6, 7, 8, 3, 28, 10, 11, 12, 13, 14, 15, 16, 9]
T --> L 
generated key: 6
Card deck after: [27, 7, 8, 3, 10, 11, 28, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6]
U --> O 

Output: HELLO



Input: CFUU

Card deck:       [27, 7, 8, 3, 10, 11, 28, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 1, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6]
Intializing algorithm.

generated key: 25
Card deck after: [26, 1, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6, 27, 8, 3, 10, 11, 17, 18, 28, 19, 20, 21, 22, 23, 24, 25, 7]
C --> D 
generated key: 5
Card deck after: [10, 11, 17, 18, 19, 20, 28, 26, 1, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6, 21, 22, 23, 24, 25, 7, 27, 3, 8]
F --> A 
generated key: 1
Card deck after: [28, 2, 5, 4, 12, 13, 14, 15, 16, 9, 6, 21, 22, 23, 24, 25, 7, 3, 27, 10, 11, 17, 18, 19, 20, 26, 8, 1]
U --> T 
generated key: 20
Card deck after: [26, 8, 1, 28, 4, 12, 13, 14, 15, 16, 9, 6, 21, 22, 23, 24, 25, 7, 3, 10, 27, 2, 11, 17, 18, 19, 20, 5]
U --> A 

Output: DATA



Input: ZJZUFZZCDJ

Card deck:       [26, 8, 1, 28, 4, 12, 13, 14, 15, 16, 9, 6, 21, 22, 23, 24, 25, 7, 3, 10, 27, 2, 11, 17, 18, 19, 20, 5]
Intializing algorithm.

generated key: 7
Card deck after: [6, 21, 22, 23, 24, 25, 7, 3, 10, 2, 27, 26, 8, 1, 4, 11, 17, 18, 19, 20, 5, 28, 13, 14, 15, 16, 9, 12]
Z --> S 
generated key: 16
Card deck after: [2, 15, 16, 9, 12, 27, 8, 1, 4, 11, 17, 18, 19, 20, 5, 13, 14, 28, 6, 21, 22, 23, 24, 25, 7, 3, 10, 26]
J --> T 
generated key: 8
Card deck after: [27, 1, 4, 11, 17, 18, 19, 20, 5, 13, 14, 6, 21, 28, 2, 15, 16, 9, 12, 22, 23, 24, 25, 7, 3, 10, 26, 8]
Z --> R 
generated key: 26
Card deck after: [9, 12, 22, 23, 24, 25, 7, 3, 10, 26, 8, 27, 4, 11, 17, 18, 19, 20, 5, 13, 14, 6, 21, 2, 15, 28, 16, 1]
U --> U 
generated key: 3
Card deck after: [19, 20, 5, 13, 14, 6, 21, 2, 15, 16, 1, 28, 9, 12, 22, 23, 24, 25, 7, 3, 10, 26, 8, 27, 11, 17, 18, 4]
F --> C 
generated key: 6
Card deck after: [8, 11, 27, 19, 20, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 17, 18, 4, 28, 22, 23, 24, 25, 7, 3, 10, 26, 12]
Z --> T 
generated key: 5
Card deck after: [17, 18, 4, 22, 23, 28, 8, 11, 24, 25, 7, 3, 10, 26, 12, 27, 20, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 19]
Z --> U 
generated key: 11
Card deck after: [28, 24, 25, 7, 3, 10, 26, 12, 20, 27, 17, 18, 4, 22, 23, 8, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 19, 11]
C --> R 
generated key: 25
Card deck after: [27, 24, 18, 4, 22, 23, 8, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 19, 11, 28, 7, 3, 10, 26, 12, 20, 17, 25]
D --> E 
generated key: 17
Card deck after: [7, 3, 28, 10, 26, 12, 20, 17, 25, 27, 18, 4, 22, 23, 8, 5, 13, 14, 6, 21, 2, 15, 16, 1, 9, 19, 11, 24]
J --> S 

Output: STRUCTURES
```


</div> </div></div>


</main>
