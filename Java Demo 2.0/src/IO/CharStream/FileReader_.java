package IO.CharStream;
import java.io.*;

//CharStream: 适用于处理文本文件

public class FileReader_ {
    public static void main(String[] args) throws Exception{
        read01();
    }

    //每次读取一个char字符
    public static void read01() throws Exception {
        String filePath = "c:/javaIo/Hello.java";
        FileReader fileReader;
        int data;   //注意为int类型,这样才好接收 fileReader.read()

        fileReader = new FileReader(filePath);
        while ((data = fileReader.read()) != -1) {
            System.out.print((char) data);
        }

        fileReader.close();
    }



    public static void read02() throws Exception {
        String filePath = "c:/javaIo/Hello.java";
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];

        fileReader = new FileReader(filePath);
        while ((readLen = fileReader.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));
        }

        fileReader.close();

    }
}
