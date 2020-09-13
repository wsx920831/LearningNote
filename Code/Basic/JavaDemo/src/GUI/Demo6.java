package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/6 21:28
 * @Version 1.0
 */

//动作监听器

public class Demo6 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("窗体");
        JButton button = new JButton("哈哈哈哈");
        jFrame.add(button);

        //给按钮添加动作监听器（对鼠标点击和空格键起作用）
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if ("哈哈哈哈".equals(button.getText())){
                    button.setText("黑黑黑黑");
                }else{
                    button.setText("哈哈哈哈");
                }
            }
        });
        FrameUtil.initFrame(jFrame, 600,400);
    }
}
