// Assignment: 5
// Author: Ben Levintan, ID: 318181831


package doublyLinkedList;
import java.util.Objects;
/**
 * A node in a doubly linked list.
 * @param <T> the type of data stored in the node
 */
public class Node <T>{

    private T data;
    private Node<T> prev;
    private Node<T> next;

    /**
     * Constructs a new node with given specified data.
     * @param data the data to be stored in the node
     */
    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    /**
     * Returns the data stored in the node.
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }
    /**
     * Sets the data to be stored in the node.
     * @param data the data to be stored in the node
     */

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the previous node.
     * @return the previous node
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Sets the previous node.
     * @param prev the previous node
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Returns the next node.
     * @return the next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the next node.
     * @param next the next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }


}
