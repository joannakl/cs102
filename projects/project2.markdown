---
layout: lab
title: Project 2
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__due date:__ March 4

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 2: Census 1900 - Immigrant Data

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other public or private forum). If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and Regions of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.
</div>

---

<br/><br/>
### Introduction and objectives



<a title="Census 1900 - Immigrant Data" href="https://www2.census.gov/library/publications/decennial/1900/volume-1/volume-1-p13.pdf"><img width="400" alt="Census 1900 - Immigrant Data, Ttitle Page" src="img/1900Census.png" style="float:right; margin:10px"></a>



In this project you will be working with open data. Wikipedia has a good description of open data: "Open data is the idea that some data
should be freely available to everyone to use and republish as they wish, without restrictions from copyright, patents or other mechanisms of control."

You will be working with a specific data set from the <a href="https://www.census.gov/">United States Census Bureau</a>. The data set selected for this project is from Table 33 of the Twelfth Census of the United States, completed in 1900. It provides information about country of birth for non-US born US residents at the time that the census was completed.

The original PDF version of this data can be found here, provided by the U.S. Census Bureau. In this project, you will be working with a transcription of the PDF that is provided in CSV (comma separated values) format. This transcription was made available by <a href="https://data.stacker.com/">Stacker</a> project. The file can be downloaded from their <a href="https://github.com/stacker-media/data/tree/main/1900-census-immigrant-state">GitHub repository</a>. (If you prefer, you also access a copy of the CSV file on Brightspace).

Your program will explore this data set and allow the user to make queries about it.
<br/><br/>

The goal of this programming project is for you to master (or at least
get practice on) the following tasks:

- working with multi-file programs
- reading data from input files
- using and understanding command line arguments
- working with large data sets
- using the `ArrayList` class
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
<input id="Census 1900 - Immigrant Data" class="toggle" type="checkbox"  checked=true >
<label for="Census 1900 - Immigrant Data" class="lbl-toggle"> Census 1900 - Immigrant Data</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program should work with a local copy of a file whose format matches that of the file that you can download from
the website. This file is a comma separated values (CSV) file. CSV files are just text files. Your program can open them and read them as simple text.
Each line in a CSV file constitutes a data point (well, except for heading lines and all the other description lines at the top). The _columns_ in each entry are separated by commas (hence the name of the file format).

Here is an example row for New York State:
```

New York,1900425,473,1744,461,706,78491,1787,16347,90336,27199,1016,6880,2195,8746,135685,286,4048,20008,480020,1573,9414,37168,408,425553,182248,302,75,353,12601,118,9696,19701,37317,2018,362,10549,165610,33862,1130,1614,42708,13678,1915,7304,4241,339,1001

```
(Note that due to the length of the line, the last columns may not be visible in the above display.)

<br/>

The README.md file in the <a href="https://github.com/stacker-media/data/tree/main/1900-census-immigrant-state">1900-census-immigrant-state repository</a> contains information about how the file is structured (i.e., what all the rows and columns represent).

__From the point of view of this assignment, a valid data row MUST contain 48 columns. All rows that do not have that many columns should be ignored. Note that the topmost row with 48 columns
is the header for all the rows that represent the actual data.__ You should not assume that the input file used for testing your program will have columns in exactly the same order. You also should not assume that the input file used for testing your program will contain on the US states and teritories (i.e., there could be fewer or more rows).

You can (and should, unless you have a good reason not to) use the `CSV` class listed in the Appendix to help you with parsing the input file.

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

`    Error: the file census2000.csv cannot be opened.`

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


The program should run in a loop that allows the user to issue different queries.
The types of queries are:

- `REGION total`
- `REGION from ORIGIN`
- `REGION all`


In the above, the words in uppercase indicate keywords that will be replaced by
actual values:
`REGION` is the name of the US State or territory displayed in the first column of data rows, and `ORIGIN` is a country or place of origin of the person counted (listed in the headings for the data rows).

In all cases the match for `REGION` should be exact but not case sensitive. For example, `New york` should match the
row for `New York`, but `newyork`, `ny` or `New York State` should not.
The columns matching `ORIGIN` should be all the columns that contain names of
places of origin whose names contain the keyword `ORIGIN` in them. This match should not be case sensitive.
For example, if the `ORIGIN` is `poland`, the data from all the columns with headings `Poland (Austrian)`, `Poland (German)`, `Poland (Russian)`, `Poland (unknown)` should be returned.

- In the first case, `REGION total`, the program should display the
total foreign born population in the specified `REGION`. The format of the output
should be

	```
	REGION: total foreing born population is NUM.
	```
	(in which `REGION` and `NUM` are replaced with the actual values).

- In the second case, `REGION from ORIGIN`, the program should display the
total number of foreign born population in all the places of origin whose name contains the keyword `ORIGIN`. The format of the output should be

	```
	REGION: foreign born population
	PLACE1  NUM1
	PLACE2  NUM2
	...
	```
	in which the `PLACE1`, `PLACE2`, ... all contain the keyword `ORIGIN` and `NUM1`,`NUM2`, ... are the corresponding counts. The order of the
	places should be from the one with largest count to the smallest count. Any
	ties should be resolved based on the place names (in alphabetical order).


- In the third case, `REGION all`, the program should display the list of all the places of origin and the population counts from them that are associated with the
specified `REGION` and whose count is greater than zero. The format of the output should be

	```
	REGION: foreign born population
	PLACE1  NUM1
	PLACE2  NUM2
	...
	```
	in which the `PLACE1`, `PLACE2`, ... are all places of origin with a non-zero count and `NUM1`,`NUM2`, ... are the corresponding counts. The order of the
	places should be from the one with largest count to the smallest count. Any
	ties should be resolved based on the place names (in alphabetical order).

<br/>

On each iteration, the user should be prompted to enter a new query (for which
the program computes the results) or the word 'quit'
to indicate the termination of the program.

<br/>


__The user should not be prompted for any other response.__

<br/>

If the query entered by the user is invalid, the program should display an error message:

`    This is not a valid query. Try again. `

and allow the user to provide an alternative query.

If the query entered by the user does not return any results,  the program should print
a message

`    No matches found. Try again. `

and allow the user to provide an alternative query.

<br>

All output from the user interaction should be printed to the standard output stream (`System.out`), even the above error messages.

<br/>

__Sample user interaction is shown in the Appendix.__


</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked=true >
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You need to provide an implementation of several classes that store the data and
compute the results when the program is executed.

In particular, your program must implement and use the following classes.
You may implement additional classes and additional methods in the required classes, if you wish.

#### <code class="code_title">Origin</code> class

This class should represent a place of origin and the associated count for a particular place region.

- This class should provide a two parameter constructor that validates and sets the name of the place of origin and the count.

	`public Origin( String originName, int count)`

	The `originName` cannot be `null` or an empty string, and the `count` should not be negative.
	If this constructor is called with invalid arguments,  it should throw an instance of the `IllegalArgumentException`  with an appropriate message.

- The class should provide accessor methods for the name and the count:
	- `public String getOriginName()`
	- `public int getCount()`

- The class should implement `Comparable<Origin>`  interface. Two `Origin` objects should be compared based on their count (with the one having a smaller count being considered _smaller_). If their counts are equal, the comparison should be done based on the alphabetical ordering of the names.

- The class should override the `equals` method from the `Object` class. Two `Origin` objects
	are the same if their names and counts are the same.

- The class should override the `toString` method from the `Object` class. It should
	return a  `String` matching the following pattern:

	```
	PLACE NUM
	```
	(where `PLACE` is the name and `NUM` is the count associated with the given `Origin` object).


#### <code class="code_title">Region</code> class

This class should represent a particular US state or territory. It should store the information about the name of the region and about the list of all the counts of foreign born residents and their places of origin (i.e., it should keep a list of all the `Origin` objects associated with the given region).

- This class should provide a one parameter constructor that validates and sets the name, class and location of the place.

	`public Region (String name)`

	Any non-empty string is a valid `name`. If this constructor
	is called with a `null` or an empty `name`, it should throw an instance of `IllegalArgumentException`  with an appropriate message.

	There should be no default constructor.

- This class should provide a method to add an `Origin` object to the list of
places of origin associated with it.

	`public boolean add(Origin origin)`

	If a method is called with `null` argument, it should throw an instance
	of `IllegalArgumentException` with an appropriate message.
	If the `origin`'s name is equal (case insensitive match) to one of the already existing place of origin names, then this object should not be added to the list and the method should return `false`.
	If `origin` is added to the list, the method should return `true`.

- The class should provide a method that retrieves a list of `Origin` objects based on the provided keyword.

	`public ArrayList<Origin> getByName( String keyword )`

	If a method is called with `null` argument or an empty string, it should throw
an instance of `IllegalArgumentException`. The method should return a list of all `Origin` objects associated with this `Region` object whose names contain `keyword` as a substring or `null` if there are no matching `Origin` objects.


- The class should override the `equals` method from the `Object` class. Two `Region` objects
	are the same if they have identical names. The match should be case insensitive.

- The class should override the `toString` method from the `Object` class. It should
	return a multi-line `String` matching the following pattern

	```
	REGION: foreign born population
	PLACE1  NUM1
	PLACE2  NUM2
	...
	```
	(in which the `PLACE1`, `PLACE2`, ... are all places of origin with a non-zero count and `NUM1`,`NUM2`, ... are the corresponding counts). The order of the
	places should be from the one with largest count to the smallest count. Any
	ties should be resolved based on the place names (in alphabetical order).


#### <code class="code_title">RegionList</code> class
The `RegionList` class should be used to store all the `Region` objects.
This class should inherit from the `ArrayList<Region>` class.

- The class needs to provide a default constructor that creates an empty `RegionList` object.

In addition, the class should implement the following method:

- `public Region getByName ( String keyword )  `

	If a method is called with `null` argument or an empty string, it should throw
	an instance of `IllegalArgumentException`.
	This method should return a  `Region` object whose name matches the
  `keyword`. The keyword comparison should be done in a case insensitive way. If there is no match, the method should return `null`.


#### <code class="code_title">Census1900ImmigrationData</code> class
The `Census1900ImmigrationData` class is the actual program. This is the class that should contain the `main` method.
It is responsible for opening and reading
the data file, obtaining user input, performing some data validation and handling
all errors that may occur, and printing all output to the standard output stream. It should handle any
exceptions thrown by your other classes and terminate gracefully, if need be, with
a friendly error message presented to the user: The program should never just reprint the
exception message as a way of handling an exception. These messages are rarely
readable to the ordinary user and make it seem like the program crashed in response to the exception.

You may implement other methods in this class to modularize the design.

</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox" checked=true >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_s22/notes/CodeConventions.pdf).

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

The first interaction has a lot of invalid instructions or instructions that produce no results.

```
Enter one of the following instructions.

REGION total
REGION from ORIGIN
REGION all
quit

Replace REGION with your desired region, and ORIGIN with your desired place of origin (or its substring).
------

Enter your instruction:
Georgia

This is not a valid query. Try again.

Enter your instruction:
Geoergia from Moon

No matches found. Try again.

Enter your instruction:
Georgia from Moon

No matches found. Try again.

Enter your instruction:
Georgia frommm France

This is not a valid query. Try again.

Enter your instruction:
quit
```

The following interaction has all valid instructions and all queries produce non-empty results.

```
Enter one of the following instructions.

REGION total
REGION from ORIGIN
REGION all
quit

Replace REGION with your desired region, and ORIGIN with your desired place of origin (or its substring).
------

Enter your instruction:
California total

California: total foreign born population is 367215

Enter your instruction:
California from Poland

California: foreign born population
Poland (Russian)	832
Poland (unknown)	229
Poland (German)	187
Poland (Austrian)	72

Enter your instruction:
New York from Cuba

New York: foreign born population
Cuba	2195
West Indies (except Cuba and Puerto Rico)	4241

Enter your instruction:
New York all

New York: foreign born population
Germany	480020
Ireland	425553
Italy	182248
Russia	165610
England	135685
Canada (English) (includes Newfoundland)	90336
Austria	78491
Sweden	42708
Poland (Russian)	37317
Hungary	37168
Scotland	33862
Canada (French) (includes Newfoundland)	27199
France	20008
Poland (German)	19701
Bohemia	16347
Switzerland	13678
Norway	12601
Roumania	10549
Poland (Austrian)	9696
Holland	9414
Denmark	8746
Wales	7304
China	6880
West Indies (except Cuba and Puerto Rico)	4241
Finland	4048
Cuba	2195
Poland (unknown)	2018
Turkey	1915
Belgium	1787
Asia (except China, Japan, and India)	1744
Spain	1614
Greece	1573
South America	1130
Central America	1016
Born at Sea	1001
Australia	706
Africa	473
Atlantic Islands	461
India	408
Portugal	362
Mexico	353
Other Countries	339
Japan	302
Europe (not otherwise specified)	286
Pacific Islands (except Phillipine Islands)	118
Luxemburg	75

Enter your instruction:
quit

```


<br>
<br>
<br>


</div> </div></div>


</main>
