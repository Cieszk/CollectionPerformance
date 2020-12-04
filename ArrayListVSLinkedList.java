package PerfomanceCheck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ArrayListVSLinkedList implements TimeMeasurement {
    /**
     * Porównanie perforamance'u ArrayList i LinkedList dla:
     * Tworzenia List
     * Wstawiania do list
     * Usuwania Elementów z list
     * Pobierania List
     * Iterowania poprzez listy
     */

    public static ArrayList<Long> arrayList = (ArrayList<Long>) CreateBigArray.createBigArrayList(8000);
    public static LinkedList<Long> linkedList = (LinkedList<Long>) CreateBigArray.createBigLinkedList(8000);

    private static void iterateList(Iterator listIterator) {
        while (listIterator.hasNext()) listIterator.next();
    }


    public static void createLists() {
        System.out.println("Creating lists:\n");

        // ArrayList
        double creatingArrayList = TimeMeasurement.checkTime(consumer -> CreateBigArray.createBigArrayList(8000));
        System.out.println("Array list: " + creatingArrayList + " seconds");

        // LinkedList
        double creatingLinkedList = TimeMeasurement.checkTime(consumer -> CreateBigArray.createBigLinkedList(8000));
        System.out.println("Linked list: " + creatingLinkedList + " seconds");
    }


    public static void getLists() {
        System.out.println("\nGetting lists:\n");

        double gettingArrayList = TimeMeasurement.checkTime(consumer -> System.out.println(arrayList));
        System.out.println("Array list: " + gettingArrayList + " seconds");


        double gettingLinkedList = TimeMeasurement.checkTime(consumer -> System.out.println(linkedList));

        System.out.println("Array list: " + gettingLinkedList + " seconds");
    }

    public static void insertIntoList() {
        System.out.println("\nInserting element into lists:\n");

        double insertArrayList = TimeMeasurement.checkTime(consumer -> arrayList.add(45, 32453255L));
        System.out.println("Inserting into ArrayList: " + insertArrayList + " seconds");

        double insertLinkedList = TimeMeasurement.checkTime(consumer -> linkedList.add(45, 32453255L));
        System.out.println("Inserting into LinkedList: " + insertLinkedList + " seconds");
    }

    public static void removeElementFromList() {
        System.out.println("\nRemove element from lists:\n");

        double removeElementArrayList = TimeMeasurement.checkTime(consumer -> arrayList.remove(1200));
        System.out.println("Remove from ArrayList: " + removeElementArrayList + " seconds");

        double removeElementLinkedList = TimeMeasurement.checkTime(consumer -> linkedList.remove(1200));
        System.out.println("Remove from LinkedList: " + removeElementLinkedList + " seconds");
    }

    public static void iterateTroughList() {
        System.out.println("\nIterate trough lists:\n");

        Iterator<Long> arrayIterator = arrayList.iterator();
        Iterator<Long> linkedIterator = linkedList.iterator();

        double iterateArrayList = TimeMeasurement.checkTime(consumer -> iterateList(arrayIterator));
        System.out.println("Iterate trough LinkedList: " + iterateArrayList + " seconds");

        double iterateLinkedList = TimeMeasurement.checkTime(consumer -> iterateList(linkedIterator));
        System.out.println("Iterate trough LinkedList: " + iterateLinkedList + " seconds");

    }


}
