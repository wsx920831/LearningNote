import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/3 1:10
 * @Version 1.0
 */
public class ImgClient{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.3.100"),9095);

        //创建输入流对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());

        //创建输出流对象
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("download.png"));

        int len = 0;
        while ((len = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(len);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
    }
}