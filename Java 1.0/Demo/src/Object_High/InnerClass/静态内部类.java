package Object_High.InnerClass;

//静态内部类: 定义在外部类的成员位置上, 且有static修饰
/*
1.可以直接访问外部的静态成员,包括private, 不可直接访问非静态成员
2.可以随意添加访问修饰符, 因为它的地位就是一个成员
3.若外部类和内部类有重名,遵循作用域的就近原则, 若想访问外部类,用 Outer.成员 去调用 (因为static)
4.作用域: 为整个class中都可使用
5.调用: ①外部类访问: 创建对象在访问 ②外部其它类访问: 2种方式
 */


class Outer04 {
    private int n1 = 10;
    private static String name = "BOB";

    static class Inner04 {
        public void say() {
            System.out.println(name);
        }
    }

    public Inner04 getInner04() {
        return new Inner04();
    }

    public static Inner04 getStaticInner04() {
        return new Inner04();
    }
}

class StaticInnerClass {
    public static void main(String[] args) {
        //三种方法
        Outer04.Inner04 inner01 = new Outer04.Inner04();

        Outer04 outer04 = new Outer04();
        Outer04.Inner04 inner02 = outer04.getInner04();

        Outer04.Inner04 inner03 = Outer04.getStaticInner04();
    }
}


