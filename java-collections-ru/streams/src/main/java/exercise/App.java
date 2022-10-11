package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static final String FREE_DOMAINS_ONE = "@gmail.com";
    public static final String FREE_DOMAINS_TWO = "@yandex.ru";
    public static final String FREE_DOMAINS_THREE = "@hotmail.com";
    public static int getCountOfFreeEmails(List<String> emails) {
        return (int) emails.stream()
                .filter(num -> num.contains(FREE_DOMAINS_ONE) || num.contains(FREE_DOMAINS_TWO) || num.contains(FREE_DOMAINS_THREE))
                //.filter(num -> num.contains(FREE_DOMAINS_TWO))
                //.filter(num -> num.contains(FREE_DOMAINS_THREE))
                .count();
    }
}
// END
