---
layout: lab
title: Project 6
---

<div class="lab-right" markdown="1">
__Project 6__ <br>
__due date:__ December 12

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 6: Code Reading with `AVLTree` and `PriorityQueue`

<hr>

<div class="emph" markdown=1>
You may discuss the code for this project with anybody in the class and in the world.
You may not discuss the questions that are part of the quiz on NYU Classes. You may not post or share those questions in any way.
</div>

---


<br/><br/>
### Introduction

Familiarize yourself with the code and documentation pages listed below.
Once you feel confident that you understand the code, you should answer the questions about it on NYU Classes.

As with Project 1
- You will have three submissions and the highest score for a submission made prior to the due date will count towards your project grade. __There is no 5hr grace period for this project.__ The due date is 11:59pm (US, Eastern Time) on December 12.
- You will have 1 hour to answer 15 questions. The questions are drawn randomly from a larger pool, so you should not expect to see
the same questions on multiple attempts.
- You will see your score after each submission, but you will not have the information as to which answers were correct and which were wrong.

### Code and documentation you need to read

__AVL Tree__

The [AVLTree-Project6](https://us.edstem.org/courses/2361/workspaces/p0r5fmuYfyfak26S41E2ZC3hKJwdgCj1) workspace contains a very simple
implementation of an AVL tree.  It also contains two different comparator classes.

You should be able to understand and answer questions about how these classes work.


__Priority Queue__

You should look at the documentation and source code for the
[`PriorityQueue<E>` class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/PriorityQueue.html). If you no longer have the source code for the built-in Java classes, you can download the zip file from
[Java source code](https://cs.nyu.edu/~joannakl/cs102_f20/code/java.base.zip). You should be using Java 11 version of the code and documentation.

You do not need to look at
- split iterator (`PriorityQueueSpliterator` class and `spliterator()` )
- details of the implementation of the inner class `Itr`
- `bulkRemove`, `forEach`, `readObject`, `removeAll`, `removeAt`, `removeEq`, `removeIf`, `retainAll`, `writeObject` methods
- a tiny bit set implementation

You should be able to understand all other parts of the implementation.


### Working on This Assignment

- Start reading the code right away so that you have a chance to ask questions if there are things you do not understand.
- Work with the give code. Write small programs that use these classes. 
- Do not attempt to answer the questions on NYU Classes unless you understand the code and have enough time to complete the quiz (1 hr).
- Make sure you make your first attempt at the quiz on NYU Classes at least a couple of days before the due date,
so that you can revisit the code and retake it, if need be. Making the three submissions on the evening of the due date
is not an effective way of maximizing the score.





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
