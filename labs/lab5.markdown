---
layout: lab
title: Lab
---

<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
October 14
(whichever comes first)

__submission mode:__ group

</div>

<main markdown="1" class="lab">

## Lab 5: Iterating Over Things and the for-each Loop

### Introduction

You might have used a for-each loop in some of your programs.
You might have wondered how it works. If you did neither, you still need to
complete this lab because iterating over collections of items is something that
we will do not only for lists and linear structures,
but for all other data structures as well.

Let’s start with the following program:


{% highlight java linenos%}
import java.util.ArrayList;

public class ForEach {
  public static void main (String [] args ) {
    ArrayList<String> list = new ArrayList<String>();


    list.add("Warsaw");
    list.add("Venice");
    list.add("Atlanta");
    list.add("New York");
    list.add("Rome");


    for ( String city : list )
      System.out.println(city);


    //add duplicates
    for (String city : list )
      list.add(city);


    //remove cities starting with "W"
    for ( String city : list )
      if ( city.startsWith("W") )
        list.remove (city) ;
  }
}
{% endhighlight %}


What do you think it does? Try to figure it out before attempting to compile it and run it.

The above code uses the for-each loop in three places. It is a handy tool,
but (as you might have discovered when trying to run the above code) it does not
always work.

These loops are based on iterators and you need to understand a bit more about
iterators before you understand why only one of the above for loops works without
causing a runtime error.


### Part 1  (as a group during recitation; submit your answers on Gradescope)

For this part use the documentation as well as the source code for Java
 that you downloaded a couple of weeks ago.


1. Look at the documentation page for `ArrayList` class. List all interfaces that
this class implements.
2. Look at the documentation of the
[`Iterable<E>` interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Iterable.html).
List all the methods that are required by that interface. Indicate the ones
that are provided by the `ArrayList` class directly (not the ones that may be
inherited from other classes).



### Part 2  `Iterable<E>` and `Iterator<E>`  (as a group during recitation; submit your answers on Gradescope)

One of the methods required by the `Iterable<E>` interface is called
`iterator()` - it returns an instance of  `Iterator<E>`. Look at the documentation
for `Iterator<E>`, [https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html)  and answer the following questions.

1. Is `Iterator<E>` a class or an interface?
2. List all the methods from `Iterator<E>`.
3. Some of the methods have the `default` keyword listed next to their name.
Research what that keyword does/means and briefly explain it.
4. What is the purpose of the `next()` method? In what situations might it
throw an exception?
5. What is the purpose of the `hasNext()` method?


### Part 3   Implementing the `Iterable<E>` Interface  (as a group during recitation; submit your answers on Gradescope)

Look at the source code for `ArrayList` class. Since it is implementing the
`Iterable<E>` interface, it should have a method called `iterator()`.
That method should be returning an instance of an `Iterator<E>`. Look for the
class associated with that instance.  Answer the following questions based on
the source code that you are looking at.


1. What is the name of the class that represents the object returned by the
`iterator()` method of the `ArrayList<E>` class? HINT: you need to look at the
source code to see the type of the object that is actually returned.
2. Where is that class implemented (specify the file name and the line number)?
What is the relationship between that class and the `ArrayList<E>` class?
3. Look at the cursor data field in that class. In your own words, describe its purpose.
4. Look at the `next()` method of that class. Ignoring the `checkForComodification()`
function call, figure out what the function does and describe the steps.
5. One of the lines in the `next()` method is

    ```
    Object[] elementData = ArrayList.this.elementData;
    ```
    What does this line do? What do you think `ArrayList.this` refers to? Could
    we replace it with `this`?


After answering the questions in Parts 1-3, go back to the code example in the Introduction.
Try to figure out why it does not work.


### Part 4   Making a linked list iterable  (as a group during recitation; work in an Ed Workspace; submit your answers on Gradescope)

Go to Ed Workspaces.
- One of your group members should fork the `LinkedList` workspace that we worked with during the lecture.
(It should have a very basic `LinkedList` class implementation.)
- The other group members should be invited to that workspace, so you can collaborate to complete this part.


Task: Add `implements Iterable<E>` to the header of the class. Implement all the methods
and inner classes that are going to turn the `LinkedList` class into iterable collection.

Once you finish (or the when the recitation ends) add the URL of your workspace as the answer
for this part on Gradescope.


### Part 5  (as a group during recitation; submit your answers on Gradescope)

Write down one or two questions that your group still has about iterators.


</main>
