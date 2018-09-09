
<div class="recitation">
<div class="column_date">
<p markdown="block">
Recitation  <br>
Tue, 9/11 (sec. 6 and 9)<br>
Thu, 9/13 (sec. 10)
</p>
</div>

<div class="column_recitation">
<p markdown="block">

-


__Writing bullet-proof code activity.__ - distributed during the recitation.

<!--
__Writing bullet-proof code:__ [instructions](https://goo.gl/RCKoS1) ,
[worksheet](https://goo.gl/BzgFso)
-->

__Extra credit__ (due ):

(This should be done individually, not as a group activity.)

Last week you worked on solving several problems and using the CodeBat
autograder/autotester to verify if your solution was correct.
In more realistic situations, there is no such tester. The programmer needs to
be able to convince themselves that their work is correct. <br>
This semester we will be using an autograder on Gradescope to give your hints about
your program's correctness. At first, you will see all of the tests and see if they
passed or not. As the semester progresses, you will not be given the individual tests
anymore. <br>
As a practice for this, there is an exercise on Gradescope with 20 test cases,
but you will not see the tests themselves. Each test is worth 0.05 points, so this
can give you a hint as to how many tests passed and how many failed.

The problem for which you need to write a solution is as follows:

Write a function, that f]given a string, returns the sum of the numbers appearing
in the string, ignoring all other characters. A number is a series of 1 or more digit
chars in a row. (Note: `Character.isDigit(char)` tests if a char is one of the chars
'0', '1', .. '9'. `Integer.parseInt(string)` converts a string to an int.)

`sumOfNumbers("abc123xyz")` should return `123`<br>
`sumNumbers("aa11b33")` should return `44` <br>
`sumNumbers("7 11")` should return `18`<br>
`sumNumbers("hello")` should return `0`<br>

You should implement your code in the following template:


- [SumOfNumbers.java](hwk/SumOfNumbers.java)



</p>
</div>

</div>
