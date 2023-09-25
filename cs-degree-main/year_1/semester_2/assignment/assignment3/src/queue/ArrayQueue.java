// Assignment: 3
// Author: Ben Levintan, ID: 318181831

package queue;
/**
 * ArrayQueue is a class that implements the Queue interface.
 * It provides a basic implementation of a queue using an array.
 */
public class ArrayQueue implements Queue{
    /**
     * The queue array to hold the elements.
     */
    private Object[] queue;
    private int size;
    /**
     * Constructs a new ArrayQueue object with the specified capacity.
     *
     * @param capacity The capacity of the queue.
     */
    public ArrayQueue(int capacity){
        size = 0;
        queue = new Object[capacity];
    }


    /**
     * Adds an element to the back of the queue.
     * @param object the element to add
     * @return true if the element was added successfully, false otherwise
     * This method adds the specified element to the back of the queue. If the queue
     * is full and cannot accept any more elements, this method returns false. Otherwise,
     * it adds the element to the queue and returns true.
     */
    public boolean enqueue(Object object){

        if(size == queue.length)
            return false;
        else {
            queue[size] = object;
            size++;
            return true;
        }
    }

    /**
     * Removes and returns the element at the front of this queue. If the queue is empty,
     * returns null.
     * @return the element that was removed from the front of the queue, or null if the queue is empty.
     * move all the other objects one index to the front of the queue
     */
    public Object dequeue(){

        if(queue[0] == null)
            return null;

        Object dequeued = queue[0];

        for(int i = 0 ; i < size - 1 && queue[i] != null ; ++i){
            queue[i] = queue[i+1];
        }

        queue[size-1] = null;
        size--;

        return dequeued;

    }

    /**
     * Returns the element at the head of the queue without removing it.
     * If the queue is empty, returns null.
     * The queue remains unchanged.
     * @return the element at the head of the queue, or null if the queue is empty
     */
    public Object peek(){

        if(queue[0]==null)
            return null;

        return queue[0];

    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue.
     */
    public int size(){

        int i;

        for(i = 0; i<size && queue[i] != null ; ++i){}

        return i;

    }

    /**
     * Checks whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size==0)
            return true;
        else
            return false;
    }

    /**
     * Returns true if the queue is full, false otherwise.
     * A queue is considered full if the number of elements in the array is equal to the length of the array.
     * @return true if the queue is full, false otherwise.
     */
    @Override
    public boolean isFull() {
        return (queue.length==size);
    }

    /*for testing*/
    public void printQueue(ArrayQueue queue) {
        int queueSize = queue.size();
        for (int i = 0;  i < queueSize && queue.queue[i]!=null ; i++) {
            if(queue.queue[i]==null)
                break;
            System.out.print(queue.queue[i] + " ");
        }
        System.out.println();
    }
}