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

    public static List<Double> create(List list) {

        double creatingArrayDeque = TimeMeasurement.checkTime(consumer -> new ArrayDeque<>(list));

        double creatingLinkedHashSet = TimeMeasurement.checkTime(consumer -> new LinkedHashSet<>(list));

        double creatingPriorityQueue = TimeMeasurement.checkTime(consumer -> new PriorityQueue<>(list));

        return Arrays.asList(creatingArrayDeque, creatingLinkedHashSet, creatingPriorityQueue);

    }

    public static double getQueue(Queue queue) {

        double gettingQueue = TimeMeasurement.checkTime(consumer -> System.out.println(queue));

        return gettingQueue;

    }

    public static double insertQueue(Queue queue, long value) {

        double insertQueueTime = TimeMeasurement.checkTime(consumer -> queue.add(value));

        return insertQueueTime;
    }

    public static double removeQueue(Queue queue, int index, List list) {

        double removeQueueTime = TimeMeasurement.checkTime(consumer -> queue.remove(list.get(index)));

        return removeQueueTime;
    }

    public static double iterateQueue(Queue queue) {
        Iterator<Long> queueIterator = queue.iterator();

        double iterateQueueTime = TimeMeasurement.checkTime(consumer -> iterate(queueIterator));

        return iterateQueueTime;

    }

    public static void createAverageTime(long sizeOfSet, int repeats) {
        List<List> list = new ArrayList<>();

        double averageArrayDeque = 0;
        double averageLinkedHashSet = 0;
        double averagePriorityQueue = 0;

        for (int i = 0; i < repeats; i++) {
            list.add(create(CreateBigArray.createBigArrayList(sizeOfSet)));
        }

        for (int i = 0; i < list.size(); i++) {
            averageArrayDeque += (double) (list.get(i).get(0));
            averageLinkedHashSet += (double) (list.get(i).get(1));
            averagePriorityQueue += (double) (list.get(i).get(2));
        }
        averageArrayDeque /= repeats;
        averageLinkedHashSet /= repeats;
        averagePriorityQueue /= repeats;

        System.out.println("ArrayDeque: " + averageArrayDeque + "\nLinkedHashSet: " + averageLinkedHashSet + "\nPriorityQueue: " + averagePriorityQueue);
    }

    public static void getAverageTime(long sizeOfSet, int repeats) {
        ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(sizeOfSet);

        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);
        ArrayDeque<Long> arrayDeque = new ArrayDeque<>(array);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(array);

        double averageArrayDeque = 0;
        double averageLinkedHashSet = 0;
        double averagePriorityQueue = 0;


        for (int i = 0; i < repeats; i++) {
            averageArrayDeque += getQueue(arrayDeque);
            averageLinkedHashSet += HashSetVSLinkedHashSetVSTreeSet.getSets(linkedHashSet);
            averagePriorityQueue += getQueue(priorityQueue);
        }
        averageArrayDeque /= repeats;
        averageLinkedHashSet /= repeats;
        averagePriorityQueue /= repeats;

        System.out.println("ArrayDeque: " + averageArrayDeque + "\nLinkedHashSet: " + averageLinkedHashSet + "\nPriorityQueue: " + averagePriorityQueue);
    }

    public static void insertAverageTime(long sizeOfSet, int repeats) {
        ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(sizeOfSet);

        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);
        ArrayDeque<Long> arrayDeque = new ArrayDeque<>(array);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(array);

        double averageArrayDeque = 0;
        double averageLinkedHashSet = 0;
        double averagePriorityQueue = 0;

        Random random = new Random();

        for (int i = 0; i < repeats; i++) {
            averageArrayDeque += insertQueue(arrayDeque, random.nextLong());
            averageLinkedHashSet += HashSetVSLinkedHashSetVSTreeSet.insertIntoSet(linkedHashSet, random.nextLong());
            averagePriorityQueue += insertQueue(priorityQueue, random.nextLong());
        }
        averageArrayDeque /= repeats;
        averageLinkedHashSet /= repeats;
        averagePriorityQueue /= repeats;

        System.out.println("ArrayDeque: " + averageArrayDeque + "\nLinkedHashSet: " + averageLinkedHashSet + "\nPriorityQueue: " + averagePriorityQueue);
    }

    public static void removeAverageTime(long sizeOfSet, int repeats) {
        ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(sizeOfSet);

        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);
        ArrayDeque<Long> arrayDeque = new ArrayDeque<>(array);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(array);

        double averageArrayDeque = 0;
        double averageLinkedHashSet = 0;
        double averagePriorityQueue = 0;

        Random random = new Random();

        for (int i = 0; i < repeats; i++) {
            averageArrayDeque += removeQueue(arrayDeque, random.nextInt(array.size()), array);
            averageLinkedHashSet += HashSetVSLinkedHashSetVSTreeSet.removeElementFromSet(linkedHashSet, random.nextInt(array.size()), array);
            averagePriorityQueue += removeQueue(priorityQueue, random.nextInt(array.size()), array);
        }
        averageArrayDeque /= repeats;
        averageLinkedHashSet /= repeats;
        averagePriorityQueue /= repeats;

        System.out.println("ArrayDeque: " + averageArrayDeque + "\nLinkedHashSet: " + averageLinkedHashSet + "\nPriorityQueue: " + averagePriorityQueue);
    }

    public static void iterateAverageTime(long sizeOfSet, int repeats) {
        ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(sizeOfSet);

        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);
        ArrayDeque<Long> arrayDeque = new ArrayDeque<>(array);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(array);

        double averageArrayDeque = 0;
        double averageLinkedHashSet = 0;
        double averagePriorityQueue = 0;

        for (int i = 0; i < repeats; i++) {
            averageArrayDeque += iterateQueue(arrayDeque);
            averageLinkedHashSet += HashSetVSLinkedHashSetVSTreeSet.iterateTroughSet(linkedHashSet);
            averagePriorityQueue += iterateQueue(priorityQueue);
        }
        averageArrayDeque /= repeats;
        averageLinkedHashSet /= repeats;
        averagePriorityQueue /= repeats;

        System.out.println("ArrayDeque: " + averageArrayDeque + "\nLinkedHashSet: " + averageLinkedHashSet + "\nPriorityQueue: " + averagePriorityQueue);
    }


}
