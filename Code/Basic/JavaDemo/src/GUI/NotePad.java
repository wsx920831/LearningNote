package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.Buffer;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/6 22:58
 * @Version 1.0
 */
public class NotePad {
    static JFrame frame = new JFrame("记事本");

    public static void main(String[] args) {
        //菜单条
        final JMenuBar bar = new JMenuBar();

        //文件菜单
        JMenu file = new JMenu("文件");
        JMenu edit= new JMenu("编辑");

        //菜单项
        JMenuItem open = new JMenuItem("打开");
        JMenuItem save = new JMenuItem("保存");
        JMenuItem copy = new JMenuItem("复制");
        JMenuItem paste = new JMenuItem("粘贴");

        //文本框
        final JTextArea area = new JTextArea(20,30);

        //添加保存事件
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //文件对话框（载入）
                    FileDialog fileDialog = new FileDialog(frame,"请选择文件保存路径",FileDialog.SAVE);
                    fileDialog.setVisible(true);
                    String path = fileDialog.getDirectory();
                    String fileName = fileDialog.getFile();

                    //输出文件信息
                    BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path,fileName)));
                    String content = area.getText();
                    System.out.println(content);
                    writer.write(content);
                    writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //文件对话框（载入）
                    FileDialog fileDialog = new FileDialog(frame, "请选择文件读取路径", FileDialog.LOAD);
                    fileDialog.setVisible(true);
                    String path = fileDialog.getDirectory();
                    String fileName = fileDialog.getFile();

                    BufferedReader reader = new BufferedReader(new FileReader(new File(path,fileName)));
                    String content = null;
                    while ((content = reader.readLine()) != null){
                        System.out.println("content = " + content);
                        area.setText(area.getText() + content + "\r\n");
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


            }
        });


        //滚动条
        ScrollPane scrollPane = new ScrollPane();

        //把area添加到滚动条上
        scrollPane.add(area);

        //菜单选项加到文件菜单
        file.add(open); file.add(save);
        edit.add(copy); edit.add(paste);

        //文件菜单添加到菜单条
        bar.add(file); bar.add(edit);

        //滚动条、菜单条添加到窗体
        frame.add(bar,BorderLayout.NORTH);
        frame.add(scrollPane);
        FrameUtil.initFrame(frame,600,400);



    }
}
