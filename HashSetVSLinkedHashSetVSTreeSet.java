package PerfomanceCheck;

import java.util.*;

public class HashSetVSLinkedHashSetVSTreeSet implements TimeMeasurement {
    /**
     * Porównanie perforamance'u HashSet'u LinkedHashSet'u i TreeSet'u dla:
     * Tworzenia Set'ów
     * Wstawiania do Set'ów
     * Usuwania Elementów z Set'ów
     * Pobierania Set'ów
     * Iterowania poprzez Sety
     */

    private static ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(5000);

    public static HashSet<Long> hashSet = new HashSet<>(array);
    public static LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);
    public static TreeSet<Long> treeSet = new TreeSet<>(array);

    private static void iterateSet(Iterator setIterator) {
        while (setIterator.hasNext()) setIterator.next();
    }

    public static void createSets() {
        System.out.println("Creating sets:\n");

        double creatingHashSet = TimeMeasurement.checkTime(consumer -> new HashSet<>(array));
        System.out.println("Creating HashSet: " + creatingHashSet + " seconds");

        double creatingTreeSet = TimeMeasurement.checkTime(consumer -> new TreeSet<>(array));
        System.out.println("Creating TreeSet: " + creatingTreeSet + " seconds");

        double creatingLinkedHashSet = TimeMeasurement.checkTime(consumer -> new LinkedHashSet<>(array));
        System.out.println("Creating LinkedHashSet: " + creatingLinkedHashSet + " seconds");

    }

    public static void getSets() {
        System.out.println("\nGetting sets:\n");

        double gettingHashSet = TimeMeasurement.checkTime(consumer -> System.out.println(hashSet));
        System.out.println("HashSet: " + gettingHashSet + " seconds");


        double gettingLinkedHashSet = TimeMeasurement.checkTime(consumer -> System.out.println(linkedHashSet));
        System.out.println("LinkedHashSet: " + gettingLinkedHashSet + " seconds");

        double gettingTreeSet = TimeMeasurement.checkTime(consumer -> System.out.println(treeSet));
        System.out.println("TreeSet: " + gettingTreeSet + " seconds");
    }

    public static void insertIntoList() {
        System.out.println("\nInserting element into lists:\n");

        double insertHashSet = TimeMeasurement.checkTime(consumer -> hashSet.add(32453255L));
        System.out.println("Inserting into HashSet: " + insertHashSet + " seconds");

        double insertLinkedHashSet = TimeMeasurement.checkTime(consumer -> linkedHashSet.add(32453255L));
        System.out.println("Inserting into LinkedHashSet: " + insertLinkedHashSet + " seconds");

        double insertTreeSet = TimeMeasurement.checkTime(consumer -> treeSet.add(32453255L));
        System.out.println("Inserting into TreeSet: " + insertTreeSet + " seconds");
    }

    public static void removeElementFromList() {
        System.out.println("\nRemove element from lists:\n");

        double removeElementHashSet = TimeMeasurement.checkTime(consumer -> hashSet.remove(array.get(500)));
        System.out.println("Remove from HashSet: " + removeElementHashSet + " seconds");

        double removeElementLinkedHashSet = TimeMeasurement.checkTime(consumer -> linkedHashSet.remove(array.get(500)));
        System.out.println("Remove from LinkedHashSet: " + removeElementLinkedHashSet + " seconds");

        double removeElementTreeSet = TimeMeasurement.checkTime(consumer -> treeSet.remove(array.get(500)));
        System.out.println("Remove from TreeSet: " + removeElementTreeSet + " seconds");
    }

    public static void iterateTroughList() {
        System.out.println("\nIterate trough lists:\n");

        Iterator<Long> hashSetIterator = hashSet.iterator();
        Iterator<Long> linkedHasSetIterator = linkedHashSet.iterator();
        Iterator<Long> treeSetIterator = treeSet.iterator();

        double iterateHashSet = TimeMeasurement.checkTime(consumer -> iterateSet(hashSetIterator));
        System.out.println("Iterate trough HashSet: " + iterateHashSet + " seconds");

        double iterateLinkedHashSet = TimeMeasurement.checkTime(consumer -> iterateSet(linkedHasSetIterator));
        System.out.println("Iterate trough LinkedHashSet: " + iterateLinkedHashSet + " seconds");

        double iterateTreeSet = TimeMeasurement.checkTime(consumer -> iterateSet(treeSetIterator));
        System.out.println("Iterate trough TreeSet: " + iterateTreeSet + " seconds");

    }
}
