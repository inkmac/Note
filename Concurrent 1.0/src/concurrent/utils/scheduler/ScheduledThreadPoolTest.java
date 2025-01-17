package concurrent.utils.scheduler;

import utils.Log;
import utils.Time;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        scheduleWithFixedDelay(pool);
    }

    private static void schedule(ScheduledExecutorService pool) {
        pool.schedule(() -> {
            Log.debug("task 1");
            Time.sleep(1000);
        }, 1, TimeUnit.SECONDS);

        pool.schedule(() -> {
            Log.debug("task 2");
        }, 1, TimeUnit.SECONDS);
    }

    private static void scheduleAtFixRate(ScheduledExecutorService pool) {
        Log.debug("start...");

        pool.scheduleAtFixedRate(() -> {
            Log.debug("running...");
        }, 1, 1, TimeUnit.SECONDS);
    }

    private static void scheduleWithFixedDelay(ScheduledExecutorService pool) {
        Log.debug("start...");

        pool.scheduleWithFixedDelay(() -> {
            Log.debug("running...");
            Time.sleep(2000);
        }, 1, 1, TimeUnit.SECONDS);
    }
}
