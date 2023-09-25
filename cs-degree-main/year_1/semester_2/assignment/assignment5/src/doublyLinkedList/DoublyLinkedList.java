// Assignment: 5
// Author: Ben Levintan, ID: 318181831


package doublyLinkedList;

/**
 * A generic implementation of a doubly linked list.
 * @param <T> the type of elements stored in the list
 */
public class DoublyLinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Checks if the doubly linked list is empty.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the doubly linked list.
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the beginning of the doubly linked list.
     * @param data the element to be added
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an element to the end of the doubly linked list.
     * @param data the element to be added
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     * @param data the element to be removed
     * @return the removed element, or null if the element is not found
     */
    public T remove(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                if (current.getPrev() == null) {
                    head = current.getNext();
                } else {
                    current.getPrev().setNext(current.getNext());
                }
                if (current.getNext() == null) {
                    tail = current.getPrev();
                } else {
                    current.getNext().setPrev(current.getPrev());
                }
                size--;
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Checks if the list contains the specified element.
     * @param data the element to be checked
     * @return true if the element is found, false otherwise
     */
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Clears the list by removing all elements.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Prints the elements of the list in forward order.
     */
    public void printForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Prints the elements of the list in backward order.
     */
    public void printBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getPrev();
        }
        System.out.println();
    }
}
