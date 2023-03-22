package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class App {

    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        MaxThread thread1 = new MaxThread(numbers);
        thread1.start();
        LOGGER.info("Thread " + thread1.getName() + " started");

        MinThread thread2 = new MinThread(numbers);
        thread2.start();
        LOGGER.info("Thread " + thread2.getName() + " started");

        try {
            thread2.join();
            LOGGER.log(Level.INFO, "Thread " + thread2.getName() + " finished");
            thread1.join();
            LOGGER.log(Level.INFO, "Thread " + thread1.getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        var minMax = new HashMap<String, Integer>();

        minMax.put("min", thread2.getMin());
        minMax.put("max", thread1.getMax());
        return minMax;
    }
    // END
}
