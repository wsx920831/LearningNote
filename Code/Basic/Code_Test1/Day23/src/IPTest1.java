import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/28 22:44
 * @Version 1.0
 */
public class IPTest1 {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机IP信息
        //创建本机IP对象(通过静态方法)
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("本机IP地址：" + localHost.getHostAddress());
        System.out.println("本机主机名：" + localHost.getHostName());

        //获取其他机器IP信息
        InetAddress allByName = InetAddress.getByName("192.168.3.201");
        System.out.println("他机IP地址：" + allByName.getHostAddress());
        System.out.println("他机主机名：" + allByName.getHostName());


    }
}
