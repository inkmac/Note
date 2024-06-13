package Object_High.InnerClass;

//匿名内部类: 既是内部类, 又是一个对象实例

/*  细节
1.不能重写构造器
2.可以直接访问外部类的所有成员,包括private
3.若外部类和内部类有重名,遵循作用域的就近原则, 若想访问外部类,用 Outer.this.成员 去调用
 */

/*  如何理解 + 为什么需要
new IA()相当于创建了一个实现了接口的类, 然后实现了接口
同时他是一个类,所以他可以在{}其中编写代码(来实现接口)
同时也是一个对象, 所以可以赋给一个对象引用然后再调用; 或者是直接调用
它允许你在需要时立即提供实现,而无需单独创建一个类文件; 这在某些情况下非常方便,尤其是当你只打算用一次
 */

class Outer01 {
    public static void main(String[] args) {
        Outer01.method();
    }

    public static void method() {
        //第一种调用方法
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫...");
            }
        };
        System.out.println("tiger的运行类型 = " + tiger.getClass());
        tiger.cry();

        //第二种调用方法
        new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫...");
            }
        }.cry();
    }
}

interface IA {
    void cry();
}




class Outer02 {
    public static void main(String[] args) {
        Outer02.method();
    }

    public static void method() {
        Father father = new Father() {
            @Override
            void say() {
                System.out.println("Father say...");
            }
        };
        father.say();
        System.out.println("father的运行类型 = " + father.getClass());
    }
}

class Father {
    void say() {};
}
