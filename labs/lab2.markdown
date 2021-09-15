---
layout: lab
title: Lab2
---

<!--
<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
Sep. 23 (whichever comes first)

__submission mode:__ group

</div>
-->
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

#### Using Ed Workspace

To work on the problems in this recitation, you should be working in an Ed Workspace with a few other students.
Here is a quick video with instructions on how to create a single group workspace and share it with the members of your group: [how to create and use a single Ed workspace for lab 2](https://youtu.be/Bam-JvlIt5I).



### Problem 1


#### Part 1
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

To complete this part, you should setup the Ed workspace. Make sure to share it with your section leader
in addition to your group members.

#### Part 2

Handling problems like the ones you observed in Part 1 requires different types of validation techniques:

*  If the input data is supposed to fall within a certain range (dictated by the specification, instructions or, sometimes, common sense), then the program should make sure that those ranges are met.
*  If certain values make sense and others do not (this should really be determined by the specification), then the program should attempt to detect and reject the values that do not make sense.
*  If the program makes calls to functions that throw exceptions[^1], the code should be ready to handle those exceptions (the language like Java forces programmers to handle checked exceptions[^2], but it is a good idea to watch out for the unchecked exceptions as well ). Catching and handling specific types of exceptions allows us to write appropriate types of handlers for the errors that may occur. (This is done using try and catch blocks.)
*  If the input data comes from the user, the input buffers should be emptied when the input statement is satisfied. In some cases, it might be worthwhile to warn the user (especially in the interactive programs that deal with sensitive information) if part of the input is being ignored. If you are using the [Scanner](https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html) class in Java, make sure that you understand the difference between the `nextLine()` function and the other next-functions, like `next()`, `nextInt()`, `nextFloat()`,   ....

#### Activity

Work with a team. Each of you has something to contribute here. It is not an easy problem.

- Group the problems you identified with the code from Part 1 into related groups (the problems that might be fixed using a similar approach). (3-5 minutes)

- Modify the original code to handle one group of problems at a time. Each time you add code to handle a particular problem, run the program and 1) verify that the problem is actually fixed, and 2) make sure that nothing else broke.
  - If you discover that there are problems that you cannot fix, move on to the next group. If you have time, you can come back to those later.

- As a final test, submit your code on Gradescope for _Recitation-week2-problem1_ assignment.


**Warning: it may be challenging to pass all of the tests, but it is possible to do so with the knowledge of Java that you should have acquired in CSCI-UA 101!**



[^1]:     If you do not remember how to handle exceptions in Java, take a look at the Oracle [lessons on exception handling](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

[^2]:
     If you are not sure about the difference between checked and unchecked exceptions, you may want to review them. Here is a possible tutorial:  [Checked vs Unchecked Exceptions in Java](https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/)


### Problem 2


As a practice for this, there is an exercise (called **lab2_extra**) on Gradescope with 20 test cases, but you will not see the tests themselves. Each test is worth 0.05 points, so this can give you a hint as to how many tests passed and how many failed.

Write a function that, given a string argument, returns the sum of the numbers appearing in that string, ignoring all other characters. A number is a series of 1 or more digit characters in a row. (Note: [`Character.isDigit(char)`](https://docs.oracle.com/javase/10/docs/api/java/lang/Character.html#isDigit(char)) function tests if a char is one of the characters '0', '1', .. '9'. [`Integer.parseInt(string)`](https://docs.oracle.com/javase/10/docs/api/java/lang/Integer.html#parseInt(java.lang.String)) converts a string to an int.)

*   `sumOfNumbers("abc123xyz")` should return 123
*   `sumNumbers("aa11b-33")` should return 44 (11+33 = 44, note that '-' does not turn the value into a negative one)
*   `sumNumbers("7 11")` should return 18 (7+11 = 18, since there is a space between 7 and 11)
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


Do not add `main` function. Do not change the name of the package. Do not change the name of the class
or the name of the function in the template.


### Problem 3

OpenMRS is an open source medical record management system. Being open source means that anybody can read the source code, contribute to it, and, depending on the license, reuse it in their own projects. A lot of the components of OpenMRS are written in Java. We will look to that package for the _real life_ examples of some concepts that are covered in this course. Today you will start with real life input data validation. Go to OpenMRS main GitHub page at [https://github.com/openmrs](https://github.com/openmrs) , select openmrs-core and then directories: `api > src > main > java/org/openmrs  > validator`. This directory contains many different classes that provide validation of various types of values obtained from the user or from other external sources. Take a look at `PersonNameValidator.java` class. Read through the code - you may not be able to understand every single line of the code, but you should be able to get a rough idea what it is doing. Can you figure out what makes a valid name in OpenMRS. 





</main>
