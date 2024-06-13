package DesignPattern.Decorator;

public class FriedRice extends FastFood {
    public FriedRice() {
        super(10, "FriedRice");
    }

    @Override
    public double cost() {
        return getPrice();
    }
}
