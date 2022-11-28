package exercise;

import java.util.Comparator;
import java.util.List;

// BEGIN
class App {
    public static List<String> buildAppartmentsList(List<Home> appartments, int n) {
        return appartments.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .limit(n)
                .map(Home::toString)
                .toList();

    }
}
// END
