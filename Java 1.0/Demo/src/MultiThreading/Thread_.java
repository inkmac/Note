package MultiThreading;

/*  细节
一个类没有继承Thread也可以使用, 可用于启动线程
一个线程只有在start()之后才会运行
线程会在run方法结束后自动退出, 如果有无限循环需要手动判断什么时候退出!!!

 */

@SuppressWarnings({"ALL"})
class Thread_ {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        Thread thread1 = new Thread(cat);    //可以封到一个Thread里面, 这个线程对象仍然是cat
        //不能 cat.run() 调用, 不然就是一个普通方法,没有真正启动线程, 是一个main线程的方法, 会阻塞
        thread1.start();    //只能用start()开启线程, start()来调用run()
//        thread1.start();  //一个线程只能调用1次


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
