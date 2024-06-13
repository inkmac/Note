package Object_Low;

//对象: 类中全部的方法和属性的集合

class Cat {
    String name;
    int age;
    String[] property = {"1", "abc"};       //可在该处赋值, 也可在使用时赋值
}

class CatObject01 {
    public static void main(String[] args) {
        //创建对象(本质其实是对象地址)
        Cat c1 = new Cat();

        //若未赋值, 有默认值, 与数组相同
        System.out.println("CAT information:" + c1.name + " " + c1.age);
        //如何访问属性: 对象名.属性名
        c1.name = "Bob";
        c1.age = 3;
        System.out.println("CAT information:" + c1.name + " " + c1.age);


        //赋值机制: 引用传递, 赋的是地址
        //c1的改变会导致c2的改变 *****
        Cat p1 = new Cat();
        p1.age = 10;
        Cat p2 = p1;                 //p2 --> p1
        p2.age = 80;
        System.out.println(p1.age);  //80
    }
}

class CatObject02{
    public static void main(String[] args) {
        Cat a = new Cat();
        a.age = 10;
        Cat b;          //先声明但并不创建
        b = a;          //把b指向a地址
        b = null;       //直接将b地址改为null, 但对a无影响
        System.out.println(a.age);  //10
        System.out.println(b.age);  //报错

        /*
        单独一个定义的b只是一个地址,使用b时用的是地址,地址指向b.age
        b所对应class中全部属性和方法才是真正的对象
        但是我们一般习惯性上讲b为对象
         */
    }
}



//成员方法入门介绍 :
class Person {
    /*
    1. public表示方法是公开的
    2. void: 表示方法没有返回值
    3. cal01(): cal01是方法名, ()是形参列表, 方法名可以任意起
    4. {} 方法体, 可以写我们要执行的代码, 写其中的代码被调用时会执行
     */
    public void cal01() {
        int res = 0;
        for (int i = 1; i <= 10; i++) {
            res += i;
        }
        System.out.println("sum01 = " + res);
    }

    public void cal02(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        System.out.println("sum02 = " + res);
        //若有需要输入的变量, 需要括号里加上需要输入的变量
        //(int n)形参列表, 表示当前有一个n, 可以接收用户输入
    }

    public int cal03(int a, int b) {
        int res = a + b;
        return res;
        //若有计算, 需要有return
        /*
        1. int: 表示该方法最后结果是一个int类型, 可当做int数据使用
        2. (int a, int b)形参列表, 2个形参, 可以接收用户传入的2个数
        3. return res: 表示把res的值, 返回给这个方法, 现在这个方法的值就是res
         */
    }
}

class PersonObject01 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.cal01();                 //调用cal01方法
        p1.cal02(5);              //调用cal02方法, 并在()中输入n的值

        int returnRes = p1.cal03(50, 20);  //把cal03返回的值, 赋给returnSum
        System.out.println("getSum返回的值=" + returnRes);
    }
}


