package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class App {

    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {

        MaxThread thread1 = new MaxThread(numbers);
        thread1.start();
        LOGGER.info(MaxThread.class.getName() + " start");
        MaxThread.currentThread().interrupt();
        LOGGER.info(MaxThread.class.getName() + " finish");

        MinThread thread2 = new MinThread(numbers);
        thread2.start();
        LOGGER.info(MinThread.class.getName() + " start");
        MaxThread.currentThread().interrupt();
        LOGGER.info(MinThread.class.getName() + " finish");

        var minMax = new HashMap<String, Integer>();

        minMax.put("min", thread2.getMin());
        minMax.put("max", thread1.getMax());
        return minMax;
    }
    // END
}
