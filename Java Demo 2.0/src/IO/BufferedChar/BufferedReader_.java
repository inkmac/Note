package IO.BufferedChar;
import java.io.*;

//适用于处理文本文件, 是FileReader的高级版

public class BufferedReader_ {
    public static void main(String[] args) throws Exception {

        String path = "D:\\JAVA\\Coding\\Arithmetic.java";
        BufferedReader bufferReader = new BufferedReader(new FileReader(path));

        String line;  //按行读取, 但是不换行, 需要人为换行
        while ((line = bufferReader.readLine()) != null)
            System.out.println(line);

        bufferReader.close();   //会自动关闭FileReader

    }
}
