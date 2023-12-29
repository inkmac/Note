package IO_Stream.ObjectStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
1.读取(反序列化)的顺序, 需要和保存(序列化)顺序一致, 否则报错
2.要求序列化的对象必须实现Serializable接口, 其中属性类型也必须实现Serializable接口
3.class中建议添加serialVersionUID, 提高兼容性
4.序列化的时候并不会保存static和transient类型的成员
5.如果父类实现Serializable接口, 则子类也默认实现了序列化
 */

public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String path = "c:/JavaIO/ObjectStream.dat";
        //可以传入的参数类型: InputStream
        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path));

        System.out.println(OIS.readInt());
        System.out.println(OIS.readBoolean());
        System.out.println(OIS.readChar());
        System.out.println(OIS.readDouble());
        System.out.println(OIS.readUTF());


        //必须访问的是同一个包下面的Object, 可以import + public来访问同一个, 否则会throw Exception
        Object dog = OIS.readObject();
        System.out.println("Runtime class = " + dog.getClass());
        System.out.println(dog);

        Dog dog1 = (Dog) dog;
        System.out.println("Dog name = " + dog1.getName());

        OIS.close();
    }
}
