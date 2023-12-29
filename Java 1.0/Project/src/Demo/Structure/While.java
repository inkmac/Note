package Demo.Structure;


//统计1-200之间能被5整除但不能被3整除的整数
// {if, switch用于判断 ; while, for用于循环迭代}  ******************
class while01 {
    public static void main(String[] args) {
//        int i = 1;                                         //错误示范
//        while (i <= 100 && (i % 5 == 0 && i % 3 != 0)) {
//            System.out.println(i);
//            i++;
//        }

        int i = 1;
        while (i <= 200) {
            if (i % 5 == 0 && i % 3 != 0) {
                System.out.println("i=" + i);
            }i++;
        }
        System.out.println(i);
    }
}



//有100,000元, >50000时每次付5%, <50000时每次付1000, 一共能过多少个路口。
// {全部为while时,可以直接用while (true), 然后再用多分支判断}      [P148]
class while02 {
    public static void main(String[] args) {
        double money = 100000;
        int count = 0;

        while (money > 50000) {
            money -= money * 0.05;
            count++;
        }
        while(money < 50000) {
            money -= 1000;
            count++;
            if (money < 1000) {
                System.out.println("余额不足" + money);
                break;
            }
        }
        System.out.println("过了" + count +"个路口");
    }
}
