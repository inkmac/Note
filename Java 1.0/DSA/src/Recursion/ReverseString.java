package Recursion;

public class ReverseString {
    static void f(int n, String str) {
        if (n == str.length())
            return;
        f(n + 1, str);
        System.out.print(str.charAt(n));    //归的时候输出, 刚好是反的
    }

    public static void main(String[] args) {
        f(0 , "Hello, world");
    }
}
