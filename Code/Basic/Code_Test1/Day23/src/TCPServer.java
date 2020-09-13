import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/1 0:37
 * @Version 1.0
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //********************数据接收********************//
        //创建TCP服务端服务
        ServerSocket serverSocket = new ServerSocket(9092);

        //调用accept()方法，返回Socket对象
        Socket socket = serverSocket.accept();

        //创建输入流对象（接收客户端发送的数据）
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));

        //创建输入流对象（接收键盘输入的数据）
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));

        //创建输出流对象（向客户端发送数据）
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));

        String content = null;
        while ((content = bufferedReader.readLine()) != null){
            //读取数据
            System.out.println(content);

            //回复数据
            content = bufferedReader1.readLine();
            bufferedWriter.write("服务端：" + content + "\r\n");
            bufferedWriter.flush();
        }
        serverSocket.close();

    }
}
