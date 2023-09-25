package queue;

/**
 * A queue is a collection that orders its elements in a specific sequence.
 * In a queue, the element that was added first will be removed first.
 * This interface represents the basic operations of a queue.
 */
public interface Queue {

    /**
     * Adds an element to the back of the queue.
     *
     * @param element the element to add
     * @return true if the element was added successfully, false otherwise
     * (for example, if the queue is full)
     *
     * This method adds an element to the back of the queue, returning a boolean
     * value indicating whether or not the element was added successfully. If the
     * queue is full and cannot accept any more elements, this method returns false.
     * Otherwise, it returns true.
     */
    boolean enqueue(Object element);

    /**
     * Removes and returns the element at the front of the queue.
     * If the queue is empty, returns null.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     *
     * This method removes and returns the element at the front of the queue. If the
     * queue is empty and there are no elements to remove, it returns null. Otherwise,
     * it returns the element that was removed.
     */
    Object dequeue();

    /**
     * Returns the element at the front of the queue without removing it.
     * If the queue is empty, returns null.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     *
     * This method returns the element at the front of the queue without removing it.
     * If the queue is empty and there are no elements to return, it returns null.
     * Otherwise, it returns the element that is currently at the front of the queue.
     */
    Object peek();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     *
     * This method returns the number of elements currently in the queue. If the
     * queue is empty, it returns 0.
     */
    int size();

    /**
     * Returns true if the queue is empty, false otherwise.
     *
     * @return true if the queue is empty, false otherwise
     *
     * This method returns true if the queue is currently empty and has no elements.
     * Otherwise, it returns false.
     */
    boolean isEmpty();

    /**
     * Returns true if the queue is full, false otherwise.
     *
     * @return true if the queue is full, false otherwise
     *
     * This method returns true if the queue is currently full and cannot accept any
     * more elements. Otherwise, it returns false.
     */
    boolean isFull();

}

