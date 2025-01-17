package nonlock.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicArrayTest {
    public static void main(String[] args) {
        // 保护的是数组里面的元素
        new AtomicReferenceArray<>(5);
    }
}

