package IO_Stream;
import java.io.File;
import java.io.IOException;

//要求路径存在,否则会抛出一个 IOException, 可以与mkdirs配合使用
public class FileCreate {
    public static void main(String[] args) {
        create01();
        create02();
        create03();
    }

    //new File(String pathname)
    public static void create01() {
        String filepath = "c:/new1.txt";
        File file = new File(filepath);

        try {
            file.createNewFile();
            System.out.println("Way1 Create successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // new File(File parent, String Child)
    public static void create02() {
        File parentFile = new File("c:/newFile");
        String name = "new2.txt";
        File file = new File(parentFile, name);

        try {
            file.createNewFile();
            System.out.println("Way2 create successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //new File(String parent, String child)
    public static void create03() {
        String parentPath = "c:/newFile";
        String filePath = "new3.txt";
        File file = new File(parentPath, filePath);

        try {
            file.createNewFile();
            System.out.println("Way3 create successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
