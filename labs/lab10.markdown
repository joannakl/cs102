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


## BSTs  and AVL Trees


### Problem 1

![a tree](img/AVL1.png)

Starting with the AVL tree shown below, show what the tree will look like after each of the following operations. Assume that the remove method uses the successor when applicable. __For each step modify the tree that results from the previous step (NOT the original tree)__.

- add 31
- add 8
- add 30
- remove 17
- remove 7
- remove 39


### Problem 2

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


### Problem 3

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

### Problem 4

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
