package Generics;

//泛型: 数据类型的参数

/*
1.泛型要求只能为引用数据类型
2.指定数据类型后,可以传入 该类型或子类型
3.泛型可以简写(只写左边),如果全写左右必须相同,不写默认为Object
 */

@SuppressWarnings({"all"})
class Detail {
    public static void main(String[] args) {
        Person<String> bob = new Person<>("BOB");
        bob.showE();
        bob.showClass();


        //可以只写左边, 编译器会自动判断
        Person<Integer> person = new Person<>(30);
        //不写默认是Object型
        Person<Object> objPerson01 = new Person<>();
        Person objPerson02 = new Person();

    }
}



class Person<E> {
    private E e;

    public Person() {}

    public Person(E e) {
        this.e = e;
    }

    public void showE() {
        System.out.println("e=" + e);
    }

    public void showClass() {
        System.out.println(e.getClass());
    }

    <U> void Custom() {}
}
