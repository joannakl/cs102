---
layout: lab
title: Project 3
---

<div class="lab-right" markdown="1">
__Project 3__ <br>
__due date:__ October 29

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 3: Implementing Lists, Stacks and Queues

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


<br/><br/>
### Introduction and objectives

In this project you __will not__ be writing a complete program. Instead, you will be developing
classes that implement given interfaces. In order to check the correctness of your implementation
you should create your own programs that use your classes and test each of the implemented methods carefully.

<br/><br/>

The goal of this programming project is for you to master (or at least
get practice on) the following tasks:


- writing classes
- implementing interfaces
- implementing your own linked list
- implementing your own stack
- implementing your own queue
- testing your own code

**Start early!** This project may not seem like much work, but
debugging always takes time.



<div class="wrap-collabsible">
<input id="list" class="toggle" type="checkbox" >
<label for="list" class="lbl-toggle"> Linked list </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Doubly linked list

```java
// List  ADT
public interface List<E> {

	// adds an element 'it' at position pos, shifts elements starting at pos by
	// one position to the right (higher position values)
	// throws NoSuchElementException if pos < 0 or pos >= size
	public boolean add(E item, int pos) throws NoSuchElementException;

	// removes and returns an element at position pos, shifts elements starting
	// at pos+1 by one to the left (lower position values)
	// throws NoSuchElementException if pos < 0 or pos >= size
	public E remove(int pos) throws NoSuchElementException;


	public boolean remove (E item);

	// determines if 'it' is in the list and if so returns its position,
	// otherwise returns -1
	public int find (E item) ;

	// retrieves and returns an item from position pos
	// throws NoSuchElementException if pos < 0 or pos >= size
	public E get( int pos) throws NoSuchElementException;

	// returns the current number of elements in the list
	public int size();

	// removes all elements from the list, so it is once again empty
	public void clear();

	public boolean equals(Object obj);

	public String toString ();
}

```

</div> </div></div>



<div class="wrap-collabsible">
<input id="stack" class="toggle" type="checkbox" >
<label for="stack" class="lbl-toggle"> Stack </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Singly linked reference based stack.

```java
public interface Stack<E> {
  /** Add an element to the top of this stack
   * @param item character to be added to the stack
   */
  public void push ( E item ) ;

  /** Remove and return the element from the top of this stack
   * @return the element from the top of the stack or null if the stack is empty
   *   from the stack. If stack is empty, null is returned.
   */
  public E pop () ;

  /** Return the element from the top of this stack.
   * @return  the element from the top of the stack or null if the stack is empty
   */
  public E peek () ;


	public boolean equals(Object obj);

  /** Produces string representation of this stack.
   * @return Returns a String object that contains all elements stored on the stack.
   *   The elements are separated by spaces. The top of the stack is the rightmost
   *   element in the returned string.
   */
  public String toString () ;
}
```

</div> </div></div>



<div class="wrap-collabsible">
<input id="queue" class="toggle" type="checkbox" >
<label for="queue" class="lbl-toggle"> Queue </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Array-based queue

```java
public interface Queue<E> {
  /** Add an element to the queue.
    * @param item  an element to be added to the queue
    */
  public void enqueue ( E item ) ;

  /** Remove and return the element from the front of the queue
    * @return the element from the front of the queue or null if queue is empty
    */
  public E dequeue () ;

  /** Return the element from the front of the queue
    * @return the element from the front of the queue or null if queue is empty
    */
  public E peek () ;


	public boolean equals(Object obj);

  /** Compute a string representation of the queue.
    * @return String object representing the queue. The string should contain the
    * current list elements in the queue one per line.
    */
  public String toString () ;
}

```


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


#### Sample Interactions

Here are a few sample runs of a program with much reduced input file to illustrate  the user interface.

```


	Search the database by using one of the following queries.
	  To search for meteorite nearest to a given goe-location, enter
	        location LATITUDE LONGITUDE
	  To search for meteorites that fell in a given year, enter
	        year YEAR
	  To search for meteorites with weights MASS +/- 10 grams, enter
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
	  To search for meteorite nearest to a given goe-location, enter
	        location LATITUDE LONGITUDE
	  To search for meteorites that fell in a given year, enter
	        year YEAR
	  To search for meteorites with weights MASS +/- 10 grams, enter
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

</div> </div></div>


</main>
