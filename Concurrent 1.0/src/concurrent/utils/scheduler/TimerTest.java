package concurrent.utils.scheduler;

import utils.Log;
import utils.Time;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                Log.debug("task 1");
                Time.sleep(1000);
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                Log.debug("task 2");
            }
        };

        Log.debug("start...");

        timer.schedule(task1, 1000);
        timer.schedule(task2, 1000);
    }
}
