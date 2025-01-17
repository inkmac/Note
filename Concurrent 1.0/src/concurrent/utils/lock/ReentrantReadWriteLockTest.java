package concurrent.utils.lock;

import utils.Log;
import utils.Time;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        DataContainer data = new DataContainer();
        new Thread(data::read, "read 1").start();
        new Thread(data::read, "read 2").start();

        new Thread(data::write, "write 1").start();
    }
}

class DataContainer {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock r = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock w = lock.writeLock();

    public void read() {
        Log.debug("acquire read lock...");
        r.lock();
        try {
            Log.debug("read");
            Time.sleep(1000);
        } finally {
            Log.debug("release read lock");
            r.unlock();
        }
    }

    public void write() {
        Log.debug("acquire write lock...");
        w.lock();
        try {
            Log.debug("write");
            Time.sleep(1000);
        } finally {
            Log.debug("release write lock");
            w.unlock();
        }
    }
}
