package Recursion;

public class PascalTriangle {
    /**
     * 记忆法 杨辉三角
     */
    private static int calc(int[][] arr, int i, int j) {
        if (arr[i][j] != 0)
            return arr[i][j];

        if (j == 0 || i == j) {
            arr[i][j] = 1;
            return 1;
        }

        arr[i][j] = calc(arr, i - 1, j - 1) + calc(arr, i - 1, j);
        return arr[i][j];
    }

    public static void print(int n) {
        int[][] arr = new int[n][];    //由于长度不定, 先不初始化
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = calc(arr, i, j);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 动态规划 杨辉三角
     */

    public static void main(String[] args) {
        print(5);
    }
}
