package Object_Mid.Polymorphic;

//方法多态: 重写和重载体现多态

//对象多态: 动态绑定机制
/*  简单介绍:
1.一个对象的编译类型和运行类型可以不一致, 但编译类型必须是运行类型的父类
2.编译类型看左边, 运行类型看右边
 */


//向上转型: 父类引用指向子类对象
/*  细节:
1.父类类型 名 = new 子类类型(); 其中子类对象可以改变
2.编译类型看左边, 运行类型看右边
3.编译时只保存了父类方法,不能调用子类特有方法 --> 解决: 向下转型
  但是运行时会从子类开始寻找方法(只找override的)
 */


//向下转型: 强制将父类引用转换为子类类型, 建立在向上转型基础上, 然后可以调用子类方法
/*
1.子类类型 名 = (子类类型) 父类引用
2.只能强转父类引用, 不能强转父类对象
3.要求父类引用必须指向当前目标类型对象
4.可以调用子类所有对象
 */

class Animal {
    int n1 = 10;

    public Animal(int n1) {
        this.n1 = n1;
    }

    public void makeSound() {
        System.out.println("动物发出声音");
    }

    public void eat() {
        System.out.println("Animal eat~");
    }

    public int getN1() {
        return n1;
    }
}


class Dog extends Animal {
    int n1 = 20;        //这个叫字段的隐藏, 相当于子类n1重写了父类n1, 少用!!!!!

    public Dog(int n1) {
        super(n1);      //直接修改父类的属性,相当于父类n1直接被修改
    }

    @Override
    public void makeSound() {
        System.out.print("狗发出汪汪声");
    }

    public void fetch() {
        System.out.println("狗玩飞盘");
    }

}


@SuppressWarnings({"ALL"})
class Main01 {
    public static void main(String[] args) {
        Animal animal = new Dog(999);  //向上转型: 使用Animal引用指向Dog对象
        animal.makeSound();
        animal.eat();
        System.out.println(animal.n1);
        System.out.println(animal.getN1());

        Dog dog = (Dog) animal;     //向下转型为Dog类引用,仍指向Dog对象
        dog.fetch();                //这是Dog类特有的方法,只有通过Dog引用才能调用它

    }
}
