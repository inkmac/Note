package Keyword;

// == 比较运算符: 比较值和数据类型是否完全相同
/*
1.可以判断基本数据类型和引用数据类型
2.判断基本数据类型: (数学上的)值是否相等
3.判断引用数据类型: 判断地址是否相等, 即是否为同一个对象 --> 因为引用数据类型本质上为对象引用,是地址, 所以直接比较的就是地址
4.比较双方有一个基本数据类型, 就比较值是否相等
 */

class B {}
class A extends B {}
class equals1 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = a;
        System.out.print(a == b);   //比较的是地址, 只要指向相同, 结果就是true
        System.out.print(a == c);
        System.out.println(b == c);
        B d = (B) a;

        System.out.println(d == a);  //true

        int n1 = 10;
        double n2 = 10.000;
        System.out.println(n1 == n2);   //比较的数学上的值相不相同
    }
}



// equals()方法
/*
1.只可以比较引用数据类型: 首先比较的是地址, 若该类中重写了equals方法, 则比较的是内容
  可以用Generate产生一个重写的equals方法/直接输入equals+Tab自动补全

重写了 equals 方法的类:
1.String: String 类比较的是字符串的内容,而不是引用 (p.name也算字符串)
2.Integer,Double,Float,Long,Short,Byte,Character,Boolean:
  这些包装类都重写了 equals 方法,以比较它们包装的基本数据类型的值
3.Date,Calendar: 这些类重写了 equals 方法,以比较日期和时间的值

没有重写 equals 方法的类:
4.自定义类(除非你自己创建了一个类并在其中重写了 equals 方法)。
 */

class Equals {
    public static void main(String[] args) {
        String s1 = new String("BOB");
        String s2 = new String("BOB");
        System.out.print(s1 == s2);
        System.out.println(s1.equals(s2));  //true

        //注意
        String name = "Steve";
        System.out.println("Steve".equals(name));   //推荐, 可以避免空指针
        System.out.println(name.equals("Steve"));
    }
}