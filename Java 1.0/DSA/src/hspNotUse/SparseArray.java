package hspNotUse;
/*  稀疏数组介绍
1. 第0行: 记录了原始数组的总大小 + 原始数组中非0元素数量
2. 剩下行: 记录每一个非0元素的位置 + 大小
 */

public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 1;

        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        //将二维数组 --> 稀疏数组
        //1. 先遍历二维数组, 得到非0数据的个数
        int sum = 0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if (anInt != 0)
                    sum++;
            }
        }

        //2. 根据sum创建对应的sparseArray
        //   sparseArr是列数为3的数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;


        //3.遍历二维数组, 将非0的值存放到 sparseArr中
        //  从第1行开始存入 非0元素位置以及大小
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println("输出稀疏数组如下~~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.print(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2]);
            System.out.println();
        }


        //将稀疏数组 --> 二维数组
        //1.创建二维数组(根据第0行)
        int[][] chessArr1 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2.将稀疏数组的数据返回给二维数组(根据第1行 --> i=1)
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出二维数组
        System.out.println("二维数组恢复完毕~~~~~~~");
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
