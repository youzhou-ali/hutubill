package guilistener;

import entity.Record;
import guidialog.SpendDetailDialog;
import guipanel.SpendDetailPanel;
import service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @program: hutubill
 * @description: 消费记录面板监听器
 * @author: youzhou
 * @create: 2019-11-04 22:08
 **/
public class SpendDetailListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        SpendDetailPanel p = SpendDetailPanel.instance;
        JButton b = (JButton) actionEvent.getSource();
        if (b == p.bSearch) {
            if (p.dateEnd.getDate().getTime() < p.dateStart.getDate().getTime()){
                JOptionPane.showMessageDialog(p,"起止日期不合法");
                p.dateStart.setDate(new Date());
                return;
            }
        }

        if (b == p.bEdit){
            Record record = p.getSelectedRecord();
            SpendDetailDialog spendDetailDialog = new SpendDetailDialog(record);
            spendDetailDialog.setVisible(true);
        }

        if(b==p.bDelete){
            if(JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(p,"确认删除?"))
                return;
            new RecordService().delete(p.getSelectedRecord());
        }

        p.updateData();
    }
}
