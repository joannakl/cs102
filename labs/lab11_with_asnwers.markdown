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


## BSTs, Binary Heaps, Graphs, Hash Tables, ... 

### Part 1 Solving Problems

#### Problem 1

Assume that the array representing a min binary heap contains the values 2, 8, 3, 10, 16, 7, 18, 13, 15. Show the contents of the array after inserting the value 4. Show the tree representation of this heap.

#### Problem 2

Assume that the array representing a min binary heap contains the values 2, 8, 3, 10, 16, 7, 18, 13, 15. Show the contents of the array after deleting the minimum element. Show the tree representation of this heap.

#### Problem 3

In a min binary heap with N elements, what is the range of indices in which the largest element should be located?

#### Problem 4

Which of the arrays represents a binary heap?

<pre>
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

[10, 9, 5, 8, 3, 4, 2, 7, 8, 1, 2, 6 ]

[3, 9, 7, 10, 12, 8, 9, 6, 7, 15, 17]
</pre>


#### Problem 5

Assume that the initial size of an array to store the hashtable is 7. Five 
(key, value) pairs were just added to the hash table and resulted in a single 
collision.

- What is the load factor if the linear probing is used as a collision resolution method? 

- What is the load factor is separate chaining is used as a collision resolution method? 


#### Problem 6

Assume that 
- initial size of an array used to store a hashtable is 11,
- the collision resolution method used is separate chaining with a linked list 
- the load factor is 0.75 
- if a new element is added to a hashtable that would increase the load factor to be equal to or greater than 0.75, a new array is allocated with a size equal to the `2*old_size+1` 

Show the array that stores this hash table after the following key-value pairs are added:

- (10, "hello")
- (21, "start")
- (3, "bingo")
- (5, "compsci")
- (10, "ai")
- (16, "brain")
- (38, "power")
- (36, "fluent")
- (65, "lab")
- (12, "finished") 

__Answer__

- (10, "hello")

`10 % 11 = 10`, so index for this pair is 10 

```
index   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
element |   |   |   |   |   |   |   |   |   |   |  | |
                                                   |
                                                 (10, "hello") 
```

load factor = 1/11

- (21, "start")

`21 % 11 = 10`, so index for this pair is also 10 

Note that Java's `Hashtable` code add the new pair at the start of the _chain_. 

```
index   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
element |   |   |   |   |   |   |   |   |   |   |  | |
                                                   |
                                                (21, "start") 
                                                   |
                                                (10, "hello") 
```

load factor = 2/11

- (3, "bingo")

`3 % 11 = 3`, so index for this pair is 3 

```
index   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
element |   |   |   | | |   |   |   |   |   |   |  | |
                      |                            |
                    (3, "bingo")                (21, "start") 
                                                   |
                                                (10, "hello") 
```

load factor = 3/11


- (5, "compsci")

`5 % 11 = 5`, so index for this pair is 3 

```
index   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
element |   |   |   | | |   | | |   |   |   |   |  | |
                      |       |                    |
                  (3, "bingo")|                 (21, "start") 
                              |                    |
                          (5, "compsci")        (10, "hello") 
```

load factor = 4/11
                    
- (10, "ai")

A pair with key equal to 10 already exists. So its value is 
modified from "hello" to "ai".

```
index   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 
element |   |   |   | | |   | | |   |   |   |   |  | |
                      |       |                    |
                  (3, "bingo")|                 (21, "start") 
                              |                    |
                          (5, "compsci")        (10, "ai") 
```

load factor = 4/11

- (16, "brain")
- (38, "power")
- (36, "fluent")
- (65, "lab")
- (12, "finished") 


#### Problem 7

Consider a different representation of a graph described below:

A simple undirected graph is an ordered pair G = (V, E) where V is a non-empty set of vertices, and
E is a set of unordered pairs (u, v) where u and v are in V and u != v. If S is a set, define |S| as the
size of S. An incidence matrix M is a |V|x|E| matrix where M (i, j) is 1 if edge j is incident to vertex
i (edge j is either (i, u) or (u, i)) and 0 otherwise.
Given an `n x m` matrix, decide if it can  be an incidence matrix of a simple undirected graph G = (V, E) where |V| = `n` and |E| = `m`

`n = 3, m = 3`
```
1 1 0
0 1 1
1 0 1
```

`n = 3, m = 3`
```
1 1 0
1 1 1
1 0 0
```

`n = 5, m = 7`
```
1 1 0 0 1 0 0
1 0 1 0 1 0 0
0 0 0 1 0 1 0
0 0 1 1 0 0 1
0 1 0 0
```
    
`n = 5, m = 7`
```
1 1 0 0 1 0 0
1 0 1 0 0 0 0
0 0 0 1 0 1 0
0 0 1 1 1 0 1
0 1 0 0 1 1 1
```

#### Problem 8

Consider the `PriorityQueue.java` file from Java API. This class provides an implementation of a priority queue (very much like the one we discussed in class).
There is a `heapify()` method in that class that is used to establish the heap properties for the data stored in the underlying array.
Answer the following questions after studying the `heapify()` method and some other parts of the `PriorityQueue` class.

- The method  `heapify()` is private. Determine which public methods make use of it (directly or indirectly). Describe what situation requires the use of this method.

- Assume that the array used for storage in the `PriorityQueue` class contains the following elements and the `size` variable is equal to 9.

  ```
  [45  36   89   50  12  72  95  20  5 ]

  ```

  Show the content of the array after each iteration of the for loop in the  `heapify()`  method.
  Assume that the elements are of type `Integer` and therefore implement `Comparable<Integer>` interface which is used to determine the relationship between elements (this means you can assume that `comparator == null` is always true.

#### Problem 9

Hackerearth is one of the websites on which you can test your skills of solving problems. For this problem, go to [https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/practice-problems/algorithm/monk-and-his-friends/](https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/practice-problems/algorithm/monk-and-his-friends/)  and try to solve the _Monk and His Friends_ problem. Make sure to read the instructions carefully and understand the sample input and output for the problem before you start coding.

Write your code on your computer or in an Ed workspace shared by your group members, so that you do not lose it in case the website reloads.

HINT: you should use [`TreeSet<E>`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/TreeSet.html) class in this problem. It implements a balanced binary search tree that does not allow duplicates.

Once you finish your code, submit it on the website to be tested. Take a screenshot of the test results and submit it for this problem on Gradescope. It will be challenging to pass all the tests, but you should be able to pass at least the first few. You should submit a screenshot with the results even if you pass only small portion of the tests.

If you pass all the tests, try to work on other binary search tree related problems on Hackerearth.



### Part 2: Be the Grader

#### Problem 1

In this question, you are asked to analyze incorrect solutions to the problem and explain what is wrong with them. Be as detailed as possible in explaining why the solution is incorrect. Do not simply propose an alternative solution.

__Problem Statement__:
Write a recursive method of a binary search tree that tests if a given data item (String in this case) is stored in this instance of a binary search tree or not. Assume that the binary search tree class has a data field called root pointing to the root of the tree. The definition of the node is as follows:

```
public class Node {
    public String word;
    public Node left;
    public Node right;
}
```


The method header is as follows: <br/>
`public boolean find ( String word )`
<br/>
You may need to define additional methods.


__solution 1:__

```
public boolean find ( String word )
    if (left == null && right == null) {
        return false;
    }
    if (left.data == word || right.data == word ) {
        return true;
    }
    else {
        find(word, left);
        find(word, right);
    }
}
```
__solution 2:__

```
public boolean find ( String word ) {
    Node c = this;
    if (c == null ) return false;
    if (c.data.equals(word) )  return true;
    c.left.find(word);
    c.right.find(word)
}
```

__solution 3:__

```
public boolean find ( String word ) {
    return find (word, root);
}

private boolean find (String word, Node root) {
    if (root == null ) return false;
    if (root.word.equals(word) ) return true;
    return find(s, root.left);
    return find(s, root.right);
}
```

__solution 4:__

```
public boolean find ( String word ) {
    return find (word, root);
}

private boolean find (String word, Node root) {
    if (word == null ) return false;
    if (root.word == word ) return true;
    return ( find(s, root.left)  ||  find (s, root.right) ) ;
}
```


__solution 5:__

```
public boolean find ( String word ) {
    if (word == null )
        return false;
    else if (word.compareTo(right)<0 )
        return find(word.left);
    else
        return find(word.right);
}
```


#### Problem 2

In this question, you are asked to analyze incorrect solutions to the problem and explain what is wrong with them. Be as detailed as possible in explaining why the solution is incorrect. Do not simply propose an alternative solution.

__Problem Statement__:
Write a recursive method of a binary tree that prints to the standard output (the screen) values of nodes in the order defined by the inorder traversal. Assume that the binary tree class has a data field called root pointing to the root of the tree. The definition of the node is as follows:

```
public class IntNode {
    public int data;
    public IntNode left;
    public IntNode right;
}
```

The method header is as follows:
<br/>`public void inorderPrint ( )`<br/>
You may need to define additional methods.

__solution 1:__

```
public void inorderPrint ( ) {
    IntNode temp = root;
    if (temp.left != null ) {
        temp = temp.left;
        inorderPrint( temp);
    }
    System.out.println(temp);
    if (temp.right != null ) {
        temp = temp.right;
        inorderPrint(temp);
    }
}
```

__solution 2:__

```
public void inorderPrint ( ) {
    inorderPrint(root);

private void inorderPrint( IntNode n ) {
    inorderPrint( n.left);
    System.out.println(n.data);
    inorderPrint( n.right);
}
```

__solution 3:__

```
public void inorderPrint ( ) {
    int = data.length;
    if (data == root.data )
        System.out.print(IntNode.left);
    else if ( left == null )
        inorderPrint();
        System.out.print(IntNode.right);
    else
        inorderPrint();;
}
```

#### Problem 3

In this question, you are asked to analyze incorrect solutions to the problem and explain what is wrong with them. Be as detailed as possible in explaining why the solution is incorrect. Do not simply propose an alternative solution.

__Problem Statement:__
Write a recursive method of a generic binary tree that calculates the number of nodes in the tree. There is no size data field in the tree that keeps track of the number of nodes, so your function has to do all the calculations. The definition of the node is as follows:

```
public class BTNode  {
    public T data;
    public BTNode left;
    public BTNode right;
}
```

The method header is as follows:
<br/>`public int size ( )`<br/>
You may need to define additional methods.

__solution 1:__

```
public int size ( ){
    size ( root ) ;
}
private int size (BTNode n ) {
    if (n.right == null && n.left == null ) return 1;
    return size (n.left) + size (n.right) + 1;
}
```

__solution 2:__

```
public int size ( ){
    if (data == null) return 0;
    else return 1 + left.size() + right.size() ;
}
```

__solution 3:__

```
public int size ( ) {
    BTNode a;
    if (a == null)  return 0;
    if (a.right != null) return 1 + size(a.right);
    if (a.left != null) return 1 + size(a.left) ;
}
```


</main>
