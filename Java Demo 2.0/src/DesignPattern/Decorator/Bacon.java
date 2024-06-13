package DesignPattern.Decorator;

public class Bacon extends Decorator {
    public Bacon(FastFood fastFood) {
        super(fastFood, 5, "Egg");
    }

    /**
     *
     * @return 培根价格 + FastFood本身原来的价格
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
