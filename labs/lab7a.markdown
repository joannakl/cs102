---
layout: lab
title: Lab
---

<!--
<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
Sept. 16
(whichever comes first)

__submission mode:__ group

</div>
-->

<main markdown="1" class="lab">

## Lab 7a Add

This lab will give you some practice in submitting the types of problems you will be working on for project 4.

The name for the class that contains `main()` function should be `Main`. There should NOT be any package names in the submitted files.
The program should read all the input from the _standard input_ stream, and write all the output to the _standard output_ stream.

The submission link is available on Gradescope. You will see if you passed or failed tests. But you will NOT see what the tests are, so make sure to come up with tests on your own.



### Problem Statement (with solution)

Write a program that reads two integers from standard input, calculates their sum and prints the result to standard output.

__Input__

Two integer values  -1,000,000,000 <= v1, v2 <= 1,000,000,000 each on its own line.

__Output__

A single value that is the sum of v1 and v2 followed by a newline.

__Example 1__

```
Input:
4
9

Output:
13

```


__Example 2__

```
Input:
-5
5

Output:
0

```


---

A simple Java solution for this program is here:


```Java
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int a = in.nextInt();
		int b = in.nextInt();
        System.out.println(a + b);
    }
}
```

Note a few things:
- the user is not prompted for anything
- the only output is the actual answer
- the words "Input" and "Output" shown the examples above should not 
be produced by your program, they are just parts of the examples 



### Problem Statement

(For this one, write a program and submit it on Gradescope to make sure 
that you are conforming with the autograder requirements.) 


Write a program that reads two integers from standard input, calculates their sum and prints the result to standard output.

__Input__

Two integer values  -2,000,000,000 <= v1, v2 <= 2,000,000,000 each on its own line.

__Output__

A single value that is the sum of v1 and v2 followed by a newline.

__Example 1__

```
Input:
4
9

Output:
13

```


__Example 2__

```
Input:
-5
5

Output:
0

```

</main>
