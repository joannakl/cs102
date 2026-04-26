import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Collections;

/**
 * A Binary Max Heap implementation.
 *
 * <p>This class provides the fundamental operations for a max heap structure. 
 * It includes an efficient O(n) constructor to build a heap from an 
 * existing array using Floyd's bottom-up heapify algorithm. In a max heap,
 * the parent is always greater than or equal to its children.</p>
 *
 * @param <K> the type of elements maintained by this heap, which must 
 * implement the {@link Comparable} interface.
 */
public class BinaryHeap<K extends Comparable<K>> {

    /**
     * The internal storage for the heap elements.
     */
    private final ArrayList<K> heap;

    /**
     * Constructs a new, empty BinaryHeap.
     */
    public BinaryHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Constructs a BinaryHeap from an existing array.
     * This uses Floyd's algorithm to build the heap in O(n) time by sifting
     * down starting from the last non-leaf node.
     *
     * @param array the initial elements to be placed in the heap
     * @throws NullPointerException if the provided array is null
     */
    public BinaryHeap(K[] array) {
        if (array == null) {
            throw new NullPointerException("Initial array cannot be null");
        }
        this.heap = new ArrayList<>();
        Collections.addAll(this.heap, array);
        
        // Start from the last non-leaf node and sift down to the root
        for (int i = getParentIndex(heap.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * Returns the number of elements currently in the heap.
     *
     * @return the size of the heap
     */
    public int size() {
        return heap.size();
    }

    /**
     * Checks if the heap contains no elements.
     *
     * @return true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Adds a new element to the heap and restores the max-heap property.
     *
     * @param key the element to be added
     * @throws NullPointerException if the specified element is null
     */
    public void add(K key) {
        if (key == null) {
            throw new NullPointerException("Cannot add null element");
        }
        heap.add(key);
        siftUp(heap.size() - 1);
    }

    /**
     * Restores the heap property by moving an element at the given index 
     * upward until it is less than or equal to its parent.
     *
     * @param index the index of the element to sift up
     */
    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = getParentIndex(index);
            if (heap.get(index).compareTo(heap.get(parentIndex)) <= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * Retrieves, but does not remove, the maximum element (the root).
     *
     * @return the maximum element in the heap
     * @throws NoSuchElementException if the heap is empty
     */
    public K peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    /**
     * Removes and returns the maximum element from the heap, then 
     * restores the max-heap property.
     *
     * @return the maximum element formerly at the root
     * @throws NoSuchElementException if the heap is empty
     */
    public K remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        K max = heap.get(0);
        K lastElement = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastElement);
            siftDown(0);
        }

        return max;
    }

    /**
     * Restores the heap property by moving an element at the given index
     * downward until it is greater than or equal to its children.
     *
     * @param index the index of the element to sift down
     */
    private void siftDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChild = getLeftChildIndex(index);
            int rightChild = getRightChildIndex(index);
            int largest = index;

            if (leftChild < size && heap.get(leftChild).compareTo(heap.get(largest)) > 0) {
                largest = leftChild;
            }

            if (rightChild < size && heap.get(rightChild).compareTo(heap.get(largest)) > 0) {
                largest = rightChild;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);
            index = largest;
        }
    }

    /**
     * Calculates the index of the parent of the node at the given index.
     *
     * @param index the index of the child node
     * @return the index of the parent node
     */
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * Calculates the index of the left child of the node at the given index.
     *
     * @param index the index of the parent node
     * @return the index of the left child node
     */
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    /**
     * Calculates the index of the right child of the node at the given index.
     *
     * @param index the index of the parent node
     * @return the index of the right child node
     */
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    /**
     * Swaps the elements at two specified positions in the heap.
     *
     * @param index1 the index of the first element
     * @param index2 the index of the second element
     */
    private void swap(int index1, int index2) {
        K temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
