//Ben Levintan
/**
 * The DataStructure class represents a data structure to manage a book library in a Java program.
 * It utilizes an ArrayList for efficient random access and iteration, making it well-suited for
 * scenarios where students frequently take and return books. The simplicity of ArrayList and its
 * automatic resizing capabilities contribute to easier code management and adaptability to dynamic
 * changes in the library's size.
 *
 * @param <T> The type of data to be stored in the data structure.
 */
package LibraryPackage;

/**
 * this data structure would be used to store books in a library system,
 * the structure would mimic an array list data structure.
 TODO List for Library Data Structure:

 - [X] Implement `add(T data, int index)` method:
 - Inserts a new node at the specified index in the data structure.

 - [X] Implement `addToEnd(T data)` method:
 - Inserts a new node at the end of the data structure.

 - [X] Implement `size()` method:
 - Gets the size of the data structure.

 - [X] Implement `contains(T data)` method:
 - Searches for a node with the given data in the data structure.

 - [X] Implement `delete(T data)` method:
 - Deletes a node with the given data from the data structure.

 - [X] Implement `toString()` method:
 - Return the string value of the elements in the data structure from beginning to end, separated by commas.

 */
public class DataStructure<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    //default constructor
    public DataStructure() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    //constructor with a specific capacity
    public DataStructure(int capacity) {
        this.array = new Object[capacity];
        this.size = capacity;
    }

    /**
     * Inserts a new element at the specified index in the array list.
     *
     * @param data  The data to be stored.
     * @param index The index at which the data should be inserted.
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index > size).
     */
    void add(T data, int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        checkMaxCapacity();
        array[index] = data;
        size++;
    }

    /**
     * Inserts a new element at the end of the array list.
     *
     * @param data The data to be stored.
     */
    void addToEnd(T data) {
        checkMaxCapacity();
        add(data, size);
    }

    /**
     * Searches for a data element in the array list.
     *
     * @param data The data to search for.
     * @return true if the data is found; false otherwise.
     */
    boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes the first occurrence of the specified data element from the array list.
     *
     * @param data The data to be deleted.
     */
    void delete(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                // Shift elements to the left to remove the element
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return;
            }
        }
    }

    /**
     * Gets the size of the array list.
     *
     * @return The number of elements in the array list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the string representation of the elements in the array list.
     *
     * @return String representation of the array list.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * Gets the element at the specified index.
     *
     * @param index The index of the element to get.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index >= size).
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index is out of bounds.");

        T element = (T) array[index];
        return element;
    }
    /**
     * Ensures that the array has enough capacity for a new elements.
     * If the current capacity is full, the array capacity is doubled.
     */
    private void checkMaxCapacity() {
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }
}
