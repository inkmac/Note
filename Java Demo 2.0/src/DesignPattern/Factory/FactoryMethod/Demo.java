package DesignPattern.Factory.FactoryMethod;


public class Demo {
    public static void main(String[] args) {
        //创建咖啡店类对象
        CoffeeStore store = new CoffeeStore();
        CoffeeFactory factory = new LatteCoffeeFactory();
        store.setFactory(factory);
        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }
}
