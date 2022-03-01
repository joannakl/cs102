---
layout: lab
title: Lab
---

<!--
<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
November 4
(whichever comes first)

__submission mode:__ group

</div>

<main markdown="1" class="lab">
-->

## Magic Of Recursion


### Introduction

Beginners often have trouble figuring out how exactly recursive functions work.
Today, you will be working with fairly short recursive functions and try to
investigate the magic of recursion. It is not really magic once you understand
how it works, but it is not a bad idea to think of it as magic at the
beginning - you can certainly do some pretty neat tricks with it.

The main idea of recursion is to solve a large problem by reducing it to smaller
and smaller version of it and then finally solving a trivial problem.

In the example below, the objective is to calculate factorial of a number,

$$ n! =
\begin{cases}
n \times (n-1)! & \mbox{if }  n > 0 \\
1 & \mbox{if }  n = 0
\end{cases}$$

The first person does not know the answer to $10!$ right away. But they do know how to
reduce the problem so that it is a bit smaller, $9!$. They also know how to use the solution
to the smaller problem to calculate the solution for the larger problem, $10\times 9!$.
Each person along the chain makes the problem smaller and smaller and smaller, until the final
person can answer the question directly without asking anybody else for help, $0!$.

<div style="text-align:center">

<br>
<br>
	<!-- Slideshow container -->
	<div class="slideshow-container" style="width:80%">

	 <!-- Full-width images with number and caption text -->
	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-15.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-14.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-13.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-12.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-11.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-10.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-9.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-8.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-7.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-6.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-5.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-4.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-3.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-2.jpg" style="width:100%">
	 </div>

	 <div class="mySlides fade">
	   <img src="{{ site.baseurl }}/slides/img/08/recursion-comic-1.jpg" style="width:100%">
	 </div>

	 <!-- Next and previous buttons -->
	 <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	 <a class="next" onclick="plusSlides(1)">&#10095;</a>
	</div>
	<br>

	<!-- The dots/circles -->
	<!--
	<span class="dot" onclick="currentSlide(1)"></span>
	<span class="dot" onclick="currentSlide(2)"></span>
	<span class="dot" onclick="currentSlide(3)"></span>
	-->

	<br>
	<br>
</div>


In a recursive function, we make the problem smaller by making a function call
to the recursive function with different arguments (such that those arguments make the
problem a little bit easier).

The question that is so simple that it does not need further recursive calls is called
the __base case__ - this is when we can give the answer directly.



Here is the same problem solved using a Java function:

{% highlight java linenos%}
//assume n >= 0
long factorial ( int n ) {
	if (n == 0)     //base case
	    return 1;
	else            //recursive case
	    return n * factorial(n-1);
}
{% endhighlight %}


<br>


### Part 1


You'll be working with the [CodingBat](http://codingbat.com/) exercises again.

Let's see if you can solve some of the problems related to recursion.

The website tests your code using many inputs. Try to write code solutions to the following problems.

1. Bunny Ears, [http://codingbat.com/prob/p183649](http://codingbat.com/prob/p183649)  - this is just a warm up exercise, you can see its solutions on the website.
2. PowerN, [http://codingbat.com/prob/p158888](http://codingbat.com/prob/p158888)
3. ChangeXY,  [http://codingbat.com/prob/p101372](http://codingbat.com/prob/p101372)
4. Pair *, [http://codingbat.com/prob/p158175](http://codingbat.com/prob/p158175)
5. Count 7, [http://codingbat.com/prob/p101409](http://codingbat.com/prob/p101409)
6. Count 8, [http://codingbat.com/prob/p192383](http://codingbat.com/prob/p192383)  - this is related to the above, but with an added twist.

There are many more problems in Recursion 1 section
([http://codingbat.com/java/Recursion-1](http://codingbat.com/java/Recursion-1)) - use them
for extra practice.


To get _progress and participation_ credit for this lab, take a screenshot of one or more of your submitted problems showing the test results and submit the screenshot(s) to Gradescope under Lab 6.



### Part 2

You can use [PythonTutor](http://www.pythontutor.com/) website to visualize code
execution in several different languages. (_Python_ in its name may be miss-leading.
It works with many programming languages.)

Follow the link to the two recursive functions on PythonTutor website: [https://goo.gl/Wfyp4C](https://goo.gl/Wfyp4C)
(it tends to be slow to start, so be patient; if it fails, just try again by
clicking Visualize Execution; if it says there are errors, just try it again).

Use the Forward button to execute the code one line at a time. You can also use
the Back button to go backwards (this is something that does not work in a debugger,
unfortunately, but for good reasons).

As you are stepping through the code, there are boxes that appear on the right
hand side. Those boxes symbolize the stack frames created for each function on
the program's stack as the program is running. They contain storage for all of
the local variables and  parameters. They also contain additional information
that allows the program to "jump" from one place in the code to the next.

Investigate the two functions listed in the example and answer the questions

1. How many stack frames are created to complete the execution of the call to `fun3`?
2. What value is returned by each recursive call to `fun3` (each call has its own stack frame)?
   List the value of the parameter  together with the return value.
3. What does `fun3` do?
4. In each stack frame, there is a number next to the name of the function
   (right after the colon). What does  this number represent?
5. Step through the execution of recursive calls of `fun4`.
   What does this function do? (answer the same questions as for `fun3`)





### Part 3

These are problems that should be solved recursively, but with slightly more
sophisticated recursion than in the first set of problems. Many of them require
recursive backtracking technique that we discussed in class.

Keep in mind that the main idea of recursion is to solve a large problem by reducing
it to smaller and smaller version of it and then finally solving a trivial problem.
Before writing code, spend some time thinking about what the simple cases are
(i.e., base case) and how to move from a large problem to a smaller problem
(recursive case).

Here are some problems that you should look at. Try to solve all of the problems.

1. Group Sum,  [https://codingbat.com/prob/p145416](https://codingbat.com/prob/p145416) - this
is just a warm up exercise, you can see its solutions on the website, but it is a good starting point.
2. Group Sum - No Adjacent, [https://codingbat.com/prob/p169605](https://codingbat.com/prob/p169605)
3. Group Sum - Clump, [https://codingbat.com/prob/p105136](https://codingbat.com/prob/p105136)
4. Split Array, [https://codingbat.com/prob/p185204](https://codingbat.com/prob/p185204)
5. Split Array - Odd 10, [https://codingbat.com/prob/p171660](https://codingbat.com/prob/p171660)

There are several more problems in Recursion 2 section
([https://codingbat.com/java/Recursion-2](https://codingbat.com/java/Recursion-2) ) - use
them for practice on your own.



<!--
</main>
-->

<script src="{{ site.baseurl }}/slides/js/image_slides.js"></script>




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
