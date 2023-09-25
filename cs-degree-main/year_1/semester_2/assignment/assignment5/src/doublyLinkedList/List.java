// Assignment: 5
// Author: Ben Levintan, ID: 318181831


package doublyLinkedList;
/**
 * The interface represents a generic list.
 * @param <T> the type of elements in the list
 */
public interface List<T extends Object> {

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the amount of elements in the list.
     * @return the size of the list
     */
    int size();

    /**
     * Adds an element to the front of the list.
     * @param data the element to add
     */
    void addFirst(T data);

    /**
     * Adds an element to the end of the list.
     * @param data the element to add
     */
    void addLast(T data);

    /**
     * Removes the first appearance of the element that holds 'data' from the list.
     * @param data the element to be removed
     * @return the removed element, or null if not found
     */
    T remove(T data);

    /**
     * Removing all elements.
     */
    void clear();

    /**
     * Checks if the list contains an element that holds data.
     * @param data the element to be checked
     * @return true if the element is present, false otherwise
     */
    boolean contains(T data);

    /**
     * Prints the elements head to tail.
     */
    void printForward();

    /**
     * Prints the elements tail to head.
     */
    void printBackward();
}
