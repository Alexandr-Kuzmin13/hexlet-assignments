package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {

    public static final String INCORRECT_VALUE = "Не удалось посчитать площадь" + "\n" + "Вычисление окончено";

    public NegativeRadiusException(String message) {
        super(message);
    }

}
// END
