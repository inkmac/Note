package mutex.synchronize;

import utils.Log;

public class GuardedObjectTest {
    public static void main(String[] args) {
        GuardedObject guardObject = new GuardedObject();

        new Thread(() -> {
            Log.debug("等待结果...");
            String result = (String) guardObject.get();
            Log.debug("结果是: {}", result);
        }, "t1").start();

        new Thread(() -> {
            Log.debug("获取结果...");
            String result = getString();
            guardObject.complete(result);
        }, "t2").start();
    }

    private static String getString() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "result";
    }

    // classes

    static class GuardedObject {
        private Object response;

        public synchronized Object get() {
            while (response == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }

        public synchronized Object get(long timeout) {
            long begin = System.currentTimeMillis();
            long passTime = 0;

            while (response == null) {
                long waitTime = timeout - passTime;

                if (waitTime <= 0) {
                    break;
                }

                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                passTime = System.currentTimeMillis() - begin;
            }

            return response;
        }

        public synchronized void complete(Object response) {
            this.response = response;
            this.notifyAll();
        }
    }
}


