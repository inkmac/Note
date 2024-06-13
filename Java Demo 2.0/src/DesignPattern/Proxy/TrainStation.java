package DesignPattern.Proxy;

public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("Sell tickets in train station | 200$");
    }
}
