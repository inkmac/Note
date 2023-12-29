package MultiThreading;

//Runnable: 适用于补充单继承机制; 多个线程共享一个资源(对象)

class Runnable_ {
    public static void main(String[] args){
        Dog dog = new Dog();
        Thread thread1 = new Thread(dog);    //将Dog塞进新的线程
        Thread thread2 = new Thread(dog);
        thread1.start();
        thread2.start();
    }
}


class Dog implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Dog Bark~\t" + Thread.currentThread().getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
