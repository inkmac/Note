package DesignPattern.Decorator;

public class Client {
    public static void main(String[] args) {
        FriedRice friedRice = new FriedRice();
        System.out.println(friedRice.getDescription() + " is " +  friedRice.cost() + "$");

        FastFood food = new FriedRice();
        food = new Egg(food);
        System.out.println(food.getDescription() + " is " +  food.cost() + "$");

        food = new Bacon(food);
        System.out.println(food.getDescription() + " is " +  food.cost() + "$");

    }
}
