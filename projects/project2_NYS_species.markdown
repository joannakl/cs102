---
layout: lab
title: Project 2
---

<div class="lab-right" markdown="1">
__Project 2__ <br>
__due date:__ Feb 21

__submission mode:__ individual

</div>

<main markdown="1" class="lab">

## Project 2: New York State Species

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

<br/><br/>
### Introduction and objectives


<a title="New York State Open Data" href="https://data.ny.gov/">
<img width="300" alt="NYS map logo" src="https://static-assets.ny.gov/sites/all/themes/ny_gov/images/nygov-logo.png" style="float:right; margin:10px"> </a>


In this project you will be working with open data from New York State. Wikipedia has a good description of open data: "Open data is the idea that some data
should be freely available to everyone to use and republish as they wish, without restrictions from copyright, patents or other mechanisms of control."
You will be working with a specific data set published by New York State. It is called _Biodiversity by County - Distribution of Animals, Plants and Natural Communitie_. It contains the locations, distribution and status of species of plants and animals organized by county. 
You can find the complete data set and all the information about it at   [_Biodiversity by County - Distribution of Animals, Plants and Natural Communitie_](https://data.ny.gov/Energy-Environment/Biodiversity-by-County-Distribution-of-Animals-Pla/tk82-7km5/about_data) .

Your program will explore this data set and allow the user to make simple queries about it.
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
<input id="The Data Set" class="toggle" type="checkbox"  checked="true"  >
<label for="The Data Set" class="lbl-toggle">The Data Set</label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You can find the data set [here](https://data.ny.gov/Energy-Environment/Biodiversity-by-County-Distribution-of-Animals-Pla/tk82-7km5/about_data). A copy of the file can also be downloaded from the project2 page on Brightspace. 


Your program should work with a local copy of a file (i.e. a file that is stored on the same machine on which the program is run) whose format matches that of the file that you can download from
the website. The file is a CSV file. This means that entries in a single row are separated by commas. 

Here are a few lines from the file:

```
County,Category,Taxonomic Group,Taxonomic Subgroup,Scientific Name,Common Name,Year Last Documented,NY Listing Status,Federal Listing Status,State Con
servation Rank,Global Conservation Rank,Distribution Status
Albany,Animal,Amphibians,Frogs and Toads,Anaxyrus americanus,American Toad,1990-1999,Game with open season,not listed,S5,G5,Recently Confirmed
Albany,Animal,Amphibians,Frogs and Toads,Anaxyrus fowleri,Fowler's Toad,1990-1999,Game with open season,not listed,S4,G5,Recently Confirmed
Albany,Animal,Amphibians,Frogs and Toads,Hyla versicolor,Gray Treefrog,1990-1999,Game with open season,not listed,S5,G5,Recently Confirmed

```


The first line (which is wrapped) contains the column headings. The columns are separated by a comma.
Every remaining line contains information for a particular species of animals or plants in a particular county (taxonomi group and subgroup, its scientific and common names, its conservation status in NYS, etc). You can find the description of all the columns on the homepage for the data set. 



The file that you download is a CSV (comma separated values) file  - it is a simple text file and is processed
like a text file (but it can also be opened by most of the spreadsheet programs and displayed column-wise based
on the locations of commas on each line). Since some of the columns in a CSV file may contain longer text that
might, optionally, contain commas or newlines as well, those entries are enclosed in a set of double quotes.

<br>

There are 12 columns in the data set. In some rows, some of the entries may be missing.

__From the point of view of this assignment, a valid row in the data set MUST contain__
- county
- category
- taxonomic group 
- taxonomic subgroup
- scientific name
- common name
- NY listing status 

__Any rows that do not contain these seven values should be quietly ignored by the program.__

????? 

CVS class

?????

You can (and should) use the `Parser` class listed in the Appendix to help you with parsing the input file.

</div> </div></div>


<div class="wrap-collabsible">
<input id="interface" class="toggle" type="checkbox"  checked="true"  >
<label for="interface" class="lbl-toggle"> User Interface </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

Your program has to be a console based program (no graphical interface) - this
means that the program should not open any windows or dialog boxes to prompt user
for the input. (Use the `Scanner` class to read the user input.)

</div> </div></div>

<div class="wrap-collabsible">
<input id="usage" class="toggle" type="checkbox"  checked="true"  >
<label for="usage" class="lbl-toggle"> Program Usage </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

The program is started from the command line (or run within an IDE). It expects one command line argument. When the user runs the program, they provide the name of the input
file as a command line argument. (This way the user can specify a different data set - for example data sets from different states or for a subset of counties in NYS, as long as such file follows exactly the same format as the one described in the previous sections.)

If the name of the input file provided as a command line argument is incorrect or the file cannot be
opened for any reason, the program should display an error message and terminate. It should not prompt the user for
an alternative name of the file.

If the program is run without any arguments, the program should display an error message and terminate. It should not prompt the user for the name of the file.

The error messages should be specific and informative, for example:

`    Error: the file NYS_biodiversity.txt cannot be opened.`

or

`    Error: the program expects file name as an argument.`

The above error messages generated by your code should be written to the `System.err` stream (not the
`System.out` stream). If you are not sure what the difference is, research it or ask questions.

</div> </div></div>

<div class="wrap-collabsible">
<input id="user" class="toggle" type="checkbox"  checked="true"  >
<label for="user" class="lbl-toggle"> User Interaction </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


The program should run in a loop that allows the user to get information about 
different species. The user enters a keyword that may be part or whole of the 
scientific or common species name. The program should provide information about 
any species that matches the keyword (if at least one exists). The matching should 
be case-insensitive. For example, if the keyword is "FROG" the common species 
"Gray Treefrog" is a match. 

For each matching species, the program should output the following information:

```
COMMON NAME (SCIENTIFIC NAME)
TAXONOMIC GROUP, TAXONOMIC SUBGROUP
NY LISTING STATUS
present in NUM / 62 counties 
```

All words in uppercase should be replaced by the actual values. NYS has 62 total counties.
NUM is the number of counties in which the species is present. 

If multiple species match the keyword, their output should be separated by a blank line.

If no species matches the keyword, the program should print a message stating so:

```
No matching species found.
```

If the user enters `quit`, the program should terminate. 

__Sample user interaction is shown in the Appendix.__


</div> </div></div>

<div class="wrap-collabsible">
<input id="classes" class="toggle" type="checkbox"  checked="true" >
<label for="classes" class="lbl-toggle"> Data Storage and Organization </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

You need to provide an implementation of several classes that store the data and
compute the results when the program is executed.

**In particular, your program must implement and use the following classes.
You may implement additional classes and additional methods in the required classes, if you wish.**

#### <code class="code_title">Species</code> class

This class should represent a particular species. This means that all the information about that 
species should be stored in the instances of this class. 


- This class should provide a six-argument constructor that validates and sets the required information:
```
	public Species(  String category,
                     String taxonomicGroup,
                     String taxnomicSubGroup,
                     String scientificName,
                     String commonName,
                     String NYListingStatus
                     )
```
	Valid arguments cannot be `null` and they cannot be empty strings.
	If this constructor is called with invalid arguments,  it should throw an instance of the `IllegalArgumentException`  with an appropriate message.

- The class should provide the following accessors (i.e., getters):
	- `public String getCommonName()` 
	- `public String getScientificName()` 
	- `public String getTaxonomicGroup()` 
	- `public String getTaxonomicSubGroup()` 
	- `public String getNYListingStatuse()` 
	- `public String getCategory()` 
    
- The class needs to be able to store a list of counties in which the given species is present. 
The class should provide methods that allow for adding a new county to such a list of counties, 
and for checking if the species is present in a given county:
    - `public boolean isPresentIn( String county )` should return true or false to indicate if the species is present in the specified county; this function should throw an instance of an `IllegalArgumentException` if it is given a `null` value or an empty string in place of the county name. 
    - `public boolean addCounty( String county )` should add this county to the list of counties in which the species is present; it should return true if the list did not contain this particular county before, and false if it did and therefore the list of counties has not changed; this function should throw an instance of an `IllegalArgumentException` if it is given a `null` value or an empty string in place of the county name. 

- The class should override the `equals` method from the `Object` class. Two `Species` objects
	are the same if they have the same values for the common name, scientific name, taxonomic group, taxonomic subgroup and category. The comparison should be case-insensitive. 

- The class should override the `toString` method from the `Object` class. It should
	return a  `String` matching the following pattern:

    ```
    COMMON NAME (SCIENTIFIC NAME)
    TAXONOMIC GROUP, TAXONOMIC SUBGROUP
    NY LISTING STATUS
    present in NUM / 62 counties 
    ```

    All words in uppercase should be replaced by the actual values. NYS has 62 total counties.
    NUM is the number of counties in which the species is present. 

- The class should implement `Comparable<Species>` interface. The two `Species` objects should be compared
    based on their common names, and, if the common names are the same (unlikely), then they should be compared by their scientific names to resolve the ties (these are guaranteed to be unique). All comparisons should be case-insensitive.

#### <code class="code_title">SpeciesList</code> class
The `SpeciesList` class should be used to store all the `Species` objects.
This class should inherit from the   `ArrayList<Species>` class.

- The class needs to provide a default constructor that creates an empty `SpeciesList` object.

In addition, the class should implement the following two methods:

- `public void add( Species species, String county ) ` 

    This method adds the species to the list. If the species is already present in the list,
    the list of counties in which it is present should be modified to include the specified 
    county. If the species is not present in the list yet, then it should be added with the 
    specified county being the first county in its own list of counties within which it is present. 
    
    This method should throw and instance of IllegalArgumentException if the `species` is `null`, or if 
    the `county` is `null` or an empty string. 

- `public SpeciesList getByName ( String keyword )  `

	This method should return a list of all `Species` objects for which the names (either common name, or scientific name) __contain__ the
  `keyword`. The keyword comparison should be done in a case-insensitive way.
	The returned list should be sorted according to the natural ordering of the elements (i.e., dictated
	by the `compareTo` method defined in the `Species` class).
	If `keyword` is `null` or an empty string, this method
	should throw an instance of `IllegalArgumentException` with an appropriate message.

	If there are no elements in the list that match the given criteria, this method should return `null`.


#### <code class="code_title">NYSpecies</code> class
The `NYSpecies` class is the actual program. This is the class that should contain the `main` method.
It is responsible for opening and reading
the data file, obtaining user input, performing some data validation and handling
all errors that may occur (in particular, it should handle any
exceptions thrown by your other classes and terminate gracefully, if need be, with
a friendly error message presented to the user: __The program should never just reprint the
exception message as a way of handling an exception. These messages are rarely
readable to the ordinary user and make it seem like the program crashed in response to the exception.__

You may implement other methods in this class to modularize the design.

</div> </div></div>

<div class="wrap-collabsible">
<input id="rules" class="toggle" type="checkbox"  checked="true"  >
<label for="rules" class="lbl-toggle"> Programming Rules </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


- You should follow the rules outlined in the document
[Code conventions](https://cs.nyu.edu/~joannakl/cs102/notes/CodeConventions.pdf).

- The data file should be read only once! Your program needs to store the data
in memory resident data structures.

- You may not use any of the collection
classes that were not covered in cs101 (for this assignment, do not use `LinkedList`, `Stack`, `Queue`, `PriorityQueue`, or any classes implementing the `Map` interface). You can, and should, use the `ArrayList` class.

- You may use any exception-related classes.

- You may use any classes to handle the file I/O, but probably the simplest ones
are `File` and `Scanner` classes. You are responsible for knowing how to use the classes that you select.

</div> </div></div>

<div class="wrap-collabsible">
<input id="working" class="toggle" type="checkbox"  checked="true"  >
<label for="working" class="lbl-toggle"> Working on This Assignment </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

- __You should start right away!__
- You should modularize your design so that you can test it regularly: for example, implement the part of the code that reads and parses the input file, then implement and test individual classes, then implement the part that provides the interactive part of the program, ... .
- You can base your implementaion on the project 1 code as much as you wish. If you are copying some parts of project 1 verbatim (and you can in some cases), then you should make sure that you acknowledge it as the source of your code. 
- Make sure that at all times you __have a working program!__
You should also implement stubs of methods that return `0` or `null`. This way your code compiles, even though it may
not work completely because some methods are not implemented.  You can implement methods that perform one task at a time.
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
<input id="grading" class="toggle" type="checkbox"  checked="true"  >
<label for="grading" class="lbl-toggle"> Grading </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>


If your program does not compile or if it crashes (almost) every time it is run without producing any results,
you will get a zero on the assignment. Make sure that you are submitting
functioning and documented code, even if it is not a complete implementation so that you can get partial credit. 
__Read the results shown by Gradescope. If the information there states the that program did not compile or failed to run, or was terminated because it run too long, or ..., then this is what the graders will see and they will assign a automatic zero.__ 


The grade will be determined by several factors:
- 60 points: class correctness: correct behavior of methods of the required classes and correct behavior of the program as a whole (this will be determined by the autograder and some manual evaluation) - again, read the output from the autograder to see how you are doing on this part
- 20 points: design and the implementation of the required classes and any additional classes
   (this will be determined by a code review)
- 20 points: proper documentation, program style and format of submission
   (this will be determined by a code review)

</div> </div></div>


<div class="wrap-collabsible">
<input id="submit" class="toggle" type="checkbox"  checked="true" >
<label for="submit" class="lbl-toggle"> How and What to Submit </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>

__For the purpose of grading, your project must be be in the package called `project2`.
This means that each of your submitted source code files should start with a line:__

`package project2;`


Your should submit all your source code files (the ones with `.java` extensions only) to Gradescope.
 __DO NOT__ submit `.class` files
or any project files that your IDE or operating system might produce. __DO NOT__ submit the data file or any of your test files. __You can see all the files on Gradescope. .__
Verify that there is nothing there that you did not intend to put it. 

Gradescope accepts individual files and zip files. You can upload whichever one you want. (But if, when you produce a zip file, there are other files included in it, make sure to remove them before or during the submission.)

You may resubmit to Gradescope as many times as you wish before the submission link closes. But if you resubmit
after the grace period ends, your assignment will be subject to the late point deductions unless you opt to use your freebie days.

For this project, you will see ALL of the results for the autograded unit tests. This will not be
the case in future assignments.


</div> </div></div>


<div class="wrap-collabsible">
<input id="appendix" class="toggle" type="checkbox"  checked="true" >
<label for="appendix" class="lbl-toggle"> Appendix </label>
<div class="collapsible-content" markdown=1>
<div class="content-inner" markdown=1>



#### `CSV` class - Parsing Lines of the Input File

CSV is a simple file format, but there are many non-standard variations: the field separator, the field delimiter, the special characters allowed in the fields, etc.

You should use the `CSV` class provided below as is or you can modify it if you wish.

-   [`CSV`](project2/project2/CSV.html) class documentation
-   [`CSV.java`](project2/project2/CSV.java) file

If you are not sure how it works, ask questions about it and experiment with it outside of the context of the project.



#### Sample Interactions

Note: this sample used a subset of the data set, not the entire data set. 
It is here to illustrate the format of the output and the interaction. You should 
not try to match the results shown below. 

```
Enter the keyword to search through species names, or "quit" to stop:
rough aster
Rough Aster (Eurybia radula)
Flowering Plants, Asters, Goldenrods and Daisies
Endangered
present in 5 / 62 counties

Enter the keyword to search through species names, or "quit" to stop:
PANIC GRASS
Beaked Panic Grass (Coleataenia anceps ssp. anceps)
Flowering Plants, Grasses
Endangered
present in 4 / 62 counties

Stalked Panic Grass (Coleataenia stipitata)
Flowering Plants, Grasses
Endangered
present in 3 / 62 counties

Tall Dune Panic Grass (Panicum amarum var. amarum)
Flowering Plants, Grasses
Rare
present in 3 / 62 counties

Enter the keyword to search through species names, or "quit" to stop:
dog
Delicate Rabbit Tobacco (Pseudognaphalium micradenium)
Flowering Plants, Asters, Goldenrods and Daisies
Endangered
present in 4 / 62 counties

Rough-leaved Dogwood (Cornus drummondii)
Flowering Plants, Other Flowering Plants
Endangered
present in 4 / 62 counties

Enter the keyword to search through species names, or "quit" to stop:
joe
Coastal Plain Joe Pye Weed (Eutrochium dubium)
Flowering Plants, Asters, Goldenrods and Daisies
Rare
present in 6 / 62 counties

Enter the keyword to search through species names, or "quit" to stop:
coffee
Kentucky Coffee Tree (Gymnocladus dioicus)
Flowering Plants, Other Flowering Plants
Endangered
present in 6 / 62 counties

Enter the keyword to search through species names, or "quit" to stop:
milk
Canada Milk Vetch (Astragalus canadensis var. canadensis)
Flowering Plants, Other Flowering Plants
Endangered
present in 15 / 62 counties

Cooper's Milkvetch (Astragalus neglectus)
Flowering Plants, Other Flowering Plants
Endangered
present in 12 / 62 counties

Cross-leaved Milkwort (Polygala cruciata)
Flowering Plants, Other Flowering Plants
Rare
present in 5 / 62 counties

Orange Milkwort (Polygala lutea)
Flowering Plants, Other Flowering Plants
Endangered
present in 6 / 62 counties

Twining Milk Pea (Galactia regularis)
Flowering Plants, Other Flowering Plants
Endangered
present in 5 / 62 counties

White Milkweed (Asclepias variegata)
Flowering Plants, Other Flowering Plants
Endangered
present in 9 / 62 counties

Enter the keyword to search through species names, or "quit" to stop:
bluestem
Bushy Bluestem (Andropogon glomeratus var. glomeratus)
Flowering Plants, Grasses
Rare
present in 4 / 62 counties

Dune Bluestem (Schizachyrium littorale)
Flowering Plants, Grasses
Rare
present in 6 / 62 counties

Enter the keyword to search through species names, or "quit" to stop:
deer
No matching species found.

Enter the keyword to search through species names, or "quit" to stop:
cat
Bristly Spiked Lobelia (Lobelia spicata var. hirtella)
Flowering Plants, Other Flowering Plants
Endangered
present in 3 / 62 counties

Cat-tail Sedge (Carex typhina)
Flowering Plants, Sedges
Endangered
present in 20 / 62 counties

Coastal Plain Blue-eyed Grass (Sisyrinchium fuscatum)
Flowering Plants, Other Flowering Plants
Endangered
present in 4 / 62 counties

Delicate Rabbit Tobacco (Pseudognaphalium micradenium)
Flowering Plants, Asters, Goldenrods and Daisies
Endangered
present in 4 / 62 counties

Navel Cornsalad (Valerianella umbilicata)
Flowering Plants, Other Flowering Plants
Endangered
present in 4 / 62 counties

Sickle-leaved Golden Aster (Pityopsis falcata)
Flowering Plants, Asters, Goldenrods and Daisies
Rare
present in 5 / 62 counties

Spiked Wood Rush (Luzula spicata ssp. spicata)
Flowering Plants, Rushes
Endangered
present in 1 / 62 counties

Weft Fern (Crepidomanes intricatum)
Ferns and Fern Allies, Ferns
Endangered
present in 6 / 62 counties

Enter the keyword to search through species names, or "quit" to stop:
quit
```

<br>
<br>
<br>


</div> </div></div>


</main>
