package DesignPattern.SingleInstance;

//单例模式饿汉式: 直接创建对象

/*  如何创建:
1.构造器私有化
2.类的内部创建私有static对象, 并赋给对象引用
3.向外界提供一个公共static方法
 */

class SingleTon {
    public static void main(String[] args) {
        Dog a1 = Dog.getInstance();
        System.out.println(a1);

    }
}

class Dog {
    private final String name;

    private final static Dog dog = new Dog("Goe");

    private Dog(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    public static Dog getInstance() {
        return dog;
    }

    @Override
    public String toString() {
        return "girlfriend{" +
                "name='" + name + '\'' +
                '}';
    }
}