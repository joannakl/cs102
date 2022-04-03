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

## Binary Trees and Binary Search Trees


### Part 1

![a tree](img/Binary_search_tree.png)

- Which of the nodes in the above tree are at level 2?
- How many nodes would have to be added to level 3 so that the number of nodes at that level is maximum?
- Assuming that the height of leaf nodes is defined to be zero, what is the height of the above tree?
- Assuming that the height of leaf nodes is defined t0 be zero, what is the height of the node with value 3?
- Recall the iterative algorithm for calculating the size of a binary tree that we discussed in class.
What is the largest number of elements in the stack when the algorithm is applied to the above tree?

### Part 2

![a tree](img/bst.png)

- Specify the __inorder__ traversal of the above tree.
Provide your answer as a sequence of uppercase letters with nothing in between them so them.
- Specify the __preorder__ traversal of the above tree.
Provide your answer as a sequence of uppercase letters with nothing in between them so them.
- Specify the __postorder__ traversal of the above tree.
Provide your answer as a sequence of uppercase letters with nothing in between them so them.

### Part 3

You are told that the preorder and postorder traversals of a given tree are as follows:

preorder: A B C D E F G H I

postorder: C E D B H G I F A

Construct a tree for which this is the case.

### Part 4

In a binary search tree the values stored in a left subtree of a node have values smaller than it, and the values store in a right subtree of a node have values larger than it.
This has to be true for every node in the tree.

This is an example of a binary search tree:


![a tree](img/bst1.png)

- Consider trying to search for a value in a binary search tree.
What algorithm would you follow to avoid having to visit every single node in a tree?
<br>
Provide pseudocode as your answer.


- (There may not be a right answer here, so go with your instinct as an aspiring computer scientist.)
  - If we were to add a new node with value 35 to the above tree, where would you attach it?
  - If we were to add a new node with value 70 to the above tree, where would you attach it?
  - If we were to add a new node with value 8 to the above tree, where would you attach it?
  - If we were to add a new node with value 8 to the above tree, where would you attach it?
  - Working with the original tree, what would the tree look like if we removed the value 32 from it.
  - Working with the original tree, what would the tree look like if we removed the value 55 from it.
  - Working with the original tree, what would the tree look like if we removed the value 25 from it.


















</main>
