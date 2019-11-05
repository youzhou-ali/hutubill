package guipanel;

import guilistener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

/**
 * @program: hutubill
 * @description: 备份面板
 * @author: youzhou
 * @create: 2019-10-30 20:45
 **/
public class BackupPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();
    JButton bBackup =new JButton("备份");

    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        BackupListener listener = new BackupListener();
        bBackup.addActionListener(listener);
    }
}
