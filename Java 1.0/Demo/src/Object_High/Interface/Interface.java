package Object_High.Interface;

//Interface接口: 使得代码更加规范, 方便统一管理,使用

/*  细节:
1.接口不可以被实例化
2.接口方法全都是public abstract, 且可以省略
3.接口的属性全部都是public static final的, 可直接调用且可以省略

4.default关键字可以让接口中的方法有方法体, 实现类可以直接获得, 而不需要去强制实现这个方法, 但仅限于interface使用
5.static的方法必须有方法体, 可以被实现类直接调用,而不需要创建对象

6.一个普通类若想实现接口, 就必须将接口的所有方法全部实现, 然后也可以有自己的成员, 用Generate或者alt+Shift+Enter快速生成
7.一个普通类若实现接口,就获得了接口中所有元素
8.抽象类实现接口,可以不用实现接口的方法
9.接口不能继承其它类, 但可以继承其它(多个)接口, 并且自动继承其中方法(无需实现)
10.一个类可以同时实现多个接口和一个继承

11.接口的修饰符只能是public或默认
 */


/*  接口 VS 继承
1.继承是直接拥有, 接口还未实现但给了一个标准模版,且更为严格
2.实现接口是对java单继承机制的一种补充
3,接口在一定程度上实现代码解耦[即:接口规范性+动态绑定]
 */


interface AA {
    void hi();
    void say();        //立即想到为 public abstract void say();
    int n1 = 10;       //立即想到为 public static final int n1 = 10;
}

interface BB {}

class A implements AA,BB {
    @Override
    public void hi() {
        System.out.println("Hi");
    }

    @Override
    public void say() {
        System.out.println("Say" + AA.n1);
    }

}
