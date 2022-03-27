---
layout: lab
title: Lab
---
<!--
<div class="lab-right" markdown="1">

__due date:__ 7 days from the time you start the lab or
LATEST_DATE
(whichever comes first)

__submission mode:__ group

</div>
-->
<main markdown="1" class="lab">

##  Sorting Algorithms


### Part 1: Running Time Estimates
(Warning: this is a challenging problem and probably the most important one on this lab. Do NOT skip it.)
<br/>

You need to find 1000 most expensive items from an unsorted price list containing $$10^7$$ different items. Two schemes of solution are as follows.

- Scheme A: repeat 1000 times the sequential search (with the linear complexity O(n) ) .

- Scheme B: convert the list into an array (the complexity O(n) ), then sort the array (complexity O(nlogn)) and fetch 1000 top items.

Which scheme is faster?

You run some preliminary experiments  and determined that:
- searching in an unsorted list of 100 items takes on average 0.1 millisecond (ms)
- creating an array out of 100 items takes on average 0.1 millisecond (ms)
- sorting of 100 items takes on average 0.2 millisecond (ms)
- time for fetching data from the consecutive indexes of the array is so small that it can be ignored

Estimate the actual running time expected by each of the two schemes. Show your calculations.
Assume that each price in the list is unique.


### Part 2: Selection Sort

Think of the number of comparisons between elements that are required  when selection sort is applied. How would you count the number of  comparisons if you were sorting 12 elements - figure out the exact number of comparisons. Generalize your calculation to $N$ elements and figure out the exact number of comparisons used for sorting $N$ elements using selection sort.
Use the implementation shown below for your calculations.

```java
public static void selectionSort(double[] list) {
  for (int i = 0; i < list.length - 1; i++) {
    // Find the minimum in the list[i...list.length-1]
    double currentMin = list[i];
    int currentMinIndex = i;
    for (int j = i + 1; j < list.length; j++) {
      if (currentMin > list[j]) {
        currentMin = list[j];
        currentMinIndex = j;
      }
    }
    // Swap list[i] with list[currentMinIndex] if necessary;
    if (currentMinIndex != i) {
      list[currentMinIndex] = list[i];
      list[i] = currentMin;
    }
  }
}
```
### Part 3: Insertion Sort

Think of the number of comparisons between elements that are required  when insertion sort is applied. How would you count the number of  comparisons if you were sorting 12 elements - figure out the exact number of comparisons. Generalize your calculation to $N$ elements and figure out the exact number of comparisons used for sorting $N$ elements using insertion sort.
Use the implementation shown below for your calculations.

```java
public static void insertionSort(double[] list) {
  for (int i = 1; i < list.length; i++) {
      // insert list[i] into a sorted sublist list[0..i-1] so that
      // list[0..i] is sorted.
    double currentElement = list[i];
    int k;
    for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
          list[k + 1] = list[k];
    }

    // Insert the current element into list[k+1]
    list[k + 1] = currentElement;
  }
}
```

### Part 4: Mergesort

Apply the merge sort algorithm to the larger array shown below. Here is a complete solution to a similar, but smaller example. Show the steps.

| Action | 0 | 1 | 2 | 3 | 4|
|:---|:---:|:---:|:---:|:---:|:---:|
| | M | E | R | G | E |
|split after index 2|M | E | R | G | E |
|split after index 1|M | E | R | G | E |
|split after index 0|M | E | R | G | E |
|merge segments 0-0 and 1-1| E | M | R | G | E |
|merge segments 0-1 and 2-2| E | M | R | G | E |
|split after index 3 | E | M | R | G | E |
|merge segments 3-3 and 4-4| E | M | R | E | G |
|merge segments 0-2 and 3-4| E | E | G | M | R |

__Array to sort__


| 0 | 1 | 2 | 3 | 4| 5 |6|7|8|9|10|11|12|13|14|15|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| M | E | R | G | E |S|O|R|T|E|X|A|M|P|L|E|

### Part 5:  Quick sort

Apply the quicksort three separate times to the same array. For the first one the rules for pivot selection, location to which the pivot should be moved and handling of elements equal to the pivot have been chosen. The first couple of steps are shown for that array. Finish that sorting and then change the rules and apply the sort again (make sure you change enough so that the process is really different).  Possible alternative choices are to move the pivot to the first index, to select a pivot based on a different rule, to swap the elements that are equal to the pivot.

- Rule for pivot selection:     middle element of a partition: (first+last)/2

- Rule for where the pivot is moved during partitioning:      swap with last element  in the partition

- Rule for what should happen with elements equal to the pivot:     leave them in place


|Action | 0 | 1 | 2 | 3 | 4| 5 |6|7|8|9|10|11|12|13|14|15|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| | Q| U|I|C|K|S|O|R|T|E|X|A|M|P|L|E|
|move pivot|  Q| U|I|C|K|S|O|__E__|T|E|X|A|M|P|L|__R__|
|partition around R|  Q| L|I|C|K|P|O|E|M|E|A|X|T|S|U|R|
|move pivot to final spot|  Q| L|I|C|K|P|O|E|M|E|A|R|T|S|U|X|
|move pivot in part 0-10|  Q| L|I|C|K|__A__|O|E|M|E|__P__|R|T|S|U|X|
|partition part 0-9 around P|  E| L|I|C|K|A|O|E|M|Q|P|R|T|S|U|X|
|partition part 0-9 around P|  E| L|I|C|K|A|O|E|M|Q|P|R|T|S|U|X|
|move pivot P to final spot|   E| L|I|C|K|A|O|E|M|P|Q|R|T|S|U|X|
| ... |


</main>



<script src="{{ site.baseurl }}/slides/js/image_slides.js"></script>




<script src="https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-AMS_HTML&delayStartupUntil=configured" type="text/javascript"></script>
<script type="text/javascript">
  // var slideshow = remark.create();

  // Setup MathJax
  MathJax.Hub.Config({
      tex2jax: {
      skipTags: ['script', 'noscript', 'style', 'textarea', 'pre'],
        inlineMath: [ ['$','$'], ["\\(","\\)"] ],
        displayMath: [ ['$$','$$'], ["\\[","\\]"] ],
        processEscapes: true
      }
  });

  MathJax.Hub.Configured();
</script>
