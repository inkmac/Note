package IO.Transfer;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

// OutputStreamWriter 用于将字节流转换成字符流
public class OutputStreamWriter_ {
    public static void main(String[] args) throws Exception{
        String filePath = "C:/javaIO/Transfer.txt";
        // 参数: (字节流对象, 编码格式)
        OutputStreamWriter OSW = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");

        OSW.write("Hello, 老韩");
        OSW.close();
    }
}
