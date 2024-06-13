package IO.ByteStream;
import java.io.FileOutputStream;


public class FileOutputStream_ {
    public static void main(String[] args) throws Exception{
        writeFile();
    }

    public static void writeFile() throws Exception{
        FileOutputStream FOS = null;
        String filePath = "C:/JavaIO/new1.txt";

        //new FileOutputStream(filePath) 是覆盖原文件
        //new FileOutputStream(filePath, true) 是追加到原文件后面
        FOS = new FileOutputStream(filePath, true);
        FOS.write('a');     //输入单个字符
        FOS.write("Hello,World!".getBytes());   //输入一个字符串
        FOS.write("Hello,World!".getBytes(), 0, 5);  //输入一个指定头尾的字符串

        FOS.close();
    }
}
