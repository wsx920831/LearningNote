package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * @Author 王嗣鑫
 * @Date 2020/9/5 0:50
 * @Version 1.0
 */

//非容器组件

public class Demo3 {
    public static void main(String[] args) {
        //窗体
        JFrame jFrame = new JFrame("第一个窗体");

        //面板
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

//        //滚动条
//        ScrollPane scrollPane = new ScrollPane();
//        jFrame.add(scrollPane);



        //标签
        JLabel jLabel = new JLabel("用户名：");
        //输入框
        JTextField jTextField = new JTextField(12);
        jPanel.add(jLabel);
        jPanel.add(jTextField);

        //密码框
        JLabel jLabel1 = new JLabel("密码");
        JPasswordField jPasswordField = new JPasswordField(12);
        jPanel.add(jLabel1);
        jPanel.add(jPasswordField);

        //单选框
        JLabel jLabel2 = new JLabel("性别");
        JRadioButton man = new JRadioButton("男",true);
        JRadioButton woman = new JRadioButton("女");
        ButtonGroup buttonGroup = new ButtonGroup(); //通过分组保证只能选一个
        buttonGroup.add(man);
        buttonGroup.add(woman);
        jPanel.add(jLabel2);
        jPanel.add(man);
        jPanel.add(woman);

        //下拉列表
        JLabel cityname = new JLabel("城市");
        Object[] city = {"北京","上海","广州","深圳"};
        JComboBox jComboBox = new JComboBox(city);
        jPanel.add(cityname);
        jPanel.add(jComboBox);

        //复选框
        JLabel honname = new JLabel("兴趣爱好");
        JCheckBox jCheckBox1 = new JCheckBox("旅游",true);
        JCheckBox jCheckBox2 = new JCheckBox("读书");
        JCheckBox jCheckBox3 = new JCheckBox("编程");
        JCheckBox jCheckBox4 = new JCheckBox("工作");
        jPanel.add(honname);
        jPanel.add(jCheckBox1);
        jPanel.add(jCheckBox2);
        jPanel.add(jCheckBox3);
        jPanel.add(jCheckBox4);

        //文本框+滚动条
        JLabel txtname = new JLabel("个人简介");
        JTextArea jTextArea = new JTextArea(20,15);
        jTextArea.setLineWrap(true); //自动换行
        jPanel.add(txtname);
        jPanel.add(jTextArea);

        FrameUtil.initFrame(jFrame,600,600);





    }
}
