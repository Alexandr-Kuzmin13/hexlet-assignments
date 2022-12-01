package exercise;

import java.util.Map;

// BEGIN
public class App {

    public static void printSquare(Circle circle) {

        try {
            var resultBuilder = (int) Math.ceil(circle.getSquare());

            String finalString = "\n" + "Вычисление окончено";

            System.out.print(resultBuilder + finalString);

        } catch (NegativeRadiusException v) {

            System.out.print(NegativeRadiusException.INCORRECT_VALUE);
        }


    }
}
// END
