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

    public static List<Double> createSets(List list) {

        double creatingHashSet = TimeMeasurement.checkTime(consumer -> new HashSet<>(list));

        double creatingTreeSet = TimeMeasurement.checkTime(consumer -> new TreeSet<>(list));

        double creatingLinkedHashSet = TimeMeasurement.checkTime(consumer -> new LinkedHashSet<>(list));

        return Arrays.asList(creatingHashSet, creatingTreeSet, creatingLinkedHashSet);
    }

    public static double getSets(Set set) {

        double gettingSet = TimeMeasurement.checkTime(consumer -> System.out.println(set));

        return gettingSet;
    }

    public static double insertIntoSet(Set set, long value) {

        double insertSet = TimeMeasurement.checkTime(consumer -> set.add(value));

        return insertSet;
    }

    public static double removeElementFromSet(Set set, int index, List list) {

        double removeElementSet = TimeMeasurement.checkTime(consumer -> set.remove(list.get(index)));

        return removeElementSet;
    }

    public static double iterateTroughSet(Set set) {

        Iterator<Long> setIterator = set.iterator();

        double iterateSetTime = TimeMeasurement.checkTime(consumer -> iterateSet(setIterator));

        return iterateSetTime;

    }

    public static void createAverageTime(long sizeOfSet, int repeats) {
        List<List> list = new ArrayList<>();
        double averageHashSet = 0;
        double averageTreeSet = 0;
        double averageLinkedHashSet = 0;

        for (int i = 0; i < repeats; i++) {
            list.add(createSets(CreateBigArray.createBigArrayList(sizeOfSet)));
        }

        for (int i = 0; i < list.size(); i++) {
            averageHashSet += (double) (list.get(i).get(0));
            averageTreeSet += (double) (list.get(i).get(1));
            averageLinkedHashSet += (double) (list.get(i).get(2));
        }
        averageHashSet /= repeats;
        averageTreeSet /= repeats;
        averageLinkedHashSet /= repeats;

        System.out.println("HashSet: " + averageHashSet + "\nTreeSet: " + averageTreeSet + "\nLinkedHashSet: " + averageLinkedHashSet);
    }

    public static void getAverageTime(long sizeOfSet, int repeats) {
        ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(sizeOfSet);
        List<List> list = new ArrayList<>();

        HashSet<Long> hashSet = new HashSet<>(array);
        TreeSet<Long> treeSet = new TreeSet<>(array);
        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);

        double averageHashSet = 0;
        double averageTreeSet = 0;
        double averageLinkedHashSet = 0;

        for (int i = 0; i < repeats; i++) {
            averageHashSet += getSets(hashSet);
            averageTreeSet += getSets(treeSet);
            averageLinkedHashSet += getSets(linkedHashSet);
        }
        averageHashSet /= repeats;
        averageTreeSet /= repeats;
        averageLinkedHashSet /= repeats;

        System.out.println("HashSet: " + averageHashSet + "\nTreeSet: " + averageTreeSet + "\nLinkedHashSet: " + averageLinkedHashSet);
    }

    public static void insertAverageTime(long sizeOfSet, int repeats) {
        ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(sizeOfSet);

        HashSet<Long> hashSet = new HashSet<>(array);
        TreeSet<Long> treeSet = new TreeSet<>(array);
        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);

        double averageHashSet = 0;
        double averageTreeSet = 0;
        double averageLinkedHashSet = 0;

        Random random = new Random();

        for (int i = 0; i < repeats; i++) {
            averageHashSet += insertIntoSet(hashSet, random.nextLong());
            averageTreeSet += insertIntoSet(treeSet, random.nextLong());
            averageLinkedHashSet += insertIntoSet(linkedHashSet, random.nextLong());
        }
        averageHashSet /= repeats;
        averageTreeSet /= repeats;
        averageLinkedHashSet /= repeats;

        System.out.println("HashSet: " + averageHashSet + "\nTreeSet: " + averageTreeSet + "\nLinkedHashSet: " + averageLinkedHashSet);
    }

    public static void removeAverageTime(long sizeOfSet, int repeats) {
        ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(sizeOfSet);

        HashSet<Long> hashSet = new HashSet<>(array);
        TreeSet<Long> treeSet = new TreeSet<>(array);
        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);

        double averageHashSet = 0;
        double averageTreeSet = 0;
        double averageLinkedHashSet = 0;

        Random random = new Random();

        for (int i = 0; i < repeats; i++) {
            averageHashSet += removeElementFromSet(hashSet, random.nextInt(array.size()), array);
            averageTreeSet += removeElementFromSet(treeSet, random.nextInt(array.size()), array);
            averageLinkedHashSet += removeElementFromSet(linkedHashSet, random.nextInt(array.size()), array);
        }
        averageHashSet /= repeats;
        averageTreeSet /= repeats;
        averageLinkedHashSet /= repeats;

        System.out.println("HashSet: " + averageHashSet + "\nTreeSet: " + averageTreeSet + "\nLinkedHashSet: " + averageLinkedHashSet);
    }

    public static void iterateAverageTime(long sizeOfSet, int repeats) {
        ArrayList<Long> array = (ArrayList<Long>) CreateBigArray.createBigArrayList(sizeOfSet);

        HashSet<Long> hashSet = new HashSet<>(array);
        TreeSet<Long> treeSet = new TreeSet<>(array);
        LinkedHashSet<Long> linkedHashSet = new LinkedHashSet<>(array);

        double averageHashSet = 0;
        double averageTreeSet = 0;
        double averageLinkedHashSet = 0;

        for (int i = 0; i < repeats; i++) {
            averageHashSet += iterateTroughSet(hashSet);
            averageTreeSet += iterateTroughSet(treeSet);
            averageLinkedHashSet += iterateTroughSet(linkedHashSet);
        }
        averageHashSet /= repeats;
        averageTreeSet /= repeats;
        averageLinkedHashSet /= repeats;

        System.out.println("HashSet: " + averageHashSet + "\nTreeSet: " + averageTreeSet + "\nLinkedHashSet: " + averageLinkedHashSet);
    }


}
