package project4;

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
 * <p>The <i>middle</i> position is defines as (size+1)/2. For mdeques with odd sizes, this is the actual middle element. For the mdeques with
 * even sizes, this is the element, one past the middle of the elements. The position count is zero based.
 *
 * <pre>
 * [A, B, C, D]  -- middle element is C.
 * [A, B, C, D, E] -- middle element is C.
 * </pre>
 *
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
    public void pushBack (E item ) {

        if (item == null ) throw new IllegalArgumentException("null is not valid for this MDeque");
        Node n = new Node(item);
        if (front == null ) {
            front = back = n;
            middle = n;
        }
        else {
            back.next = n;
            n.prev = back;
            back = n;
            if (size % 2 == 0 ) middle = middle.next;
        }
        size++;
    }

    /**
     * Inserts the specified item at the front of this mdeque.
     *
     * @param item the element to add
     * @throws IllegalArgumentException if {@code item} is {@code null}
     */
    public void pushFront( E item ) {
        if (item == null ) throw new IllegalArgumentException("null is not valid for this MDeque");
        Node n = new Node(item);

        if (front == null ) {
            front = back = n;
            middle = n;
        }
        else {
            front.prev = n;
            n.next = front;
            front = n;
            if (size % 2 == 1 ) middle = middle.prev;

        }
        size++;
    }


    /**
     * Inserts the specified item in the middle of this mdeque.
     *
     * @param item the element to add
     * @throws IllegalArgumentException if {@code item} is {@code null}
     */
    public void pushMiddle( E item) {
        if (item == null ) throw new IllegalArgumentException("null is not valid for this MDeque");
        Node n = new Node(item);

        if (front == null ) {
            front = back = n;
            middle = n;
        }
        else {
            n.next = middle.next;
            n.prev = middle;
            middle.next = n;

            if (n.next != null )
                n.next.prev = n;

            if (size%2 == 0 ) {
                middle = middle.next;
            }
        }
        size++;

    }

    /**
     * Retrieves the middle element of this mdeque.
     *
     * @return the middle of this mdeque, or {@code null} if this mdeque is empty
     */
    public E peekMiddle () {
        if (middle == null ) return null;

        return size%2 == 0 ? middle.next.data : middle.data;
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
    public E popFront () {
        if (front == null ) return null;
        E val = front.data;
        front = front.next;
        if (front != null ) front.prev = null;
        else {
            back = null;
            middle = null;
        }
        if (size %2 == 0) middle = middle.next;
        size--;
        return val;
    }

    /**
     * Retrieves and removes the back element of this mdeque.
     *
     * @return the back of this mdeque, or {@code null} if this mdeque is empty
     */
    public E popBack () {
        if (back == null ) return null;
        E val = back.data;
        back = back.prev;
        if (back != null ) {
            back.next = null;
            if (size %2 == 1) middle = middle.prev;
        }
        else {
            front = null;
            middle = null;
        }
        size--;
        return val;
    }

    /**
     * Retrieves and removes the middle element of this mdeque.
     *
     * @return the middle of this mdeque, or {@code null} if this mdeque is empty
     */
    public E popMiddle() {
        if (middle == null ) return null;
        E val = (size%2 == 0 ? middle.next.data : middle.data);

        if (size %2 == 0 ) { //remove after
            middle.next = middle.next.next;
            if (middle.next != null ) {
                middle.next.prev=middle;
            }
            else { //we removed last node (which is middle in 2 element mdeque)
                back = middle;
            }
        }
        else { //remove at
            if (middle.next == null ) { //one node
                front = back = middle = null;
            }
            else {
                middle.prev.next = middle.next;
                middle.next.prev = middle.prev;
                middle = middle.prev;
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
    public Iterator<E> iterator(){
        return null;
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
        return null;
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
        //sb.append("\n");
        //sb.append(String.format("front: %4s, middle: %4s, back: %4s,  size: %4d",
        //        peekFront(), peekMiddle(), peekBack() , size ));


        return sb.toString()+"\n";

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
