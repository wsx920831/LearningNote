import java.io.*;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/26 23:45
 * @Version 1.0
 */

/*输入字节流转为字符流*/

public class InputStreamReader1 {
    public static void main(String[] args) throws IOException {
        writeTest1();
        readTest2();

    }

    //输入字节流转为字符流
    public static void readTest1() throws IOException {
        InputStream in = System.in; //字节流
        InputStreamReader inputStreamReader = new InputStreamReader(in); //转为字符流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //转为缓冲字符流
        String content = null;
        while ((content = bufferedReader.readLine()) != null){
            System.out.println("输入内容：" + content);
        }
    }

    //输出字节流转为字符流
    public static void writeTest1() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("..\\aa.txt"),true); //字节流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk"); //转为字符流,指定编码格式
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter); //转为缓冲字符流
        bufferedWriter.write("你好");
        bufferedWriter.newLine();
        bufferedWriter.write("我好");
        bufferedWriter.newLine();
        bufferedWriter.write("大家好");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public static void readTest2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("..\\aa.txt"); //字节流
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"gbk"); //转为字符流,指定编码格式
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //转为缓冲字符流
        String content = null;
        while ((content = bufferedReader.readLine()) != null){
            System.out.println(content);
        }
    }
}
