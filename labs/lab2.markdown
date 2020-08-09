---
layout: lab
title: Daily
---


## Lab 2: Bullet-Proof Programs or Input Validation

### Introduction

Popular Murphy's Law states: _whatever can go wrong, will go wrong_.

In the previous programming courses, you probably often heard the phrase: "assume a well-behaved user".
If we can assume that the input data that comes from the user or files is correct, then the programs become simpler.
But the users and input files are generally not well-behaved. At some point we need to be able  to write code that can handle real users and real data (i.e., whatever is thrown at it).
What do I mean by handle?
The program should not crash and it should not produce results that make absolutely no sense. Instead, the code should validate any input data and produce appropriate error messages indicating invalid data types or values.
In some situations the program may be able to request the user to re-enter incorrectly provided information (this makes sense in interactive programs).
In some cases, the program may need to skip invalid data (and optionally log that fact in an error log file).
In some cases, the program may have to terminate after producing the error indicating what went wrong.
Not validating data properly may lead to very costly consequences for the users and the companies that use such software. Here is one story from a few years ago that may give you goosebumps: [The $100,000 Keying Error](http://ieeexplore.ieee.org/document/4488265/).

Complete the exercises  described below.  Their goal is to give you practice
in recognizing the potential for trouble and on bullet-proofing your own code
(or at least attempting to do so).

### Part 1 (nothing to submit)
Consider the following short program:

{% highlight java %}
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

```java
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
```

There are more possible inputs that cause problems than there are those that will
produce correct and reasonable results.
Try to run the program with the following input values provided for the
two prompts (the first one is supposed to be the age; the second one is supposed to be the name).

- &nbsp;
```
  21
  Jane
```
- &nbsp;
```
  -35
  Mark
```

215
    Joe
3
    R2d2
18
    Ann Marie
111111111111111
    Ann
32.5
    Amber
Eighteen
    Steven
32 43 12
    Ellen


You can upload this code to the autograder on Gradescope
(save the code in a file called Age.java in the package called lab2).
You will see that all, but one of the tests fail.
