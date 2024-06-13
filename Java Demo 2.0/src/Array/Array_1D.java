package Array;
import java.util.Scanner;
//数组 : 多个 同一数据类型 数据的集合

//一维数组入门介绍
class Array1D_01 {
    public static void main(String[] args) {
        //arr[] 表示 类型为double 名为arr的数组
        //{}中的数值为数组的元素
        double[] arr = {1, 5.0, 6.6, 7};

        //如何遍历数组的所有元素: for循环
        //通过下标来访问, 下标从0开始, arr[0] ; 然后用for一个个访问
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println("第" + (i+1) + "个元素为" + arr[i]);
        }

        //可以通过 数组名.length 得到数组的大小/长度
        System.out.println("length=" + arr.length);
    }
}


//一维数组定义及使用方法
class Array1D_02{
    public static void main(String[] args) {
        //动态数组定义, 表示有3个元素
        int[] arr01 = new int[3];

        //动态数组使用方法:
        //①先定义数组和Scanner ②再用for循环一一输入
        double[] arr = new double[3];
        Scanner input = new Scanner(System.in);

        for (int i = 0 ; i < arr.length ; i++) {
            System.out.print("input number" + (i+1) + ":");
            arr[i] = input.nextDouble();
        }

        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println("input number" + (i+1) + ":" + arr[i]);
        }

        //静态数组的使用:
        double[] arr03 = {1, 5.0, 6.6, 7};
    }
}


//数组赋值机制
class Array1D_03 {
    public static void main(String[] args) {
        //数组的赋值机制: 引用传递, 赋的是地址
        //arr2的改变会导致arr1的改变 ***
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr2[0] = 10;

        for (int j : arr1) {
            System.out.print(j + " ");
        }
    }
}


//冒泡排序法
class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 4, 5, 1, 8, 7, 0, -1};      //length = 6

        for (int i = 0; i < arr.length - 1; i++) {  //要排n - 1次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j + 1];        //保存i+1较小的值
                    arr[j + 1] = arr[j];          //将i+1替换成大的数, 即i
                    arr[j] = temp;                //再将temp赋给i
                }
            }
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}



