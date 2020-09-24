---
layout: lab
title: Lab
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__due date:__ October 8

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 2: Finding Fallen Stars

<hr>

<div class="emph" markdown=1>
You may discuss any of the assignments with your classmates and tutors (or anyone else) but <span class="red"> all work for all assignments must be
entirely your own</span>. Any sharing or copying of assignments will be considered cheating (this includes posting of partial or complete
solutions on Ed, GitHub or any other public forum). If you get significant help from anyone, you should acknowledge it in
your submission (and your grade will be proportional to the part that you completed on your own). You are responsible for
every line in your program: you need to know what it does and why. You should not use any data structures and features of Java
that have not been covered in class (or the prerequisite class). If you have doubts whether or not you are allowed to use certain
structures, just ask your instructor.
</div>

---


<a title="NASA/Planetary Science / Public domain" href="https://commons.wikimedia.org/wiki/File:SmallAsteroidImpacts-Frequency-Bolide-20141114.jpg"><img width="400" alt="SmallAsteroidImpacts-Frequency-Bolide-20141114" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7b/SmallAsteroidImpacts-Frequency-Bolide-20141114.jpg/512px-SmallAsteroidImpacts-Frequency-Bolide-20141114.jpg" style="float:right; margin:10px"></a>

<br/><br/>
### Introduction and objectives
Every year there are numerous meteorites entering Earth's atmosphere. In this project, you will design
a tool for _finding_ these fallen stars (or rather finding locations at which they were found for the first time).
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

In this project you will be working with open data. Wikipedia has a good description of open data: "Open data is the idea that some data
should be freely available to everyone to use and republish as they wish, without restrictions from copyright, patents or other mechanisms of control."

The data set that you need can be found at
NASA's Open Data site. The specific data set is called
[Meteorite Landing](https://data.nasa.gov/Space-Science/Meteorite-Landings/gh4g-9sfh).
For your convenience a csv file is also located on [the course website](Meteorite_Landings.csv) (right click to download).
It contains information on all of the known meteorite landings on Earth. It was last updated in June of 2018.

The file that you download is a CSV (comma separated values) file  - it is a simple text file and is processed
like a text file (but it can also be opened by most of the spreadsheet programs and displayed column-wise based
on the locations of commas on each line). Since some of the columns in a CSV file may contain longer text that
might, optionally, contain commas as well, those entries are enclosed in a set of double quotes.

There are ten columns in the Meteorite Landing dataset. Some of the columns may be empty.

<img src="img/data_proj2.png" style="max-width:100%;">

__From the point of view of this assignment, a valid row in the data set MUST contain the name and id values.
Any rows that do not contain these two values should be quietly ignored by the program.__

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
from a particular range of years, or geographic location).

The user may start the program from the command line or run it within an IDE like
Eclipse - __from the point of view of your program this does not matter__.

If the name of the input file provided as a command line argument is incorrect or the file cannot be
opened for any reason, the program should display an error message and terminate. It should not prompt the user for
an alternative name of the file.

If the program is run without any arguments, the program should display an error message and terminate. It should not prompt the user
for the name of the file.

The error messages should be specific and informative, for example:

`    Error: the file meteorites.csv cannot be opened.`

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

- `location LATITUDE LONGITUDE`
- `year YEAR`
- `mass MASS`

In the above, the words in uppercase indicate keywords that will be replaced by
actual values, for example `mass 200` or `location 50.7 6.08`.

In the first case, `location LATITUDE LONGITUDE`, the program should display the
meteorite whose landing site location is closest to the one specified by the user.

In the second case, `year YEAR`,  the program should display the list of all meteorites
that have landed during that year. The results should be displayed in alphanumeric
order of the names.

In the third case, `mass MASS`,  the program should display the list of all meteorites
whose mass is within 10 grams of the user specified `MASS` (in grams).
The results should be displayed in alphanumeric order of the names.

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




__Matching results display:__
If the query entered by the user matches one or more meteorite, the information  should be displayed in the following format:

```
NAME ID YEAR MASS LATITUDE LONGITUDE
```

All the words in uppercase letters are place-holders for the actual values from the data set.
Each of the values should be printed within a field of specified width and using specified alignment
(see below) and there should be one space between those fields.
The LATITUDE and LONGITUDE should be displayed with exactly 5 digits after the decimal point.

field | width |  alignment
---|---|---
NAME | 20 | left
ID | 4 | right
YEAR | 4 | right
MASS | 6 | right
LATITUDE | 10 | right
LONGITUDE | 10 | right

If any of the values is missing, it should be left blank in the result.



__Sample interaction:__

Sample user interaction is shown in Appendix 2.


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

This class should represent the location (latitude, longitude).

- This class should provide a two parameter constructor that validates and sets the latitude and longitude:

	`public Location (double latitude, double longitude);`

	A valid latitude should be a number in the range [-90.0, 90.0] (inclusive on both ends).
	A valid longitude should be a number in the range [-180.0, 180.0] (inclusive on both ends).
	If this constructor is called with invalid parameters, it should throw an instance of
	`IllegalArgumentException` with an appropriate message.

	WARNING: make sure that you do not reverse the parameters.

	There should be no default constructor.

- This class should provide `getDistance` method that computes and returns distance between this location
and the one provided as the parameter.

	`double getDistance( Location loc )`

	If this function is called with null parameter, it should throw an instance of
	`IllegalArgumentException` with an appropriate message.

	The [Haversine formula](https://en.wikipedia.org/wiki/Haversine_formula) determines the distance
	between two points on a sphere given their latitudes and longitudes. There are many sites that
	provide a Java implementation of that formula. You can find one such implementation
	in the Appendix: [Haversine formula implementation](#haversine-formula-implementation)


- It should provide the accessor methods `getLatitude()` and `getLongitude()`.

- It should override the `equals` method from the `Object` class. Two `Location` objects `l1` and `l2` should
be considered equal if the following is true
	- abs(l1.latitude - l2.latitude) < 0.00001
	- abs(l1.longitude - l2.longitude) < 0.00001

	(where abs() stands for absolute value).

#### <code class="code_title">Meteorite</code> class

This class should represent a meteorite with all of its characteristics.

- This class should provide a two parameter constructor that validates and sets the name and id:

	`public Meteorite (String name, int id)`

	Any non-empty string is a valid name. A valid id should be a number greater than zero.
	If this constructor is called with invalid parameters, it should throw an instance of
	`IllegalArgumentException` with an appropriate message.

	There should be no default constructor.

- This class should provide the following mutator and accessor methods. The mutator
	methods should validate the data according to the specification below. If any values are invalid,
	the method should throw an instance of 	`IllegalArgumentException` with an appropriate message.
	- `public void setMass(int mass)`, `public int getMass()` - a valid mass should be a positive integer
	- `public void setYear(int year)`, `public int getYear()` - a valid
		year should be a positive integer smaller than the current year
	- `public void setLocation(Location loc)`, `public Location getLocation()`

- The class should implement `Comparable<Meteorite>` interface. The two `Meteorite` objects should be
	compared based on their alphanumeric names ("aaaba" is smaller, or comes before, "bacd").
	If two names are the same, the comparison should be performed
	based on the numeric id's. The comparison by names should be case insensitive.

- The class should override the `equals` method from the `Object` class. Two `Meteorite` objects
	are he same if they have identical names (case of letters does not matter) and id's.

- The class should override the `toString` method from the `Object` class. It should
	return a `String` matching the following pattern

	`NAME ID YEAR MASS LATITUDE LONGITUDE`

	All the words in uppercase letters are place-holders for the actual values from the data set.
	Each of the values should be printed within a field of specified width and using specified alignment
	(see below) and there should be one space between those fields.
	The LATITUDE and LONGITUDE should be displayed with exactly 5 digits after the decimal point.

	field | width |  alignment
	---|---|---
	NAME | 20 | left
	ID | 4 | right
	YEAR | 4 | right
	MASS | 6 | right
	LATITUDE | 10 | right
	LONGITUDE | 10 | right

	If any of the values is missing, it should be left blank in the result.

#### <code class="code_title">MeteoriteList</code> class
The `MeteoriteList` class should be used to store all the `Meteorite` objects.
This class should inherit from the   `ArrayList<Meteorite>` class.

- The class needs to provide a default constructor that creates an empty `MeteoriteList` object.

In addition, the class should implement the following two methods:

- `public MeteoriteLinkedList getByMass ( int mass, int delta)  `

	This method should return a list of all `Meteorite` objects with mass within `delta` grams of the
	specified `mass`. Both values are specified in grams.
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `comparaTo` method defined in the `Mereorite` class).
	If either value is less than zero, the method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.

- `public Meteorite getByLocation ( Location loc)   `

	This method should return a `Meteorite` object whose landing site is  nearest to the specified location `loc`.
	If `loc` is null, the method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If the current list is empty, this method should return `null`.

- `public MeteoriteLinkedList getByYear ( int year)  `

	This method should return a list of all `Meteorite` objects that landed on Earth
	on the `year` specified.
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `comparaTo` method defined in the `Mereorite` class).
	If the value of `year` is less than zero, the method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.



#### <code class="code_title">MeteoriteLinkedList</code> class

The `MeteoriteLinkedList` class should provide an implementation of a simple __sorted singly
linked list__.

The class should use an inner private class to define the `Node`:

{% highlight java linenos %}
private class Node implements Comparable<Node> {
	Meteorite data;
	Node next;

	Node ( Meteorite data ) {
		this.data = data;
	}

	public String toString () {
		return data.toString();
	}

	public boolean equals( Object o ) {
		if (this == o) return true;
		if (!(o instanceof Node)) {
			return false;
		}
		Node other = (Node) o;
		if (!this.data.equals(other.data)) {
			return false;
		}
		return true;
	}

	public int compareTo (Node n ) {
		return data.compareTo(n.data);
	}
}
{% endhighlight %}

This class should implement the following constructors:
- the default constructor that instantiates an empty list
- a one parameter constructor <br>
  `public MeteoriteLinkedList ( MeteoriteList list ) ;` <br>
  that given a `MeteoriteList` objects produces a `MeteoriteLinkedList` object
  with the same elements. If `list` is null, the constructor should throw
  an instance of `IllegalArgumentException`.

The class should implement the following `public` methods:
- `boolean add ( Meteorite m)` <br>
	This method adds a new element to this list. If `m` is already present in the list (i.e.,
	an element that is equal to `m` exists), no new 	object should be added
	or modified. The return value indicates if the list changed as the result
	of this operation. This method should throw an instance of `IllegalArgumentException`
	if it is called with `null` as the parameter.
- `Meteorite remove (String name, int id)` <br>
	This method removes and returns an element matching the `name` and `id` specified.
	If there is no matching element, this method should return `null`.
- `String toString()` <br>
	This method returns a `String` object that represents this list.
	The string should contain all the elements of the list in order one per line.
	Each `Meteorite` object should be represented according to its own `toString` method.

__Notes:__
- this should not be a generic class (you'll get a chance to implement generic classes later)
- this list should be in sorted order at all times

#### <code class="code_title">FallenStars</code> class
The `FallenStars` class is the actual program. This is the class that should contain the `main` method.
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
[Code conventions](https://cs.nyu.edu/~joannakl/cs102_f20/notes/CodeConventions.pdf)
posted on the course website.

- The data file should be read only once! Your program needs to store the data in memory resident data structures.

- You may not use any of the collection
classes that were not covered in cs101 (for this assignment, do not use `LinkedList`, `Stack`, `Queue`, `PriorityQueue`, or any classes implementing the `Map` interface). You can, and should, use the `ArrayList` class.

- You must implement the `MeteoriteLinkedList` class from scratch.
You cannot use any of the built-in Java classes as its base class.

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
functioning code, even if it is not a complete implementation so that you can get partial credit.

If the program does not adhere to the specification, the grade will be low and
will depend on how easy it is to figure out what the program is doing and how to work with it.

The grade will be determined by several factors:
- 40 points: class correctness: correct behavior of methods of the required classes and correct behavior of the program
	as a whole (this will be determined by the autograder and some manual evaluation)
- 30 points: design and the implementation of the required classes and any additional classes
   (this will be determined by a code review)
- 20 points: proper documentation, program style and format of submission
   (this will be determined by a code review)
- 10 points: academic honesty questionnaire - taken in the form of an online quiz


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
or any project files that your IDE might produce.

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

#### Haversine formula implementation

Source: [Geeks for Geeks](https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/)

To use this code, you will need to adapt it to your own implementation of the
`Location` class.

{% highlight java linenos %}
static double haversine(double lat1, double lon1,
			double lat2, double lon2)
{
	// distance between latitudes and longitudes
	double dLat = Math.toRadians(lat2 - lat1);
	double dLon = Math.toRadians(lon2 - lon1);

	// convert to radians
	lat1 = Math.toRadians(lat1);
	lat2 = Math.toRadians(lat2);

	// apply formulae
	double a = Math.pow(Math.sin(dLat / 2), 2) +
			   Math.pow(Math.sin(dLon / 2), 2) *
			   Math.cos(lat1) *
			   Math.cos(lat2);
	double rad = 6371;
	double c = 2 * Math.asin(Math.sqrt(a));
	return rad * c;
}
{% endhighlight %}

#### Parsing CSV files

You may use this code as is in your program.

{% highlight java linenos %}
/**
 * Splits the given line of a CSV file according to commas and double quotes
 * (double quotes are used to surround multi-word entries so that they may contain commas)
 * @author Joanna Klukowska
 * @param textLine  a line of text from a CSV file to be parsed
 * @return an ArrayList object containing all individual entries found on that line;
 *  any missing entries are indicated as empty strings; null is returned if the textline
 *  passed to this function is null itself.
 */
public static ArrayList<String> splitCSVLine(String textLine){

	if (textLine == null ) return null;

	ArrayList<String> entries = new ArrayList<String>();
	int lineLength = textLine.length();
	StringBuffer nextWord = new StringBuffer();
	char nextChar;
	boolean insideQuotes = false;
	boolean insideEntry= false;

	// iterate over all characters in the textLine
	for (int i = 0; i < lineLength; i++) {
		nextChar = textLine.charAt(i);

		// handle smart quotes as well as regular quotes
		if (nextChar == '"' || nextChar == '\u201C' || nextChar =='\u201D') {

			// change insideQuotes flag when nextChar is a quote
			if (insideQuotes) {
				insideQuotes = false;
				insideEntry = false;
			}
			else {
				insideQuotes = true;
				insideEntry = true;
			}
		}
		else if (Character.isWhitespace(nextChar)) {
			if ( insideQuotes || insideEntry ) {
				// add it to the current entry
				nextWord.append( nextChar );
			}
			else { // skip all spaces between entries
				continue;
			}
		}
		else if ( nextChar == ',') {
			if (insideQuotes){ // comma inside an entry
				nextWord.append(nextChar);
			}
			else { // end of entry found
				insideEntry = false;
				entries.add(nextWord.toString());
				nextWord = new StringBuffer();
			}
		}
		else {
			// add all other characters to the nextWord
			nextWord.append(nextChar);
			insideEntry = true;
		}

	}
	// add the last word ( assuming not empty )
	// trim the white space before adding to the list
	if (!nextWord.toString().equals("")) {
		entries.add(nextWord.toString().trim());
	}

	return entries;
}
{% endhighlight %}

</div> </div></div>


</main>
