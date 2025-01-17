package memory;

import utils.Log;

import static utils.Time.sleep;

public class VisibilityTest {
    // volatile: 使得读取在内存中而不是缓存中
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {

            }
        }).start();

        sleep(1000);

        Log.debug("Stop");
        flag = false;
    }
}
