package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/5 21:08
 * @Version 1.0
 */

//菜单

public class Demo4 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("记事本");

        //菜单条
        JMenuBar bar = new JMenuBar();

        //文件菜单
        JMenu file= new JMenu("文件");
        JMenu edit = new JMenu("编辑");
        JMenu change = new JMenu("切换工作目录");

        //菜单项
        JMenuItem open = new JMenuItem("打开");
        JMenuItem close = new JMenuItem("关闭");
        JMenuItem copy = new JMenuItem("复制");
        JMenuItem paste = new JMenuItem("复制");
        JMenuItem jMenuItem1 = new JMenuItem("上");
        JMenuItem jMenuItem2 = new JMenuItem("下");
        JMenuItem jMenuItem3 = new JMenuItem("左");
        JMenuItem jMenuItem4 = new JMenuItem("有");

        //文本框
        JTextArea text = new JTextArea(20,30);

        //菜单添加菜单项
        file.add(open); file.add(close);
        edit.add(copy); edit.add(paste);

        //复选菜单
        change.add(jMenuItem1);
        change.add(jMenuItem2);
        change.add(jMenuItem3);
        change.add(jMenuItem4);
        file.add(change);

        //菜单条添加菜单
        bar.add(file);
        bar.add(edit);

        //添加菜单条
        jFrame.add(bar, BorderLayout.NORTH);
        jFrame.add(text);
        FrameUtil.initFrame(jFrame,500,500);
    }

}
