package DesignPattern.Adapter.Class;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();

        // 读取SD卡内容
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        // 通过适配器读取TF卡的内容
        String msg1 = computer.readSD(new SDAdapterTF());
        System.out.println(msg1);
    }
}