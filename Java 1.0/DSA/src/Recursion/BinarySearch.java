package Recursion;

public class BinarySearch {
    static int search(int[] arr, int target) {
        return f(arr, target, 0, arr.length - 1);
    }

    private static int f(int[] arr, int target, int i, int j) {
        if (i > j)
            return -1;

        int m = (i + j) >>> 2;
        if (target < arr[m])
            return f(arr, target, i, m - 1);
        else if (arr[m] < target)
            return f(arr, target, m + 1, j);
        else
            return m;
    }
}
