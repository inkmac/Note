package Reflection;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Access {

    @Test
    public void Constructor() throws Exception{
        Class<User> userClass = User.class;

        // 得到private User1(String name, int age) 构造器
        // 1. 得到private构造器
        Constructor<User> privateConstructor = userClass.getDeclaredConstructor(String.class, int.class);
        // 2. 创建实例
        privateConstructor.setAccessible(true);  // 设置可访问性为 true, 允许调用私有构造函数
        User user = privateConstructor.newInstance("A", 100);

    }

    static class User {
        public String name;
        private int age;

        public User() {}

        private User(String name, int age) {}

        private void call(String arg) {
            System.out.println("calls " + arg);
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Test
    public void Field() throws Exception {
        Class<User> userClass = User.class;
        User user = userClass.newInstance();

        Field age = userClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(user, 200);

        // 对于static属性, 对象参数直接填null即可

        System.out.println(user);
    }

    @Test
    public void Method() throws Exception{
        Class<User> userClass = User.class;
        User user = userClass.newInstance();

        // 获取的方法有形参, 需将参数也带上
        Method call = userClass.getDeclaredMethod("call", String.class);
        call.setAccessible(true);
        call.invoke(user, "Hi");
        // 若为static方法, 则对象参数直接传null即可

        // 如果方法有返回值, 统一返回Object类型
        // 但运行类型与返回类型一致
        Object returns = call.invoke(user, "Hi");
    }
}
