package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        LinkedHashMap<String, Object> data11 = new LinkedHashMap<>(data1);
        LinkedHashMap<String, Object> data21 = new LinkedHashMap<>(data2);
        LinkedHashMap<String, String> data3 = new LinkedHashMap<>();
        if (data21.equals(new HashMap<>())) {
            for (Map.Entry<String, Object> mapElement : data11.entrySet()) {
                data3.put(mapElement.getKey(), "deleted");
            }
        }
        for (Map.Entry<String, Object> mapElement1 : data11.entrySet()) {
            for (Map.Entry<String, Object> mapElement2 : data21.entrySet()) {
                if (mapElement1.getKey().equals(mapElement2.getKey()) && mapElement1.getValue().equals(mapElement2.getValue())) {
                    data3.put(mapElement1.getKey(), "unchanged");
                    data21.remove(mapElement2.getKey());
                    break;
                } else if (mapElement1.getKey().equals(mapElement2.getKey()) && !mapElement1.getValue().equals(mapElement2.getValue())) {
                    data3.put(mapElement1.getKey(), "changed");
                    data21.remove(mapElement2.getKey());
                    break;
                } else {
                    data3.put(mapElement1.getKey(), "deleted");
                }
            }
        }
        for (Map.Entry<String, Object> mapElement : data21.entrySet()) {
            data3.put(mapElement.getKey(), "added");
        }
        return data3;
    }
}
//END
