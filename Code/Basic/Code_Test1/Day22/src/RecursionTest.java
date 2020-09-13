import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/26 22:57
 * @Version 1.0
 */
public class RecursionTest {
    public static void main(String[] args) throws IOException {
//        showTree(new File("..\\一级文件夹"),"|--");
//        delFile(new File("..\\一级文件夹"));
        cutFile(new File("..\\一级文件夹"),new File("..\\一级文件夹拷贝"));

    }
    //打印文件目录树
    public static void showTree(File f, String s){
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()){
                System.out.println(s + file.getName());
            }else if (file.isDirectory()){
                System.out.println(s + file.getName());
                showTree(file,"|  " + s);
            }
        }
    }
    //删除文件夹
    public static void delFile(File f){
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()){ //是文件直接删除
                file.delete();
            }else if (file.isDirectory()){ //是文件夹递归调用
                delFile(file);
            }
        }
        f.delete(); //此时文件夹已经是空的，直接删除
    }

    //剪切一个文件下所有文件
    public static void cutFile(File source, File dest) throws IOException {
        File[] files = source.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                //dest本来是文件夹，需要增减文件名，转为文件
                File dest1 = new File(dest.getPath() + "\\" + file.getName());
                Boolean flag = file.renameTo(dest1);
                System.out.println(flag);

            }else if (file.isDirectory()){
                //增加下一级目录
                File file1 = new File(source.getPath() + "\\" + file.getName());
                File file2 = new File(dest.getPath() + "\\" + file.getName());
                System.out.println("file2.getPath() = " + file2.getPath());
                file2.mkdir(); //创建目录
                cutFile(file1,file2);
            }
        }
        source.delete(); //删除已经剪切完的空文件夹
    }
}
