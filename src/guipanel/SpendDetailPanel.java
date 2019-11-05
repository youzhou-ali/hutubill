package guipanel;

import entity.Category;
import entity.Record;
import guilistener.SpendDetailCheckListener;
import guilistener.SpendDetailListener;
import guimodel.CategoryComboBoxModel;
import guimodel.SpendDetailTableModel;
import org.jdesktop.swingx.JXDatePicker;
import service.RecordService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: hutubill
 * @description: 消费记录面板
 * @author: youzhou
 * @create: 2019-11-03 21:59
 **/
public class SpendDetailPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static SpendDetailPanel instance = new SpendDetailPanel();

    private JLabel lERDate = new JLabel("日期");
    private JLabel lEPSpe = new JLabel("-");

    public CategoryComboBoxModel categoryComboBoxModelb = new CategoryComboBoxModel();
    public JComboBox<Category> categoryJComboBox = new JComboBox<>(categoryComboBoxModelb);

    public JXDatePicker dateStart = new JXDatePicker(new Date());
    public JXDatePicker dateEnd = new JXDatePicker(new Date());

    public JButton bSearch = new JButton("查询");
    public JCheckBox checkAllCategory = new JCheckBox("全部分类");

    public SpendDetailTableModel spendDetailTableModel = new SpendDetailTableModel();
    public JTable recordTable = new JTable(spendDetailTableModel);

    public JCheckBox searchAll = new JCheckBox("查询全部");
    public JButton bEdit = new JButton("修改");
    public JButton bDelete = new JButton("删除");

    public SpendDetailPanel() {
        setLayout(new BorderLayout());
        add(north(), BorderLayout.NORTH);
        add(center(), BorderLayout.CENTER);
        add(south(), BorderLayout.SOUTH);
        addListener();
    }

    private JPanel north() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
//        p.add(lERCategory);
        p.add(categoryJComboBox);
        categoryJComboBox.setEnabled(false);
        p.add(checkAllCategory);
        checkAllCategory.setSelected(true);
        p.add(lERDate);
        p.add(dateStart);
        p.add(lEPSpe);
        p.add(dateEnd);
        p.add(bSearch);
        GUIUtil.setColor(ColorUtil.grayColor, lERDate, lEPSpe);
        GUIUtil.setColor(ColorUtil.blueColor, bSearch);
//        GUIUtil.setFontSize(1,14,lERSearchWay,lERCategory,lERDate);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
        dateStart.setFormats(formatter);
        dateEnd.setFormats(formatter);
        return p;
    }

    private JScrollPane center() {
        return new JScrollPane(recordTable);
    }

    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(searchAll);
        p.add(bEdit);
        p.add(bDelete);
        GUIUtil.setColor(ColorUtil.blueColor, bDelete, bEdit, searchAll);
        return p;
    }

    @Override
    public void updateData() {
        List<Record> selectedDataRecords = new RecordService().listDate2Date(dateStart.getDate(), dateEnd.getDate());
        if (checkAllCategory.isSelected())
            spendDetailTableModel.recordArrayList = selectedDataRecords;
        else
            spendDetailTableModel.recordArrayList = new RecordService().getRecordsByCategory(selectedDataRecords, (Category) categoryJComboBox.getSelectedItem());

        if (searchAll.isSelected())
            spendDetailTableModel.recordArrayList = new RecordService().listAll();
        recordTable.updateUI();
    }

    @Override
    public void addListener() {
        SpendDetailListener spendDetailListener = new SpendDetailListener();
        SpendDetailCheckListener spendDetailCheckListener = new SpendDetailCheckListener();
        checkAllCategory.addActionListener(spendDetailCheckListener);
        bSearch.addActionListener(spendDetailListener);
        searchAll.addActionListener(spendDetailCheckListener);
        bEdit.addActionListener(spendDetailListener);
        bDelete.addActionListener(spendDetailListener);
    }

    public Record getSelectedRecord() {
        int index = recordTable.getSelectedRow();
        return spendDetailTableModel.recordArrayList.get(index);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(SpendDetailPanel.instance);
    }
}
