package DesignPattern.Factory.AbstractFactory;

public interface FoodFactory {

    // 生产咖啡的功能
    Coffee createCoffee();

    // 生产甜点的功能
    Dessert createDessert();
}
