package Keyword;

//Finalize: 会默认调用
/*
1.当对象被回收时,系统自动调用该对象的finalize方法。子类可以重写该方法,做一些释放资源的操作
2.什么时候被回收: 当某个对象没有任何引用时候, 则JVM就认为该对象是一个垃圾对象, 会使用垃圾回收机制来销毁对象
  在销毁对象前,会先调用finalize方法
3.垃圾回收机制的调用,由系统决定(有自己的GC算法), 也可通过System.gc()主动触发垃圾回收机制(不一定成功)

老韩提示: 在实际开发中基本上不会运用finalize, 主要是为了面试
 */

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {        //finalize + Tab补全
        System.out.println("销毁对象" + " 并释放资源");
    }
}

public class finalize {
    public static void main(String[] args) {
        Car bob = new Car("BOB");
        bob = null;                 //但此时Car并未被回收, 因为jvm有自己算法

        System.gc();
        System.out.println("程序退出");     //先走完代码,再销毁(因此不会阻塞程序)
    }
}