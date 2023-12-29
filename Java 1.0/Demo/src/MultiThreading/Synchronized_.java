package MultiThreading;

//synchronized: 同一时刻最多有一个线程访问, 为并发机制
//保护的是同一对象的资源

/*  synchronized方法
1.非静态方法的synchronized锁是对象本身, this
2.静态方法的synchronized锁是类本身, 当前类.class
 */

/*  synchronized代码块: alt+ctrl+T环绕
1.用 synchronized($锁$) {}
2.这个$锁$就是互斥锁, 一般为this
3.一般互斥锁只有唯一一把, 同时只能被一个线程获取, 保证只有获取到该锁的线程可以访问被保护的共享资源
 */


/*  锁什么时候释放
1.线程同步方法,代码块执行完毕
2.运行时遇到break; return
3.运行时出现了未处理的Error或Exception, 导致异常结束
4.执行了wait()方法, 当前线程会暂停并释放锁

什么时候不释放锁
1.调用Thread.sleep或Thread.yield方法, 暂停线程但不释放锁
2.线程使用同步代码块时候,其他线程调用了该线程的suspend()方法将该线程挂起,但该线程不会释放锁
  提示: 应避免使用suspend()和resume()来控制线程,因为方法过时了
 */


class synchronized_ {
    public static void main(String[] args) {
        buy buy = new buy();
        buy buy2 = new buy();       //如果是不同对象, synchronize没有效果
        Thread t1 = new Thread(buy);
        t1.setName("T1");
        Thread t2 = new Thread(buy);
        t2.setName("T2");

        t1.start();
        t2.start();
    }
}


class buy implements Runnable {
    private int money= 10000;
    private final Object obj = new Object();

    @Override
    public void run() {
        for (;;) {
            synchronized (obj) {
                if (money <= 0) {
                    System.out.println("Not Enough Money");
                    break;
                }
                money -= 1000;
                System.out.println("Monet Left: " + money);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}





