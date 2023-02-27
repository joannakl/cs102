---
layout: lab
title: Project 3
---

<div class="lab-right" markdown="1">
__Project 3__ <br>
__due date:__ March 10 at 11:59pm

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 3: NYS Tax Preparers 



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


In this project you will be working with open data. Wikipedia has a good description of open data: "Open data is the idea that some data
should be freely available to everyone to use and republish as they wish, without restrictions from copyright, patents or other mechanisms of control."

You will be working with a specific data set from the <a href="https://data.ny.gov/">New York State Open Data collection</a>: <a href="https://data.ny.gov/Government-Finance/New-York-State-Registered-Tax-Return-Preparers-and/b7jj-bh4g">New York State Registered Tax Return Preparers and Facilitators</a>. As the name suggests, this dataset contains tax return preparers and facilitators that have registered with the New York State Department of Taxation and Finance pursuant to Tax Law Section 32. Your project will provide a way for the user
to interact with this data set (or its subset, or a dataset similar to it).

<br/><br/>

The goal of this programming project is for you to master (or at least
get practice on) the following tasks:

- working with multi-file programs
- reading data from input files
- using and understanding command line arguments
- working with large data sets
- working with a list 
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
<input id="The Dataset" class="toggle" type="checkbox"  checked=true >
<label for="The Dataset" class="lbl-toggle">The Dataset</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program should work with a local copy of a file whose format matches that of the file that you can download from
the website. This file is a comma separated values (CSV) file. CSV files are just text files. Your program can open them and read them as simple text.
Each line in a CSV file constitutes a data point (well, except for the heading line). The _columns_ in each entry are separated by commas (hence the name of the file format).

Here is an example row for Deborah Fisher from H&R Block:
```

FACILITATOR,DEBORAH,A,FISHER,H&R Block,MEDINA,NY,US,14103,,POINT (-78.38691 43.22012)


```

Note that the consecutive commas within the row correspond to _empty_ columns. 

<br/>

The data set and its description are at <a href="https://data.ny.gov/Government-Finance/New-York-State-Registered-Tax-Return-Preparers-and/b7jj-bh4g">New York State Registered Tax Return Preparers and Facilitators</a>. For your convenience, you can also download the `CSV` file provided with this project. There are several different data formats available on NYC OpenData site. Your program has to work with the `CSV` format of the data.

<br/>

The real data files are not perfect. You may discover that some rows are missing some values. Other rows may
contain invalid values in columns. **For the purpose of this project, any row that contains
the last name of the person and the city in which they are located is a valid row. The other entries might be missing or may be invalid (in which case they should be treated as missing). Any row that is missing the person's last name or the city should be quietly ignored.**

For example, all the following a valid rows (versions of the row above) that should be used by the program:


```

FACILITATOR,,,FISHER,H&R Block,MEDINA,,,,,POINT (-78.38691 43.22012)

,,,FISHER,,MEDINA,,,,,

,DEBORAH,A,FISHER,,MEDINA,NY,US,14103,,

```

But these rows are invalid and should be silently ignored by the program: 

```

FACILITATOR,DEBORAH,A,FISHER,H&R Block,,NY,US,14103,,POINT (-78.38691 43.22012)

FACILITATOR,DEBORAH,A,,H&R Block,MEDINA,NY,US,14103,,POINT (-78.38691 43.22012)

FISHER,H&R Block,MEDINA,NY

```
Note that the last of the above rows actually contains the last name and the city, but they are in different columns than the format of the dataset suggests. 

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
file as a command line argument. (This way the user can specify a different data set - for example data sets from different census years, or a partial data set that may include only a subset of row entries.) **Make sure that your program does not harcode the name of the file in the program itself. Also, make sure that you program does not prompt the user for the name of the file.**

If the name of the input file provided as a command line argument is incorrect or the file cannot be
opened for any reason, the program should display an error message and terminate. It should not prompt the user for
an alternative name of the file.

If the program is run without any arguments, the program should display an error message and terminate. It should not prompt the user for the name of the file.

The error messages should be specific and informative, for example:

`    Error: the file NYS_tax_preparers.csv cannot be opened.`

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


The program should run in a loop that allows the user to retrieve information about different NYS registered tax preparers/facilitators by using different queries.

The types of queries are:

- `name NAME_KEYWORD` - retrieves and displays all records for which the `NAME_KEYWORD` is a substring of the person's name 
- `zip ZIP_CODE` - retrieves and displays all records in a given `ZIP_CODE` 
- `city CITY_KEYWORD` - retrieves and displays all records for which the `CITY_KEYWORD` is a substring of the name of the city 
- `quit` - terminates the program 


In the above, the words in lowercase indicate the query type (they can be entered by the user in any case, but the strings must match exactly). The words in uppercase indicate keywords that will be replaced by actual values.

All matches for `NAME_KEYWORD` and `CITY_KEYWORD` should be case insensitive. For example "DEB" as `NAME KEYWORD` should match "Deborah", "DEBI", "Adebayo", etc. The `ZIP_CODE` should be a five digit zip code and should be matched exactly. 

If there are no records matching the query, the program should display a message:

`No matching results.` 

and allow the user to enter another query.

If there are results, the program should display all records in alphabetical order by last name of the person.  The format of each record should be as follows:

```
LAST_NAME, FIRST_NAME, INITIAL
<tab>BUSINESS_NAME, CITY, STATE, COUNTRY, ZIP 
```
If any of the values is missing, it should be skipped (but the comma following it should be still displayed). 

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


<br>

All output from the user interaction should be printed to the standard output stream (`System.out`), even the above error messages since they are part of the user interaction.

<br/>

__Sample user interaction is shown in the Appendix.__








</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked=true >
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>




Your need to provide an implementation of several classes that store the data and
compute the results when the program is executed.

In particular, your program must implement and use the following classes.
You may implement additional classes and additional methods in the required classes, if you wish. Make sure that your design follows object oriented principles. For any additional methods/classes ask yourself where they belong, and if they should be accessible to third parties using the code. 

__As you are working on your classes, keep in mind that they should be (and will be) tested separately from the rest of your program.__



#### <code class="code_title">Name</code> class

This class represents a person's name. It should store information about first name, last name, and the middle initial. 
<p/>

This class should provide three constructors:
- one parameter constructor that takes last name only
- two parameter constructor that takes last name and first name
- three parameter constructor that takes last name, first name and the middle initial  

In each case the order of the parameters should be as described above. The last name is a non-empty `String` object. The first name is a, possibly empty or `null`, `String` object. The middle initial is a, possibly empty or `null`, `Character` object. 
<br>
If any of the constructors are called with `null` or an empty string as the last name, the constructor should throw an instace of `IllegalArgumentException`. 
<p/>

This class should override the `equals` methods (see the documentation for the `Object` class for details).
The two `Name` objects should be considered equal if their first name, last name and middle initial are the same. This comparison should be case insensitive. 
<p/>

It should implement `Comparable<Name>` interface. The comparison 
should be case insensitive and consistent with alphabetic ordering of words in an English dictionary. 
The `Name` objects should be compared by the last name first, then the first name, then the middle initial. 

#### <code class="code_title">Location</code> class

This class represents a location associated with each record. It should store information about city, state, country and zip code. 
<p/>

This class should provide a single constructors with four parameters
<br/>
`Name ( String city, String state, String country, String zip )`
<br/>
The city is a non-empty `String` object. The state, country and zip code can be, possibly empty or `null`, `String` objects. 
<br>
If the constructor is called with `null` or and empty string as the city, the constructor should throw an instance of `IllegalArgumentException`. 
<br/>
If the constructor is called with `zip` value that is not valid, the constructor should throw  an instance of `IllegalArgumentException`. Valid zip code values are 5-digit strings (i.e., any string that has non-digit characters is not a valid zip code, any string that has more than 5 digits is not a valid zip code). If the `zip` argument contains fewer than 5 digits (and no other non-digit characters), then the leading digits should be assumed to be zeros. For example, if `zip="1301"` then the actual zip-code is 01301. 
<p/>

This class should override the `equals` methods (see the documentation for the `Object` class for details).
The two `Location` objects are equal if all of their components (city, state, country, zip code) are the same. This comparison should be case insensitive. 
<p/>

It should implement `Comparable<Loction>` interface. The comparison 
should be case insensitive and consistent with alphabetic ordering of words in an English dictionary. 
The `Location` objects should be compared by the zip code, city name, then the state, then country. If any of the values is missing, the comparison should be based on the following value in the list. Consider the following exaples: 
- `loc1: zip = null, city = Brooklyn, state = NY, country = USA` <br/>
`loc2: zip = 10025, city = Manhattan, state = NY, country = USA` <br/>
`loc1.compareTo(loc2)` should return a value smaller than zero since we cannot compare based on zip-code values and the comparison is done based on the city names. 
- `loc3: zip = 10012, city = Manhattan, state = NY, country = USA` <br/>
`loc4: zip = 10025, city = Manhattan, state = NY, country = USA` <br/>
`loc1.compareTo(loc2)` should return a value smaller than zero since the comparison is done based on the zip codes. 

#### <code class="code_title">Record</code> class

The `Record` class stores information about a particular record/row from the input file. The class is not required to store all the information from each row of the input file, but it should store the fields relevant to this program, namely:

- person name (with its components as described above)
- the business associated with the record, as a possibly empty or `null` string objects 
- the location associated with the recor (with its components described as above) 
<p/>

This class should provide a three parameter constructor:
<br/>
`Record ( Name name, String business, Location location) `
<br/>
`name` and `location` should be valid objects as described in previous sections. `business` should be a, possibly empty or `null`, `String` object. 
<br/>
There should be no default constructor. (A default constructor is one that can be used without passing any arguments.)
<p/>

The class should provide public getters as follows:
- `Name getName()`
- `String getBusiness()`
- `Location getLocation()`
<p/>

This class should override the `equals` methods (see the documentation for the `Object` class for details).
The two `Record` objects are equal if all of their components (name, business, location) are equal. This comparison should be case insensitive for the business names and should follow the equality definitions above for the names and the locations. 
<p/>

This class should implement `Comparable<Record>` interface.
The comparison should be done by the persons' names as the primary key, and by the location
as the secondary key (i.e., when two objects that have the same persons' names are compared, the comparison should be performed by their locations).
<p/>

The class should override the `toString` method. The method should produce a two-line string of the format matching the following: 
```
LAST_NAME, FIRST_NAME, INITIAL
<tab>BUSINESS_NAME, CITY, STATE, COUNTRY, ZIP 
```
If any of the values is missing, it should be skipped (but the comma following it should be still included in the returned string). Zip codes should always be shown with 5 digits (i.e., they should show the leading zeros). 


#### <code class="code_title">RecordList</code> class

The `RecordList` class should be used to store all the unique `Record` objects.
This class should inherit from the `ArrayList<Record>` class. This class provides all functionality of the `ArrayList`, but adds to it a few functions that are specialized to a list that is designed to store and work with `Record` objects. 
<p/>

The class needs to provide a default constructor that creates an empty `RecordList` object.
<p/>

In addition, the class should implement the following methods:

- `public RecordList getByName (String keyword)`
returns a list of records for which the `keyword` is a substring of person's last name or first name. The method should be case insensitive. It should throw and instance of `IllegalArgumentException` exception if called with `null` argument or with an empty string. It should return `null` if there are no `Record` objects matching the `keyword`.
- `public RecordList getByCity (String keyword)`
returns a list of records for whcih the `keyword` is a substring of the city at which the tax preparer is located. The method should be case insensitive. It should throw and instance of `IllegalArgumentException` exception if called with `null` argument or with an empty string. It should return `null` if there are no `Record` objects matching the `keyword`. 
- `public RecordList getByZip (String zip )`
returns a list of records for which the zip-code (if specified) matches the `zip` argument exactly. It should throw and instance of `IllegalArgumentException` exception if called with `null` argument, or with a string that does not represent a five digit zip code (i.e., contains any characters other than digits, or contains fewer or more than five characters). It should return `null` if there are no `Record` objects matching the `zip` exactly. 
<p/>

The class should override the `toString` method. The details are up to you, but you should make sure that it returns a `String` object
that is a meaningful representation of the object on which it is called (it may or may not contain the listing of all of the elements).


#### <code class="code_title">NYS_Taxes</code> and <code class="code_title">CSV</code> classes

The [`NYS_Taxes`](project3/NYS_Taxes.java) class is the actual program. This is the class that is provided with the project. It parses the data from the input file, constructs the `RecordList` object and provides the user interaction. 

You should not need to modify it, but you may. Make sure to document any changes clearly. WARNING: if you feel like you need to make changes to this class, it may mean that your implementation of other classes is not following the specification. 

This class makes use of the [`CSV`](project3/CSV.java) class that is provided as part of the project as well. It halps in reading and parsing CSV files. You can see its documentation at [`CSV` documentation](project3/project3/CSV.html)



</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox" checked=true >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102/notes/CodeConventions.pdf).

- You may not use any of the collection
classes that are implemented in Java libraries except for the  `ArrayList` class which one of your classes needs to extend. For this assignment, do not use `LinkedList`, `Stack`, `Queue`, `PriorityQueue`, or any classes implementing the `Map` interface. You can, and should, use the `ArrayList` class.

- You may use any exception-related classes.


</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"   checked=true>
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly. Start by creating class and function stubs for ALL the required classes and methods, then implement and test individual classes. The classes have certain dependance on one another so start with the ones that do not depend on anything else. 
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

__For the purpose of grading, your project must be be in the package called `project3`.
This means that each of your submitted source code files should start with a line:__

`package project3;`


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

</div> </div></div>


<div class="wrap-collabsible">
<input id="appendix" class="toggle" type="checkbox"  checked=true>
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

#### `CSV` class - Parsing Lines of the Input File

CSV is a simple file format, but there are many non-standard variations: the field separator, the field delimiter, the special characters allowed in the fields, etc.

You should use the `CSV` class provided below as is or you can modify it if you wish.

-   [`CSV`](project3/project3/CSV.html) class documentation
-   [`CSV.java`](project3/CSV.java) file

If you are not sure how it works, ask questions about it.



#### Sample Interactions

Here are a few sample runs of a program (keep in mind, they are here to illustrate  the user interface, not
to show you examples of tests that the autograder will run on your program).


```
$ java project3.NYS_Taxes New_York_State_Registered_Tax_Preparers.csv
Enter one of the following instructions.
name NAME_KEYWORD
zip ZIP_CODE
city CITY_KEYWORD
quit


Enter your query: 
zip 01301
BURKE, ARTHUR, E
	HRB Tax Group Inc,GREENFIELD, MA, US, 01301

CROMACK, TODD, 
	Poet Seat Associates LLC,GREENFIELD, MA, US, 01301

HOLBROOK, RICHARD, L
	RL Holbrook III & Assoc Inc,GREENFIELD, MA, US, 01301

THIBEAULT, LAURIE, 
	H & R Block,GREENFIUELD, MA, US, 01301

Enter your query: 
city katonah
CAMPOS, VERONICA, A
	TAX ON HUDSON INC,KATONAH, NY, US, 10536

FORTE, LOUIS, 
	Louis Forte,KATONAH, NY, US, 10536

PEREZ SCOTT, JULIA, N
	Matthew Cronin CPA PC,KATONAH, NY, US, 10536

TOM, MICHAEL, A
	POINT B PLANNING LLC,KATONAH, NY, US, 10536

Enter your query: 
name askew
ASKEW, ELIZABETH, C
	Block Advisors,HOUSTON, TX, US, 77096

Enter your query: 
name doo
AIDOO, ABDULAI, 
	ABDULAI AIDOO,BRONX, NY, US, 10458

DOODNAUTH, NITYAN, 
	Nityan Financial Service LLC,RICHMOND HILL, NY, US, 11418

DOOLEY, SHIRLEY, 
	H&R Block,BEAR, DE, US, 19701

DOOLIN, PATRICIA, K
	Block Advisors,GILBERT, AZ, US, 85296

DOOLITTLE, HEAVENLY, 
	BERCORPORATION,WILLIAMSTON, SC, US, 29627

DOOMS BOE, ELNORA, 
	H and R Block,WASHINGTON, DC, US, 20009

DOONEY, EDWARD, M
	TAX ADVISORS GROUP OF LI,ROCKVILLE CENTRE, NY, US, 11570

FELDMAN, SHIRLEY DOON, 
	H&R BLOCK,HICKSVILLE, NY, US, 11801

GUILDOO, DENIS, V
	L & M Associates,MOUNTAIN HOME, AR, US, 72653

KAYDOO, LINCOLN, 
	H&R Block,ORLANDO, FL, US, 32819

VEERAPEN, NAIDOO, R
	NRV Tax and Insurance Services LLC,SOUTH OZONE PARK, NY, US, 11421

Enter your query: 
quit

```

and here is one with several invalid querries 

```
$ java project3.NYS_Taxes New_York_State_Registered_Tax_Preparers.csv
Enter one of the following instructions.
name NAME_KEYWORD
zip ZIP_CODE
city CITY_KEYWORD
quit


Enter your query: 
city 
This is not a valid query. Invalid keyword. Try again.
Enter your query: 
zip 1301
This is not a valid query. Invalid keyword. Try again.
Enter your query: 
getbyName Joanna
This is not a valid query. Try again.
Enter your query: 
quit

```

<br>
<br>
<br>


</div> </div></div>


</main>
