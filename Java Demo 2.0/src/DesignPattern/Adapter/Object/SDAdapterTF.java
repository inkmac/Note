package DesignPattern.Adapter.Object;

import DesignPattern.Adapter.Class.TFCard;

/**
 * @Introduction: 适配器类, 对象适配器模式:
 *                    适配器类内部声明一个被适配对象的实例,
 *                    通过调用被适配对象的方法来实现目标接口的功能,
 *                    利用了合成复用原则, 降低了耦合度
 */
public class SDAdapterTF implements SDCard {
    private final TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("via SD adapter to read TF card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write TF card");
        tfCard.writeTF(msg);
    }
}
