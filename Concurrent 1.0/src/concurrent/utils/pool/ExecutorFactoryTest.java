package concurrent.utils.pool;

import utils.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFactoryTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(() -> Log.debug("1"));
        threadPool.execute(() -> Log.debug("2"));
        threadPool.execute(() -> Log.debug("3"));
        threadPool.execute(() -> Log.debug("4"));
    }
}
