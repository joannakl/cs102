import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic singly linked list implementation. 
 * This list does not allow null elements. 
 * @param <E> the type of elements in this list
 */
public class MyLinkedList<E> implements Iterable<E> {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Node class representing a single element in the linked list.
     */
    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Iterator class for the linked list.
     */
    private class LinkedListIterator implements Iterator<E> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Adds an element to the end of the list.
     * @param data the element to add
     * @throws IllegalArgumentException if the element is null
     */
    public void add(E data) {
        if (data == null) {
            throw new IllegalArgumentException("Null elements are not allowed");
        }
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Adds an element at the specified index in the list.
     * @param index the index at which to insert the element
     * @param data the element to insert
     * @throws IllegalArgumentException if the element is null 
     * @throws IndexOutOfBoundsException if the index is out of bounds, i.e., index < 0 or index > size
     */
    public void add(int index, E data) {
        if (data == null) {
            throw new IllegalArgumentException("Null elements are not allowed");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) {
                tail = newNode;
            }
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     * @param data the element to remove
     * @return true if the element was removed, false otherwise
     */
    public boolean remove(E data) {
        if (data == null) {
            return false;
        }
        if (head == null) {
            return false;
        }

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        if (current.next == null) {
            tail = current;
        }
        size--;
        return true;
    }

    /**
     * Returns the element at the specified index.
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     * @param data the element to search for
     * @return  the index of the first occurrence of the element, or -1 if the element is not found
     */
    public int indexOf(E data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Shifts the specified data element down the list by a specified number of positions.
     * If the new position is beyond the end of the list, it wraps to the start of the list.
     * For example, if the list is ['a', 'b', 'c', 'd', 'e'] and the data is 'c' with a shift of 2, the list will become ['a', 'b', 'd', 'e', 'c'].
     * Or, if the list is [1, 2, 3, 4, 5] and the data is 3 with a shift of 3, the list will become [1, 3, 2, 4, 5].
     * @param data the data element to shift
     * @param shift the number of positions to shift the element down the list
     */
    public void shiftDown(E data, int shift) {
        if (shift <= 0 || head == null) {
            return;
        }

        Node current = head;
        Node previous = null;
        int index = 0;

        // Find the node with the specified data
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
            index++;
        }

        // If the node is not found, do nothing
        if (current == null) {
            return;
        }

        // Remove the node from its current position
        if (previous != null) {
            previous.next = current.next;
        } else {
            head = current.next;
        }

        // Calculate the new position index
        int newIndex = (index + shift) % size;

        // Find the new position for the node
        Node newPrevious = head;
        for (int i = 0; i < newIndex - 1; i++) {
            newPrevious = newPrevious.next;
        }

        // Insert the node at the new position
        if (newPrevious != null) {
            current.next = newPrevious.next;
            newPrevious.next = current;
        } else {
            // If the new position is the head of the list
            current.next = head;
            head = current;
        }
    }
    /**
     * Shifts the specified data element up the list by a specified number of positions.
     * If the new position is beyond the start of the list, it wraps to the end of the list.
     * For example, if the list is ['a', 'b', 'c', 'd', 'e'] and the data is 'c' and the shift is 2, the list will become ['c', 'a', 'b', 'd', 'e'].
     * Or, if the list is [1, 2, 3, 4, 5] and the data is 3 and the shift is 3, the list will become [1, 2, 4, 5, 3].
     * @param data the data element to shift
     * @param shift the number of positions to shift the element up the list
     */
    public void shiftUp(E data, int shift) {
        if (shift <= 0 || head == null) {
            return;
        }

        Node current = head;
        Node previous = null;
        int index = 0;

        // Find the node with the specified data
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
            index++;
        }

        // If the node is not found, do nothing
        if (current == null) {
            return;
        }

        // Remove the node from its current position
        if (previous != null) {
            previous.next = current.next;
        } else {
            head = current.next;
        }

        // Calculate the new position index
        int newIndex = (index - shift) % size;

        // Find the new position for the node
        Node newPrevious = head;
        for (int i = 0; i < newIndex - 1; i++) {
            newPrevious = newPrevious.next;
        }

        // Insert the node at the new position
        if (newPrevious != null) {
            current.next = newPrevious.next;
            newPrevious.next = current;
        } else {
            // If the new position is the head of the list
            current.next = head;
            head = current;
        }
    }
    /**
     * Splits the list at the specified index and returns a new list containing the elements from the index to the end, [index, size-1].
     * The original list will contain the elements up to the index [0, index-1].
     * For example, if the list is ['a', 'b', 'c', 'd', 'e'] and the index is 2, the original list will be ['a', 'b'] and the returned list will be ['c', 'd', 'e'].
     * @param index the index at which to split the list
     * @return a new list containing the elements from the index to the end
     * @throws IndexOutOfBoundsException if the index is out of bounds, i.e., index < 0 or index >= size
     */
    public MyLinkedList<E> splitAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyLinkedList<E> newList = new MyLinkedList<>();
        if (index == 0) {
            newList.head = head;
            newList.tail = tail;
            newList.size = size;
            head = null;
            tail = null;
            size = 0;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newList.head = current.next;
            newList.tail = tail;
            newList.size = size - index;
            tail = current;
            current.next = null;
            size = index;
        }
        return newList;
    }

    /**
     * Appends another list to the end of this list.
     * For example, if this list is ['a', 'b', 'c'] and the list to append is ['d', 'e'], this list will become ['a', 'b', 'c', 'd', 'e'].
     * @param list the list to append
     */
    public void appendList(MyLinkedList<E> list) {
        if (list == null || list.head == null) {
            return;
        }
        if (head == null) {
            head = list.head;
            tail = list.tail;
            size = list.size;
        } else {
            tail.next = list.head;
            tail = list.tail;
            size += list.size;
        }
        list.head = null;
        list.tail = null;
        list.size = 0;
    }

    /**
     * Reverses the elements in this list.  
     * For example, if the list is ['a', 'b', 'c', 'd', 'e'], the reversed list will be ['e', 'd', 'c', 'b', 'a'].
     */
    public void reverse() {
        if (head == null) {
            return;
        }

        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        tail = head;
        head = previous;

    } 

    /**
     * Extracts nodes from the list that have odd indices and returns a new list containing these nodes.
     * For example, if the list is ['a', 'b', 'c', 'd', 'a'], the returned list will be ['b', 'd'] and this list will be ['a', 'c', 'a'].
     * The original list will contain the nodes with even indices.
     * @return a new list containing the nodes with odd indices
     */
    public MyLinkedList<E> extractOddNodes() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        if (head == null) {
            return newList;
        }

        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current == head) {
                newList.head = current;
                newList.tail = current;
                newList.size = 1;
                head = current.next;
                current = current.next;
                previous = null;
            } else {
                previous.next = current.next;
                newList.tail.next = current;
                newList.tail = current;
                newList.size++;
                current = previous.next;
            }
            previous = current;
            if (current != null) {
                current = current.next;
            }
        }
        if (newList.size > 0) {
            newList.tail.next = null;
        }
        return newList;
    }

    /**
     * Rotates the list to the right by a specified number of positions.
     * If the shift is greater than the size of the list, it wraps around.
     * For example, if the list is [1, 2, 3, 4, 5] and the shift is 2, the list will become [4, 5, 1, 2, 3].
     * Or, if the list is ['a', 'b', 'c', 'd', 'e'] and the shift is 7, the list will become ['d', 'e', 'a', 'b', 'c'].
     * @param shift the number of positions to rotate the list to the right
     * @throws IllegalArgumentException if the shift is negative
     */
    public void rotateRight(int shift) {
        if (shift < 0) {
            throw new IllegalArgumentException("Shift must be non-negative");
        }
        if (head == null || shift == 0) {
            return;
        }

        int k = shift % size;
        if (k == 0) {
            return;
        }

        Node current = head;
        Node previous = null;
        for (int i = 0; i < size - k; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail.next = head;
        head = current;
        tail = previous;
    }

    /**
     * Rotates the list to the left by a specified number of positions.
     * If the shift is greater than the size of the list, it wraps around.
     * For example, if the list is [1, 2, 3, 4, 5] and the shift is 2, the list will become [3, 4, 5, 1, 2].
     * Or, if the list is ['a', 'b', 'c', 'd', 'e'] and the shift is 7, the list will become ['c', 'd', 'e', 'a', 'b'].
     * @param shift the number of positions to rotate the list to the left
     * @throws IllegalArgumentException if the shift is negative    
     */
    public void rotateLeft(int shift) {
        if (shift < 0) {
            throw new IllegalArgumentException("Shift must be non-negative");
        }
        if (head == null || shift == 0) {
            return;
        }

        int k = shift % size;
        if (k == 0) {
            return;
        }

        Node current = head;
        Node previous = null;
        for (int i = 0; i < k; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail.next = head;
        head = current;
        tail = previous;
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
     
    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of the list. List elements should be enclosed in a set of square brackets and separated by commas.
     * @return a string representation of the list
     */
    @Override  
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Returns true if the specified object is also a MyLinkedList and contains the same elements in the same order as this list.
     * @param obj the object to compare
     * @return true if the object is equal to this list, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MyLinkedList)) {
            return false;
        }
        MyLinkedList<?> other = (MyLinkedList<?>) obj;
        if (size != other.size) {
            return false;
        }

        Iterator<E> iter1 = iterator();
        Iterator<?> iter2 = other.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            E data1 = iter1.next();
            Object data2 = iter2.next();
            if (!data1.equals(data2)) {
                return false;
            }
        }
        return true;
    }

}