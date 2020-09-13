import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/2 23:23
 * @Version 1.0
 */
public class TomcatTest extends Thread{
    Socket socket;

    static HashSet<String> hashSet = new HashSet<String>(); //存储IP

    public TomcatTest(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //获取输入字节流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\王嗣鑫\\Desktop\\JAVA\\Code_Test1\\冒泡排序.png"));

            //1.获取输出字节流
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());

            //数据读取及发送
            int content = 0;
            while ((content = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(content);
            }
//            bufferedWriter.write("<html><head><title>aaa</title></head><body>你好啊浏览器</body></html>");
            //统计下载人数
            String ip = socket.getInetAddress().getHostAddress();
            if (hashSet.add(ip)){
                System.out.println("恭喜" + ip + "下载成功！" + "当前下载人数：" + hashSet.size());
            }

            bufferedInputStream.close();
            bufferedOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        //创建TCP服务端服务
        ServerSocket serverSocket = new ServerSocket(9095);
        //不断接接收客户端链接
        while (true){
            Socket socket = serverSocket.accept();
            new TomcatTest(socket).start(); //启动数据发送线程
//            Thread.sleep(2000);
        }


    }
}
