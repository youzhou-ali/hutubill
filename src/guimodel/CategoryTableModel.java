package guimodel;

import entity.Category;
import service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: hutubill
 * @description: 消费分类次数模型
 * @author: youzhou
 * @create: 2019-10-30 17:26
 **/
public class CategoryTableModel implements TableModel {
    private String[] columnNames = new String[]{"分类名称","消费次数"};

    // 使用从Service返回的List作为TableModel的数据
    public List<Category> cs = new CategoryService().list();

    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    // 先通过cs.get(rowIndex)获取行对应的Category对象
    // 然后根据columnIndex返回对应的属性
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(0==columnIndex)
            return cs.get(rowIndex);
        if(1==columnIndex)
            return 0;
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
