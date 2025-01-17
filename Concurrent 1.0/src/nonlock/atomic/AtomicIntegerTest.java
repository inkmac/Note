package nonlock.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();

        System.out.println("i.getAndIncrement() = " + i.getAndIncrement());
        System.out.println("i.incrementAndGet() = " + i.incrementAndGet());

        System.out.println("i.getAndAdd(5) = " + i.getAndAdd(5));
        System.out.println("i.addAndGet(5) = " + i.addAndGet(5));

        System.out.println("i.updateAndGet((x) -> x * 10) = " + i.updateAndGet((x) -> x * 10));

        System.out.println("i.get() = " + i.get());
    }
}
