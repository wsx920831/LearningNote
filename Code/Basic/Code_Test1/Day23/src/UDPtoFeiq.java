import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/29 2:04
 * @Version 1.0
 */

//每个网络程序都有自己所处理的特定格式数据,如果接收到的数据不符合指定的格式，那么就会被当成垃圾数据丢弃。(加密..)

//飞Q接收的数据格式：
//version:time :sender : ip: flag:content ;
//版本号 时间  发送人  :IP： 发送的标识符(32): 真正的内容;
//
//在udp协议中，有一个IP地址称作为广播地址，广播地址就是主机号为255地址。
//给广播IP地址发送消息的时候，在同一个网络段的机器都可以接收 到信息。
//192.168.15.255

//使用udp协议给飞Q发送消息。

public class UDPtoFeiq {
    public static void main(String[] args) throws InterruptedException, IOException {
        while (true) {

            //创建DatagramSocket对象
            DatagramSocket datagramSocket = new DatagramSocket();

            //数据打包
            String s = getData("FeiQ_哈哈");
            System.out.println(s);
            DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(), s.getBytes().length, InetAddress.getByName("192.168.3.255"), 2425);

            //数据发送
            datagramSocket.send(datagramPacket);

            //资源关闭
            datagramSocket.close();

            Thread.sleep(1000);

        }
    }
    public static String getData(String s){
        StringBuilder content = new StringBuilder();
        content.append("1.0:");
        content.append(System.currentTimeMillis() + ":");
        content.append("wsx:");
        content.append("192.168.3.100:");
        content.append("32:");
        content.append(s);
        return content.toString();
    }
}
