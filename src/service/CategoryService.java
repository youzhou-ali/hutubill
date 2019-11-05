package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.Collections;
import java.util.List;

/**
 * @program: hutubill
 * @description: 消费分类业务
 * @author: youzhou
 * @create: 2019-10-31 21:19
 **/
public class CategoryService {
    private CategoryDAO categoryDao = new CategoryDAO();
    private RecordDAO recordDao = new RecordDAO();

    public List<Category> list() {
        List<Category> cs= categoryDao.list();
        for (Category c : cs) {
            List<Record> rs =recordDao.list(c.getId());
            c.setRecordNumbers(rs.size());
        }
        Collections.sort(cs,(c1, c2)->c2.getRecordNumbers()-c1.getRecordNumbers());

        return cs;
    }

    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }

    public void update(int id, String name) {
        Category c = new Category();
        c.setName(name);
        c.setId(id);
        categoryDao.update(c);
    }

    public void delete(int id) {
        categoryDao.delete(id);
    }

    public Category getCategoryByRecord(Record record){
        return categoryDao.get(record.getCid());
    }
}
