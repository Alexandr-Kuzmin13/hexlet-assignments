package exercise;

// BEGIN
public class MaxThread extends Thread {

    private final int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {

        var x = numbers[0];
        for (var i = 1; i < numbers.length; i++) {
            if (x < numbers[i]) {
                x = numbers[i];
            }
        }
        max = x;
    }

    public int getMax() {
        return max;
    }
}
// END
