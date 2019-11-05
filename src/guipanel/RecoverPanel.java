package guipanel;

import guilistener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

/**
 * @program: hutubill
 * @description: 备份面板
 * @author: youzhou
 * @create: 2019-10-30 20:47
 **/
public class RecoverPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover = new JButton("恢复");

    public RecoverPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
    }
}
