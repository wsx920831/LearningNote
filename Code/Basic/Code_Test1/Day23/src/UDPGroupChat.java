import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/30 0:40
 * @Version 1.0
 */

/*使用UDP实现群聊功能*/

class ChatSend extends Thread{
    @Override
    public void run() {
        try {
            //创建UDP服务
            DatagramSocket datagramSocket = new DatagramSocket();

            //通过缓冲输入字符流获取数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //缓冲输入字符流 System.in可以连续输入
            String content = null;

            //数据打包及发送
            while ((content = bufferedReader.readLine()) != null){
                DatagramPacket datagramPacket = new DatagramPacket(content.getBytes("utf-8"), content.getBytes().length, InetAddress.getByName("192.168.3.255"), 9000);
                datagramSocket.send(datagramPacket);
            }
            datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class ChatRecive extends Thread{
    @Override
    public void run() {
        try {
            //创建UDP服务
            DatagramSocket datagramSocket = new DatagramSocket(9000);

            //创建空数据包用于接收数据
            byte[] buf = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
            int count = 0;

            //接收数据
            while (true) {
                datagramSocket.receive(datagramPacket);
                System.out.println(datagramPacket.getAddress().getHostAddress() + ": " + new String(buf,0,datagramPacket.getLength(),"utf-8"));
                count ++;
                if (count == 100){
                    break;
                }
            }
            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
public class UDPGroupChat {
    public static void main(String[] args) {
        ChatSend chatSend = new ChatSend();
        chatSend.start();

        ChatRecive chatRecive = new ChatRecive();
        chatRecive.start();

    }
}
