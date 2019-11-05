package guimodel;

import entity.Category;
import service.CategoryService;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: hutubill
 * @description: 消费分类模型
 * @author: youzhou
 * @create: 2019-10-30 16:56
 **/
public class CategoryComboBoxModel implements ComboBoxModel<Category> {
    public List<Category> cs = new CategoryService().list();

    public Category c;

    public CategoryComboBoxModel() {
        if (!cs.isEmpty())
            c = cs.get(0);
    }

    @Override
    public void setSelectedItem(Object o) {
        c = (Category) o;
    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Category getElementAt(int i) {
        return cs.get(i);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {

    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {

    }
}
