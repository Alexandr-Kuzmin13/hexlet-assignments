package exercise;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String text) {
        Map<String, Integer> wordsCount = new HashMap<>();
        if (text.equals("")) {
            return new HashMap<>();
        }
        List<String> textListArray1 = new ArrayList<>(Arrays.asList(text.split(" ")));
        List<String> textListArray2 = new ArrayList<>(Arrays.asList(text.split(" ")));
        String key = null;
        for (String word : textListArray1) {
            var k = 0;
            var i = 0;
            while (i < textListArray2.size()) {
                if (word.equals(textListArray2.get(i))) {
                    k += 1;
                    key = textListArray2.get(i);
                    textListArray2.remove(textListArray2.get(i));
                } else {
                    i++;
                }
            }
            if (k > 0) {
                wordsCount.put(key, k);
            }
        }
        return wordsCount;
    }

    public static String toString(Map<String, Integer> dictionary) {
        String result = "";
        for (Map.Entry<String, Integer> word: dictionary.entrySet()) {
            result = result + "  " + word.getKey() + ": " + word.getValue() + "\n";
        }
        if (dictionary.equals(new HashMap<>())) {
            return "{}";
        }
        return "{\n" + result + "}";
    }
}
//END
