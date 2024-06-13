package IO;
import java.io.File;

@SuppressWarnings({"ALL"})
public class FileInformation {
    public static void main(String[] args) {
        File file = new File("c:/01_news/test100/test.txt");
        file.mkdirs();
    }

    public void info() {
        File file = new File("c:/01_news/test100/test.txt");

        file.getName();    //文件名字
        file.getAbsolutePath();     //绝对路径
        file.getParent();   //获取父类信息
        file.length();      //文件大小(以byte为单位)
        file.exists();     //是否存在
        file.isFile();      //是不是一个文件
        file.isDirectory();   //是不是一个目录

        file.delete();  //删除空目录或文件, 并返回一个boolean值
        file.mkdir();   //创建单级目录
        file.mkdirs();  //创建多级目录, 并返回一个boolean值
    }
}
