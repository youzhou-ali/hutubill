package guimodel;

import entity.Record;
import org.w3c.dom.views.AbstractView;
import service.RecordService;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: hutubill
 * @description: 消费记录详情模型
 * @author: youzhou
 * @create: 2019-11-03 22:20
 **/
public class SpendDetailTableModel implements TableModel {

    String[] columNames = new String[]{"分类", "金额", "备注", "日期"};

    public List<Record> recordArrayList;

    public SpendDetailTableModel() {
        recordArrayList = new RecordService().listToday();
    }


    @Override
    public int getRowCount() {
        return recordArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return columNames[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record c = recordArrayList.get(rowIndex);
        if (0 == columnIndex)
            return new RecordService().getCategoryName(c);
        if (1 == columnIndex)
            return c.getSpend();
        if (2 == columnIndex)
            return c.getComment();
        if (3 == columnIndex)
            return c.getDate();
        return null;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {

    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }
}
