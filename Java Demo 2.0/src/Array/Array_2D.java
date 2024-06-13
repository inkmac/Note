package Array;
import java.util.Scanner;

//二维数组入门介绍
class Array2D_01 {
    public static void main(String[] args) {
        //二维数组每一个元素都是一维数组, 所以需要遍历2次
        //arr[i]表示二维数组第i个元素
        //arr[i].length表示第i个元素的长度
        int[][] arr = {{0, 0, 0},{1, 1, 1},{2, 2, 2}};

        //arr[a][b]访问的是(a+1,b+1)的值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {     //此处为arr[i] ****
                System.out.print(arr[i][j] + " ");
            } System.out.println();
        }
    }
}

//arr[n][m], 表示n行m列
//arr[n].length 表示第n行的个数

//二维数组创建及使用
class Array2D_02 {
    public static void main(String[] args) {
        //动态二维数组
        //创建Way1:
        int[][] arr1 = new int[1][2];
        //Way2：
        int[][] arr2;
        arr2 = new int[1][];           //第二个括号可以不填**

        //动态二维数组赋值             **若没有赋值, 则默认值为0
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print("input number:");
                int num = input.nextInt();
            }

            //静态二维数组
            int[][] arr3 = {{1}, {2, 2}, {3, 3, 3}};
        }
    }
}