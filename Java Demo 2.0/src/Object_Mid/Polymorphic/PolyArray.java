package Object_Mid.Polymorphic;

//多态数组: 对象数组


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {       //给子类提供public访问属性方法
        return name;
    }


    public int getAge() {
        return age;
    }


    public void say() {
        System.out.print(this.name + " " + this.age);
    }
}


class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public void say() {
        super.say();
        System.out.println(" score=" + score);
    }

    public void study() {
        System.out.println(getName() + " is studying");;
    }
}


class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void say() {
        super.say();
        System.out.println(" salary=" + salary);
    }

    public void teach() {
        System.out.println(getName() + " is teaching");
    }
}


public class PolyArray {
    public static void main(String[] args) {
        Person[] person = new Person[3];        //创建一个纯父类数组
        person[0] = new Person("Bob", 10);  //指向子类对象
        person[1] = new Student("jack", 20,80);
        person[2] = new Teacher("POT", 30,21000.0);

        /* 循环遍历多态数组, 调用say() */
        for (int i = 0; i < person.length; i++) {
            person[i].say();                            //动态绑定,从运行类型(子类)开始找
            if (person[i] instanceof Student) {
                ((Student) person[i]).study();           //向下转型,可以调用子类方法
            }
            else if (person[i] instanceof Teacher) {
                ((Teacher) person[i]).teach();
            }
            else {
                System.out.println(" 无职业");
            }
            //为什么使用if, 因为子类中有特有的方法需要调用(向下转型), 若没有特有的方法就无需使用if
        }
    }
}
