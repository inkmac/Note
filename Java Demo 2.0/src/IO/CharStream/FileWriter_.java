package IO.CharStream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) throws IOException {
        writer();
    }

    // 注意: 最后必须close或者flush, 否则会无法写入
    public static void writer() throws IOException {
        String filePath = "c:/JavaIO/noteFileWriter.txt";
        FileWriter fileWriter = null;

        fileWriter = new FileWriter(filePath, true);    //选择是追加而不是覆盖

        fileWriter.write('H');
        fileWriter.write(new char[]{'a', 'b', 'c'});
        fileWriter.write("Hello,World!".toCharArray(), 0, 5);
        fileWriter.write("Hello,World!");
        fileWriter.write("Hello,World!", 0, 5);

        fileWriter.close();     //必须要close或者flush, 否则无法写入

    }
}

