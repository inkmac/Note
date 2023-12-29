import java.util.Scanner;
//常量: 不会变的的量    eg: 10/3; final int m = 10
//变量: 值会变的量      eg: int m = 10


class Variety01 {
    public static void main(String[] args) {
        //char short byte的计算(可以相互转换), 但是计算结果默认int类型
        char a = 'e';            //此时的e对应编码表是101 所以计算时的e就等于101
        char d = 'a' + 1;
        long c = 100L;
        System.out.println(d);
        System.out.println(a + d);
        //byte -> short -> int -> long -> float -> double
        //char -> int -> long -> float -> double
        //能且仅能从前往后(系统默认), 从后往前需要强制类型转换, 其中并不包含String类型


        //同时定义多个变量
        int m = 10, n = 19;
    }
}



class Variety02 {
    public static void main(String[] args) {
        //强制类型转换,仅会转换最近的一个，若想转换整个，需用()括起来
        short s = 10;
        s = (short) (s - 9);
        //若为s -= 9的话效果相同, 该方法javac会自动帮你弄成short类型, 即会自动进行类型转换
        //但若为s = s - 9则会报错 int --x-> short
        System.out.println(s);


        //强制类型转换的精度损失, 直接舍去小数点后面(即溢出)的数
        int x = (int) 2.5;
        int y = (int) -2.5;
        System.out.println("x=" + x);
        System.out.println("y=" + y);

    }
}


class Variety03 {
    public static void main(String[] args) {
        //int -> String,尾部加上 + ""即可 ----> 详情见Wrapper类
        int a1 = 10;
        long b1 = 31L;
        String a2 = a1 + "";
        String b2 = b1 + "";
        System.out.println(a1 + b1);
        System.out.println(a2 + b2 + " " + "\n");
        // + " "表示空一个位
        // + "\n"表示换新的一行
    }
}


class Variety04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);  //开启一个录入键盘的入口(System.in)

        System.out.print("int类型:");              //在控制台中输出 "int类型:" 这段文字
        int classInt = scanner.nextInt();         //执行到这句话时, 程序会停下来等待用户输入, 并将输入赋给classInt这个变量

        System.out.print("double类型:");
        double classDouble = scanner.nextDouble();

        System.out.print("String类型:");
        String classString = scanner.next();

        System.out.print("Char类型:");
        char classChar = scanner.next().charAt(0);     //从字符串中提取一个位置的字符

        // 使用完毕后,如果不再需要,可以关闭 scanner 来释放空间
        scanner.close();
    }
}


//使用XXX.length()获得字符串长度