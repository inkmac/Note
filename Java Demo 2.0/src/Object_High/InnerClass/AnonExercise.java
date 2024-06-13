package Object_High.InnerClass;

interface IL {
    void show();
}

class Exercise01 {
    public static void main(String[] args) {
        Exercise01.f1(new IL() {
            @Override
            public void show() {
                System.out.println("show~");
            }
        });
    }

    public static void f1(IL il) {      //用f1来调用匿名内部类的方法
        il.show();
    }
}




interface Bell {
    void ring();
}

class Phone {
    public static void main(String[] args) {
        new Bell() {
            @Override
            public void ring() {
                System.out.println("起床了");
            }
        }.ring();

        new Bell() {
            @Override
            public void ring() {
                System.out.println("上课了~");
            }
        }.ring();
    }
}