package PerfomanceCheck;

import java.util.function.Consumer;

public interface TimeMeasurement {
    /**
     * Interface stworzony do mierzenia czasu fukncji,
     * w celu nie powielania cały czas tego samego kodu
     */

    static double checkTime(Consumer consumer) {
        long startTime = System.nanoTime();
        consumer.accept(consumer);
        long endTime = System.nanoTime();
        double timeElapsed = ((double) endTime - (double) startTime) / 1_000_000_000;
        return timeElapsed;
    }
}
