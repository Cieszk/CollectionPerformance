package PerfomanceCheck;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayListVSLinkedList implements TimeMeasurement {
    /**
     * Porównanie perforamance'u ArrayList i LinkedList dla:
     * Tworzenia List
     * Wstawiania do list
     * Usuwania Elementów z list
     * Pobierania List
     * Iterowania poprzez listy
     */

    public static ArrayList<Long> arrayList = (ArrayList<Long>) CreateBigArray.createBigArrayList(12000);
    public static LinkedList<Long> linkedList = (LinkedList<Long>) CreateBigArray.createBigLinkedList(12000);

    private static void iterateList(Iterator listIterator) {
        while (listIterator.hasNext()) listIterator.next();
    }


    public static List<Double> createLists(long size) {

        double creatingArrayList = TimeMeasurement.checkTime(consumer -> CreateBigArray.createBigArrayList(size));

        double creatingLinkedList = TimeMeasurement.checkTime(consumer -> CreateBigArray.createBigLinkedList(size));

        return Arrays.asList(creatingArrayList, creatingLinkedList);
    }

    public static double getLists(int index, List list) {

        double gettingList = TimeMeasurement.checkTime(consumer -> list.get(index));

        return gettingList;
    }

    public static double insertIntoList(int index, List list, long element) {

        double insertArrayList = TimeMeasurement.checkTime(consumer -> list.add(index, element));

        return insertArrayList;
    }

    public static double removeFromList(int index, List list) {

        double removeElementFromList = TimeMeasurement.checkTime(consumer -> list.remove(index));

        return removeElementFromList;
    }

    public static double iterateTroughList(List list) {
        Iterator<Long> listIterator = list.iterator();

        double iterateArrayList = TimeMeasurement.checkTime(consumer -> iterateList(listIterator));

        return iterateArrayList;
    }


    public static void createAverageTime(long sizeOfList, int repeats) {
        List<List> list = new ArrayList<>();
        double averageArray = 0;
        double averageLinked = 0;
        for (int i = 0; i < repeats; i++){
            list.add(createLists(sizeOfList));
        }

        for (int i = 0; i < list.size(); i++) {
            averageArray += (double)(list.get(i).get(0));
            averageLinked += (double) (list.get(i).get(1));
        }
        averageArray /= list.size();
        averageLinked /= list.size();
        System.out.println("Arraylist: "+ averageArray + "\nLinkedList: " + averageLinked);
    }

    public static void getAverageTime(long sizeOfList, int repeats) {
        double averageArray = 0;
        double averageLinked = 0;

        List<List> list = new ArrayList<>();
        list.add(CreateBigArray.createBigArrayList(sizeOfList));
        list.add(CreateBigArray.createBigLinkedList(sizeOfList));

        Random random = new Random();

        for (int i = 0; i < repeats; i++) {
            averageArray +=  getLists(random.nextInt(list.size()), list.get(0));
            averageLinked += getLists(random.nextInt(list.size()), list.get(1));
        }

        averageArray /= repeats;
        averageLinked /= repeats;
        System.out.println("Arraylist: "+ averageArray + "\nLinkedList: " + averageLinked);
    }

    public static void insertAverageTime(long sizeOfList, int repeats) {
        double averageArray = 0;
        double averageLinked = 0;

        List<List> list = new ArrayList<>();
        list.add(CreateBigArray.createBigArrayList(sizeOfList));
        list.add(CreateBigArray.createBigLinkedList(sizeOfList));

        Random random = new Random();

        for (int i = 0; i < repeats; i++) {
            averageArray +=  insertIntoList(random.nextInt(list.size()), list.get(0), random.nextLong());
            averageLinked += insertIntoList(random.nextInt(list.size()), list.get(1), random.nextLong());
        }

        averageArray /= repeats;
        averageLinked /= repeats;
        System.out.println("Arraylist: "+ averageArray + "\nLinkedList: " + averageLinked);
    }

    public static void removeAverageTime(long sizeOfList, int repeats) {
        double averageArray = 0;
        double averageLinked = 0;

        List<List> list = new ArrayList<>();
        list.add(CreateBigArray.createBigArrayList(sizeOfList));
        list.add(CreateBigArray.createBigLinkedList(sizeOfList));

        Random random = new Random();

        for (int i = 0; i < repeats; i++) {
            averageArray +=  removeFromList(random.nextInt(list.size()), list.get(0));
            averageLinked += removeFromList(random.nextInt(list.size()), list.get(1));
        }

        averageArray /= repeats;
        averageLinked /= repeats;
        System.out.println("Arraylist: "+ averageArray + "\nLinkedList: " + averageLinked);
    }

    public static void iterateAverageTime(long sizeOfList, int repeats) {
        double averageArray = 0;
        double averageLinked = 0;

        List<List> list = new ArrayList<>();
        list.add(CreateBigArray.createBigArrayList(sizeOfList));
        list.add(CreateBigArray.createBigLinkedList(sizeOfList));

        for (int i = 0; i < repeats; i++) {
            averageArray +=  iterateTroughList(list.get(0));
            averageLinked += iterateTroughList(list.get(1));
        }

        averageArray /= repeats;
        averageLinked /= repeats;
        System.out.println("Arraylist: "+ averageArray + "\nLinkedList: " + averageLinked);
    }


}
