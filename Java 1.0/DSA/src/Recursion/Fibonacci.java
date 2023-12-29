package Recursion;
import java.util.Arrays;

/**
 * 演示斐波那契数列记忆法(Memoization), 时间复杂度O(n)
 */
public class Fibonacci {
    public static int f(int n, int[] cache) {
        if (cache[n] != -1)     //数组里面已有计算过的数据
            return cache[n];

        cache[n] = f(n - 1, cache) + f(n - 2, cache);   //记录数组没有的数据
        return cache[n];
    }

    public static int calc(int n) {
        int[] cache = new int[n + 1];   //传进来的几, 需要存在数组对应的index, 因此要+1
        Arrays.fill(cache, -1);
        cache[0] = 0;    //结束迭代的两个值
        cache[1] = 1;

        return f(n, cache);
    }

    public static void main(String[] args) {
        int calc = calc(5);
        System.out.println(calc);
    }
}
