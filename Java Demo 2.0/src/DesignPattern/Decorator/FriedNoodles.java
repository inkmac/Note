package DesignPattern.Decorator;

public class FriedNoodles extends FastFood {
    public FriedNoodles() {
        super(15, "FriedNoodles");
    }

    @Override
    public double cost() {
        return getPrice();
    }
}
