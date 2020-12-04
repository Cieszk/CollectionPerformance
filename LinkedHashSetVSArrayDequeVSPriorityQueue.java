package PerfomanceCheck;

import java.util.*;

public class LinkedHashSetVSArrayDequeVSPriorityQueue implements TimeMeasurement {
    /**
     * Porównanie perforamance'u LinkedHashSet'u, ArrayDeque i PriorityQueue dla:
     * Tworzenia
     * Wstawiania
     * Usuwania Elementów
     * Pobierania
     * Iterowania
     */

    private static ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(5000);

    public static LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);
    public static ArrayDeque<Long> arrayDeque = new ArrayDeque<>(array);
    public static PriorityQueue<Long> priorityQueue = new PriorityQueue<>(array);

    private static void iterate(Iterator iterator) {
        while (iterator.hasNext()) iterator.next();
    }

    public static void create() {
        System.out.println("Creating sets:\n");

        double creatingArrayDeque = TimeMeasurement.checkTime(consumer -> new ArrayDeque<>(array));
        System.out.println("Creating ArrayDeque: " + creatingArrayDeque + " seconds");

        double creatingLinkedHashSet = TimeMeasurement.checkTime(consumer -> new LinkedHashSet<>(array));
        System.out.println("Creating LinkedHashSet: " + creatingLinkedHashSet + " seconds");

        double creatingPriorityQueue = TimeMeasurement.checkTime(consumer -> new PriorityQueue<>(array));
        System.out.println("Creating PriorityQueue: " + creatingPriorityQueue + " seconds");

    }

    public static void get() {
        System.out.println("\nGetting:\n");

        double gettingArrayDeque = TimeMeasurement.checkTime(consumer -> System.out.println(arrayDeque));
        System.out.println("ArrayDeque: " + gettingArrayDeque + " seconds");


        double gettingLinkedHashSet = TimeMeasurement.checkTime(consumer -> System.out.println(linkedHashSet));
        System.out.println("LinkedHashSet: " + gettingLinkedHashSet + " seconds");

        double gettingPriorityQueue = TimeMeasurement.checkTime(consumer -> System.out.println(priorityQueue));
        System.out.println("PriorityQueue: " + gettingPriorityQueue + " seconds");
    }

    public static void insert() {
        System.out.println("\nInserting element:\n");

        double insertArrayDeque = TimeMeasurement.checkTime(consumer -> arrayDeque.add(32453255L));
        System.out.println("Inserting into ArrayDeque: " + insertArrayDeque + " seconds");

        double insertLinkedHashSet = TimeMeasurement.checkTime(consumer -> linkedHashSet.add(32453255L));
        System.out.println("Inserting into LinkedHashSet: " + insertLinkedHashSet + " seconds");

        double insertPriorityQueue = TimeMeasurement.checkTime(consumer -> priorityQueue.add(32453255L));
        System.out.println("Inserting into PriorityQueue: " + insertPriorityQueue + " seconds");
    }

    public static void removeElement() {
        System.out.println("\nRemove element:\n");

        double removeElementArrayDeque = TimeMeasurement.checkTime(consumer -> arrayDeque.remove(array.get(500)));
        System.out.println("Remove from ArrayDeque: " + removeElementArrayDeque + " seconds");

        double removeElementLinkedHashSet = TimeMeasurement.checkTime(consumer -> linkedHashSet.remove(array.get(500)));
        System.out.println("Remove from LinkedHashSet: " + removeElementLinkedHashSet + " seconds");

        double removeElementPriorityQueue = TimeMeasurement.checkTime(consumer -> priorityQueue.remove(array.get(500)));
        System.out.println("Remove from PriorityQueue: " + removeElementPriorityQueue + " seconds");
    }

    public static void iterate() {
        System.out.println("\nIterate trough lists:\n");

        Iterator<Long> arrayDequeIterator = arrayDeque.iterator();
        Iterator<Long> linkedHasSetIterator = linkedHashSet.iterator();
        Iterator<Long> priorityQueueIterator = priorityQueue.iterator();

        double iterateArrayDeque = TimeMeasurement.checkTime(consumer -> iterate(arrayDequeIterator));
        System.out.println("Iterate trough ArrayDeque: " + iterateArrayDeque + " seconds");

        double iterateLinkedHashSet = TimeMeasurement.checkTime(consumer -> iterate(linkedHasSetIterator));
        System.out.println("Iterate trough LinkedHashSet: " + iterateLinkedHashSet + " seconds");

        double iteratePriorityQueue = TimeMeasurement.checkTime(consumer -> iterate(priorityQueueIterator));
        System.out.println("Iterate trough PriorityQueue: " + iteratePriorityQueue + " seconds");

    }
}
