
package set;

/**
 * A simple implementation of the Set interface using an array to store elements.
 * @param <E> the type of elements in the set
 */
class SimpleSet<E> implements Set<E> {
    protected E[] elements;
    protected int size;
    protected int capacity;
    /**
     * Constructs a SimpleSet with the specified capacity.
     * @param capacity the initial capacity of the set
     */
    public SimpleSet(int capacity) {
        this.capacity = capacity;
        this.elements = (E[]) new Object[capacity];
        this.size = 0;
    }
    /**
     * Constructs a SimpleSet with a default capacity of 5.
     */
    public SimpleSet() {
        this(5); // Default capacity is 5
    }
    /**
     * Adds the specified element to the set if it is not already present.
     * @param element the element to be added to the set
     */
    public void add(E element) {
        if (contains(element)) {
            return;
        }

        if (size >= capacity) {
            capacity += 5;
            E[] newElements = (E[]) new Object[capacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }

        elements[size] = element;
        size++;

    }
    /**
     * Removes the specified element from the set if it is present.
     * @param element the element to be removed from the set
     */
    public void remove(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                elements[i] = null;
                if (i != size - 1) {
                    elements[i] = elements[size - 1];
                }
                elements[--size] = null;

            }
        }

    }
    /**
     * Checks if the set contains the specified element.
     * @param e the element to be checked for containment in the set
     * @return true if the set contains the element, false otherwise
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the number of elements in the set.
     * @return the number of elements in the set
     */
    public int size() {
        return size;
    }
    /**
     * Checks if the set is empty (contains no elements).
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Returns a string representation of the set.
     * @return a string representation of the set
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(elements[i]).append(", ");
        }
        sb.append(elements[size - 1]).append("]");
        return sb.toString();
    }
}
