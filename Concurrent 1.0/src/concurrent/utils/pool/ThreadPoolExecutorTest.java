package concurrent.utils.pool;

import utils.Log;
import utils.Time;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        invokeAny(pool);
    }

    private static void submit(ExecutorService pool) throws ExecutionException, InterruptedException {
        Future<String> future = pool.submit(() -> {
            Log.debug("running");
            Time.sleep(1000);
            return "ok";
        });

        Log.debug("future: {}", future.get());
        // 如果执行过程中有异常, future.get() 会直接抛出 ExecutionException
    }

    private static void invokeAll(ExecutorService pool) throws InterruptedException {
        List<Future<String>> futures = pool.invokeAll(Arrays.asList(
                () -> {
                    Log.debug("begin");
                    Time.sleep(1000);
                    return "1";
                },
                () -> {
                    Log.debug("begin");
                    Time.sleep(1000);
                    return "2";
                },
                () -> {
                    Log.debug("begin");
                    Time.sleep(1000);
                    return "3";
                }
        ));

        futures.forEach(f -> {
            try {
                Log.debug("{}", f.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void invokeAny(ExecutorService pool) throws InterruptedException, ExecutionException {
        String result = pool.invokeAny(Arrays.asList(
                () -> {
                    Log.debug("begin");
                    Time.sleep(1000);
                    Log.debug("end");
                    return "1";
                },
                () -> {
                    Log.debug("begin");
                    Time.sleep(500);
                    Log.debug("end");
                    return "2";
                },
                () -> {
                    Log.debug("begin");
                    Time.sleep(1500);
                    Log.debug("end");
                    return "3";
                }
        ));

        Log.debug("{}", result);
    }

    private static void shutdown(ExecutorService pool) {
        // pool.shutdown();
        // 所有任务(包括BlockQueue中的)都执行完才关闭
        // 不会阻塞调用线程
        // 用 pool.awaitTermination() 等待线程池的关闭

        // List<Runnable> tasks = pool.shutdownNow();
        // 返回的是等待队列中的任务
        // 会向所有线程发送中断信号
    }
}
