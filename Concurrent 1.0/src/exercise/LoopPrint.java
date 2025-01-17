package exercise;

import utils.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static utils.Time.sleep;

/**
 * 要求交替循环输出abcabcabcabcabc
 */
public class LoopPrint {
    public static void main(String[] args) {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();

        new Thread(() -> awaitSignal.print("a", a, b)).start();
        new Thread(() -> awaitSignal.print("b", b, c)).start();
        new Thread(() -> awaitSignal.print("c", c, a)).start();

        sleep(1000);

        awaitSignal.lock();
        try {
            Log.debug("Start");
            a.signal();   // 先让a唤醒
        } finally {
            awaitSignal.unlock();
        }
    }

    static class AwaitSignal extends ReentrantLock {
        private final int loopNumber;

        public AwaitSignal(int loopNumber) {
            this.loopNumber = loopNumber;
        }

        public void print(String str, Condition current, Condition next) {
            for (int i = 0; i < loopNumber; i++) {
                lock();

                try {
                    current.await();
                    System.out.print(str);
                    next.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    unlock();
                }
            }
        }
    }
}
