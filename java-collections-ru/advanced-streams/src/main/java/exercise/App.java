package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String config) {
        return Arrays.stream(config.lines()
                        .filter(num -> num.startsWith("environment"))
                        .map(num -> num.replaceAll("environment=", ""))
                        .collect(Collectors.joining())
                        .split("[,\"]"))
                .filter(num -> num.startsWith("X_FORWARDED_"))
                .map(num -> num.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
