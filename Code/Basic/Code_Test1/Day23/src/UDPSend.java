import java.io.IOException;
import java.net.*;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/29 0:19
 * @Version 1.0
 */
public class UDPSend {
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            //创建DatagramSocket对象
            DatagramSocket datagramSocket = new DatagramSocket();

            //数据打包
            String s = "UDP哈哈哈";
            DatagramPacket datagramPacket = new DatagramPacket(s.getBytes("utf-8"), s.getBytes().length, InetAddress.getByName("192.168.3.201"), 9000);

            //数据发送
            datagramSocket.send(datagramPacket);

            //资源关闭
            datagramSocket.close();

            Thread.sleep(1000);

        }
    }
}
