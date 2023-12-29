package IO_Stream.ObjectStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;


public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception{
        //序列化后,保存的文件格式为dat
        String path = "c:/JavaIO/ObjectStream.dat";
        //可以传入的参数类型: OutputStream
        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(path));

//        OOS.write(100);   //不能直接write, 不会执行对象的序列化操作, 只是单纯写入

        OOS.writeInt(100);    //会自动装箱
        OOS.writeBoolean(true);
        OOS.writeChar('a');
        OOS.writeDouble(10.1);
        OOS.writeUTF("hello");

        //保存一个dog对象
        OOS.writeObject(new Dog("BOB"));
        OOS.close();

    }
}


//如果需要序列化某个类的对象, 必须实现serializable接口
class Dog implements Serializable {
    String name;

    //serialVersionUID 序列化的版本号, 提高兼容性
    @Serial
    private static final long serialVersionUID = 1L;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

}
