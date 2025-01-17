package memory;

import utils.Log;

import static utils.Time.sleep;

public class TwoPhaseTerminationTest {
    public static void main(String[] args) {
        TwoPhaseTermination test = new TwoPhaseTermination();
        test.start();

        sleep(2000);
//        test.stop();
    }

    private static class TwoPhaseTermination {
        private Thread monitor;
        private volatile boolean stop = false;
        private boolean isStarted = false;

        public void start() {
            synchronized (this) {
                if (isStarted) {
                    return;
                }
                isStarted = true;
            }

            monitor = new Thread(() -> {
                Log.debug("start monitoring");

                while (!stop) {

                    Log.debug("monitoring...");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }

                Log.debug("exiting");
            });

            monitor.start();
        }

        public void stop() {
            stop = true;
            monitor.interrupt();
        }
    }
}
