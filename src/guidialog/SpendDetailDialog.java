package guidialog;

import entity.Category;
import entity.Record;
import guimodel.CategoryComboBoxModel;
import guipanel.SpendDetailPanel;
import org.jdesktop.swingx.JXDatePicker;
import service.CategoryService;
import service.RecordService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: hutubill
 * @description: 消费记录编辑框
 * @author: youzhou
 * @create: 2019-11-05 16:43
 **/
public class SpendDetailDialog extends JDialog {

    public JLabel lSpend = new JLabel("花费¥");
    public JLabel lCategory = new JLabel("分类");
    public JLabel lComment = new JLabel("备注");
    public JLabel lDate = new JLabel("日期");

    public JTextField tfSpend = new JTextField("");
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());

    public JButton bEdit = new JButton("提交");
    SpendDetailPanel spendDetailPanel = SpendDetailPanel.instance;

    public CategoryComboBoxModel ccbmRecord = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(ccbmRecord);

    public SpendDetailDialog(Record record) {
        this.setLayout(new BorderLayout());
        this.setSize(400, 600);
        this.setModal(true);
        this.setLocationRelativeTo(spendDetailPanel);
        tfSpend.setText(String.valueOf(record.getSpend()));
        ccbmRecord.c = (new CategoryService().getCategoryByRecord(record));
        cbCategory.updateUI();
        tfComment.setText(record.getComment());
        datepick.setDate(record.getDate());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd EEE");
        datepick.setFormats(formatter);
        this.add(center(), BorderLayout.CENTER);
        JPanel south = new JPanel();
        south.add(bEdit);
        GUIUtil.setColor(ColorUtil.blueColor, bEdit);
        this.add(south, BorderLayout.SOUTH);

        bEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (tfSpend.getText().length() == 0) {
                    JOptionPane.showMessageDialog(spendDetailPanel, "输入为空");
                    return;
                }
                if (!GUIUtil.checkZero(tfSpend, "花费金额")) {
                    return;
                }
                int index = spendDetailPanel.recordTable.getSelectedRow();
                int spend = Integer.parseInt(tfSpend.getText().trim());
                Category category = (Category) cbCategory.getSelectedItem();
                String comment = tfComment.getText().trim();
                Date date = datepick.getDate();
                int id = record.getId();
                Record newRecord = new Record(spend, id, category.getId(), comment, date);
                new RecordService().update(newRecord);
                JOptionPane.showMessageDialog(spendDetailPanel, "修改成功");
                setVisible(false);
                spendDetailPanel.updateData();
            }
        });
        this.pack();
    }

    public JPanel center() {
        JPanel p = new JPanel();
        int gap = 40;
        p.setLayout(new GridLayout(4, 2, gap, gap));
        p.add(lSpend);
        p.add(tfSpend);
        p.add(lCategory);
        p.add(cbCategory);
        p.add(lComment);
        p.add(tfComment);
        p.add(lDate);
        p.add(datepick);
        GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
        return p;
    }
}
