package Object_High;

//abstract关键字: 主要是为了实现继承和多态的机制 --> 方法重写

/*
1.抽象方法不能有方法体,即{}
2.抽象类不可以创建对象实例
3.abstract只能修饰类和方法
4.抽象类可以没有abstract方法, 但一旦包含abstract方法就一定要为抽象类
5.如果一个类继承了抽象类,那么它必须实现抽象类的所有抽象方法,除非自身也为抽象类
6.abstract和private, final, static冲突
 */


abstract class Template {        //抽象类模版模式
    public abstract void job();

    public void calTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("执行时间 = " + (end - start) + "ms");
    }
}

class AA extends Template {
    public void job() {
        long num = 0;
        for (int i = 0; i < 1000000000; i++) {
            num += i;
        }
        System.out.println("num = " + num);
    }
}

class Test {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.calTime();
    }
}