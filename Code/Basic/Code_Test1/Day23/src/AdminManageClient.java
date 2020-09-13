import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/3 1:47
 * @Version 1.0
 */
public class AdminManageClient {
    static Scanner scanner = new Scanner(System.in);
//    static Socket socket;
//
//    static {
//        try {
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("请输入功能选项：登录（L）| 注册（R）");
            String option = scanner.next();
            if ("R".equalsIgnoreCase(option)){
                manage(1);
            }else if("L".equalsIgnoreCase(option)){
                System.out.println("L");
                manage(2);
            }else{
                System.out.println("输入错误，请重新选择功能");
            }
        }
    }

    public static void manage(int flag) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("192.168.3.100"),9096);

        //获取信息
        System.out.println("请输入账号：");
        String id = scanner.next();
        System.out.println("请输入密码：");
        String pwd = scanner.next();
        String Info = "id=" + id + ";pwd=" + pwd + "\r\n";

        //将信息传入后台校验
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        if (flag == 1){
            bufferedWriter.write("flag=1;" + Info);
        }else{
            bufferedWriter.write("flag=2;" + Info);
        }

        bufferedWriter.flush();
        String backinfto = bufferedReader.readLine();
        System.out.println("backinfto = " + backinfto);
        if ("1".equals(backinfto)){
            if (flag == 1){
                System.out.println("注册成功！");
            }else{
                System.out.println("登录成功！");
            }
        }else{
            if (flag == 1){
                System.out.println("注册失败，账户已存在！");
            }else{
                System.out.println("登录失败，账号或密码有误！");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }

}
