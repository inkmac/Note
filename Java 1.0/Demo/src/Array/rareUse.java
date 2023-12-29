package Array;

import java.util.Scanner;

//数组反转
class Array1D_05{
    public static void main(String[] args) {
        int[] set1 = {1, 2, 3, 4, 5, 6};

        //内部直接反转
        for (int i = 0; i < (set1.length / 2); i++) {
            int temp = set1[set1.length - (i + 1)];
            set1[set1.length - (i + 1)] = set1[i];
            set1[i] = temp;
        }
        for (int k : set1) {
            System.out.print(k + " ");
        }

        System.out.println("\n" + "---------------------");
        //新建一个地址,倒序插入, 在最后将地址赋回去*
        int[] set2 = new int[6];
        for (int i = (set1.length - 1), j = 0; i >= 0; i--, j++) {
            set2[i] = set1[j];
        }
        set1 = set2;                                //此时原来set1地址没有被引用, 会被当做垃圾处理
        for (int j : set1) {
            System.out.print(j + " ");
        }
    }
}


//数组添加
class Array1D_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {1, 2, 3};                     //要放在外面

        for(;;) {
            int[] arrNew = new int[arr.length + 1];

            for (int i = 0; i < arr.length; i++) {
                arrNew[i] = arr[i];
            }

            System.out.print("input your number:");
            int num = input.nextInt();
            arrNew[arrNew.length - 1] = num;
            arr = arrNew;

            for (int j : arr) {
                System.out.print(j + " ");
            }

            System.out.print("continue? y/n :");
            String answer = input.next();
            if ("n".equals(answer)) {
                break;
            }
        }
    }
}


//查找
class Array1D_07 {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "A", "D"};        //字符串类型要加 ""
        Scanner input = new Scanner(System.in);
        System.out.print("input:");
        String name = input.next();

        //一个经典方法: 定义一个计数工具    * * * * * * * * * * * * * * * * * * * * * * *
        int count = 0;
        for (String s : arr) {
            if (name.equals(s)) {
                System.out.println("Find name:" + s);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Cannot find name");
        }
    }
}


