package MultiThreading;

/*
1.setName  设置名称
2.setPriority(Thread.$rank$)  设置优先级
3.setDaemon()  设置为守护线程
4.interrupt  打断线程, 如果在休眠,就终止休眠
5.join  线程的插队, 先执行插入的线程的任务

6.Thread.yield  线程的礼让, 让出CPU,让其它线程执行,但让出时间不确定,也不一定让成功
 */

class Methods01 {
    public static void main(String[] args) {
        Eat eat = new Eat();
        eat.setName("BOB");
        eat.setPriority(Thread.MIN_PRIORITY);
        eat.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread Stop");
        eat.interrupt();
    }
}


class Eat extends Thread {
    @Override
    public void run() {
        for (;;) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Eats~\t" + Thread.currentThread().getName());
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println();
            }
        }
    }
}

