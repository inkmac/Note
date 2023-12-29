package BinarySearch;

public class RightMost {
    public static void main(String[] args) {

    }

    public static int searchRightMost(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        int candidate = -1;

        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                candidate = m;  //记录候选位置
                i = m + 1;
            }
        }

        return candidate;
    }
}
