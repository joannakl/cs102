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

## Lab 2: Bullet-Proof Programs or Input Validation Continued.

### Problem 1

This is a group project done in the recitation. You will get the link during your weekly recitation.

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

OpenMRS is an open source medical record management system. Being open source means that anybody can read the source code, contribute to it, and, depending on the license, reuse it in their own projects. A lot of the components of OpenMRS are written in Java. We will look to that package for the _real life_ examples of some concepts that are covered in this course. Today you will start with real life input data validation. Go to OpenMRS main GitHub page at [https://github.com/openmrs](https://github.com/openmrs) , select openmrs-core and then directories: `api > src > main > java/org/openmrs  > validator`. This directory contains many different classes that provide validation of various types of values obtained from the user or from other external sources. Take a look at `PersonNameValidator.java` class. Read through the code - you may not be able to understand every single line of the code, but you should be able to get a rough idea what it is doing. Discuss with your group members what makes a valid name in OpenMRS.





</main>
