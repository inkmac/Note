package BinarySearch;

public class LeftMost {
    public static void main(String[] args) {
        int[] arr = {0, 2, 2, 3, 4};

        int index = search(arr, 2);
        System.out.println(index);
    }

    public static int search(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;

        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {        //找到了
                candidate = m;   //记录候选位置
                j = m - 1;  //继续向左查询, 如果i > j时退出循环
            }
        }

        return candidate;
    }
}