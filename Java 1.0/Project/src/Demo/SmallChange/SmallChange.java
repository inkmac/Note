package Demo.SmallChange;

import java.util.Scanner;

public class SmallChange {
    public static void main(String[] args) {
        boolean select = true;
        double balance = 0;
        String detail = "";
        Scanner scanner = new Scanner(System.in);

        while (select) {
            System.out.println("========零钱通菜单========");
            System.out.println("     1.零钱通明细");
            System.out.println("     2.收益入账");
            System.out.println("     3.消费");
            System.out.println("     4.退出");
            System.out.print("请选择(1-4):");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=====零钱通明细=====");
                    System.out.println("当前剩余余额:" + balance);
                    System.out.println(detail);
                    break;

                case 2:
                    System.out.println("=====收益入账=====");
                    System.out.print("收益入账:");
                    double income = scanner.nextDouble();
                    //编程思想
                    //用单个if将不符合的条件一一排除
                    if (income <= 0) {
                        System.out.println("income输入有误, 重新输入~");
                        break;
                    }
                    balance += income;
                    detail += "收益入账: " + income + "\n";
                    break;

                case 3:
                    System.out.println("=====消费=====");
                    System.out.print("消费支出:");
                    double expense = scanner.nextDouble();

                    if (expense <= 0 || expense > balance) {
                        System.out.println("expense输入有误, 重新输入~");
                        break;
                    }
                    balance -= expense;
                    detail += "消费支出:" + expense + "\n";
                    break;

                case 4:
                    System.out.println("确定要退出吗 yes/no?");
                    String result = scanner.next();
                    if (result.equals("yes")) {
                        select = false;
                        System.out.println("已退出~");
                    }
                    break;

                default:
                    System.out.println("输入有误, 重新输入~");
            }
        }
    }
}
