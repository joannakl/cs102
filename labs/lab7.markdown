---
layout: lab
title: Lab
---
<!--
<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
LATEST_DATE
(whichever comes first)

__submission mode:__ group

</div>
-->
<main markdown="1" class="lab">

## Test Driven Development (TDD) and using JUnit Testing

### Introduction

Every program requires testing and maintenance. There are many different types of testing approaches and many different philosophies regarding what things should be tested and how. The exercises below are designed to introduce you to a couple of tools and approaches that are used in testing. This is by no means an exhaustive introduction and using these techniques will not guarantee that you write bug-free code, but it may help.

### Part 1


Test driven development (TDD) is something that many consider _the right_ way of approaching the software development and software testing. What is TDD? An intro to the course on TDD at lynda.com:  [https://www.youtube.com/watch?v=QCif_-r8eK4](https://www.youtube.com/watch?v=QCif_-r8eK4) .  As NYU students you have free access to all lynda.com tutorials, so you could follow the entire course. It is well worth it.

Watch the video ahead of time so you know what the major ideas behind TDD are.

You may also find the following tutorial useful: Introduction to Test Driven Development at [http://www.agiledata.org/essays/tdd.html](http://www.agiledata.org/essays/tdd.html)

Note that the definition of TDD given by google when you just search for ”Test driven development” does not really capture the testing aspect of it. Do not copy and paste that definition to your answers on the worksheet. TDD is an approach to developing software. Any such approach uses several different types of testing. The kinds of tests that you should be thinking about at this point of your software developer career are __unit tests__ and __integration tests__. Use the web to try to find definitions/descriptions of what these two types of tests are and how they differ. You should look at least at two or three sources to make sure you get the best view of what these types of tests are.

You should be able to answer the following questions:

1. What is the difference between TDD way of software development and the way that you are developing the code right now?

2. What is meant by unit testing?

3. What is meant by integration testing?


### Part 2  Writing Simple Unit Tests

In this example, we will look at a class representing a 2D point (just like the one we looked
at in class).

We will focus on testing two methods (or rather writing just a couple of tests for each of those two methods):

```java
/**
 * Compareres this point with the paramter. The Point objects are compared based
 * on their distance from the origin: given two Point objects the one closer
 * to the origin is considered to be smaller.
 * @param other the Point object to compare to this object
 * @return 1, 0, -1 to indicate the this object is greater than, equal to or less than the parameter object
 * @throws NullPointerException  if the specified object is null
 **/
public int compareTo ( Point other );

/**
 * Computes and returns the sum of this point and a given point p.
 * @param other a Point object to be added to this object
 * @return a Point object that is the sum of this object and the parameter object
 * @throws IllegalArgumentException  if the specified object is null
 **/
public Point add ( Point other ) ;

```


The first method is actually implemented in the class. But the true TDD happens when we write the tests
__before__ we write the actual implementation - we will do that with the `add` method.

Looking at the specification for the methods, we need to come up with the tests.

Here are some ideas for testing the `compareTo` method:
- does it throw a right exception when called with `null` parameter?
- does it return correct value when it is called with two `Point` objects that are the same? does
it matter which of the objects is passed as the parameter (i.e., given two points `p1` and `p2`
that are the same is it true that `p1.compareTo(p2) == p2.compareTo(p1) == 0`?)
- does it return correct value when it is called with two `Point` objects that are not the same? does
it matter which of the objects is passed as the parameter (i.e., given two points `p1` and `p2`
is it true that `p1.compareTo(p2) == - p2.compareTo(p1)`?)

And here are some ideas for testing the `add` method:
- does it throw a right exception when called with `null` parameter?
- does it return the correct value when it is called with a point `(0.0, 0.0)`?

(Note that these are not exhaustive tests. They are meant to illustrate how the test can be written.)


__JUnit methods to use in tests__

You can write many tests with just a couple of functions to use for testing:

- `fail(MESSAGE)` - call this function when you reach the point at which the test fails;
use `MESSAGE` to indicate what happened

- `assertEquals(MESSAGE, EXPECTED_VALUE, COMPUTED_VALUE)` - call this function to
test if the value computed by a function is equal to what was expected;
use `MESSAGE` to indicate what happened

- `assertTrue(MESSAGE, CONDITION)` - call this function to test if a `CONDITION` is
true (this often compares the return value to some upper or lower bound);
use `MESSAGE` to indicate what happened


There are some more functions described at
[http://junit.sourceforge.net/javadoc/org/junit/Assert.html](http://junit.sourceforge.net/javadoc/org/junit/Assert.html)


__Testing `Point` class__

With these few methods, we can write a few tests for our `Point` class.

You can find the source code for the class below in the appendix and in the workspace that
you will be working with during the recitations.


Look at the class `PointTest` to see five tests.

Use the instructions at the top of that file to compile and execute the test.

The tests for the `add` method are commented out. When you run the test class, all
tests for the `compareTo` method pass. You should see

```
JUnit version 4.12
...
Time: 0.005

OK (3 tests)
```

Now, uncomment the tests for the `add` method and compile and run the test class again.
This will produce errors since the `add` method is not implemented yet:

```
JUnit version 4.12
.E...E.
Time: 0.007
There were 2 failures:
1) testAdd_null(PointTest)
java.lang.AssertionError: No exception thrown for null parameter.
at org.junit.Assert.fail(Assert.java:88)
at PointTest.testAdd_null(PointTest.java:79)
at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)

...

2) testAdd_origin(PointTest)
java.lang.AssertionError: Incorrect Point object returned expected:<(10.0000, 7.7000)> but was:<null>
at org.junit.Assert.fail(Assert.java:88)
at org.junit.Assert.failNotEquals(Assert.java:834)
at org.junit.Assert.assertEquals(Assert.java:118)

...

at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
at org.junit.runner.JUnitCore.runMain(JUnitCore.java:77)
at org.junit.runner.JUnitCore.main(JUnitCore.java:36)

FAILURES!!!
Tests run: 5,  Failures: 2
```

Each failed test shows the error message and a detailed stack trace when the test failed.

### Part 3


The Ed workspace titled [project 2 tests](https://edstem.org/us/courses/3906/workspaces/pdNWYBwEtKULq8XiryjhGehoz1NnMQ2B)
includes the package `project2`. These the test that were used in the autograder for project 2.



### Additional JUnit Tutorial

- [Lars Vogel](http://www.vogella.com/people/larsvogel.html) is one of the Eclipse
developers as well as the author of a JUnit tutorial at [http://www.vogella.com/people/larsvogel.html](http://www.vogella.com/people/larsvogel.html)

- [JUnit Tests: How To Write JUnit Test Cases With Examples](https://www.softwaretestinghelp.com/junit-tests-examples/)

- [JUnit Tutorial for beginner with Eclipse](https://www.codejava.net/testing/junit-tutorial-for-beginner-with-eclipse)



### Source Code

__`Point` class__

{% highlight java%}

public class Point implements Comparable <Point>  {

    private double x;
    private double y;

    public Point ( double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public boolean equals (Object obj) {
        if (obj == this ) return true;
        if (obj == null ) return false;
        if (! (obj instanceof Point) )  return false;
        Point other = (Point) obj;
        if ( this.x - other.x < 0.00001 && other.x - this.x < 0.00001
            && this.y - other.y < 0.00001 && other.y - this.y < 0.00001 )
            return true;
        return false;
    }
    /**
     * Compareres this point with the paramter. The Point objects are compared based
     * on their distance from the origin: given two Point objects the one closer
     * to the origin is considered to be smaller.
     * @param other the Point object to compare to this object
     * @return 1, 0, -1 to indicate the this object is greater than, equal to or less than the parameter object
     * @throws NullPointerException  if the specified object is null
     **/
    public int compareTo ( Point other ) {
        double thisDist = this.x*this.x + this.y*this.y;
        double otherDist = other.x*other.x + other.y*other.y;
        if (thisDist < otherDist)
            return -1;
        else if (thisDist > otherDist)
            return 1;
        else
            return 0;
    }
    /**
     * Computes and returns the sum of this point and a given point p.
     * @param other a Point object to be added to this object
     * @return a Point object that is the sum of this object and the parameter object
     * @throws IllegalArgumentException  if the specified object is null
     **/
    public Point add ( Point other ) {

        //TODO: develop it at a later time
        return null;
    }

    public String toString ( ) {
        return String.format("(%.4f, %.4f)", this.x, this.y);
    }
}


{% endhighlight %}

__`PointTest` class__

{% highlight java%}

import static org.junit.Assert.*;
import org.junit.Test;

/*

To compile this code execute (hint: copy and paste to avoid typing errors):

javac -cp .:/usr/share/java/junit-4.12.jar PointTest.java

To run this code execute (hint: copy and paste to avoid typing errors):

java -cp .:/usr/share/java/junit-4.12.jar:/usr/share/java/hamcrest-core.jar org.junit.runner.JUnitCore PointTest

*/


public class PointTest {
    @Test
    public void testCompareTo_withNull () {
        try {
            Point p1 = new Point (10, 7.7);
            Point p2 = null;
            p1.compareTo(p2);
            fail("No exception thrown for null parameter.");

        }
        catch (NullPointerException ex) {
            //desired behavior, test passed
        }
        catch (Exception ex) {
            fail("Invalid exception thrown.");
        }

    }

    @Test
    public void testCompareTo_equal () {
        try {
            Point p1 = new Point (10, 7.7);
            Point p2 = new Point (7.7, 10);
            int comp;
            comp = p1.compareTo(p2);
            assertEquals("Invalid value returned for equal Point objects", 0, comp);
            comp = p2.compareTo(p1);
            assertEquals("Invalid value returned for equal Point objects", 0, comp);

        }
        catch (Exception ex) {
            fail("Unexpected exception thrown.");
        }

    }
    @Test
    public void testCompareTo_notEqual () {
        try {
            Point p1 = new Point (10, 10.0);
            Point p2 = new Point (0, 10);
            int comp;
            comp = p1.compareTo(p2);
            assertEquals("Invalid value returned for Point objects that are not equal", 1, comp);
            comp = p2.compareTo(p1);
            assertEquals("Invalid value returned for Point objects that are not equal", -1, comp);

        }
        catch (Exception ex) {
            fail("Unexpected exception thrown.");
        }

    }

/*
    @Test
    public void testAdd_null (){
        try {
            Point p1 = new Point (10, 7.7);
            Point p2 = null;
            p1.add(p2);
            fail("No exception thrown for null parameter.");

        }
        catch (IllegalArgumentException ex) {
            //desired behavior, test passed
        }
        catch (Exception ex) {
            fail("Invalid exception thrown.");
        }
    }

    @Test
    public void testAdd_origin () {
        try {
            Point p1 = new Point (10, 7.7);
            Point p2 = new Point (0, 0);
            Point p = p1.add(p2);
            assertEquals("Incorrect Point object returned", p1, p);
            p = p2.add(p1);
            assertEquals("Incorrect Point object returned", p1, p);
        }
        catch (Exception ex) {
            fail("Unexpected exception thrown.");
        }

    }
*/

}

{% endhighlight %}

</main>
