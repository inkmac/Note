package DesignPattern.Proxy;

public class ProxyPoint implements SellTickets {

    // 声明火车站类对象
    private final TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("charge some additional fees | 15$");
        trainStation.sell();
    }
}
