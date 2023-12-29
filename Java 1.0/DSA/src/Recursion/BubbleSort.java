package Recursion;
import java.util.Arrays;

public class BubbleSort {
    private static void f(int[] arr, int j) {
        if (j == 0)
            return;

        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        f(arr, j - 1);
    }

    private static void fUpdate(int[] arr, int j) {
        if (j == 0)
            return;

        int x = 0;   //记录未排序的右边界, 节省排序次数
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                x = i;   //根据是否交换判断有序有无序的边界, x处于无序的右边界
            }
        }

        fUpdate(arr, x);
    }

    public static void sort(int[] arr) {
        f(arr, arr.length - 1);     //一共需要排(n - 1)次
        fUpdate(arr, arr.length - 1);
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
