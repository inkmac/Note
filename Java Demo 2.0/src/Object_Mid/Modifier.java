package Object_Mid;

//public: 对外全部公开
//protected: 对子类, 本包(Object_Mid), 本类
//默认: 对本包, 本类
//private: 对本类
/*  细节:
1.可以用来修饰类中的属性, 成员方法, 构造器, 类(但只能用public和默认修饰)
2.一个类对象的正常创建范围就在本包中(无论是否为public)
  若想访问其他包的类,使用import或者类的全限定名(从根目录开始) + public
3.无论什么时候,对象访问都遵循Modifier的原则
 */

public class Modifier {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    private void m1() {
        System.out.println("n1=" + n1 + " n2=" + n2 + " n3=" + n3 + " n4=" + n4);
    }
}

