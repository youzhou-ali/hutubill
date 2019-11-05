package guiframe;

import guipanel.MainPanel;

import javax.swing.*;

/**
 * @program: hutubill
 * @description: 面板容器
 * @author: youzhou
 * @create: 2019-10-30 20:49
 **/
public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    private MainFrame(){
        this.setSize(500,450);
        this.setTitle("有舟的糊涂账");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}
