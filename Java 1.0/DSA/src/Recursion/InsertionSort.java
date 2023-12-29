package Recursion;

import java.util.Arrays;

public class InsertionSort {
    private static void insertion(int[] arr, int low) {
        if (low == arr.length)
            return;

        int t = arr[low];   //获取未排序区域最左边的数据
        int i = low - 1;   //已排序区域右指针

        while (i >= 0 &&  t < arr[i]) {
            arr[i + 1] = arr[i];    //空出插入位置
            i--;   //指针向前走
        }

        arr[i + 1] = t;

        insertion(arr, low + 1);
    }

    public static void sort(int[] arr) {
        insertion(arr, 1);  //把0当做已经排序好的
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
