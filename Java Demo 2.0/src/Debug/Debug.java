package Debug;

//断点调试(Debug): 从该行开始, 代码一步一步执行

//F7: 跳入方法内部
//alt+shift+F7: 强制进入方法(进入JDK源码)
//F8: 逐步执行
//shift + F8: 跳出方法
//F9: Resume, 立即跳到下一个断点

public class Debug {
    public static void main(String[] args) {
        int sum = 0;
        for (int j = 0; j < 5; j++) {
            System.out.print("j=" + j + "\t");
        }

        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("i=" + i);
            System.out.println("sum=" + sum);
        }
        System.out.println("结束程序");
    }
}
