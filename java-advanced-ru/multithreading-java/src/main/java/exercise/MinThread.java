package exercise;

// BEGIN
public class MinThread extends Thread {

    private final int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {

        var x = numbers[0];
        for (var i = 1; i < numbers.length; i++) {
            if (x > numbers[i]) {
                x = numbers[i];
            }
        }
        min = x;
    }

    public int getMin() {
        return min;
    }
}
// END
