package test;

import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @program: hutubill
 * @description: 测试柱状图
 * @author: youzhou
 * @create: 2019-10-29 22:01
 **/
public class ChartTest {
    public static void main(String[] args){
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        Image img = ChartUtil.getImage(400,300);
        Icon icon = new ImageIcon(img);
        l.setIcon(icon);
        p.add(l);
        GUIUtil.showPanel(p);
    }
}
