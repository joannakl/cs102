---
layout: lab
title: Lab
---
<!--
<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
Oct. 7
(whichever comes first)

__submission mode:__ group

</div>
-->
<main markdown="1" class="lab">

## Lab 4: <code class="code_title">ArrayList&lt;E&gt;</code> - case study


### Introduction

In class we either already did or will discuss different implementations
of a list abstract data type ADT.

The `ArrayList<E>` class in Java provides an implementation of the `List<E>` interface (which is a formal way in Java to define an ADT).
In this recitation, you will study the source code and documentation of the `ArrayList<E>` class in order to understand more about its implementation.

Answer the questions below based on the source code and the documentation pages for the `ArrayList<E>` class.

You should have downloaded the source code for the entire Java 11 collection
of classes for lab3, but if, for some reason, you no longer have access to it, you can download it again from the course website: [Java source code]({{site.baseurl }}/code/java.base.zip) (don't remove it - you will need it again later on in the semester).

You will also need the [documentation page for `ArrayList<E>`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html) as well as several other classes from which `ArrayList<E>` inherits.

Work alone or find a partner to answer the questions in the rest of this lab.


### Part 1

<span class="strong">Complete this part based on reading the documentation (NOT the source code).</span>

1. How do you figure out which package the `ArrayList<E>` class is located in (or any other class that you are trying to use)?
2. Which interfaces are implemented by the `ArrayList<E>` class?
3. Select the methods inherited from the `AbstractList<E>`  class.
4. Select the methods inherited from the `AbstractCollection<E>` class.


### Part 2

<span class="strong">Complete this part based on the source code (NOT the documentation).</span>

1. How many constructors are in the class? List them (with parameter lists).
2. The data in this class is stored in an array. What is the name of the array data field?
3. What is the type of the array data field?
4. What is the initial capacity (actual size) of the array when the `ArrayList<E>` object is created with the default constructor?
5. What is the capacity of the array **after** the first call to the `add(E e`) method is made on an `ArrayList<E>` object that was created with the default constructor?
6. What is the capacity of the array **after** the fifth call to the `add(E e)` method is made on an `ArrayList<E>` object that was created with the default constructor?
7. What is the capacity of the array **after** the eleventh call to the `add(E e)` method is made on an `ArrayList<E>` object that was created with the default constructor?
8. What is the maximum size to which this array can grow? (or what is the largest number of elements that can be stored in an `ArrayList<E>` object)
9. Assume you have an `ArrayList<E>` object with the current size of 5 (i.e., five elements were successfully added to it and none were removed. What happens when you call the method `void add(int index, E element)` and specify index 8?
10. The `grow(int minCapacity)` method makes a call to `Arrays.copyOf(T[] original, int newLength)` which then, indirectly, calls a method in the `System` class:

    `public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);`

	Research what the "native" modifier means and explain it in your own words.
11. Examine the `indexOf()` method. The code has two parts that look very similar: one is used when the parameter is `null`, the other when it is not `null`. Are both parts really needed? Explain why.
12. The `indexOf` and `contains` methods both accept a parameter of type `Object`. This means that the following code compiles and runs:
```
      ArrayList<Color> list = new ArrayList<Color>();
      // code that adds several Color objects
      if ( list.contains("hello") )
          System.out.println("hello is in the list" );
```
(assume the `Color` class from the first project).
    What happens when the `contains()` method is passed a value whose type does not match the type of the list itself? Explain where in the code this is handled? (i.e., where in the code, the value of `false` is returned).


13. Examine the    `E remove(int index)`    method. What does this method do when the `index` is larger than `size`? explain how this situation is handled, what other methods (in possibly other classes) are called  and  what is returned.

14. Examine the `trimToSize()` method. The method uses Java's ternary conditional operator `... : ... ? ...`
(see [https://www.tutorialspoint.com/Java-Ternary-Operator-Examples](https://www.tutorialspoint.com/Java-Ternary-Operator-Examples), if you are not familiar with it). Explain what this operator achieves in this particular function and rewrite the function using `if ... else ...` statement instead of the operator.

15. There are several classes _inside_ the `ArrayList<E>` class. These are called inner classes. Locate the one called `ListItr`. Study it with your group. Try to explain what the purpose of that class is (feel free to use the code as well as the documentation).  Point out things in the code of that class that seem strange, or that you do not understand.



### Part 3

1. Look at the documentation for some of the public methods in the source code and compare it to the documentation on the website. What do you notice?

1. Still looking at the documentation explain what the following keywords seem to do:
  - `@param`
  - `@return`
  - `@throws`

1. The `sort` function defined in the `ArrayList<E>` class takes an object of type `Comparator<? super E> ` as a parameter. Research what this type represents. In what ways is it similar and in what ways is it different than the `Comparable<E>` interface?

1. Study the `equals` method  in the `ArrayList<E>` class. Try to figure out step by step how it works. You will need to look at other methods that it calls to have a full understanding.


</main>
