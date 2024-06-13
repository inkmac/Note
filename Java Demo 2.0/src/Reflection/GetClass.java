package Reflection;

/**
 * 演示得到Class对象的6种方式
 */

public class GetClass {
    public static void main(String[] args) throws Exception {

        // 1. Class.forName()
        String classPath = "Reflection.Cat";    // 通过读取配置文件获取
        Class<?> aClass = Class.forName(classPath);
        System.out.println("aClass = " + aClass);

        // 2. 类.class    应用场景: 参数传递
        Class<Cat> catClass = Cat.class;
        System.out.println("catClas" +
                "s = " + catClass);

        // 3. 对象.getClass()  应用场景: 有对象实例
        Cat cat = new Cat();
        Class<? extends Cat> aClass1 = cat.getClass();
        System.out.println("aClass1 = " + aClass1);

    }
}
