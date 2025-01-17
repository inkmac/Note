package nonlock.unsafe;

import sun.misc.Unsafe;
import utils.UnsafeAccessor;

public class MyAtomicInteger {
    private static final Unsafe UNSAFE;
    private static final long valueOffset;
    private volatile int value;

    static {
        UNSAFE = UnsafeAccessor.getUnsafe();
        try {
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public int getValue() {
        return value;
    }

    public void increment(int amount) {
        while (true) {
            int prev = this.value;
            int next = prev + amount;
            if (UNSAFE.compareAndSwapInt(this, valueOffset, prev, next)) {
                break;
            }
        }
    }
}
