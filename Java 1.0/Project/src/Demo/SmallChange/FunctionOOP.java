package Demo.SmallChange;

import java.util.Scanner;

class FunctionOOP {
    boolean select = true;
    double balance = 0;
    String detail = "";
    Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        while (select) {
            System.out.println("========零钱通菜单(OOP)========");
            System.out.println("     1.零钱通明细");
            System.out.println("     2.收益入账");
            System.out.println("     3.消费");
            System.out.println("     4.退出");
            System.out.print("请选择(1-4):");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    this.detail();
                    break;

                case 2:
                    this.income();
                    break;

                case 3:
                    this.expense();
                    break;

                case 4:
                    this.quit();
                    break;

                default:
                    System.out.println("输入有误, 重新输入~");
            }
        }
    }


    public void detail() {
        System.out.println("=====零钱通明细=====");
        System.out.println("当前剩余余额:" + balance);
        System.out.println(detail);
    }

    public void income() {
        System.out.println("=====收益入账=====");
        System.out.print("收益入账:");
        double income = scanner.nextDouble();
        //编程思想
        //用单个if将不符合的条件一一排除
        if (income <= 0) {
            System.out.println("income输入有误, 重新输入~");
        }
        balance += income;
        detail += "收益入账: " + income + "\n";
    }

    public void expense() {
        System.out.println("=====消费=====");
        System.out.print("消费支出:");
        double expense = scanner.nextDouble();

        if (expense <= 0 || expense > balance) {
            System.out.println("expense输入有误, 重新输入~");
        }
        balance -= expense;
        detail += "消费支出:" + expense + "\n";
    }

    public void quit() {
        System.out.println("确定要退出吗 yes/no?");
        String result = scanner.next();
        if (result.equals("yes")) {
            select = false;
            System.out.println("已退出, 感谢使用OOP版本~");
        }
    }
}


