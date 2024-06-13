package DesignPattern.Factory.AbstractFactory;

public class Demo {
    public static void main(String[] args) {

        FoodFactory factory = new ItalyFoodFactory();

        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
