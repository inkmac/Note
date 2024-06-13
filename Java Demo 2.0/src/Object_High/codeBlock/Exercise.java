package Object_High.codeBlock;

class Sample {
    Sample(String a) {
        System.out.println(a);
    }
    Sample() {
        System.out.println("Sample无参构造器被调用");
    }
}

class Test {
    Sample sam1 = new Sample("sam1初始化");        //只要创建对象, 构造器会自动执行
    static Sample sam= new Sample("static sam初始化");
    static {
        System.out.println("static代码块被执行");
    }
    Test() {
        System.out.println("Test无参构造器被调用");
    }
}

public class Exercise {
    public static void main(String[] args) {
        new Test();
    }
}


