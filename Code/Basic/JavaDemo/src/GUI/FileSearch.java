package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/6 22:11
 * @Version 1.0
 */

//实现文件搜索功能

public class FileSearch {
    public static void main(String[] args) {
        JFrame frame = new JFrame("文件搜索");
        JPanel panel = new JPanel();
        final JTextField field = new JTextField("请输入文件目录",15);
        JButton button = new JButton("搜索");
        final JTextArea area = new JTextArea(15,15);
        ScrollPane bar = new ScrollPane();

        //先把area添加到滚动条上
        bar.add(area);

        //组件添加到panel
        panel.add(field);
        panel.add(button);

        //给输入框添加鼠标点击事件
        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextField field = (JTextField) e.getSource();
                if ("请输入文件目录".equals(field.getText())){
                    field.setText("");
                }
            }
        });

        //给搜索按钮添加鼠标点击事件
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //清空area
                area.setText("");
                //获取输入路径
                String path = field.getText();

                //创建file对象
                File dir = new File(path);

                if (dir.exists()) {
                    //找到该目录下所有的子文件
                    File[] files = dir.listFiles();

                    //文件信息写入文本框
                    for (File file : files) {
                        area.setText(area.getText() + file.getName() + "\r\n");
                    }
                } else {
                    area.setText("路径不存在！");
                }

            }
        });

        frame.add(panel,BorderLayout.NORTH);
        frame.add(bar);
        FrameUtil.initFrame(frame,600,400);

    }
}
