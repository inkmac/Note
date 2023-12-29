package Object_Low;

//This关键字: 指向当前对象的引用(哪个对象调用,this就代表哪个对象)
//用来区分对象和参数!

/*  细节:
1.this关键字可以访问本类的属性,方法,构造器
2.访问属性的属性: this.属性名
3.访问方法的语法: this.方法名()
4.访问构造器的语法: this() 且必须放在第一条语句;   注意:只能在构造器中访问另一个构造器
6.单独一个this表示当前整个对象
7.this只可在方法,构造器中使用(不能使用在static语句中)
 */

//属性访问
class T1 {
    String name = "Bob";
    int age = 10;

    public void f1() {
        String name = "jack";
        //若有局部变量, 就近原则
        System.out.println("name=" + name + " age=" + age);
        //有this, 指定为属性
        System.out.println("name=" + this.name + " age=" + this.age);
    }
}


//构造器调用
class Dog {
    public Dog(String name, int age) {
        System.out.println("Dog构造器被调用~");
    }

    public Dog() {
        this("jack", 10);
    }
}


//方法调用
class T2 {
    public void f1() {
        System.out.println("f1() execute");
    }

    public void f2() {
        System.out.println("f2() execute");
        f1();
        this.f1();      //两种方法调用f1()
    }
}

class T2Object {
    public static void main(String[] args) {
        T2 T = new T2();
        T.f2();
    }
}


//Main方法调用时候this的指向:
/*
首先,在main方法中创建了两个People对象引用: john和jane。
当你写People john = new People("John")时, 是在内存中分配了一个新的People对象,并将其引用赋给了john。
同样,People jane = new People("Jane"), 也创建了一个新的People对象,并将其引用赋给了jane。
两个对象分别有自己的内容john --> John; jane --> Jane。

然后,用john调用了makePeople方法(谁调用,指向谁,所以现在this指向john)并将jane作为参数传入。
在makePeople方法内部, p.name = this.name;
将当前对象(也就是 john)的name赋值给了传入的People对象(也就是 jane)的name属性。这样,p的name也变成了"John"。

最后,方法返回了p, 所以在main方法中,updatedJane实际上是指向了jane这个对象,但其内容已经改变。
此时updatedJane.name的值为"John"。
 */
class People {
    String name;

    public People(String name) {
        this.name = name;
    }

    public People copyPeople(People p) {
        this.name = p.name;
        return this;
    }
}

class Main {
    public static void main(String[] args) {
        People john = new People("John");
        People jane = new People("Jane");

        People updatedJohn = john.copyPeople(jane);

        System.out.println(updatedJohn.name); // 输出 "Jane"
    }
}