package concurrent.utils.lock;

import utils.Log;
import utils.Time;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Log.debug("running...");
                    Time.sleep(1000);
                    Log.debug("end...");
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
