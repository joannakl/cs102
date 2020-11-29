---
layout: lab
title: Lab
---

<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
December 11
(whichever comes first)

__submission mode:__ group

</div>

<main markdown="1" class="lab">

## Lab 12 Binary Search Trees and AVL Trees

### Working with Binary Search Trees and AVL Trees (as group during recitation)

With your group complete the exercises in Lab 12 on Gradescope.
<br/><br/>

-----

## Additional Practice Problems (on your own for additional practice, no need to submit)

### Binary Heap

__Problem 1__

Assume that the array representing a min binary heap contains the values 2, 8, 3, 10, 16, 7, 18, 13, 15. Show the contents of the array after inserting the value 4. Show the tree representation of this heap.

__Problem 2__

Assume that the array representing a min binary heap contains the values 2, 8, 3, 10, 16, 7, 18, 13, 15. Show the contents of the array after deleting the minimum element. Show the tree representation of this heap.

__Problem 3__

In a min binary heap with N elements, what is the range of indices in which the largest element should be located?

__Problem 4__

Which of the arrays represents a binary heap?

<img src="img/binary_heap.png" alt="binary heap ? " width="500px" />


__Problem 5__

Consider the `PriorityQueue.java` file from Java API. This class provides an implementation of a priority queue (very much like the one we discussed in class).
There is a `heapify()` method in that class that is used to establish the heap properties for the data stored in the underlying array.
Answer the following questions after studying the `heapify()` method and some other parts of the `PriorityQueue` class.

- The method  `heapify()` is private. Determine which public methods make use of it (directly or indirectly). Describe what situation requires the use of this method.

- Assume that the array used for storage in the `PriorityQueue` class contains the following elements and the `size` variable is equal to 9.

  ```
  [45  36   89   50  12  72  95  20  5 ]

  ```

  Show the content of the array after each iteration of the for loop in the  `heapify()`  method.
  Assume that the elements are of type `Integer` and therefore implement `Comparable<Integer>` interface which is used to determine the relationship between elements (this means you can assume that `comparator == null` is always true.


### Extra Challenge

__Problem 6: Estimate running time__

You need to find 1000 most expensive items from an unsorted price list containing $10^7$ different items. Two schemes of solution are as follows.
- Scheme A: repeat 1000 times the sequential search (with the linear complexity O(n) ).
- Scheme B: convert the list into an array (the complexity O(n) ), then sort the array (complexity O(nlogn)) and fetch 1000 top items.

Which scheme is faster?

You run some preliminary experiments  and determined that:
- searching in an unsorted array of 100 items takes on average 0.1 millisecond (ms)
- creating an array out of 100 items takes on average 0.1 millisecond (ms)
- sorting of 100 items takes on average 0.2 millisecond (ms)
time for fetching data from the consecutive indexes of the array is so small that it can be ignored

Explain how you can use that information to estimate the actual running time expected by each of the two schemes and determine which of the two schemes is faster.

__Problem 6__

You are given two string consisting of characters a-z (any order and any number). Find and list all characters that occur in both strings.

You need to write an algorithm for solving the problem. You do not need to specify the code for the solution, but be very specific in your description of the algorithm.

__Problem 7__

Given a string, sort the characters in decreasing order based on their frequency.

Example:
<br>Input:  "tree"
<br>Output: "eert"
<br>Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Challenge: create O(N) algorithm where N is the number of characters in the string.

You need to write an algorithm for solving the problem. You do not need to specify the code for the solution, but be very specific in your description of the algorithm.


</main>


<script src="https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-AMS_HTML&delayStartupUntil=configured" type="text/javascript"></script>
<script type="text/javascript">
  // var slideshow = remark.create();

  // Setup MathJax
  MathJax.Hub.Config({
      tex2jax: {
      skipTags: ['script', 'noscript', 'style', 'textarea', 'pre'],
        inlineMath: [ ['$','$'], ["\\(","\\)"] ],
        displayMath: [ ['$$','$$'], ["\\[","\\]"] ],
        processEscapes: true
      }
  });

  MathJax.Hub.Configured();
</script>
