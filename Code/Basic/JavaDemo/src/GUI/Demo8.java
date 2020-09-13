package GUI;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/6 21:59
 * @Version 1.0
 */

//键盘事件监听器

public class Demo8 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("窗体");
        JButton button = new JButton("哈哈哈哈");
        jFrame.add(button);
//        button.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                System.out.println("键入");
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                System.out.println("按下");
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                System.out.println("释放");
//
//            }
//        });

        //重写其中一个方式
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                switch (code){
                    case 38:
                        System.out.println("上");
                        break;
                    case 40:
                        System.out.println("下");
                        break;
                    case 37:
                        System.out.println("左");
                        break;
                    case 39:
                        System.out.println("右");
                        break;
                    default:
                        break;
                }
            }
        });

        FrameUtil.initFrame(jFrame,600,400);
    }
}
