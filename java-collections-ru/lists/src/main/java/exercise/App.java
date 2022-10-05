package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// BEGIN
class App {
    public static boolean scrabble(String characterSet, String word) {

        if (characterSet.length() < word.length()) {
            return false;
        }
        word = word.toLowerCase(Locale.ROOT);
        List<String> firstList = new ArrayList<>(Arrays.asList(word.split("")));
        List<String> secondList = new ArrayList<>(Arrays.asList(characterSet.split("")));

        boolean answer = false;
        for (String s : firstList) {
            answer = true;
            for (var j = 0; j < secondList.size(); j++) {
                if (s.equals(secondList.get(j))) {
                    answer = true;
                    secondList.remove(secondList.get(j));
                    break;
                } else {
                    answer = false;
                }
            }
            if (!answer) {
                return false;
            }
        }
        return answer;
    }

}

//END
