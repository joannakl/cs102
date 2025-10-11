package project3;

import java.util.Iterator;

/**
 * A linear collection that supports element insertion and removal at
 * three points: front, middle and back.  The name <i>mdeque</i> is short for "double ended queue" (deque) with <i>m</i> for "middle"
 * and is pronounced "em-deck".  {@code MDeque}
 * has no fixed limits on the number of elements it contains.
 *
 * <p> The remove operations all return {@code null} values if the mdeque is empty. The structure does not allow {@code null} as an element.
 *
 * <p> All {@code pop...}, {@code push...}, and {@code peek...} operations (from all three points of access) are constant time operations.
 *
 * <p>The <i>middle</i> position is defines as size/2. For mdeques with odd sizes, this is the actual middle element. For the mdeques with
 * even sizes, this is the element, one past the middle of that elements. The position count is zero based.
 *
 * <pre>
 * [A, B, C, D]  -- middle element is C.
 * [A, B, C, D, E] -- miccle element is C.
 * </pre>
 *
 * @author Joanna Klukowska
 *
 * @param <E> the type of elements held in this mdeque
 */
public class MDeque<E> implements Iterable<E> {

    private class Node {
        E data;
        Node next;
        Node prev;
        Node (E item) {
            data = item;
        }
    }

    private Node front;
    private Node back;
    private Node middle;
    private int size;

    /**
     * Creates an empty MDeque object.
     */
    public MDeque ( ) {

    }


    /**
     * Inserts the specified item at the back of this mdeque.
     *
     * @param item the element to add
     * @throws IllegalArgumentException if {@code item} is {@code null}
     */
    public void pushBack(E item) {
        if (item == null) throw new IllegalArgumentException("null is not valid for this MDeque");
        Node n = new Node(item);
        if (back == null) {
            front = back = middle = n;
        } else {
            n.prev = back;
            back.next = n;
            back = n;
            if (size % 2 == 1) {
                middle = middle.next;
            }
        }
        size++;
    }
    

    /**
     * Inserts the specified item at the front of this mdeque.
     *
     * @param item the element to add
     * @throws IllegalArgumentException if {@code item} is {@code null}
     */
    public void pushFront(E item) {
        if (item == null) throw new IllegalArgumentException("null is not valid for this MDeque");
        Node n = new Node(item);
        if (front == null) {
            front = back = middle = n;
        } else {
            n.next = front;
            front.prev = n;
            front = n;
            if (size % 2 == 0) {
                middle = middle.prev;
            }
        }
        size++;
    }
    


    /**
     * Inserts the specified item in the middle of this mdeque.
     *
     * @param item the element to add
     * @throws IllegalArgumentException if {@code item} is {@code null}
     */
    public void pushMiddle(E item) {
        if (item == null) throw new IllegalArgumentException("null is not valid for this MDeque");
        Node n = new Node(item);
    
        if (front == null) {
            front = back = middle = n;
        } else if (size % 2 == 0) {
            // Insert BEFORE middle
            n.next = middle;
            n.prev = middle.prev;
            if (middle.prev != null) middle.prev.next = n;
            else front = n;
            middle.prev = n;
            middle = n; // move middle to new node
        } else {
            // Insert AFTER middle
            n.prev = middle;
            n.next = middle.next;
            if (middle.next != null) middle.next.prev = n;
            else back = n;
            middle.next = n;
            middle = n; // move middle to new node
        }
    
        size++;
    }
    
    

    /**
     * Retrieves the middle element of this mdeque.
     *
     * @return the middle of this mdeque, or {@code null} if this mdeque is empty
     */
    public E peekMiddle() {
        return middle == null ? null : middle.data;
    }
    

    /**
     * Retrieves the first element of this mdeque.
     *
     * @return the front of this mdeque, or {@code null} if this mdeque is empty
     */
    public E peekFront () {
        return front==null? null : front.data;
    }

    /**
     * Retrieves the back element of this mdeque.
     *
     * @return the back of this mdeque, or {@code null} if this mdeque is empty
     */
    public E peekBack () {
        return back==null? null : back.data;
    }

    /**
     * Retrieves and removes the first element of this mdeque.
     *
     * @return the front of this mdeque, or {@code null} if this mdeque is empty
     */
    public E popFront() {
    if (front == null) return null;

    E val = front.data;
    front = front.next;
    if (front != null) front.prev = null;

    size--;
    if (size == 0) {
        front = back = middle = null;
    } else if (size % 2 == 1) {
        middle = middle.next;
    }

    return val;
}


    /**
     * Retrieves and removes the back element of this mdeque.
     *
     * @return the back of this mdeque, or {@code null} if this mdeque is empty
     */
    public E popBack() {
        if (back == null) return null;
    
        E val = back.data;
        back = back.prev;
        if (back != null) back.next = null;
    
        size--;
        if (size == 0) {
            front = back = middle = null;
        } else if (size % 2 == 0) {
            middle = middle.prev;
        }
    
        return val;
    }
    

    /**
     * Retrieves and removes the middle element of this mdeque.
     *
     * @return the middle of this mdeque, or {@code null} if this mdeque is empty
     */
    public E popMiddle() {
        if (middle == null) return null;
    
        E val = middle.data;
    
        if (size == 1) {
            front = back = middle = null;
        } else {
            Node toRemove = middle;
    
            if (middle.prev != null)
                middle.prev.next = middle.next;
            else
                front = middle.next;
    
            if (middle.next != null)
                middle.next.prev = middle.prev;
            else
                back = middle.prev;
    
            // Update middle pointer **based on post-removal size**
            if ((size - 1) % 2 == 0) {
                // size is going from odd → even: move middle forward
                middle = toRemove.next;
            } else {
                // size going from even → odd: move middle back
                middle = toRemove.prev;
            }
        }
    
        size--;
        return val;
    }
    
    


    /**
     * Returns the number of elements in this mdeque.
     *
     * @return the number of elements in this mdeque
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in this mdeque in proper sequence.
     * The elements will be returned in order from front to back.
     *
     * @return an iterator over the elements in this mdeque in proper sequence
     */
    
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node current = front;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new java.util.NoSuchElementException();
                E value = current.data;
                current = current.next;
                return value;
            }
        };
    }


    /**
     * Returns an iterator over the elements in this mdeque in reverse
     * sequential order.  The elements will be returned in order from
     * back to front.
     *
     * @return an iterator over the elements in this mdeque in reverse
     * sequence
     */
    
    public Iterator<E> reverseIterator() {
        return new Iterator<E>() {
            private Node current = back;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new java.util.NoSuchElementException();
                E value = current.data;
                current = current.prev;
                return value;
            }
        };
    }


    /**
     * Returns a string representation of this mdeque.  The string
     * representation consists of a list of the collection's elements in the
     * order they are returned by its iterator, enclosed in square brackets
     * ({@code "[]"}).  Adjacent elements are separated by the characters
     * {@code ", "} (comma and space).
     *
     * @return a string representation of this mdeque
     */
    public String toString () {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0 ) {
            toString(front, sb);
        }

        sb.append("]");

        // debugging help
        // sb.append("\n");
        // sb.append(String.format("front: %4s, middle: %4s, back: %4s,  size: %4d",
        //         peekFront(), peekMiddle(), peekBack() , size ));


        return sb.toString();

    }
    private void toString( Node head, StringBuilder sb ) {
        if (head.next == null ) {
            sb.append(head.data);
        }
        else {
            sb.append(head.data);
            sb.append(", ");
            toString(head.next, sb);
        }
    }
/*
	public MDeque<E> clone () {
		MDeque<E> tmp = new MDeque<>();
		Node current = front;
		while (current != null ) {
			tmp.pushBack(current.data);
			current = current.next;
		}
		return tmp;
	}
*/



}
