package Network;

import java.net.InetAddress;


public class InetAddress_ {
    public static void main(String[] args) throws Exception {

        //获取本机的 InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //根据指定的主机名, 获取InetAddress对象
        InetAddress byName = InetAddress.getByName("LAPTOP-CTF6KUOU");//要加""
        System.out.println(byName);

        //根据域名, 返回对应的InetAddress对象
        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println(byName1);

        //通过 InetAddress对象, 获取对应的IP地址
        String hostAddress = byName.getHostAddress();
        System.out.println(hostAddress);

        //通过 InetAddress对象, 获取对应的域名/主机名
        String hostName = byName.getHostName();
        System.out.println(hostName);
    }
}
