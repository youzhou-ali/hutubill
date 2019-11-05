package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: hutubill
 * @description: 消费记录业务类
 * @author: youzhou
 * @create: 2019-11-03 11:04
 **/
public class RecordService {
    private RecordDAO recordDAO = new RecordDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    /**
     * @Description: 添加消费记录
     * @Param:
     * @return:
     * @Author: youzhou
     * @Date: 2019/11/3
     * @Time: 11:08
     */
    public void add(int spend, Category category, String comment, Date date) {
        Record record = new Record();
        record.setSpend(spend);
        record.setCid(category.getId());
        record.setComment(comment);
        record.setDate(date);
        recordDAO.add(record);
    }

    /**
    * @Description: 返回今天的消费记录
    * @Param:
    * @return:
    * @Author: youzhou
    * @Date: 2019/11/5
    * @Time: 16:13
    */
    public List<Record> listToday() {
        return recordDAO.listToday();
    }

    /**
    * @Description: 返回一段时间的消费记录
    * @Param:
    * @return:
    * @Author: youzhou
    * @Date: 2019/11/5
    * @Time: 16:13
    */
    public List<Record> listDate2Date(Date start, Date end) {
        return recordDAO.list(start, end);
    }

    /**
    * @Description: 返回所有消费记录
    * @Param:
    * @return:
    * @Author: youzhou
    * @Date: 2019/11/5
    * @Time: 16:26
    */
    public List<Record> listAll() {
        return recordDAO.list();
    }

    /**
    * @Description: 返回一种分类下的所有消费记录
    * @Param:
    * @return:
    * @Author: youzhou
    * @Date: 2019/11/5
    * @Time: 16:14
    */
    public List<Record> getRecordsByCategory(List<Record> records, Category category) {
        List<Record> records1 = new ArrayList<>();
        for (Record record : records) {
            if (record.getCid() == category.getId())
                records.add(record);
        }
        return records1;

    }

    /**
    * @Description: 根据分类号返回分类名
    * @Param:
    * @return:
    * @Author: youzhou
    * @Date: 2019/11/5
    * @Time: 16:14
    */
    public String getCategoryName(Record cid) {
        Category c = categoryDAO.get(cid.getCid());
        return c.getName();
    }

    public void update(Record record){
        recordDAO.update(record);
    }
    public void delete(Record record) {
        recordDAO.delete(record.getId());
    }
}
