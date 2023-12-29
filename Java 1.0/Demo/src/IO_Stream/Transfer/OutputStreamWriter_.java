package IO_Stream.Transfer;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class OutputStreamWriter_ {
    public static void main(String[] args) throws Exception{
        String filePath = "c:/javaIO/Transfer.txt";
        OutputStreamWriter OSW = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");

        OSW.write("Hello, 老韩");
        OSW.close();
    }
}
