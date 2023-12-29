package Useless;

import java.util.Scanner;

//判断年龄是否大于18岁
class easy_if01 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("输入年龄");
        int age = myScanner.nextInt();

        if (age > 18) {
            System.out.println("Yes");
        }
        else{
            System.out.println("NO");
        }
    }
}


//判断第一个数字大于10.0，且第二个数小于20.0，打印两数之和；否则不作处理
class easy_if02{
    public static void main(String[] args) {
        Scanner a1Scanner = new Scanner(System.in);
        System.out.println("input number1:");
        double a1 = a1Scanner.nextDouble();
        Scanner a2Scanner = new Scanner(System.in);
        System.out.println("input number2:");
        double a2 = a2Scanner.nextDouble();

        if (a1 > 10.0 && a2 < 20.0) {
            System.out.println("sum = " + (a1 + a2));
        }
        else {
            System.out.println("not up to the standard");
        }
    }
}


//写一个程序，可以接收一个字符，eg：a,b,c, a代表星期一，b代表星期二,根据输入显示相应的信息
class easy_switch01{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入一个字符(a-c)");
        String data = input.next();

        switch(data) {
            case "a" :
                System.out.println("Monday");
                break;
            case "b" :
                System.out.println("Tuesday");
                break;
            case "c" :
                System.out.println("Wednesday");
                break;
            default :
                System.out.println("Wrong,out of range,input again");
        }
    }
}


//用switch将小写的字母转化为大写的，仅转换a,b, 其他的输出other
class easy_switch02{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input an letter:");
        String letter = input.next();
        switch (letter) {
            case "a" :
                System.out.println('A');
                break;
            case "b" :
                System.out.println('B');
                break;
            default :
                System.out.println("other");
        }
    }
}


//1-100内的数求和,当和大于20时打印当前的数
class easy_break15 {
    public static void main(String[] args) {
        int sum = 0 ;
        for (int i = 1 ; 1 <= 100 ; i++) {              //注意此时i的作用域范围
            sum += i;
            if (sum > 20) {
                System.out.print("sum > 20;  ");
                System.out.println("now i=" + i);
                break;
            }
        }
    }
}


//可变参数的使用
class easy_MethodVar {
    public String showScore(String name,double... scores) {
        double total = 0;
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }
        return name + ": TotalScore=" + total;
    }
}
class easy_ObjectVar07{
    public static void main(String[] args) {
        easy_MethodVar a = new easy_MethodVar();
        String information = a.showScore("Bob", 100, 99, 100);
        System.out.println(information);
    }
}


//登录验证, 名字为"Bob", 有三次机会, 输入”666“提示密码输入正确
// {String类型的比较用equals方法, 而不是 ==}
class easy_break01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1 ; i < 4 ; i++) {
            System.out.print("input your name:");
            String name = input.next();
            System.out.print("input your password:");
            String password = input.next();
            if ( "666".equals(password) && "Bob".equals(name) ) {
                System.out.println("Right");
                break;
            }
//            if ((3 - i) == 0) {
//                System.out.println("You failed");
//                break;
//            }
            System.out.println("Wrong, left chance: " + (3 - i));

        }
    }
}


//输出a-z以及Z-A
//知道char类型本质是数字型, 可以与int相互转换以及运算
class easy_for01{
    public static void main(String[] args) {
        for (char a = 'a' ; a <= 'z' ; a++) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (char b = 'Z' ; b >= 'A' ; b--) {
            System.out.print(b + " ");
        }
    }
}


//打印矩形字符 水平, 竖直, 字符
class Method02{
    public void print02(int m, int n, String i) {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
class Object02 {
    public static void main(String[] args) {
        Method02 a = new Method02();
        a.print02(5,3,"*");
    }
}