package IO.PrintStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintStream_ {
    public static void main(String[] args) throws Exception{

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("hello, world");
        printWriter.close();

        PrintWriter PW1 = new PrintWriter(new FileWriter("c:/javaIo/PrintWriter.txt"));
        PW1.println("Hello, JJJeb");
        PW1.println("Hello, World~~");
        PW1.close();    //如果不关闭, 或者flush, 将无法写入!!!!
    }
}
