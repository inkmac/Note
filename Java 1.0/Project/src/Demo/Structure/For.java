package Demo.Structure;

import java.util.Scanner;

//写出所有a + b = n 的式子, n由玩家输入
//先得到a, 再得到b = n - a
class for01{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input n:");
        int n = input.nextInt();

        for (int a = 0 ; a <= n ; a ++) {
            System.out.println(a + "+" + (n - a) + "=" +n );
        }
    }
}


//输出1~100不能被5整除的数, 每5个一组为一行
//化繁为简: ①先输出1~100不能5整除的数: 循环, ②判断每5个一行: if
class for02{
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1 ; i <= 100 ; i++){
            if (i % 5 != 0){
                System.out.print(i + "\t");
                count++;
                if (count == 5) {                 //检测每5个为一组
                    System.out.println();
                    count = 0;
                }
            }
        }
    }
}


//输出1- 1/2 + 1/3 - 1/4 + ...1/100
// 遇到 小数/除法* 一定要用double变量和小数
class for03 {
    public static void main(String[] args) {
        double sum = 0;
        for (double i = 1 ; i <= 100 ; i++) {       //用double接收
            if (i % 2 == 0) {
                sum -= 1.0/i;                       //用小数做除法
            }else {
                sum += 1.0/i;
            }
        }
        System.out.println("sum=" + sum);
    }
}


//求1 + (1+2) + (1+2+3) + (1+2+3+4+...+100)
class for04{
    public static void main(String[] args) {
        int sum = 0;
        int count = 1;
        for (int a = 1 ; a <=100 ; a++) {
            for (int b = 1 ; b <= count ; b++) {
                sum += b;
            }
            count++;
        }
        System.out.println("sum=" + sum);
    }
}