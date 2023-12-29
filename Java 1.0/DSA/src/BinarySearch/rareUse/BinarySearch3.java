package BinarySearch.rareUse;

public class BinarySearch3 {
    public static void main(String[] args) {

    }

    @Deprecated
    public static int search(int[] arr, int target) {
        int i = 0, j = arr.length;

        while (j - i > 1) {     //因为j当做边界处理, 所以j和i相邻的时候就代表找完了, 退出循环
            int m = (i + j) >>> 1;
            if (target < arr[m])
                j = m;
            else
                i = m;
        }

        //因为j不参与查找, 所以只比较arr[i]
        if (arr[i] == target)
            return i;
        else
            return -1;
    }
}
