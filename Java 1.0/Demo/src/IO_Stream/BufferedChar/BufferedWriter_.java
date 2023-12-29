package IO_Stream.BufferedChar;
import java.io.*;


public class BufferedWriter_ {
    public static void main(String[] args) throws Exception{

        String path = "c:/JavaIO/BufferedWriter.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true)); //追加

        bufferedWriter.write("Hello,World");
        bufferedWriter.newLine();       //插入一个换行符
        bufferedWriter.write("Hello,World2");

        bufferedWriter.close();
    }
}
