package exercise;

import java.util.Arrays;

class SafetyList {
    // BEGIN
    private int[] numberArray = new int[10];

    private int size;

    public synchronized void add(int element) {

        if (numberArray.length == size) {
            int[] extendedData = new int[numberArray.length * 2];
            System.arraycopy(numberArray, 0, extendedData, 0, numberArray.length);
            numberArray = extendedData;
        }

        numberArray[size++] = element;
    }
    public int getSize() {
        return size;
    }
    // END
}
