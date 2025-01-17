package nonlock.atomic;

import utils.Log;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {
    static final AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) {
        Log.debug("main start...");

        String prev = ref.getReference();
        int stamp = ref.getStamp();   // 版本号

        Log.debug("{}", stamp);
    }
}

