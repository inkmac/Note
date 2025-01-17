package mutex.synchronize;

import utils.Log;

public class WaitNotify {
    private final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(WaitNotify::run, "t1").start();

        new Thread(WaitNotify::run, "t2").start();

        Thread.sleep(1000);

        Log.debug("Notify...");

        synchronized (lock) {
//            lock.notify();  // 唤醒上一个线程
            lock.notifyAll();  // 唤醒所有线程
        }
    }

    private static void run() {
        synchronized (lock) {
            Log.debug("start");

            try {
                lock.wait();   // 让线程在lock上一直等待下去, 并释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.debug("end");
        }
    }
}