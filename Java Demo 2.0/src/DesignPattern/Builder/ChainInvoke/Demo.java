package DesignPattern.Builder.ChainInvoke;

public class Demo {
    public static void main(String[] args) {
        // 链式调用生成phone
        Phone phone = new Phone.Builder()
                .setCpu("Intel")
                .setScreen("hp")
                .setMemory("Kingston")
                .setMainboard("ASUS")
                .build();

        System.out.println(phone);
    }
}
