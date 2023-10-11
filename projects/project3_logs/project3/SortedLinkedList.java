package project3;

import java.util.Iterator;

/**
 * This is an implementation of a sorted doubly-linked list. 
 * All elements in the list are maintained in ascending/increasing order
 * based on the natural order of the elements.
 * This list does not allow <code>null</code> elements. 
 * 
 * @author Joanna Klukowska
 * @author 
 * 
 * @param <E> the type of elements held in this list
 */
public class SortedLinkedList<E extends Comparable<E>>
        implements Iterable<E> {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs a new empty sorted linked list.
     */
    public SortedLinkedList() {
    	head = null;
    	tail = null;
    	size = 0;
    }

    /**
     * Adds the specified element to the list in ascending order.
     *
     * @param element the element to add
     * @return <code>true</code> if the element was added successfully, 
     * <code>false</code> otherwise (if <code>element==null</code>)
     */
    public boolean add(E element) {
        // TODO: Implement this method
        return false;
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        // TODO: Implement this method
    }

    /**
     * Returns <code>true</code> if the list contains the specified element, 
     * <code>false</code> otherwise.
     *
     * @param o the element to search for
     * @return <code>true</code> if the element is in the list, 
     * <code>false</code> otherwise
     */
    public boolean contains(Object o) {
        // TODO: Implement this method
        return false;
    }

    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
	 * @throw IndexOutOfBoundsException  if the index is out of 
	 * range <code>(index < 0 || index >= size())</code>
     */
    public E get(int index) throws IndexOutOfBoundsException {
        // TODO: Implement this method
        return null;
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the element is not in the list.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the element, 
     * or -1 if the element is not in the list
     */
    public int indexOf(Object o) {
        // TODO: Implement this method
        return -1;
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * starting at the specified <code>index</code>, i.e., in the range of indexes 
     * <code>index <= i < size()</code>, or -1 if the element is not in the list 
     * in the range of indexes <code>index <= i < size()</code>.
     *
     * @param o the element to search for
     * @param index the index to start searching from
     * @return the index of the first occurrence of the element, starting at the specified index,
     * or -1 if the element is not found
     */
    public int nextIndexOf(Object o, int index) {
        // TODO: Implement this method
        return -1;
    }

    /**
     * Removes the first occurence of the specified element from the list.
     *
     * @param o the element to remove
     * @return <code>true</code> if the element was removed successfully,
     * <code>false</code> otherwise
     */
    public boolean remove(Object o) {
        // TODO: Implement this method
        return false;
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return an iterator over the elements in the list
     */
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    /**
     * Compares the specified object with this list for equality.
     *
     * @param o the object to compare with
     * @return <code>true</code> if the specified object is equal to this list, 
     * <code>false</code> otherwise
     */
    public boolean equals(Object o) {
        // TODO: Implement this method
        return false;
    }

    /**
     * Returns a string representation of the list. 
     *  The string representation consists of a list of the lists's elements in 
     *  ascending order, enclosed in square brackets ("[]"). 
     *  Adjacent elements are separated by the characters ", " (comma and space). 
     *
     * @return a string representation of the list
     */
    public String toString() {
        // TODO: Implement this method
        return "[]";
    }
	
    /* Inner class to represent nodes of this list.*/
	private class Node implements Comparable<Node>{
		E data; 
		Node next;
		Node prev;
		Node(E data) {
			if (data == null ) throw new NullPointerException ("does not allow null");
			this.data = data; 
		}
		Node (E data, Node next, Node prev) {
			this(data);
			this.next = next;
			this.prev = prev;
		}
		public int compareTo( Node n ) {
			return this.data.compareTo(n.data); 
		}
	}
	
	/* A basic forward iterator for this list. */
	private class ListIterator implements Iterator<E> {
		
		Node nextToReturn = head; 
		@Override
		public boolean hasNext() {
			return nextToReturn != null;
		}

		@Override
		public E next() throws NoSuchElementException{
            if (nextToReturn == null ) 
                throw new NoSuchElementException("the end of the list reached");
            E tmp = nextToReturn.data;
            nextToReturn = nextToReturn.next;
			return tmp;
		}
		
	}
}


