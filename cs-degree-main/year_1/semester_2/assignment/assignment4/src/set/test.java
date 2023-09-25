package set;

public class test {
    public static void main(String[] args) {
        SimpleSet<Integer> set = new SimpleSet<>();

        // Add elements
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(20);

        // Check size and isEmpty
        System.out.println("Size: " + set.size());
        System.out.println("Is empty: " + set.isEmpty());

        // Add duplicate element
        set.add(10);

        // Check size after adding duplicate element
        System.out.println("Size after adding duplicate element: " + set.size());

        // Check contains
        System.out.println("Contains 15: " + set.contains(15));
        System.out.println("Contains 25: " + set.contains(25));

        // Remove elements
        set.remove(10);
        set.remove(20);

        // Check size after removing elements
        System.out.println("Size after removing elements: " + set.size());

        // Check contains after removing elements
        System.out.println("Contains 10: " + set.contains(10));
        System.out.println("Contains 20: " + set.contains(20));

        SimpleSet<Integer> setA = new SimpleSet<>();
        SimpleSet<Integer> setB = new SimpleSet<>();

        // Add elements to setA
        setA.add(1);
        setA.add(2);
        setA.add(3);

        // Add elements to setB
        setB.add(2);
        setB.add(3);
        setB.add(4);

        // Print setA
        System.out.println("Set A: " + setA.toString());

        // Print setB
        System.out.println("Set B: " + setB);

        // Union
        SimpleSet<Integer> unionSet = SetUtils.union(setA, setB);
        System.out.println("Union: " + unionSet);

        // Intersection
        SimpleSet<Integer> intersectionSet = SetUtils.intersection(setA, setB);
        System.out.println("Intersection: " + intersectionSet);

        // Difference
        SimpleSet<Integer> differenceSet = SetUtils.difference(setA, setB);
        System.out.println("Difference (A - B): " + differenceSet);

        // Symmetric Difference
        SimpleSet<Integer> symmetricDifferenceSet = SetUtils.symmetricDifference(setA, setB);
        System.out.println("Symmetric Difference: " + symmetricDifferenceSet);
    }

}

