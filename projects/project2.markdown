---
layout: lab
title: Project 2
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__due date:__ Oct. 11

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 2: Every Place Has a Name

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other public or private forum). If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and features of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.
</div>

---

<br/><br/>
### Introduction and objectives



<a title="U.S. Government, Public domain, via Wikimedia Commons" href="https://commons.wikimedia.org/wiki/File:USGS_logo_green.svg"><img width="400" alt="USGS logo green" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/USGS_logo_green.svg/256px-USGS_logo_green.svg.png" style="float:right; margin:10px"></a>


In this project you will be working with open data. Wikipedia has a good description of open data: "Open data is the idea that some data
should be freely available to everyone to use and republish as they wish, without restrictions from copyright, patents or other mechanisms of control."
You will be working with a specific data set from the United States Geological Survey. It contains names of every place in the United States (towns, villages, parks, lakes, mountains, ...). You can find the complete collection of the data sets organized by state (and in a few other ways) at  https://www.usgs.gov/core-science-systems/ngp/board-on-geographic-names/download-gnis-data.

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
debugging always takes time.



<div class="wrap-collabsible">
<input id="Every place name in the United States Data Set" class="toggle" type="checkbox"  >
<label for="Every place name in the United States Data Set" class="lbl-toggle"> Every place name in the United States Data Set </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You can find the data set [here](https://www.usgs.gov/core-science-systems/ngp/board-on-geographic-names/download-gnis-data) - it is updated fairly regularly (the latest update was at the end of August).

Your program should work with a local copy of a file whose format matches that of the files that you can download from
the website. All files are pipe-delimited text files.

Here are the first few lines of the New York state examples:

```
FEATURE_ID|FEATURE_NAME|FEATURE_CLASS|STATE_ALPHA|STATE_NUMERIC|COUNTY_NAME|COUNTY_NUMERIC|PRIMARY_LAT_DMS|PRIM_LONG_DMS|PRIM_LAT_DEC|PRIM_LONG_DEC|SOURCE_LAT_DMS|SOURCE_LONG_DMS|SOURCE_LAT_DEC|SOUR
CE_LONG_DEC|ELEV_IN_M|ELEV_IN_FT|MAP_NAME|DATE_CREATED|DATE_EDITED
205110|North Country National Scenic Trail|Trail|PA|42|Perry|099|401920N|0770439W|40.3221113|-77.0775473|||||200|656|Wertzville|09/12/1979|08/27/2019
205609|Bog Hollow Brook|Stream|CT|09|Litchfield|005|414429N|0732945W|41.7414829|-73.4959579|414734N|0733030W|41.7928952|-73.5084172|119|390|Kent|09/12/1979|05/01/2015
205906|Byram River|Stream|CT|09|Fairfield|001|405901N|0733918W|40.9837089|-73.6551276|410919N|0734132W|41.1553735|-73.6923523|0|0|Mamaroneck|09/12/1979|02/24/2020
206430|Converse Lake|Lake|CT|09|Fairfield|001|410758N|0733907W|41.1326454|-73.6520811|||||129|423|Mount Kisco|09/12/1979|05/23/2018
206431|Converse Pond Brook|Stream|CT|09|Fairfield|001|410410N|0734018W|41.0695412|-73.6717953|410834N|0733919W|41.1428737|-73.6554063|48|157|Glenville|09/12/1979|
206783|East Branch Converse Pond Brook|Stream|CT|09|Fairfield|001|410328N|0734026W|41.0577778|-73.6738889|410751N|0734037W|41.1308333|-73.6769444|45|148|Glenville|09/12/1979|03/14/2007
206789|East Branch Mianus River|Stream|CT|09|Fairfield|001|410630N|0733519W|41.1084297|-73.5887367|411031N|0733426W|41.1753736|-73.5740145|57|187|Stamford|09/12/1979|
206794|East Branch Silvermine River|Stream|CT|09|Fairfield|001|411308N|0732925W|41.2189847|-73.4904008|411612N|0732930W|41.2698717|-73.4916883|136|446|Norwalk North|09/12/1979|07/08/2015
207079|Fishers Island Ferry|Crossing|CT|09|New London|011|411644N|0720324W|41.2789876|-72.0567414|||||0|0|New London|09/12/1979|11/02/2007
207080|Fishers Island Sound|Bay|CT|09|New London|011|411827N|0715745W|41.3075991|-71.9625725|||||0|0|Mystic|09/12/1979|06/16/2011
207099|Fivemile River|Stream|CT|09|Fairfield|001|410326N|0732645W|41.0573192|-73.445953|411132N|0733056W|41.1923181|-73.5156792|0|0|Norwalk South|09/12/1979|
207285|Gerow Brook|Stream|CT|09|Fairfield|001|412950N|0733159W|41.4973161|-73.5331805|412851N|0733031W|41.4808333|-73.5086111|150|492|Brewster|09/12/1979|
207966|Horseneck Brook|Stream|CT|09|Fairfield|001|410109N|0733740W|41.019264|-73.6279041|410734N|0733754W|41.1262073|-73.6317941|9|30|Glenville|09/12/1979|
208076|Indian Lake|Lake|CT|09|Litchfield|005|415506N|0732948W|41.9182523|-73.49674|||||191|627|Sharon|09/12/1979|12/14/2018
208078|Indian Lake Creek|Stream|CT|09|Litchfield|005|415223N|0733009W|41.8731486|-73.502624|415438N|0732942W|41.9106484|-73.4951235|149|489|Amenia|09/12/1979|
208170|John D Milne Lake|Reservoir|CT|09|Fairfield|001|411218N|0732941W|41.2049417|-73.4946493|||||114|374|Norwalk North|09/12/1979|05/23/2018
208246|Kelsey Brook|Stream|CT|09|Litchfield|005|415706N|0732958W|41.9517591|-73.4995678|415743N|0732926W|41.9619444|-73.4905556|217|712|Sharon|09/12/1979|
208857|Mianus Reservoir|Reservoir|CT|09|Fairfield|001|410835N|0733647W|41.1431772|-73.6129529|||||70|230|Pound Ridge|09/12/1979|05/23/2018
```


The first line (which is wrapped) contains the column headings. The columns are separated by pipe symbols (vertical bars).
Every remaining line contains information for a single place (its unique ID, name, type of the place, state in which the place is located, ...).

The same file can be opened with a program designed to work with spreadsheets (like Excel) as long as the pipe symbol, `|`, is used as the column delimiter.

<img src="img/everyName.png" style="max-width:100%;">


<!--
The file that you download is a CSV (comma separated values) file  - it is a simple text file and is processed
like a text file (but it can also be opened by most of the spreadsheet programs and displayed column-wise based
on the locations of commas on each line). Since some of the columns in a CSV file may contain longer text that
might, optionally, contain commas or newlines as well, those entries are enclosed in a set of double quotes.

-->

<br>

There are twenty columns in the data set. Some of the columns may be empty. More detailed description of the file
format and each of its columns can be found [here](https://geonames.usgs.gov/docs/pubs/Nat_State_Topic_File_formats.pdf).

__From the point of view of this assignment, a valid row in the data set MUST contain the feature ID, feature name, feature class, and state and county associated with its location.
Any rows that do not contain these two values should be quietly ignored by the program.__

You can (and should) use the `Parser` class listed in the Appendix to help you with parsing the input file.

</div> </div></div>


<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox"  >
<label for="interface" class="lbl-toggle"> User Interface </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program has to be a console based program (no graphical interface) - this
means that the program should not open any windows or dialog boxes to prompt user
for the input. (Use the `Scanner` class to read the user input.)

</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox"  >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is started from the command line (or run within an IDE). It expects one command line argument.

This program should use command line arguments. When the user runs the program, they provide the name of the input
file as a command line argument. (This way the user can specify a different data set - for example data sets from different
states).

If the name of the input file provided as a command line argument is incorrect or the file cannot be
opened for any reason, the program should display an error message and terminate. It should not prompt the user for
an alternative name of the file.

If the program is run without any arguments, the program should display an error message and terminate. It should not prompt the user for the name of the file.

The error messages should be specific and informative, for example:

`    Error: the file NY_Features_20210825.txt cannot be opened.`

or

`    Usage Error: the program expects file name as an argument.`

The above error messages generated by your code should be written to the `System.err` stream (not the
`System.out` stream). If you are not sure what the difference is, research it or ask questions.

</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"  >
<label for="user" class="lbl-toggle"> User Interaction </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The program should run in a loop that allows the user to issue different queries.
The three types of queries are:

- `name KEYWORD`
- `name KEYWORD class CLASS`
- `name KEYWORD state STATE`
- `name KEYWORD class CLASS state STATE`
- `name KEYWORD state STATE class CLASS`


In the above, the words in uppercase indicate keywords that will be replaced by
actual values, for example `name Mianus`, `name Mianus class reservoir`, `name Mianus state NY`, `name Mianus state NY class reservoir NY` or `name Mianus class Reservoir state NY`. You can assume that `KEYWORD`, `CLASS` and `STATE` are always single
words with no white space characters. (Consider it an extra challenge in parsing if there could be multi-word phrases in each query.)

Correct state name specification should use its two letter abbreviation.

In the first case, `name Mianus`, the program should display the
entries from the data set whose names contain `Mianus` specified by the user.

In the second case, `name Mianus class reservoir`, the program should display the
entries from the data set whose names contain `Mianus` and whose class contains the word `reservoir`.

In the third case, `name Mianus state NY`, the program should display the
entries from the data set whose names contain `Mianus` and that are located in New York state (NY).


In the fourth and fifth cases, `name Mianus state NY class reservoir NY`  or `name Mianus  class reservoir state NY`, the program should display the
entries from the data set whose names contain `Mianus` , whose class contains the work `reservoir` and that are located in New York state (NY).



<br>

The `name` query is mandatory. The other two queries may be used to provide additional restrictions (they can be used in any order, i.e., `name Mianus class Reservoir state NY` and `name Mianus state NY class Reservoir` should produce identical results).

<br>

__The keywords should be case insensitive. This means that `name Mianus`, `name MIANUS`
and `name MiAnUs` should all return exactly the same results.__

<br>

On each iteration, the user should be prompted to enter a new query (for which
the program computes the results) or the word 'quit'
to indicate the termination of the program.

__The user should not be prompted for any other response.__

If the query entered by the user is invalid, the program should display an error message:

`    This is not a valid query. Try again. `

and allow the user to provide an alternative query.

If the query entered by the user does not return any results,  the program should print
a message

`    No matches found. Try again. `

and allow the user to provide an alternative query.

<br>

All output from the user interaction should be printed to the standard output stream (`System.out`).

<br>


__Matching results display:__
If the query entered by the user matches one or more place, the information  should be displayed in the following format:

```
NAME, CLASS
COUNTY, STATE
LATITUDE, LONGITUDE, ELEVATION

-----
```

All the words in uppercase letters are place-holders for the actual values from the data set. The elevation should be specified in feet (not meters).

If latitude, longitude or elevation are missing, they should be left blank in the above output.

The output should contain a single blank line, followed by a line with five dashes, `-----`,
after each result. This will visually separate the results for improved readability.


__Sample user interaction is shown in the Appendix.__


</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox" >
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You need to provide an implementation of several classes that store the data and
compute the results when the program is executed.

In particular, your program must implement and use the following classes.
You may implement additional classes and additional methods in the required classes, if you wish.

#### <code class="code_title">Location</code> class

This class should represent a location of the given named place/feature. It should store the information about state, county, latitude, longitude and elevation (in feet).

- This class should provide a two parameter constructor that validates and sets the state and county names.

	`public Location( String state, String, county)`

	Valid arguments cannot be `null`.
	If this constructor is called with invalid arguments,  it should throw an instance of the `IllegalArgumentException`  with an appropriate message.

- The class should provide accessor and mutator methods (i.e., getters and setters) for the longitude, the latitude and the elevation values. They should use the following signatures:
	- `public double getLatitude()`
	- `public void setLatitude( double latitude )` - a valid latitude is in the range of from -90 to +90 (inclusive)
	- `public double getLongitude()`
	- `public void setLongitude( double longitude )` - a valid longitude is in the range of from -180 to +180 (inclusive)
	- `public int getElevation()`
	- `public void setElevation( int elevation )`

	If any of the mutators is called with an invalid argument, the method should throw an instance of the  `IllegalArgumentException`  with an appropriate message.

- The class should implement `Comparable<Location>`  interface. Two `Location` objects should be
	compared based on their state names (case insensitive, alphabetic ordering), county names (case insensitive, alphabetic ordering), latitude, longitude (both following the numerical ordering of floating point numbers), and elevation (following the numerical ordering of integers).
	If two `Location` objects have the same state names, the comparison should be done by their county names. If
 	two `Location` objects have the same state names names and the same county names, the comparison should be done by
	their latitude coordinates. ...

- The class should override the `equals` method from the `Object` class. Two `Location` objects
	are the same if they represent identical locations (i.e., the names of the state and the county are the same, the longitude and latitude values are the same (up to six places after the decimal point), and the elevations are the same).

- The class should override the `toString` method from the `Object` class. It should
	return a  `String` matching the following pattern:

	```
	COUNTY, STATE
	LATITUDE, LONGITUDE, ELEVATION
	```
	(If latitude, longitude, or elevation are not provided, the values should be printed as zeros - this is the convention
	used in the data set.)


#### <code class="code_title">Feature</code> class

This class should represent a particular place/feature. It should store information about the place's name, class (i.e., what type of a place it is), and its location. It can store additional information if you wish.

- This class should provide a three parameter constructor that validates and sets the name, class and location of the place.

	`public Feature (String name, String class, Location location)`

	Any non-empty string is a valid `name` or `class`. If this constructor
	is called with a `null` or an empty `name` or `class`, it should throw an instance of `IllegalArgumentException`  with an appropriate message.

	`location` should be a valid Location object.
	If this constructor is called with a `null` argument,  it should throw an instance of the `IllegalArgumentException`  with an appropriate message.

	There should be no default constructor.

- This class should provide the following accessor methods:
	- `public String getFeatureName()`
	- `public String getFeatureClass()`
	- `public Location getFeatureLocation()`

- The class should implement `Comparable<Feature>` interface. The two `Feature` objects should be
	compared based on their names, location, and class (in that order), i.e., if
	two `Feature` objects have the same names, the comparison should be done by their locations (following the rules outlined in the `Location` class); if the
 	two `Feature` objects have the same names and the same locations, the comparison should be done by
	their  their class; finally, if all three are the same, the two objects should
	be considered equal. All comparisons should be case insensitive.

- The class should override the `equals` method from the `Object` class. Two `Feature` objects
	are the same if they have identical names, locations and classes.  All comparisons should be case insensitive.

- The class should override the `toString` method from the `Object` class. It should
	return a multi-line `String` matching the following pattern


	```
	NAME, CLASS
	COUNTY, STATE
	LATITUDE, LONGITUDE, ELEVATION
	```

	All the words in uppercase letters are place-holders for the actual values from the data set. The elevation should be specified in feet (not meters).

	If latitude, longitude or elevation are missing, they should be left blank in the above output.

#### <code class="code_title">FeatureList</code> class
The `FeatureList` class should be used to store all the `Feature` objects.
This class should inherit from the   `ArrayList<Feature>` class.

- The class needs to provide a default constructor that creates an empty `FeatureList` object.

In addition, the class should implement the following two methods:

- `public FeatureList getByName ( String keyword )  `

	This method should return a list of all `Feature` objects for which the names __contain__ the
  `keyword`. The keyword comparison should be done in a case insensitive way.
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `compareTo` method defined in the `Feature` class).
	If `keyword` is `null` or an empty string, this method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.

- `public FeatureList getByClass ( String keyword )   `

	This method should return a list of all `Feature` objects for which the class name (the type of the feature) contains the
  `keyword`.  The keyword comparison should be done in a case insensitive way.
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `compareTo` method defined in the `Feature` class).
	If `keyword` is `null` or an empty string, this method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.

- `public FeatureList getByState ( String state )   `

	This method should return a list of all `Feature` objects for which the state name  matches the parameter `state`.
	The comparison should be done in a case insensitive way, but the comparison is based on equality of the two state names
	(which are two letter state name abbreviations).
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `compareTo` method defined in the `Feature` class).
	If `keyword` is `null` or an empty string, this method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.


#### <code class="code_title">EveryPlaceHasAName</code> class
The `EveryPlaceHasAName` class is the actual program. This is the class that should contain the `main` method.
It is responsible for opening and reading
the data file, obtaining user input, performing some data validation and handling
all errors that may occur (in particular, it should handle any
exceptions thrown by your other classes and terminate gracefully, if need be, with
a friendly error message presented to the user: The program should never just reprint the
exception message as a way of handling an exception. These messages are rarely
readable to the ordinary user and make it seem like the program crashed in response to the exception.

You may implement other methods in this class to modularize the design.

</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_f21/notes/CodeConventions.pdf).

- The data file should be read only once! Your program needs to store the data
in memory resident data structures.

- You may not use any of the collection
classes that were not covered in cs101 (for this assignment, do not use `LinkedList`, `Stack`, `Queue`, `PriorityQueue`, or any classes implementing the `Map` interface). You can, and should, use the `ArrayList` class.

- You may use any exception-related classes.

- You may use any classes to handle the file I/O, but probably the simplest ones
are `File` and `Scanner` classes. You are responsible for knowing how to use the classes that you select.

</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  >
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
__DO NOT__ test your program on the entire large input file. This may take a long time and you will never know
if the results are correct or not.
- Each class that you submit __will be tested by itself without the context of other classes that you are implementing for this assignment__. <br>
This means that you need to make sure that your methods can perform their tasks correctly even if they are executed in situations that would not arise in the context of this specific program.
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
<input id="submit" class="toggle" type="checkbox" >
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
<input id="appendix" class="toggle" type="checkbox" >
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>



#### Parsing Lines of the Input File

The input file is a plain text file. Each line contains entries for several columns. Each column is separated by a pipe symbol, `|`.
To simplify parsing through the file, you can use the following function:

```
/**
 * Splits the given line of a pipe-delimited file according to | characters.
 * @author Joanna Klukowska
 * @param textLine	a line of text to be parsed
 * @return the array containing words (or empty strings) from between | characters
 */
public static String [] splitInputLine(String textLine){

	if (textLine == null ) return null;

	String [] entries = null;

	entries = textLine.split("\\|");

	return entries;
}
````


#### Sample Interactions

Here are a few sample runs of a program with much reduced input file to illustrate  the user interface.

```
Search the dataset by using one of the following queries.
  To search for features by keyword in their name, enter
	name KEYWORD
  To limit the search to a particular class of features , enter
	name KEYWORD class FEATURE_CLASS
  To limit the search to a particular state, enter
	name KEYWORD state STATE
  Or combine both restrictions by entering
	name KEYWORD class CLASS state STATE
    or
	name KEYWORD state STATE class CLASS
    To terminate the program, enter
	quit




Enter your search query:

name nyu

NYU Lutheran Medical Center, Hospital
NY, Kings
40.646368, -74.020396, 11

-----------
WNYU-FM (New York), Tower
NY, Bronx
40.857322, -73.912914, 53

-----------
NYU Hospital for Joint Diseases, Hospital
NY, New York
40.734390, -73.982832, 7

-----------



Enter your search query:

name NYU class hospital

NYU Lutheran Medical Center, Hospital
NY, Kings
40.646368, -74.020396, 11

-----------
NYU Hospital for Joint Diseases, Hospital
NY, New York
40.734390, -73.982832, 7

-----------



Enter your search query:

quit

```


<br>
<br>
<br>


</div> </div></div>


</main>
