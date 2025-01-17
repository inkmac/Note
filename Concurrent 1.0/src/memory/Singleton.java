package memory;

public final class Singleton {
    private static volatile Singleton INSTANCE = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();  // 确保先创建对象, 再赋值
                }
            }
        }

        return INSTANCE;
    }
}
