package Generics;


/*  泛型类
1.普通成员可以使用泛型,静态成员不可以
2.使用泛型的数组不可以初始化
3.不写<>默认为Object类
 */


class Tiger<U,T> {
    T a;
    U[] arr;
}


interface IA<U,T,F> {
//    U name;     不能这样用,接口属性默认为static
    U getU();
    T getT();
    F getF();
}

interface IB<U,T,F> extends IA<U,T,F> {}     //可以像形参一样传递下去



/*  泛型方法
1.可以适用于static方法类型
2.当调用方法时候,传入参数,编译器会自动确定类型
 */

class Car<F> {
    void run() {}

    <U,T> void fly(U u, T t) {
        System.out.println(u.getClass());
        System.out.println(t.getClass());
    }

    static <T> void aa(T t) {
        System.out.println(t);
    }

    //说明:该方法不是一个泛型方法,而是使用了类声明的泛型
    void hi(F f) {
        System.out.println(f.getClass());
    }

}


@SuppressWarnings({"ALL"})
class Details02 {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("Bob",200);

        car.aa("fly");
    }
}