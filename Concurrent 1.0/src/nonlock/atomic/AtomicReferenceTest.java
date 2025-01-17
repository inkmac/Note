package nonlock.atomic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static void main(String[] args) {
        // 保护的是整个对象

        DecimalAccount account = new DecimalAccountCas(BigDecimal.valueOf(0));
        account.demo();
    }
}

class DecimalAccountCas implements DecimalAccount {
    private final AtomicReference<BigDecimal> balance;

    public DecimalAccountCas(BigDecimal balance) {
        this.balance = new AtomicReference<>(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return balance.get();
    }

    @Override
    public void deposit(BigDecimal amount) {
        while (true) {
            BigDecimal prev = balance.get();
            BigDecimal next = prev.add(amount);

            if (balance.compareAndSet(prev, next)) {
                break;
            }
        }
    }
}


interface DecimalAccount {
    BigDecimal getBalance();

    void deposit(BigDecimal amount);

    default void demo() {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(() -> this.deposit(BigDecimal.valueOf(10))));
        }

        final long startTime = System.nanoTime();
        threads.forEach(Thread::start);
        threads.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        final long endTime = System.nanoTime();
        System.out.println(this.getBalance()
                + " cost: " + (endTime - startTime)/1000_000 + " ms");
    }
}