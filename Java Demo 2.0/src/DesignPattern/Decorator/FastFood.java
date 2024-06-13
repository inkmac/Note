package DesignPattern.Decorator;

public abstract class FastFood {
    private double price;
    private String description;

    public FastFood() {}

    public FastFood(double price, String description) {
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // 用于子类计算食物的总价格
    public abstract double cost();

}
