package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/5 0:15
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {
        //窗体
        JFrame jFrame = new JFrame("第一个窗体");
        FrameUtil.initFrame(jFrame,400,400);

        //对话框1
//        JDialog jDialog = new JDialog(jFrame,"对话框",true);
//        jDialog.setBounds(500,300,100,200);
//        jDialog.setVisible(true);

        //对话框2
        //消息
        JOptionPane.showMessageDialog(jFrame,"明天下雨","通知",JOptionPane.INFORMATION_MESSAGE);

        //警告
        JOptionPane.showMessageDialog(jFrame,"迟到扣钱","警告",JOptionPane.WARNING_MESSAGE);

        //错误
        JOptionPane.showMessageDialog(jFrame,"路径不存在","错误",JOptionPane.ERROR_MESSAGE);

        //输入框
        String money = JOptionPane.showInputDialog("请输入金额：");
        System.out.println("money = " + money);

        //确认框
        int n = JOptionPane.showConfirmDialog(jFrame,"确认是否要删除文件？");
        System.out.println("n = " + n);



    }

    //初始化窗体

}
