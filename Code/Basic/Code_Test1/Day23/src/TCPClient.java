import com.sun.deploy.net.socket.UnixSocketImpl;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/1 0:30
 * @Version 1.0
 */
public class TCPClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        //建立TCP客户端服务
        Socket socket = new Socket(InetAddress.getByName("192.168.3.201"),9092);

        //创建缓冲输入字符流对象（获取键盘数据）
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //创建缓冲输出字符流（将数据写出）
        //socket.getOutputStream()返回OutputStream，然后通过OutputStreamWriter（输出转换流）转为字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));

        //创建缓冲输入字符流对象（接收客户端发送的数据）
        //socket.getInputStream()返回InputStream，然后通过InputStreamReader（输入转换流）转为字符流
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String content = null;
        while ((content = bufferedReader.readLine()) != null){
            //*******************数据发送***************//
            bufferedWriter.write("客户端：" + content + "\r\n"); //不加/r/n服务器的readline不能读一整行
            bufferedWriter.flush(); //不刷新没法写出去，服务端不能及时收到

            //*******************数据接收*******************//
            content = bufferedReader1.readLine();
            System.out.println(content);
        }
        //关闭资源

        socket.close();
    }
}
