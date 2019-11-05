package guilistener;

import entity.Category;
import guipanel.CategoryPanel;
import guipanel.MainPanel;
import guipanel.RecordPanel;
import guipanel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @program: hutubill
 * @description: 记一笔监听器
 * @author: youzhou
 * @create: 2019-11-03 11:28
 **/
public class RecordLstener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        RecordPanel p = RecordPanel.instance;
        if (0 == p.cbModel.cs.size()) {
            JOptionPane.showMessageDialog(p, "暂无消费分类，无法添加，请先增加消费分类");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }

        if (!GUIUtil.checkZero(p.tfSpend, "花费金额"))
            return;
        int spend = Integer.parseInt(p.tfSpend.getText());
        Category c = p.getSelectedCategory();
        String comment = p.tfComment.getText();
        Date d = p.datePicker.getDate();
        new RecordService().add(spend, c, comment, d);
        JOptionPane.showMessageDialog(p, "添加成功");

        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}
