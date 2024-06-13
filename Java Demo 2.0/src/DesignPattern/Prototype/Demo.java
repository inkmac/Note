package DesignPattern.Prototype;

/**
 * @Introduction: 演示浅克隆
 */

public class Demo {
    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        Prototype clone = prototype.clone();

        System.out.println(prototype == clone);
    }
}
