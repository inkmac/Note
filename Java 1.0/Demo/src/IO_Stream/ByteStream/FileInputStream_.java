package IO_Stream.ByteStream;
import java.io.*;

//适用于处理二进制文件, 如图片,视频,音频等

public class FileInputStream_ {
    public static void main(String[] args) throws IOException {
        readFile01();
        readFile02();
    }

    //每次读取单个byte
    public static void readFile01() throws IOException {
        String filePath = "c:/JavaIO/hello.java";
        int readFile = 0;
        FileInputStream fileInputStream = null;

        fileInputStream = new FileInputStream(filePath);

        //读取完毕就返回-1
        while ((readFile = fileInputStream.read()) != -1) {
            System.out.print((char) readFile);
        }

        //关闭文件流,释放资源
        fileInputStream.close();
    }

    //使用byte[]读取, 更快
    public static void readFile02() throws IOException {
        String filePath = "c:/JavaIO/hello.java";
        int readLen = 0;
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[8];


        fileInputStream = new FileInputStream(filePath);

        while ((readLen = fileInputStream.read(buf)) != -1) {
            //确定读取范围readLen, 防止文件长度不足但仍读取buf长度, 文件溢出
            System.out.print(new String(buf,0,readLen));
        }


        //关闭文件流,释放资源
        fileInputStream.close();
    }
}
