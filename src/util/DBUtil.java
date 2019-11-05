package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: hutubill
 * @description: 数据库连接工具类
 * @author: youzhou
 * @create: 2019-10-30 21:15
 **/
public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "hutubill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }
}
