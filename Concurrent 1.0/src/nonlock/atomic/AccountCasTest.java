package nonlock.atomic;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountCasTest {
    public static void main(String[] args) {
        Account account = new AccountCas(0);
        account.demo();
    }
}

class AccountCas implements Account {
    private final AtomicInteger balance;

    public AccountCas(int balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public int getBalance() {
        return balance.get();
    }

    @Override
    public void deposit(int amount) {
        while (true) {
            int prev = balance.get();
            int next = prev + amount;

            if (balance.compareAndSet(prev, next)) {
                break;
            }
        }
    }
}

interface Account {
    int getBalance();

    void deposit(int amount);

    default void demo() {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(() -> this.deposit(10)));
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
