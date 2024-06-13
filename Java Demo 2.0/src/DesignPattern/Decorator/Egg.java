package DesignPattern.Decorator;

public class Egg extends Decorator {

    public Egg(FastFood fastFood) {
        super(fastFood, 2, "Egg");
    }

    /**
     *
     * @return 鸡蛋价格 + FastFood本身原来的价格
     */
    @Override
    public double cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + getFastFood().getDescription();
    }
}
