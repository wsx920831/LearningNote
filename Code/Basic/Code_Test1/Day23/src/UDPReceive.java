import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/29 0:27
 * @Version 1.0
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        while (true) {
            //创建DatagramSocket对象，传入监听端口
            DatagramSocket datagramSocket = new DatagramSocket(9000);

            //创建空包，用于存储接到的数据
            byte[] buff = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);

            //数据接收
            datagramSocket.receive(datagramPacket);
            System.out.println("接到的数据：" + new String(buff,0,datagramPacket.getLength(),"utf-8"));

            datagramSocket.close();
        }
    }
}
