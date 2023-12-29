package Network;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTCPServer01 {
    public static void main(String[] args) throws Exception {

        //1.在本机的9999端口监听
        //  要求: 本机没有其他服务正在监听该端口
        //  细节: 这个ServerSocket可以通过accept()返回多个Socket [多个Client连接Server的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Wait at 9999~");

        //2.当没有客户端连接在9999端口时,程序会阻塞,等待连接
        //  如果有客户端连接,就会返回一个socket对象,程序继续
        Socket socket = serverSocket.accept();
        System.out.println("accept=" + socket.getClass());

        //3.通过socket.getInputStream 读取Client写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();


        //4. IO读取
        byte[] bytes = new byte[1024];
        int readLen;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLen));
        }


        //5.通过socket, 给Client发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, Client".getBytes());
        //设置一个结束标记!
        socket.shutdownOutput();


        //关闭Stream和socket和serverSocket
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
