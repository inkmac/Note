package MultiThreading;

/* 细节:
    1.一个线程只有在start()之后才会调用, 不能用run()调用, 不然就是一个普通方法, 没有真正启动线程, 是一个main线程的方法
    2.线程会在run方法结束后自动退出, 如果有无限循环需要手动判断什么时候退出!!!
    3.如果开启了多个线程, 线程启动顺序不一定是start()调用的顺序, 具体什么时候运行由线程调度器(Scheduler)决定
    4.多线程运行结果是随机的
    5.一个线程只能调用一次, 一旦线程结束, 它就不能再次启动, 生命周期只能是一次。如果想要再次执行相同的任务, 需要创建一个新的线程对象来执行相同的任务
 */


class Thread_ {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();

        //main线程和cat线程是并行执行的,互不影响
        //可以用Terminal的jconsole来监视
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread i=" + i);
            Thread.sleep(1000);
        }
    }
}


class Cat extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Cat start " + i + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
