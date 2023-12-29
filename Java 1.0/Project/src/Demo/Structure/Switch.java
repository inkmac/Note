package Demo.Structure;
import java.util.Scanner;


//学生成绩>=60的输入合格, <60的输入不合格(要求switch完成)
//{可以先算数运算, 然后再来判断}
class switch01{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input score:");
        double score = input.nextDouble();

        if (score >= 0 && score <=100) {
            switch ((int)(score / 60)) {
                case 1 :
                    System.out.println("Qualified");
                    break;
                case 0 :
                    System.out.println("Unqualified");
                    break;
            }
        }else {
            System.out.println("Wrong,input again");
        }
    }
}



//输入1-10之间的数, 1-3属于small, 3-6属于big
// {case后面可以不带语句，与下面条件合并,利用switch的穿透性}
class switch02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input your number:");
        int number = input.nextInt();

        switch (number) {
            case 1 :
            case 2 :
            case 3 :
                System.out.println("small");
                break;
            case 4 :
            case 5 :
            case 6 :
                System.out.println("big");
                break;
            default:
                System.out.println("Wrong,input again");
        }
    }
}
