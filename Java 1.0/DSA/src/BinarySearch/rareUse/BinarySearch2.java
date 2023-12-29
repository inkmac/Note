package BinarySearch.rareUse;

public class BinarySearch2 {
    public static void main(String[] args) {

    }

    @Deprecated
    public static int search(int[] arr, int target) {
        int i = 0, j = arr.length;    //不希望j参与运算, 所以当做边界处理

        while (i < j) {               //2
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;                //3
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}

