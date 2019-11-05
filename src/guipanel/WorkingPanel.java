package guipanel;

import javax.swing.*;

/**
 * @program: hutubill
 * @description: 面板抽象类
 * @author: youzhou
 * @create: 2019-11-02 21:27
 **/
public abstract class WorkingPanel extends JPanel {
    public abstract void updateData();
    public abstract void addListener();
}
