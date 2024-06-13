package DesignPattern.SingleInstance;

//单例模式懒汉式: 先不创建对象,等需要的时候再创建(节约空间)

/*  如何创建:
1.构造器私有化
2.类的内部创建私有static对象, 但不赋值
3.向外界提供一个公共static方法, 并检测是否调用了cat对象
 */

class LazySingle {
    public static void main(String[] args) {
        Cat instance = Cat.getInstance();
        System.out.println(instance);
    }
}

class Cat {
    private final String name;
    private static Cat cat;     // 先不初始化, 当需要使用的时候再创建对象

    private Cat(String name) {
        System.out.println("little Cat~");
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("Cat");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

