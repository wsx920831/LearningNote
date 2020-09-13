import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/3 2:09
 * @Version 1.0
 */
public class AdminManageServer extends Thread{
    Socket socket;
    File filepath;

    public AdminManageServer(Socket socket, File filepath) {
        this.socket = socket;
        this.filepath = filepath;
    }

    @Override
    public void run() {
        try {
            BufferedReader readDB = new BufferedReader(new FileReader(filepath));
            BufferedWriter writeDB = new BufferedWriter(new FileWriter(filepath,true));
            BufferedReader readClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writeClient = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String InfoClient = readClient.readLine();
            String id = InfoClient.split(";")[1].split("=")[1];  //ID
            String pwd = InfoClient.split(";")[2].split("=")[1];  //PWD

            String flag = InfoClient.split(";")[0].split("=")[1]; //FLAG

            System.out.println("id=" + id + " | pwd=" + pwd + " | flag=" + flag);
            String content = null;
            boolean isRegister = true; //默认可以注册
            boolean isLogin = false; //默认不可以登录

            while ((content = readDB.readLine()) != null) {
                String idDB = content.split(";")[0].split("=")[1];  //ID
                String pwdDB = content.split(";")[1].split("=")[1];  //PWD
                System.out.println("idDB=" + idDB + " | pwdDB=" + pwdDB);
                if ("1".equals(flag)){
                    if (content.indexOf(id) != -1) {
                        isRegister = false;
                        break;
                    }
                }else{
                    if (id.equals(idDB) && pwd.equals(pwdDB)){
                        isLogin = true;
                        break;
                    }
                }
            }
            if ("2".equals(flag)){
                isRegister = isLogin;
            }
            System.out.println("isRegister = " + isRegister);
            if (!isRegister) { //不可以注册
                //向客户端发送不能注册的信息
                writeClient.write("0" + "\r\n");
                writeClient.flush();
            } else { //可以注册
                System.out.println("2");
                //向客户端发送可以注册的信息
                writeClient.write("1" + "\r\n");
                writeClient.flush();

                if ("1".equals(flag)){
                    //信息写入数据库
                    writeDB.newLine();
                    writeDB.write("id=" + id + ";" + "pwd=" + pwd);
                    writeDB.flush();
                }

            }
            writeClient.close();
            readClient.close();
            writeDB.close();
            readDB.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9096);
        //读取数据库
        File filepath = new File("账户信息.txt");
        if (!filepath.exists()){//文件不存在
            filepath.createNewFile();
        }

        int count = 0;
        while (true) {
            Socket socket = serverSocket.accept();
            new AdminManageServer(socket,filepath).start();
        }
    }
}
