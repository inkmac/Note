package nonlock.atomic;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AtomicAccumulatorTest {
    public static void main(String[] args) {
        demo(
                () -> new AtomicLong(0),
                AtomicLong::getAndIncrement
        );

        demo(
                LongAdder::new,
                LongAdder::increment
        );
    }

    private static <T> void demo(Supplier<T> adderSupplier, Consumer<T> action) {
        T adder = adderSupplier.get();

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 500_000; j++) {
                    action.accept(adder);
                }
            }));
        }

        long start = System.nanoTime();
        threads.forEach(Thread::start);
        threads.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long end = System.nanoTime();

        System.out.println(adder + " cost: " + (end - start)/1000_000);
    }
}
