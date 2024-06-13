package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Class_ {
    public static void main(String[] args) throws Exception {
        // 模拟配置文件
        String configuration =
                "classPath=Reflection.Cat\n" +
                "method=hi\n";


        String[] eachConfiguration = configuration.split("\n");
        String classPath = eachConfiguration[0].split("=")[1];
        String method = eachConfiguration[1].split("=")[1];

        // 使用反射
        // 1. 加载类, 返回Class类型对象
        Class<?> aClass = Class.forName(classPath);

        // 2. 通过 aClass 得到加载的类 Reflection.Cat 的对象实例
        Object o = aClass.newInstance();

        // 3. 通过 aClass 得到加载的类 Reflection.Cat 的 method 的方法对象
        Method method1 = aClass.getMethod(method);
        // 通过 method1 调用方法
        method1.invoke(o);

        // 4. 得到成员变量
        // getField() 不能得到private field
        Field nameField = aClass.getField("name");
        String name = (String) nameField.get(o);

        // 5. 获取构造器
        Constructor<?> constructor = aClass.getConstructor();  // 无参构造器 public Cat()
        Constructor<?> constructor1 = aClass.getConstructor(String.class);  // 有参构造器 public Cat(String name)
    }
}
