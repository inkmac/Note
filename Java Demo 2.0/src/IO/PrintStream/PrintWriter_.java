package IO.PrintStream;
import java.io.IOException;
import java.io.PrintStream;


public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //默认情况下, PrintStream输出的位置为标准输出, 即显示器
        out.println("Hello, World");
        out.write("666 Jeb".getBytes());
        out.close();

        //将输出位置修改到 "c:/JavaIO/PrintStream.txt"
        System.setOut(new PrintStream("c:/JavaIO/PrintStream.txt"));
        System.out.println("hello, Jeb");


//        //将位置重新定义到 显示器
//        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
//        System.out.println("This will be printed on the console.");
    }
}
