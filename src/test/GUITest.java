package test;

import util.GUIUtil;

import javax.swing.*;

/**
 * @program: hutubill
 * @description: 测试GUI
 * @author: youzhou
 * @create: 2019-10-29 17:23
 **/
public class GUITest {
    public static void main(String[] args) {
        GUIUtil.useLNF();
        JPanel p = new JPanel();
        p.add(new JButton("按钮1"));
        p.add(new JButton("按钮2"));
        GUIUtil.showPanel(p);
    }
}
