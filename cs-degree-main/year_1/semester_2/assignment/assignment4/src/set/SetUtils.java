
package set;

/**
 * A utility class for performing operations on sets.
 */
class SetUtils {
    /**
     * Computes the union of two sets.
     * @param setA the first set
     * @param setB the second set
     * @param <E> the type of elements in the sets
     * @return a new set that contains all the elements from both input sets
     */
    public static <E> SimpleSet<E> union(SimpleSet<E> setA, SimpleSet<E> setB) {
        SimpleSet<E> result = new SimpleSet<>();
        for (int i = 0; i < setA.size(); i++) {
            result.add(setA.elements[i]);
        }
        for (int i = 0; i < setB.size(); i++) {
            result.add(setB.elements[i]);
        }
        return result;
    }
    /**
     * Computes the intersection of two sets.
     * @param setA the first set
     * @param setB the second set
     * @param <E> the type of elements in the sets
     * @return a new set that contains the common elements between the input sets
     */
    public static <E> SimpleSet<E> intersection(SimpleSet<E> setA, SimpleSet<E> setB) {
        SimpleSet<E> result = new SimpleSet<>();
        for (int i = 0; i < setA.size(); i++) {
            if (setB.contains(setA.elements[i])) {
                result.add(setA.elements[i]);
            }
        }
        return result;
    }
    /**
     * Computes the difference of two sets.
     * @param setA the first set
     * @param setB the second set
     * @param <E> the type of elements in the sets
     * @return a new set that contains the elements from setA that are not present in setB
     */
    public static <E> SimpleSet<E> difference(SimpleSet<E> setA, SimpleSet<E> setB) {
        SimpleSet<E> result = new SimpleSet<>();
        for (int i = 0; i < setA.size(); i++) {
            if (!setB.contains(setA.elements[i])) {
                result.add(setA.elements[i]);
            }
        }
        return result;
    }
    /**
     * Computes the symmetric difference of two sets.
     * @param setA the first set
     * @param setB the second set
     * @param <E> the type of elements in the sets
     * @return a new set that contains the elements that are present in either setA or setB, but not both
     */
    public static <E> SimpleSet<E> symmetricDifference(SimpleSet<E> setA, SimpleSet<E> setB) {
        SimpleSet<E> difference1 = difference(setA, setB);
        SimpleSet<E> difference2 = difference(setB, setA);
        return union(difference1, difference2);
    }
}