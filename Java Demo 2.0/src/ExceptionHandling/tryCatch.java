package ExceptionHandling;
import java.util.Scanner;

//alt + ctrl + T 生成 tryCatch代码

/*
1.如果异常发生了,则try中异常发生后的代码不执行,直接进入catch块
2.如果没有异常,顺序执行try中代码,不进入catch
3.可以分支多个catch捕获多个异常, 但是子类异常要求写在前面,父类在后面

4.如果希望无论是否有异常,都执行一段代码,可以用finally,并且是最后执行的
5.可以直接try-finally, 相当于没有捕获异常,所以遇到异常会直接崩溃。   应用场景:无论有无异常,都必须执行某个业务逻辑
 */

class tryCatch {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入String:");
            String str = scanner.next();

            //alt + ctrl + T 快速生成代码
            try {
                int a = Integer.parseInt(str);
                System.out.println("Successful~");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Exception message = " + e.getMessage());
            } finally {
                System.out.println("Default executed finally~");
            }

            System.out.println("Out of try catch");
        }

    }
}
