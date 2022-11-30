package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorage) {

        var resultMap = keyValueStorage.toMap();
        Map<String, String> clone = new HashMap<>();

        TreeSet<String> keys = new TreeSet<>(resultMap.keySet());

        for (String key: keys) {
            clone.put(resultMap.get(key), key);
        }
        resultMap.putAll(clone);

        TreeSet<String> keysAfter = new TreeSet<>(resultMap.keySet());

        for (String key: keysAfter) {
            if (!clone.containsKey(key)) {
                resultMap.remove(key);
            }
        }
    }
}
// END