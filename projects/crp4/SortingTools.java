import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A utility class providing various sorting algorithms for arrays and lists.
 * This class supports Selection Sort, Merge Sort, and Quick Sort.
 *
 * <p>All methods return a sorted version of the input collection. 
 * For arrays and ArrayLists, the sorting is performed in-place. 
 * For LinkedLists, a new sorted list is returned.</p>
 */
public class SortingTools {

    /**
     * Enumeration of available sorting algorithms.
     */
    public enum Algorithm {
        SELECTION_SORT, MERGESORT, QUICKSORT, HEAPSORT
    }

    /**
     * Sorts an ordinary array using the specified algorithm.
     *
     * @param <T> the type of elements, must implement {@link Comparable}
     * @param array the array to be sorted
     * @param alg the algorithm to use (SELECTION_SORT, MERGESORT, QUICKSORT, HEAPSORT)
     * @return the sorted array
     */
    public <T extends Comparable<T>> T[] sort(T[] array, Algorithm alg) {
        switch (alg) {
            case SELECTION_SORT: return selectionSort(array);
            case MERGESORT:      return mergeSort(array);
            case QUICKSORT:      return quickSort(array);
            case HEAPSORT:       return heapSort(array);
            default: throw new IllegalArgumentException("Unknown algorithm");
        }
    }

    /**
     * Sorts an ArrayList using the specified algorithm.
     *
     * @param <T> the type of elements, must implement {@link Comparable}
     * @param list the ArrayList to be sorted
     * @param alg the algorithm to use
     * @return the sorted ArrayList
     */
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> list, Algorithm alg) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) list.toArray(new Comparable[0]);
        sort(array, alg);
        
        for (int i = 0; i < array.length; i++) {
            list.set(i, array[i]);
        }
        return list;
    }

    /**
     * Sorts a LinkedList using the specified algorithm.
     *
     * @param <T> the type of elements, must implement {@link Comparable}
     * @param list the LinkedList to be sorted
     * @param alg the algorithm to use
     * @return a new LinkedList containing the sorted elements
     */
    public <T extends Comparable<T>> LinkedList<T> sort(LinkedList<T> list, Algorithm alg) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) list.toArray(new Comparable[0]);
        sort(array, alg);
        
        LinkedList<T> sortedList = new LinkedList<>();
        for (T item : array) {
            sortedList.add(item);
        }
        return sortedList;
    }

    // --- Private Selection Sort Implementation ---

    /**
     * Sorts an array using the Selection Sort algorithm.
     *
     * <p><b>Algorithm Outline:</b>
     * <ol>
     * <li>Iterate through the array from the first element to the second-to-last.</li>
     * <li>For each position, assume the current element is the minimum.</li>
     * <li>Scan the remaining unsorted portion of the array to find the actual minimum.</li>
     * <li>Swap the found minimum element with the element at the current starting position.</li>
     * <li>Repeat until the entire array is processed.</li>
     * </ol>
     * </p>
     */
    private <T extends Comparable<T>> T[] selectionSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // --- Private Merge Sort Implementation ---

    /**
     * Sorts an array using the Merge Sort algorithm.
     *
     * <p><b>Algorithm Outline:</b>
     * <ol>
     * <li><b>Divide:</b> Calculate the midpoint and split the array into two halves.</li>
     * <li><b>Conquer:</b> Recursively call Merge Sort on both the left and right halves.</li>
     * <li><b>Combine:</b> Merge the two sorted halves back into a single sorted subarray 
     * using temporary storage to compare elements.</li>
     * </ol>
     * </p>
     */
    private <T extends Comparable<T>> T[] mergeSort(T[] array) {
        if (array.length > 1) {
            mergeSortRecursive(array, 0, array.length - 1);
        }
        return array;
    }

    private <T extends Comparable<T>> void mergeSortRecursive(T[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortRecursive(array, left, mid);
            mergeSortRecursive(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        @SuppressWarnings("unchecked")
        T[] L = (T[]) new Comparable[n1];
        @SuppressWarnings("unchecked")
        T[] R = (T[]) new Comparable[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }
        while (i < n1) 
            array[k++] = L[i++];
        while (j < n2) 
            array[k++] = R[j++];
    }

    // --- Private Quick Sort Implementation ---

    /**
     * Sorts an array using the Quick Sort algorithm.
     *
     * <p><b>Algorithm Outline:</b>
     * <ol>
     * <li><b>Pivot Selection:</b> Choose an element (the last element) as the 'pivot'.</li>
     * <li><b>Partitioning:</b> Reorder the array so all elements less than the pivot 
     * move to its left, and all elements greater move to its right.</li>
     * <li><b>Recursion:</b> Recursively apply the logic to the left and right subarrays.</li>
     * </ol>
     * </p>
     */
    private <T extends Comparable<T>> T[] quickSort(T[] array) {
        quickSortRecursive(array, 0, array.length - 1);
        return array;
    }

    private <T extends Comparable<T>> void quickSortRecursive(T[] array, int low, int high) {
        if (low < high) {
            // pivotIndex is now the permanent home of the pivot
            int pivotIndex = partition(array, low, high);
            
            // Recursively sort the elements to the left and right of the pivot
            quickSortRecursive(array, low, pivotIndex - 1);
            quickSortRecursive(array, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array by isolating the pivot and using two pointers 
     * to find out-of-place elements.
     *
     * <p><b>Algorithm Outline:</b>
     * <ol>
     * <li>The pivot is chosen as the last element (array[high]).</li>
     * <li>'left' starts at low, and 'right' starts at high - 1 (excluding pivot).</li>
     * <li>'left' slides right until it finds an element >= pivot.</li>
     * <li>'right' slides left until it finds an element <= pivot.</li>
     * <li>If left < right, the elements are swapped and the process repeats.</li>
     * <li>Finally, the pivot at array[high] is swapped with array[left].</li>
     * <li>The index 'left' is returned as the final sorted position of the pivot.</li>
     * </ol>
     * </p>
     *
     * @param <T> the type of elements
     * @param array the array to partition
     * @param low the starting index
     * @param high the ending index
     * @return the final sorted index of the pivot
     */
    private <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int left = low;
        int right = high - 1;

        while (left <= right) {
            // Slide left until we find an element greater than or equal to pivot
            while (left <= right && array[left].compareTo(pivot) < 0) {
                left++;
            }
            // Slide right until we find an element less than or equal to pivot
            while (left <= right && array[right].compareTo(pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        // Swap pivot into its final resting place
        swap(array, left, high);
        return left;
    }
    
    // --- Private Heap Sort Implementation ---
    
    /**
     * Sorts an array using the Heap Sort algorithm.
     *
     * <p><b>Algorithm Outline:</b>
     * <ol>
     * <li><b>Build Heap:</b> Use the BinaryHeap(T[]) constructor to build a 
     * max heap in O(n) time.</li>
     * <li><b>Extract:</b> Repeatedly call remove() to extract the largest 
     * remaining element.</li>
     * <li><b>Place:</b> Fill the original array from right to left with 
     * the extracted elements.</li>
     * </ol>
     * </p>
     */
    private <T extends Comparable<T>> T[] heapSort(T[] array) {
        // Build heap efficiently in O(n)
        BinaryHeap<T> heap = new BinaryHeap<>(array);

        // Extract elements in O(n log n)
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = heap.remove();
        }

        return array;
    }
}
