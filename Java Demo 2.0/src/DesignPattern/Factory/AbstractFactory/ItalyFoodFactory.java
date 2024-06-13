package DesignPattern.Factory.AbstractFactory;

public class ItalyFoodFactory implements FoodFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Chocolate();
    }
}
