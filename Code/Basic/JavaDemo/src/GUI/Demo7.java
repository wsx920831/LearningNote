package GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/6 21:48
 * @Version 1.0
 */

// 鼠标监听器

public class Demo7 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("窗体");
        JButton button = new JButton("哈哈哈哈");
        jFrame.add(button);

        //重写所有方法
//        button.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("点击");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println("按下");
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                System.out.println("松开");
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                System.out.println("进入");
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                System.out.println("移出");
//
//            }
//        });

        //重写其中一个方法
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("鼠标单击");
                if (e.getClickCount() == 2){
                    System.out.println("鼠标双击");
                }
            }
        });

        FrameUtil.initFrame(jFrame,600,400);
    }
}
