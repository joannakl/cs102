---
layout: lab
title: Project 2
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__due date:__ March 7

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 2: Data Is Plural

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub, Discord, Groupme, ... or any other forum). If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and features of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.
</div>

---
<a title="Jonathan Gray, CC0, via Wikimedia Commons" href="https://commons.wikimedia.org/wiki/File:Open_Data_stickers.jpg"><img width="400" alt="Open Data stickers" src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Open_Data_stickers.jpg/512px-Open_Data_stickers.jpg" style="float:right; margin:10px"></a>

<br/><br/>
### Introduction and objectives


In this project you will be working with open data. Wikipedia has a good description of open data: "Open data is the idea that some data
should be freely available to everyone to use and republish as they wish, without restrictions from copyright, patents or other mechanisms of control."
In fact, you will be working with an open data set that is a collection of open data sets.
[_Data is Plural_](https://tinyletter.com/data-is-plural) is a project run by Jeremy Singer-Vine. You can subscribe to his newsletter and get a fresh collection of interesting data sets each week. Or, you can browse [the archives](https://docs.google.com/spreadsheets/d/1wZhPLMCHKJvwOkP4juclhjFgqIY8fQFMemwKL2c64vk) dating back to 2015.

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
- implementing your own linked list
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
<input id="dataset" class="toggle" type="checkbox"  >
<label for="dataset" class="lbl-toggle"> Dataset </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You can access the latest dataset [here](https://docs.google.com/spreadsheets/d/1wZhPLMCHKJvwOkP4juclhjFgqIY8fQFMemwKL2c64vk) - it is updated fairly regularly.

Your program should work with a local CVS copy of this file that you can download from
[here](data_is_plural.csv).


The file that you download is a CSV (comma separated values) file  - it is a simple text file and is processed
like a text file (but it can also be opened by most of the spreadsheet programs and displayed column-wise based
on the locations of commas on each line). Since some of the columns in a CSV file may contain longer text that
might, optionally, contain commas or newlines as well, those entries are enclosed in a set of double quotes.

There are six columns in the _Data is Plural_ data set. Some of the columns may be empty.

<img src="img/data_proj2.png" style="max-width:100%;">

<br>

__From the point of view of this assignment, a valid row in the data set MUST contain the _headline_, _text_ and _links_ values.
Any rows that do not contain these two values should be quietly ignored by the program.__

You can (and should) use the `CSV` class listed in the Appendix to help you with parsing the input file.

</div> </div></div>


<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox"  >
<label for="interface" class="lbl-toggle"> User Interface </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program has to be a console based program (no graphical interface) - this
means that the program should not open any windows or dialogs to prompt user
for the input.

</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox"  >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is started from the command line (or run within an IDE). It expects one command line argument.

This program should use command line arguments. When the user runs the program, they provide the name of the input
file as a command line argument. (This way the user can specify a different data set - for example a subset of entries
from a particular range of dates).

The user may start the program from the command line or run it within an IDE like
Eclipse - __from the point of view of your program this does not matter__.

If the name of the input file provided as a command line argument is incorrect or the file cannot be
opened for any reason, the program should display an error message and terminate. It should not prompt the user for
an alternative name of the file.

If the program is run without any arguments, the program should display an error message and terminate. It should not prompt the user for the name of the file.

The error messages should be specific and informative, for example:

`    Error: the file data_is_plural_2019.csv cannot be opened.`

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

- `title KEYWORD`
- `description KEYWORD`
- `url KEYWORD`

In the above, the words in uppercase indicate keywords that will be replaced by
actual values, for example `title COVID`, `description immigration` or `url .gov`.

In the first case, `title KEYWORD`, the program should display the
entries from the data set whose titles (headlines) contain the `KEYWORD` specified by the user.

In the second case, `description KEYWORD`, the program should display the
entries from the data set whose descriptions (text) contain the `KEYWORD` specified by the user.

In the third case, `url KEYWORD`,  the program should display the
entries from the data set whose links  contain the `KEYWORD` specified by the user. For example,
`url .gov` would return the data sets that are hosted on government sites.

<br>

The user should be able to combine two of the above queries (but not three or more)
to narrow down the returned results.
For example, if the user enters
`title COVID url .gov`, the program should display the entries from the data set whose titles
contain the word `COVID` and for which the links lead to sites with `.gov` in their URLs.

<br>

__The keywords should be case insensitive. This means that `title COVID`, `title covid`
and `title Covid` should all return exactly the same results.__

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
If the query entered by the user matches one or more DataSet, the information  should be displayed in the following format:

```
DATE
NAME
DESCRIPTION
LINKS

-----
```

All the words in uppercase letters are place-holders for the actual values from the data set.

If date is missing from the data set, it should be skipped in the result in the result.

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

#### <code class="code_title">Date</code> class

This class should represent a calendar date. It should store the information about the year, month and day of the week.

- This class should provide a three parameter constructor that validates and sets the year, month and day.

	`public Date( int year, int month, int day)`

	A valid `year` has to be a positive integer. A valid `month` has to be a positive integer in the range of 1-12.
	A valid `day` depends on the month of the year and the year. Please see the [Julian and Gregorian calendars](https://en.wikipedia.org/wiki/Month#Julian_and_Gregorian_calendars) for the length of the months and   [Leap Year Algorithm](https://en.wikipedia.org/wiki/Leap_year#Algorithm) to determine how to calculate which year is a leap year.

- The class should implement `Comparable<Date>` interface. The two `Date` objects should be
	compared based on year, month and day (in that order). This way the earlier dates are _smaller_ than the later dates.

- The class should override the `equals` method from the `Object` class. Two `Date` objects
	are the same if they represent identical dates.

- The class should override the `toString` method from the `Object` class. It should
	return a  `String` matching the following pattern: `YYYY-MM-DD`.



#### <code class="code_title">DataSet</code> class

This class should represent a data set with all of its characteristics (date, title/headline, description/text,
list of links, and any other information you may decide may be useful to store).

- This class should provide a three parameter constructor that validates and sets the title, description and a list of  links.

	`public DataSet (String title, String description, ArrayList<URL> links)`

	Any non-empty string is a valid `title` or `description`. If this constructor
	is called with a `null` or an empty `title` or `description`, it should throw an instance of `IllegalArgumentException`  with an appropriate message.

	`links` should be a non-empty list of `URL` objects. Note that [`URL`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/net/URL.html) is a class defined in Java (you do not need to define it yourself).
	If this constructor is called with a `null` or an empty list as `links`,  it should throw an instance of `IllegalArgumentException`  with an appropriate message.

	There should be no default constructor.

- This class should provide the following mutator and accessor methods. The mutator
	methods should validate the data according to the specification below. If any values are invalid,
	the method should throw an instance of 	`IllegalArgumentException` with an appropriate message.
	- `public void setDate(Date date)`, `public Date getDate()` - a valid date should not be `null` and should have a year equal to or after the year 2000.
	- `public void setHatTips( String hatTips)`, `public int getHatTips()` - a valid
		`hatTip` should be a non-empty, not `null` string

- The class should implement `Comparable<DataSet>` interface. The two `DataSet` objects should be
	compared based on their dates, and, if the dates are the same, by their titles. The comparison between titles
  should be case insensitive.

- The class should override the `equals` method from the `Object` class. Two `DataSet` objects
	are the same if they have identical dates and titles (case of letters does not matter).

- The class should override the `toString` method from the `Object` class. It should
	return a multi-line `String` matching the following pattern

	```
	DATE
	NAME
	DESCRIPTION
	LINKS
	```

	All the words in uppercase letters are place-holders for the actual values from the data set.

	If date is missing from the data set, it should be skipped in the result in the result.

#### <code class="code_title">DataSetList</code> class
The `DataSetList` class should be used to store all the `DataSet` objects.
This class should inherit from the   `ArrayList<DataSet>` class.

- The class needs to provide a default constructor that creates an empty `DataSetList` object.

In addition, the class should implement the following two methods:

- `public DataSetList getByTitle ( String keyword )  `

	This method should return a list of all `DataSet` objects for which the titles (headlines) contain the
  `keyword`. The keyword comparison should be done in a case insensitive way.
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `comparaTo` method defined in the `DataSet` class).
	If `keyword` is `null` or an empty string, this method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.

- `public DataSet getByDescription ( String keyword )   `

	This method should return a list of all `DataSet` objects for which the descriptions (text fields) contain the
  `keyword`.  The keyword comparison should be done in a case insensitive way.
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `comparaTo` method defined in the `DataSet` class).
	If `keyword` is `null` or an empty string, this method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.

- `public DataSet getByURL ( String keyword )   `

	This method should return a list of all `DataSet` objects for which the links  contain the
  `keyword`.  The keyword comparison should be done in a case insensitive way.
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `comparaTo` method defined in the `DataSet` class).
	If `keyword` is `null` or an empty string, this method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.


#### <code class="code_title">DataIsPlural</code> class
The `DataIsPlural` class is the actual program. This is the class that should contain the `main` method.
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
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_s21/notes/CodeConventions.pdf)
posted on the course website.

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
This means that you need to make sure that your methods can perform their tasks correctly even if they are executed in situations that would not
arise in the context of this specific program.
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
- 50 points: class correctness: correct behavior of methods of the required classes and correct behavior of the program
	as a whole (this will be determined by the autograder and some manual evaluation)
- 30 points: design and the implementation of the required classes and any additional classes
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


Your should submit all your source code files (the ones with `.java` extensions only)
in a single __zip__ file to Gradescope. __DO NOT__ submit `.class` files
or any project files that your IDE might produce. You can see all the files on Gradescope.
Verify that there is nothing there that you did not intend to put it.

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

#### Parsing CSV files

CSV is a simple file format, but there are many non-standard variations: the field separator,
the field delimiter, the special characters allowed in the fields, etc.

You should use the `CSV` class provided below. It was designed to work with the
file format that you are working with.

- [`CSV`](doc/project2/CSV.html) class documentation
- [`CSV.java`](project2/CSV.java) file

<!--
#### Sample Interactions

Here are a few sample runs of a program with much reduced input file to illustrate  the user interface.

```


	Search the database by using one of the following queries.
	  To search for DataSet nearest to a given goe-location, enter
	        location LATITUDE LONGITUDE
	  To search for DataSets that fell in a given year, enter
	        year YEAR
	  To search for DataSets with weights MASS +/- 10 grams, enter
	        mass MASS
	  To finish the program, enter
	        quit




	Enter your search query:

	year 1980
	Cccccccccccccccc        3 1980     75  -10.00000  -10.00000
	Eeeeeeeeee              5 1980          10.00000  -10.00000
	Dddddddd                4 1980     85  -15.00000  -10.00000
	Ff ff 01                6 1980     78
	Ff ff 02                7 1980     78    0.00000    0.00000



	Enter your search query:

	year 1990
	Aaaa                    1 1990     20    0.00000    0.00000
	Bbbb                    2 1990     25   10.00000   10.00000



	Enter your search query:

	mass 80
	Cccccccccccccccc        3 1980     75  -10.00000  -10.00000
	Dddddddd                4 1980     85  -15.00000  -10.00000
	Ff ff 01                6 1980     78
	Ff ff 02                7 1980     78    0.00000    0.00000



	Enter your search query:

	mass 150
	No matches found. Try again.


	Enter your search query:

	location -12.0 -10.0
	Cccccccccccccccc        3 1980     75  -10.00000  -10.00000


	Enter your search query:

	location -14.0 -10.0
	Dddddddd                4 1980     85  -15.00000  -10.00000


	Enter your search query:

	quit
```
---

```


	Search the database by using one of the following queries.
	  To search for DataSet nearest to a given goe-location, enter
	        location LATITUDE LONGITUDE
	  To search for DataSets that fell in a given year, enter
	        year YEAR
	  To search for DataSets with weights MASS +/- 10 grams, enter
	        mass MASS
	  To finish the program, enter
	        quit




	Enter your search query:

	location 0 0
	Ff ff 02                7 1980     78    0.00000    0.00000


	Enter your search query:

	location 0
	This is not a valid geolocation. Try again.


	Enter your search query:

	location
	This is not a valid query. Try again.




	Enter your search query:

	mass 25
	Aaaa                    1 1990     20    0.00000    0.00000
	Bbbb                    2 1990     25   10.00000   10.00000



	Enter your search query:

	mass twenty five
	This is not a valid mass. Try again.


	Enter your search query:

	mas
	This is not a valid query. Try again.




	Enter your search query:

	year -10
	This is not a valid year. Try again.


	Enter your search query:

	quit
```
-->
</div> </div></div>


</main>
