---
layout: lab
title: Lab3
---

<!--
<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
Sep. 30
(whichever comes first)

__submission mode:__ group

</div>
-->

<main markdown="1" class="lab">

## Lab 3: Finding Code Responsible for Behavior

### Introduction

*   Have you ever run a program and wondered why it does what it does?
*   Have you ever run your own code and wondered why it does not do what you expected it to do?
*   Have you ever accidentally wrote a line of code that turned out to be correct, but you were not sure why it worked?

In this lab you will learn and practice some techniques that may be used to demystify such situations.

Here is a simple program. You might have seen similar programs in the previous course.



{% highlight java linenos%}
import java.util.ArrayList;

public class PrintlnMystery {
    public static void main( String[] args ) {

        ArrayList<Integer> list = new ArrayList<Integer> ();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println( list );
    }
}
{% endhighlight %}


When we run it, it produces a single line of output:


```
    [1, 2, 3, 4, 5]
```


How does it work? How does `println` function know what to do? Where do the commas and the square brackets come from? And what is `System.out` to begin with? (Yes, you probably used `System.out` a thousand times, but have you ever stopped to think about what it actually is. Is it a class, object, something else? Where is it defined? What other things you can do with it?)

It order to complete the three parts below, you will need two things:
- [Java documentation pages](https://docs.oracle.com/en/java/javase/11/docs/api/index.html)
- [Java source code]({{site.baseurl }}/code/java.base.zip) - make sure that you download the source code and extract it from the zip file prior to the recitation. You should also know where you saved it and how to navigate back to it, so that you can access it easily when you are working with your group.

__This lab uses Java 11. It does not matter if the version of Java installed on your own system is different.__

### Part 1

<span class="strong">Complete this part based on reading the documentation (NOT the source code).</span>

Java API comes with thorough documentation. You can browse through it starting at the main page at [Java documentation pages](https://docs.oracle.com/en/java/javase/11/docs/api/index.html), or you can just use a search engine to look for the name of a particular class that you are interested in. Note that the search often returns documentation pages for older versions of Java (versions 7 and 8 still seem to be dominant). In some cases it does not matter. But when you need documentation for a specific version, just add 'java 11', for example, to your search query.



*   Read  the documentation for the **[System](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/System.html)** class.
*   Find the class in which the **println** function is defined and look at the detailed description(s) of this function.  It says there that it uses **valueOf** function defined in another class. Look at the documentation for that function.
*   Finally, the documentation for the appropriate **valueOf** function claims to use yet another function (don't worry, this is the end of this chain). Look at the documentation for that function (you need it to answer one of the questions below).

Answer the following questions:


1. What does **System.out** represent? What is it with respect to the **System** class (data member/field, static data member/field, method, static method, ...)?
2. What is the type of **System.out**?
3. Which class is  **println()** function defined in?
4. There are several **println** functions. How do they differ? Which function is called/used in the above program (on the last line of the code)? <br>
WARNING: think of how the compiler decides which overloaded function should be called!
5. **println** calls **valueOf** function while it executes. What class is this function defined in?
6. There are several **valueOf** functions. Which function is used in the above program?
7. **valueOf** function calls another function. In which class is that function defined?
8. Reading all the documentation, were you able to figure out where the square brackets and the commas in the output come from? If so, what is the answer? If not, you probably took a wrong _turn_ answering one of the questions above. Go back to the previous questions and/or ask for help.


### Part 2

<span class="strong">Complete this part based on the source code (NOT the documentation).</span>

OpenJDK (Open Java Development Kit) is a free and open source implementation of the Java programming language. To download its source code use the link in the Introduction section above.

Look at the sub-directory structure in the source code that you downloaded. Pay special attention to the **java** subdirectory.

Open any of the source code files (the ones with .java extension). Take a look at the top 24 or so lines. The text talks about _GNU General Public License, version 2_. Find a website that describes what that is.

Answer the following questions:

1. How does the sub-directory structure in the source code relates to package/import statements that you include at the top of many of your programs? (For example the first line in the program above.)
2. What are the top 24 lines of each source code file? Why do you think they are there?
3. Are you allowed to modify and redistribute the source code of OpenJDK?




### Part 3

<span class="strong">Complete this part based on reading the source code and the documentation.</span>

Locate and open the Java source code for the class that you determined contains the **toString** function executed to produce the output with square brackets and commas for the **ArrayList** object.

Looking at the implementation of the **toString** function you will discover several things that you may
not have encountered before. Don't worry about those lines. You should have enough intuition (given the
comments above the method and what you observed in practice) to figure out what the method does even
without understanding each line of code.

Answer the following questions:

1. Find and list some parts in the source code of the **toString** function (the one responsible for putting together string representation of an **ArrayList** object) that are unfamiliar/strange.
2. Indicate the line of code that produces the open square bracket ”[” (specify the line(s) number and copy the line(s) here).
3. Indicate the line of code that produces the close square bracket ”]” (specify the line(s) number and copy the line(s) here).
4. Indicate the line of code that places the comma and space between the elements in the ArrayList (specify the line(s) number and copy the line(s) here).























</main>
