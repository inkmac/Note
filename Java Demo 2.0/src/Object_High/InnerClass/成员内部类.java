package Object_High.InnerClass;

//成员内部类: 定义在外部类的成员位置上
/*
1.可以直接访问外部类的所有成员,包括private
2.可以随意添加访问修饰符, 因为它的地位就是一个成员
3.若外部类和内部类有重名,遵循作用域的就近原则, 若想访问外部类,用 Outer.this.成员 去调用
4.作用域: 为整个class中都可使用
5.调用: ①外部类访问: 创建对象在访问 ②外部其它类访问: 3种方式
 */

class Outer03 {
    private int n1 = 10;

    public class Inner03 {
        void f1() {
            System.out.println("Inner03 f1() executed~");
            System.out.println("Outer n1 = " + Outer03.this.n1);
        }
    }

    public void m1() {
        Inner03 inner03 = new Inner03();
        inner03.f1();
    }

    public Inner03 getInner03() {
        return new Inner03();
    }

}


class MemberInnerClass {
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        outer03.m1();

        //三种方式
        Outer03.Inner03 inner01 = outer03.new Inner03();

        Outer03.Inner03 inner02 = outer03.getInner03();

        new Outer03().new Inner03();
    }
}
