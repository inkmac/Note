package DesignPattern.Adapter.Class;

/**
 * @Introduction: Computer只有读取SD卡的能力, 不能读取TF卡
 */
public class Computer {

    public String readSD(SDCard sdCard) {
        return sdCard.readSD();
    }
}
