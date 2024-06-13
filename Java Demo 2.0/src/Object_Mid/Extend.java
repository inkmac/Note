package Object_Mid;

//继承: 子类从另父类继承所有成员

/*  细节:
1.若子类想修改父类属性, 无法在类主体中直接赋值, 建议在构造器中赋值
2.子类使用构造器时,默认会先调用父类的无参构造器;
  若父类没有无参构造器,则子类一定要有构造器并用super指定使用父类的哪个构造器, 否则会报错!!
3.super语句需放在子类构造器第一句话, 但this也要第一句, 因此这两种方法不能共存
  若有this, 则会将无参super()覆盖
4.java为单继承机制, 若想A继承B,C? 可以A继承B,B继承C
 */


class Base {
    public Base(String name) {
        System.out.println("Base(String name) executed~ " + name);
    }

    public Base() {
        System.out.println("Base() executed~");
    }
}

class Sub extends Base {
    public Sub(String name) {
        super(name);                           //在子类中指定有参构造器
        System.out.println("Sub(String name) executed~ " + name);
    }

    public Sub() {                             //默认指定无参构造器
        System.out.println("Sub() executed~");
    }
}

class ExtendDetail02 {
    public static void main(String[] args) {
        Sub sub = new Sub("jack");
        Sub sub1 = new Sub();
    }
}



/*  访问细节(无super): 就近原则
1.先看子类是否有该属性
2.如果子类有,并且可以访问,则返回信息
3.如果子类没有,看父类是否有该属性(如果父类有,并且可以访问,则返回信息)
4.若父类没有则按3规律,继续向上级找,直到Object(若没有就会报错)

①若找到了, 但父类属性是private,会报错而不会向上级继续寻找
②若想指定使用属性,需要super()

 */


class Father {
    String name = "Bob";
    int age = 50;
}

class Son extends Father {
    String name = "Young Bob";
}

class Access {
    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.name);   //从下往上一级级找
        System.out.println(son.age);
    }
}


