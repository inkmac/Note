package Recursion;

public class Factorial {
    public static int f(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        int f = f(0);
        System.out.println(f);
    }
}
