package entity;

/**
 * @program: hutubill
 * @description: 配置信息类
 * @author: youzhou
 * @create: 2019-10-30 20:59
 **/
public class Config {

    private int id;
    private String key;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
