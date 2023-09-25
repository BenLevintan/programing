package set;
/**
 * An interface representing a set, which is a collection of unique elements.
 * @param <E> the type of elements in the set
 */
    public interface Set<E> {
    /**
     * Adds the specified element to the set if it is not already present.
     * @param element the element to be added to the set
     */
        void add(E element);
    /**
     * Removes the specified element from the set if it is present.
     * @param element the element to be removed from the set
     */
        void remove(E element);
    /**
     * Checks if the set contains the specified element.
     * @param element the element to be checked for containment in the set
     * @return true if the set contains the element, false otherwise
     */
        boolean contains(E element);
    /**
     * Returns the number of elements in the set.
     * @return the number of elements in the set
     */
        int size();
    /**
     * Checks if the set is empty (contains no elements).
     * @return true if the set is empty, false otherwise
     */
        boolean isEmpty();
    }

