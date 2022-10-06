package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere (List<Map<String, String>> books, Map<String, String> wheres) {
        List<Map<String, String>> result = new ArrayList<>();
        var x = wheres.size();
        for (Map<String, String> book : books) {
            boolean answer = false;
            var k = 0;
            for (Entry<String, String> sourceBook : book.entrySet()) {
                for (Entry<String, String> where : wheres.entrySet()) {
                    if (sourceBook.getKey().equals(where.getKey()) && sourceBook.getValue().equals(where.getValue())) {
                        k++;
                    }
                }
                if (k == x) {
                    answer = true;
                }
            }
            if (answer) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
