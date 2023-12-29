package Object_High.Interface;

// 接口的多态性: 向上转型+动态绑定
// 包括之前的多态参数和多态数组, 在这里接口充当父类, 实现接口的类充当子类
// 接口(编译类型)充当形参,实现接口的类(运行类型)充当实参
// 编译类型可以是接口类型,也可以有接口类型数组


// 多态参数
class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Computer computer = new Computer();
        computer.work(phone);
    }
}

interface USB {
    public void start();
    public void stop();
}

class Phone implements USB {
    @Override
    public void start() {
        System.out.println("Phone started~");
    }

    @Override
    public void stop() {
        System.out.println("Phone stopped~");
    }
}

class Computer {
    public void work(USB usb) {
        usb.start();
        usb.stop();
    }
}



