package methods;

public class TwoPhaseTermination {

    public static void main(String[] args) throws InterruptedException {
        Termination t = new Termination();
        t.start();

        Thread.sleep(3500);
        t.stop();
    }


    static class Termination {
        private Thread monitor;

        public void start() {
            monitor = new Thread(() -> {
                System.out.println("start monitoring");

                while (!monitor.isInterrupted()) {

                    System.out.println("monitoring...");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {  // InterruptedException 会重置打断标记
                        e.printStackTrace();
                        monitor.interrupt();   // 重新设置打断标记
                    }
                }

                System.out.println("exiting");
            });

            monitor.start();
        }

        public void stop() {
            if (monitor != null) {
                monitor.interrupt();
            }
        }
    }
}
