package DesignPattern.Adapter.Class;

/**
 * @Introduction: 适配器类, 用类适配器模式:
 *                  通过继承被适配的类,
 *                  使得适配器类具有了被适配类的一些特性,
 *                  从而可以在目标接口中实现对被适配类的功能进行适配
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {
    @Override
    public String readSD() {
        System.out.println("via SD adapter to read TF card");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write TF card");
        writeTF(msg);
    }
}
