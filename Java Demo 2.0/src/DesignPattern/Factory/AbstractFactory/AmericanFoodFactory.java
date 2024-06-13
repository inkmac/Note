package DesignPattern.Factory.AbstractFactory;

public class AmericanFoodFactory implements FoodFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Cake();
    }
}
