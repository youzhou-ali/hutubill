package guilistener;

import guipanel.SpendDetailPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: hutubill
 * @description: 消费记录面板点选按钮监听器
 * @author: youzhou
 * @create: 2019-11-04 22:33
 **/
public class SpendDetailCheckListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        SpendDetailPanel p = SpendDetailPanel.instance;
        JCheckBox c = (JCheckBox) actionEvent.getSource();
        if (c == p.checkAllCategory) {
            if (p.checkAllCategory.isSelected()) {
                p.categoryJComboBox.setEnabled(false);
            } else {
                p.categoryJComboBox.setEnabled(true);
            }
        }

        if (c == p.searchAll) {
            if (p.searchAll.isSelected()) {
                p.checkAllCategory.setEnabled(false);
                p.categoryJComboBox.setEnabled(false);
                p.dateStart.setEnabled(false);
                p.dateEnd.setEnabled(false);
                p.bSearch.setEnabled(false);
            } else {
                p.checkAllCategory.setEnabled(true);
                p.dateStart.setEnabled(true);
                p.dateEnd.setEnabled(true);
                p.bSearch.setEnabled(true);
            }
        }
        p.updateData();
    }
}
