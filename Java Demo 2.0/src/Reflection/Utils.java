package Reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Utils {

    @Test
    public void api_class() {
        Class<Cat> catClass = Cat.class;

        // getName() 获取全类名
        // getSimpleName() 获取简单类名
        // getPackage() 获取类所在的包路径

        // getFields()  获取所有public的属性, 包括本类和父类的
        // getDeclaredFields()  获取本类所有属性

        // getMethods()  获取所有public的方法, 包括本类和父类的
        // getDeclaredMethods()  获取本类所有方法

        // getConstructor()  获取本类所有public的Constructor
        // getDeclaredConstructor()  获取本类所有Constructor

        // getSuperclass()  以Class 获取父类信息
        // getInterfaces()  以Class[] 获取实现的interface信息
        // getAnnotations() 以Annotation[] 获取类的注解信息

    }

    @Test
    public void api_field() {
        Field field;

        // getModifiers() 获取字段修饰符, 返回int
        // 说明: 默认修饰符: 0, public: 1, private:2, protected: 4, static: 8, final: 16

        // getType() 返回该字段所属数据类型的Class对象
        // getName() 返回属性名
    }

    @Test
    public void api_method() {
        Method method;

        // getModifiers() 获取方法修饰符, 返回int
        // 说明: 默认修饰符: 0, public: 1, private:2, protected: 4, static: 8, final: 16

        // getReturnType() 得到返回类型的Class对象
        // getParameterTypes()  得到参数类型的Class[]对象

        // getName() 返回属性名
    }

    @Test
    public void api_modifier() {
        Constructor<?> constructor;

        // getModifiers() 获取构造器的修饰符, 返回int
        // 说明: 默认修饰符: 0, public: 1, private:2, protected: 4, static: 8, final: 16

        // getParameterTypes()  得到参数类型的Class[]对象

        // getName() 返回构造器名
    }
}
