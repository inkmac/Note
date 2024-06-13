package DesignPattern.Adapter.Object;

public class TFCardImpl implements TFCard {
    private String msg = "TF default Message";

    @Override
    public String readTF() {
        msg = "TFCard read msg: " + msg;
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        this.msg = msg;
        System.out.println("TFCard read msg: " + msg);
    }
}
