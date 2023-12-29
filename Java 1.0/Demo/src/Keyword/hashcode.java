package Keyword;

//hashcode: 浅显的理解hashcode就是地址(除了重写hashcode方法的类)

/*
1.对象引用如果相同 ,hashcode一定一样
2.对象引用不相同, hashcode通常不一样 (eg: String)
3.hashcode主要根据地址号来的,不能完全将hashcode等价于地址
4.hashcode在需要的时候也会重写 --> eg: String类就重写了,直接比较内容,相同则hashcode也相同
 */


class AA {}
class Hashcode {
    public static void main(String[] args) {
        AA aa = new AA();
        AA aa2 = new AA();
        AA aa3 = aa;

        System.out.println(aa.hashCode());
        System.out.println(aa2.hashCode());
        System.out.println(aa3.hashCode());
    }
}