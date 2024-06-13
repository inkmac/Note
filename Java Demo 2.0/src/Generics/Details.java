package Generics;

/*  泛型类
1.普通成员可以使用泛型,静态成员不可以
2.泛型类型的变量不能初始化
3.不写<>默认为Object类
 */

class Tiger<U,T> {
    T a;
    U[] arr;
}

interface IA<U,T,E extends Car> {     // 可以指定上下界
//    U name;     不能这样用,接口属性默认为static
    U getU();
    T getT();
    E getF();
}



/*  泛型方法
1.可以适用于static方法类型
2.当调用方法时候,传入参数,编译器会自动确定类型
 */

class Car {
    void run() {}

    <U,T> void fly(U u, T t) {
        System.out.println(u.getClass());
        System.out.println(t.getClass());
    }

    static <T> void aa(T t) {
        System.out.println(t);
    }

}


@SuppressWarnings({"ALL"})
class Details02 {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("Bob",200);

        Car.aa("fly");

    }
}