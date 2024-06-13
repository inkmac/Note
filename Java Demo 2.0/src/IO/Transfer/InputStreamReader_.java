package IO.Transfer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


// InputStreamWriter 用于将字节流转换成字符流
public class InputStreamReader_ {
    public static void main(String[] args) throws Exception {
        String path = "C:/javaIO/Transfer.txt";
        //传入参数: InputStream, 编码
        InputStreamReader ISR = new InputStreamReader(new FileInputStream(path), "gbk");
        BufferedReader BR = new BufferedReader(ISR);

        BufferedReader BR1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));

        String a = BR.readLine();
        System.out.println(a);
        //关闭外层流
        BR.close();
    }
}
