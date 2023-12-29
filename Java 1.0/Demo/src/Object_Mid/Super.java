package Object_Mid;

//super(): 直接调用父类的成员(就近原则)
//与this很像, this调用本对象, super调用父类对象

/* 使用:
1.super不可访问private
2.访问属性的属性: super.属性名, 若修改的话是直接修改父类属性,与字段隐藏不一样
3.访问方法的语法: super.方法名()
4.访问构造器的语法: super() 且必须放在构造器第一条语句; 故不可与this()一起使用
5.子类构造器要显式调用父类构造器, 除非父类有无参构造器
 */



class Super {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public Super(){}
    public Super(String name){}
    public Super(String name, int age){}

    public void test100() {}
    protected void test200() {}
    void test300() {}
    private void test400() {}

}

class D extends Super {
    public void say100() {
        System.out.println(super.n1 + super.n2 + super.n3);
    }

    D() {
//        super();
//        super("Bob");
        super("Bob", 100);
    }

    public void say300() {
        super.test100();
        super.test200();
        super.test300();
    }
}


/*  直接访问细节: 就近原则
1.先看子类是否有该属性
2.如果子类没有,则向父类继续查找直到找到为止
①若找到了, 但父类属性是private,会报错而不会向上级继续寻找
②若没有就会报错
 */


