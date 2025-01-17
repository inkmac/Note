package nonlock.atomic;

import utils.Log;

import java.util.concurrent.atomic.AtomicInteger;

public class LockCas {
    private final AtomicInteger state = new AtomicInteger(0);

    public void lock() {
        while (true) {
            if (state.compareAndSet(0, 1)) {
                break;
            }
        }
    }

    public void unlock() {
        Log.debug("unlock");
        state.set(0);
    }
}
