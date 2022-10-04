---
layout: lab
title: Project 2
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__due date:__ October 20 at 11:59pm.

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 2: Trees on NYC Streets

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other public or private forum). If you get significant help from anyone or anything, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and concepts of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.
</div>

---

<br/><br/>
### Introduction and objectives



<a title="Silver Linden in front of 38 East 8th Street" href="https://tree-map.nycgovparks.org/tree-map/tree/4612695"><img width="600" alt="Silver Linden in front of 38 East 8th Street" src="img/NYCStreetTrees.png" style="float:right; margin:10px"></a>



In this project you will be working with open data. Wikipedia has a good description of open data: "Open data is the idea that some data
should be freely available to everyone to use and republish as they wish, without restrictions from copyright, patents or other mechanisms of control."

You will be working with a specific data set from the <a href="https://www.nycgovparks.org/trees/treescount">New York City Department of Parks</a>: The 2015 Street Tree Census was conducted by volunteers and staff organized by NYC Parks & Recreation and partner organizations. Tree data collected includes tree species, diameter and perception of health. Your project will provide a way for the user
to interact with this data set (or its subset, or a dataset similar to it).

<br/><br/>

The goal of this programming project is for you to master (or at least
get practice on) the following tasks:

- working with multi-file programs
- reading data from input files
- using and understanding command line arguments
- working with large data sets
- using and implementing different types of list data structure
- writing classes
- working with existing code
- extending existing classes (inheritance)
- parsing data
- working with exception handling

Many of the skills that you need to complete this project
are based on the material covered in cs101. But there might be certain
topics for which you did not have to write a program or that you forgot.
Make sure to ask questions during recitations, in class and on Ed.

**Start early!** This project requires you to write several classes and
debugging always takes time even if you are the most confident and skilled programmer.



<div class="wrap-collabsible">
<input id="2015 Street Tree Census" class="toggle" type="checkbox"  checked=true >
<label for="2015 Street Tree Census" class="lbl-toggle">2015 Street Tree Census</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program should work with a local copy of a file whose format matches that of the file that you can download from
the website. This file is a comma separated values (CSV) file. CSV files are just text files. Your program can open them and read them as simple text.
Each line in a CSV file constitutes a data point (well, except for the heading line). The _columns_ in each entry are separated by commas (hence the name of the file format).

Here is an example row for the Littleleaf Linden tree at 36 East 8th Street (pictured above):
```

30371,101746,06/22/2015,7,0,OnCurb,Alive,Good,Tilia cordata,littleleaf linden,None,None,NoDamage,Volunteer,Stones,Yes,No,No,No,No,No,No,No,No,36 EAST 8 STREET,10003,New York,102,1,Manhattan,1,66,27,MN23,West Village,1005900,New York,40.731287,-73.99424612,985844.6917,205704.1999,1,59,1008834,1005480012

```
(Note that due to the length of the line, the last columns may not be visible in the above display.)

<br/>

The data set that you need can be found at the <a href="https://data.cityofnewyork.us/Environment/2015-Street-Tree-Census-Tree-Data/uvpi-gqnh" alt="NYC OpenData website" target="_blank">NYC OpenData website</a>. For your convenience, you can also download the `CSV` file provided with this project. There are several different data formats available on NYC OpenData site. Your program has to work with the `CSV` format of the data.

<br/>

The real data files are not perfect. You may discover that some rows are missing some values. Other rows ma
contain invalid values in columns. For the purpose of this project, any row that contains
the tree id and common species name is a valid row. Any rows that are missing either of these
two values should be silently ignored by the program. Any other column values could be empty. For example this
is a valid row:

```

30371,,,,,,,,Tilia cordata,littleleaf linden,,,,,,,,,,,,,,,36 EAST 8 STREET,,New York,,,,,,,,,,,,,,,,,

```

</div> </div></div>


<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox" checked=true  >
<label for="interface" class="lbl-toggle"> User Interface </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program has to be a console based program (no graphical interface) - this
means that the program should not open any windows or dialog boxes to prompt user
for the input. (Use the `Scanner` class to read the user input.)

__Warning__ You should have a single `Scanner` object to read in data from the user. If you use more than one, your program is not going to work correctly in all situations (including when executed in the autograder).

</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox"  checked=true   >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is started from the command line (or run within an IDE). It expects one command line argument.

This program should use command line arguments. When the user runs the program, they provide the name of the input
file as a command line argument. (This way the user can specify a different data set - for example data sets from different census years, or a partial data set that may include only a subset of row entries.)

If the name of the input file provided as a command line argument is incorrect or the file cannot be
opened for any reason, the program should display an error message and terminate. It should not prompt the user for
an alternative name of the file.

If the program is run without any arguments, the program should display an error message and terminate. It should not prompt the user for the name of the file.

The error messages should be specific and informative, for example:

`    Error: the file census2015.csv cannot be opened.`

or

`    Usage Error: the program expects file name as an argument.`

The above error messages generated by your code should be written to the `System.err` stream (not the
`System.out` stream). If you are not sure what the difference is, research it or ask questions.

</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"  checked=true   >
<label for="user" class="lbl-toggle"> User Interaction </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The program should run in a loop that allows the user to check popularity of different trees
on streets os different New York City boroughs.

On each iteration, the user should be prompted to enter a new query (for which
the program computes the results) or the word 'quit'  (any case of letters should work)
to indicate the termination of the program.

__The user should not be prompted for any other response.__

A valid query consists of a string (possibly with spaces) that should be matched by
the program against the names of trees in the input file. Both Latin names and common names should be included in the search (they are in separate columns in the data set).
By _match_ we mean that the name entered by the user is a substring of an actual species name
(Latin or common). This match should be case insensitive.

In response to a valid query for which at least one match is found, the program should print the list of all the different species matching the name (without repeats in alphabetical order) and then print the information regarding
the counts of all trees with those species names for the entire NYC and for each borough individually. For example:

```
Enter the tree species to learn more about it ("quit" to stop):
linden
All matching species:
  american linden
  littleleaf linden
  silver linden

Popularity in the city:
  NYC:           51,267(683,788)    7.50%
  Manhattan:       5,457(65,423)    8.34%
  Bronx:           6,719(85,203)    7.89%
  Brooklyn:      15,299(177,293)    8.63%
  Queens:        20,817(250,551)    8.31%
  Staten Island:  2,975(105,318)    2.82%

Enter the tree species to learn more about it ("quit" to stop):
quit
```

For each location:
- the first value is the total number of the three different types of linden trees in that borough;
- the number in parenthesis is the total number of trees in that borough;
- the last column contains the percentage calculated as the
total number of lindens divided by the total number of trees times 100.

The program has to produce the output formatted in aligned columns, with commas grouping the tree digits in larger numbers and with two digits
after the decimal point in the last column. This is a perfect place to use `String.format()` or `System.out.printf()` functions. If you never used either of these functions, make sure to
ask about them to avoid doing extra work.


If the name entered by the user cannot be matched to any tree in the list of trees stored in the dataset, the program should print
a message

`   Tere are no records of TREE_NAME on NYC streets `

(in which `TREE_NAME` is replaced by the name that the user entered) and continue into the next iteration.

<br/>

All output from the user interaction should be printed to the standard output stream (`System.out`), even the above error messages.

<br/>

__More sample user interactions are shown in the Appendix.__


</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked=true >
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>




Your need to provide an implementation of several classes that store the data and
compute the results when the program is executed.

In particular, your program must implement and use the following classes.
You may implement additional classes and additional methods in the required classes, if you wish.

__As you are working on your classes, keep in mind that they should be (and will be) tested separately from the rest of your program.__



#### <code class="code_title">TreeSpecies</code> class

This class should represent a single tree species that has both the common name and the Latin name of the species.

The class should provide a two parameter constructor

`    public TreeSpecies ( String commonName, String latinName)`

Both names are, possibly empty, strings. They cannot be `null`. If this constructor is called with a `null` argument, it should throw and instance
of `IllegalArgumentException` with an appropriate error message.

<br/>
The class should override the `equals` method. Two `TreeSpecies` objects
are equal if both the names are the same. The comparison should be case insensitive.


#### <code class="code_title">Tree</code> class

The `Tree` class stores information about a particular tree that grows in New York City. The class should store only
a subset of the entries from the input file, namely:

- tree_id as a non-negative integer
- status as a string, valid values: "Alive", "Dead", "Stump", or empty string or `null`
- health as a string, valid values: "Good", "Fair", "Poor", or empty string or `null`
- spc_latin (Latin name) as a, possibly empty, string, cannot be `null`
- spc_common (common name) as a, possibly empty, string, cannot be `null`
- zipcode as a positive five digit integer (This means that any number from 0 to 99999 is acceptable. The values that are shorter should be
 treated as if they had leading zeroes, i.e., 8608 represents zipcode 08608, 98 represents zip code 00098, etc.)
- boroname as a string, valid values: "Manhattan", "Bronx", "Brooklyn", "Queens", "Staten Island"
- x_sp as a double
- y_sp as a double


All of the string data fields should be case insensitive - i.e., "Alive", "alive", "ALIVE" and "aLIVe" are all valid values
for the status data field.

Note that some of these data fields may not be needed in this project, but the code has to provide them and
the data for them has to be stored.

<br/>

This class should provide a two parameter constructor:

`    public Tree (int treeID, TreeSpecies species ) `

The `treeID` should be a non-negative integer and the `species` should not be `null`.
If the constructor is called with invalid arguments, then an instance of `IllegalArgumentException` should be thrown
carrying an appropriate error message.

There should be no default constructor. (A default constructor is one that can be used without passing any arguments.)

<br/>

The class should provide getters and setters for all other required
data fields. The parameters for all setters should be validated according to the
rules specified above. If a setter is called with invalid arguments, then an instance of `IllegalArgumentException` should be thrown
carrying an appropriate error message.

<br/>

This class should override the `equals` methods (see the documentation for the `Object` class for details).
The two `Tree` objects should be considered equal if their id's and both, Latin and common, species names are the same. The other values should not be considered in the equality. The name comparison should be case insensitive.

<br/>

This class should implement `Comparable<Tree>` interface.
The comparison should be done by the common species name as the primary key (using alphabetical order), and by the tree id
as the secondary key (i.e., when two objects that have the same species name are compared, the comparison should be performed by  the id).
The comparison method should be case insensitive (i.e., two `Tree` objects with the species name stored as "Baldcypress" and "BaldCypress"
should be compared by their id's since their names are the same).

<br/>

The class should override the `toString` method. The details are up to you, but you should make sure that it returns a `String` object
that is a meaningful representation of the object on which it is called.

#### <code class="code_title">TreeSpeciesList</code> class

The `TreeSpeciesList` class should be used to store all the unique `TreeSpecies` objects.
This class should inherit from the `ArrayList<TreeSpecies>` class. (Some of you may realize that a `HashTable` would probably be a better choice here. For the purpose
of this project, you should NOT use the `HashTable` or any other hashing data structure).
<br/>

The class needs to provide a default constructor that creates an empty `TreeSpeciesList` object.

<br/>
In addition, the class should implement the following methods:

- `public TreeSpeciesList getByCommonName (String keyword)`
returns a list of species whose common name contains `keyword` as a substring.
The method should be case insensitive. It should throw and instance of `IllegalArgumentException` exception if called with `null` argument. It should
return `null` if there are no `TreeSpecies` objects matching the `keyword`.


- `public TreeSpeciesList getByLatinName (String keyword)`
returns a list of species whose Latin name contains `keyword` as a substring.
The method should be case insensitive. It should throw and instance of `IllegalArgumentException` exception if called with `null` argument. It should
return `null` if there are no `TreeSpecies` objects matching the `keyword`.



#### <code class="code_title">TreeList</code> class

The `TreeList` class should be used to store all the `Tree` objects.

This class should be a simple version of a linked list. By _simple_ we mean that
you do not need to provide all the methods to make it a linked list, but
the connectivity between elements should be done based on the linked list structure.
(This is not a generic class. You will need to have an internal `Node` class
that stores a `Tree` object as data and a reference to the next node. You will need to keep track of the `head` and, possibly `tail` references. )

The class needs to provide the default constructor that creates an empty list.

`    public TreeList ( ) `

The class should implement
- `    public void add(Tree tree)`
  method that adds a given `tree` object to the current list; this method should
throw an instance of `IllegalArgumentException` if the specified reference is `null`
- `    public int getTotalNumberOfTrees()`
  method that returns the total number of `Tree` objects stored in this list.
- `    public int getCountByCommonName ( String speciesName ) `
  method that returns the number of `Tree`  objects in the list whose common name is the same as the given `speciesName`.
  This method should be case insensitive. If the method is called with a non-existent species, the return value should be 0.
- `    public int getCountByLatinName ( String speciesName ) `
  method that returns the number of `Tree`  objects in the list whose Latin name is the same as the given `speciesName`.
  This method should be case insensitive. If the method is called with a non-existent species, the return value should be 0.
- `    public int getCountByBorough ( String boroName ) `
  method that returns the number of `Tree` objects in the list that are located in the borough equal to `boroName`. This method should be case insensitive.
  If the method is called with a non-existent borough name, the return value should be 0.
- `    public int getCountByCommonNameBorough ( String speciesName, String boroName ) `
  method that returns the number of `Tree` objects in the list whose common name is the same as the given `speciesName` and  which are located in the borough `boroName`. This method should be case insensitive.
  If the method is called with a non-existent borough name or species, the return value should be 0.
- `    public int getCountByLatinNameBorough ( String speciesName, String boroName ) `
  method that returns the number of `Tree` objects in the list whose Latin name is the same as the given `speciesName` and  which are located in the borough `boroName`. This method should be case insensitive.
  If the method is called with a non-existent borough name or species, the return value should be 0.

<br/>

The class should override the `toString` method. The details are up to you, but you should make sure that it returns a `String` object
that is a meaningful representation of the object on which it is called (it may or may not contain the listing of all of the elements).


#### <code class="code_title">NYCStreetTrees </code> class
The `NYCStreetTrees` class is the actual program. This is the class that should contain the `main` method.
It is responsible for opening and reading
the data file, obtaining user input, performing some data validation and handling
all errors that may occur, and printing all output to the standard output stream. It should handle any
exceptions thrown by your other classes and terminate gracefully, if need be, with
a friendly error message presented to the user: The program should never just reprint the
exception message as a way of handling an exception. These messages are rarely
readable to the ordinary user and make it seem like the program crashed in response to the exception.

You may (and probably should) implement other methods in this class to modularize the design.




</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox" checked=true >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_f22/notes/CodeConventions.pdf).

- The data file should be read only once! Your program needs to store the data
in memory resident data structures.

- You may not use any of the collection
classes that were not covered in cs101 (for this assignment, do not use `LinkedList`, `Stack`, `Queue`, `PriorityQueue`, or any classes implementing the `Map` interface). You can, and should, use the `ArrayList` class.

- You may use any exception-related classes.

- You may use any classes to handle the file I/O, but probably the simplest ones
are `File` and `Scanner` classes. You are responsible for knowing how to use the classes that you select.

</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"   checked=true>
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly: for example, implement the part of the code that reads and parses the input file, then implement and test individual classes, then implement the part that provides the interactive part of the program, ... .
- Make sure that at all times you __have a working program!__
You should also implement stubs of methods that return `0` or `null`. This way your code compiles, even though it may
not work completely.  You can implement methods that perform one task at a time.
This way, if you run out of time, at least parts of your program will be functioning properly.
- You should make sure that you are __testing the program on much smaller data set__ for which you can determine the correct
output manually. You can create  a test input file that contains only a few rows.
- You should make sure that your program's results are consistent with what is described in this specification
by running the program on carefully designed test inputs and examining
the outputs produced to make sure they are correct.
The goal in doing this is to try to find the mistakes you have most likely made in your code. <br>
<!--
__DO NOT__ test your program on the entire large input file. This may take a long time and you will never know
if the results are correct or not.
-->
- Each class that you submit __will be tested by itself without the context of other classes that you are implementing for this assignment__. <br>
This means that you need to make sure that your methods can perform their tasks correctly even if they are executed in situations that would not arise in the context of this specific program.
- You should __backup__ your code after each time you spend some time working on it.
Save it to a flash drive, email it to yourself, upload it to your Google drive, push it to a private git repository,
do anything that gives you a second (or maybe third copy). Computers tend to break just a few days or even
a few hours before the due dates - make sure that you have working code if that happens.

</div> </div></div>

<div class="wrap-collabsible">
<input id="grading" class="toggle" type="checkbox" checked=true >
<label for="grading" class="lbl-toggle"> Grading </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You have to follow Academic Integrity Rules.

If your program does not compile or if it crashes (almost) every time it is run,
you will get a zero on the assignment. Make sure that you are submitting
functioning and documented code, even if it is not a complete implementation so that you can get partial credit.

If the program does not adhere to the specification, the grade will be low and
will depend on how easy it is to figure out what the program is doing and how to work with it.

The grade will be determined by several factors:
- 60 points: class correctness: correct behavior of methods of the required classes and correct behavior of the program
	as a whole (this will be determined by the autograder and some manual evaluation)
- 20 points: design and the implementation of the required classes and any additional classes
   (this will be determined by a code review)
- 20 points: proper documentation, program style and format of submission
   (this will be determined by a code review)

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox" checked=true >
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

__For the purpose of grading, your project must be be in the package called `project2`.
This means that each of your submitted source code files should start with a line:__

`package project2;`


Your should submit all your source code files (the ones with `.java` extensions only) to Gradescope.
 __DO NOT__ submit `.class` files
or any project files that your IDE or operating system might produce. __You can see all the files on Gradescope.__
Verify that there is nothing there that you did not intend to put it. __DO NOT submit the data file.__

Gradescope accepts individual files and zip files.
You can produce a zip file directly from Eclipse (if this is what you are using):
 -  right click on the name of the package (inside the `src` folder) and select Export...
 -  under General pick Archive File and click Next
 -  in the window that opens select appropriate files and settings:
	 -  in the right pane pick ONLY the files that are actually part of the project,
		but make sure that you select all files that are needed
	 -  in the left pane, make sure that no other directories are selected
	 -  click Browse and navigate to a location that you can easily find on your system (Desktop or folder with the course materials or ...)
	 -  in Options select "Save in zip format", "Compress the contents of the file" and "Create only selected directories"
 -  click Finish

You may resubmit to Gradescope as many times as you wish before the submission link closes. But if you resubmit
after the grace period ends, your assignment will be subject to the late point deductions.

For this project, you will see ALL of the results for the autograded unit tests. This will not be
the case in future assignments.


</div> </div></div>


<div class="wrap-collabsible">
<input id="appendix" class="toggle" type="checkbox"  checked=true>
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

#### `CSV` class - Parsing Lines of the Input File

CSV is a simple file format, but there are many non-standard variations: the field separator, the field delimiter, the special characters allowed in the fields, etc.

You should use the `CSV` class provided below as is or you can modify it if you wish.

-   [`CSV`](project2/doc/project2/CSV.html) class documentation
-   [`CSV.java`](project2/CSV.java) file

If you are not sure how it works, ask questions about it.



#### Sample Interactions

Here are a few sample runs of a program (keep in mind, they are here to illustrate  the user interface, not
to show you examples of tests that the autograder will run on your program).


```
Enter the tree species to learn more about it ("quit" to stop):
oak
All matching species:
	black oak
	bur oak
	english oak
	northern red oak
	pin oak
	sawtooth oak
	scarlet oak
	schumard's oak
	shingle oak
	southern red oak
	swamp white oak
	white oak
	willow oak

Popularity in the city:
	NYC           :      82,867(683,788)   12.12%
	Manhattan     :        8,736(65,423)   13.35%
	Bronx         :       11,103(85,203)   13.03%
	Brooklyn      :      22,372(177,293)   12.62%
	Queens        :      30,571(250,551)   12.20%
	Staten Island :      10,085(105,318)    9.58%

Enter the tree species to learn more about it ("quit" to stop):
prunus
All matching species:
	prunus
	prunus cerasifera
	prunus serotina
	prunus virginiana

Popularity in the city:
	NYC           :      41,653(683,788)    6.09%
	Manhattan     :        1,174(65,423)    1.79%
	Bronx         :        5,505(85,203)    6.46%
	Brooklyn      :       8,364(177,293)    4.72%
	Queens        :      18,814(250,551)    7.51%
	Staten Island :       7,796(105,318)    7.40%

Enter the tree species to learn more about it ("quit" to stop):
car
All matching species:
	aesculus x carnea
	carpinus betulus
	carpinus caroliniana
	carpinus japonica
	carya glabra
	quercus imbricaria
	quercus macrocarpa
	scarlet oak

Popularity in the city:
	NYC           :       7,286(683,788)    1.07%
	Manhattan     :          628(65,423)    0.96%
	Bronx         :        1,396(85,203)    1.64%
	Brooklyn      :       2,178(177,293)    1.23%
	Queens        :       2,316(250,551)    0.92%
	Staten Island :         768(105,318)    0.73%

Enter the tree species to learn more about it ("quit" to stop):
american elm
All matching species:
	american elm

Popularity in the city:
	NYC           :       7,975(683,788)    1.17%
	Manhattan     :        1,698(65,423)    2.60%
	Bronx         :        1,471(85,203)    1.73%
	Brooklyn      :       2,587(177,293)    1.46%
	Queens        :       1,709(250,551)    0.68%
	Staten Island :         510(105,318)    0.48%

Enter the tree species to learn more about it ("quit" to stop):
frog

Tere are no records of frog on NYC streets

Enter the tree species to learn more about it ("quit" to stop):
quit


```


<br>
<br>
<br>


</div> </div></div>


</main>
