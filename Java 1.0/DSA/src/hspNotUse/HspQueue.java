package hspNotUse;

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;   //用于存放数据, 模拟队列

    //创建Queue
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;   //指向队列头部
        rear = -1;    //指向队列尾部
    }

    //判断Queue是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断Queue是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到queue
    public void addQueue(int n) {
        if (isFull()) {
            throw new RuntimeException("Already full");
        }

        rear++;
        arr[rear] = n;
    }

    //获取数据, 出queue
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("hspNotUse.Queue.Queue empty");
        }

        front++;
        return arr[front];
    }

    //显示queue,遍历
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("hspNotUse.Queue.Queue Empty");
            return;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public int getHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("hspNotUse.Queue.Queue Empty");  //return的话不能成功, 直接抛出异常代替
        }

        return arr[front + 1];
    }
}


class Test1 {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        queue.addQueue(10);
        queue.addQueue(100);
        queue.addQueue(1000);

        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
        queue.showQueue();
    }
}
