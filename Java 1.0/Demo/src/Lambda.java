public class Lambda {
    public static void main(String[] args) {
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("show~");
            }
        });

        f1(() -> {
                System.out.println("IL shows");
        });

        /* lambda省略规则
        1.参数类型可以不写
        2.如果只有一个参数, ()也可以不写
        3.如果方法体只有一行  {} ; return可以省略, 但需要同时省略
         */
        f1(() -> System.out.println("hello"));

    }

    public static void f1(IL il) {      //用f1来调用方法
        il.show();
    }
}


@FunctionalInterface   //必须是函数式接口(有且只有一个抽象方法)
interface IL {
    void show();
}

