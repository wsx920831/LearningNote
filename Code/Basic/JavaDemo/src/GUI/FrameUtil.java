package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/5 0:29
 * @Version 1.0
 */
public class FrameUtil {

    public static void initFrame(JFrame jFrame, int width, int height){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //获取屏幕分辨率
        Dimension screenSize = toolkit.getScreenSize();
        int x = screenSize.width;
        int y = screenSize.height;
        jFrame.setBounds((x-width)/2,(y-height)/2,width,height); //设置位置及大小
        jFrame.setVisible(true); //设置窗体
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置关闭窗体事件
    }
}
