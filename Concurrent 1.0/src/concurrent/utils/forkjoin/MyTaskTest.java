package concurrent.utils.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MyTaskTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Integer i = pool.invoke(new MyTask(5));
        System.out.println(i);
    }
}

class MyTask extends RecursiveTask<Integer> {
    private final int n;

    public MyTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n == 1) {
            return 1;
        }

        MyTask t1 = new MyTask(n - 1);
        t1.fork();
        Integer res = n + t1.join();
        return res;
    }
}

