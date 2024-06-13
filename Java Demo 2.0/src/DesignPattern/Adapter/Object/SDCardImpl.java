package DesignPattern.Adapter.Object;

public class SDCardImpl implements SDCard {
    private String msg = "SD Default Message";

    @Override
    public String readSD() {
        msg = "SDCard read msg: " + msg;
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        this.msg = msg;
        System.out.println("SDCard read msg: " + msg);
    }
}
