package methods;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("running...");
                Thread.sleep(1000);
                return 100;
            }
        });

        Thread t = new Thread(task, "t1");
        t.start();

        System.out.println("task.get() = " + task.get());
    }
}
