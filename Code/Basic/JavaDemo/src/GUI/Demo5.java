package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/5 21:28
 * @Version 1.0
 */

//布局管理器

public class Demo5 {

    public static void main(String[] args) {
//        border();
//        flow();
//        grid();
        card();
    }

    //边框布局管理器
    public static void border(){
        JFrame jFrame = new JFrame("边框布局管理器");

        //创建边框布局管理器
        BorderLayout borderLayout = new BorderLayout(2,4);

        //利用BorderLayout管理窗体
        jFrame.setLayout(borderLayout);

        //窗体增加按钮
        jFrame.add(new JButton("北"),BorderLayout.NORTH);
        jFrame.add(new JButton("南"),BorderLayout.SOUTH);
        jFrame.add(new JButton("东"),BorderLayout.EAST);
        jFrame.add(new JButton("西"),BorderLayout.WEST);
        jFrame.add(new JButton("中"),BorderLayout.CENTER);

        //初始化窗体
        FrameUtil.initFrame(jFrame,600,400);
    }

    //流式布局管理器
    public static void flow(){
        JFrame jFrame = new JFrame("流式布局管理器");
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        //创建流式布局管理器
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,2,10);

        //流式布局管理器管理面板
        jPanel.setLayout(flowLayout);

        jPanel.add(new JButton("按按按按按按按按按按按按按钮1"));
        jPanel.add(new JButton("按按按按按按按按按按按按按钮2"));
        jPanel.add(new JButton("按按按按按按按按按按按按按钮3"));
        jPanel.add(new JButton("按按按按按按按按按按按按按钮4"));

        //初始化窗体
        FrameUtil.initFrame(jFrame,600,500);
    }

    //网格布局管理器
    public static void grid(){
        JFrame frame = new JFrame("网格布局管理器");

        //创建网格布局管理器
        GridLayout gridLayout = new GridLayout(4,4,2,2);

        //窗体采用网格布局
        frame.setLayout(gridLayout);

        //添加按钮
        for (int i = 0; i < 10; i++) {
            frame.add(new JButton(i+""));
        }
        frame.add(new JButton("+"));
        frame.add(new JButton("-"));
        frame.add(new JButton("*"));
        frame.add(new JButton("/"));
        frame.add(new JButton("="));
        frame.add(new JButton("."));

        //初始化窗体
        FrameUtil.initFrame(frame,600,500);


    }

    //流式布局管理器
    public static void card(){
        JFrame jFrame = new JFrame("卡片布局管理器");
        final JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        //创建卡片布局管理器
        final CardLayout cardLayout = new CardLayout();

        //流式布局管理器管理面板
        jPanel.setLayout(cardLayout);

        JButton button = new JButton("按按按按按按按按按按按按按钮1");

        jPanel.add(button);
        jPanel.add(new JButton("按按按按按按按按按按按按按钮2"));
        jPanel.add(new JButton("按按按按按按按按按按按按按钮3"));
        jPanel.add(new JButton("按按按按按按按按按按按按按钮4"));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(jPanel);
            }
        });

        //初始化窗体
        FrameUtil.initFrame(jFrame,600,500);
    }
}
