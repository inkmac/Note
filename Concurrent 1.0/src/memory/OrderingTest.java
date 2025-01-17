package memory;

public class OrderingTest {
    private volatile boolean ready = false;
    private int num = 0;
    private int testNum;

    public void action1() {
        num = 2;
        ready = true;
        // 写屏障
    }

    public void action2() {
        // 读屏障
        if (ready) {
            testNum = num + num;
        } else {
            testNum = 1;
        }
    }

    // 对于写入 volatile 变量的代码: 在写操作前的所有操作会先于写操作执行。
    // 对于读取 volatile 变量的代码: 在读操作后的所有操作会在读操作之后执行。
}
