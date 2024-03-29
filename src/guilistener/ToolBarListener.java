package guilistener;

import guipanel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: hutubill
 * @description: 监听器类
 * @author: youzhou
 * @create: 2019-10-31 20:21
 **/
public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MainPanel p = MainPanel.instance;
        JButton b = (JButton) actionEvent.getSource();
        if (b == p.bReport)
            p.workingPanel.show(ReportPanel.instance);
        if (b == p.bCategory)
            p.workingPanel.show(CategoryPanel.instance);
        if (b == p.bSpend)
            p.workingPanel.show(SpendPanel.instance);
        if (b == p.bRecord)
            p.workingPanel.show(RecordPanel.instance);
        if (b == p.bSpendDetail)
            p.workingPanel.show(SpendDetailPanel.instance);
        if (b == p.bConfig)
            p.workingPanel.show(ConfigPanel.instance);
        if (b == p.bBackup)
            p.workingPanel.show(BackupPanel.instance);
        if (b == p.bRecover)
            p.workingPanel.show(RecoverPanel.instance);
    }
}
