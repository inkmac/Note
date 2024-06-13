package DesignPattern.Factory.FactoryMethod;

/**
 * @Introduction: 咖啡类接口
 */

public interface Coffee {

    String getName();

    // 加糖
    default void addSugar() {
        System.out.println("加糖");
    }

    // 加奶
    default void addMilk() {
        System.out.println("加奶");
    }
}

