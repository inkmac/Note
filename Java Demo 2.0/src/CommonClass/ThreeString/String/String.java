package CommonClass.ThreeString.String;

/*
1.String a = "abc" 先从常量池看是否有"string",如果有,直接指向; 如果没有就创建一个,并且指向
2.new String() 不管有没有, 都会直接开新空间创建一个新的string对象,并且指向

3.String类是final char[] value的, 所以String a = "abc";  a = "java";
  本质上不是"bob"被改变了, 而是创建一个对象"java"并且指向, "bob"和"java"都在
  所以说每次修改都会重开空间
 */


class StringDetail {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.print(a == b);
        System.out.println(a.equals(b));

        String c = new String("abc");
        System.out.println(a == c);             //因为c是new的新对象,有新地址
    }
}


class test {
    String str = "abc";

    public void change(String s) {
        s = "java";         //String类型的赋值是改变指向,原来的内容并没有变化,所以外面的test.str没变
    }

    public static void main(String[] args) {
        test test = new test();
        test.change(test.str);
        System.out.println(test.str);
    }
}