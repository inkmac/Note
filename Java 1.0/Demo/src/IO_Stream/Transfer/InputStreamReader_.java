package IO_Stream.Transfer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class InputStreamReader_ {
    public static void main(String[] args) throws Exception{
        String path = "c:/javaIO/Transfer.txt";
        //传入类型: InputStream + 编码
        InputStreamReader ISR = new InputStreamReader(new FileInputStream(path), "gbk");
        BufferedReader BR = new BufferedReader(ISR);

        BufferedReader BR1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));

        String a = BR.readLine();
        System.out.println(a);
        //关闭外层流
        BR.close();
    }
}
