package PerfomanceCheck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CreateBigArray {
    /**
     * Klasa pomocnicza do tworzenia Array'ów dla poszczegolnych Array'ów,
     * Setów itd.
     */

    public static List<Long> bigArrayList = new ArrayList<>();
    public static List<Long> bigLinkedList = new LinkedList<>();
    public static long[] bigArray;

    public static List<Long> createBigArrayList(long size) {
        Random random = new Random();
        for (long i = 0; i < size; i++) {
            bigArrayList.add(random.nextLong());
        }
        return bigArrayList;
    }
    public static List<Long> createBigLinkedList(long size) {
        Random random = new Random();
        for (long i = 0; i < size; i++) {
            bigLinkedList.add(random.nextLong());
        }
        return bigLinkedList;
    }
    public static long[] createBigArray(long size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            bigArray[i] = random.nextLong();
        }
        return bigArray;
    }


}
