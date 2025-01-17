package exercise;

import utils.Log;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class FindMax {
    public static void main(String[] args) throws Exception{
        State state = new State(100_000_000);
        Log.debug("start");
        final long begin = System.nanoTime();

        int max = findMaxByParallelIntStream(state);

        final long end = System.nanoTime();
        Log.debug("end, max={}, cost: {} ms", max, (end-begin)/1_000_000);
    }

    private static int findMaxByThreadPoolExecutor(State state) throws ExecutionException, InterruptedException {
        int[] numbers = state.numbers;
        int n = state.n;
        int step = n / 10;

        ArrayList<Future<Integer>> result = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(9);

        for (int i = 0; i < n; i += step) {
            int k = i;
            result.add(pool.submit(() -> {
                int max = 0;
                for (int j = k; j < k + step; j++) {
                    if (numbers[j] > max) {
                        max = numbers[j];
                    }
                }
                return max;
            }));
        }

        Log.debug("result size: {}", result.size());

        int max = 0;
        for (Future<Integer> future : result) {
            if (future.get() > max) {
                max = future.get();
            }
        }

        pool.shutdown();
        return max;
    }

    private static int findMaxByIntStream(State state) {
        return IntStream.of(state.numbers).max().orElse(0);
    }

    private static int findMaxByParallelIntStream(State state) {
        return IntStream.of(state.numbers).parallel().max().orElse(0);
    }

    private static int findMaxByCompare(State state) {
        int[] numbers = state.numbers;

        int max = 0;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static class State {
        final int[] numbers;
        final int n;

        State(int n) {
            this.n = n;
            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = ThreadLocalRandom.current().nextInt(1_000_000_000);
            }
        }
    }
}
