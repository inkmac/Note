package Demo.Structure;

import java.util.Scanner;

//定义一个数，看是否能被三或五整除
//[出错]  {!!!注意:区分赋值和比较运算符 = 和 == 的区别！！！}
class if01 {
    public static void main(String[] args) {
        Scanner a1Scanner = new Scanner(System.in);
        System.out.println("input number:");
        int a1 = a1Scanner.nextInt();

        if (a1 % 3 == 0 | a1 % 5 == 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");;
        }
    }
}


//[错误] {加深对=和==的理解}
class if02{
    public static void main(String[] args) {
        boolean a = false;
        if (a == true) {                        // 2
            System.out.println("1");
        }else {
            System.out.println("2");
        }
        System.out.println("-----------------");

        boolean b = false;
        if (a = true) {
            System.out.println("1");             // 1
        }else{
            System.out.println("2");
        }
    }
}


//判断一年是否是闰年,条件为符合二者之一 ①能被4整除，但不能被100整除  ②能被400整除
//[复习]  {可以将多条件整合}
class if03 {
    public static void main(String[] args) {
        Scanner yearScanner = new Scanner(System.in);
        System.out.println("input year:");
        int year = yearScanner.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}


//对信用分（1-100）进行一个判断
//{如何判断: ①嵌套检测[不推荐]  ②多分支)
class if04{
    public static void main(String[] args) {
        Scanner gradeScanner = new Scanner(System.in);
        System.out.println("input your grade:");
        int grade = gradeScanner.nextInt();

        if (grade == 100) {                             //方法一 [推荐]
            System.out.println("Good");
        } else if (grade >= 60  && grade < 100 ) {
            System.out.println("Not too bad");
        } else if (grade >= 0 && grade < 60) {
            System.out.println("Bad");
        }else {
            System.out.println("Wrong,input again");
        }

        System.out.println("-------------------------------------------");

        if (grade <= 100 && grade > 0) {                //方法二 [不推荐]
            if (grade == 100) {
                System.out.println("Good");
            } else if (grade >= 60) {
                System.out.println("Not too bad");
            } else {
                System.out.println("Bad");
            }
        } else {
            System.out.println("Wrong,input again");
        }

    }
}
