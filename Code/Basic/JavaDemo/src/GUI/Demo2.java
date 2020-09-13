package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/5 0:44
 * @Version 1.0
 */

//文件对话框+面板
public class Demo2 {
    public static void main(String[] args) {
        //窗体
        JFrame jFrame = new JFrame("第一个窗体");
        FrameUtil.initFrame(jFrame,400,400);

        //文件对话框（载入）
        FileDialog fileDialog = new FileDialog(jFrame,"请选择打开的文件",FileDialog.LOAD);
        fileDialog.setVisible(true);
        System.out.println("文件目录：" + fileDialog.getDirectory());
        System.out.println("文件名称：" + fileDialog.getFile());

        //文件对话框（保存）
        FileDialog fileDialog1 = new FileDialog(jFrame,"请选择保存的路径",FileDialog.SAVE);
        fileDialog1.setVisible(true);
        System.out.println("文件目录：" + fileDialog1.getDirectory());
        System.out.println("文件名称：" + fileDialog1.getFile());

        //面板
        JPanel jPanel = new JPanel();
        //设置面板颜色
        jPanel.setBackground(Color.BLUE);
        //将面板添加到窗体
        jFrame.add(jPanel);
        FrameUtil.initFrame(jFrame,400,400);
    }
}
