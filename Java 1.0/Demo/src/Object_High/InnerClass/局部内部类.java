package Object_High.InnerClass;

//局部内部类: 定义在一个类(外部类)的内部的类, 在方法或代码块中

/*  细节
1.可以直接访问外部类的所有成员,包括private
2.局部内部类不能添加修饰符,但可以用final修饰(防止被继承)
3.若外部类和内部类有重名,遵循作用域的就近原则, 若想访问外部类,用 Outer.this.成员 去调用
4.作用域: 只在定义它的方法或代码块中可以使用, 是一个局部变量
5.调用: 只能在作用域内创建对象后再访问

 */

class Outer {
    private int n1 = 10;
    private void m1() {
        System.out.println("m2 executed~");
    }

    public void m2() {
        class Inner implements AAA {
            private int n1 = 100;
            public void f1() {
                System.out.println("f1() executed~ \nInner n1=" + n1);
                System.out.println("Outer n1=" + Outer.this.n1);
                m1();
            }

            @Override
            public void bob() {

            }
        }
        Inner inner = new Inner();
        inner.f1();
    }
}

class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m2();
    }
}

interface AAA {
    void bob();
}
