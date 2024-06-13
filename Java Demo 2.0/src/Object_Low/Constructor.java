package Object_Low;

//基本语法: [访问修饰符] 方法名(形参列表) {}
//老韩说明:
//1. 构造器没有返回值
//2. 方法名和类名必须一样
//3. 构造器是自动调用的, 创建对象时就会自动调用, 目的是进行初始化等操作
/*  细节:
1.构造器可以重载
2.系统有一个默认无参的构造器, 但一旦自己定义之后, 默认构造器就会被覆盖
3.若有形参,创建对象时一定要有实参, 若想不填实参, 需再定义一下一个无参构造器(重载)
4.构造器不能为static, final
 */

class Person03 {
    String name;
    int age;

    public Person03(String name, int age) {
        System.out.println("构造器被调用~~");
        this.name = name;
        this.age = age;
    }
}


class Test{
    public static void main(String[] args) {
        Person03 p = new Person03("smith",80);
        System.out.println("name=" + p.name +" age=" + p.age);
    }
}


