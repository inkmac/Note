package Object_Low;

//使用及细节:
//1. 先建立一个class类, 再在其中编写方法
//   若在同一个类中可直接调用,不需要创建对象(main方法除外)
class Use {
    public void print(int n) {
        System.out.println("print is used n=" + n);
    }

    public void sayOk(int n) {
        print(n);
        System.out.println("Now execute sayOk()");
    }
}

//2.用 class名 定义一个变量,并用 该变量.方法名() 调用该方法
class UseObject01 {
    public static void main(String[] args) {
        Use a = new Use();          //定义一个可以调用方法的变量, -->class的地址(内包含方法)
        a.sayOk(10);             //通过变量使用该方法
    }
}

//细节
/*  方法要求有返回数据类型:
1.一个方法最多一个返回值, 如何返回多个结果? 返回数组
2.必须有return, return可以是任意类型, 但是return值类型必须与要求的一致或可以相互转换
3.调用该方法时, 变量名.方法名 就是return得到的值, 可直接使用
4.方法遇到return时, 会直接结束该方法 (若为递归,可能会进入下一层方法)
5.return的作用是让该方法变成一个数据类型, 方便后续调用
 */

/*  方法为void:
1.一个方法可以有参数, 也可以没有参数
2.参数类型可以为任意类型, 但类型必须与形参一致或兼容
3.方法定义时的参数称为形式参数(形参), 调用时的参数称为实际参数(实参)
4.实参与形参类型要一致或兼容; 个数,顺序必须一致
5.void也可return, 作用为结束当前方法
 */

/*  方法调用细节:
1.同一个class中方法可以直接调用, 其中形参可以一直带上,方便观察 (main方法除外)
2.跨class/在main()方法中 调用方法, 需先创建对象, 再用 对象名.方法名 调用方法
4.或者直接 new AA().test()也可以调用
 */


//方法赋值细节:
class Person02 {
    int age;
}

class AA {
    public static void test100(Person02 p) {
        p.age = 1000;
    }
    public static void test200(Person02 p) {
        p = null;
    }
    public static void test300(Person02 p) {
        p = new Person02();         //因为()已经定义了p, 故无需再定义**
        p.age = 2000;
    }
}

class test1{
    public static void main(String[] args) {
        Person02 p = new Person02();
        p.age = 10;

        AA.test100(p);
        System.out.println("Test100 main的p.age=" + p.age);
        //解释: p的地址并未改变, 但指向的内容改变了,故p.age --> 1000

        AA.test200(p);
        System.out.println("Test200 main的p.age=" + p.age);
        //解释: 传进去的参数是一个地址副本(copy版本), 是完全一样的
        //是副本改变了指向, 指向了null, 原来的p仍指向之前的Person对象

        AA.test300(p);
        System.out.println("Test300 main的p.age=" + p.age);
        //解释: new Person()又创建了一个新对象, 变的是新空间的p.age, 跟原来的没关系
        //如果有两个不同的对象, 那么对其中一个对象的修改并不会影响到另一个对象, 因为二者是独立的
    }
}


/*  参数传递细节:
1.Java中的参数传递是按值传递, 相当于: 形参 = 实际传入的参数
2.基本数据类型: 在方法内被改变,在main方法中仍然不变 --> 因为是值拷贝
3.引用数据类型(对象): 传进去的参数是一个地址, 只有指向的内容在方法内被改变(eg: p.age), 在main方法中才变
 */


/*  一些基本概念:
class Person不是对象, 只是一个类
创建对象的时候就自动获得类中的全部成员, 就算不调用也默认有这些成员
p是对象引用, 本质上是对象的内存地址(指向对象), 从而可以访问和操作对象(实例)
p.age才是对象的一部分
而方法中的变量并不是对象, 而是方法的形参
只有成员变量的定义以及赋值可以写在类的主体, 其他初始化操作可以写在构造器中

注: 调用属性时无括号 eg: p.age
    调用方法时有括号 eg: p.test()/ new AA().test()也可以调用
    调用方法必须显式的调用,光创建对象并不会调用; 构造器会自动调用
 */


