---
layout: lab
title: Project 4
---

<div class="lab-right" markdown="1">
__Project 4__ <br>
__due date:__  November 17

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 4: Climate Change, Rising Waters 

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other forum). You should not use code generation tools to create any part of the implementation for this project. 
If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and features of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.

If your submitted code matches closely or exactly code submitted by another person in the class, it will get a zero grade and the offense will be reported to the department and the dean. 
</div>

---
<br/><br/>
### Introduction and objectives

Sea levels have been rising globally. Natural disasters cause the waters to rise at smaller scale 
and for shorter amounts of time. Urban planners for future cities and development as well as governments 
and citizens of existing cities need to know which areas are at risk of being flooded when the water level
increases. 
You are going to write a program that uses your new expertise in graph algorithms 
to evaluate what happens to a given terrain when the waters are rising. 

<br/><br/>


The goal of this programming project is for you to master (or at least get practice on) the following tasks:

- developing and writing recursive algorithms,
- developing and writing algorithms that use queues,
- implementing graph algorithms, 
- working with implicit graph representation,  
- working with existing code,
- using command line arguments,
- implementing classes according to provided specification.


**Start early!** This project may not seem like much coding, but debugging and testing always takes time, especially for recursive algorithms.


<div class="wrap-collabsible">
<input id="background" class="toggle" type="checkbox"   checked=true   >
<label for="background" class="lbl-toggle"> Background</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You are going to develop a tool that models flooding
due to the water levels rising. 

To do this we will model an actual terrain with a two dimensional grid. 
Each value in the grid represents the elevation of that grid point: higher values indicate higher elevations, 
lower values indicate lower elevations. The elevation values are floating point numbers, think `double`. 

Take a look at the following three grid examples (for 
easy of reading we are just using integers to represent
elevations): 

```
Grid 1
  0  1  2  3  4  2  1
  1  2  3  4  5  4  2
  3  4  5  6  6  5  4
  2  4  5  7  5  3  2
  1  2  4  5  3  2  1
  0  1  2  3  1  1  1
  0  0  1  2  1  1  1
```

```
Grid 2
 -1  0  0  4  0  0  1 
  0  0  4  0  0 -1  0
  0  4  0  0 -1 -1  0
  4  0  0  0  0 -1  0
  0 -1 -1  0  0  0  3
  0  0 -1  0  0  3  0
  0  0 -1  0  3  1  0  
```

```
Grid 3
  0  1  2  3  4  5  6
  0  1  2  3  4  5  5
  0  1  2  3  4  4  4
  0  0  1  2  3  3  3
  0  0  0  1  2  2  2
 -1  0  0  0  1  1  1
 -1 -1  0  0  0  0  0
 -2 -1 -1 -1  0  0  0
```


Before you continue, take a look at those three grids above and 
try to identify what kind of terrain they represent: a hill? a slope? a mountain? a lowland surrounded by protective barriers? a valley? 

To model the water flow we need to also decide on the water source. A deep valley far inland is not likely to be flooded even if the sea levels rise above its level. But if there is a river flowing through that valley and the river's water rise, then the valley will get flooded. So we need to know where on the grid the water is coming from. 

Let's consider three different water levels for the above grids. We will assume that the source of water is at the upper left corner of the grid (grid point `{ 0, 0 }`). 

<table>

<tr>
<th></th>
<th>grid 1 </th>
<th>grid 2 </th>
<th>grid 3 </th>
</tr>
<tr>
<td>water level at 0 </td>
<td><img src="img/grid1_1s_0w.txt.png" width="200px" width="200px" /> </td>
<td><img src="img/grid2_1s_0w.txt.png" width="200px" /> </td>
<td><img src="img/grid3_1s_0w.txt.png" width="200px" /> </td>
</tr>
<tr>
<td>water level at 1 </td>
<td><img src="img/grid1_1s_1w.txt.png" width="200px" /> </td>
<td><img src="img/grid2_1s_1w.txt.png" width="200px" /> </td>
<td><img src="img/grid3_1s_1w.txt.png" width="200px" /> </td>
</tr>
<tr>
<td>water level at 2 </td>
<td><img src="img/grid1_1s_2w.txt.png" width="200px" /> </td>
<td><img src="img/grid2_1s_2w.txt.png" width="200px" /> </td>
<td><img src="img/grid3_1s_2w.txt.png" width="200px" /> </td>
</tr>

</table>

The areas that are flooded are marked with a shaded block. In each grid, the water level increases, the area that is flooded increases as well. In case of grid 2, the flooded area does not change, since the water is stopped by high terrain. The water level would need to go up to 4 for that high terrain (and the rest of the terrain on the map) to be flooded. 

It is also possible that the grid has multiple water sources. Places like New York City that are surrounded by water on multiple sides are a good example here. 

The next example uses the same grid and water levels as before, but with two water sources:
one in the upper left corner and one at the lower right corner. You can see that the resulting 
maps are different for grids 1 and 2. 

<table>

<tr>
<th></th>
<th>grid 1 </th>
<th>grid 2 </th>
<th>grid 3 </th>
</tr>
<tr>
<td>water level at 0 </td>
<td><img src="img/grid1_2s_0w.txt.png" width="200px" /> </td>
<td><img src="img/grid2_2s_0w.txt.png" width="200px" /> </td>
<td><img src="img/grid3_2s_0w.txt.png" width="200px" /> </td>
</tr>
<tr>
<td>water level at 1 </td>
<td><img src="img/grid1_2s_1w.txt.png" width="200px" /> </td>
<td><img src="img/grid2_2s_1w.txt.png" width="200px" /> </td>
<td><img src="img/grid3_2s_1w.txt.png" width="200px" /> </td>
</tr>
<tr>
<td>water level at 2 </td>
<td><img src="img/grid1_2s_2w.txt.png" width="200px" /> </td>
<td><img src="img/grid2_2s_2w.txt.png" width="200px" /> </td>
<td><img src="img/grid3_2s_2w.txt.png" width="200px" /> </td>
</tr>

</table>


</div> </div></div>


<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox" checked=true >
<label for="usage" class="lbl-toggle"> Program Usage and Format of the Input File </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The part of the program that handles command line arguments is written for you. 

The program expects three command line arguments. 

The first one is the name of the input file that contains 
description of the grid, water sources and the height
of the water to simulate.  

The second one is used to determine which algorithm should be used to simulate the rising waters. The possible values are `bfs` and `dfs`. 

The third command line argument indicates if the program
should display visualization as the simulation progresses. (More on that later.) The possible values are `true` or `false` (or really, anything other than `true` is treated as `false`). 
<br>

The format of the input file is as follows. If you wish to create your own input files (and you should)
make sure to follow this format exactly:

- line 1 contains the water height for the simulation 
- line 2 contains the number of water sources
- line 3 and 4 contain row and column numbers for the first water source 
- ... the above repeats as many times as there are water sources
- next line contains the number of rows in the terrain map
- next line contains the number of columns in the terrain map
- all remaining lines contain the actual map: there are as many lines as the number 
of rows, and each line contains space separated floating point numbers (there are 
as many of them as the number of columns)

For example, the file that contains the following:

```
2
1
0
0
7
7
0 1 2 3 4 2 1
1 2 3 4 5 4 2
3 4 5 6 6 5 4
2 4 5 7 5 3 2
1 2 4 5 3 2 1
0 1 2 3 1 1 1
0 0 1 2 1 1 1
```

Has 
- the water level reaching 2 feet (first line), 
- one water source at grid point { 0, 0 } (lines 2 to 4)
- the terrain map that is 7 by 7 grid point (lines 5 to 13)

Here are couple of sample input files that model two different terrains with their own water sources:
- [world 1](project4_flood/world1.in)
- [world 2](project4_flood/world2.in)


</div> </div></div>




<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox" checked="true">
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You should start by downloading the files for each class listed below. 
They are all part of the `project4` package, so make sure to setup your environment
accordingly. 
For some of the classes, you will need to provide implementation 
of some of the methods. Other classes are completely implemented for you. 
The first step is to read through the existing code, so you know what is what and how to use the existing code to complete the parts 
that you need to work on. 


#### <code class="code_title">NotOnMapException</code> class 

Class documentation: [`NotOnMapException` documentation](project4_flood/project4/NotOnMapException.html)

Source code: [`NotOnMapException.java`](project4_flood/project4/NotOnMapException.java)

You should not make any changes to this file. 


#### <code class="code_title">GridPoint</code> class 

Class documentation: [`GridPoint` documentation](project4_flood/project4/GridPoint.html)

Source code: [`GridPoint.java`](project4_flood/project4/GridPoint.java)

You should not make any changes to this file. 



#### <code class="code_title">Map</code> class 

Class documentation: [`Map` documentation](project4_flood/project4/Map.html)

Source code: [`Map.java`](project4_flood/project4/Map.java)

You need to implement the missing methods in this class. Each method that you 
need to complete contains the comment:

```
// TODO: implement this method
```

Make sure to remove these lines, once the code is complete. 



#### <code class="code_title">Simulation</code> class 

Class documentation: [`Simulation` documentation](project4_flood/project4/Simulation.html)

Source code: [`Simulation.java`](project4_flood/project4/Simulation.java)

You need to implement the missing methods in this class. Each method that you 
need to complete contains the comment:

```
// TODO: implement this method
```

Make sure to remove these lines, once the code is complete. 

You should not modify any other methods in this class, but you may 
create additional methods if you wish. (They will most likely need to be private methods.)

You need to implement two different ways of simulating the flooding 
process: one using recursive DSF, and the other using iterative BFS. Both of these 
algorithms will implement search for the connected component that starts at a given water source. The map
given in the input file serves as an implicit graph representation: two grid points are connected if they share 
a side in the map. Additionally, in the connected component that your algorithm should discover all the elevation values 
are at or below the water level specified in the input file. 

The starting point for each algorithm is the same: the map of the 
elevations for the world. The end point for each algorithm is also the same:
the map of the world with some of the areas flooded based on the water level. 
If one of your algorithms produces a different result than the other, you know 
that there is a problem. 

In order to add __visualization__ to your implementation of the algorihtms, the 
code should make the call to `visualize()` method after each step. The _step_ can be defined 
as simply each time  new grid point is marked as flooded.
You code should call the function only if the boolean flag passed to the 
algorithm is true. 



</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"   checked=true >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102/notes/CodeConventions.pdf)


</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- Make sure that at all times you __have a working program!__
You should also implement stubs of methods that return `0` or `null`. This way your code compiles, even though it may
not work completely.  You can implement methods that perform one task at a time.
This way, if you run out of time, at least parts of your program will be functioning properly.
- You should make sure that you are __testing the program__ : you should create your own grid descriptions and experiment with different shapes of the grids, different locations of water sources, etc.  <br>
__DO NOT__ limit your testing to just the example grids above. They do not cover all possible scenarios. 

- You should __backup__ your code after each time you spend some time working on it.
Save it to a flash drive, email it to yourself, upload it to your Google drive, push it to a private git repository,
do anything that gives you a second (or maybe third copy). Computers tend to break just a few days or even
a few hours before the due dates - make sure that you have working code if that happens.

</div> </div></div>

<div class="wrap-collabsible">
<input id="grading" class="toggle" type="checkbox"  >
<label for="grading" class="lbl-toggle"> Grading </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>



If your program does not compile or if it crashes (almost) every time it is run,
you will get a zero on the assignment. Make sure that you are submitting
functioning code, even if it is not a complete implementation so that you can get partial credit.


The grade will be determined by several factors:
- 60 points: class correctness: correct behavior of methods of the required classes (this will be determined by the autograder), these points will be assigned as follows:
	- 0 points: code passes fewer than a half of the autograder tests 
	- 30 points: code passes [50-70)% of the autograder tests 
	- 36 points: the code passes [70-80)% of the autograder tests
	- 44 points: the code passes [80-90)% of the autograder tests 
	- 52 points: the code passes [90-95)% of the autograder tests 
	- 60 points: the code passes 95% or more of the autograder tests 
- 20 points: design and the implementation of your code
- 10 points: efficient implementation of the required methods
   (this will be determined by a code review). Efficient design avoids recomputing the same results multiple times. 
It also means that the algorithms do not consider unnecessary location while exploring the map of grid points. 
- 10 points: proper documentation, program style and format of submission (this will be determined by a code review)

Note that if you do not implement a particular algorithm according to the specification (for example, your recursive algorithm is not recursive), all the correctness points will be subtracted for that part of the program. 

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox"  checked=true>
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


__For the purpose of grading, your project must be be in the package called `project4`.
This means that each of your submitted source code files should start with a line:__

`package project4;`


Your should submit all your source code files (the ones with `.java` extensions only) to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. Do not submit the data
file or any data files that you might have created. 
Once you submit, you should look at all the files that Gradescope has - make sure there is nothing there that should not be there. 

You may resubmit to Gradescope as many times as you wish before the submission link closes. But if you resubmit
after the grace period ends, your assignment will be subject to the late point deductions.

For this project, you will see some of the results for the autograded unit tests. Some of the results will be hidden. (When some results are hidden, Gradescope does not display the score for the autograded part. )





</div> </div></div>




<div class="wrap-collabsible">
<input id="appendix" class="toggle" type="checkbox"   checked=true>
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

#### Sample Program Runs

Here are sample program runs for the two input files listed before when run using each of the two algorithms.

<br>
[world 1](project4_flood/world1.in) with DFS algorithm for finding connected components 

<video width="640" height="300" controls>
  <source src="project4_flood/world1_dfs.webm" type="video/webm">
  Your browser does not support the video tag.
</video>


<br>
[world 1](project4_flood/world1.in) with BFS algorithm for finding connected components 

<video width="640" height="300" controls>
  <source src="project4_flood/world1_bfs.webm" type="video/webm">
  Your browser does not support the video tag.
</video>


<br>
[world 2](project4_flood/world2.in) with DFS algorithm for finding connected components 

<video width="640" height="600" controls>
  <source src="project4_flood/world2_dfs.webm" type="video/webm">
  Your browser does not support the video tag.
</video>


<br>
[world 2](project4_flood/world2.in) with DFS algorithm for finding connected components 

<video width="640" height="600" controls>
  <source src="project4_flood/world2_bfs.webm" type="video/webm">
  Your browser does not support the video tag.
</video>



</div> </div></div>

</main>
