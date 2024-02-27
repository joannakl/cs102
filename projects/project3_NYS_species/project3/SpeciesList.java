package project3;

import java.util.Collections;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * This is an implementation of the species lists using a sorted doubly-linked
 * list. All elements in the list are maintained in ascending/increasing order
 * based on the natural order of the elements. This list does not allow
 * <code>null</code> elements.
 * 
 */
public class SpeciesList implements Iterable<Species> {

	private Node head;
	private Node tail;
	private int size;

	/**
	 * Constructs a new empty sorted linked list of Species objects.
	 */
	public SpeciesList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Adds the specified element to the list in ascending order. If this list
	 * contains an element that is equal to <code>species</code> argument, the
	 * counties in two objects are merged and stored in the object in the list.
	 * 
	 * @param species the element to add to this list
	 * @return <code>true</code> if a new species object was added to this list, <code>false</code>
	 *         otherwise (if <code>element==null</code> or if <code>species</code>
	 *         was already present in this list)
	 */
	public boolean add(Species species) {
		if (species == null) {
			return false;
		}
		//add to an empty list 
		if (head == null) {
			head = new Node(species);
			tail = head;
			size++;
			return true;
		}
		//handle all other cases (add in order based on natural order of the elements)	
		Node current = head;
		//iterate to the correct location 
		while (current.next != null && current.data.compareTo(species) < 0) {
			current = current.next;
		}
		//add before the first node 
		if (current == head && current.data.compareTo(species) > 0) {
			Node newNode = new Node(species, head, null);
			head.prev = newNode;
			head = newNode;
		} 
		// add to the first node (species matches the first node value)
		else if (current == head && current.data.compareTo(species) == 0) {
			// merge the counties
			for (String c : species.getCounties()) {
				current.data.addCounty(c);
			}
			return false;
		}
		// add to another existing node (species matches current.prev value 
		else if (current.prev!=null && current.prev.data.equals(species) ) {
			//merge the counties 
			for (String c : species.getCounties()) {
				current.prev.data.addCounty(c);
			}
			return false;
		}
		else if (current == tail) {
			Node newNode = new Node(species, null, tail);
			tail.next = newNode;
			tail = newNode;
		} else {
			Node newNode = new Node(species, current, current.prev);
			current.prev.next = newNode;
			current.prev = newNode;
		}
		size++;
				
		return true;
	}

	/**
	 * Adds the specified <code>species</code> element and its associated
	 * <code>county</code> to the list in ascending order. If this list contains an
	 * element that is equal to <code>species</code> argument, the counties in two
	 * objects and the <code>county</code> argument are merged and stored in the
	 * object in the list. If <code>county==null</code> or an empty string, 
	 * this method throws an instance of <code>IllegalArgumentException</code>.	 
     *
	 * @param species the element to add to this list
	 * @param county  the county to be associated with the <code>species</code>
	 *                object
	 * @return <code>true</code> if a new species object was added to this list, <code>false</code>
	 *         otherwise (if <code>species==null</code> or if <code>species</code>
	 *         was already present in this list)
	 */
	public boolean add(Species species, String county) {
		if (species == null) {
			return false;
		}
		if (county == null || county.isEmpty()) {
			throw new IllegalArgumentException("county cannot be null or empty");
		}
		//add county to species	first and use the other add to finish the job
		species.addCounty(county);
		return add(species);
		
	}

	/**
	 * Removes all elements from this list.
	 */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Returns <code>true</code> if this list contains an element equal to the specified
	 * element, <code>false</code> otherwise.
	 *
	 * @param o the element to search for
	 * @return <code>true</code> if the element is in the list, <code>false</code> otherwise
	 */
	public boolean contains(Object o) {
		return indexOf(o) != -1;
	}

	/**
	 * Returns the element at the specified index in thia list.
	 *
	 * @param index the index of the element to return
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
	 *        index >= size())
	 */
	public Species get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds: " + index);
		}

		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current.data;
	}
	/**
	 * Returns a list of <code>Species</code> objects that contain the specified 
	 * keyword in either the common name or the scientific name. The search is 
	 * case-insensitive. If no match is found, this method returns <code>null</code>.
	 * @param keyword the keyword to search for
	 * @return a list of <code>Species</code> objects that contain the specified 
	 * keyword in either the common name or the scientific name.
	 * @throws IllegalArgumentException if the keyword is null or empty
	 */
	public SpeciesList getByName(String keyword) {

		if (keyword == null || keyword.isEmpty()) {
			throw new IllegalArgumentException("invalid keyword: " + keyword);
		}

		SpeciesList list = new SpeciesList();
		keyword = keyword.toLowerCase();

		for (Species s : this) {
			String cName = s.getCommonName().toLowerCase();
			String sName = s.getScientificName().toLowerCase();
			if (cName.contains(keyword) || sName.contains(keyword)) {
				list.add(s);
			}
		}
		return list.size() == 0 ? null : list;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in the
	 * list, or `-1` if the element is not in the list.
	 *
	 * @param o the element to search for
	 * @return the index of the first occurrence of the element, or `-1` if the
	 *         element is not in the list
	 */
	public int indexOf(Object o) {
		if (o == null) {
			return -1;
		}

		Node current = head;
		int index = 0;
		while (current != null) {
			if (current.data.equals(o)) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	/**
	 * Removes the specified element from the list.
	 *
	 * @param o the element to remove
	 * @return <code>true</code> if the element was removed successfully, <code>false</code> otherwise
	 */
	public boolean remove(Object o) {
		if (o == null) {
			return false;
		}

		Node current = head;
		while (current != null) {
			if (current.data.equals(o)) {
				
				if (current == head) {
					head = head.next;
					head.prev = null;
				} else if (current == tail) {
					tail = tail.prev;
					tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				size--;
				return true;
			}
			current = current.next;
		}
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
	 * Returns an iterator over the elements in the list. It allows forward
	 * traversal of the list.
	 *
	 * @return an iterator over the elements in the list
	 */
	public Iterator<Species> iterator() {
		return new Itr();
	}

	/**
	 * Returns a list iterator over the elements in the list. It allows 
	 * bidirectional traversal of the list.
	 *
	 * @return an iterator over the elements in the list
	 */
	public ListIterator<Species> listIterator() {
		return new ListItr();
	}

	/**
	 * Compares the specified object with this list for equality. Two lists are
	 * considered equal if they contain the same elements in the same order.
	 *
	 * @param o the object to compare with
	 * @return <code>true</code> if the specified object is equal to this list, 
	 * <code>false</code>
	 *         otherwise
	 */
	public boolean equals(Object o) {
		// TODO: Implement this method
		return false;
	}

	/**
	 * Returns a string representation of the list. The string representation
	 * consists of a list of the lists's elements common names and scientific 
	 * names in ascending order, enclosed in square brackets ("[]"). Adjacent 
	 * elements are separated by the characters ", " (comma and space). 
	 * 
	 * [commonName1 (scientificName1), commonName2 (scientificName2), ...]
	 * 
	 * An empty list is represented by "[]".
	 *
	 * @return a string representation of the list
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node current = head;
		while (current != null) {
			sb.append(String.format("%s (%s)", current.data.getCommonName(), current.data.getScientificName()));
			if (current.next != null) {
				sb.append(", ");
			}
			current = current.next;
		}
		sb.append("]");
		return sb.toString();
	}

	/* Inner class to represent nodes of this list. */
	private class Node implements Comparable<Node> {
		Species data;
		Node next;
		Node prev;

		Node(Species data) {
			if (data == null)
				throw new NullPointerException("doesn not allow null");
			this.data = data;
		}

		Node(Species data, Node next, Node prev) {
			this(data);
			this.next = next;
			this.prev = prev;
		}

		public int compareTo(Node n) {
			return this.data.compareTo(n.data);
		}
	}

	/* A basic forward iterator for this list. */
	private class Itr implements Iterator<Species> {
		Node nextToReturn = head;
		Node lastReturned = null;
		int nextIndex = 0;

		@Override
		public boolean hasNext() {
			return nextToReturn != null;
		}

		@Override
		public Species next() {
			if (!hasNext())
				throw new NoSuchElementException();
			lastReturned = nextToReturn;
			nextToReturn = nextToReturn.next;
			nextIndex++;
			return lastReturned.data;
		}

        public void remove() {
        	throw new UnsupportedOperationException("remove is not implemented");
        }
	}
	
	/* A basic bidirectional iterator for this list. */
	private class ListItr implements ListIterator<Species> {

        private Node previous;
        private Node next;
        private int nextIndex;

        ListItr( ) {
            next = head; 
            previous = null; 
            nextIndex = 0;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public Species next() {
            if (!hasNext())
                throw new NoSuchElementException();

            previous = next;
            next = next.next;
            nextIndex++;
            return previous.data;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public Species previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            
            next = previous;	
            previous = previous.prev;
            nextIndex--;
            return next.data;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        public void remove() {
        	throw new UnsupportedOperationException("remove is not implemented");
        }

        public void set(Species s) {
        	throw new UnsupportedOperationException("set is not implemented");
        }

		@Override
		public void add(Species s) {
        	throw new UnsupportedOperationException("add is not implemented");
			
		}
    


	}
}
