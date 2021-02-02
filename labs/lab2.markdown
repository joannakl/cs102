---
layout: lab
title: Lab2
---

<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
Sep. 23 (whichever comes first)

__submission mode:__ group

</div>

<main markdown="1" class="lab">

## Lab 2: Bullet-Proof Programs or Input Validation

### Introduction

Popular Murphy's Law states: _whatever can go wrong, will go wrong_.

In the previous programming courses, you probably often heard the phrase: "assume a well-behaved user".
If we can assume that the input data that comes from the user or files is correct, then the programs become simpler.
But the users and input files are generally not well-behaved. At some point we need to be able  to write code that can handle real users and real data (i.e., whatever is thrown at it).

__What do I mean by handle?__

The program should not crash and it should not produce results that make absolutely no sense. Instead, the code should validate any input data and produce appropriate error messages indicating invalid data types or values.
In some situations the program may be able to request the user to re-enter incorrectly provided information (this makes sense in interactive programs).
In some cases, the program may need to skip invalid data (and optionally log that fact in an error log file).
In some cases, the program may have to terminate after producing the error indicating what went wrong.
Not validating data properly may lead to very costly consequences for the users and the companies that use such software. Here is one story from a few years ago that may give you goosebumps: [The $100,000 Keying Error](http://ieeexplore.ieee.org/document/4488265/).

Complete the exercises  described below.  Their goal is to give you practice
in recognizing the potential for trouble and on bullet-proofing your own code
(or at least attempting to do so).

### Part 1 (on your own, before the group meeting in the recitation; nothing to submit)
Consider the following short program:

{% highlight java linenos%}
package lab2;
import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your age (a positive integer): ");
        int num = in.nextInt();
        System.out.println("Enter your name: ");
        String name = in.next();
        System.out.println(name + " is  " + num + " years old." );
        in.close();
    }
}
{% endhighlight %}

There are more possible inputs that cause problems than there are those that will
produce correct and reasonable results.
Try to run the program with the following input values provided for the
two prompts (the first one is supposed to be the age; the second one is supposed to be the name).

- `21 Jane`
- `-35 Mark`
- `215 Joe`
- `3 R2d2`
- `18 Ann Marie`
- `111111111111111 Ann`
- `32.5  Amber`
- `Eighteen Steven`
- `32 43 12 Ellen`



### Part 2 (as a group during recitation; submit your file on Gradescope)

You should be working in an Ed Workspace with your group members.
Here is a quick video with instructions on how to create a single group workspace and share it with the members of your group: [how to create and use a single Ed workspace for lab 2](https://stream.nyu.edu/media/1_dbx055dl) (or [here](https://youtu.be/Bam-JvlIt5I), if the previous link does not work).

Handling problems like the ones you observed in Part 1 requires different types of validation techniques:

*  If the input data is supposed to fall within a certain range (dictated by the specification, instructions or, sometimes, common sense), then the program should make sure that those ranges are met.
*  If certain values make sense and others do not (this should really be determined by the specification), then the program should attempt to detect and reject the values that do not make sense.
*  If the program makes calls to functions that throw exceptions[^1], the code should be ready to handle those exceptions (the language like Java forces programmers to handle checked exceptions[^2], but it is a good idea to watch out for the unchecked exceptions as well ). Catching and handling specific types of exceptions allows us to write appropriate types of handlers for the errors that may occur. (This is done using try and catch blocks.)
*  If the input data comes from the user, the input buffers should be emptied when the input statement is satisfied. In some cases, it might be worthwhile to warn the user (especially in the interactive programs that deal with sensitive information) if part of the input is being ignored. If you are using the [Scanner](https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html) class in Java, make sure that you understand the difference between the `nextLine()` function and the other next-functions, like `next()`, `nextInt()`, `nextFloat()`,   ....

#### Activity

1. As a team try to group the problems you identified with the code from Part 1 into related groups (the problems that might be fixed using a similar approach). (3-5 minutes)

1. Divide the groups that you identified in step 1 between your team members and try to modify the original code to handle those problems. (10 minutes) You can create additional files in which each of you is trying
to fix the problem they are working on so that you are not creating conflicts between each other.

    You should restrict valid age values to be integers in the range of 0 to 120 (inclusive). The valid names should consist of letters, spaces and hyphens ('-') only (sorry R2D2!).

1. Discuss your attempted fixes with the rest of your team:
  - which problems were you able to fix?
  - which problems still persist?
  - where the problems your team grouped together in step 1 really belong to the same group or should they be handled differently?
  (5 minutes per team member)

1. Combine all your code into a single solution that fixes as many problems as possible. You will submit that file to  Gradescope.




**Warning: it may be challenging to pass all of the tests, but it is possible to do so with the knowledge of Java that you should have acquired in CSCI-UA 101!**



### Part 3 (nothing to submit)

OpenMRS is an open source medical record management system. Being open source means that anybody can read the source code, contribute to it, and, depending on the license, reuse it in their own projects. A lot of the components of OpenMRS are written in Java. We will look to that package for the _real life_ examples of some concepts that are covered in this course. Today you will start with real life input data validation. Go to OpenMRS main GitHub page at [https://github.com/openmrs](https://github.com/openmrs) , select openmrs-core and then directories: `api > src > main > java/org/openmrs  > validator`. This directory contains many different classes that provide validation of various types of values obtained from the user or from other external sources. Take a look at `PersonNameValidator.java` class. Read through the code - you may not be able to understand every single line of the code, but you should be able to get a rough idea what it is doing. Discuss with your group members what makes a valid name in OpenMRS.


### Extra credit (optional - complete Part 2 before you attempt this; can be done as a group or individually)

Last week you worked on solving several problems and using the CodeBat autograder/autotester to verify if your solution was correct. In parts 1 and 2, we gave you an autograder that determined the correctness of the implementation. In more realistic situations, there is no such tester. The programmers need to be able to convince themselves that their work is correct.

This semester we will be using an autograder on Gradescope to give you hints about your program's correctness. At first, you will see all of the tests and see if they passed or not (just like for parts 1 and 2). As the semester progresses, we will hide some of the tests so that you are going to need to decide on your own if the code that you submit is correct or not.

As a practice for this, there is an exercise (called **lab2_extra**) on Gradescope with 20 test cases, but you will not see the tests themselves. Each test is worth 0.05 points, so this can give you a hint as to how many tests passed and how many failed.

The problem for which you need to write a solution is as follows:

Write a function that, given a string argument, returns the sum of the numbers appearing in that string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: [`Character.isDigit(char)`](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#isDigit(char)) function tests if a char is one of the characters '0', '1', .. '9'. [`Integer.parseInt(string)`](https://docs.oracle.com/javase/10/docs/api/java/lang/Integer.html#parseInt(java.lang.String)) converts a string to an int.)

*   `sumOfNumbers("abc123xyz")` should return 123
*   `sumNumbers("aa11b-33")` should return 44 (note that '-' does not turn the value into a negative one)
*   `sumNumbers("7 11")` should return 18 (since there is a space between 7 and 11)
*   `sumNumbers("hello")` should return 0

You should implement your code in the following template:


{% highlight java%}
package lab2;
//do not change the name of the package
//the autograder will fail, if the package is not named properly

// add your own name below:
//
// author:
//


public class SumOfNumbers {

    /*
    Implement this function. Do not change
    anything else in this file.
    */
    public static int sumOfNumbers(String str) {

    }
}

{% endhighlight %}



[^1]:     If you do not remember how to handle exceptions in Java, take a look at the Oracle [lessons on exception handling](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

[^2]:
     If you are not sure about the difference between checked and unchecked exceptions, you may want to review them. Here is a possible tutorial:  [Checked vs Unchecked Exceptions in Java](https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/)

</main>
