package mutex.lock;

import utils.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static utils.Time.sleep;

public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock();
    private static boolean hasInt = false;
    private static boolean hasObject = false;

    private static final Condition waitInt = lock.newCondition();
    private static final Condition waitObject = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();

            try {
                Log.debug("Any Int? {}", hasInt);

                while (!hasInt) {
                    try {
                        waitInt.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Log.debug("Get Int, do...");
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();

            try {
                Log.debug("Any Object? {}", hasObject);

                while (!hasObject) {
                    try {
                        waitObject.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Log.debug("Get Object, do...");
            } finally {
                lock.unlock();
            }
        }, "B").start();

        sleep(1000);

        new Thread(() -> {
            lock.lock();

            try {
                hasInt = true;
                waitInt.signal();
            } finally {
                lock.unlock();
            }
        }, "deliver Int").start();

        sleep(1000);

        new Thread(() -> {
            lock.lock();

            try {
                hasObject = true;
                waitObject.signal();
            } finally {
                lock.unlock();
            }
        }, "deliver Object").start();
    }

    // condition.await() 前需要获取锁
    // await() 后, 会释放锁, 进入conditionObject等到
    // await() 线程被唤醒(或打断, 或超市), 会重新竞争lock锁
    // 竞争lock锁成功后, 从await()后继续执行
}

