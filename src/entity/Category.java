package entity;

/**
 * @program: hutubill
 * @description: 消费分类
 * @author: youzhou
 * @create: 2019-10-30 21:03
 **/
public class Category {
    private int id;
    private String name;
    private int recordNumbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecordNumbers() {
        return recordNumbers;
    }

    public void setRecordNumbers(int recordNumbers) {
        this.recordNumbers = recordNumbers;
    }

    public String toString(){
        return name;
    }
}
