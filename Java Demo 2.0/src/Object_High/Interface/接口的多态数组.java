package Object_High.Interface;

// 接口的多态性: 向上转型+动态绑定+向下转型
// 包括之前的多态参数和多态数组, 在这里接口充当父类, 实现接口的类充当子类
// 接口(编译类型)充当形参,实现接口的类(运行类型)充当实参
// 编译类型可以是接口类型,也可以有接口类型数组


// 多态数组
interface Person {
    void work();
}


class Student implements Person {
    @Override
    public void work() {
        System.out.print("Student is learning~ \t");
    }

    public void play() {
        System.out.println("Play");
    }
}


class Teacher implements Person {
    @Override
    public void work() {
        System.out.print("Teacher is teaching~ \t");
    }

    public void manage() {
        System.out.println("Manage");
    }
}


class Main {
    public static void main(String[] args) {
        Person[] person = new Person[2];
        person[0] = new Student();
        person[1] = new Teacher();

        for (int i = 0; i < person.length; i++) {
            person[i].work();
            if (person[i] instanceof Student) {
                ((Student) person[i]).play();
            }
            else if (person[i] instanceof Teacher) {
                ((Teacher) person[i]).manage();
            }
        }
    }
}