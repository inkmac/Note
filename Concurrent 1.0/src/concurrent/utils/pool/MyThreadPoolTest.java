package concurrent.utils.pool;

import utils.Log;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(
                2,
                2000,
                TimeUnit.MILLISECONDS,
                10,
                BlockingQueue::put
        );
        for (int i = 0; i < 5; i++) {
            final int j = i;
            threadPool.execute(() -> Log.debug("{}", j));
        }
    }
}

class ThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final HashSet<Worker> workers = new HashSet<>();
    private final int coreSize;
    private final long timeout;
    private final TimeUnit timeUnit;
    private final RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
        this.rejectPolicy = rejectPolicy;
    }

    public void execute(Runnable task) {
        if (workers.size() < coreSize) {
            Worker worker = new Worker(task);
            Log.debug("new a worker: {}", worker);
            workers.add(worker);
            worker.start();
        } else {
            taskQueue.tryPut(rejectPolicy, task);
        }
    }

    class Worker extends Thread {
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            while (task != null || (task = taskQueue.poll(timeout, timeUnit)) != null) {
                try {
                    Log.debug("running... {}", task);
                    task.run();
                } catch (Exception e) {
                    throw new RuntimeException();
                } finally {
                    task = null;
                }
            }
            synchronized (workers) {
                Log.debug("worker is removed: {}", this);
                workers.remove(this);
            }
        }
    }
}

class BlockingQueue<T> {
    // 任务队列
    private final Deque<T> queue = new ArrayDeque<>();
    // 锁
    private final ReentrantLock lock = new ReentrantLock();
    // 生产者条件变量
    private final Condition fullWaitSet = lock.newCondition();
    // 消费者条件变量
    private final Condition emptyWaitSet = lock.newCondition();

    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public T poll(long timeout, TimeUnit unit) {
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (queue.isEmpty()) {
                if (nanos <= 0) {
                    return null;
                }
                nanos = emptyWaitSet.awaitNanos(nanos);
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                emptyWaitSet.await();
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public boolean offer(T task, long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (queue.size() == capacity) {
                if (nanos <= 0) {
                    return false;
                }
                Log.debug("wait to join queue... {}", task);
                nanos = fullWaitSet.awaitNanos(nanos);
            }
            Log.debug("add to queue {}", task);
            queue.addLast(task);
            emptyWaitSet.signal();
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void put(T task) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                Log.debug("wait to join queue... {}", task);
                fullWaitSet.await();
            }
            queue.addLast(task);
            emptyWaitSet.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if (queue.size() == capacity) {
                rejectPolicy.reject(this, task);
            } else {  // 有空闲
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}

@FunctionalInterface
interface RejectPolicy<T> {
    void reject(BlockingQueue<T> queue, T task);
}