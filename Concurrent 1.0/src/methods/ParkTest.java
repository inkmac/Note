package methods;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        System.out.println("park...");
        LockSupport.park();   // LockSupport.park() 在中断信号为true时不会进行阻塞
        System.out.println("going...");
        System.out.println("打断状态: " + Thread.interrupted());

        // LockSupport.unpack() 在 park() 之前或之后调用都有用
        LockSupport.unpark(Thread.currentThread());
    }

    /*
        每个Thread有一个Parker对象
        其中 _counter = 0

        1. 调用 park() 时:
            如果 _counter = 0, 就阻塞
            如果 _counter = 1, 就继续运行, 同时 _counter 置为 0

        2. 调用 unpark() 时:
            如果 线程被阻塞, 就继续运行
            如果 _counter = 0, 就继续运行, 同时 _counter 置为 1
     */
}
