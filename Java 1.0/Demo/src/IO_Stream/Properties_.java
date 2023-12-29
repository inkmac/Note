package IO_Stream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
load  加载指定配置文件
list  显示k-v到指定位置
store  存储文件,如果不存储文件就不会更新
getProperty  获取k所对应的v
setProperty  设置k-v, 如果不存在k,就创建
中文默认用Unicode编码保存
 */

class Properties01 {
    public static void main(String[] args) throws Exception{

        Properties properties = new Properties();
        properties.load(new FileReader("c:/JavaIO/Property01.txt"));
        properties.list(System.out);

        String Jeb = properties.getProperty("Jeb");
        System.out.println("Jeb=" + Jeb);

    }
}


class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("user", "steve");
        properties.setProperty("pwd", "31415");
        //如果不保存, 就无法存储
        properties.store(new FileWriter("c:/JavaIO/Property02.txt"), "hello,world");

        System.out.println("File Save Successfully~");
    }
}