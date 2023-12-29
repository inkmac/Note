package Object_High;

//类变量(静态变量): 属于类本身的变量, 不属于类的实例(对象)

//(1) 被同一类型所有对象实例共享
//(2) 定义: (Modifier) static 数据类型 变量名
//(3) 访问: 类名.变量名

/*  细节:
1.static属性所有对象共享,值都相同, 除此之外都与普通属性相同
2.静态方法只可以访问静态成员, 但不能直接访问实例属性或实例方法, 不能使用this/super
  Way1: 实例属性或实例方法static化    Way2: 将实例对象写入形参列表,再调用
3.实例方法既可以访问实例成员, 也可以访问静态成员

4.static属性的声明不能写在任何方法中,只写在类中
5.构造器不能被static修饰
6.父类的静态方法可以被子类继承，但不能重写
 */


/* 类什么时候被加载?  答:class或其内部被调用的时候
① 创建对象实例时(new)
② 创建子类对象实例时, 父类也会被加载, 而且父类先被加载
③ 使用类的静态成员时
 */


class Child {
    private final String name;
    public static int stuCount = 0;
    public static double feeCount = 0;

    public Child(String name) {
        this.name = name;
    }

    public static void payFee(Child child, double fee) {
        Child.stuCount ++;
        Child.feeCount += fee;
        System.out.print(child.name + " joined" + "\t");
        System.out.print("now stuCount=" + Child.stuCount + "\t");
        System.out.println("now feeCount=" + Child.feeCount);
    }
}

class staticChild {
    public static void main(String[] args) {
        Child c1 = new Child("c1");
        Child.payFee(c1, 100);
        System.out.println(Child.feeCount);

        Child c2 = new Child("c2");
        Child.payFee(c2, 200);
        System.out.println(Child.feeCount);
    }
}

