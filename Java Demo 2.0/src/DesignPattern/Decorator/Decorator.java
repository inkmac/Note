package DesignPattern.Decorator;

public abstract class Decorator extends FastFood {

    private FastFood fastFood;

    public Decorator(FastFood fastFood, double price, String description) {
        super(price, description);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
