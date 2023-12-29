package Recursion;
import java.util.LinkedList;

public class HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    static void init(int n) {
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
        print();
    }

    /**
     * @param n 圆盘个数
     * @param a 源
     * @param b 借
     * @param c 目
     */
    static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0)
            return;
        move(n - 1, a, c, b);   //a借c到b
        c.addLast(a.removeLast());  //最下面的圆盘放到c
        print();
        move(n - 1, b, a, c); //剩下的圆盘借a到c
    }

    private static void print() {
        System.out.println("------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void main(String[] args) {
        init(3);
        move(3, a, b, c);
    }
}
