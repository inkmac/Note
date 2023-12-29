package Useless.Unknown;

// @Solved
class AA {
    int a = 1;

    void f1() {
        System.out.println(this.a);     //编译的时候就指向到AA.a上面了, 这是java编译器默认的
    }
}

class BB extends AA {
    int a = 2;
}

class MA {
    public static void main(String[] args) {
        BB bb = new BB();
        bb.f1();
    }
}
