package exercise;

import java.util.Random;

// BEGIN
public class ListThread extends Thread {

    private final SafetyList safetyList;

    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    @Override
    public void run() {

        Random rnd = new Random();
        for (var i = 0; i < 1000; i++) {

            safetyList.add(rnd.nextInt(1000));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// END
