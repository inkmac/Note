package Network;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;


public class SocketTCPClient01 {
    public static void main(String[] args) throws Exception {

        //1.连接Server(IP, 端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("Client = " + socket.getClass());

        //2.连接上后,生成Socket,通过socket.getOutPutStream()
        OutputStream outputStream = socket.getOutputStream();

        //3.通过输出流, 写入数据到 数据通道
        outputStream.write("Hello Server".getBytes());
        //设置一个结束标记!! 不然阻塞
        socket.shutdownOutput();

        //4.获取socket关联的输入流, 读取数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }

        //关闭Stream和Socket, 必须关闭!!!
        outputStream.close();
        inputStream.close();
        socket.close();

    }
}
