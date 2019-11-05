package startup;

import guiframe.MainFrame;
import guipanel.MainPanel;
import guipanel.SpendPanel;
import util.GUIUtil;

import javax.swing.*;

/**
 * @program: hutubill
 * @description: 启动入口
 * @author: youzhou
 * @create: 2019-10-31 20:13
 **/
public class BootStart {
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();

        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}
